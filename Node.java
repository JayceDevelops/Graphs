import java.util.LinkedList;

public class Node {
    
    public String name;
    public LinkedList<Edge> edges; // Outgoing

    // prims 
    public boolean visited;

    // dijkstras
    public int distance;
    public Node prev;

    public Node(String name){
        this.name = name;
        this.edges = new LinkedList<>();
        this.visited = false;
        this.distance = 0;
        this.prev = null;
    }

    @Override 
    public String toString(){
        return this.name;
    }
}