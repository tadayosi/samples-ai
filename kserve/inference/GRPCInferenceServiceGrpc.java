package inference;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 * <pre>
 * Inference Server GRPC endpoints.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.68.1)",
    comments = "Source: kserve/grpc_predict_v2.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GRPCInferenceServiceGrpc {

  private GRPCInferenceServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "inference.GRPCInferenceService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<inference.GrpcPredictV2.ServerLiveRequest,
      inference.GrpcPredictV2.ServerLiveResponse> getServerLiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerLive",
      requestType = inference.GrpcPredictV2.ServerLiveRequest.class,
      responseType = inference.GrpcPredictV2.ServerLiveResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<inference.GrpcPredictV2.ServerLiveRequest,
      inference.GrpcPredictV2.ServerLiveResponse> getServerLiveMethod() {
    io.grpc.MethodDescriptor<inference.GrpcPredictV2.ServerLiveRequest, inference.GrpcPredictV2.ServerLiveResponse> getServerLiveMethod;
    if ((getServerLiveMethod = GRPCInferenceServiceGrpc.getServerLiveMethod) == null) {
      synchronized (GRPCInferenceServiceGrpc.class) {
        if ((getServerLiveMethod = GRPCInferenceServiceGrpc.getServerLiveMethod) == null) {
          GRPCInferenceServiceGrpc.getServerLiveMethod = getServerLiveMethod =
              io.grpc.MethodDescriptor.<inference.GrpcPredictV2.ServerLiveRequest, inference.GrpcPredictV2.ServerLiveResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ServerLive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ServerLiveRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ServerLiveResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GRPCInferenceServiceMethodDescriptorSupplier("ServerLive"))
              .build();
        }
      }
    }
    return getServerLiveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<inference.GrpcPredictV2.ServerReadyRequest,
      inference.GrpcPredictV2.ServerReadyResponse> getServerReadyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerReady",
      requestType = inference.GrpcPredictV2.ServerReadyRequest.class,
      responseType = inference.GrpcPredictV2.ServerReadyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<inference.GrpcPredictV2.ServerReadyRequest,
      inference.GrpcPredictV2.ServerReadyResponse> getServerReadyMethod() {
    io.grpc.MethodDescriptor<inference.GrpcPredictV2.ServerReadyRequest, inference.GrpcPredictV2.ServerReadyResponse> getServerReadyMethod;
    if ((getServerReadyMethod = GRPCInferenceServiceGrpc.getServerReadyMethod) == null) {
      synchronized (GRPCInferenceServiceGrpc.class) {
        if ((getServerReadyMethod = GRPCInferenceServiceGrpc.getServerReadyMethod) == null) {
          GRPCInferenceServiceGrpc.getServerReadyMethod = getServerReadyMethod =
              io.grpc.MethodDescriptor.<inference.GrpcPredictV2.ServerReadyRequest, inference.GrpcPredictV2.ServerReadyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ServerReady"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ServerReadyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ServerReadyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GRPCInferenceServiceMethodDescriptorSupplier("ServerReady"))
              .build();
        }
      }
    }
    return getServerReadyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<inference.GrpcPredictV2.ModelReadyRequest,
      inference.GrpcPredictV2.ModelReadyResponse> getModelReadyMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModelReady",
      requestType = inference.GrpcPredictV2.ModelReadyRequest.class,
      responseType = inference.GrpcPredictV2.ModelReadyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<inference.GrpcPredictV2.ModelReadyRequest,
      inference.GrpcPredictV2.ModelReadyResponse> getModelReadyMethod() {
    io.grpc.MethodDescriptor<inference.GrpcPredictV2.ModelReadyRequest, inference.GrpcPredictV2.ModelReadyResponse> getModelReadyMethod;
    if ((getModelReadyMethod = GRPCInferenceServiceGrpc.getModelReadyMethod) == null) {
      synchronized (GRPCInferenceServiceGrpc.class) {
        if ((getModelReadyMethod = GRPCInferenceServiceGrpc.getModelReadyMethod) == null) {
          GRPCInferenceServiceGrpc.getModelReadyMethod = getModelReadyMethod =
              io.grpc.MethodDescriptor.<inference.GrpcPredictV2.ModelReadyRequest, inference.GrpcPredictV2.ModelReadyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModelReady"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ModelReadyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ModelReadyResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GRPCInferenceServiceMethodDescriptorSupplier("ModelReady"))
              .build();
        }
      }
    }
    return getModelReadyMethod;
  }

  private static volatile io.grpc.MethodDescriptor<inference.GrpcPredictV2.ServerMetadataRequest,
      inference.GrpcPredictV2.ServerMetadataResponse> getServerMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ServerMetadata",
      requestType = inference.GrpcPredictV2.ServerMetadataRequest.class,
      responseType = inference.GrpcPredictV2.ServerMetadataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<inference.GrpcPredictV2.ServerMetadataRequest,
      inference.GrpcPredictV2.ServerMetadataResponse> getServerMetadataMethod() {
    io.grpc.MethodDescriptor<inference.GrpcPredictV2.ServerMetadataRequest, inference.GrpcPredictV2.ServerMetadataResponse> getServerMetadataMethod;
    if ((getServerMetadataMethod = GRPCInferenceServiceGrpc.getServerMetadataMethod) == null) {
      synchronized (GRPCInferenceServiceGrpc.class) {
        if ((getServerMetadataMethod = GRPCInferenceServiceGrpc.getServerMetadataMethod) == null) {
          GRPCInferenceServiceGrpc.getServerMetadataMethod = getServerMetadataMethod =
              io.grpc.MethodDescriptor.<inference.GrpcPredictV2.ServerMetadataRequest, inference.GrpcPredictV2.ServerMetadataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ServerMetadata"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ServerMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ServerMetadataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GRPCInferenceServiceMethodDescriptorSupplier("ServerMetadata"))
              .build();
        }
      }
    }
    return getServerMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<inference.GrpcPredictV2.ModelMetadataRequest,
      inference.GrpcPredictV2.ModelMetadataResponse> getModelMetadataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModelMetadata",
      requestType = inference.GrpcPredictV2.ModelMetadataRequest.class,
      responseType = inference.GrpcPredictV2.ModelMetadataResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<inference.GrpcPredictV2.ModelMetadataRequest,
      inference.GrpcPredictV2.ModelMetadataResponse> getModelMetadataMethod() {
    io.grpc.MethodDescriptor<inference.GrpcPredictV2.ModelMetadataRequest, inference.GrpcPredictV2.ModelMetadataResponse> getModelMetadataMethod;
    if ((getModelMetadataMethod = GRPCInferenceServiceGrpc.getModelMetadataMethod) == null) {
      synchronized (GRPCInferenceServiceGrpc.class) {
        if ((getModelMetadataMethod = GRPCInferenceServiceGrpc.getModelMetadataMethod) == null) {
          GRPCInferenceServiceGrpc.getModelMetadataMethod = getModelMetadataMethod =
              io.grpc.MethodDescriptor.<inference.GrpcPredictV2.ModelMetadataRequest, inference.GrpcPredictV2.ModelMetadataResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModelMetadata"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ModelMetadataRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ModelMetadataResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GRPCInferenceServiceMethodDescriptorSupplier("ModelMetadata"))
              .build();
        }
      }
    }
    return getModelMetadataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<inference.GrpcPredictV2.ModelInferRequest,
      inference.GrpcPredictV2.ModelInferResponse> getModelInferMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ModelInfer",
      requestType = inference.GrpcPredictV2.ModelInferRequest.class,
      responseType = inference.GrpcPredictV2.ModelInferResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<inference.GrpcPredictV2.ModelInferRequest,
      inference.GrpcPredictV2.ModelInferResponse> getModelInferMethod() {
    io.grpc.MethodDescriptor<inference.GrpcPredictV2.ModelInferRequest, inference.GrpcPredictV2.ModelInferResponse> getModelInferMethod;
    if ((getModelInferMethod = GRPCInferenceServiceGrpc.getModelInferMethod) == null) {
      synchronized (GRPCInferenceServiceGrpc.class) {
        if ((getModelInferMethod = GRPCInferenceServiceGrpc.getModelInferMethod) == null) {
          GRPCInferenceServiceGrpc.getModelInferMethod = getModelInferMethod =
              io.grpc.MethodDescriptor.<inference.GrpcPredictV2.ModelInferRequest, inference.GrpcPredictV2.ModelInferResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ModelInfer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ModelInferRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  inference.GrpcPredictV2.ModelInferResponse.getDefaultInstance()))
              .setSchemaDescriptor(new GRPCInferenceServiceMethodDescriptorSupplier("ModelInfer"))
              .build();
        }
      }
    }
    return getModelInferMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GRPCInferenceServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GRPCInferenceServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GRPCInferenceServiceStub>() {
        @java.lang.Override
        public GRPCInferenceServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GRPCInferenceServiceStub(channel, callOptions);
        }
      };
    return GRPCInferenceServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GRPCInferenceServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GRPCInferenceServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GRPCInferenceServiceBlockingStub>() {
        @java.lang.Override
        public GRPCInferenceServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GRPCInferenceServiceBlockingStub(channel, callOptions);
        }
      };
    return GRPCInferenceServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GRPCInferenceServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GRPCInferenceServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GRPCInferenceServiceFutureStub>() {
        @java.lang.Override
        public GRPCInferenceServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GRPCInferenceServiceFutureStub(channel, callOptions);
        }
      };
    return GRPCInferenceServiceFutureStub.newStub(factory, channel);
  }

  /**
   * <pre>
   * Inference Server GRPC endpoints.
   * </pre>
   */
  public interface AsyncService {

    /**
     * <pre>
     * The ServerLive API indicates if the inference server is able to receive 
     * and respond to metadata and inference requests.
     * </pre>
     */
    default void serverLive(inference.GrpcPredictV2.ServerLiveRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ServerLiveResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerLiveMethod(), responseObserver);
    }

    /**
     * <pre>
     * The ServerReady API indicates if the server is ready for inferencing.
     * </pre>
     */
    default void serverReady(inference.GrpcPredictV2.ServerReadyRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ServerReadyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerReadyMethod(), responseObserver);
    }

    /**
     * <pre>
     * The ModelReady API indicates if a specific model is ready for inferencing.
     * </pre>
     */
    default void modelReady(inference.GrpcPredictV2.ModelReadyRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ModelReadyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModelReadyMethod(), responseObserver);
    }

    /**
     * <pre>
     * The ServerMetadata API provides information about the server. Errors are 
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    default void serverMetadata(inference.GrpcPredictV2.ServerMetadataRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ServerMetadataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getServerMetadataMethod(), responseObserver);
    }

    /**
     * <pre>
     * The per-model metadata API provides information about a model. Errors are 
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    default void modelMetadata(inference.GrpcPredictV2.ModelMetadataRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ModelMetadataResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModelMetadataMethod(), responseObserver);
    }

    /**
     * <pre>
     * The ModelInfer API performs inference using the specified model. Errors are
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    default void modelInfer(inference.GrpcPredictV2.ModelInferRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ModelInferResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getModelInferMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service GRPCInferenceService.
   * <pre>
   * Inference Server GRPC endpoints.
   * </pre>
   */
  public static abstract class GRPCInferenceServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return GRPCInferenceServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service GRPCInferenceService.
   * <pre>
   * Inference Server GRPC endpoints.
   * </pre>
   */
  public static final class GRPCInferenceServiceStub
      extends io.grpc.stub.AbstractAsyncStub<GRPCInferenceServiceStub> {
    private GRPCInferenceServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GRPCInferenceServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GRPCInferenceServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * The ServerLive API indicates if the inference server is able to receive 
     * and respond to metadata and inference requests.
     * </pre>
     */
    public void serverLive(inference.GrpcPredictV2.ServerLiveRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ServerLiveResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getServerLiveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * The ServerReady API indicates if the server is ready for inferencing.
     * </pre>
     */
    public void serverReady(inference.GrpcPredictV2.ServerReadyRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ServerReadyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getServerReadyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * The ModelReady API indicates if a specific model is ready for inferencing.
     * </pre>
     */
    public void modelReady(inference.GrpcPredictV2.ModelReadyRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ModelReadyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModelReadyMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * The ServerMetadata API provides information about the server. Errors are 
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    public void serverMetadata(inference.GrpcPredictV2.ServerMetadataRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ServerMetadataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getServerMetadataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * The per-model metadata API provides information about a model. Errors are 
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    public void modelMetadata(inference.GrpcPredictV2.ModelMetadataRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ModelMetadataResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModelMetadataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * The ModelInfer API performs inference using the specified model. Errors are
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    public void modelInfer(inference.GrpcPredictV2.ModelInferRequest request,
        io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ModelInferResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getModelInferMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service GRPCInferenceService.
   * <pre>
   * Inference Server GRPC endpoints.
   * </pre>
   */
  public static final class GRPCInferenceServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<GRPCInferenceServiceBlockingStub> {
    private GRPCInferenceServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GRPCInferenceServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GRPCInferenceServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * The ServerLive API indicates if the inference server is able to receive 
     * and respond to metadata and inference requests.
     * </pre>
     */
    public inference.GrpcPredictV2.ServerLiveResponse serverLive(inference.GrpcPredictV2.ServerLiveRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getServerLiveMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * The ServerReady API indicates if the server is ready for inferencing.
     * </pre>
     */
    public inference.GrpcPredictV2.ServerReadyResponse serverReady(inference.GrpcPredictV2.ServerReadyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getServerReadyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * The ModelReady API indicates if a specific model is ready for inferencing.
     * </pre>
     */
    public inference.GrpcPredictV2.ModelReadyResponse modelReady(inference.GrpcPredictV2.ModelReadyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModelReadyMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * The ServerMetadata API provides information about the server. Errors are 
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    public inference.GrpcPredictV2.ServerMetadataResponse serverMetadata(inference.GrpcPredictV2.ServerMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getServerMetadataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * The per-model metadata API provides information about a model. Errors are 
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    public inference.GrpcPredictV2.ModelMetadataResponse modelMetadata(inference.GrpcPredictV2.ModelMetadataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModelMetadataMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * The ModelInfer API performs inference using the specified model. Errors are
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    public inference.GrpcPredictV2.ModelInferResponse modelInfer(inference.GrpcPredictV2.ModelInferRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getModelInferMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service GRPCInferenceService.
   * <pre>
   * Inference Server GRPC endpoints.
   * </pre>
   */
  public static final class GRPCInferenceServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<GRPCInferenceServiceFutureStub> {
    private GRPCInferenceServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GRPCInferenceServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GRPCInferenceServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * The ServerLive API indicates if the inference server is able to receive 
     * and respond to metadata and inference requests.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<inference.GrpcPredictV2.ServerLiveResponse> serverLive(
        inference.GrpcPredictV2.ServerLiveRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getServerLiveMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * The ServerReady API indicates if the server is ready for inferencing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<inference.GrpcPredictV2.ServerReadyResponse> serverReady(
        inference.GrpcPredictV2.ServerReadyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getServerReadyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * The ModelReady API indicates if a specific model is ready for inferencing.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<inference.GrpcPredictV2.ModelReadyResponse> modelReady(
        inference.GrpcPredictV2.ModelReadyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModelReadyMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * The ServerMetadata API provides information about the server. Errors are 
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<inference.GrpcPredictV2.ServerMetadataResponse> serverMetadata(
        inference.GrpcPredictV2.ServerMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getServerMetadataMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * The per-model metadata API provides information about a model. Errors are 
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<inference.GrpcPredictV2.ModelMetadataResponse> modelMetadata(
        inference.GrpcPredictV2.ModelMetadataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModelMetadataMethod(), getCallOptions()), request);
    }

    /**
     * <pre>
     * The ModelInfer API performs inference using the specified model. Errors are
     * indicated by the google.rpc.Status returned for the request. The OK code 
     * indicates success and other codes indicate failure.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<inference.GrpcPredictV2.ModelInferResponse> modelInfer(
        inference.GrpcPredictV2.ModelInferRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getModelInferMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SERVER_LIVE = 0;
  private static final int METHODID_SERVER_READY = 1;
  private static final int METHODID_MODEL_READY = 2;
  private static final int METHODID_SERVER_METADATA = 3;
  private static final int METHODID_MODEL_METADATA = 4;
  private static final int METHODID_MODEL_INFER = 5;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SERVER_LIVE:
          serviceImpl.serverLive((inference.GrpcPredictV2.ServerLiveRequest) request,
              (io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ServerLiveResponse>) responseObserver);
          break;
        case METHODID_SERVER_READY:
          serviceImpl.serverReady((inference.GrpcPredictV2.ServerReadyRequest) request,
              (io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ServerReadyResponse>) responseObserver);
          break;
        case METHODID_MODEL_READY:
          serviceImpl.modelReady((inference.GrpcPredictV2.ModelReadyRequest) request,
              (io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ModelReadyResponse>) responseObserver);
          break;
        case METHODID_SERVER_METADATA:
          serviceImpl.serverMetadata((inference.GrpcPredictV2.ServerMetadataRequest) request,
              (io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ServerMetadataResponse>) responseObserver);
          break;
        case METHODID_MODEL_METADATA:
          serviceImpl.modelMetadata((inference.GrpcPredictV2.ModelMetadataRequest) request,
              (io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ModelMetadataResponse>) responseObserver);
          break;
        case METHODID_MODEL_INFER:
          serviceImpl.modelInfer((inference.GrpcPredictV2.ModelInferRequest) request,
              (io.grpc.stub.StreamObserver<inference.GrpcPredictV2.ModelInferResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getServerLiveMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              inference.GrpcPredictV2.ServerLiveRequest,
              inference.GrpcPredictV2.ServerLiveResponse>(
                service, METHODID_SERVER_LIVE)))
        .addMethod(
          getServerReadyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              inference.GrpcPredictV2.ServerReadyRequest,
              inference.GrpcPredictV2.ServerReadyResponse>(
                service, METHODID_SERVER_READY)))
        .addMethod(
          getModelReadyMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              inference.GrpcPredictV2.ModelReadyRequest,
              inference.GrpcPredictV2.ModelReadyResponse>(
                service, METHODID_MODEL_READY)))
        .addMethod(
          getServerMetadataMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              inference.GrpcPredictV2.ServerMetadataRequest,
              inference.GrpcPredictV2.ServerMetadataResponse>(
                service, METHODID_SERVER_METADATA)))
        .addMethod(
          getModelMetadataMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              inference.GrpcPredictV2.ModelMetadataRequest,
              inference.GrpcPredictV2.ModelMetadataResponse>(
                service, METHODID_MODEL_METADATA)))
        .addMethod(
          getModelInferMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              inference.GrpcPredictV2.ModelInferRequest,
              inference.GrpcPredictV2.ModelInferResponse>(
                service, METHODID_MODEL_INFER)))
        .build();
  }

  private static abstract class GRPCInferenceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GRPCInferenceServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return inference.GrpcPredictV2.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GRPCInferenceService");
    }
  }

  private static final class GRPCInferenceServiceFileDescriptorSupplier
      extends GRPCInferenceServiceBaseDescriptorSupplier {
    GRPCInferenceServiceFileDescriptorSupplier() {}
  }

  private static final class GRPCInferenceServiceMethodDescriptorSupplier
      extends GRPCInferenceServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    GRPCInferenceServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GRPCInferenceServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GRPCInferenceServiceFileDescriptorSupplier())
              .addMethod(getServerLiveMethod())
              .addMethod(getServerReadyMethod())
              .addMethod(getModelReadyMethod())
              .addMethod(getServerMetadataMethod())
              .addMethod(getModelMetadataMethod())
              .addMethod(getModelInferMethod())
              .build();
        }
      }
    }
    return result;
  }
}
