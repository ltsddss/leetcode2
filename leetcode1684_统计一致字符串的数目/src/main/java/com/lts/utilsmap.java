package com.lts;

import java.util.Arrays;

public class utilsmap {
    public static int Solution1(int num1,int num2){
        return (num1-1)*4+num2;
    }
    public static int[] Solution2(int num2){
        int result1=num2%4;
        int result2=0;
        if(result1==0){
            result1=4;
            result2=num2/4;
        }
        else {result2=num2/4+1;}
        return new int[]{result2,result1};
    }
    public static void main(String[] args) {
        System.out.println(utilsmap.Solution1(1,1));
        System.out.println(utilsmap.Solution1(1,2));
        System.out.println(utilsmap.Solution1(1,3));
        System.out.println(utilsmap.Solution1(1,4));
        System.out.println(utilsmap.Solution1(2,1));
        System.out.println(utilsmap.Solution1(2,2));
        System.out.println(utilsmap.Solution1(2,3));
        System.out.println(utilsmap.Solution1(2,4));
        System.out.println(utilsmap.Solution1(3,1));
        System.out.println(utilsmap.Solution1(3,2));
        System.out.println(utilsmap.Solution1(3,3));
        System.out.println(utilsmap.Solution1(3,4));
        System.out.println(utilsmap.Solution1(4,1));
        System.out.println("&&&&&&&&&&&&&");
        System.out.println(Arrays.toString(utilsmap.Solution2(1)));
        System.out.println(Arrays.toString(utilsmap.Solution2(2)));
        System.out.println(Arrays.toString(utilsmap.Solution2(3)));
        System.out.println(Arrays.toString(utilsmap.Solution2(4)));
        System.out.println(Arrays.toString(utilsmap.Solution2(5)));
        System.out.println(Arrays.toString(utilsmap.Solution2(6)));
        System.out.println(Arrays.toString(utilsmap.Solution2(7)));
        System.out.println(Arrays.toString(utilsmap.Solution2(8)));
        System.out.println(Arrays.toString(utilsmap.Solution2(9)));
        System.out.println(Arrays.toString(utilsmap.Solution2(10)));
        System.out.println(Arrays.toString(utilsmap.Solution2(11)));
        System.out.println(Arrays.toString(utilsmap.Solution2(12)));
    }
}
