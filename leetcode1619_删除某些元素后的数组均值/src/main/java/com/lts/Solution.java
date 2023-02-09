package com.lts;

import java.util.Arrays;

public class Solution {
    /**
     *
     * @param arr 参数的数组长度为20的倍数，说明每次删除的最大值和最小值均为整数
     * @return
     */
    public double trimMean(int[] arr) {
//        首先判断需要删除的最小值和最大值分别是多少倍，最后将剩下的数值相加除以arr剩下元素的个数

//        将值强转为int
        int delete= (int) (arr.length *0.05);

        int sum=0;

        Arrays.sort(arr);
        for (int i = delete; i < arr.length-delete; i++) {
            sum+=arr[i];
        }
        return (double) sum/(arr.length-2*delete);
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.trimMean(new int[]{1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3}));
    }
}
