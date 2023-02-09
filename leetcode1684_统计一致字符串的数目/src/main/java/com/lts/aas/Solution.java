package com.lts.aas;

import java.util.Arrays;

public class Solution {
    public int reinitializePermutation(int n) {
        // 初始化perm
        int[] perm=new int[n];
        int[] temp=new int[n];
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            perm[i]=i;
        }
        temp=Arrays.copyOf(perm,n);
        int result=0;
        // 循环执行步骤，直到perm回到最初
        while(!Arrays.equals(arr,perm)){
            result++;
            for(int i=0;i<n;i++){
                if(i%2==0){
                    arr[i]=temp[i/2];
                }
                else{
                    arr[i]=temp[n/2+(i-1)/2];
                }
            }
            temp=Arrays.copyOf(arr,n);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.reinitializePermutation(10));
    }
}
