package array;

public class Palindrome {

    // Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

    // String cleanedString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    public boolean check(char[] array) {

        int l = 0;
        int r = array.length -1;

        if (l == r) {
            return false;
        }

        while (l < r) {
            if (array[l] != array[r]) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }

}
