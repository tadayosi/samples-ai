import torch

x = torch.rand(5, 3)
print(x)

print("cuda =", torch.cuda.is_available())
print("mps =", torch.backends.mps.is_available())
