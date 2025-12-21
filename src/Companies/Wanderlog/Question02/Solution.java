package Companies.Wanderlog.Question02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {
    public static List<String> groupTransactions(List<String> transactions) {
        Map<String, Integer> transactionMap = new HashMap<>();

        for (String transaction : transactions) {
            if (transactionMap.containsKey(transaction)) {
                transactionMap.put(transaction, transactionMap.get(transaction) + 1);
            } else {
                transactionMap.put(transaction, 1);
            }
        }

        return transactionMap.entrySet()
                .stream()
                .sorted((a, b) -> {
                    int cmp = b.getValue().compareTo(a.getValue());
                    return (cmp != 0) ? cmp : a.getKey().compareTo(b.getKey());
                })
                .map(e -> e.getKey() + " " + e.getValue())
                .collect(toList());
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int transactionsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> transactions = IntStream.range(0, transactionsCount).mapToObj(_ -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.groupTransactions(transactions);

        bufferedWriter.write(
            String.join("\n", result)
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
