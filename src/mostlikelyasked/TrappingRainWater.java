package mostlikelyasked;

public class TrappingRainWater {

    public static void main(String[] args) {
//        int[] height = {4, 2, 0, 3, 2, 5};
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(
                new TrappingRainWater()
                        .trap(height)
        );
    }

    public int trap(int[] height) {

        int volume = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    volume += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    volume += rightMax - height[right];
                }
                right--;
            }
        }

        return volume;
    }
}
