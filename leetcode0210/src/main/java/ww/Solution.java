package ww;

public class Solution {
    public String smallestString(String s) {
        if(s.equals("a")){
            return "z";
        }
//        找到a的位置
        int index=s.indexOf('a');
        if(index!=-1){
//            有a
            if(index==0){
//                a在开头
//                跳过a到非a字母处
                String temp="";
                while (index<(s.length()-1)&&s.charAt(index)=='a'){
                    index++;
                }
                return s.substring(0,index)+smallestString(s.substring(index));
            }else {
                String temp=s.substring(0,index);
                return s.replaceFirst(temp,replase(temp));
            }
        }
        else {
            return replase(s);
        }
    }

    public String replase(String s){
        char[] array = s.toCharArray();
        for (int i = 0; i < array.length; i++) {
            array[i]=--array[i];
        }
        return new String(array);
    }

    public static void main(String[] args) {
        Solution solution=new Solution();

        System.out.println(solution.smallestString("zzzzzzzzzzz"));
    }
}
