package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {

    public static void main(String[] args) {
        int ret = new LongestConsecutiveSequence()
                .longestConsecutive(new int[] {100,4,200,1,3,2});
        System.out.println(ret);
    }

    public int longestConsecutive(int[] nums) {

        Map<Integer, Integer> num2count = new HashMap<>();
        for (int num: nums) {
            num2count.put(num, 1);
        }

        int max = 0;

        for (int num: nums) {
            if (num2count.get(num) == 1) {
                int n = num + 1;
                int currentMax = 1;

                while (num2count.containsKey(n) && num2count.get(n) != 0) {
                    int step = num2count.get(n);
                    num2count.put(n, 0);

                    if (step > 1) {
                        currentMax += step;
                        break;
                    } else {
                        currentMax += 1;
                        n += 1;
                    }
                }

                num2count.put(num, currentMax);
                max = Math.max(max, currentMax);
            }
        }

        return max;
    }

}
