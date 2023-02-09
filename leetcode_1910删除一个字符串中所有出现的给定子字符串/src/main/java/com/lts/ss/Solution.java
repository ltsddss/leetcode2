package com.lts.ss;

public class Solution {
    public int countNicePairs(int[] nums) {
        int result=0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(IsTrue(nums[i],nums[j])){
                    result++;
                }
            }
        }
        return result;
    }

    public Boolean IsTrue(int num1,int num2){
        String temp1= "";
        String temp2= "";
        for (int i = 0; i < (num1+"").length(); i++) {
            temp1=(num1+"").charAt(i)+temp1;
        }
        for (int i = 0; i < (num2+"").length(); i++) {
            temp2=(num2+"").charAt(i)+temp2;
        }
        return (num1 + Integer.parseInt(temp2)) == (num2 + Integer.parseInt(temp1));
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.countNicePairs(new int[]{13,10,35,24,76}));
    }
}
