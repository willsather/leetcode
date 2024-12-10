package com.willsather.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TrappingWaterTest {

    @Test
    public void testTrap_withNoWater() {
        int[] height = {1, 2, 3, 4, 5};

        assertThat(TrappingWater.solution(height)).isEqualTo(0);
    }

    @Test
    public void testTrap_withSingleElement() {
        int[] height = {3};

        assertThat(TrappingWater.solution(height)).isEqualTo(0);
    }

    @Test
    public void testTrap_withValleyShape() {
        int[] height = {5, 4, 1, 2, 1, 4, 5};

        assertThat(TrappingWater.solution(height)).isEqualTo(13);
    }

    @Test
    public void testTrap_withMultipleValleys() {
        int[] height = {4, 2, 0, 3, 2, 5};

        assertThat(TrappingWater.solution(height)).isEqualTo(9);
    }

    @Test
    public void testTrap_withIncreasingHeight() {
        int[] height = {0, 1, 2, 3, 4, 5};

        assertThat(TrappingWater.solution(height)).isEqualTo(0);
    }

    @Test
    public void testTrap_withDecreasingHeight() {
        int[] height = {5, 4, 3, 2, 1};

        assertThat(TrappingWater.solution(height)).isEqualTo(0);
    }

    @Test
    public void testTrap_withRandomHeights() {
        int[] height = {3, 0, 1, 3, 0, 5};

        assertThat(TrappingWater.solution(height)).isEqualTo(8);
    }

    @Test
    public void testTrap_withAllSameHeight() {
        int[] height = {2, 2, 2, 2, 2};

        assertThat(TrappingWater.solution(height)).isEqualTo(0);
    }

    @Test
    public void testTrap_withAllZeros() {
        int[] height = {0, 0, 0, 0, 0};

        assertThat(TrappingWater.solution(height)).isEqualTo(0);
    }
}

