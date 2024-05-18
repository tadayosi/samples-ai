///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.tensorflow:proto:1.15.0

import static java.lang.System.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;

import org.tensorflow.framework.*;

public class tensorproto {

    static final String pb1 = "data/mnist-12/test_data_set_0/input_0.pb";
    static final String pb2 = "data/mnist-12/test_data_set_0/output_0.pb";

    public static void main(String... args) throws Exception {
        for (var file : Arrays.asList(pb1, pb2))
            readProto(file);
    }

    static void readProto(String file) throws Exception {
        out.println("==================================================");
        out.println("[" + file + "]");
        var pb = ByteBuffer.wrap(Files.readAllBytes(Path.of(file)));
        var proto = TensorProto.parseFrom(pb);
        out.println("dtype = " + proto.getDtype());
        var data = proto.getScomplexValList();
        out.println("size = " + data.size());
        out.println(data);
    }
}
