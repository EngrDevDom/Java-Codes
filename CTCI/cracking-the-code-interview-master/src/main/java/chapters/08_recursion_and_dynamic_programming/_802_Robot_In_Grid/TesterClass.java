package _802_Robot_In_Grid;

import java.util.List;

public class TesterClass {


    public static void main(String[] args) {

        boolean[][] grid = createGrid(3, 3);
        List<PointInGrid> path = Robot.findPath(grid, 2, 2);
        System.out.print("Solution path: " + path);
    }

    private static boolean[][] createGrid(int rows, int columns) {
        boolean[][] grid = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                grid[row][col] = true;
            }
        }
        return grid;
    }
}
