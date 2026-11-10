import java.util.LinkedList;

public class Node {
    
    public String name;
    public LinkedList<Edge> edges; // Outgoing
    public boolean visited;

    public Node(String name){
        this.name = name;
        edges = new LinkedList<>();
        visited = false;
    }

    @Override 
    public String toString(){
        return this.name;
    }
}