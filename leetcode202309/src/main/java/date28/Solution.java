package date28;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //    2864. 最大二进制奇数
    public static String maximumOddBinaryNumber(String s) {
//        判断s中存在多少个1，将其中一个放在结尾，其他的放在前面
        int one=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                one++;
            }
        }
        if(one>1){
            String prof="";
            for (int i = 0; i < one-1; i++) {
                prof+="1";
            }
            String last="";
            for (int i = 0; i < s.length()-one; i++) {
                last+="0";
            }
            return prof+last+"1";
        }else {
            String last="";
            for (int i = 0; i < s.length()-one; i++) {
                last+="0";
            }
            return last+"1";
        }
    }

//    2865. 美丽塔 I
    public static long maximumSumOfHeights(List<Integer> maxHeights) {
//        找到数组中最大值的下标，分别向两边遍历找到当前的最大山状数组
        int max;
        long result=0;
        for (int i = 0; i < maxHeights.size(); i++) {
            max=maxHeights.get(i);
            long value=getMax(i,max,maxHeights);
            result= Math.max(result, value);

        }
        return result;
    }

    public static Long getMax(int index,int max,List<Integer> maxHeights){
        long result=max;
        int min=max;
        for (int i = index+1; i < maxHeights.size(); i++) {
            if(min>maxHeights.get(i)){
                min=maxHeights.get(i);
            }
            result+=min;
        }
        min=max;
        for (int i = index-1; i >=0; i--) {
            if(min>maxHeights.get(i)){
                min=maxHeights.get(i);
            }
            result+=min;
        }
        return result;
    }

    //2859. 计算 K 置位下标对应元素的和
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
//        判断二进制1的个数
        int result=0;
        for (int i = 0; i < nums.size(); i++) {
            if(getOneNumber(Integer.toBinaryString(i))==k){
                result+=nums.get(i);
            }
        }
        return result;
    }

    public Integer getOneNumber(String s){
        int one=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='1'){
                one++;
            }
        }
        return one;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
//        [3,6,3,5,5,1,2,5,5,6]
        list.add(3);
        list.add(6);
        list.add(3);
        list.add(5);
        list.add(5);
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(5);
        list.add(6);
        System.out.println(maximumSumOfHeights(list));
    }
}
