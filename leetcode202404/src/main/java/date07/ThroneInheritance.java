package date07;

import java.util.ArrayList;
import java.util.List;
//1600. 王位继承顺序
public class ThroneInheritance {
    private ListNode head;
    private ListNode node;
    public ThroneInheritance(String kingName) {
//        初始化
        head=new ListNode("",kingName,new ListNode());
        node=head;
    }

    public void birth(String parentName, String childName) {
//        重置指向
        node=head;
        int flag=0;
        while (null!=node.getNext()){
            if(node.getNext().getParentName().equals(parentName)){
                node=node.getNext();
            }else {
                ListNode temp=new ListNode(parentName,childName,node.getNext());
                node.setNext(temp);
                flag=1;
                break;
            }
        }
//        flag==0时，直接插入尾部
        if(flag==0){
            ListNode temp=new ListNode(parentName,childName,new ListNode());
            node.setNext(temp);
        }

    }

    public void death(String name) {
//        重置指向
        node=head;
//        遍历删除节点
        int flag=0;
        while (null!=node.getNext()){
            if(node.getNext().getCurrentName().equals(name)){
                node.setNext(node.getNext().getNext());
                flag=1;
                break;
            }else {
                node=node.getNext();
            }
        }
//        flag==0时，直接删除尾节点
        if(flag==0){
            node.setNext(null);
        }
    }

    public List<String> getInheritanceOrder() {
        List<String> result=new ArrayList<>();
        node=head;
        while (null!=node){
            result.add(node.getCurrentName());
            node=node.getNext();
        }
        return result;
    }
}
class ListNode{
    private String parentName;
    private String currentName;
    private ListNode next;

    public ListNode() {
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getCurrentName() {
        return currentName;
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public ListNode(String parentName, String currentName, ListNode next) {
        this.parentName = parentName;
        this.currentName = currentName;
        this.next = next;
    }
}
