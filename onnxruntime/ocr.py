import cv2
import torch
import numpy as np
import onnxruntime as ort
from util import print_inout

model_dir = "data/ppocr/"
model_det = "en_PP-OCRv3_det_infer.onnx"
model_rec = "en_PP-OCRv3_rec_infer.onnx"
model_cls = "ch_ppocr_mobile_v2.0_cls_infer.onnx"

input = "data/images/camels_song.jpg"

image = cv2.imread(input)
image = np.random.randn(10, 3, 32, 100).astype(np.float32)
det_sess = ort.InferenceSession(model_dir + model_det)
print_inout(model_det, det_sess)
print(image.shape)
outputs = det_sess.run(None, {"x": image})
print(outputs)
