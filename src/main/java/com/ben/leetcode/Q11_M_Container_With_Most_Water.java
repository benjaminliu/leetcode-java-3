package com.ben.leetcode;

/**
 * Created by ben on 2018/7/28.
 */
public class Q11_M_Container_With_Most_Water {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2)
            return 0;

        if (height.length == 2)
            return height[0] > height[1] ? height[1] : height[0];

        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int distance = right - left;
            int temp;
            if (height[left] > height[right]) {
                temp = height[right] * distance;
                right--;
            } else {
                temp = height[left] * distance;
                left++;
            }

            if (max < temp)
                max = temp;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Q11_M_Container_With_Most_Water q = new Q11_M_Container_With_Most_Water();
        int i = q.maxArea(height);
        System.out.println(i);
    }
}
