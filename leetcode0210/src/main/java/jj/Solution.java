package jj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String[] getFolderNames(String[] names) {
        List<String> result=new ArrayList<>();
        for (String name : names) {
            Long index = index(result, name);
            if(0==index){
                result.add(name);
            }else if(-1==index){
                result.add(name+"("+"1"+")");
            }
            else {
                result.add(name+"("+(index+1)+")");
            }
        }
        return result.toArray(new String[result.size()-1]);
    }
    public Long index(List<String> s,String ll){
        List<String> collect = s.stream().filter((item) -> item.contains(ll)).collect(Collectors.toList());
        if(collect.size()==0){
            return 0L;
        }
        if(collect.get(collect.size()-1).equals(ll)){
            return -1L;
        }
        return Long.parseLong(collect.get(collect.size()-1).substring(collect.get(collect.size()-1).lastIndexOf("(")+1,collect.get(collect.size()-1).lastIndexOf(")")));
    }

    public static void main(String[] args) {
        Solution s=new Solution();
        System.out.println(Arrays.toString(s.getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)"})));
    }
}
