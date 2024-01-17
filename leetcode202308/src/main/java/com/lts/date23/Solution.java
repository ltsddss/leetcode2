package com.lts.date23;

public class Solution {
    //    剑指 Offer 12. 矩阵中的路径

    /**
     * 使用回溯的解法，维护一个visit数组记录是否被访问过
     *
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        boolean[][] visit = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean flag = check(board, visit, i, j, word, 0);
                if (flag) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, boolean[][] visit, int i, int j, String s, int k) {
        if (s.charAt(k) != board[i][j]) {
            return false;
        }
        if (k == s.length() - 1) {
            return true;
        }
        visit[i][j] = true;
        boolean result = false;
        int[][] distion = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] ints : distion) {
            int newi = ints[0] + i;
            int newj = ints[1] + j;
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[i].length) {
                if (!visit[newi][newj]) {
                    boolean flag = check(board, visit, newi, newj, s, k + 1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        visit[i][j] = false;
        return result;
    }

    //    剑指 Offer 13. 机器人的运动范围
    public int movingCount(int m, int n, int k) {
        boolean[][] visit = new boolean[m][n];
        return dfs(0, 0, k, visit);
    }

    public int dfs(int m, int n, int k, boolean[][] visit) {
        if (m < 0 || m >= visit.length || n < 0 || n >= visit[0].length || (m / 10 + m % 10 + n / 10 + n % 10) > k || visit[m][n]) {
            return 0;
        }
        visit[m][n] = true;
        return dfs(m, n + 1, k, visit) + dfs(m + 1, n, k, visit) + dfs(m - 1, n, k, visit) + dfs(m, n - 1, k, visit) + 1;
    }

    //    剑指 Offer 14- I. 剪绳子
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int quotient = n / 3;
        int remainder = n % 3;
        if (remainder == 0) {
            return (int) Math.pow(3, quotient);
        } else if (remainder == 1) {
            return (int) Math.pow(3, quotient - 1) * 4;
        } else {
            return (int) Math.pow(3, quotient) * 2;
        }
    }

    //    剑指 Offer 15. 二进制中1的个数
    public int hammingWeight(int n) {
        String s = Integer.toBinaryString(n);
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                result++;
            }
        }
        return result;
    }

    //  剑指 Offer 16. 数值的整数次方 TODO: 超时
    public double myPow(double x, int n) {
        if (x == 1) {
            return 1;
        }
        if (n > 0) {
            double result = x;

            while ((n - 1) != 0) {
                result *= x;
                n--;
            }
            return result;
        }
        if (n < 0) {
            double result = x;

            while ((n - 1) != 0) {
                result /= x;
                n++;
            }
            return result;
        }
        return 1;

    }

    //    剑指 Offer 17. 打印从1到最大的n位数
    public int[] printNumbers(int n) {
        int[] result = new int[(int) Math.pow(10, n) - 1];
        for (int i = 1; i < result.length + 1; i++) {
            result[i - 1] = i;
        }
        return result;
    }

    //    剑指 Offer 18. 删除链表的节点
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }
        ListNode temp = head;
        while (temp.next.val != val) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }

    //    剑指 Offer 20. 表示数值的字符串
    public boolean isNumber(String s) {
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myPow(2.000, -3));
    }
}
