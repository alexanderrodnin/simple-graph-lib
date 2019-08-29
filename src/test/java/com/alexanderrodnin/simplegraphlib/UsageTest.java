package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.model.Edge;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

@Disabled("Disabled. Only for developers.")
class UsageTest {

    //@formatter:off
    /**
     * "A" ---> "B"
     */
    //@formatter:on
    @Test
    void initDirectGraphByBuilder() {
        Graph graph = GraphBuilder.<String>directed()
                .addVertex("A")
                .addVertex("B")
                .addEdge("A", "B")
                .build();

        System.out.println(graph.toString());
    }

    //@formatter:off
    /**
     * "A" --- "B"
     */
    //@formatter:on
    @Test
    void initUndirectGraphByBuilder() {
        Graph graph = GraphBuilder.<String>undirected()
                .addVertex("A")
                .addVertex("B")
                .addEdge("A", "B")
                .build();

        System.out.println(graph.toString());
    }

    //@formatter:off
    /**
     * "A" ---> "B"
     */
    //@formatter:on
    @Test
    void initDirectGraphByConstructor() {
        Graph<String> graph = new DirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge(new Edge<>("B", "A"));

        System.out.println(graph.toString());
    }

    //@formatter:off
    /**
     * "A" --- "B"
     */
    //@formatter:on
    @Test
    void initUndirectGraphByConstructor() {
        Graph<String> graph = new UndirectedGraph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge(new Edge<>("B", "A"));

        System.out.println(graph.toString());
    }

    @Test
    void initUndirectedGraphWithCustomPathFinderByBuilder() {
        Graph graph = GraphBuilder.<String>undirected()
                .setCustomPathFindStrategy((graphModel, source, destination) ->
                        new ArrayList<>(Arrays.asList(new Edge<>("A","B")))
                )
                .addVertex("A")
                .addVertex("B")
                .addEdge("A", "B")
                .build();

        System.out.println(graph.toString());

    }
}
