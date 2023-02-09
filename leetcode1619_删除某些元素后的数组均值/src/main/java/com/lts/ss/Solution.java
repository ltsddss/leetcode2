package com.lts.ss;

import com.sun.crypto.provider.HmacPKCS12PBESHA1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        List<String> list=new ArrayList<>();

//        构造一个map存储一个名称的list集合
        Map<String,List<String>> map=new HashMap<>();

        for (int i = 0; i < keyName.length; i++) {
            List<String> temp = map.getOrDefault(keyName[i], new ArrayList<>());
            temp.add(keyTime[i]);
            map.put(keyName[i],temp);
        }

        for (String key : map.keySet()) {
            List<String> a=map.get(key);

            a.sort(String::compareTo);
            
//            维护一个大小为3的滑动窗口
            for (int i = 2; i < a.size(); i++) {
                Long i1=getTime(a.get(i));
                Long i2=getTime(a.get(i-2));
                if(i1-i2<=60){
                    list.add(key);
                    break;
                }
            }
        }
        list.sort(String::compareTo);
        return list;
    }

//    将时间转化为分钟
    public Long getTime(String time){
        String[] split = time.split(":");
        return Long.parseLong(split[0])*60+Long.parseLong(split[1]);
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.alertNames(
                new String[]{"a","a","a","a","a","a","a","b","b","b","b","b","b","b","c","c","c","c","c","c","c","c","c"},
                new String[]{"00:37","11:24","14:35","21:25","15:48","20:28","07:30","09:26","10:32","20:10","19:26","08:13","01:08","15:49","02:34","06:48","04:33","07:18","00:05","06:44","13:33","04:12","03:54"}));
    }
}
