package Companies.Wanderlog.Question01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'aPlusB' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY lines as parameter.
     */

    public static List<String> aPlusB(List<String> lines) {
        return lines.stream().map(line -> {
            StringTokenizer st = new StringTokenizer(line);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            return String.valueOf(a + b);
        }).collect(toList());
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int linesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> lines = IntStream.range(0, linesCount).mapToObj(_ -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = Result.aPlusB(lines);

        bufferedWriter.write(
            String.join("\n", result)
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
