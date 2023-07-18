package pp;

import java.util.Arrays;

public class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] temp=new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            temp[i][0]=nums[i]-k;
            temp[i][1]=nums[i]+k;
        }
        int[] result=new int[nums.length];
        int max=0;
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                if(temp[i][1]<temp[j][0]){
//                    计算美丽值
                    result[i]=j-i;
                    if(result[i]>max){
                        max=result[i];
                    }
                    break;
                }
                else if(temp[i][1]>=temp[j][0]&&j==temp.length-1){
                    result[i]=j-i+1;
                    if(result[i]>max){
                        max=result[i];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(s.maximumBeauty(new int[]{1, 1, 1, 1}, 10));
    }
}
