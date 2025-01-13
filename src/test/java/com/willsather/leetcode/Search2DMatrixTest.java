package com.willsather.leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class Search2DMatrixTest {

    @Test
    public void testTargetFoundInMiddle() {
        int[][] matrix = {
                {1, 3, 5},
                {7, 10, 11},
                {12, 14, 16}
        };
        assertThat(Search2DMatrix.solution(matrix, 10)).isTrue();
    }

    @Test
    public void testTargetNotFound() {
        int[][] matrix = {
                {1, 3, 5},
                {7, 10, 11},
                {12, 14, 16}
        };
        assertThat(Search2DMatrix.solution(matrix, 4)).isFalse();
    }

    @Test
    public void testTargetAtStart() {
        int[][] matrix = {
                {1, 3, 5},
                {7, 10, 11},
                {12, 14, 16}
        };
        assertThat(Search2DMatrix.solution(matrix, 1)).isTrue();
    }

    @Test
    public void testTargetAtEnd() {
        int[][] matrix = {
                {1, 3, 5},
                {7, 10, 11},
                {12, 14, 16}
        };
        assertThat(Search2DMatrix.solution(matrix, 16)).isTrue();
    }

    @Test
    public void testEmptyMatrix() {
        int[][] matrix = {};

        // Empty matrix should return false
        assertThat(Search2DMatrix.solution(matrix, 10)).isFalse();
    }

    @Test
    public void testSingleRowMatrix() {
        int[][] matrix = {{1, 2, 3, 4, 5}};

        // Found in the single row
        assertThat(Search2DMatrix.solution(matrix, 3)).isTrue();
    }

    @Test
    public void testSingleColumnMatrix() {
        int[][] matrix = {{1}, {2}, {3}, {4}, {5}};

        // Found in the single column
        assertThat(Search2DMatrix.solution(matrix, 4)).isTrue();
    }

    @Test
    public void testEdgeCaseMinimumMatrix() {
        int[][] matrix = {{1}};

        // Single element matrix, element is the target
        assertThat(Search2DMatrix.solution(matrix, 1)).isTrue();
    }

    @Test
    public void testEdgeCaseMinimumMatrixNotFound() {
        int[][] matrix = {{1}};

        // Single element matrix, element is not the target
        assertThat(Search2DMatrix.solution(matrix, 2)).isFalse();
    }
}
