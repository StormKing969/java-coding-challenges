package Personal.NumberOfIslands;

import java.util.Arrays;

public class DFS {
        public static void main(String[] args) {
            // Example grid representing a map of '1's (land) and '0's (water)
            char[][] grid = {
                    {'1','1','0','0','0'},
                    {'1','1','0','0','0'},
                    {'0','0','1','0','0'},
                    {'0','0','0','1','1'}
            };
            // Prints the number of islands found in the grid
            System.out.println("Number of Islands: " + numIslands(grid));
        }

        /**
         * Counts the number of islands in the given grid.
         * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
         * @param grid 2D array representing the map
         * @return number of islands
         */
        public static int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0) return 0;

            int count = 0;
            // Traverse each cell in the grid
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    // If a land cell is found, perform DFS to mark the entire island
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++; // Increment island count
                    }
                }
            }

            return count;
        }

        /**
         * Depth-First Search to mark all connected land cells as visited.
         * Changes visited land cells from '1' to '0' to avoid revisiting.
         * @param grid 2D array representing the map
         * @param i current row index
         * @param j current column index
         */
        private static void dfs(char[][] grid, int i, int j) {
            // Check for out-of-bounds or water cell
            if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
                return;
            }

            grid[i][j] = '0'; // Mark current cell as visited

            // Print the grid state after each visit for debugging
            System.out.println("Visiting cell: (" + i + ", " + j + ")");
            for (char[] array : grid) {
                System.out.println(Arrays.toString(array));
            }
            System.out.println("-------------------");

            // Recursively visit all adjacent cells (up, down, left, right)
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }
