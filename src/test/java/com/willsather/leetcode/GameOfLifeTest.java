package com.willsather.leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class GameOfLifeTest {

    @Test
    public void testEmptyBoard() {
        int[][] board = {};
        int[][] original = {};

        GameOfLife.solution(board);

        assertThat(board).isEmpty();
        assertThat(board).isEqualTo(original);
    }

    @Test
    public void testSingleCellDead() {
        int[][] board = {{0}};
        int[][] original = {{0}};
        int[][] expected = {{0}};

        GameOfLife.solution(board);

        assertThat(board).isEqualTo(expected);
        assertThat(board).isNotSameAs(original);
    }

    @Test
    public void testSingleCellAlive() {
        int[][] board = {{1}};
        int[][] original = {{1}};
        int[][] expected = {{0}}; // A single live cell dies due to underpopulation

        GameOfLife.solution(board);

        assertThat(board).isEqualTo(expected);
        assertThat(board).isNotSameAs(original);
    }

    @Test
    public void testBlockPattern() {
        int[][] board = {
                {1, 1},
                {1, 1}
        };
        int[][] original = {
                {1, 1},
                {1, 1}
        };
        int[][] expected = {
                {1, 1},
                {1, 1}
        }; // Block pattern remains unchanged

        GameOfLife.solution(board);

        assertThat(board).isEqualTo(expected);
        assertThat(board).isNotSameAs(original);
    }

    @Test
    public void testBlinkerPattern() {
        int[][] board = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        int[][] original = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 1, 0}
        };
        int[][] expected = {
                {0, 0, 0},
                {1, 1, 1},
                {0, 0, 0}
        };

        GameOfLife.solution(board);

        assertThat(board).isEqualTo(expected);
        assertThat(board).isNotSameAs(original);
    }

    @Test
    public void testToadPattern() {
        int[][] board = {
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0},
                {0, 0, 0, 0}
        };
        int[][] original = {
                {0, 0, 0, 0},
                {0, 1, 1, 1},
                {1, 1, 1, 0},
                {0, 0, 0, 0}
        };
        int[][] expected = {
                {0, 0, 1, 0},
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {0, 1, 0, 0}
        };

        GameOfLife.solution(board);

        assertThat(board).isEqualTo(expected);
        assertThat(board).isNotSameAs(original);
    }

    @Test
    public void testRandomConfiguration() {
        int[][] board = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        int[][] original = {
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}
        };
        int[][] expected = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        GameOfLife.solution(board);

        assertThat(board).isEqualTo(expected);
        assertThat(board).isNotSameAs(original);
    }
}