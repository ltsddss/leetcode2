package date04;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //    1038. 从二叉搜索树到更大和树
    public int sum;
    /**
     * 将左子树所有的节点加在当前节点
     * @param root
     * @return
     */
    public TreeNode bstToGst(TreeNode root) {
        if (null!=root) {
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }

    //2951. 找出峰值

    /**
     * 给你一个下标从 0 开始的数组 mountain 。你的任务是找出数组 mountain 中的所有 峰值。
     *
     * 以数组形式返回给定数组中 峰值 的下标，顺序不限 。
     *
     * 注意：
     *
     * 峰值 是指一个严格大于其相邻元素的元素。
     * 数组的第一个和最后一个元素 不 是峰值。
     * @param mountain
     * @return
     */
    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> result=new ArrayList<>();
        for (int i = 1; i < mountain.length-1; i++) {
            if(mountain[i]>mountain[i-1]&&mountain[i]>mountain[i+1]){
                result.add(i);
            }
        }
        return result;
    }

//    2952. 需要添加的硬币的最小数量

    /**
     * 给你一个下标从 0 开始的整数数组 coins，表示可用的硬币的面值，以及一个整数 target 。
     *
     * 如果存在某个 coins 的子序列总和为 x，那么整数 x 就是一个 可取得的金额 。
     *
     * 返回需要添加到数组中的 任意面值 硬币的 最小数量 ，使范围 [1, target] 内的每个整数都属于 可取得的金额 。
     *
     * 数组的 子序列 是通过删除原始数组的一些（可能不删除）元素而形成的新的 非空 数组，删除过程不会改变剩余元素的相对位置。
     * @param coins
     * @param target
     * @return
     */
    public int minimumAddedCoins(int[] coins, int target) {
        return 0;
    }

    public static void main(String[] args) {

    }
}
