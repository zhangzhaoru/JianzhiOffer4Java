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
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

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
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
        return res;
    }


    // 查找二叉树中和为某值的路径
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        ArrayList<Integer> path = new ArrayList<>();
        dspFindPath(root, target, path);
        return res;
    }

    public void dspFindPath(TreeNode root, int target, ArrayList<Integer> path) {
        if (root == null || target < 0) {
            return;
        }
        if (root.val == target && root.right == null && root.right == null) {
            path.add(root.val);
            res.add(path);
            return;
        }
        path.add(root.val);
        ArrayList<Integer> clone = (ArrayList<Integer>) path.clone();
        dspFindPath(root.left, target - root.val, path);
        dspFindPath(root.right, target - root.val, clone);
    }

    // 获取二叉树的深度
    public static int TreeDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth=0;
        int rightDepth=0;
        return dspTreeDepth(root);
    }

    public static int dspTreeDepth(TreeNode curNode){
        if(curNode==null){
            return 0;
        }
        if(curNode.left==null&&curNode.right==null){
            return 1;
        }
        return Math.max(dspTreeDepth(curNode.left),dspTreeDepth(curNode.right))+1;
    }

    // 判断二叉树是否为平衡二叉树
    public static boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
        return dspBanlancedTree(root);
    }

    public static Boolean dspBanlancedTree(TreeNode curNode){
        if(curNode==null){
            return true;
        }
        if (curNode.right == null && curNode.left == null) {
            return true;
        }
        return (Math.abs(TreeDepth(curNode.left) - TreeDepth(curNode.right))) > 1 ? false : true;
    }

    private static ArrayList<TreeLinkNode> list = new ArrayList<>();

    // 查找二叉树的下一个节点
    public static TreeLinkNode GetNext(TreeLinkNode pNode) {
        TreeLinkNode root = pNode;
        // 查找当前节点的根节点
        while (root.next != null) {
            root = root.next;
        }
        inOrder4LinkTree(root);
        int i = 0;
        for (; i < list.size(); i++) {
            if (list.get(i) == pNode) {
                break;
            }
        }
        if (i + 1 < list.size()) {
            return list.get(i + 1);
        }
        return null;
    }

    public static void inOrder4LinkTree(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        inOrder4LinkTree(root.left);
        list.add(root);
        inOrder4LinkTree(root.right);
    }





}
