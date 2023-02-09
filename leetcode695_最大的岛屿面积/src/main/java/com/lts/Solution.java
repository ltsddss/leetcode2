package com.lts;

public class Solution {
    /**
     * 采用深度有限遍历的方式将每一个岛屿的节点遍历一边，
     * 当遍历到1的时候进行深度或者广度优先搜索，将搜索后的节点置0表示该节点已经遍历过
     * 判断每块岛屿的面积，找出最大的数值
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int result=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                result=Math.max(result,maxArea(grid,i,j));
            }
        }

        return result;
    }

    /**
     * 节点的深度优先遍历函数
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public int maxArea(int[][] grid,int i,int j){
        if(i<grid.length&&i>=0&&j<grid[0].length&&j>=0){
            if(grid[i][j]!=0){
                grid[i][j]=0;
//                递归节点上下左右的值，求出最终面积
                return 1+maxArea(grid,i,j+1)+maxArea(grid,i+1,j)+maxArea(grid,i-1,j)+maxArea(grid,i,j-1);
            }
            else {
                return 0;
            }
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.maxAreaOfIsland(new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        }));
    }
}
