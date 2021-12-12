import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> bingoNumbers = new ArrayList<>();
        ArrayList<Grid> grids = new ArrayList<>();
        String fileAddress = "src/input.txt";
        int lineNum = 1;

        try {
            File input = new File(fileAddress);
            Scanner InputReader = new Scanner(input);
            while (InputReader.hasNextLine()) {
                String lineData;

                if (lineNum == 1) {
                    lineData = InputReader.nextLine();
                    bingoNumbers.addAll(Arrays.stream(lineData.split(","))
                            .mapToInt(Integer::valueOf)
                            .boxed()
                            .collect(Collectors.toList()));
                    lineData = InputReader.nextLine();
                    lineNum+=2;
                }
                else {
                    Grid currentGrid = new Grid();
                    for (int y = 0; y < 5; y++) {
                        lineData = InputReader.nextLine();
                        int[] gridLine = Arrays.stream(lineData.trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                        for (int x = 0; x < 5; x++) {
                            currentGrid.grid[x][y] = gridLine[x];
                        }
                    }
                    System.out.println(currentGrid);
                    if (InputReader.hasNextLine()) {
                        lineData = InputReader.nextLine();
                        if (!lineData.trim().isEmpty()) {
                            System.out.println("Issue: " + lineData);
                        }
                    }
                }
            }
            InputReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
