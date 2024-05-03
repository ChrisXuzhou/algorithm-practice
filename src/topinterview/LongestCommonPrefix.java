package topinterview;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String longestPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String currentString = strs[i];

            // Find the common prefix between the current string and the longest prefix
            int j = 0;
            while (j < longestPrefix.length() && j < currentString.length() &&
                    longestPrefix.charAt(j) == currentString.charAt(j)) {
                j++;
            }

            // Update the longest common prefix
            longestPrefix = longestPrefix.substring(0, j);

            if (longestPrefix.isEmpty()) {
                return "";
            }

        }

        return longestPrefix;
    }

}
