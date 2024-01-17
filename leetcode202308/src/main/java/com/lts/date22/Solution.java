package com.lts.date22;

import java.util.*;

public class Solution {
    //        剑指 Offer 03. 数组中重复的数字
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (null != map.get(num)) {
                return num;
            } else {
                map.put(num, 1);
            }
        }
        return -1;
    }

    //    剑指 Offer 04. 二维数组中的查找
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        for (int[] ints : matrix) {
            if (0 != ints.length && ints[0] <= target) {
                for (int anInt : ints) {
                    if (anInt == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //    剑指 Offer 05. 替换空格
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }

    //    剑指 Offer 06. 从尾到头打印链表
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (null != head) {
            stack.push(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; !stack.isEmpty(); i++) {
            result[i] = stack.pop();
        }
        return result;
    }

    //    剑指 Offer 07. 重建二叉树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        TODO: 一点思路没有
        return new TreeNode(1);
    }

    //    剑指 Offer 09. 用两个栈实现队列
    private Stack<Integer> stackHead = new Stack<>();
    private Stack<Integer> stackTail = new Stack<>();

    public void CQueue() {

    }

    public void appendTail(int value) {
        stackTail.add(value);
    }

    public int deleteHead() {
        if (!stackHead.isEmpty()) {
            return stackHead.pop();
        }
        if (null == stackHead.peek()) {
            while (null != stackTail.peek()) {
                stackHead.push(stackTail.pop());
            }
        }
        if (stackHead.isEmpty()) {
            return -1;
        }
        return stackHead.pop();
    }

    //    剑指 Offer 10- I. 斐波那契数列
    public int fib(int n) {
        return result(n) % 1000000007;
    }

    public int result(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    //    剑指 Offer 10- II. 青蛙跳台阶问题
    public int numWays(int n) {
//        和斐波那契数列相同
        return 0;
    }

    //    剑指 Offer 11. 旋转数组的最小数字
    public int minArray(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0];
    }
}
