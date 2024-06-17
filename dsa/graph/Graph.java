package dsa.graph;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class Graph {
    private int V;
    private LinkedList<Integer> Edge[];

    public Graph(int v){
        this.V = v;
        Edge=new LinkedList[this.V];
        IntStream.range(0, this.V).forEach(i -> Edge[i]=new LinkedList<>());
    }

    public void addEdge(int u, int v){
        Edge[u].add(v);
    }

    public int getV() {
        return V;
    }

    public LinkedList<Integer>[] getEdge() {
        return Edge;
    }
}
