package com.willsather.leetcode;

public class GameOfLife {
    public static void solution(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int rows = board.length;
        int cols = board[0].length;

        int[][] newBoard = new int[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                int liveNeighbors = GameOfLife.countLiveNeighbors(board, i, j);

                // 1. if live, dies due to underpopulation
                if (board[i][j] == 1 && liveNeighbors < 2) {
                    newBoard[i][j] = 0;
                }

                // 2. if live, lives on due to 2 neighbors
                else if (board[i][j] == 1 && (liveNeighbors == 2 || liveNeighbors == 3)) {
                    newBoard[i][j] = 1;
                }

                // 3. if live, dies due to over population
                else if (board[i][j] == 1 && liveNeighbors > 3) {
                    newBoard[i][j] = 0;
                }

                // 4. dead cell gets revived
                else if (board[i][j] == 0 && liveNeighbors == 3) {
                    newBoard[i][j] = 1;
                }

                // 5. stays the same
                else {
                    newBoard[i][j] = board[i][j];
                }
            }
        }

        // update original board
        for (int i = 0; i < rows; i++) {
            System.arraycopy(newBoard[i], 0, board[i], 0, cols);
        }
    }

    private static int countLiveNeighbors(int[][] board, int row, int col) {
        int maxRow = board.length - 1;
        int maxCol = board[0].length - 1;

        int count = 0;

        // top row
        if (row > 0) {
            // top left
            if (col > 0 && board[row - 1][col - 1] == 1) {
                count++;
            }

            // top middle
            if (board[row - 1][col] == 1) {
                count++;
            }

            // top right
            if (col < maxCol && board[row - 1][col + 1] == 1) {
                count++;
            }
        }

        // left
        if (col > 0 && board[row][col - 1] == 1) {
            count++;
        }

        // right
        if (col < maxCol && board[row][col + 1] == 1) {
            count++;
        }

        // bottom row
        if (row < maxRow) {
            // bottom left
            if (col > 0 && board[row + 1][col - 1] == 1) {
                count++;
            }

            // bottom middle
            if (board[row + 1][col] == 1) {
                count++;
            }

            // bottom right
            if (col < maxCol && board[row + 1][col + 1] == 1) {
                count++;
            }
        }

        return count;
    }
}
