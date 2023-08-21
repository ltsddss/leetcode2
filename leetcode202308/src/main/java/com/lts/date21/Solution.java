package com.lts.date21;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean canChange(String start, String target) {
        String xxs="";
        String xxt="";
        for (int i = 0; i < start.length(); i++) {
            if(!(start.charAt(i) =='_')){
                xxs+=start.charAt(i);
            }
            if(!(target.charAt(i)=='_')){
                xxt+=target.charAt(i);
            }
        }
        if(!xxs.equals(xxt)){
            return false;
        }
        List<List<Integer>> listStart=getLengthAndIndex(start);
        List<List<Integer>> listTarget=getLengthAndIndex(target);


        if(!(listStart.get(0).size()==listTarget.get(0).size()&&listStart.get(1).size()==listTarget.get(1).size())){
            return false;
        }
        for (int i = 0; i < listStart.get(0).size(); i++) {
//            判断start的l是否在target的右边
            if(listStart.get(0).get(i)<listTarget.get(0).get(i)){
                return false;
            }
        }
        for (int i = 0; i < listStart.get(1).size(); i++) {
//            判断start的l是否在target的右边
            if(listStart.get(1).get(i)>listTarget.get(1).get(i)){
                return false;
            }
        }
        return true;
    }
    public List<List<Integer>> getLengthAndIndex(String str){
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> listL=new ArrayList<>();
        List<Integer> listR=new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i)=='L'){
                listL.add(i);
            }if(str.charAt(i)=='R'){
                listR.add(i);
            }
        }
        list.add(listL);
        list.add(listR);
        return list;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.canChange("_LL__R__R_", "L___L___RR"));
    }
}
