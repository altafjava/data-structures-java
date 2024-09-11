package com.altafjava.array;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath2 {

    // Directions for moving up, down, left, right
    private static final int[][] DIRECTIONS = {
        {-1, 0}, {1, 0}, {0, -1}, {0, 1}
    };

    public static int findShortestPath(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        
        // Find the source 'S'
        int[] start = findSource(grid);
        if (start == null) return -1;

        // Initialize BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start[0], start[1], 0});  // {row, col, distance}
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];
            int distance = current[2];

            // Check if we reached the destination 'D'
            if (grid[row][col] == 'D') {
                return distance;
            }

            // Explore all possible directions
            for (int[] direction : DIRECTIONS) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check if the new position is valid
                if (isValid(newRow, newCol, grid, visited)) {
                    queue.add(new int[]{newRow, newCol, distance + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }

        // If we exit the loop, there's no path from 'S' to 'D'
        return -1;
    }

    // Find the coordinates of the start point 'S'
    private static int[] findSource(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'S') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Check if the new position is within bounds, not an obstacle, and not visited
    private static boolean isValid(int row, int col, char[][] grid, boolean[][] visited) {
        return row >= 0 && row < grid.length &&
               col >= 0 && col < grid[0].length &&
               grid[row][col] != '0' && !visited[row][col];
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'S', '1', '0', '1'},
            {'1', '1', '0', '1'},
            {'0', '1', '1', '1'},
            {'1', '1', '1', 'D'}
        };

        int shortestPath = findShortestPath(grid);
        if (shortestPath != -1) {
            System.out.println("Shortest Path: " + shortestPath);
        } else {
            System.out.println("No path exists from 'S' to 'D'");
        }
    }
}
