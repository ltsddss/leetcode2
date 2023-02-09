package com.lts;

public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
//        找到两个字符不相同的位置，完后进行交换，如果交换后仍不相同，则返回false
        int a = 0;
        int b = 0;
        int flag = 0;
        int re = 0;
        if (s1.equals(s2)) return true;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                flag++;
                if (flag == 1) {
                    a = i;
                    re++;
                }
                if (flag == 2) {
                    b = i;
                    re++;
                    break;
                }
            }
        }
        if (re == 2) {
            String temp = s1.substring(0, a) + s1.charAt(b) + s1.substring(a + 1, b) + s1.charAt(a) + s1.substring(b + 1);
            if (s2.equals(temp)) {
                return true;
            }
            else {
                return false;
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.areAlmostEqual("abcd", "dcba"));
    }


}
