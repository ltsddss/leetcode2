package com.lts.lts;

import java.util.*;

public class Solution {
    public int transportationHub(int[][] path) {
//        将二维数组拆分为两个一维数组，判断每个节点是否有是交通枢纽的可能

        int[] resu1=new int[path.length];
        int[] resu2=new int[path.length];
        int max=-1;
        for (int i = 0; i < path.length; i++) {
            resu1[i]=path[i][0];
            resu2[i]=path[i][1];
            max=Math.max(max,path[i][0]);
            max=Math.max(max,path[i][1]);
        }

//        判断第二维中的i对应的一维是否是否有max-1个不相同的点
        Map<Integer,Integer> sum=new HashMap<>();
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < path.length; j++) {
                if(resu2[j]==i){
//                    表示到达i的个数，判断sum的数量是否是max-1
                    sum.put(resu1[j],1);
                }
            }
            if(sum.size()==max){
                int flag=0;
                for (int k : resu1) {
                    if (k == i) {
                        flag=1;
                    }
                }
                if(flag==1){
                    break;
                }
                return i;
            }
            else {
                sum.clear();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.transportationHub(new int[][]{{0,1},{0,3},{1,3},{2,0},{2,3}}));
    }
}
