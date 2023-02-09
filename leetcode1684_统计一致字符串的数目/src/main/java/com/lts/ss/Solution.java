package com.lts.ss;

class Solution {
    public int countEven(int num) {
        int result = 0;
        for (int i = 1; i <= num; i++) {
            int sum = 0;
            int temp = i;
            while (temp != 0) {
                if ((temp % 10) % 2 == 1) {
                    // 表示i的个位数为奇数
                    sum++;
                    System.out.println(temp);
                    temp = temp / 10;
                    System.out.println(temp);
                }
                else {
                    temp=temp/10;
                }
            }
            if (sum % 2 == 0) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.countEven(4)+"结果");
    }
}