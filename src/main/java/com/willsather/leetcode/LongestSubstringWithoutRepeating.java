package com.willsather.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {
    public static int solution(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // if character is found again and within the window, move left pointer
            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {
                left = map.get(currentChar) + 1;
            }

            // update the latest index of the character
            map.put(currentChar, right);

            // update max length if longest so far
            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
            }
        }

        return maxLength;
    }
}
