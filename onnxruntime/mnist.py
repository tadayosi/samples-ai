import numpy as np
from onnx import numpy_helper
from util import print_inout, read_proto
import onnxruntime as ort

model = "data/mnist-12/mnist-12.onnx"
input = "data/mnist-12/test_data_set_0/input_0.pb"

print("ONNX Runtime example using MNIST model")
sess = ort.InferenceSession(model)
print("============================================================")
print_inout(model, sess)
print("============================================================")

# inputs = np.random.randn(1, 1, 28, 28).astype(np.float32)
inputs = numpy_helper.to_array(read_proto(input))
print(f">>> {inputs.shape}")
results = sess.run(None, {"Input3": inputs})[0][0]
print("Output:")
print("------------------------------")
answer = 0
for i in range(len(results)):
    value = results[i]
    print(f"{i} = {value}")
    if value > results[answer]:
        answer = i
print("------------------------------")
print(f"Answer => {answer}")
