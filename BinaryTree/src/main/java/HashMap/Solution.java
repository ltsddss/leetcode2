package HashMap;

import java.util.HashMap;
import java.util.Hashtable;

//测试hashMap是否是线程安全的
public class Solution {

    public static void main(String[] args) {
//        创建4个线程，尝试同时向map中添加数值

        Hashtable<String,String> map=new Hashtable<>();

        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                map.put(Thread.currentThread().getName(), Thread.currentThread().toString());
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 1000; i++) {
                map.put(Thread.currentThread().getName(),Thread.currentThread().toString());
            }
        }).start();

        map.forEach((key,value)->{
            System.out.println(key+"  "+value);
        });
    }
}
