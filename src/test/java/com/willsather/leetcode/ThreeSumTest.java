package com.willsather.leetcode;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ThreeSumTest {

    @Test
    void testBasicCase() {
        int[] nums = {-1, 0, 1};
        List<List<Integer>> expected = List.of(List.of(-1, 0, 1));
        assertThat(ThreeSum.solution(nums)).isEqualTo(expected);
    }

    @Test
    void testDuplicates() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> expected1 = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));
        assertThat(ThreeSum.solution(nums)).containsExactlyInAnyOrderElementsOf(expected1);
    }

    @Test
    void testEmptyReturn() {
        int[] nums = {0, 1, 1};
        List<List<Integer>> expected = List.of();
        assertThat(ThreeSum.solution(nums)).isEqualTo(expected);
    }

    @Test
    void testAllZeroes() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> expected = List.of(List.of(0, 0, 0));
        assertThat(ThreeSum.solution(nums)).isEqualTo(expected);
    }
}
