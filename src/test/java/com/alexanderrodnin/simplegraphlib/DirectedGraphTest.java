package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.model.Edge;
import com.alexanderrodnin.simplegraphlib.model.DefaultGraphModel;
import com.alexanderrodnin.simplegraphlib.model.GraphModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class DirectedGraphTest {

    GraphModel<String> model;
    Graph<String> graph;

    @BeforeEach
    void init() {
        model = new DefaultGraphModel<>();
        graph = GraphBuilder
                .<String>directed()
                .setCustomGraphModel(model)
                .build();
    }

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
    void vertexesTest() {
        Set<String> vertexes = new HashSet<>(Arrays.asList("A", "B", "C", "D"));
        vertexes.forEach(vertex -> graph.addVertex(vertex));

        Assertions.assertEquals(vertexes.size(), model.getAllVertexes().size());
        Assertions.assertTrue(vertexes.containsAll(model.getAllVertexes()));
    }

    //@formatter:off
    /**
     * A +--+ B
     */
    //@formatter:on
    @Test
    void edgesTest() {
        Set<String> vertexes = new HashSet<>(Arrays.asList("A", "B"));
        vertexes.forEach(vertex -> graph.addVertex(vertex));
        graph.addEdge(new Edge<>("A", "B"));

        Assertions.assertEquals(1, model.getAllEdges().size());
        Assertions.assertTrue(model.containsEdge("A", "B"));
        Assertions.assertFalse(model.containsEdge("B", "A"));
    }

}
