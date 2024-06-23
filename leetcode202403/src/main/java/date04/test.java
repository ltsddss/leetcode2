package date04;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class test {

    public static void main(String[] args) {
        test test=new test();
        System.out.println(test.test());
    }

    public String  test() {
        myPeople myPeople=new myPeople();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),//线程等待的最大数量
                Executors.defaultThreadFactory(),//默认线程工厂
                //第一种拒绝策略，抛出异常
                new ThreadPoolExecutor.DiscardOldestPolicy()//等待队列满了,就会和最早进入线程池的线程进行竞争，如果竞争成功就成功，失败就抛弃任务，不会抛出异常，是DiscardPolicy的一种优化策略
        );
        try{
            threadPoolExecutor.execute(()->{
                for (int i = 0; i < 100; i++) {
                    System.out.println(Thread.currentThread().getName()+" "+myPeople.getPeopleNumber());
                }

            });
        }finally {
            threadPoolExecutor.shutdown();
        }


        return Thread.currentThread().getName();
    }
}

class myPeople{
    public int index;

    myPeople(){}
    public int getPeopleNumber(){
        return ++index;
    }
}
