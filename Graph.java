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

    /*
        Print out the MST of the graph using prims algo

        Graph Must be already constructed by the caller
    */
    public void prims(){
        int mst_weight = 0;

        if (DEBUG) System.out.println("PRIM");

        // Mark all nodes unvisited
        unvisitAllNodes();

        // Pick a node to start from
        Node temp = nodes.getFirst();
        if (DEBUG) System.out.println("Starting at " + temp);
        temp.visited = true;

        if (DEBUG) System.out.println(temp + ".visited set to true");

        if (DEBUG) System.out.println("Visit all nodes...");

        // Continue until all nodes are visited 
        while(!allNodesVisited()){

            // Find the smallest edge
            Edge smallEdge = getSmallestEdge();

            // print the smallest edge
            if (DEBUG) System.out.println("Smallest Edge: " + smallEdge);

            // add total mst cost 
            mst_weight += smallEdge.weight;

            // Mark destination as visited 
            smallEdge.end.visited = true;
        }
        
        // report total weight
        System.out.println("Prim's complete. Total mst cost: " + mst_weight);
    }

    /*
        Finds the smallest edge to an unvisited node, only considering visited nodes.

    */
    private Edge getSmallestEdge(){
        int min = Integer.MAX_VALUE;

        Edge candidate = null;

        for (Node n : nodes){
            if (n.visited){
                for (Edge e : n.edges){
                    if (e.weight < min && !e.end.visited){
                        min = e.weight;
                        candidate = e;
                    }
                }
            }
        }

        return candidate;
    }

    private boolean allNodesVisited(){
        for (Node n : nodes){
            if (!n.visited){
                return false;
            }
        }

        return true;
    }

    private void unvisitAllNodes(){
        for (Node n : nodes){
            n.visited = false;
        }
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
