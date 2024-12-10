package com.willsather.leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HighFiveTest {

    @Test
    void testBasicScenario() {
        int[][] input = {
                {1, 91}, {1, 92}, {2, 93}, {2, 97}, {1, 60},
                {2, 77}, {1, 65}, {1, 87}, {1, 100}, {2, 100}, {2, 76}
        };
        int[][] expected = {
                {1, 87}, {2, 88}
        };

        assertThat(expected).isEqualTo(HighFive.highFive(input));
    }

    @Test
    void testSingleStudentSingleScore() {
        int[][] input = {
                {1, 50}
        };
        int[][] expected = {
                {1, 50}
        };
        assertThat(expected).isEqualTo(HighFive.highFive(input));
    }

    @Test
    void testSingleStudentMultipleScores() {
        int[][] input = {
                {1, 30}, {1, 40}, {1, 50}, {1, 60}, {1, 70}, {1, 80}, {1, 90}
        };
        int[][] expected = {
                {1, 70} // Top 5: 90, 80, 70, 60, 50; Average: (90+80+70+60+50) / 5 = 70
        };
        assertThat(expected).isEqualTo(HighFive.highFive(input));
    }

    @Test
    void testMultipleStudentsWithExactFiveScores() {
        int[][] input = {
                {1, 10}, {1, 20}, {1, 30}, {1, 40}, {1, 50},
                {2, 60}, {2, 70}, {2, 80}, {2, 90}, {2, 100}
        };
        int[][] expected = {
                {1, 30}, // Top 5: 50, 40, 30, 20, 10; Average: 30
                {2, 80}  // Top 5: 100, 90, 80, 70, 60; Average: 80
        };
        assertThat(expected).isEqualTo(HighFive.highFive(input));
    }

    @Test
    void testMultipleStudentsWithMoreThanFiveScores() {
        int[][] input = {
                {1, 10}, {1, 20}, {1, 30}, {1, 40}, {1, 50}, {1, 60}, {1, 70},
                {2, 80}, {2, 90}, {2, 100}, {2, 110}, {2, 120}, {2, 130}
        };
        int[][] expected = {
                {1, 50}, // Top 5: 70, 60, 50, 40, 30; Average: 50
                {2, 110} // Top 5: 130, 120, 110, 100, 90; Average: 110
        };
        assertThat(expected).isEqualTo(HighFive.highFive(input));
    }

    @Test
    void testEdgeCaseNoScores() {
        int[][] input = {};
        int[][] expected = {};

        assertThat(expected).isEqualTo(HighFive.highFive(input));
    }

    @Test
    void testEdgeCaseSingleStudentScoresLessThanFive() {
        int[][] input = {
                {1, 20}, {1, 30}, {1, 40}
        };
        int[][] expected = {
                {1, 30} // Top scores: 40, 30, 20; Average: (40+30+20) / 3 = 30
        };

        assertThat(expected).isEqualTo(HighFive.highFive(input));
    }
}
