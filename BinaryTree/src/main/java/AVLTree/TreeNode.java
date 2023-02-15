package AVLTree;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TreeNode {
//    二叉树的值
    int val;
//    二叉树的左节点
    TreeNode leftNode;

//    二叉树的右节点
    TreeNode rightNode;

    public TreeNode(int val) {
        this.val = val;
    }

    //    左子树的高度
    public int leftHeight(){
        if(this.leftNode==null){
            return 0;
        }
        else {
            return this.leftNode.Height();
        }
    }
//    右子树高度
    public int rightHeight(){
        if(this.rightNode==null){
            return 0;
        }
        else {
            return this.rightNode.Height();
        }
    }
//    树高度
    public int Height(){
        return Math.max(leftNode==null?0:leftNode.Height(),rightNode==null?0:rightNode.Height())+1;
    }

//    左旋转
    public void leftRotate(){
//        以当前根节点的值创建一个新节点
        TreeNode node=new TreeNode(this.val);
//        把新节点的左子树设置为当前节点的左子树
        node.leftNode=this.leftNode;
//        把新节点的右子树设置为当前节点的右子树的左子树
        node.rightNode=this.rightNode.leftNode;
//        把当前节点的值设置为右子树的值
        this.val=this.rightNode.val;
//        把当前节点的右子树设置为右子树的右子树
        this.rightNode=this.rightNode.rightNode;
//        把当前节点的左子树设置为新节点
        this.leftNode=node;
    }

//    右旋转
    public void rightRotate(){
//        创建一个新节点，以根节点的值创建
        TreeNode node=new TreeNode(this.val);
//        把新节点的右子树设置为当前节点的右子树
        node.rightNode=this.rightNode;
//        把新节点的左子树设置为当前节点左子树的右子树
        node.leftNode=this.leftNode.rightNode;
//        把当前节点的值设置为左子节点的值
        this.val=this.leftNode.val;
//        把当前节点的左子树设置为左子树的左子树
        this.leftNode=this.leftNode.leftNode;
//        把当前节点的右子树设置为新节点
        this.rightNode=node;
    }

    /**
     * 平衡二叉树的插入
     *
     * @param number 需要插入的值
     * @return 1
     */
    public int insertAVLTree(int number) {

//        如果插入的节点的值大于当前节点的值
        if (this.val > number) {
//            判断当前节点的左子节点是否为null
            if (this.leftNode == null) {
//                插入到左子节点
                TreeNode node = new TreeNode();
                node.val = number;
                this.leftNode = node;
            } else {
//                递归插入到左子树
                this.leftNode.insertAVLTree( number);
            }
        } else {
            if (this.rightNode == null) {
                TreeNode node = new TreeNode();
                node.val = number;
                this.rightNode = node;
            } else {
                this.rightNode.insertAVLTree( number);
            }
        }

//        右子树比左子树高
        if(rightHeight()-leftHeight()>1){
//            右子树的左子树比右子树的右子树要高（右旋）
            if(rightNode.leftHeight()>rightNode.rightHeight()){
                this.rightNode.rightRotate();
            }
//            再左旋
            leftRotate();
            return 1;
        }

//            左子树比右子树高(右旋)
        if(leftHeight()-rightHeight()>1){
//            左子树的右子树的高度比左子树的左子树的高度大，则左旋
            if(this.leftNode.rightHeight()>this.leftNode.leftHeight()){
//                先左子树进行左旋
                this.leftNode.leftRotate();
            }
//            再右旋
            rightRotate();
        }

        return 1;
    }
}
