package ii;

//面试题 05.02. 二进制数转字符串
public class Solution {
    public String printBin(double num) {
        int[] temp=new int[32];
        for (int i = -1; i > -33; i--) {
            if(num>Math.pow(2,i)){
                num-=Math.pow(2,i);
                temp[Math.abs(i)-1]=1;
            }
            if(num==Math.pow(2,i)){
                temp[Math.abs(i)-1]=1;
                StringBuilder result=new StringBuilder("0.");
                for (int j = 0; j <= Math.abs(i)-1; j++) {
                    result.append(temp[j]);
                }
                return result.toString();
            }
        }
        return "ERROR";
    }
}
