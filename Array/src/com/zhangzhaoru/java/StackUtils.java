package com.zhangzhaoru.java;

import org.junit.Test;

import java.util.Stack;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/4/15 9:04 下午
 * @Description:
 */
public class StackUtils {
    private static Stack<Integer> stack1 = new Stack<Integer>();
    private static Stack<Integer> stack2 = new Stack<Integer>();

    // 两个栈实现队列的进队与出队操作
    public static void push4Queue(int node) {
        stack1.add(node);
    }

    public static int pop4Queue() {
        if (stack2.empty()) {
            if (stack1.empty()) {
                return -1;
            } else {
                while (!stack1.empty()) {
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }

    public static int size4Queue() {
        return stack1.size() + stack2.size();
    }

    public static boolean isEmpty4Queue() {
        return (stack1.empty() && stack2.empty());
    }

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if(pushA.length==0|| popA.length==0){
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0;i<pushA.length;i++){
            stack.push(pushA[i]);
            while(!stack.empty()&&stack.peek()==popA[j++]){
                stack.pop();
            }
        }
        return stack.empty();
    }

    @Test
    public void test1() {
        push4Queue(1);
        push4Queue(2);
        push4Queue(3);
        System.out.println(pop4Queue());
        System.out.println(pop4Queue());
        push4Queue(4);
        System.out.println(pop4Queue());
        push4Queue(5);
        System.out.println(pop4Queue());
        System.out.println(pop4Queue());

    }

    @Test
    public void test2(){
        int[] push={1,2,3,4,5};
        int[] pop={4,3,5,2,1};
        if(IsPopOrder(push,pop)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
