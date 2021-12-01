def sonar_depth(input_filepath):
    file = open(input_filepath, "r")

    with open(input_filepath, "r") as file:
        depths = file.readlines()

    previous_depth = depths[0]
    depth_increase_count = 0
    for depth in depths:
        if int(depth) > int(previous_depth):
            depth_increase_count += 1
        previous_depth = depth
    return depth_increase_count

print("Number of Depth Increases: {0}".format(sonar_depth("data/day1/input_1.txt")))
