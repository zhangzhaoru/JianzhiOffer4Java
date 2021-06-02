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
            while (!list.isEmpty() && (i - size + 1) > (int) list.getFirst()) {
                list.removeFirst();
            }
            while (!list.isEmpty() && num[i] >= num[(int) list.getLast()]) {
                list.removeLast();
            }
            list.addLast(i);
            if (i >= size - 1) {
                res.add(num[(int) list.getFirst()]);
            }

        }
        return res;
    }

    /**
     * 数组连续最大和
     *
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int maxSum = array[0];
        int curSum = array[0];
        for (int i = 0; i < array.length; i++) {
            if (curSum >= 0) {
                curSum += array[i];
            } else {
                curSum = array[i];
            }
            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }
        return maxSum;
    }

    public static int[] str2Arr(String str) {
        String substring = str.substring(1, str.length() - 1);
        String[] strings = substring.split(",");
        int[] array = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            array[i] = StringUtils.str2Int(strings[i]);
        }
        return array;
    }

    /**
     * 只包含因子为2，3，5的数称为丑数
     *
     * @param index
     * @return
     */
    public static int getUglyNumber(int index) {
        int curIndex = 1;
        int i = 1;
        while (curIndex < index) {
            if (isUglyNum(i++)) {
                curIndex++;
            }
        }

        return i - 1;
    }

    //剪绳子
    // 使用递归算法求解
    public static int cutRope1(int target) {
        if(target<2){
            return 0;
        }
        if(target==2){
            return 1;
        }
        if(target==3){
            return 2;
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        for(int i  =4;i<=target;i++){
            int max=0;
            for(int j=1;j<=i/2;j++){
                int temp = list.get(j)*list.get(i-j);
                if(temp>=max){
                    max=temp;
                }
            }
            list.add(max);
        }
        return list.get(target);

    }

    @Test
    public void test10(){
        int target=8;
        System.out.println(cutRope1(target));
    }


    public static int getUglyNumberII(int index) {
        if (index < 7) {
            return index;
        }
        int p2 = 0, p3 = 0, p5 = 0, curNum = 1;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        while (list.size() < index) {
            curNum = Math.min(list.get(p2) * 2, Math.min(list.get(p3) * 3, list.get(p5) * 5));
            if (curNum == list.get(p2) * 2) {
                p2++;
            }
            if (curNum == list.get(p3) * 3) {
                p3++;
            }
            if (curNum == list.get(p5) * 5) {
                p5++;
            }
            list.add(curNum);
        }
        return list.get(list.size() - 1);

    }

    public static boolean isUglyNum(int num) {
        if (num <= 1) {
            return false;
        }
        while (num != 1) {
            if (num % 5 == 0) {
                num /= 5;
            } else if (num % 3 == 0) {
                num /= 3;
            } else if (num % 2 == 0) {
                num /= 2;
            } else {
                return false;
            }
        }
        return true;
    }

    // 小顶堆
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(); //小顶堆，默认容量为11
    // 大顶堆
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,new Comparator<Integer>(){ //大顶堆，容量11
        @Override
        public int compare(Integer i1,Integer i2){
            return i2-i1;
        }
    });

    // 动态更新数据流的中位数
    public static void Insert(Integer num) {
        if(minHeap.isEmpty()&&maxHeap.isEmpty()){
            maxHeap.add(num);
            return;
        }
        if(num<maxHeap.peek()){
            maxHeap.add(num);
            if(Math.abs(maxHeap.size()-minHeap.size())>1){
                minHeap.add(maxHeap.poll());
            }
        }else{
            minHeap.add(num);
            if(Math.abs(maxHeap.size()-minHeap.size())>1){
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public static Double GetMedian() {
        if(minHeap.size()==maxHeap.size() ){
            return (double)(minHeap.peek()+maxHeap.peek())/(double)2.0;
        }else if(minHeap.size()>maxHeap.size()){
            return (double) (minHeap.peek());

        }else{
            return (double) maxHeap.peek();
        }
    }


    @Test
    public void test12(){
        int[] nums=  {5,2,3,4,1,6,7,0,8};
        for(int i=  0;i<nums.length;i++){
            Insert(nums[i]);
            System.out.println("GetMedian() = " + GetMedian());
        }
    }



    @Test
    public void test9() {
        System.out.println("getUglyNumberII(i) = " + getUglyNumberII(7));
    }

    @Test
    public void test8() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("getUglyNumberII(i) = " + getUglyNumberII(i));
        }
    }

    @Test
    public void test7() {
        boolean uglyNum = isUglyNum(1);
        System.out.println(uglyNum);
    }

    @Test
    public void test6() {
        String str = "[1,-2,3,10,-4,7,2,-5]";
        int maxSum = FindGreatestSumOfSubArray(str2Arr(str));
        System.out.println(maxSum);

    }

    @Test
    public void test5() {
        String str = "[1,-2,3,10,-4,7,2,-5]";
        int[] arr = str2Arr(str);
        for (int i = 0; i < arr.length; i++) {
            System.out.printf(arr[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void test4() {
        int[] num = {2, 3, 4, 2, 6, 2, 5, 1};
        int size = 3;
        ArrayList<Integer> list = maxInWindows(num, size);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(list.get(i) + " ");
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

    // 不使用加减乘除做加法
    public int Add(int num1,int num2) {
        int result,ans;
        do{
            result = num1 ^ num2;
            ans=(num1&num2)<<1;
            System.out.println("Integer.toBinaryString(num1) = " + Integer.toBinaryString(num1));
            System.out.println("Integer.toBinaryString(num2) = " + Integer.toBinaryString(num2));
            System.out.println("Integer.toBinaryString(result) = " + Integer.toBinaryString(result));
            System.out.println("Integer.toBinaryString(ans) = " + Integer.toBinaryString(ans));
            num1 = result;
            num2 = ans;
        }while(ans!=0);
        return result;
    }

    @Test
    public void test11(){
        System.out.println("Add(2,3) = " + Add(2, 3));
    }

}
