input = "data/day3/input.txt"
diagostic_length = 12

def task1(input_filepath):
    with open(input_filepath, "r") as file:
        diagnostics = file.readlines()

    gamma = ""
    epsilon = ""


    num_diagnostics = len(diagnostics)
    pos_hi = [0,0,0,0,0,0,0,0,0,0,0,0]

    for diagnostic in diagnostics:
        for pos in range(diagostic_length):
            #print(diagnostic[pos])
            if diagnostic[pos] == "1":
                pos_hi[pos] = pos_hi[pos] + 1

    for pos in range(diagostic_length):
        num_hi  = pos_hi[pos]
        if (num_hi > (num_diagnostics - num_hi)):
            gamma += "1"
            epsilon += "0"
        else: 
            gamma += "0"
            epsilon += "1"
    
    gamma_rate = int(gamma, 2)
    epsilon_rate = int(epsilon, 2)
    return gamma_rate * epsilon_rate

print("Task 1: {0}".format(task1(input)))