package com.willsather.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Search2DMatrix {
    public static boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        Queue<int[]> queue = new LinkedList<>(); // [row, col]
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] indices = queue.poll();
            int row = indices[0];
            int col = indices[1];

            int current = matrix[row][col];
            visited[row][col] = true;

            // found it
            if (current == target) {
                return true;
            }

            // still possible to find

            // navigate down
            if (row + 1 < matrix.length && !visited[row + 1][col] && current < target) {
                queue.add(new int[]{row + 1, col});
            }

            // navigate right
            if (col + 1 < matrix[0].length && !visited[row][col + 1] && current < target) {
                queue.add(new int[]{row, col + 1});
            }
        }

        return false;
    }
}
