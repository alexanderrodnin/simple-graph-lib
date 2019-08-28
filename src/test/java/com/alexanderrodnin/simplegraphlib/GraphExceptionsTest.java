package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.exceptions.EdgeAlreadyExistException;
import com.alexanderrodnin.simplegraphlib.exceptions.GraphHasNotContainVertex;
import com.alexanderrodnin.simplegraphlib.exceptions.VertexAlreadyExistException;
import com.alexanderrodnin.simplegraphlib.model.Edge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GraphExceptionsTest {

    private Graph<String> graph;

    @BeforeEach
    void init() {
        graph = GraphBuilder.<String>undirected().build();
    }

    @Test
    void vertexAlreadyExistExceptionTest() {
        graph.addVertex("A");
        Assertions.assertThrows(VertexAlreadyExistException.class, () -> graph.addVertex("A"));
    }

    @Test
    void edgeAlreadyExistException() {
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge(new Edge<>("A", "B"));
        Assertions.assertThrows(EdgeAlreadyExistException.class, () -> graph.addEdge(new Edge<>("A", "B")));
    }

    @Test
    void graphHasNotContainVertex() {
        graph.addVertex("A");
        Assertions.assertThrows(GraphHasNotContainVertex.class, () -> graph.addEdge(new Edge<>("A", "B")));
    }


}