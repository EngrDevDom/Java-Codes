package _802_Robot_In_Grid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Robot in a Grid: Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off iimits"such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
 * the bottom right.
 */
public class Robot {

    public static List<PointInGrid> findPath(final boolean[][] grid, int row, int column) {

        if (grid == null || row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return null;
        }

        List<PointInGrid> solutions = new ArrayList<>();
        solutions.add(new PointInGrid(0, 0));
        //use cacheMap to store solutions already computed
        Map<PointInGrid, Boolean> cacheMap = new HashMap<>();
        cacheMap.put(new PointInGrid(0, 0), true);

        boolean foundPath = findPath(grid, row, column, solutions, cacheMap);

        if (foundPath) {
            return solutions;
        } else {
            return null;
        }

    }

    public static boolean findPath(final boolean[][] grid, int row, int column, List<PointInGrid> solutions, Map<PointInGrid, Boolean> cacheMap) {

        PointInGrid point = new PointInGrid(row, column);

        if (cacheMap.containsKey(point)) {
            return cacheMap.get(point);
        }

        if (!isPointFree(grid, row, column)) {
            return false;
        }

        boolean foundPath = findPath(grid, row, column - 1, solutions, cacheMap);
        if (!foundPath) {
            foundPath = findPath(grid, row - 1, column, solutions, cacheMap);
        }

        cacheMap.put(point, foundPath);

        if (foundPath) {
            solutions.add(point);
        }
        return foundPath;
    }

    private static boolean isPointFree(boolean[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return false;
        }
        return grid[row][column];
    }
}
