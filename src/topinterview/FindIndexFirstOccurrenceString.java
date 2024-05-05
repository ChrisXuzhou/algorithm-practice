package topinterview;

public class FindIndexFirstOccurrenceString {

    public static void main(String[] args) {

        int idx = new FindIndexFirstOccurrenceString()
                .strStr(
                        "sadbutsad",
                        "sad"
                );

        System.out.println(idx);
    }

    public int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length(); i++) {

            int ii = i;
            int j = 0;
            while (ii < haystack.length()
                    && j < needle.length()
                    && haystack.charAt(ii) == needle.charAt(j)) {
                ii++;
                j++;
            }

            if (j == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
