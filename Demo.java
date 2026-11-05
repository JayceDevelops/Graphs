public class Demo {
    public static void main(String[] args) {
        // Create nodes
        String cities = "EWOAPHIJ";
        Graph pennsylvania = new Graph();

        //for (int i = 0; i < cities.length(); i++){
            //char city = cities.charAt(i);

            //Node c = new Node(city+""); // Cast
            //pennsylvania.addNode(c);
        //}

        // Nodes 
        Node W = new Node("W");
        Node E = new Node("E");
        Node O = new Node("O");
        Node A = new Node("A");
        Node P = new Node("P");
        Node H = new Node("H");
        Node I = new Node("I");
        Node J = new Node("J");

        // Edges

        // All outgoing edges

        // W
        pennsylvania.addEdge(W, O, 21);
        pennsylvania.addEdge(W, H, 20);
        pennsylvania.addEdge(W, J, 22);
        pennsylvania.addEdge(W, E, 40);

        // O
        pennsylvania.addEdge(O, W, 21);
        pennsylvania.addEdge(O, A, 16);

        // A
        pennsylvania.addEdge(A, O, 16);
        pennsylvania.addEdge(A, P, 18);

        // P
        pennsylvania.addEdge(P, A, 18);
        pennsylvania.addEdge(P, H, 21);

        // H
        pennsylvania.addEdge(H, P, 21);
        pennsylvania.addEdge(H, W, 20);
        pennsylvania.addEdge(H, I, 41);

        // I
        pennsylvania.addEdge(I, H, 41);
        pennsylvania.addEdge(I, J, 10);
        pennsylvania.addEdge(I, E, 35);

        // J
        pennsylvania.addEdge(J, W, 22);
        pennsylvania.addEdge(J, I, 10);

        // E
        pennsylvania.addEdge(E, W, 40);
        pennsylvania.addEdge(E, I, 35);

        pennsylvania.addNode(E);
        pennsylvania.addNode(W);
        pennsylvania.addNode(O);
        pennsylvania.addNode(A);
        pennsylvania.addNode(P);
        pennsylvania.addNode(H);
        pennsylvania.addNode(I);
        pennsylvania.addNode(J);

        pennsylvania.printGraph();
    }
}
