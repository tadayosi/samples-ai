import tensorflow as tf

input_dir = "data/mnist"

mnist = tf.saved_model.load("build/tensorflow/mnist/1")
print("signatures:", list(mnist.signatures.keys()))

infer = mnist.signatures["serving_default"]
print("inputs:", infer.structured_input_signature)
print("outputs:", infer.structured_outputs)


def do_infer(img):
    result = infer(tf.image.convert_image_dtype(img, tf.float32))
    output = result["output_0"]
    # print("output:", output.numpy())
    return tf.argmax(output, axis=1).numpy()[0]


for dir in tf.io.gfile.listdir(input_dir):
    print("dir:", dir)
    for file in tf.io.gfile.listdir(f"{input_dir}/{dir}"):
        img_file = tf.io.read_file(f"{input_dir}/{dir}/{file}")
        img = tf.image.decode_image(img_file)
        # print("img:", img.shape)
        answer = do_infer(img)
        print(f"  {file} =>", answer)
