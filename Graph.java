import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

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
        Dijkstras algo
    */

    public void dijkstras(Node start, Node end){

        // Reset all dijkstras properties 
        unvisitAllNodes();
        resetDistance();
        resetPrev();

        Node curr = start;
        curr.distance = 0;
        
        Scanner keyboard = new Scanner(System.in);

        while (curr != null){
            if (DEBUG) print("Current node is " + curr + " distance = " + curr.distance);

            if (curr == end){
                break;
            }

            // Pick edges 1 by 1 
            for (Edge edge : curr.edges){
                if (DEBUG) print("\tEdge " + edge + " visited? " + edge.end.visited);

                if (edge.end.visited){
                    if (DEBUG) print("\t\tskip...");
                    continue;
                }

                int newDistance = curr.distance + edge.weight;
                if (DEBUG) print("\t\tNew Distance: " + newDistance + " (" + curr.distance + " + " + edge.weight + ")");

                if (newDistance < edge.end.distance){
                    if (DEBUG) print("\t\tNew distance is smaller. updating..");
                    edge.end.distance = newDistance;
                    edge.end.prev = curr;
                }
            }

            curr.visited = true;

            //TODO: printout table
            if (DEBUG) printDijkstrasTable();

            if (DEBUG) keyboard.nextLine();

            curr = getSmallestNode();
        }

        Stack<Node> path = new Stack<>();
        curr = end;

        while (curr != null){
            path.push(curr);
            curr = curr.prev;
        }

        print("Shortest Path from " + start + " to " + end);
        while (!path.isEmpty()){
            curr = path.pop();
            print("Go to " + curr);
        }
        

        keyboard.close();
    }

    private void printDijkstrasTable(){
        System.out.println();
        System.out.printf("%-10s%-10s%-15s%-10s \n", "NAME", "VISITED", "DIST", "PREV");
        for (int i =0; i < nodes.size(); i++){
            System.out.printf("%-10s", nodes.get(i).name);
            System.out.printf("%-10s", nodes.get(i).visited);
            System.out.printf("%-15s", nodes.get(i).distance);
            System.out.printf("%-10s\n", nodes.get(i).prev);
        }
        System.out.println();
    }

    private Node getSmallestNode(){
        int min = Integer.MAX_VALUE;

        Node candidate = null;

        for (Node n : nodes){
            if (n.visited){
                continue;
            }

            if (n.distance < min){
                min = n.distance;
                candidate = n;
            }
        }

        return candidate;
    }

    private void print(String s){
        System.out.println(s);
    }

    private void resetPrev(){
        for (Node n : nodes){
            n.prev = null;
        }
    }

    // Set all nodes distance to as high as possible 
    private void resetDistance(){
        for (Node n : nodes){
            n.distance = Integer.MAX_VALUE;
        }
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
