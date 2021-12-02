def task1(input_filepath):
    with open(input_filepath, "r") as file:
        instructions = file.readlines()
    
    horizontal_pos = 0
    depth = 0

    for instruction in instructions:
        keywords = instruction.split(" ")
        match keywords[0]:
            case "forward":
                horizontal_pos += int(keywords[1])
            case "down":
                depth += int(keywords[1])
            case "up":
                depth -= int(keywords[1])
            case _: 
                print("Error: Unexpected Instruction: '{0}'".format(keywords[0]))
    return(horizontal_pos * depth)

def task2(input_filepath):
    with open(input_filepath, "r") as file:
        instructions = file.readlines()
    
    horizontal_pos = 0
    depth = 0
    aim = 0

    for instruction in instructions:
        keywords = instruction.split(" ")
        match keywords[0]:
            case "forward":
                horizontal_pos += int(keywords[1])
                depth += aim * int(keywords[1])
            case "down":
                aim += int(keywords[1])
            case "up":
                aim -= int(keywords[1])
            case _: 
                print("Error: Unexpected Instruction: '{0}'".format(keywords[0]))
    return(horizontal_pos * depth)

print("Task 1: {0}".format(task1("data/day2/input_1.txt")))
print("Task 2: {0}".format(task2("data/day2/input_1.txt")))