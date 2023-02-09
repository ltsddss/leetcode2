package com.lts;

import java.util.*;

//TODO
public class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> stack=new Stack<>();

        Queue<Integer> queue=new LinkedList<>();

        for (int i = sandwiches.length-1; i >=0; i--) {
            stack.push(sandwiches[i]);
        }
        for (int i = 0; i < students.length; i++) {
            queue.add(students[i]);
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.countStudents(new int[]{1,1,1,0,0,1}, new int[]{1,0,0,0,1,1}));
    }
}
