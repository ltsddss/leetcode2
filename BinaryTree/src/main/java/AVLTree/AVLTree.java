package AVLTree;

//  平衡二叉树
public class AVLTree {
    public static void main(String[] args) {
//        给定一个数组构造一颗平衡二叉树
        int[] sum=new int[]{2,3,4,6,8,9,11,34,55,77,10};
        AVLTree avlTree=new AVLTree();
        TreeNode node = avlTree.CreateAVLTree(sum);
//        System.out.println(avlTree.select(node, 3));

        System.out.println(node.selectMin());
    }

    /**
     * 给定一棵各个节点均不相同的二叉树，查找指定值的节点，返回该节点
     * @param root 根节点
     * @param num 要删除的值
     * @return 根节点
     */
    public TreeNode select(TreeNode root,int num){
        if(root.val==num){
            return root;
        }
        else if(root.val<num){
//            num在右节点
            return select(root.rightNode,num);
        }
        else {
            return select(root.leftNode,num);
        }
    }

    /**
     * 给定一棵各个节点均不相同的二叉树，删除指定值的节点，使二叉树依旧是平衡二叉树
     * @param root 根节点
     * @param num 要删除的值
     * @return 根节点
     */
    public int Delete(TreeNode root,int num){
//            root即为需要被删除的节点
        if(root.val==num){
//            当删除的节点是叶子节点
            if(root.rightNode==null&&root.leftNode==null){
                root=null;
            }
            else if(root.leftNode!=null||root.rightNode!=null){
                if(root.leftNode!=null&&root.rightNode!=null){
//                    有两颗子树(将当前节点的值设置为右子树的最小值)
                }
                else {
//                    只有一颗子树
                }
            }
        }
        else if(root.val<num){
//            在右子树
            Delete(root.rightNode,num);
        }
        else {
            Delete(root.leftNode,num);
        }
        return num;
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
