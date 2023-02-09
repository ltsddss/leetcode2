package com.lts.main.lts;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    public int getKthMagicNumber(int k) {
//        用最小堆实现
        int[] fig=new int[]{3,5,7};

        Set<Long> set=new HashSet<>();

        PriorityQueue<Long> priorityQueue=new PriorityQueue<>();

        priorityQueue.offer(1L);

        for (int i = 0; i < k; i++) {

        }

        return 1;
    }
}
