package Personal.NumberOfIslands;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    // Main method to test the number of islands algorithm
    public static void main(String[] args) {
        // Example grid: '1' represents land, '0' represents water
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        // Prints the number of islands found in the grid
        System.out.println("Number of Islands: " + numIslands(grid));
    }

    // Returns the number of islands in the given grid using BFS
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int count = 0;
        int rows = grid.length, cols = grid[0].length;
        // Directions: down, up, right, left
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        // Traverse each cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If cell is land ('1'), start BFS
                if (grid[i][j] == '1') {
                    count++; // Found a new island
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0'; // mark visited

                    // BFS to visit all connected land cells
                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        System.out.println("Cell: " + Arrays.toString(cell));
                        for (int[] dir : directions) {
                            int r = cell[0] + dir[0];
                            int c = cell[1] + dir[1];
                            // Check bounds and if the cell is land
                            if (r >= 0 && c >= 0 && r < rows && c < cols && grid[r][c] == '1') {
                                queue.offer(new int[]{r, c});
                                grid[r][c] = '0'; // mark visited
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
}