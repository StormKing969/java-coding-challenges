package Companies.Wanderlog.Question03;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {
    public static List<String> processLogs(List<String> logs, int maxSpan) {
        Map<String, List<String[]>> userLogs = new HashMap<>();

        for (String log : logs) {
            String[] parts = log.trim().split(" ");
            userLogs.computeIfAbsent(parts[0], _ -> new ArrayList<>()).add(parts);
        }

        Set<String> qualifyingUsers = new HashSet<>();
        for (Map.Entry<String, List<String[]>> entry : userLogs.entrySet()) {
            String userId = entry.getKey();
            List<String[]> events = entry.getValue();

            events.sort(Comparator.comparingInt(e -> Integer.parseInt(e[1])));

            Integer signInTime = null;
            for (String[] e : events) {
                String action = e[2];
                int time = Integer.parseInt(e[1]);

                if (action.equals("sign-in")) {
                    signInTime = time;
                } else if (action.equals("sign-out") && signInTime != null) {
                    int difference = time - signInTime;
                    if (difference <= maxSpan) {
                        qualifyingUsers.add(userId);
                    }
                    signInTime = null;
                }
            }
        }

        List<String> result = new ArrayList<>(qualifyingUsers);
        result.sort(Comparator.comparingInt(Integer::parseInt));
        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int logsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> logs = IntStream.range(0, logsCount).mapToObj(_ -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int maxSpan = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> result = Result.processLogs(logs, maxSpan);

        bufferedWriter.write(
            String.join("\n", result)
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
