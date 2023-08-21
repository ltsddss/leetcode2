package xx;

import java.util.*;

public class Solution {

    public int minimizedStringLength(String s) {
        HashMap<Character,Integer> result=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            result.put(s.charAt(i),1);
        }
        return result.size();
    }

    public int semiOrderedPermutation(int[] nums) {

        int min=0;
        int max=0;
        int flag=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==1){
                min=i;
                flag++;
                if(flag==2){
                    break;
                }
            }
            if(nums[i]==nums.length){
                max=i;
                flag++;
                if(flag==2){
                    break;
                }
            }
        }

        if(min<max){
            return min+nums.length-max-1;
        }else {
            return min+nums.length-max-2;
        }
    }

    public long matrixSumQueries(int n, int[][] queries) {
        int[][] query=new int[n][n];
        long sum=0L;
        for (int[] ints : queries) {
            if(ints[0]==0){
//                0改行
                for (int i = 0; i < n; i++) {
                    query[ints[1]][i] = ints[2];
                }
            }else {
//                1改列
                for (int i = 0; i < n; i++) {
                    query[i][ints[1]]=ints[2];
                }
            }
        }
        for (int[] ints : query) {
            for (int anInt : ints) {
                sum+=anInt;
            }
        }
        return sum;
    }

    /**
     * 重排链表
     * @param head
     */
    public void reorderList(ListNode head) {
//        奇数序为原序，偶数序为倒叙，奇数个时少一，偶数则不变
        Stack<ListNode> stack=new Stack<>();
        ListNode temp=head;
        int sum=0;
        while(temp!=null){
            stack.push(temp);
            temp=temp.next;
            sum++;
        }
        ListNode deOrder=new ListNode();
        while (stack.peek()!=null){
            deOrder=stack.pop();
            deOrder=deOrder.next;
        }
        temp=head;
        ListNode acOrder=head;
        if(sum%2==0){
//            偶数个
            for (int i = 0; i <= sum/2; i++) {
                if(i%2==0){
                    temp.next=deOrder;
                }
                else {
                    temp.next=acOrder;
                }
                temp=temp.next;
                acOrder=acOrder.next;
                deOrder=deOrder.next;
            }
        }
    }

    /**
     * 删除注释
     */
    public List<String> removeComments(String[] source) {
        String s="/ssssss";
        return null;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        ListNode head=new ListNode();
        ListNode temp=head;
        head.val=1;
        head.next=new ListNode();
        head=head.next;
        head.val=2;
        head.next=new ListNode();
        head=head.next;
        head.val=3;
        head.next=new ListNode();
        head=head.next;
        head.val=4;
        s.reorderList(temp);
    }
}
