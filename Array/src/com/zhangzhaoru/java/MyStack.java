package com.zhangzhaoru.java;

import com.sun.org.apache.bcel.internal.generic.RETURN;

import java.util.ArrayList;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/4/17 12:59 下午
 * @Description: 实现含有Min函数的栈
 */
public class MyStack {
    private int val;
    private int size=0;
    private ArrayList<Integer> list=new ArrayList<Integer>();
    private ArrayList<Integer> minList=new ArrayList<Integer>();

    public MyStack(int val) {
        this.val = val;
    }

    public int getSize() {
        return size;
    }

    public void push(int node) {
        if(list.isEmpty()){
            minList.add(node);
        }else{
            if(node<minList.get(size-1)){
                minList.add(node);
            }else{
                minList.add(minList.get(size-1));
            }
        }
        list.add(node);
        size++;

    }

    public void pop() {
        if(list.isEmpty()){
            return;
        }
        list.remove(size - 1);
        minList.remove(size-1);
        size--;
    }

    public int top() {
        return list.get(size-1);
    }

    public int min() {
        return minList.get(size-1);
    }
}
