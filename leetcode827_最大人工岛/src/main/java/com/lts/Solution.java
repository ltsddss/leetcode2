package com.lts;

import java.util.Arrays;

/**
 * 暴力破解，但是超时
 */
public class Solution {
    /**
     * 通过遍历所有的节点，尝试每次将节点中的1个0变为1，最后判断最大的岛屿面积
     *
     * @param grid
     * @return
     */
    public int largestIsland(int[][] grid) {

        int result = 0;


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int[][] temp=new int[grid.length][grid[0].length];
                    for (int k = 0; k < temp.length; k++) {
                        System.arraycopy(grid[k], 0, temp[k], 0, temp.length);
                    }
                    temp[i][j]=1;
                    result = Math.max(result, getresult(temp));
                }
            }
        }

        return result == 0 ? grid.length * grid[0].length : result;
    }

    public int getresult(int[][] grid) {
        int result = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result = Math.max(result, maxArea(grid, i, j));
            }
        }

        return result == 0 ? grid.length * grid[0].length : result;
    }

    public int maxArea(int[][] grid, int i, int j) {
        if (i < grid.length && i >= 0 && j < grid[0].length && j >= 0) {
            if (grid[i][j] != 0) {
                grid[i][j] = 0;
//                递归节点上下左右的值，求出最终面积
                return 1 + maxArea(grid, i, j + 1) + maxArea(grid, i + 1, j) + maxArea(grid, i - 1, j) + maxArea(grid, i, j - 1);
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();


        System.out.println(s.largestIsland(new int[][]{
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 0, 0},
                {0, 1, 1, 1, 1, 0, 0}
        }));
    }
}
