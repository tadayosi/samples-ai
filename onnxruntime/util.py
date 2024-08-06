def print_inout(name, model):
    print(f"Model: {name}")
    print("  Inputs:")
    for input in model.get_inputs():
        print(f"    {input.name} => {input.shape}: {input.type}")
    print("  Outputs:")
    for output in model.get_outputs():
        print(f"    {output.name} => {output.shape}: {output.type}")
