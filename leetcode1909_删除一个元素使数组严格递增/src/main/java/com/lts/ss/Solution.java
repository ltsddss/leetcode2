package com.lts.ss;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    public int rearrangeCharacters(String s, String target) {
        Map<String,Integer> map1=new HashMap<>();
        Map<String,Integer> map2=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(null!=map1.get(s.charAt(i)+"")){
//                map中存在该键值
                map1.put(s.charAt(i)+"",map1.get(s.charAt(i)+"")+1);
            }else {
                map1.put(s.charAt(i)+"",1);
            }
        }
        for (int i = 0; i < target.length(); i++) {
            if(null!=map2.get(target.charAt(i)+"")){
//                map中存在该键值
                map2.put(target.charAt(i)+"",map2.get(target.charAt(i)+"")+1);
            }else {
                map2.put(target.charAt(i)+"",1);
            }
        }
        int result=Integer.MAX_VALUE;
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            if (null == map1.get(entry.getKey())) {
                return 0;
            }
            int temp = map1.get(entry.getKey()) / entry.getValue();
            if (temp < result) {
                result = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.rearrangeCharacters("abc", "abcd"));
    }
}
