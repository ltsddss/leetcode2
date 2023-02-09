package com.lts;
import javafx.concurrent.WorkerStateEvent;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        // 设计一个大顶堆，将前k个人的工作质量与期望薪资最小的比，然后通过大顶堆将每一个工作质量进行判断
        Worker[] workers=new Worker[quality.length];

        for (int i = 0; i < quality.length; i++) {
            workers[i]=new Worker(quality[i],wage[i]);
        }

        Arrays.sort(workers);

//        遍历workers，将对应的worders存入一个大顶堆
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();

        int sump=0;

        double ans=1e9;
        for (Worker worker : workers) {
            priorityQueue.offer(-worker.quality);
            sump+=worker.quality;
//           大顶堆的数量达到预期，尝试
            if(priorityQueue.size()>k){
                sump+=priorityQueue.poll();
            }
            if(priorityQueue.size()==k){
                ans= Math.min(ans,sump*worker.ratio());
            }
        }

        return ans;
    }
}

class Worker implements Comparable<Worker>{

    public int quality;

    public int wage;

    public Worker(int quality, int wage) {
        this.quality = quality;
        this.wage = wage;
    }

    public double ratio(){
        return (double) wage/quality;
    }

    @Override
    public int compareTo(Worker o) {
        return Double.compare(ratio(),o.ratio());
    }
}
