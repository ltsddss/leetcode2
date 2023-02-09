package com.lts.ss;

import java.util.HashMap;

public class Solution {
    public String decodeMessage(String key, String message) {
        HashMap<Character,Character> hashMap=new HashMap<>();
        char temp='a';
        StringBuilder result=new StringBuilder();
        for (int i = 0; i < key.length(); i++) {
            if(key.charAt(i)==' '){
                continue;
            }
            if(null==hashMap.get(key.charAt(i))){
                hashMap.put(temp,key.charAt(i));
                temp++;
            }
        }

        for (int i = 0; i < message.length(); i++) {
            if(null!=hashMap.get(message.charAt(i))){
                result.append(hashMap.get(message.charAt(i)));
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.decodeMessage("eljuxhpwnyrdgtqkviszcfmabo", "zwx hnfx lqantp mnoeius ycgk vcnjrdb"));
    }
}
