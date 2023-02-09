package text.ssss;

public class Solution {
    public int divisorSubstrings(int num, int k) {
//        将num转为String
        String temp=Integer.toString(num);

        int flag=0;

        for (int i = 0; i <= temp.length()-k; i++) {
            int s=Integer.parseInt(temp.substring(i,i+k));
            if(s==0){
                continue;
            }
            if(num%s==0){
//                能整除
                flag++;
            }
        }
        if(flag>=1){
            return flag;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.divisorSubstrings(10, 2));
    }
}
