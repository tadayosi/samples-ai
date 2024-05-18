download-models:
	mkdir -p data
	cd data; \
		curl -LO https://github.com/onnx/models/raw/main/validated/vision/classification/mnist/model/mnist-12.tar.gz; \
		tar xvf mnist-12.tar.gz
