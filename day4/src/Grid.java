import java.util.ArrayList;

public class Grid {
    int grid[][] = new int[5][5];
    private boolean completedGrid[][] = new boolean[5][5];
    ArrayList<Integer> numbers = new ArrayList<>();

    Grid() {}

    public boolean checkNum(int num) {
        if (numbers.contains(num)) {
            for (int y = 0; y < 5; y++) {
                for (int x = 0; x < 5; x++) {
                    if ((grid[x][y]) == num) {
                        completedGrid[x][y] = true;
                        return checkWin(x, y, num);
                    }
                }
            }
        }
        return false;
    }

    private boolean checkWin(int x, int y, int callNum) {
        if (completedGrid[x][0] && completedGrid[x][1] && completedGrid[x][2] && completedGrid[x][3] && completedGrid[x][4]) {
            System.out.println("Board Wins: ");
            calcWin(callNum);
            return true;
        }
        if (completedGrid[0][y] && completedGrid[1][y] && completedGrid[2][y] && completedGrid[3][y] && completedGrid[4][y]) {
            System.out.println("Board Wins: ");
            calcWin(callNum);
            return true;
        }
        return false;
    }

    private void calcWin(int callNum) {
        int totalScore = 0;
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                if ((!completedGrid[x][y])) {
                    totalScore += grid[x][y];
                }
            }
        }
        totalScore *= callNum;
        System.out.println(totalScore);
    }

    @Override
    public String toString() {
        return "Grid{" +
                "grid=" + gridToString() +
                '}';
    }

    private String gridToString() {
        StringBuilder returnStr = new StringBuilder("\n[");
        for (int y = 0; y < 5; y++) {
            returnStr.append("[");
            for (int x = 0; x < 5; x++) {
                returnStr.append("["+grid[x][y]+"]");
            }
            returnStr.append("]\n");
        }
        returnStr.append("]");
        return returnStr.toString();
    }
}
