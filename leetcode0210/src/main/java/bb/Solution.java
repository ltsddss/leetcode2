package bb;

//1234. 替换子串得到平衡字符串
// TODO: 待修改，37/40个用例
public class Solution {
    public int balancedString(String s) {
//        找到s串的中各个类型字母的数量，然后维护一个最小的滑动窗口，让滑动窗口外的字符符合要求

        int len=s.length()/4;

        int[] sArray=new int[4];
        int qn=0;
        int wn=0;
        int en=0;
        int rn=0;

//        计算字符串中的各个字符的数量
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='Q'){
                sArray[0]++;
            }
            else if(s.charAt(i)=='W'){
                sArray[1]++;
            }
            else if(s.charAt(i)=='E'){
                sArray[2]++;
            }
            else {
                sArray[3]++;
            }
        }
        qn=sArray[0];
        wn=sArray[1];
        en=sArray[2];
        rn=sArray[3];
        if(check(sArray,len)){
            return 0;
        }

//        维护最小的滑动窗口实现最少的字符替换
        int result=Integer.MAX_VALUE;
        for (int l = 0; l < s.length()-1; l++) {
            int r=0;
            while (l+r<s.length()){
                if(r>0){
                    char temp= s.charAt(l+r-1);
//            将对应的值减1
                    if(temp=='Q'){
                        sArray[0]--;
                    }
                    else if(temp=='W'){
                        sArray[1]--;
                    }
                    else if(temp=='E'){
                        sArray[2]--;
                    }
                    else {
                        sArray[3]--;
                    }
                }
                if(check(sArray,len)){
                    result=Math.min(result,r);
                    break;
                }
                r++;
            }
            sArray[0]=qn;
            sArray[1]=wn;
            sArray[2]=en;
            sArray[3]=rn;
        }

        return result;
    }

    public Boolean check(int[] c,int d){
//        只有在滑动窗口之外的字符串中各个字符的数量都小于s的长度除以4的时候才可能平衡
        if(c[0]<=d&&c[1]<=d&&c[2]<=d&&c[3]<=d){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.balancedString("WQWRQQQW"));
    }
}
