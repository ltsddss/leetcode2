package qq;


//给你一个下标从 0 开始、由 n 个整数组成的数组 nums 和一个整数 target 。
//TODO 解答错误
//你的初始位置在下标 0 。在一步操作中，你可以从下标 i 跳跃到任意满足下述条件的下标 j ：
//
// 0 <= i < j < n
//-target <= nums[j] - nums[i] <= target
//返回到达下标 n - 1 处所需的 最大跳跃次数 。
//
//如果无法到达下标 n - 1 ，返回 -1 。
public class Solution {
    public int maximumJumps(int[] nums, int target) {
        int result=0;
        int temp=1;
//        双指针
        for (int i = 0; i < nums.length-1;) {
            for (int j = i+temp; j < nums.length; ) {
                if((nums[j]-nums[i]<=target)&&(nums[j]-nums[i])>=-target){
                    result++;
                    i=j;
                    j=i+1;
                    continue;
                }
                else if(j==nums.length-1){
                    temp++;
                    i=0;
                    j=temp;
                    result=0;
                    if(temp==nums.length){
                        return  -1;
                    }
                    continue;
                }
                j++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.maximumJumps(new int[]{1,2,0,3}, 2));
    }
}
