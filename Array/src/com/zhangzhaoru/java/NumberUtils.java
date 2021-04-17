package com.zhangzhaoru.java;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.junit.Test;

import java.util.Arrays;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/4/15 9:59 下午
 * @Description:
 */
public class NumberUtils {
    public static int numberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0) {
            if((n & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    public static int numberOf1II(int n) {
        int count = 0;
        String str = Integer.toBinaryString(n);
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length ;i++) {
            if(chars[i]=='1'){
                count++;
            }
        }
        return count;
    }

    public static double Power(double base, int exponent){
        double res=1.0;
        if(exponent==0){
            if(base==0){
                try {
                    throw new Exception("base not zero!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                return 1;
            }

        }else if(exponent>0){
            for(int i = 0;i<exponent;i++){
                res = res*base;
            }
        }else {
            for(int i = 0;i<-exponent;i++){
                res = res/base;
            }
        }
        return res;
    }

    @Test
    public void test1() {
        System.out.println(numberOf1(10));
    }
}
