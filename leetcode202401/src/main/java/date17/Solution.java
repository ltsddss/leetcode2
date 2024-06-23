package date17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * 2744. 最大字符串配对数目
     */
    public int maximumNumberOfStringPairs(String[] words) {
        int result = 0;
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isFZ(words[i], words[j])) {
                    result++;
                }
            }
        }
        return result;
    }

    public boolean isFZ(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        boolean result = true;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i)!=s2.charAt(s1.length()-i-1)){
                result=false;
                break;
            }
        }
        return result;
    }

    /**
     * 3005. 最大频率元素计数
     */
    public int maxFrequencyElements(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        int max=0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1); // 使用 getOrDefault 避免 NPE
            max = Math.max(max, map.get(num));
        }
        int result=0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer value = entry.getValue();
            if(value==max){
                result+=value;
            }
        }
        return result;
    }
    /**
     * 3006. 找出数组中的美丽下标 I（超时）
     */
//    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
//        int m=s.length()-a.length();
//        int n=s.length()-b.length();
//        List<Integer> list=new ArrayList<>();
//        for (int i = 0; i <= m; i++) {
//            if(s.substring(i,i+a.length()).equals(a)){
//                for (int j = 0; j <= n; j++) {
//                    if(s.substring(j,j+b.length()).equals(b)){
//                        if(Math.abs(j-i)<=k){
//                            list.add(i);
//                            break;
//                        }
//                    }
//                }
//            }
//        }
//        return list;
//    }
    /**
     * 3006. 找出数组中的美丽下标 I
     */
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        return null;
    }
    public static void main(String[] args) {
        Solution solution=new Solution();
        solution.beautifulIndices("abcd","a","a",4);
    }
}
