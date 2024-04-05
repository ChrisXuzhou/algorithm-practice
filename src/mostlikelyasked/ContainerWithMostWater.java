package mostlikelyasked;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(
                new ContainerWithMostWater()
                        .maxArea(height)
        );
    }

    public int maxArea(int[] height) {

        int max = 0;
        int right = height.length - 1;
        int left = 0;
        while (left < right) {
            int area = Math.min(height[right], height[left]) * (right - left);
            max = Math.max(area, max);

            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        return max;
    }

}
