package com.willsather.leetcode;

public class TrappingWater {
    public static int solution(int[] height) {
        int water = 0;

        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        while (left < right) {

            if (height[left] < height[right]) {

                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;

            } else {

                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;

            }

        }

        return water;
    }

//    public int trappingWater(int[] height) {
//        int total = 0;
//
//        for (int i = 0; i < height.length; i++) {
//            int leftMax = 0;
//            int rightMax = 0;
//
//            // find max on left of index
//            for (int j = 0; j <= i; j++) {
//                leftMax = Math.max(leftMax, height[j]);
//            }
//
//            // find max on right of index
//            for (int k = i; k < height.length; k++) {
//                rightMax = Math.max(rightMax, height[k]);
//            }
//
//
//            total += Math.max(0, Math.min(leftMax, rightMax) - height[i]);
//
//        }
//
//        return total;
//    }
}
