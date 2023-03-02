package com.lts.bb;

import java.util.Arrays;

public class Solution {
    public int[] divisibilityArray(String word, int m) {
        int[] result = new int[word.length()];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            stringBuilder.append(word.charAt(i));
            if (Long.parseLong(stringBuilder.toString()) % m == 0) {
                result[i] = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(Arrays.toString(s.divisibilityArray("529282143571", 4)));
    }
}
