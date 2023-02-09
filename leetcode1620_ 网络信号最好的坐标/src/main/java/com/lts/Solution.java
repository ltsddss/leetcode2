package com.lts;

import java.util.Arrays;

//TODO:待修正
public class Solution {
    public int[] bestCoordinate(int[][] towers, int radius) {
        // 遍历所有的第一象限中的整数点判断每个点的信号强度，找出最大值
        int[] result = new int[2];
        int max = 0;
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int temp = Result(towers, i, j);
                if (max < temp) {
                    max = temp;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    //    计算当前点的信号强度
    public int Result(int[][] towers, int x, int y) {
        int sum = 0;
        for (int i = 0; i < towers.length; i++) {
            sum += towers[i][2] / Math.sqrt(Math.pow((towers[i][0] - x), 2) + Math.pow((towers[i][1] - y), 2));
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.bestCoordinate(new int[][]{{1, 2, 5}, {2, 1, 7}, {3, 1, 9}}, 2)));
    }
}
