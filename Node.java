import java.util.LinkedList;

public class Node {
    
    public String name;
    public LinkedList<Edge> edges; // Outgoing

    public Node(String name){
        this.name = name;
        edges = new LinkedList<>();
    }

    @Override 
    public String toString(){
        return this.name;
    }
}