package ee;

import java.util.Arrays;

//2563. 统计公平数对的数目
public class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long result=0;
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i]>upper/2){
                break;
            }
            for (int j = i+1; j < nums.length; j++) {
                Long temp= (long) nums[j] + nums[i];
                if(temp>upper){
                    break;
                }
                else if(temp>=lower&&temp<=upper){
                    result++;
                }
            }
        }
        return result;
    }
}
