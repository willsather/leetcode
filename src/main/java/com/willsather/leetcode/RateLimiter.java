package com.willsather.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class RateLimiter {
    private final Queue<Integer> oneSecondQueue;
    private final Queue<Integer> fiveSecondQueue;

    public RateLimiter() {
        oneSecondQueue = new LinkedList<>();
        fiveSecondQueue = new LinkedList<>();
    }

    public char processPacket(int timestamp) {
        // remove timestamps older than 1 second (1000 ms)
        while (!oneSecondQueue.isEmpty() && oneSecondQueue.peek() < timestamp - 1000) {
            oneSecondQueue.poll();
        }

        // remove timestamps older than 5 seconds (5000 ms)
        while (!fiveSecondQueue.isEmpty() && fiveSecondQueue.peek() < timestamp - 5000) {
            fiveSecondQueue.poll();
        }

        // check if the packet should be accepted or dropped
        if (oneSecondQueue.size() < 3 && fiveSecondQueue.size() < 10) {
            oneSecondQueue.offer(timestamp);
            fiveSecondQueue.offer(timestamp);

            return 'a'; // ACCEPT
        } else {
            return 'd'; // DROP
        }
    }
}
