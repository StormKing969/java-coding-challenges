package Question04;

            import java.util.ArrayList;
            import java.util.HashMap;
            import java.util.List;
            import java.util.Map;

            /**
             * This class contains a method to calculate the daily server capacity
             * after replacing server IDs with new ones.
             */
            public class Q4_Attempt_2 {

                /**
                 * Calculates the daily server capacity after replacing server IDs.
                 *
                 * @param server    A list of integers representing the initial server IDs.
                 * @param replaceId A list of integers representing the server IDs to be replaced.
                 * @param newId     A list of integers representing the new server IDs to replace the old ones.
                 * @return A list of integers where each element represents the total server capacity
                 *         after each replacement operation.
                 */
                public static List<Integer> calculateDailyServerCapacity(List<Integer> server, List<Integer> replaceId, List<Integer> newId) {
                    // List to store the total server capacity after each replacement operation
                    List<Integer> returnArraList = new ArrayList<>();

                    // Map to store the positions of each server ID in the server list
                    Map<Integer, List<Integer>> idToPosition = new HashMap<>();

                    // Populate the map with the initial positions of each server ID
                    for (int i = 0; i < server.size(); i++) {
                        int id = server.get(i);
                        idToPosition.computeIfAbsent(id, _ -> new ArrayList<>()).add(i);
                    }

                    // Debugging output for the initial mapping of server IDs to positions
                    System.out.println("initialIdToPosition " + idToPosition);
                    System.out.println();

                    // Iterate through the replaceId and newId lists to perform replacements
                    for (int n = 0; n < replaceId.size(); n++) {
                        int oldServerID = replaceId.get(n); // The server ID to be replaced
                        int newServerValue = newId.get(n); // The new server ID to replace the old one

                        // Debugging output for the current replacement operation
                        System.out.println("oldServerID " + oldServerID);
                        System.out.println("newServerValue " + newServerValue);
                        System.out.println();

                        // Check if the old server ID exists and is different from the new server ID
                        if (idToPosition.containsKey(oldServerID) && oldServerID != newServerValue) {
                            // Get the positions of the old server ID
                            List<Integer> positions = idToPosition.get(oldServerID);

                            // Debugging output for the current state of the map and positions
                            System.out.println("tempIdToPosition " + idToPosition);
                            System.out.println("positions " + positions);
                            System.out.println();

                            // Replace the old server ID with the new server ID at each position
                            for (int ele : positions) {
                                System.out.println("tempServer " + server);
                                System.out.println("position " + ele);
                                server.set(ele, newServerValue); // Update the server list
                                idToPosition.computeIfAbsent(newServerValue, _ -> new ArrayList<>()).add(ele); // Update the map
                            }

                            // Debugging output for the updated server list and map
                            System.out.println("newServer " + server);
                            System.out.println("newIdToPosition " + idToPosition);
                            System.out.println();

                            // Remove the old server ID from the map
                            idToPosition.remove(oldServerID);
                        }

                        // Calculate the total server capacity after the replacement
                        int capacity = 0;
                        for (int value : server) {
                            capacity += value;
                        }

                        // Add the calculated capacity to the result list
                        returnArraList.add(capacity);
                    }

                    // Return the list of total capacities after each replacement
                    return returnArraList;
                }
            }