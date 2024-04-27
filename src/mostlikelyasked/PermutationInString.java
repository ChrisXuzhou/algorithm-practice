package mostlikelyasked;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {

        if (s1 == null || s2 == null) return false;
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> s1Map = new HashMap<>();
        for (char c: s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> s2Map = new HashMap<>();
        for (int i = 0; i< s1.length(); i++) {
            char c = s2.charAt(i);
            s2Map.put(c, s2Map.getOrDefault(c, 0) + 1);
        }

        if (s1Map.equals(s2Map)) return true;

        for (int i = s1.length(); i < s2.length(); i++) {
            char tailChar = s2.charAt(i);
            s2Map.put(tailChar, s2Map.getOrDefault(tailChar, 0) + 1);

            char headChar = s2.charAt(i - s1.length());
            if (s2Map.get(headChar) == 1) {
                s2Map.remove(headChar);
            } else {
                s2Map.put(headChar, s2Map.get(headChar) - 1);
            }

            if (s1Map.equals(s2Map)) return true;
        }

        return false;
    }

}
