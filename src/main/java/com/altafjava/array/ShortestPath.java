package com.altafjava.array;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {

    public static void main(String[] args) {
        // Define the 2D grid (matrix) with 'S' as the source, 'D' as the destination, '1' as the valid path, and '0' as obstacles.
//        char[][] matrix = { 
//                { 'S', '0', '1', '1' },
//                { '1', '1', '0', '1' }, 
//                { '0', '1', '1', '1' }, 
//                { '1', '0', 'D', '1' } 
//            };
    	char[][] matrix = { 
                { 'S', '1', 'D', '1' },
                { '1', '1', '1', '1' }, 
                { '1', '1', '1', '1' }, 
                { '1', '1', '1', '1' } 
            };
        int path = pathExists(matrix);
        System.out.println(path);
    }

    private static int pathExists(char[][] matrix) {
        // Start BFS from the source node at position (0, 0) with a distance of 0
        Node source = new Node(0, 0, 0);
        Queue<Node> queue = new LinkedList<>();
        queue.add(source);
        int numOfRows = matrix.length;
        int numOfColumns = matrix[0].length;

        // Perform BFS until the queue is empty
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (matrix[current.x][current.y] == 'D') {
                return current.distanceFromSource; // Return the distance to the destination
            } else {
                // Mark the current node as visited by setting it to '0'
                matrix[current.x][current.y] = '0';
                // Add all valid neighbors (up, down, left, right) to the queue
                List<Node> neighbors = addNeighbours(current, matrix, numOfRows, numOfColumns);
                queue.addAll(neighbors);
            }
        }
        // If the destination is unreachable, return -1
        return -1;
    }

    /**
     * This method adds all valid (non-obstacle) neighboring nodes to the BFS queue.
     */
    private static List<Node> addNeighbours(Node current, char[][] matrix, final int numOfRows, final int numOfColumns) {
        List<Node> neighbors = new LinkedList<>();
        // Check the upper neighbor (x-1, y)
        if ((current.x - 1 >= 0 && current.x - 1 < numOfRows) && matrix[current.x - 1][current.y] != '0') {
            neighbors.add(new Node(current.x - 1, current.y, current.distanceFromSource + 1));
        }
        // Check the lower neighbor (x+1, y)
        if ((current.x + 1 >= 0 && current.x + 1 < numOfRows) && matrix[current.x + 1][current.y] != '0') {
            neighbors.add(new Node(current.x + 1, current.y, current.distanceFromSource + 1));
        }
        // Check the left neighbor (x, y-1)
        if ((current.y - 1 >= 0 && current.y - 1 < numOfColumns) && matrix[current.x][current.y - 1] != '0') {
            neighbors.add(new Node(current.x, current.y - 1, current.distanceFromSource + 1));
        }
        // Check the right neighbor (x, y+1)
        if ((current.y + 1 >= 0 && current.y + 1 < numOfColumns) && matrix[current.x][current.y + 1] != '0') {
            neighbors.add(new Node(current.x, current.y + 1, current.distanceFromSource + 1));
        }
        return neighbors;
    }
}

/**
 * Node class represents a cell in the grid with its x, y coordinates and 
 * the distance from the source node.
 */
class Node {
    int x;
    int y;
    int distanceFromSource;

    Node(int x, int y, int distance) {
        this.x = x;
        this.y = y;
        this.distanceFromSource = distance;
    }

    @Override
    public String toString() {
        return "[x=" + x + ", y=" + y + ", distance=" + distanceFromSource + "]";
    }
}
