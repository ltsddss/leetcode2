package com.lts.dd;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minCapability(int[] nums, int k) {
//        将num存入map
        Map<Integer,Integer> map=new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
//            存入数值和位置
            map.put(nums[i],i);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int[] temp=new int[k];
            for (int j = 0; j < k; j++) {
                temp[j]=map.get(nums[j+i]);
            }
//                判断k个最小值是否相邻
            Arrays.sort(temp);
            int flag=0;
            for (int j = 0; j < temp.length-1; j++) {
                if(Math.abs(temp[j+1]-temp[j])==1){
                    flag++;
                    break;
                }
            }
            if(flag==0){
                return nums[i+k-1];
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.minCapability(new int[]{2, 3, 5, 9}, 2));
    }
}
