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
//DEPS org.slf4j:slf4j-nop:1.7.36

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

/**
 * WIP: This code doesn't infer properly with DenseNet yet.
 */
public class infer_densenet {

    static final String DATA_DIR = "data";
    static final String OUT_DIR = "output/kserve";

    static String target = "localhost:8001";

    public static void main(String... args) throws IOException {
        var channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            var stub = GRPCInferenceServiceGrpc.newBlockingStub(channel);

            var image = Files.newInputStream(Path.of(DATA_DIR, "objects/kitten.jpg"));
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
            var result = postprocess(rawOutput);
            out.println(result);
            out.println(imageNetClass(result.index));
        } finally {
            channel.shutdown();
        }
    }

    static List<Float> preprocess(InputStream data) {
        try {
            var image = ImageIO.read(data);
            var resized = new BufferedImage(224, 224, BufferedImage.TYPE_INT_RGB);
            resized.getGraphics().drawImage(image, 0, 0, 224, 224, null);
            resized.getGraphics().dispose();

            saveTempImage(resized, "resized.jpg");

            // TODO: Input normalisation may not be correct
            var floats = new ArrayList<Float>(3 * 224 * 224);
            for (var y = 0; y < 224; y++) {
                for (var x = 0; x < 224; x++) {
                    var rgb = resized.getRGB(x, y);
                    var r = (rgb >> 16 & 0xFF) / 255.0f;
                    var g = (rgb >> 8 & 0xFF) / 255.0f;
                    var b = (rgb & 0xFF) / 255.0f;
                    floats.add((r - 0.485f) / 0.229f);
                    floats.add((g - 0.456f) / 0.224f);
                    floats.add((b - 0.406f) / 0.225f);
                }
            }
            return floats;
        } catch (IOException e) {
            throw new RuntimeException("Error reading image", e);
        }
    }

    static void saveTempImage(BufferedImage image, String name) throws IOException {
        Files.createDirectories(Path.of(OUT_DIR, "infer"));
        ImageIO.write(image, "jpg", Path.of(OUT_DIR, "infer", name).toFile());
    }

    private static infer_densenet.Result postprocess(ByteString rawOutput) {
        var buffer = ByteBuffer.wrap(rawOutput.toByteArray());
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        var floats = new ArrayList<Float>(1000);
        while (buffer.remaining() >= 4) {
            floats.add(buffer.getFloat());
        }
        var max = argmax(floats);
        return new Result(max, floats.get(max));
    }

    static int argmax(List<Float> floats) {
        return IntStream.range(0, floats.size())
                .reduce((max, i) -> floats.get(max) > floats.get(i) ? max : i)
                .orElseThrow();
    }

    static String imageNetClass(int index) throws IOException {
        var classes = Files.readAllLines(Path.of(DATA_DIR, "imagenet_classes.txt"));
        return classes.get(index);
    }

    record Result(int index, float value) {
    }
}
