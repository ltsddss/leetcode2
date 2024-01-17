package com.lts.date24;

import java.util.*;

public class Solution {
    Map<String, Integer> map = new HashMap<>();

    public int countServers(int[][] grid) {
//        grid
        for (int i = 0; i < grid.length; i++) {
            getLinks(grid, i, 'x');
        }
        for (int i = 0; i < grid[0].length; i++) {
            getLinks(grid, i, 'y');
        }
        return map.size();
    }

    public void getLinks(int[][] grid, int i, char flag) {
//      获取grid中的1数量大于2的数组
        int index = 0;
        String temp = "";
        if (flag == 'x') {
//            表示横向
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    if (index == 0) {
                        index++;
                        temp = "(" + i + "," + j + ")";
                    } else {
                        if (index == 1) {
                            map.put(temp, 0);
                            index++;
                        }
                        map.put("(" + i + "," + j + ")", 0);
                    }
                }
            }
        }
        if (flag == 'y') {
//            表示纵向
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    if (index == 0) {
                        index++;
                        temp = "(" + j + "," + i + ")";
                    } else {
                        if (index == 1) {
                            map.put(temp, 0);
                            index++;
                        }
                        map.put("(" + j + "," + i + ")", 0);
                    }
                }
            }
        }
    }


    //    剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
    public int[] exchange(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 1) {
                list.add(num);
            }
        }
        for (int num : nums) {
            if (num % 2 == 0) {
                list.add(num);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    //剑指 Offer 22. 链表中倒数第k个节点
    public ListNode getKthFromEnd(ListNode head, int k) {
        int index = 0;
        ListNode listNode = head;
        while (listNode != null) {
            index++;
            listNode = listNode.next;
        }

        for (int i = 0; i < index - k + 1; i++) {
            if (i == index - k) {
                return head;
            } else {
                head = head.next;
            }
        }
        return null;
    }

    //    剑指 Offer 24. 反转链表 LCOF
    public ListNode reverseList(ListNode head) {
        if (null == head) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();

        while (null != head) {
            stack.add(head);
            head = head.next;
        }
        ListNode temp = stack.pop();
        ListNode result = temp;
        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }
        temp.next = null;
        return result;
    }

    //   剑指 Offer 31. 栈的压入、弹出序列
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, j = 0; i < pushed.length && j < popped.length; i++) {
            if (pushed[i] != popped[j]) {
                stack.push(pushed[i]);
            } else {
                j++;
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
        }
        return stack.isEmpty();
    }

    //    剑指 Offer 32 - I. 从上到下打印二叉树
    public int[] levelOrder(TreeNode root) {
        if (null == root) {
            return new int[0];
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (null != node.left) {
                queue.add(node.left);
            }
            if (null != node.right) {
                queue.add(node.right);
            }

            list.add(node.val);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    //    2828. 判别首字母缩略词
    public boolean isAcronym(List<String> words, String s) {
        if (s.length() == words.size()) {
            for (int i = 0; i < words.size(); i++) {
                if (s.charAt(i) != words.get(i).charAt(0)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    //    2829. k-avoiding 数组的最小总和
    public int minimumSum(int n, int k) {
        int temp = k / 2 + 1;
        int result = 0;
        int index = k;
        int s = 0;
        for (int i = 0; i < n; i++) {
            if ((i + 1) >= temp && (i + 1) < k) {
                result += index;
                index++;
                s++;
                continue;
            }
            result += i + s + 1;
        }
        return result;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumSum(2, 6));
    }
}
