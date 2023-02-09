package com.lts.ss;

public class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
//        头同尾不同，则需要插入尾部
//        头不同尾同，则需要插入头部
//        头尾均相同,则需要插入中间
//        头尾均不同,则为false
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if(s1.length==1&&s2.length==1){
            return sentence1.equals(sentence2);
        }
        if(s1.length>s2.length){
//            s2是需要被插入的
            if(s1[0].equals(s2[0])){
                if(s1[s1.length-1].equals(s2[s2.length-1])){
//                    头尾均相同(判断中间是否是连续的单词)
                    String temp1=sentence1.substring(s1[0].length()-1,sentence1.length()-s1[s1.length-1].length());
                    String temp2=sentence2.substring(s2[0].length()-1,sentence2.length()-s2[s2.length-1].length());
                    if(!temp1.contains(temp2)){
                        return areSentencesSimilar(temp1,temp2);
                    }
                    else {
                        return true;
                    }
                }
                else {
//                    头相同尾不同
                    sentence2+=" ";
                    return sentence1.contains(sentence2);
                }
            }
            else {
//                头不同
                if(s1[s1.length-1].equals(s2[s2.length-1])){
//                    尾相同
                    return sentence1.contains(sentence2);
                }
                else {
//                   尾也不同
                    return false;
                }
            }
        }
        else if(s1.length<s2.length){
            return areSentencesSimilar(sentence2,sentence1);
        }
        else {
            return sentence1.equals(sentence2);
        }
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.areSentencesSimilar("Aa AAaAaaAaaaAaAAaAA aaaAaAaAAaAaaAA", "Aa AA"));
    }
}
