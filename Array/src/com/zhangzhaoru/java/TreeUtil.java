package com.zhangzhaoru.java;

import java.util.ArrayList;
import java.util.Queue;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/5/27 9:16 上午
 * @Description:
 */
public class TreeUtil {
    //    重建二叉树
    public static TreeNode rebuildBinaryTree(int pre[], int in[]) {
        if (pre == null || in == null) {
            return null;
        }
        return rebuildTreeDsp(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public static TreeNode rebuildTreeDsp(int[] pre, int preLeft, int preRight,
                                          int[] in, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        int i;
        for (i = inLeft; i <= inRight; i++) {
            if (in[i] == pre[preLeft]) {
                break;
            }
        }
        root.left = rebuildTreeDsp(pre, preLeft + 1, preLeft + (i - inLeft), in, inLeft, i - 1);
        root.right = rebuildTreeDsp(pre, (i - inLeft)
                + preLeft + 1, preRight, in, i + 1, inRight);
        return root;
    }


    // 判断tree2是否为tree1的子树
    public static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return dspHasubTree(root1, root2) || hasSubtree(root1.left, root2) ||
                hasSubtree(root1.right, root2);
    }

    public static boolean dspHasubTree(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null) {
            return false;
        }
        if (rightNode == null) {
            return true;
        }

        if (leftNode.val != rightNode.val) {
            return false;
        }
        return dspHasubTree(leftNode.left, rightNode.left) &&
                dspHasubTree(leftNode.right, rightNode.right);
    }


    public static TreeNode Mirror(TreeNode pHead) {
        if (pHead == null || (pHead.left == null && pHead.right == null)) {
            return pHead;
        }
        return dspMirror(pHead);
    }

    public static TreeNode dspMirror(TreeNode pHead) {
        if (pHead == null || (pHead.left == null && pHead.right == null)) {
            return pHead;
        }
        TreeNode tempNode = pHead.left;
        pHead.left = pHead.right;
        pHead.right = tempNode;
        dspMirror(pHead.left);
        dspMirror(pHead.right);
        return pHead;
    }

    // 借助队列层序遍历二叉树
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.remove();
            res.add(curNode.val);
            if(curNode.left!=null){
                queue.add(curNode.left);
            }
            if(curNode.right!=null){
                queue.add(curNode.right);
            }
        }
        return res;
    }
}
