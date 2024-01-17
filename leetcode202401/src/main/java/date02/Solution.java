package date02;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    //    检查按位或是否存在尾随零
    public boolean hasTrailingZeros(int[] nums) {
//        奇数与奇数按位或运算是奇数，奇数与偶数按位或运算是奇数，偶数与偶数或运算是偶数
//        nums中如果存在两个以上的偶数，即可判断存在尾随0
        int sum = 0;
        for (int num : nums) {
            if (num % 2 == 0 && sum < 2) {
                sum++;
            }
        }
        return sum == 2;
    }

    //    找出出现至少三次的最长特殊子字符串 I
    public int maximumLength(String s) {
//       计数s中存在的相同连续串的集合，获取个数大于3的最长字串
        Map<String,Integer> map=new HashMap<>();
        
        for (int i = 0; i < s.length();) {
            for (int j = i+1; j < s.length()+1; j++) {
                if(j==s.length()||s.charAt(j)!=s.charAt(i)){
                    if(null==map.get(s.substring(i,j))){
                        map.put(s.substring(i,j),1);
                    }else {
                        map.put(s.substring(i,j),map.get(s.substring(i,j))+1);
                    }
                    i=j;
                    break;
                }
            }
        }
        int result=-1;
        for (String key:map.keySet()){
            if(map.get(key)>=3){
                result= Math.max(key.length(), result);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        System.out.println(solution.maximumLength("asasaaaaasssssssscccccccccccccccc"));
    }
}
