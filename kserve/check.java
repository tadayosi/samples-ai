///usr/bin/env jbang "$0" "$@" ; exit $?

//SOURCES inference/GrpcPredictV2.java
//SOURCES inference/GRPCInferenceServiceGrpc.java

//DEPS com.google.protobuf:protobuf-java:4.29.3
//DEPS com.google.protobuf:protobuf-java-util:4.29.3
//DEPS io.grpc:grpc-netty-shaded:1.68.1
//DEPS io.grpc:grpc-protobuf:1.68.1
//DEPS io.grpc:grpc-stub:1.68.1
//DEPS org.apache.tomcat:annotations-api:6.0.53

import static java.lang.System.out;

import inference.GRPCInferenceServiceGrpc;
import inference.GrpcPredictV2.ModelMetadataRequest;
import inference.GrpcPredictV2.ServerLiveRequest;
import inference.GrpcPredictV2.ServerMetadataRequest;
import inference.GrpcPredictV2.ServerReadyRequest;
import io.grpc.Grpc;
import io.grpc.InsecureChannelCredentials;

public class check {

    static String target = "localhost:8001";

    public static void main(String... args) {
        var channel = Grpc.newChannelBuilder(target, InsecureChannelCredentials.create())
                .build();
        try {
            var stub = GRPCInferenceServiceGrpc.newBlockingStub(channel);
            var response1 = stub.serverReady(ServerReadyRequest.newBuilder().build());
            out.println(response1);
            var response2 = stub.serverLive(ServerLiveRequest.newBuilder().build());
            out.println(response2);
            var response3 = stub.serverMetadata(ServerMetadataRequest.newBuilder().build());
            out.println(response3);
            var response4 = stub.modelMetadata(ModelMetadataRequest.newBuilder().setName("simple").build());
            out.println(response4);
        } finally {
            channel.shutdown();
        }
    }
}
