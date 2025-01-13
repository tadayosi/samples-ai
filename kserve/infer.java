///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES inference/GrpcPredictV2.java
//SOURCES inference/GRPCInferenceServiceGrpc.java

//DEPS com.google.protobuf:protobuf-java:4.29.3
//DEPS com.google.protobuf:protobuf-java-util:4.29.3
//DEPS io.grpc:grpc-netty-shaded:1.68.1
//DEPS io.grpc:grpc-protobuf:1.68.1
//DEPS io.grpc:grpc-stub:1.68.1
//DEPS org.apache.tomcat:annotations-api:6.0.53

//DEPS net.sf.extjwnl:extjwnl:2.0.5
//DEPS net.sf.extjwnl:extjwnl-data-wn31:1.2

import static java.lang.System.out;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;

import com.google.protobuf.ByteString;

import inference.GRPCInferenceServiceGrpc;
import inference.GrpcPredictV2.InferTensorContents;
import inference.GrpcPredictV2.ModelInferRequest;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;

public class infer {

    static final String DATA_DIR = "data/objects";

    static String target = "localhost:8001";

    public static void main(String... args) throws IOException {
        var channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            var stub = GRPCInferenceServiceGrpc.newBlockingStub(channel);

            var image = Files.newInputStream(Path.of(DATA_DIR, "kitten.jpg"));
            var data = preprocess(image);
            var content = InferTensorContents.newBuilder()
                    .addAllFp32Contents(data);
            var input = ModelInferRequest.InferInputTensor.newBuilder()
                    .setName("data_0")
                    .setDatatype("FP32")
                    .addShape(3).addShape(224).addShape(224)
                    .setContents(content);
            var output = ModelInferRequest.InferRequestedOutputTensor.newBuilder()
                    .setName("fc6_1");
            var request = ModelInferRequest.newBuilder()
                    .setModelName("densenet_onnx")
                    .setModelVersion("1")
                    .addInputs(0, input)
                    .addOutputs(output)
                    .build();
            var response = stub.modelInfer(request);
            out.println(response.getOutputs(0));
            var rawOutput = response.getRawOutputContents(0);
            out.println(postprocess(rawOutput));
        } finally {
            channel.shutdown();
        }
    }

    static List<Float> preprocess(InputStream data) {
        try {
            var image = ImageIO.read(data);
            var resized = new BufferedImage(224, 224, BufferedImage.TYPE_INT_RGB);
            resized.getGraphics().drawImage(image, 0, 0, 224, 224, null);
            var floats = new ArrayList<Float>(3 * 224 * 224);
            for (var y = 0; y < 224; y++) {
                for (var x = 0; x < 224; x++) {
                    var rgb = resized.getRGB(x, y);
                    floats.add((rgb >> 16 & 0xFF) / 255.0f);
                    floats.add((rgb >> 8 & 0xFF) / 255.0f);
                    floats.add((rgb & 0xFF) / 255.0f);
                }
            }
            return floats;
        } catch (IOException e) {
            throw new RuntimeException("Error reading image", e);
        }
    }

    private static int postprocess(ByteString rawOutput) {
        var buffer = ByteBuffer.wrap(rawOutput.toByteArray());
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        var floats = new ArrayList<Float>(1000);
        while (buffer.remaining() >= 4) {
            floats.add(buffer.getFloat());
        }
        return argmax(floats);
    }

    static int argmax(List<Float> floats) {
        return IntStream.range(0, floats.size())
                .reduce((max, i) -> floats.get(max) > floats.get(i) ? max : i)
                .orElseThrow();
    }
}
