package ss;

public class Solution {
    public String longestPalindrome(String s) {
//        特殊情况
        if(s.length()<=2){
            return s;
        }
        int max=0;
        int begin=0;
//        构建表格
        boolean[][] result=new boolean[s.length()][s.length()];
        for (int j = 0; j < result.length; j++) {
            for (int i = 0; i<=j; i++) {
                if(!(s.charAt(i) ==s.charAt(j))){
                    result[i][j]=false;
                }else {
                    if(j-i<3|| result[i + 1][j - 1]){
                        result[i][j]=true;
                        if(max<(j-i+1)){
                            max=j-i+1;
                            begin=i;
                        }
                    }
                }
            }
        }
        return s.substring(begin,begin+max);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.longestPalindrome("babadabad"));
    }
}
