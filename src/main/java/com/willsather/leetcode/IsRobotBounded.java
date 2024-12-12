package com.willsather.leetcode;

public class IsRobotBounded {
    public static boolean solution(String instructions) {
        // starting position of 0,0
        int xPos = 0;
        int yPos = 0;

        // x,y (up, right, down, left)
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};

        // starting up (up = 0, right = 1, down = 2, left = 3)
        int direction = 0;

        for (char letter : instructions.toCharArray()) {
            if (letter == 'G') {
                // go forward
                xPos += directions[direction][0];
                yPos += directions[direction][1];
            } else if (letter == 'L') {
                direction = (direction + 3) % 4; // rotate left 90deg (subtract 1)
            } else if (letter == 'R') {
                direction = (direction + 1) % 4; // rotate right 90deg (add 1)
            }
        }

        System.out.println("X: " + xPos);
        System.out.println("Y: " + yPos);
        System.out.println("dir: " + direction);
        return (xPos == 0 && yPos == 0) || direction != 0;
    }
}
