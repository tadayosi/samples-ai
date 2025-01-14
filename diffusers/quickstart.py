from diffusers import DiffusionPipeline
import torch
import os
from datetime import datetime

os.makedirs("output/quickstart", exist_ok=True)

prompt = "An image of a rabbit in Ukiyoe style."

model_id = "stabilityai/stable-diffusion-2-1"

pipe = DiffusionPipeline.from_pretrained(
    model_id,
    torch_dtype=torch.float16,
    safety_checker=None,
)
pipe.to("mps")

# Recommended if your computer has < 64 GB of RAM
pipe.enable_attention_slicing()

image = pipe(prompt).images[0]
time = datetime.now().strftime("%H%M%S")
image.save(f"output/quickstart/{time}.png")
