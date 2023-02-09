package text.test;

import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] a=sc.nextLine().split(",");

        int flag=0;
        for(int i=1;i<a.length;i++){
            if(Integer.parseInt(a[flag])>Integer.parseInt(a[i])){
                flag=i;
            }
        }

        System.out.println(flag);
    }
}