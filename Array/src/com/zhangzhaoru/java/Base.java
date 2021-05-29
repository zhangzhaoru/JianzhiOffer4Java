package com.zhangzhaoru.java;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/5/27 7:01 下午
 * @Description:
 */
public class Base
{
    private String baseName = "base";
    public Base()
    {
        System.out.println("1");
        System.out.println(baseName);
        callName();
    }

    public void callName()
    {
        System.out.println("base callName");
        System. out. println(baseName);
    }

    static class Sub extends Base
    {
        private String baseName = "sub";
        public void callName()
        {
            System.out.println("Sub callName");
            System. out. println (baseName) ;
        }
    }
    public static void main(String[] args)
    {
        Base b = new Sub();
    }
}
