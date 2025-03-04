package com.willsather.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GranularRateLimiter {
    private final int TIME_WINDOW = 1000; // 1 sec

    Map<String, Queue<Long>> queues = new HashMap<>();

    public boolean isRateLimited(String requestIpAddress, String requestHttpMethod, String requestHttpPath, int requestUserId, int requestTenantId) {
        long now = System.currentTimeMillis();

        return isLimitExceeded("G", 75, now) ||
                isLimitExceeded("P:" + requestHttpPath, 50, now) ||
                isLimitExceeded("UP:" + requestUserId + ":" + requestHttpPath, 25, now) ||
                isLimitExceeded("UPT:" + requestUserId + ":" + requestHttpPath + ":" + requestTenantId, 25, now);
    }

    private boolean isLimitExceeded(String key, Integer limit, Long timestamp) {
        // get rate limit queue ... in case it's not created, create linked list
        Queue<Long> queue = this.queues.computeIfAbsent(key, k -> new LinkedList<>());

        // remove outdated times (old, previous requests)
        while (!queue.isEmpty() && queue.peek() < timestamp - TIME_WINDOW) {
            queue.poll();
        }

        // add request
        queue.add(timestamp);

        // check if still valid request
        return queue.size() > limit;
    }
}