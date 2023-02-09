package com.lts.ss;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean digitCount(String num) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length(); i++) {
            if (null != map.get(num.charAt(i) + "")) {
                map.put(num.charAt(i) + "", map.get(num.charAt(i) + "") + 1);
            } else {
                map.put(num.charAt(i) + "", 1);
            }
        }
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) == '0') {
//                说明在map中不存在
                if (!(null == map.get(i + ""))) {
                    return false;

                }
            } else if (!(num.charAt(i) + "").equals(map.get(i + "") + "")) {
//                说明在map中存在
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.digitCount("1210"));
    }
}
