package aa;

import java.util.ArrayList;
import java.util.List;

//剑指 Offer 55 - II. 平衡二叉树
public class Solution {
    List<TreeNode> list=new ArrayList<>();
    public boolean isBalanced(TreeNode root) {
//        前序遍历root
        isTrue(root);
        for (TreeNode treeNode : list) {
            if(Math.abs(high(treeNode.left)-high(treeNode.right))>1){
                return false;
            }
        }
        return true;
    }

    public void isTrue(TreeNode treeNode){
        if(null==treeNode){
            return;
        }
        list.add(treeNode);
        isTrue(treeNode.left);
        isTrue(treeNode.right);
    }

//    获取左右树的高度差值
    public int high(TreeNode treeNode){
        int h1;
        int h2;
        if(null==treeNode){
            return 0;
        }
        else {
            h1=high(treeNode.left);
            h2=high(treeNode.right);
        }

        return h1>h2?++h1:++h2;
    }

    public static void main(String[] args) {
        TreeNode treeNode=new TreeNode(3);
        treeNode.left=new TreeNode(9);
        treeNode.right=new TreeNode(20);
        treeNode.right.left=new TreeNode(15);
        treeNode.right.right=new TreeNode(7);
        Solution s=new Solution();

        System.out.println(s.isBalanced(treeNode));
    }

}
