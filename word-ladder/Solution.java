import java.util.*;

class Solution {

  // Problem 1
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    int n = wordList.size();
    int begin = -1, end = -1;
    for (int i = 0; i < n; i++) {
      String word = wordList.get(i);
      if (word.equals(beginWord)) begin = i;
      if (word.equals(endWord)) end = i;
    }
    if (begin == -1) {
      wordList.add(beginWord);
      begin = n++;
    }
    if (end == -1) return 0;
    Graph g = new Graph(n);
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
        if (match(wordList.get(i), wordList.get(j))) {
          g.addEdge(i, j);
        }
      }
    }
    return g.bfs(begin ,end);
  }

  boolean match(String a, String b) {
    if (a.length() != b.length()) return false;
    int count = 0;
    for (int i = 0; i < a.length(); i++) {
      if (a.charAt(i) != b.charAt(i)) count++;

    }
    return count == 1;
  } 

  class Graph {
    ArrayList<Integer>[] adj;
    Graph(int n) {
      adj = new ArrayList[n];
      for (int i = 0;i < n; i++) adj[i] = new ArrayList<>();
    }
    void addEdge(int i, int j) {
      adj[i].add(j);
      adj[j].add(i);
    }

    int bfs(int start, int end) {
      if (start == end) return 0;
      Queue<int[]> level = new ArrayDeque<>();
      int[] vis = new int[adj.length];
      Arrays.fill(vis, -1);
      vis[start] = 1;
      level.add(new int[]{start, 1});
      while (!level.isEmpty()) {
        int n = level.size();
        for (int i = 0; i < n; i++) {
          int[] u = level.remove();
          if (u[0] == end) return u[1];
          for (int v : adj[u[0]]) {
            if (vis[v] == -1) {
              vis[v] = 1;
              level.offer(new int[]{v, u[1]+1});
            }
          }
        }
      }
      return 0;
    }
  }

}
