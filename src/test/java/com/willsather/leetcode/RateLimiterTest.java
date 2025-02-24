package com.willsather.leetcode;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RateLimiterTest {

    @Test
    public void testRateLimiter() {
        RateLimiter rateLimiter = new RateLimiter();

        int[] timestamps = {1074, 1074, 1076, 1076, 1076, 1076, 2075};
        char[] expectedOutput = {'a', 'a', 'a', 'd', 'd', 'd', 'a'};

        for (int i = 0; i < timestamps.length; i++) {
            assertThat(rateLimiter.processPacket(timestamps[i])).isEqualTo(expectedOutput[i]);
        }
    }
}
