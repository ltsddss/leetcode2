package com.lts;

import java.util.HashMap;

public class Solution {

    /**
     *
     * @param arr 是目标数组
     * @param pieces 需要去连接的数组
     * @return 是否可以实现将pieces进行连接得到arr
     */
    public boolean canFormArray(int[] arr, int[][] pieces) {
//        分别将arr和pieces的每个一维数组转为字符串

        StringBuilder flag= new StringBuilder();
        for (int i : arr) {
            flag.append(i).append(",");
        }


        for (int[] piece : pieces) {
            String temp="";
            for (int j : piece) {
                temp = temp+ j + ",";
            }
            if (!flag.toString().contains(temp)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.canFormArray(new int[]{49,18,16}, new int[][]{{16,18,49}}));
    }
}
