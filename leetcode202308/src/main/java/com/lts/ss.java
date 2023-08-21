package com.lts;

import java.util.Scanner;

public class ss {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            isTure(in.nextLine());
        }
    }

    public static void isTure(String str){
        int index0=0;
        int index1=0;
        int index2=0;
        int index3=0;
        if(str.length()<=8){
            System.out.println("NG");
        }
        for(int i=0;i<str.length();i++){
            char j=str.charAt(i);
            if(j>=48&&j<=57){
                // 数字
                index0++;
            }
            else if(j>=65&&j<=90){
                // 大写字母
                index1++;
            }
            else if(j>=97&&j<=122){
                // 小写字符
                index2++;
            }
            else{
                // 其他字符
                index3++;
            }
        }
        int temp0=(index0!=0?1:0)+(index1!=0?1:0)+(index2!=0?1:0)+(index3!=0?1:0);
        if(temp0>=3){
            // 至少三种符号
            for(int i=0;i<str.length()-3;i++){
                if(str.lastIndexOf(str.substring(i,i+3))!=i){
                    System.out.println("NG");
                    return;
                }
            }
            System.out.println("OK");
            return;
        }
        System.out.println("NG");

    }
}
