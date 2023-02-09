package text.test;

class LinkQun{
    public int val;
    public LinkQun next;

    public LinkQun(){

    }

    public LinkQun(int val,LinkQun next){
        this.val=val;
        this.next=next;
    }
}

class Solution {

    public int findTheWinner(int n, int k) {

        // 建立环形链表，每次循环k次，到第k个节点的时候将next指向k+1的位置

        // 当去掉n-1个人的时候结束循环

        LinkQun head=new LinkQun();

        LinkQun temp=head;

        temp.val=1;

        if(k==1){
            return n;
        }
        // 构造链表
        for(int i=1;i<n;i++){
            LinkQun linkqun=new LinkQun();
            linkqun.val=i+1;
            head.next=linkqun;
            head=head.next;
        }
        // 环形链表
        head.next=temp;
        int temps=1;
        while(temp!=null){
            if(temps!=k-1){
                temps++;
                temp=temp.next;
                if(temp==temp.next){
                    break;
                }
            }
            else {
                temp.next=temp.next.next;
                temps=0;
            }
        }
        return temp.val;
    }

    public static void main(String[] args) {
        Solution s=new Solution();

        System.out.println(s.findTheWinner(3, 1));
    }
}
