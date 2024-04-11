package mostlikelyasked;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {

        List<List<Integer>> ret =
                new PascalsTriangle()
                        .generate(5);

        System.out.println(ret.size());
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> results = new ArrayList<>();
        if (numRows <= 0) return results;

        List<Integer> result = new ArrayList<>();
        result.add(1);
        results.add(result);

        if (numRows == 1) return results;

        int i = 2;
        while (i <= numRows) {

            List<Integer> previous = results.get(i - 2);
            List<Integer> current = new ArrayList<>(i);

            for (int j = 0; j < i; j++) {
                current.add(
                        (j - 1 < 0 ? 0 : previous.get(j - 1)) +
                                ((j < i - 1) ? previous.get(j) : 0)
                );
            }

            results.add(current);
            i++;
        }

        return results;
    }

}
