package gg;

import java.util.*;

//6362. 合并两个二维数组 - 求和法
public class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        Map<Integer, Integer> map = new HashMap<>();


        for (int[] ints : nums1) {
            map.put(ints[0],ints[1]);
        }
        for (int[] ints : nums2) {
            map.merge(ints[0], ints[1], (a, b) -> map.get(ints[0]) + ints[1]);
        }
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Integer key : map.keySet()) {
            result[index][0] = key;
            result[index][1] = map.get(key);
            index++;
        }
        Arrays.sort(result, Comparator.comparingInt(o -> o[0]));
        return result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.deepToString(solution.mergeArrays(
                        new int[][]{
                                new int[]{2, 4},
                                new int[]{3, 6},
                                new int[]{5, 5}},
                        new int[][]{
                                new int[]{1, 3},
                                new int[]{4, 3}
                        }
                )
        ));
    }
}
