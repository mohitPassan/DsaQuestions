package Blind75.ContainerWithMostWater.Solutions;

public class NestedLoopsSolution implements ISolution {
    @Override
    public int maxArea(int[] height) {
        int maxArea = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int b = r - l;
            int h = Math.min(height[l], height[r]);
            int area = b * h;

            if (area > maxArea) {
                maxArea = area;
            }

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxArea;
    }
}
