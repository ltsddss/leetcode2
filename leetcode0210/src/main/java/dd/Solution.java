package dd;

//2562. 找出数组的串联值
public class Solution {
    public long findTheArrayConcVal(int[] nums) {
        Long result = 0L;

        if (nums.length % 2 == 0) {

//            偶数
            for (int i = 0; i < nums.length / 2; i++) {
                result += Long.parseLong(nums[i] + "" + nums[nums.length - i - 1]);
            }

        } else {
            for (int i = 0; i < nums.length / 2 ; i++) {
                result += Long.parseLong(nums[i] + "" + nums[nums.length - i - 1]);
            }
            result += nums[nums.length / 2];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findTheArrayConcVal(new int[]{7}));
    }
}
