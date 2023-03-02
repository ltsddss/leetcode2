import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        ll(Arrays.asList("1","2","3","4"));
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTask<Long> forkJoin=new ForkJoin(0L,10_0000_0000L);

        ForkJoinTask<Long> submit = forkJoinPool.submit(forkJoin);


        Long aLong = submit.get();
        System.out.println(aLong);
    }

    public static void ll(List<String> list){

        String ss = list.stream().map(s -> s+",").collect(Collectors.joining());
        System.out.println(ss);
    }
}
