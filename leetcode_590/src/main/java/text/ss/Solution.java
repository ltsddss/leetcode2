package text.ss;

public class Solution {
    public int waysToSplitArray(int[] nums) {
//        将所有的条件列出来
        Long start= Long.valueOf(nums[0]);

        Long end=0L;

        for (int i = 1; i < nums.length; i++) {
            end+=nums[i];
        }
        int result=0;

        if(start>=end){
            result++;
        }

        for (int i = 0; i < nums.length-2; i++) {
            start=start+nums[i+1];
            end=end-nums[i+1];
            if(start>=end){
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.waysToSplitArray(new int[]{3,2}));
    }
}
