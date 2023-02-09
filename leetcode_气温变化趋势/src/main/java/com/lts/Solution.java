package com.lts;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
//        首先判断每个时间段的状态，0表示平稳，1表示上升，-1表示下降
//        将两个数组的每两天之间的变化存入一个map中找到两个map中最大相同的段

        Map<Integer,Integer> mapa=new HashMap<>();
        Map<Integer,Integer> mapb=new HashMap<>();
        for (int i = 0; i < temperatureA.length-1; i++) {
            if(temperatureA[i+1]-temperatureA[i]>0){
//                表示上升
                mapa.put(i,1);
            }
            else if(temperatureA[i+1]-temperatureA[i]==0){
//                表示平稳
                mapa.put(i,0);
            }
            else {
//                表示下降
                mapa.put(i,-1);
            }
            if(temperatureB[i+1]-temperatureB[i]>0){
//                表示上升
                mapb.put(i,1);
            }
            else if(temperatureB[i+1]-temperatureB[i]==0){
//                表示平稳
                mapb.put(i,0);
            }
            else {
//                表示下降
                mapb.put(i,-1);
            }
        }
//        遍历两个map找到最大的相同段
        int max=0;
        for (int i = 0; i < mapa.size(); i++) {
            if(mapa.get(i)==mapb.get(i)){
                for (int j = i+1; j < mapa.size(); j++) {
                    if(mapa.get(j)==mapb.get(j)&&j==mapa.size()-1){
                        max= Math.max(max, (j - i+1));
                        break;
                    }
                    if(mapa.get(j)!=mapb.get(j)){
                        max= Math.max(max, (j - i));
                        break;
                    }
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.temperatureTrend(new int[]{5,10,16,-6,15,11,3}, new int[]{3,16,28,32,25,12,13,-6,4}));
    }
}
