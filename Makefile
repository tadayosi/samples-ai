download-models:
	mkdir -p data
	cd data; \
		curl -LO https://github.com/onnx/models/raw/main/validated/vision/classification/mnist/model/mnist-12.tar.gz; \
		tar xvf mnist-12.tar.gz

format:
	black .

torchserve-start:
	torchserve --start --ncs --disable-token-auth --model-store data/model_store --models densenet161.mar

torchserve-stop:
	torchserve --stop

torchserve-docker:
	podman run --rm --shm-size=1g \
	    --ulimit memlock=-1 \
	    --ulimit stack=67108864 \
	    -p 127.0.0.1:8080:8080 \
	    -p 127.0.0.1:8081:8081 \
	    -p 127.0.0.1:8082:8082 \
	    -p 127.0.0.1:7070:7070 \
	    -p 127.0.0.1:7071:7071 \
	    --mount type=bind,source=data/model_store,target=/tmp/models tadayosi/torchserve torchserve --model-store=/tmp/models
