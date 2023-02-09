package com.lts.cc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> removeSubfolders(String[] folder) {
//        对folder进行排序
        Arrays.sort(folder);
//        创建结果集合
        List<String> result=new ArrayList<>();
        result.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            int pre=result.get(result.size()-1).length();
            if(!(pre<folder[i].length()&&(result.get(result.size()-1).equals(folder[i].substring(0,pre)))&&folder[i].charAt(pre)=='/')){
                result.add(folder[i]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.removeSubfolders(new String[]{"/a","/a/b","/c/d","/c/d/e","/c/f"}));
    }
}
