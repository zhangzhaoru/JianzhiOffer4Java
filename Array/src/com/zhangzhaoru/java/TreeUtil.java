package com.zhangzhaoru.java;

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
}
