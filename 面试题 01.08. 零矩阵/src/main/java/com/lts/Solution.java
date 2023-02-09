package com.lts;

import java.util.*;

public class Solution {
    public void setZeroes(int[][] matrix) {
//        首先找到数组中每一个0的横坐标和纵坐标，将横坐标和纵坐标分别去重，再去将数组中对应位置的数值置为0

        Map<Integer,Integer> map1=new HashMap();

        Map<Integer,Integer> map2=new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
                    map1.put(i,1);
                    map2.put(j,2);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(map1.get(i)!=null){
                    matrix[i][j]=0;
                }
                if(map2.get(j)!=null){
                    matrix[i][j]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sloution=new Solution();

        sloution.setZeroes(new int[][]{
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        });
    }
}
