package com.zhangzhaoru.java;

import org.junit.Test;

import java.util.*;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/4/15 9:34 下午
 * @Description:
 */
public class Recursion {
    public static int jumpFloor(int target) {
        return dsp4Jump(target);
    }

    private static int dsp4Jump(int num) {
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        return dsp4Jump(num - 2) + dsp4Jump(num - 1);
    }

    public static int jumpFloorII(int target) {
        return dsp4JumpII(target);
    }

    private static int dsp4JumpII(int num) {
        if (num == 1) {
            return 1;
        }
        return 2 * dsp4JumpII(num - 1);
    }

    public static int rectCover(int target) {
        return dsp4Rect(target);
    }

    public static int dsp4Rect(int num) {
        if (num == 0) {
            return 0;
        }
        if (num == 1) {
            return 1;
        }
        if (num == 2) {
            return 2;
        }
        return dsp4Rect(num - 1) + dsp4Rect(num - 2);
    }

    // 递归实现全排列
    public static void swap(int[] data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }




    void perm(ArrayList<String> list,int[] data,int depth,int len){
        if(depth==len){
            list.add(Arrays.toString(data));
        }else{
            for(int i=depth;i<len;i++){
                swap(data,i,depth);
                perm(list,data,depth+1,len);
                swap(data,i,depth);

            }
        }
    }




    @Test
    public void test1(){
        int[] data={1,2,3,4,5};
        swap(data,1,2);
        System.out.println("Arrays.toString(data) = " + Arrays.toString(data));
    }

    @Test
    public void test2(){
        int[] data={1,2,3,4,5};
        ArrayList<String> list = new ArrayList<>();
        perm(list,data,0,data.length);
        Iterator<String> it = list.iterator();
        System.out.println(list.size());
        while(it.hasNext()){
            System.out.println(it.next());
        }




    }

}
