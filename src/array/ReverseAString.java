package array;

public class ReverseAString {

    // Implement a function to reverse a string in-place.
    public String reverse(String str) {

        char[] charArray = str.toCharArray();
        int left = 0;
        int right = charArray.length -1;
        while (left < right) {

            char tmp= charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = tmp;

            left ++;
            right --;
        }

        return String.valueOf(charArray);

    }

}
