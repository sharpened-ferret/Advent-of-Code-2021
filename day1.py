def sonar_depth(input_filepath):
    with open(input_filepath, "r") as file:
        depths = file.readlines()

    previous_depth = depths[0]
    depth_increase_count = 0
    for depth in depths:
        if int(depth) > int(previous_depth):
            depth_increase_count += 1
        previous_depth = depth
    return depth_increase_count

def sonar_depth_threes(input_filepath):
    with open(input_filepath, "r") as file:
        depths = file.readlines()

    previous_depth_sum = None
    depth_increase_count = 0
    for x in range(2, len(depths)):
        depth_sum = int(depths[x]) + int(depths[x-1]) + int(depths[x-2])
        if previous_depth_sum is not None:
            if depth_sum > previous_depth_sum:
                depth_increase_count += 1
        previous_depth_sum = depth_sum

    return (depth_increase_count)

print("Number of Depth Increases: {0}".format(sonar_depth("data/day1/input_1.txt")))
print("Number of Depth Triple Sum Increases: {0}".format(sonar_depth_threes("data/day1/input_1.txt")))