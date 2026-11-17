import java.util.LinkedList;

public class Node {
    
    public String name;
    public LinkedList<Edge> edges; // Outgoing

    // prims 
    public boolean visited;

    // dijkstras
    public int distance; // G value
    public Node prev;

    // A*
    public int x, y, h, f;


    public Node(String name){
        this.name = name;
        this.edges = new LinkedList<>();
        this.visited = false;
        this.distance = 0;
        this.prev = null;
        x = y = h = f = 0;

    }

    @Override 
    public String toString(){
        return this.name;
    }
}