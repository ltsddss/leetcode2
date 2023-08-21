package vv;

import java.util.Arrays;

public class Solution {
    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[nums.length-1];
        for (int num : nums) {
            if(min<num&&num<max){
                return num;
            }
        }
        return -1;
    }
}
