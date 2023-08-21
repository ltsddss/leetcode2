package com.lts;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class tt {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str=in.nextLine();
        String temp="";
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<str.length();i++){
            char j=str.charAt(i);
            if(j>=65&&j<=90||j>=97&&j<=122){
                // 大小写字符
                temp+=j;
                list.add(i);
            }
        }
        String result="";
        for(char c='a';c<='z';c++){
            for(int i=0;i<temp.length();i++){
                if(temp.charAt(i)==c||(temp.charAt(i)+"").equals((c+"").toUpperCase())){
                    result+=temp.charAt(i);
                }
            }
        }
        char[] resultStr=str.toCharArray();
        for(int i=0;i<list.size();i++){
            resultStr[list.get(i)]=result.charAt(i);
        }
        for(int i=0;i<str.length();i++){
            System.out.print(resultStr[i]);
        }
    }
}
