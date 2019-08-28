package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.finder.FirstFoundPathFindStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class FirstFoundPathStrategyTest {


    //@formatter:off
    /**
     *      +-- B --+
     *      |       |
     * A +--+       +--+D
     *      |       |
     *      +-- C --+
     */
    //@formatter:on
    @Test
    void undirectedGraphPathFindTest() {
        Graph<String> graph = GraphBuilder.<String>undirected()
                .setCustomPathFindStrategy(new FirstFoundPathFindStrategy<>())
                .addVertex("A")
                .addVertex("B")
                .addVertex("C")
                .addVertex("D")
                .addEdge("A", "B")
                .addEdge("A", "C")
                .addEdge("B", "D")
                .addEdge("C", "D")
                .build();

        List<String> path = graph.getPath("A", "D");
        Assertions.assertEquals(Arrays.asList("A", "B", "D"), path);
    }


    //@formatter:off
    /**
     *      +-< B >-+
     *      |       |
     * A <>-+       +->+D
     *      |       |
     *      +-> C >-+
     */
    //@formatter:on
    @Test
    void directedGraphPathFindTest() {
        Graph<String> graph = GraphBuilder.<String>directed()
                .setCustomPathFindStrategy(new FirstFoundPathFindStrategy<>())
                .addVertex("A")
                .addVertex("B")
                .addVertex("C")
                .addVertex("D")
                .addEdge("B", "A")
                .addEdge("B", "D")
                .addEdge("A", "C")
                .addEdge("C", "D")
                .build();

        List<String> path = graph.getPath("A", "D");
        Assertions.assertEquals(Arrays.asList("A", "C", "D"), path);
    }


}
