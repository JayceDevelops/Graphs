import java.util.LinkedList;

public class Graph {
    
    // All the nodes
    private LinkedList<Node> nodes;
    private boolean DEBUG = true;

    public Graph() {
        nodes = new LinkedList<>();
    }

    public boolean addEdge(Node start, Node end, int weight){
       return start.edges.add(new Edge(start, end, weight));
    }

    public boolean addNode(Node node){
        return nodes.add(node);
    }

    public void printGraph(){
        for (Node node : nodes){
            for (Edge e : node.edges){
                System.out.print(e + " | ");
            }
            System.out.println();
        }
    }
}
