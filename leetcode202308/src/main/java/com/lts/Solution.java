package com.lts;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static int[] result = new int[7];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String[] str = in.nextLine().split("~");
            if(isYM(str[1])){
                isIP(str[0]);
            }
        }
        for (int j : result) {
            System.out.print(j + " ");
        }
    }

    public static Boolean isYM(String str) {
        // 判断给的字符串是否是正确的子网掩码
        String[] s = str.split("\\.");
        String temp = "";
        for (int i = 0; i < s.length; i++) {
            String tt=Integer.toBinaryString(Integer.parseInt(s[i]));
            while (tt.length()<8){
                tt="0"+tt;
            }
            temp+=tt;
        }
        Pattern r = Pattern.compile("1+0+");
        Matcher m = r.matcher(temp);
        if (m.matches()) {
            return true;
        } else {
            result[5]++;
            return false;
        }
    }

    public static void isIP(String str) {
        // 判断ip地址的类型以及正确性
        String[] s = str.split("\\.");
        // 判断格式是否正确
        for (int i = 0; i < s.length; i++) {
            if (s[i].equals("")) {
                result[5]++;
                return;
            }
        }
        int temp0 = Integer.parseInt(s[0]);
        int temp1 = Integer.parseInt(s[1]);
        int temp2 = Integer.parseInt(s[2]);
        int temp3 = Integer.parseInt(s[3]);
        if (temp0 == 0 || temp0 == 127) {
            // 不属于任何一类
            return;
        }
        if (temp0 == 10) {
            // 10私网
            if (temp1 >= 0 && temp1 <= 255 && temp2 >= 0 && temp2 <= 255 && temp3 >= 0 && temp3 <= 255) {
                result[6]++;
                result[0]++;
                return;
            } else {
                result[5]++;
                return;
            }
        }
        if((temp0 == 192 && temp1 == 168)){
            // 10私网
            if (temp2 >= 0 && temp2 <= 255 && temp3 >= 0 && temp3 <= 255) {
                result[6]++;
                result[2]++;
                return;
            } else {
                result[5]++;
                return;
            }
        }
        if (temp0 == 172) {
            // 172网段
            if (temp1 >= 16 && temp1 <= 31) {
                if (temp2 >= 0 && temp2 <= 255 && temp3 >= 0 && temp3 <= 255) {
                    result[6]++;
                    result[1]++;
                    return;
                } else {
                    result[5]++;
                    return;
                }
            } else {
                result[5]++;
                return;
            }
        }
        if (temp0 >= 1 && temp0 <= 126) {
            // A类
            if (temp1 >= 0 && temp1 <= 255 && temp2 >= 0 && temp2 <= 255 && temp3 >= 0 && temp3 <= 255) {
                result[0]++;
                return;
            } else {
                result[5]++;
                return;
            }
        }
        if (temp0 >= 128 && temp0 <= 191) {
            // B类
            if (temp1 >= 0 && temp1 <= 255 && temp2 >= 0 && temp2 <= 255 && temp3 >= 0 && temp3 <= 255) {
                result[1]++;
                return;
            } else {
                result[5]++;
                return;
            }
        }
        if (temp0 >= 192 && temp0 <= 223) {
            // C类
            if (temp1 >= 0 && temp1 <= 255 && temp2 >= 0 && temp2 <= 255 && temp3 >= 0 && temp3 <= 255) {
                result[2]++;
                return;
            } else {
                result[5]++;
                return;
            }
        }
        if (temp0 >= 224 && temp0 <= 239) {
            // D类
            if (temp1 >= 0 && temp1 <= 255 && temp2 >= 0 && temp2 <= 255 && temp3 >= 0 && temp3 <= 255) {
                result[3]++;
                return;
            } else {
                result[5]++;
                return;
            }
        }
        if (temp0 >= 240 && temp0 <= 255) {
            // E类
            if (temp1 >= 0 && temp1 <= 255 && temp2 >= 0 && temp2 <= 255 && temp3 >= 0 && temp3 <= 255) {
                result[4]++;
                return;
            } else {
                result[5]++;
                return;
            }
        }
        result[5]++;
        return;
    }
}
