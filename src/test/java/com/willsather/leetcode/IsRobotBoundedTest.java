package com.willsather.leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class IsRobotBoundedTest {

    @Test
    public void shouldFormCircle_whenInstructionsAreGGLLGG() {
        assertThat(IsRobotBounded.solution("GGLLGG"))
                .as("GGLLGG should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreLR() {
        assertThat(IsRobotBounded.solution("LR"))
                .as("LR should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreLLRR() {
        assertThat(IsRobotBounded.solution("LLRR"))
                .as("LLRR should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreRGRG() {
        assertThat(IsRobotBounded.solution("RGRG"))
                .as("RGRG should form a circle")
                .isTrue();
    }

    @Test
    public void shouldNotFormCircle_whenInstructionsAreGG() {
        assertThat(IsRobotBounded.solution("GG"))
                .as("GG should not form a circle")
                .isFalse();
    }

    @Test
    public void shouldNotFormCircle_whenInstructionsAreGGGG() {
        assertThat(IsRobotBounded.solution("GGGG"))
                .as("GGGG should not form a circle")
                .isFalse();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreL() {
        assertThat(IsRobotBounded.solution("L"))
                .as("L should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreR() {
        assertThat(IsRobotBounded.solution("R"))
                .as("R should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreLLLL() {
        assertThat(IsRobotBounded.solution("LLLL"))
                .as("LLLL should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreRRRR() {
        assertThat(IsRobotBounded.solution("RRRR"))
                .as("RRRR should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreGLGLGLGL() {
        assertThat(IsRobotBounded.solution("GLGLGLGL"))
                .as("GLGLGLGL should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreGLLLLG() {
        assertThat(IsRobotBounded.solution("GLLLLG"))
                .as("GLLLLG should not form a circle")
                .isFalse();
    }

    @Test
    public void shouldNotFormCircle_whenInstructionsAreGLGLGLG() {
        assertThat(IsRobotBounded.solution("GLGLGLG"))
                .as("GLGLGLG should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreEmpty() {
        assertThat(IsRobotBounded.solution(""))
                .as("Empty string should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreG() {
        assertThat(IsRobotBounded.solution("G"))
                .as("G should not form a circle")
                .isFalse();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreGLGLGL() {
        assertThat(IsRobotBounded.solution("GLGLGL"))
                .as("GL repeated should form a circle")
                .isTrue();
    }

    @Test
    public void shouldFormCircle_whenInstructionsAreGRGRGR() {
        assertThat(IsRobotBounded.solution("GRGRGR"))
                .as("GR repeated should form a circle")
                .isTrue();
    }
}