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
import java.nio.IntBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.imageio.ImageIO;

import com.google.protobuf.ByteString;

import inference.GRPCInferenceServiceGrpc;
import inference.GrpcPredictV2.InferTensorContents;
import inference.GrpcPredictV2.ModelInferRequest;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;

public class infer_simple {

    static final String DATA_DIR = "data";
    static final String OUT_DIR = "output/kserve";

    static String target = "localhost:8001";

    public static void main(String... args) throws IOException {
        var channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            var stub = GRPCInferenceServiceGrpc.newBlockingStub(channel);

            var ints0 = IntStream.range(1, 17).boxed().collect(Collectors.toList());
            var content0 = InferTensorContents.newBuilder().addAllIntContents(ints0);
            var input0 = ModelInferRequest.InferInputTensor.newBuilder()
                    .setName("INPUT0").setDatatype("INT32").addShape(1).addShape(16)
                    .setContents(content0);

            var ints1 = IntStream.range(0, 16).boxed().collect(Collectors.toList());
            var content1 = InferTensorContents.newBuilder().addAllIntContents(ints1);
            var input1 = ModelInferRequest.InferInputTensor.newBuilder()
                    .setName("INPUT1").setDatatype("INT32").addShape(1).addShape(16)
                    .setContents(content1);

            var output0 = ModelInferRequest.InferRequestedOutputTensor.newBuilder()
                    .setName("OUTPUT0");
            var output1 = ModelInferRequest.InferRequestedOutputTensor.newBuilder()
                    .setName("OUTPUT1");

            var request = ModelInferRequest.newBuilder()
                    .setModelName("simple").setModelVersion("1")
                    .addInputs(0, input0).addInputs(1, input1)
                    .addOutputs(0, output0).addOutputs(1, output1)
                    .build();

            var response = stub.modelInfer(request);
            out.println(response);
            // in0 + in1
            var out0 = toArray(response.getRawOutputContents(0));
            out.println(Arrays.toString(out0));
            // in0 - in1
            var out1 = toArray(response.getRawOutputContents(1));
            out.println(Arrays.toString(out1));
        } finally {
            channel.shutdown();
        }
    }

    static int[] toArray(ByteString content) {
        var buffer = content.asReadOnlyByteBuffer().order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        var array = new int[buffer.remaining()];
        buffer.get(array);
        return array;
    }
}
