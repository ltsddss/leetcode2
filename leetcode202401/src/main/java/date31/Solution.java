package date31;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Solution {
    //2670. 找出不同元素数目差数组
    public int[] distinctDifferenceArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> mapLeft = new HashMap<>();
            Map<Integer, Integer> mapRight = new HashMap<>();
            for (int j = 0; j <= i; j++) {
                mapLeft.put(nums[j], 1);
            }
            if (i != nums.length - 1) {
                for (int j = i + 1; j < nums.length; j++) {
                    mapRight.put(nums[j], 1);
                }
            }
            result[i] = mapLeft.size() - mapRight.size();
        }
        return result;
    }

    //    3019. 按键变更的次数
    public int countKeyChanges(String s) {
        String temp = s.toLowerCase();
        int result = 0;
        for (int i = 1; i < temp.length(); i++) {
            if (temp.charAt(i) != temp.charAt(i - 1)) {
                result++;
            }
        }
        return result;
    }

    //    3020. 子集中元素的最大数量
    public int maximumLength(int[] nums) {
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countKeyChanges("AaAaAaaA"));
    }
}
