package com.lts;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ces {
    public static void main(String[] args) {
        String str = "11111111000000000000000000000000";
        String pattern = "1+0+";

        Pattern r = Pattern.compile("[a-z]");
        Matcher m = r.matcher(str);
        System.out.println(m.matches());
    }
}
