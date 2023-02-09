package com.lts.aa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
//        使用Hash表的方式遍历s
        Map<String, String> map = new HashMap<>();
        for (List<String> list : knowledge) {
            map.put(list.get(0), list.get(1));
        }

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
//                找到左括号，再寻找右括号
                for (int j = i+1; j <s.length() ; j++) {
                    if(s.charAt(j)==')'){
                        String temp=s.substring(i+1,j);
                        if(null!=map.get(temp)){
                            s=s.substring(0,i)+map.get(temp)+s.substring(j+1);
                            i=i+map.get(temp).length()-1;
                        }else {
                            s=s.substring(0,i)+"?"+s.substring(j+1);
                        }
                        break;
                    }
                }
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> l1 = new ArrayList<>();
        l1.add("name");
        l1.add("bob");
        List<String> l2 = new ArrayList<>();
        l2.add("age");
        l2.add("two");

        List<List<String>> l3 = new ArrayList<>();

        l3.add(l1);
        l3.add(l2);

        System.out.println(solution.evaluate("(name)is(age)yearsold(ss)", l3));

        String ss = "(name)ssss";
        String temp = "\\(name\\)";
        System.out.println(ss.replaceAll(temp, ""));
    }
}
