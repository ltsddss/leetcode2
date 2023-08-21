package uu;

// TODO 超出内存限制
public class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int[][] dp=new int[nums.length][nums.length];
        int sum=0;
        int result=Integer.MIN_VALUE;
        for (int num : nums) {
            sum+=num;
        }
        dp[1][0]=sum;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if(j==i){
                    dp[i][j]=nums[i];
                    if(result<dp[i][j]){
                        result=dp[i][j];
                    }
                }
                else if(j>i){
                    dp[i][j]=nums[j]+dp[i][j-1];
                    if(result<dp[i][j]){
                        result=dp[i][j];
                    }
                }
                else if(j==0&&i>1){
                    dp[i][j]=dp[i-1][0]-nums[i-1];
                    if(result<dp[i][j]){
                        result=dp[i][j];
                    }
                }
                else if(j>0){
                    dp[i][j]=dp[i][j-1]+nums[j];
                    if(result<dp[i][j]){
                        result=dp[i][j];
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.maxSubarraySumCircular(new int[]{5,-3,5}));
    }
}
