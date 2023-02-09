package com.lts.main;

class Solution {
    /**
     * 遍历数组
     * @param nums
     * @return
     */
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long ret = 0;
        for (int i = 0; i < n; i++) {
            int minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE;
            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, nums[j]);
                maxVal = Math.max(maxVal, nums[j]);
                ret += maxVal - minVal;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.subArrayRanges(new int[]{1,2,3,4,5,6,1}));
    }
}
