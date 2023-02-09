package com.lts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//超出时间限制
public class Solution {
    public int totalFruit(int[] fruits) {

//        每次向前移动一位，重新找是否是是水果的最大值

        Map<Integer,Integer> map=new HashMap<>();


        int[] result=new int[fruits.length];

        int flag=0;
        for (int i = 0; i < fruits.length; i++) {
            for (int j = i; j < fruits.length; j++) {
                if(map.size()<=2){
                    if(map.get(fruits[j])!=null){
                        map.put(fruits[j],map.get(fruits[j])+1);
                    }
                    else {
                        if(map.size()==1){
                            flag=j;
                        }
                        map.put(fruits[j],1);
                        if(map.size()==3){
                            map.remove(fruits[j]);
                            break;
                        }
                    }
                }
            }
            if(flag==0){
                result[i]=map.get(fruits[i]);
                map.clear();
            }
            else {
                result[i]=map.get(fruits[i])+map.get(fruits[flag]);
                flag=0;
                map.clear();
            }

        }

        Arrays.sort(result);

        return result[result.length-1];
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }
}
