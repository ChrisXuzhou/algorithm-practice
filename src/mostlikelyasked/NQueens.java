package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        List<List<String>> ret = new NQueens()
                .solveNQueens(4);


        System.out.println(ret.size());
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        List<Integer[]> records = new ArrayList<>();

        backtrack(result, records, 0, n);
        return result;
    }

    private void backtrack(List<List<String>> result, List<Integer[]> records,
                           int x, int n) {

        if (x == n && records.size() == n) {
            // add the records
            List<String> ret = new ArrayList<>();
            for (Integer[] r : records) {
                Integer j = r[1];
                StringBuilder sb = new StringBuilder();
                int k = 0;
                while (k < n) {
                    sb.append(k == j ? 'Q' : '.');
                    k++;
                }
                ret.add(sb.toString());
            }
            result.add(ret);
            return;
        }

        for (int y = 0; y < n; y++) {
            boolean valid = true;
            for (Integer[] record : records) {
                Integer i = record[0];
                Integer j = record[1];

                if (y != j && Math.abs(j - y) != Math.abs(i - x)) {
                    continue;
                }
                valid = false;
                break;
            }

            if (valid) {
                // appropriate place
                records.add(new Integer[]{x, y});
                backtrack(result, records, x + 1, n);
                records.remove(records.size() - 1);
            }
        }
    }

}
