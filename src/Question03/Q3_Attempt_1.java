package Question03;

        import java.util.*;

        /**
         * This class provides a method to calculate the minimum inconvenience
         * when placing a new delivery center in a grid.
         */
        public class Q3_Attempt_1 {

            /**
             * Calculates the minimum inconvenience of placing a new delivery center in a grid.
             *
             * @param grid A 2D list of integers where:
             *             - 1 represents an existing delivery center.
             *             - 0 represents an empty cell.
             * @return The minimum inconvenience value after placing a new delivery center.
             */
            public static int getMinInconvenience(List<List<Integer>> grid) {
                int n = grid.size(); // Number of rows in the grid
                int m = grid.getFirst().size(); // Number of columns in the grid
                int[][] dist = new int[n][m]; // Distance matrix to store distances from delivery centers

                // Initialize the distance matrix with maximum values
                for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
                Queue<int[]> queue = new LinkedList<>();

                // Step 1: Initialize BFS from all existing delivery centers (1s)
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid.get(i).get(j) == 1) { // If the cell contains a delivery center
                            dist[i][j] = 0; // Distance to itself is 0
                            queue.offer(new int[]{i, j}); // Add to BFS queue
                        }
                    }
                }

                // Directions for Chebyshev movement (8 directions)
                int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
                int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

                // Step 2: Perform multi-source BFS using Chebyshev movement
                while (!queue.isEmpty()) {
                    int[] cell = queue.poll(); // Get the current cell
                    int x = cell[0], y = cell[1];
                    for (int d = 0; d < 8; d++) { // Iterate over all 8 directions
                        int nx = x + dx[d], ny = y + dy[d]; // Calculate the new cell coordinates
                        // Check if the new cell is within bounds and can be updated
                        if (nx >= 0 && ny >= 0 && nx < n && ny < m && dist[nx][ny] > dist[x][y] + 1) {
                            dist[nx][ny] = dist[x][y] + 1; // Update the distance
                            queue.offer(new int[]{nx, ny}); // Add the new cell to the queue
                        }
                    }
                }

                // Step 3: Identify cells with the maximum distance
                int maxDist = 0; // Maximum distance found
                List<int[]> candidates = new ArrayList<>(); // List of candidate cells for the new delivery center
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid.get(i).get(j) == 0) { // Only consider empty cells
                            if (dist[i][j] > maxDist) { // If a new maximum distance is found
                                maxDist = dist[i][j]; // Update the maximum distance
                                candidates.clear(); // Clear the candidate list
                                candidates.add(new int[]{i, j}); // Add the new candidate
                            } else if (dist[i][j] == maxDist) { // If the distance equals the maximum
                                candidates.add(new int[]{i, j}); // Add the cell to the candidate list
                            }
                        }
                    }
                }

                // Step 4: Try placing a delivery center at each candidate and recalculate inconvenience
                int minInconvenience = maxDist; // Initialize the minimum inconvenience
                for (int[] cand : candidates) { // Iterate over all candidate cells
                    int cx = cand[0], cy = cand[1]; // Candidate cell coordinates
                    int newMax = 0; // New maximum distance after placing the delivery center

                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (grid.get(i).get(j) == 0) { // Only consider empty cells
                                int original = dist[i][j]; // Original distance
                                int newDist = Math.max(Math.abs(i - cx), Math.abs(j - cy)); // New distance
                                newMax = Math.max(newMax, Math.min(original, newDist)); // Update the new maximum
                            }
                        }
                    }

                    minInconvenience = Math.min(minInconvenience, newMax); // Update the minimum inconvenience
                }

                return minInconvenience; // Return the minimum inconvenience
            }
        }