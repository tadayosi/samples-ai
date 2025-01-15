download-models:
	mkdir -p data
	cd data; \
		curl -LO https://github.com/onnx/models/raw/main/validated/vision/classification/mnist/model/mnist-12.tar.gz; \
		tar xvf mnist-12.tar.gz

format:
	black .

OS ?= osx
ARCH ?= aarch_64
GRPC_JAVA_VERSION ?= 1.68.1

kserve-protoc:
	protoc --java_out=./kserve ./kserve/grpc_predict_v2.proto
	protoc \
	    --plugin=protoc-gen-grpc-java=./protoc-gen-grpc-java-$(GRPC_JAVA_VERSION)-$(OS)-$(ARCH).exe \
	    --grpc-java_out=./kserve \
	    ./kserve/grpc_predict_v2.proto
