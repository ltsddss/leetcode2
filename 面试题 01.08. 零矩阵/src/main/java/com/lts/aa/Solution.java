package com.lts.aa;

//面试题 16.11. 跳水板
public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if(k==0){
            return new int[]{};
        }
        if(shorter==longer){
            return new int[]{shorter};
        }
        int[] result=new int[k+1];

        for (int i = 0; i <= k; i++) {
            result[i]=longer*i+shorter*(k-i);
        }

        return result;
    }
}
