package com.willsather.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class GranularRateLimiterTest {
    private GranularRateLimiter rateLimiter;
    private final Random random = new Random();

    @BeforeEach
    void setUp() {
        rateLimiter = new GranularRateLimiter();
    }

    @Test
    void testGlobalRateLimit() throws InterruptedException {
        // Simulate 75 requests to random URLs (allowed)
        for (int i = 0; i < 75; i++) {
            assertThat(rateLimiter.isRateLimited("10.0.0.1", "GET", "/" + random.nextInt(100), random.nextInt(100), random.nextInt(100))).isFalse();
        }

        // 76th request should be rate-limited
        assertThat(rateLimiter.isRateLimited("10.0.0.1", "GET", "/" + random.nextInt(100), random.nextInt(100), random.nextInt(100))).isTrue();

        // wait for time window to pass
        Thread.sleep(1100);

        // after time window, request should be allowed again
        assertThat(rateLimiter.isRateLimited("10.0.0.1", "GET", "/", random.nextInt(100), random.nextInt(100))).isFalse();
    }

    @Test
    void testPathSpecificLimit() {
        // 50 requests to "/" should be allowed
        for (int i = 0; i < 50; i++) {
            assertThat(rateLimiter.isRateLimited("10.0.0.1", "GET", "/", random.nextInt(100), random.nextInt(100))).isFalse();
        }

        // 51st request should be rate-limited
        assertThat(rateLimiter.isRateLimited("10.0.0.1", "GET", "/", random.nextInt(100), random.nextInt(100))).isTrue();
    }

    @Test
    void testUserPathLimit() {
        // 25 requests per user-path should be allowed
        for (int i = 0; i < 25; i++) {
            assertThat(rateLimiter.isRateLimited("10.0.0.1", "GET", "/", 3, random.nextInt(100))).isFalse();
        }

        // 26th request should be rate-limited
        assertThat(rateLimiter.isRateLimited("10.0.0.1", "GET", "/", 3, random.nextInt(100))).isTrue();
    }

    @Test
    void testUserPathTenantLimit() {
        // 25 requests per user-path-tenant should be allowed
        for (int i = 0; i < 25; i++) {
            assertThat(rateLimiter.isRateLimited("10.0.0.1", "GET", "/", 4, 10)).isFalse();
        }

        // 26th request should be rate-limited
        assertThat(rateLimiter.isRateLimited("10.0.0.1", "GET", "/", 4, 10)).isTrue();
    }
}
