package com.lts.lts;

public class Solution {
//    笨阶乘
    int sum;

    public int clumsy(int n) {
//        判断第一个符号是什么符号
        if(n==3){
            return 2;
        }
       sum = n;
        for (int i = n; i >1 ; i--) {
            if(i%4==0){
//                为加法运算
                sum+=(i-1);
            }
            else if(i%4==3){
//                为减法运算
                return sum-=clumsy(i);
            }
            else if(i%4==2){
//                乘法运算
                sum=sum*(i-1);
            }
            else {
//                除法运算
                sum=sum/(i-1);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.clumsy(10));
    }
}
