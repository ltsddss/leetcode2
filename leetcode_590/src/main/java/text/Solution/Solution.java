package text.Solution;

import java.util.*;


 class ListNode {
   int val;
   ListNode next = null;
 }


public class Solution {
    /**
     *
     * @param head ListNode类 
     * @return ListNode类
     */
    public ListNode reverseList (ListNode head) {
        // write code here
        List<Integer> list=new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head=head.next;
        }
        ListNode res=new ListNode();
        ListNode result=res;

        for(int i=list.size()-1;i>=0;i--){
            ListNode tempp=new ListNode();
            tempp.val=list.get(i);
            res.next=tempp;
            res=tempp;
        }
        return result;
    }
}