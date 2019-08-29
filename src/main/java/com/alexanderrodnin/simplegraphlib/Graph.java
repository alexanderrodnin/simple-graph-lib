package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.model.Edge;

import java.util.List;

/**
 * Graph represents a graph structure. Working with user defined type of vertex.
 * @param <Vertex> - vertex.
 */
public interface Graph<Vertex> {

    /**
     * Add vertex to the graph.
     * @param vertex - vertex.
     */
    void addVertex(Vertex vertex);

    /**
     * Add edge to the graph.
     * @param edge - edge.
     */
    void addEdge(Edge<Vertex> edge);

    /**
     * Find path between two vertices.
     * @param source - source vertex.
     * @param destination - destination vertex.
     * @return path between two vertices.
     */
    List<Vertex> getPath(Vertex source, Vertex destination);

}
