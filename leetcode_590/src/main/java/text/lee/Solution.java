package text.lee;

/**
 * @author 爆炸杰克
 * @create 2022/5/5
 */
public class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
//
        int result=0;

        int temp=1;

        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<k){
                result++;
                temp=nums[i];
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[j]<k){
                        temp=temp*nums[j];
                        if(temp<k){
                            result++;
                        }

                    }else {
                        break;
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.numSubarrayProductLessThanK(new int[]{100,2,3,4,100,5,6,7,100}, 100));
    }
}
