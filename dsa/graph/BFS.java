package dsa.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private Graph graph;

    public BFS(Graph graph){
        this.graph=graph;
    }

    public void bfs(int v){
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[graph.getV()];

        visited[v]=true;
        queue.add(v);
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int adjacent : graph.getEdge()[current]){
                if(!visited[adjacent]){
                    visited[adjacent]=true;
                    queue.add(adjacent);
                }
            }
        }
    }
}
