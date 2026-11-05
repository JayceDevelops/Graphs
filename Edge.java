public class Edge {

    public int weight;
    public Node start, end;

    public Edge(Node start, Node end, int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override 
    public String toString(){
        return this.start + " - " + this.weight + " -> " + this.end;
    }

}