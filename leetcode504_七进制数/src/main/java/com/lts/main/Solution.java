package com.lts.main;

public class Solution {
    public String convertToBase7(int num) {
        String result = "";

        if (num >= 0) {
            while (num >= 7) {
                result = num % 7 + "" + result;
                num = num / 7;
            }

            return num + result;
        }
        else {
            return "-"+convertToBase7(-num);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.convertToBase7(-70));
    }
}
