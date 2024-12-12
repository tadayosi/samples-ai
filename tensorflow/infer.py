import tensorflow as tf

mnist = tf.keras.datasets.mnist
(x_train, y_train), (x_test, y_test) = mnist.load_data()
x_train, x_test = x_train / 255.0, x_test / 255.0

mnist = tf.saved_model.load("build/tensorflow/mnist")
print("signatures:", list(mnist.signatures.keys()))

infer = mnist.signatures["serving_default"]
print("inputs:", infer.structured_input_signature)
print("outputs:", infer.structured_outputs)

result = infer(tf.constant(x_test[0:1], dtype=tf.float32))
print(result["output_0"])
print("Answer =>", tf.argmax(result["output_0"], axis=1).numpy()[0])
