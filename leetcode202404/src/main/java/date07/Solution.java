package date07;

public class Solution {
    //    100264. 最长的严格递增或递减子数组
    public int longestMonotonicSubarray(int[] nums) {
//        维护一个窗口实现nums的严格递增或递减
        int result1 = 1;
        int result2 = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[j - 1]) {
                    temp++;
                } else {
                    result1 = Math.max(temp, result1);
                    i = j - 1;
                    break;
                }
            }
            result1 = Math.max(temp, result1);
        }
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[j - 1]) {
                    temp++;
                } else {
                    result2 = Math.max(temp, result2);
                    i = j - 1;
                    break;
                }
            }
            result2 = Math.max(temp, result2);
        }
        return Math.max(result1, result2);
    }

    //    100242. 满足距离约束且字典序最小的字符串
    public String getSmallestString(String s, int k) {
        StringBuilder t=new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if('a'==s.charAt(i)){
                continue;
            }
            if(26-(s.charAt(i)-'a')<=k){
                k-=(26-(s.charAt(i)-'a'));
                t.replace(i,i+1,"a");
            }else {
               t.replace(i,i+1,((char)(s.charAt(i)-k))+"");
            }
        }
        return t.toString();
    }
    public static void main(String[] args) {
        String s="cesssssssa|";
        String[] sdd=s.split("\\|");
        System.out.println(sdd[1]);
    }
}
