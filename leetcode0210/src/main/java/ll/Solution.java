package ll;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Map<Character, Integer>> split = Split(pattern);
        List<Boolean> result=new ArrayList<>();
        for (String query : queries) {
            List<Map<Character, Integer>> splitQuery = Split(query);
            int length=result.size();
            if(!Objects.equals(split.get(0).get('#'), splitQuery.get(0).get('#'))){
                result.add(false);
                continue;
            }
            split.get(0).forEach((key,value)->{
//                判断大写是否全部符合
                if(null==splitQuery.get(0).get(key)){
                    result.add(false);
                }
            });
            if(length!=result.size()){
                continue;
            }
            split.get(1).forEach((key,value)->{
//                判断小写是否全部符合
                if(null==splitQuery.get(1).get(key)){
                    result.add(false);
                }
            });
            if(length==result.size()){
                result.add(true);
            }
        }
        return result;
    }

    /**
     * 拆分字符串
     * @param str 字符串
     * @return 大小写字符串的list
     */
    public List<Map<Character,Integer>> Split(String str){
        Map<Character,Integer> mapUp=new HashMap<>();
//        大写字母个数
        mapUp.put('#',0);
        Map<Character,Integer> mapDo=new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if('A'<=str.charAt(i)&&str.charAt(i)<='Z'){
//                为大写
                mapUp.put(str.charAt(i),0);
                mapUp.put('#',mapUp.get('#')+1);
            }
            else {
                mapDo.put(str.charAt(i),0);
            }
        }
        List<Map<Character,Integer>> result=new ArrayList<>();
        result.add(mapUp);
        result.add(mapDo);
        return result;
    }
}
