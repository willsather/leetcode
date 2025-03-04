package com.willsather.leetcode;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // step 1: sort the array
        Arrays.sort(nums);

        // step 2: iterate over the array
        for (int i = 0; i < nums.length - 2; i++) {
            // skip duplicate elements for the first number (extra
             if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            // step 3: use two-pointer technique
            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // skip duplicates for the second and third numbers
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // increase the sum
                } else {
                    right--; // decrease the sum
                }
            }
        }

        return result;
    }

}
