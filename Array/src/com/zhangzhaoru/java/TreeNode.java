package com.zhangzhaoru.java;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/5/27 9:17 上午
 * @Description:
 */
public class TreeNode {
    //数据域
    public int val;
    //左指针域
    public TreeNode left;
    //右指针域
    public TreeNode right;
    //构造带有参数的构造方法


    public TreeNode() {
    }

    public TreeNode(int data) {
        this.val = data;
    }

    public String toString() {
        return "TreeNode [data=" + val + ", left=" + left + ", right=" + right
                + "]";
    }
}