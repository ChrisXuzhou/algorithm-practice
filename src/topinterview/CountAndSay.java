package topinterview;

public class CountAndSay {

    public String countAndSay(int n) {
        String[] ret = new String[n + 1];
        ret[0] = "";
        ret[1] = "1";

        for (int i = 2; i <= n; i++) {

            StringBuilder sb = new StringBuilder();
            String prev = ret[i - 1];
            int j = 0;
            while (j < prev.length()) {

                int je = j + 1;
                while (je < prev.length() && prev.charAt(je) == prev.charAt(je - 1)) {
                    je++;
                }
                // from j to je is a segment
                sb.append(je - j).append(prev.charAt(j));

                j = je;
            }

            ret[i] = sb.toString();
        }
        return ret[n];
    }

}
