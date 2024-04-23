package mostlikelyasked;

import java.util.Stack;

public class DecodeStringBracket {

    public String decodeString(String s) {

        // extract the units from s into a stack
        char[] chars = s.toCharArray();
        String current = "";
        int idx = 0;

        Stack<Integer> countStack = new Stack<>();
        Stack<String> result = new Stack<>();

        while (idx < chars.length) {
            // parse count
            if (Character.isDigit(chars[idx])) {
                int count = 0;
                while (Character.isDigit(chars[idx])) {
                    count = count * 10 + (chars[idx] - '0');
                    idx++;
                }
                countStack.push(count);
            } else if (chars[idx] == '[') {
                result.push(current);
                current = "";
                idx++;
            } else if (chars[idx] == ']') {
                StringBuilder ret = new StringBuilder(result.pop());
                int count = countStack.pop();
                for (int i = 0; i < count; i++) {
                    ret.append(current);
                }
                current = ret.toString();
                idx++;
            } else {
                current += chars[idx];
                idx++;
            }
        }
        return current;
    }

}
