package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class kruskal2 {
  
    /**
     * Kruskal Before
     * The Krusal's algorithm to find Minimum Spanning Tree of a given connected, undirected and weighted graph.
     * @param graph the graph
     * @return the minimum spanning tree
     */
    public List<Edge> kruskalMST(Graph graph) {
        // A = ∅
        List<Edge> result = new ArrayList<>();
        // for each vertex v ∈ G.V
        //   MAKE-SET(v)
        Subset[] subsets = new Subset[graph.vertices.size()];
        for (int v = 0; v < graph.vertices.size(); v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = Subset.rankC++;
        }
        // sort the edges of G.E into non-decreasing order by weights
        graph.edges.sort(Comparator.comparingInt(o -> o.weight));

        return getEdges(graph, result, subsets);
    }

    private List<Edge> getEdges(Graph graph, List<Edge> result, Subset[] subsets) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEdges'");
    }

    /**
     * A helper function to get the edges of the minimum spanning tree of a sorted graph
     * @param graph the sorted graph
     * @param result the result
     * @param subsets the subsets
     * @return the minimum spanning tree
     */
    private List<Edge> getEdges(Graph graph, List<Edge> result, Subset[] subsets) {
        // for each edge (u, v) ∈ G.E, in non-decreasing order by weights
        for (int i = 0, e = 0; e < graph.vertices.size() - 1; ) {
            Edge next_edge = graph.edges.get(i++);
            // FIND-SET(u)
            int x = find(subsets, next_edge.src);
            // FIND-SET(v)
            int y = find(subsets, next_edge.dest);
            // if FIND-SET(u) ≠ FIND-SET(v)
            if (x != y) {
                // A = A ∪ {(u, v)}
                result.add(next_edge);
                // UNION(u, v)
                Union(subsets, x, y);
                e++;
            }
        }
        return result;
    }

    /**
     * Kruskal After
     * Improved version of Kruskal's algorithm that uses Counting Sort to sort the weights of the edges in range [0, maxWeight] in O(n) time.
     * @param graph the graph
     * @param maxWeight the maximum weight of an edge
     * @return the minimum spanning tree
     */
    public List<Edge> kruskalMST(Graph graph, int maxWeight) {
        // A = ∅
        List<Edge> result = new ArrayList<>();
        // for each vertex v ∈ G.V
        //   MAKE-SET(v)
        Subset[] subsets = new Subset[graph.vertices.size()];
        for (int v = 0; v < graph.vertices.size(); v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = Subset.rankC++;
        }
        // sort the edges of G.E into non-decreasing order by weights
        // Use Counting Sort to sort the weights of the edges in range [0, maxWeight] in O(n) time
        graph.countingSort(maxWeight);
        return getEdges(graph, result, subsets);
    }

    /**
     * A utility function to find the subset of an element i
     * @param subsets the subsets
     * @param i the element
     * @return the subset of the element i
     */
    int find(Subset[] subsets, int i) {
        if (subsets[i].parent != i) {
            subsets[i].parent = find(subsets, subsets[i].parent);
        }
        return subsets[i].parent;
    }

    /**
     * A function that does union of two sets of x and y
     * @param subsets the subsets
     * @param x the first set
     * @param y the second set
     */
    void Union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);
        if (subsets[xroot].rank < subsets[yroot].rank) {
            subsets[xroot].parent = yroot;
        } else if (subsets[xroot].rank > subsets[yroot].rank) {
            subsets[yroot].parent = xroot;
        } else {
            subsets[yroot].parent = xroot;
 } }
}


