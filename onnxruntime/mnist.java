///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS com.microsoft.onnxruntime:onnxruntime:1.17.3
//DEPS org.tensorflow:proto:1.15.0

import static java.lang.System.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;

import org.tensorflow.framework.*;
import ai.onnxruntime.*;

public class mnist {

    static final String model = "data/mnist-12/mnist-12.onnx";
    static final String input = "data/mnist-12/test_data_set_0/input_0.pb";

    public static void main(String... args) throws Exception {
        out.println("ONNX Runtime example using MNIST model");

        var env = OrtEnvironment.getEnvironment();
        var opts = new OrtSession.SessionOptions();
        try (var session = env.createSession(model, opts)) {
            out.println("==================================================");
            session.getInputInfo().values().stream().forEach(out::println);
            session.getOutputInfo().values().stream().forEach(out::println);
            out.println("==================================================");

            var data = input();
            var t1 = OnnxTensor.createTensor(env, data);
            var inputs = Map.of("Input3", t1);
            try (var results = session.run(inputs)) {
                out.println("Output:");
                out.println("--------------------");
                results.get("Plus214_Output_0").ifPresent(output -> {
                    try {
                        var outData = (float[][]) output.getValue();
                        var answer = 0;
                        for (int i = 0; i < outData[0].length; i++) {
                            var value = outData[0][i];
                            out.println(String.format("%s = %s", i, value));
                            if (value > outData[0][answer]) {
                                answer = i;
                            }
                        }
                        out.println("--------------------");
                        out.println("Answer => " + answer);
                    } catch (OrtException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    static float[][][][] input() throws Exception {
        var pb = ByteBuffer.wrap(Files.readAllBytes(Path.of(input)));
        var proto = TensorProto.parseFrom(pb);
        var data = proto.getScomplexValList();
        var ret = new float[1][1][28][28];
        for (int i = 0, x = 0; i < 28; i++) {
            for (int j = 0; j < 28; j++) {
                ret[0][0][i][j] = data.get(i * 28 + j);
            }
        }
        return ret;
    }
}
