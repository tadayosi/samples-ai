import numpy as np
import onnxruntime as ort
from onnx import numpy_helper
from util import print_inout, read_proto

model = "data/mobilenetv2-12/mobilenetv2-12.onnx"
input = "data/mobilenetv2-12/test_data_set_0/input_0.pb"

sess = ort.InferenceSession(model)
print("============================================================")
print_inout(model, sess)
print("============================================================")

# inputs = np.random.randn(1, 3, 224, 224).astype(np.float32)
inputs = numpy_helper.to_array(read_proto(input))
results = sess.run(None, {"input": inputs})[0][0]
answer = 0
for i in range(len(results)):
    value = results[i]
    if value > results[answer]:
        answer = i
with open("data/mobilenetv2-12/synset.txt", "r") as f:
    labels = [l.rstrip() for l in f]

print(f"Answer => {labels[answer]}")
