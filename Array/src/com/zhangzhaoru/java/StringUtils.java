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



    @Test
    public void test1() {
        String str = "a";
        ArrayList<String> list = Permutation(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
