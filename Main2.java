package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
       List<Edge> edges50 = new Graph(50, 50, 50).Graph();
            List<Edge> edges100 = new Graph(100, 100, 100).Graph();
            List<Edge> edges150 = new Graph(150, 150, 150).Graph();
            List<Edge> edges200 = new Graph(200, 200, 200).Graph();

           
          System.out.print("\n~~\nTesting Kruskal (Before Update)");

           kruskalbefore(50);
          kruskalbefore(100);
          kruskalbefore(edges150);
          kruskalbefore(edges200);

            // Testing after:
            System.out.println("\n~~\nTesting Kruskal (After Update)");

            Union(edges50);
            Union(edges100);
            Union(edges150);
            Union(edges200);

        }

        public static void testKruskalBefore(List<Edge> edges) {
            Kruskal algorithm = new kruskal(edges.size(), new ArrayList<>(edges));
            long startTime = System.nanoTime();
            List<Edge> mst = algorithm.kruskal();
            long endTime = System.nanoTime();
            float elapsedTime = (endTime - startTime) / 1_000_000_000F;
            System.out.printf("Kruskal (Before) - Edges: %d, Time: %.6f seconds\n", edges.size(), elapsedTime);
        }
    

