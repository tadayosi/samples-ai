import torch
from torchvision import models

x = torch.rand(5, 3)
print(x)

print(f"Cuda => {torch.cuda.is_available()}")

print("Models:")
for m in models.list_models():
    print(m)
