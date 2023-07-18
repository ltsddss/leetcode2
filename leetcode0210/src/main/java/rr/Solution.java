package rr;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
//TODO 超时
public class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

//        构造优先级队列
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1]-o1[0]+1)-(o2[1]-o2[0]+1);
            }
        });
        queue.addAll(Arrays.asList(intervals));
//        PriorityQueue<int[]> temp=new PriorityQueue<>();
        int[] result=new int[queries.length];
        Arrays.fill(result,-1);
        for (int i = 0; i < queries.length; i++) {
            PriorityQueue<int[]> temp=new PriorityQueue<>(queue);
            while (null!=temp.peek()){
                if(queries[i]>=temp.peek()[0]&&queries[i]<=temp.peek()[1]){
                    result[i]=temp.peek()[1]-temp.peek()[0]+1;
                    break;
                }
                else {
                    temp.poll();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(Arrays.toString(s.minInterval(new int[][]{{1, 4}, {2, 4}, {3, 6}, {4, 4}}, new int[]{2, 3, 4, 5})));
    }
}
