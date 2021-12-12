import java.util.Arrays;

public class Grid {
    int grid[][] = new int[5][5];

    Grid() {

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
