package Question04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q4_Attempt_1 {
    public static List<Integer> calculateDailyServerCapacity(List<Integer> server, List<Integer> replaceId, List<Integer> newId) {
        System.out.println("Oldserver " + server);
        System.out.println("replaceId " + replaceId);
        System.out.println("newId " + newId);
        System.out.println();

        List<Integer> returnArraList = new ArrayList<>();
        Map<Integer, List<Integer>> idToPosition = new HashMap<>();

        for (int i = 0; i < server.size(); i++) {
            int id = server.get(i);
            idToPosition.computeIfAbsent(id, _ -> new ArrayList<>()).add(i);
        }

        System.out.println("initialIdToPosition " + idToPosition);
        System.out.println();

        for (int n = 0; n < replaceId.size(); n++) {
            int oldServerID = replaceId.get(n);
            int newServerValue = newId.get(n);

            System.out.println("oldServerID " + oldServerID);
            System.out.println("newServerValue " + newServerValue);
            System.out.println();

            if (idToPosition.containsKey(oldServerID) && oldServerID != newServerValue) {
                List<Integer> positions = idToPosition.get(oldServerID);
                System.out.println("tempIdToPosition " + idToPosition);
                System.out.println("positions " + positions);
                System.out.println();

                for (int ele : positions) {
                    System.out.println("tempServer " + server);
                    server.set(ele, newServerValue);
                    idToPosition.computeIfAbsent(newServerValue, _ -> new ArrayList<>()).add(ele);
                }

                System.out.println("newServer " + server);
                System.out.println("newIdToPosition " + idToPosition);
                System.out.println();

                idToPosition.remove(oldServerID);
            }

            int capacity = 0;
            for (int value : server) {
                capacity += value;
            }

            returnArraList.add(capacity);
        }

        return returnArraList;
    }
}
