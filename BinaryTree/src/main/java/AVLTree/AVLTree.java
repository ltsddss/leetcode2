package AVLTree;

//  平衡二叉树
public class AVLTree {
    public static void main(String[] args) {
//        给定一个数组构造一颗平衡二叉树
        int[] sum=new int[]{2,5,3,7,5,8,9,1,2};
        AVLTree avlTree=new AVLTree();

        avlTree.CreateAVLTree(sum);
    }

    /**
     * 平衡二叉树的创建
     *
     * @param number 需要构造的二叉树值
     * @return 平衡二叉树
     */
    public TreeNode CreateAVLTree(int[] number) {
        TreeNode node=new TreeNode(number[0]);
        for (int i = 1; i < number.length; i++) {
            node.insertAVLTree(number[i]);
        }
        return node;
    }


}
