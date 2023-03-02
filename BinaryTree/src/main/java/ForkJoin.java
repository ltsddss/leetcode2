import java.util.concurrent.RecursiveTask;

public class ForkJoin extends RecursiveTask<Long> {

    Long start;
    Long end;

    public ForkJoin(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {

        if(end-start<10000){
            Long sum=0L;
            for (Long i = start; i < end; i++) {
                sum+=i;
            }
            return sum;
        }
        else {
            Long mid=(end-start)/2;
            ForkJoin forkJoin=new ForkJoin(start,mid);
            forkJoin.fork();
            ForkJoin forkJoin1=new ForkJoin(mid+1,end);
            forkJoin1.fork();
            return forkJoin.join()+forkJoin1.join();
        }
    }
}
