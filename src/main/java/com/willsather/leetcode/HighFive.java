package com.willsather.leetcode;

import java.util.*;

public class HighFive {
    public static int[][] solution(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int[] item : items) {
            int id = item[0];
            int score = item[1];

            map.putIfAbsent(id, new PriorityQueue<>());
            PriorityQueue<Integer> pq = map.get(id);

            pq.offer(score);

            if (pq.size() > 5) {
                pq.poll();
            }
        }

        List<int[]> result = new ArrayList<>();
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Integer> pq = entry.getValue();

            int sum = 0;
            int testCount = pq.size();
            while (!pq.isEmpty()) {
                sum += pq.poll();
            }

            int average = sum / Math.min(5, testCount);
            result.add(new int[]{id, average});
        }

        result.sort(Comparator.comparingInt(a -> a[0]));

        return result.toArray(new int[result.size()][]);
    }
}
