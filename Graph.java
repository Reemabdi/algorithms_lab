package org.example;

    import java.util.ArrayList;
    import java.util.List;
    
    public class Graph {
        List<Edge> edges;
        List<Integer> vertices;
    
        public Graph(int i, int j, int k) {
            edges = new ArrayList<>();
            vertices = new ArrayList<>();
        }
    
        public void addEdge(int src, int dest, int weight) {
            edges.add(new Edge(src, dest, weight));
            // Add the vertices if they are not already in the graph
            if (!vertices.contains(src)) {
                vertices.add(src);
            }
            if (!vertices.contains(dest)) {
                vertices.add(dest);
            }
        }
    
        /**
         * Counting Sort to sort the weights of the edges in range [0, maxWeight] in O(n) time.
         * @param maxWeight the maximum weight of an edge
         */
        public void countingSort(int maxWeight) {
            List<List<Edge>> buckets = new ArrayList<>(maxWeight + 1);
            for (int i = 0; i <= maxWeight; i++) {
                buckets.add(new ArrayList<>());
            }
            for (Edge edge : edges) {
                buckets.get(edge.weight).add(edge);
            }
            // Clears the list and adds all the elements from the buckets
            edges.clear();
            for (List<Edge> bucket : buckets) {
                edges.addAll(bucket);
            }
        }
    
        public void print() {
            for (Edge edge : edges) {
                System.out.println(edge.src + " -- " + edge.dest + " == " + edge.weight);
            }}

        public List<Edge> Graph() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'Graph'");
        }
    }
    
    

