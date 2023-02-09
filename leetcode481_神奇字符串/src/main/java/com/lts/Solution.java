package com.lts;

public class Solution {
    public int magicalString(int n) {
        StringBuilder s = new StringBuilder("122");

        if(n<=2){
            return 1;
        }
        int result=1;

        for (int i = 2; n>s.length(); i++) {
            if('1'==s.charAt(i)){
                if('1'==s.charAt(s.length()-1)){
                    s.append("2");
                }
                else {
                    s.append("1");
                    result=result+1;
                }
            }
            else {
                if('1'==s.charAt(s.length()-1)){
                    s.append("22");
                }
                else {
                    s.append("11");
                    result=result+2;
                }
            }
        }

        return s.substring(n).contains("1")?("11".equals(s.substring(n))?result-2:result-1):result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.magicalString(11));
    }
}
