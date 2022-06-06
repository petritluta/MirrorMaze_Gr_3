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
}
