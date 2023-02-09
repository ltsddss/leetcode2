package com.lts;

class Linklists{
    public Integer val;

    public Linklists next;

    public Linklists() {
    }

    public Linklists(Integer val, Linklists next) {
        this.val = val;
        this.next = next;
    }

    public Integer getVal() {
        return val;
    }

    public void setVal(Integer val) {
        this.val = val;
    }

    public Linklists getNext() {
        return next;
    }

    public void setNext(Linklists next) {
        this.next = next;
    }
}

class MyLinkedList {

    public Linklists res;
    public MyLinkedList() {
        res=new Linklists();

    }

    public int get(int index) {
        return 0;
    }

    public void addAtHead(Integer val) {
        res= new Linklists(val,res);
    }

    public void addAtTail(int val) {
        Linklists temp=res;
        while(res.next!=null){
            res=res.next;
        }
        res.next=new Linklists(val,null);
        res=temp;
    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }
}
public class Solution {

    public static void main(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();

        myLinkedList.addAtHead(1);

        myLinkedList.addAtHead(2);

        myLinkedList.addAtTail(3);
    }

}
