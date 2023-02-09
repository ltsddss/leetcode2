package com.lts.aa;

public class Solution {
    public boolean evaluateTree(TreeNode root) {
//        遍历所有的非叶子节点
        if(root.val==2){
            return evaluateTree(root.left)||evaluateTree(root.right);
        }else {
            return evaluateTree(root.left)&&evaluateTree(root.left);
        }

    }
}
