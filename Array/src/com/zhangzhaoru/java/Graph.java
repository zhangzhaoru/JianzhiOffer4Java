package com.zhangzhaoru.java;

/**
 * @BelongsProject: JianzhiOffer
 * @BelongsPackage: com.zhangzhaoru.java
 * @Author: ZhangZhaoru
 * @Date: 2021/6/2 12:49 下午
 * @Description:
 */
public interface Graph {
    public int V();
    public int E();

    public void addEnge(int v,int w);
    public boolean hasEdge(int v,int w);
    void show();
    public Iterable<Iterable> adj(int v);
}
