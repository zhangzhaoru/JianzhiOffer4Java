package com.zhangzhaoru.java;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/5/29 4:30 下午
 * @Description: 二叉搜索树
 */
public class BinarySortTree {
    private TreeNode root;

    public void insert(int data) {
        TreeNode newNode = new TreeNode();
        newNode.val = data;
        if (root == null) {
            //如果是第一个节点，也就是根节点为null,直接创建一个新的节点即可　
            root = newNode;
        } else {
            TreeNode current = root;
            //current节点的父节点
            TreeNode parent;
            //循环查找插入的位置
            while (true) {
                parent = current;
                //如果插入的值小于当前节点的值，从左子树查找
                if (data < current.val) {
                    current = current.left;
                    //直到当前节点为null
                    if (current == null) {
                        //设置当前节点的父节点的左子节点为新创建的节点
                        parent.left = newNode;
                        return;
                    }

                }
                //如果插入的值大于当前节点的值，从左子树查找
                else {
                    current = current.right;
                    //直到当前节点为null
                    if (current == null) {
                        //设置当前节点的父节点的右子节点为新创建的节点
                        parent.right = newNode;
                        return;
                    }
                }
            }// end of while(true)
        }
    }

    public TreeNode find(int value) {

        TreeNode current = root;

        while (current.val != value) {

            if (value < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
            if (current == null) {
                return null;
            }
        }

        return current;
    }

    public boolean delete(int value) {

        TreeNode current = root;
        TreeNode parent = root;
        boolean isLeft = false;
        boolean isRight = false;
        //查找所要删除的节点的左子节点还是右子节点
        while (current.val != value) {
            parent = current;
            isLeft = false;
            isRight = false;
            if (value < current.val) {
                current = current.left;
                isLeft = true;
            } else {
                current = current.right;
                isRight = true;
            }
        }
        //不存在该值
        if (current == null) {
            return false;
        }
        //是叶子节点，不存在子节点
        if ((current.left == null)
                && (current.right == null)) {
            System.out.println("是叶子节点，不存在子节点");
            if (isLeft) {
                //如果是左子节点，设父节点的左子节点为null
                parent.left = null;
            } else if (isRight) {
                //如果是右子节点，设父节点的右子节点为null
                parent.right = null;
            }
            return true;
        }
        //存在左子节点
        else if ((current.left != null)
                && (current.right == null)) {
            System.out.println("不是叶子节点，存在左子节点");

            if (isLeft) {
                parent.left = current.left;
            } else if (isRight) {
                parent.right = current.left;
            }
            current = null;
            return true;
        }

        //存在右子节点
        else if ((current.left == null)
                && (current.right != null)) {
            System.out.println("不是叶子节点，存在右子节点");
            if (isLeft) {
                parent.left = current.right;

            } else if (isRight) {
                parent.right = current.right;
            }
            current = null;
            return true;
        }
        //左右子节点都存在
        else {
            System.out.println("不是叶子节点，存在左右子节点");

            if (isLeft) {
                parent.left = current.right;

                TreeNode currentLeft = current.right;
                TreeNode parentLeft = currentLeft;
                while (currentLeft != null) {
                    parentLeft = currentLeft;
                    currentLeft = currentLeft.left;
                }
                parentLeft.left = current.left;
                current = null;

            } else if (isRight) {
                parent.right = current.right;

                TreeNode currentLeft = current.right;
                TreeNode parentLeft = currentLeft;
                while (currentLeft != null) {
                    parentLeft = currentLeft;
                    currentLeft = currentLeft.left;
                }
                parentLeft.left = current.left;
                current = null;
            }

            return true;
        }

    }

    public void preOrder(TreeNode localNode) {

        if (localNode != null) {
            System.out.println(localNode.val);
            preOrder(localNode.left);
            preOrder(localNode.right);
        }
    }

    public void inOrder(TreeNode localNode) {

        if (localNode != null) {

            inOrder(localNode.left);
            System.out.println(localNode.val);
            inOrder(localNode.right);

        }
    }

    public void posOrder(TreeNode localNode) {

        if (localNode != null) {
            posOrder(localNode.left);
            posOrder(localNode.right);
            System.out.println(localNode.val);
        }
    }

    // 最小值位于左子树最左节点
    public TreeNode getMin() {
        TreeNode current = root, last = null;

        while (current != null) {
            last = current;
            current = current.left;
        }

        return last;

    }


    public TreeNode getMax() {
        TreeNode current = root, last = null;

        while (current != null) {
            last = current;
            current = current.right;
        }

        return last;
    }

    // 验证序列为二叉搜索树后续遍历序列
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        return dspVerifySquenceOfBST(sequence,0,sequence.length-1);
    }

    private static boolean dspVerifySquenceOfBST(int[] sequence, int left, int right) {
        if(left>=right){
            return true;
        }
        int i = left;
        int j = 0;
        while(sequence[i]<sequence[right]){
            i++;
        }
        for(j=i;j<right;j++){
            if(sequence[j]<sequence[right]){
                return false;
            }
        }
        return dspVerifySquenceOfBST(sequence,left,i-1)&&
        dspVerifySquenceOfBST(sequence,i,right-1);
    }


}
