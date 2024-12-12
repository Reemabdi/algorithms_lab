package org.example;


import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Main {
    private static final int NUM_EDGES = 200;
    private static final int NUMBER_OF_VERTICES = 201;
    private static final int MAX_WEIGHT = 201;

    public static void main(String[] args) {
        Graph graph = generateConnectedGraph(NUM_EDGES, NUMBER_OF_VERTICES, MAX_WEIGHT);
//        graph.print();
        Kruskal kruskal = new Kruskal();
        // Calculate the running time of Kruskal's algorithm before chanding the algorithm
        long startTime = System.nanoTime();
        List<Edge> result = kruskal.kruskalMST(graph);
        long endTime = System.nanoTime();
//        System.out.println("Following are the edges in the constructed MST");
//        for (Edge next_edge : result) {
//            System.out.println(next_edge.src + " -- " + next_edge.dest + " == " + next_edge.weight);
//        }
        System.out.println("Total time taken by original algorithm " + (endTime - startTime) + " ns");

        // Calculate the running time of Kruskal's algorithm after changing the algorithm
        startTime = System.nanoTime();
        result = kruskal.kruskalMST(graph, MAX_WEIGHT);
        endTime = System.nanoTime();
//        for (Edge next_edge : result) {
//            System.out.println(next_edge.src + " -- " + next_edge.dest + " == " + next_edge.weight);
//        }
System.out.println("Total time taken by modified algorithm " + (endTime - startTime) + " ns");
}

/**
 * Generate a connected graph with a given number of edges, vertices and maximum weight
 *
 * @param numberEdges the number of edges
 * @param numVertices the number of vertices
 * @param maxWeight   the maximum weight
 * @return a connected graph
 */
public static Graph generateConnectedGraph(int numberEdges, int numVertices, int maxWeight) {
    Graph graph = new Graph(maxWeight, maxWeight, maxWeight);
    Random random = new Random();
    // Start with the first vertex
    int cVert = 0;
    // Set to keep track of already added vertices
    Set<Integer> added = new HashSet<>();
    added.add(cVert);
    // Add edges to connect all vertices
    for (int i = 0; i < numberEdges; i++) {
        // Choose a random vertex that has not been visited yet
        int nextVertex;
        if (added.size() < numVertices) {
            do {
                nextVertex = random.nextInt(numVertices);
            } while (added.contains(nextVertex));
        } else {
            // If all vertices have been visited, choose a random vertex
            nextVertex = random.nextInt(numVertices);
        }
        int weight = random.nextInt(maxWeight + 1);     // Random weight in range [0, maxWeight]
        graph.addEdge(cVert, nextVertex, weight);
        // Mark the next vertex as visited
        added.add(nextVertex);
        // Move to the next vertex
        cVert = nextVertex;
    }

    
    return graph;
}
}
