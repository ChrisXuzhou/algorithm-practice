package mostlikelyasked;

import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {

        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i< answer.length; i++) {

            int temperature = temperatures[i];
            while ( !stack.isEmpty() && temperature > temperatures[stack.peek()]) {
                int idx = stack.pop();
                answer[idx] = i - idx;
            }

            stack.push(i);
        }
        return answer;
    }

}
