package com.zhangzhaoru.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/4/17 9:44 下午
 * @Description:
 */
public class StringUtils {
    public static String replaceSpace(String str) {
        return str.replace(" ", "%20");
    }

    // 含重复字符的字符串
    public static ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<String>();
        dsp4Permutation(set, str, 0);
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            list.add(it.next());
        }
        return list;
    }

    public static void dsp4Permutation(HashSet<String> set, String str, int depth) {
        if (depth == str.length()) {
            set.add(str);
        } else {
            for (int i = depth; i < str.length(); i++) {
                str = swap(str, depth, i);
                dsp4Permutation(set, str, depth + 1);
                str = swap(str, depth, i);
            }
        }
    }

    public static String swap(String str, int i, int j) {
        char[] chars = str.toCharArray();
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return String.valueOf(chars);
    }


    public static int FirstNotRepeatingChar(String str) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        genMap(map,str);

        for(int i = 0;i<str.length();i++){
            if(map.get(str.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
    private static void genMap(HashMap<Character, Integer> map,String str){

        char[] chars=  str.toCharArray();
        for(int i = 0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i],map.get(chars[i])+1);
            }else{
                map.put(chars[i],1);
            }
        }
    }


    public static String LeftRotateString(String str,int n){
        if(n>str.length()){
            return str;
        }
        String str1=str.substring(0,n);
        String str2=str.substring(n);
        return str2+str1;
    }

    public static String ReverseSentence(String str) {
        if(str==null||isOnlyBlack(str)){
            return str;
        }
        String[] strs=str.split(" ");
        String res="";
        for(int i = strs.length-1;i>=0;i--){
            res+=strs[i]+" ";
        }

        return res.trim();
    }

    public char FirstAppearingOnce(String str){
        if(str.isEmpty()){
            return '#';
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(map.containsKey(chars[i])){
                map.put(chars[i],map.get(chars[i])+1);
            }else{
                map.put(chars[i],1);
            }

        }
        for(int i=0;i<chars.length;i++){
            if(map.get(chars[i])==1){
                return chars[i];
            }
        }
        return '#';
    }

    public static boolean isOnlyBlack(String str){
        char[] chars = str.toCharArray();
        for(int i =0;i<chars.length;i++){
            if(chars[i]!=' '){
                return false;
            }
        }
        return true;
    }

    public static int str2Int(String str){
        if(str.isEmpty()){
            return 0;
        }
        int i=0;
        int flag=1;
        int num=0;
        char[] chars = str.toCharArray();
        if(chars[0]=='-'){
            flag=-1;
            i=1;
        }
        if(chars[0]=='+'){
            i=1;
        }
        for(;i<chars.length;i++){
            if(chars[i]>='0'&&chars[i]<'9'){
                num=num*10+(chars[i]-'0');
            }else{
                return 0;
            }
        }
        return flag*num;
    }

    @Test
    public void test6(){
        String str="gloodg";
        System.out.println(FirstAppearingOnce(str));
    }

    @Test
    public void test5(){
        String str="+2147483647";
        System.out.println(str2Int(str));
    }

    @Test
    public void test3(){
        String str="nowcoder. a am I";
        System.out.println("ReverseSentence(str) = " + ReverseSentence(str));
    }


    @Test
    public void test4(){
        String str="  ";
       if(isOnlyBlack(str)){
           System.out.println("1");
       }else{
           System.out.println("0");
       }
    }


    @Test
    public void test2(){
        String str="zhangzhaoru";
        System.out.println("LeftRotateString(str,2) = " + LeftRotateString(str, 2));
    }



    @Test
    public void test1() {
        String str = "a";
        ArrayList<String> list = Permutation(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
