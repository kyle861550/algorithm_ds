package impl.medium;

public class ContainerWithMostWater {

    public int maxArea_force(int[] height) {
        int res = 0;

        for(int i = 0; i < height.length; i++) {
            for(int j = i + 1; j < height.length; j++) {
                int width = j - i;
                res = Math.max(res, Math.min(height[i], height[j]) * width);
            }
        }

        return res;
    }

    public int maxArea_left_right_ptr(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int newArea = Math.min(height[left], height[right]) * width;
            res = Math.max(res, newArea);

            if(height[right] > height[left]) {
                left += 1;
            } else {
                right -= 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {

    }
}
