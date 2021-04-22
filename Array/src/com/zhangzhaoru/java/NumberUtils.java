package com.zhangzhaoru.java;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.junit.Test;
import org.omg.CORBA.ARG_OUT;

import java.util.*;

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
        while (flag != 0) {
            if ((n & flag) != 0) {
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
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                count++;
            }
        }
        return count;
    }

    public static double Power(double base, int exponent) {
        double res = 1.0;
        if (exponent == 0) {
            if (base == 0) {
                try {
                    throw new Exception("base not zero!");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                return 1;
            }

        } else if (exponent > 0) {
            for (int i = 0; i < exponent; i++) {
                res = res * base;
            }
        } else {
            for (int i = 0; i < -exponent; i++) {
                res = res / base;
            }
        }
        return res;
    }

    /**
     * 输出和为S的两个数字
     *
     * @param array
     * @param sum
     * @return
     */
    public static ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array.length == 0) {
            return list;
        }
        int i = 0;
        int j = array.length - 1;
        while (i != j) {
            if (sum == (array[i] + array[j])) {
                list.add(array[i]);
                list.add(array[j]);
                break;
            } else if (sum < (array[i] + array[j])) {
                j--;
            } else {
                i++;
            }
        }
        return list;
    }

    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num == null || num.length == 0 || size <= 0 || size > num.length) {
            return res;
        }
        Deque list = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            while (!list.isEmpty() && (i - size + 1) >(int)list.getFirst()) {
                list.removeFirst();
            }
            while(!list.isEmpty()&&num[i]>=num[(int)list.getLast()]){
                list.removeLast();
            }
            list.addLast(i);
            if(i>=size-1){
                res.add(num[(int)list.getFirst()]);
            }

        }
        return res;
    }

    /**
     * 数组连续最大和
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if(array.length==0){
            return 0;
        }
        int maxSum=array[0];
        int curSum=array[0];
        for(int i =0;i<array.length;i++){
            if(curSum>=0){
                curSum+=array[i];
            }else{
                curSum=array[i];
            }
            if(curSum>maxSum){
                maxSum=curSum;
            }
        }
        return maxSum;
    }

    public static int[] str2Arr(String str){
        String substring = str.substring(1, str.length() - 1);
        String[] strings = substring.split(",");
        int[] array = new int[strings.length];
        for(int i=0;i<strings.length;i++){
            array[i]=StringUtils.str2Int(strings[i]);
        }
        return array;
    }

    @Test
    public void test6(){
        String str="[1,-2,3,10,-4,7,2,-5]";
        int maxSum = FindGreatestSumOfSubArray(str2Arr(str));
        System.out.println(maxSum);

    }

    @Test
    public void test5(){
        String str="[1,-2,3,10,-4,7,2,-5]";
        int[] arr = str2Arr(str);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i]+" ");
        }
        System.out.println();
    }

    @Test
    public void test4(){
        int[] num={2,3,4,2,6,2,5,1};
        int size=3;
        ArrayList<Integer> list = maxInWindows(num, size);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i)+" ");
        }
        System.out.println();
    }


    @Test
    public void test2() {
        int[] array = {1, 2, 4, 7, 11, 15};
        int sum = 15;
        ArrayList<Integer> list = FindNumbersWithSum(array, sum);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }

    @Test
    public void test1() {
        System.out.println(numberOf1(10));
    }

    @Test
    public void test3() {
        Deque list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list.peekLast());
        System.out.println(list.peekFirst());

    }
}
