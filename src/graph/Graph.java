package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Vertex, List<Vertex>> vertices;


    public  void addVertex(String label){
        Vertex newVertex=new Vertex(label);

        this.vertices.putIfAbsent(newVertex, new ArrayList<>());
    }

    public void removeVertex(String label)
    {
        Vertex vertex=new Vertex(label);

        this.vertices.values().forEach(e->e.remove(vertex));
        this.vertices.remove(vertex);
    }
    public void addEdge(String label1,String label2)
    {
        Vertex vertex1=new Vertex(label1);
        Vertex vertex2=new Vertex(label2);

        this.vertices.get(vertex1).add(vertex2);
        this.vertices.get(vertex2).add(vertex1);

    }

    public void removeEdge(String label1,String label2)
    {
        Vertex vertex1=new Vertex(label1);
        Vertex vertex2=new Vertex(label2);


    }
}
