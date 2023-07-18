package nn;

public class Solution {
    public String addStrings(String num1, String num2) {
        String result="";
        if(num1.length()>=num2.length()){
//            定义进位
            int up=0;
//            移动指针
            int j=1;
            for (int i = num2.length()-1; i >= 0; i--,j++) {
                int temp=Character.getNumericValue(num1.charAt(num1.length()-j))+Character.getNumericValue( num2.charAt(i))+up;
                if(temp>=10){
//                    加法产生进位只可能是1
                    up=1;
                }
                else {
                    up=0;
                }
                result=(temp%10)+result;
            }
            return up==1?(addStrings(num1.substring(0,num1.length()-num2.length()),"1")+result):(num1.substring(0,num1.length()-num2.length())+result);
        }
        else {
            return addStrings(num2,num1);
        }
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.addStrings("99999", "10"));
    }
}
