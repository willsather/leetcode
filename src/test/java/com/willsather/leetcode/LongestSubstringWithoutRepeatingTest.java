package com.willsather.leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LongestSubstringWithoutRepeatingTest {

    @Test
    void testLongestSubstring() {
        // Basic cases
        assertThat(LongestSubstringWithoutRepeating.solution("aabbcda")).isEqualTo(4); // bcda
        assertThat(LongestSubstringWithoutRepeating.solution("abcabcbb")).isEqualTo(3); // abc
        assertThat(LongestSubstringWithoutRepeating.solution("bbbbb")).isEqualTo(1); // b
        assertThat(LongestSubstringWithoutRepeating.solution("pwwkew")).isEqualTo(3); // kew

        // Edge cases
        assertThat(LongestSubstringWithoutRepeating.solution("")).isEqualTo(0);
        assertThat(LongestSubstringWithoutRepeating.solution(" ")).isEqualTo(1); // " "
        assertThat(LongestSubstringWithoutRepeating.solution("a")).isEqualTo(1); // a

        // Complex cases
        assertThat(LongestSubstringWithoutRepeating.solution("abcdef")).isEqualTo(6); // abcdef
        assertThat(LongestSubstringWithoutRepeating.solution("dvdf")).isEqualTo(3); // vdf
        assertThat(LongestSubstringWithoutRepeating.solution("anviaj")).isEqualTo(5); // nviaj
    }
}
