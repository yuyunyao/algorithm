package com.didichuxing;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 图数据结构
 * 邻接表存储
 * 图的表达能力很强，大部分搜索都能使用图实现
 * 广度 深度 A* IDA* 启发式搜索
 */
public class Graph {
  private int v;//顶点个数
  private LinkedList<Integer>[] adjs;

  public Graph(int v) {
    this.v = v;
    adjs = new LinkedList[v];
    for (int i = 0; i < v; i++) {
      adjs[i] = new LinkedList<>();
    }
  }

  private void buildGraph() {
    adjs[0].add(1);
    adjs[0].add(3);
    adjs[1].add(0);
    adjs[1].add(2);
    adjs[1].add(4);
    adjs[3].add(0);
    adjs[3].add(4);
    adjs[4].add(1);
    adjs[4].add(3);
    adjs[4].add(5);
    adjs[4].add(6);
    adjs[2].add(1);
    adjs[2].add(5);
    adjs[5].add(2);
    adjs[5].add(4);
    adjs[5].add(7);
    adjs[6].add(4);
    adjs[6].add(7);
    adjs[7].add(5);
    adjs[7].add(6);
  }

  /**
   * 无向边，存2次
   * @param from
   * @param to
   */
  private void  addEdge(int  from , int  to) {
    adjs[from].add(to);
    adjs[to].add(from);
  }

  /**
   * 广度优先搜索
   * @param s 起点
   * @param t 终点
   * Edges
   */
  private void  bfs(int s,int t) {
    if (s == t) {
      return;
    }
    boolean[] visited = new boolean[v];//标记是否已经被访问
    visited[s] = true;
    int[] pre = new int[v];//记录已经遍历节点的上一个节点
    for (int i = 0; i < pre.length; i++) {
      pre[i] = -1;
    }
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    while (!queue.isEmpty()) {
      Integer poll = queue.poll();
      LinkedList<Integer> adj = this.adjs[poll];
      for (Integer vertex : adj) {
        if (!visited[vertex]) {
          pre[vertex] = poll;
          if (vertex == t) {
            //print
            print(pre, s, t);
            return;
          }
          visited[vertex] = true;
          queue.add(vertex);
        }
      }
    }
  }


  private void print(int[] pre, int s, int t) {
    if (pre[t] >=0) {
      print(pre, s,pre[t]);
    }
    System.out.println(String.format("scan vertex %d", t));
  }



  private boolean found = false; // 全局变量或者类成员变量

  /**
   * 深度优先搜索
   * @param s
   * @param t
   */
  public void dfs(int s, int t) {
    found = false;
    boolean[] visited = new boolean[v];
    int[] prev = new int[v];
    for (int i = 0; i < v; ++i) {
      prev[i] = -1;
    }
    recurDfs(s, t, visited, prev);
    print(prev, s, t);
  }

  private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
    if (found == true) return;
    visited[w] = true;
    if (w == t) {
      found = true;
      return;
    }
    for (int i = 0; i < adjs[w].size(); ++i) {
      int q = adjs[w].get(i);
      if (!visited[q]) {
        prev[q] = w;
        recurDfs(q, t, visited, prev);
      }
    }
  }



  public static void main(String[] args) {
    Graph graph = new Graph(8);
    graph.addEdge(0,1);
    graph.addEdge(1,2);
    graph.addEdge(1,4);
    graph.addEdge(2,5);
    graph.addEdge(0,3);
    graph.addEdge(3,4);
    graph.addEdge(4,5);
    graph.addEdge(4,6);
    graph.addEdge(5,7);
    graph.addEdge(6,7);
//    graph.buildGraph();
//    graph.bfs(0,6);
    graph.dfs(0,6);
  }
}
