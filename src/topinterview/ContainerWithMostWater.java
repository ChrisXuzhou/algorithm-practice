package topinterview;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int area = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            int width = right - left;
            area = Math.max(area, minHeight * width);

            if (height[left] < height[right]) {
                // move left to right ward which maybe a possible bigger area.
                left++;
            } else {
                right--;
            }
        }

        return area;
    }

}
