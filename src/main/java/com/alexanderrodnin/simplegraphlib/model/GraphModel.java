package com.alexanderrodnin.simplegraphlib.model;

import java.util.Set;

/**
 * Represents the model of graph structure.
 * @param <Vertex> user defined type of vertex.
 */
public interface GraphModel<Vertex> {
    /**
     * Add vertex to the graph.
     * @param vertex - vertex.
     */
    void addVertex(Vertex vertex);

    /**
     * Add edge to the graph.
     * @param source - source vertex.
     * @param destination - destination vertex.
     */
    void addEdge(Vertex source, Vertex destination);

    /**
     * @return all vertices.
     */
    Set<Vertex> getAllVertices();

    /**
     * @return all edges.
     */
    Set<Edge> getAllEdges();

    /**
     * @param vertex - source vertex.
     * @return connected vertices.
     */
    Set<Vertex> getConnectedVertices(Vertex vertex);

    /**
     * Check if vertex contains.
     * @param vertex - source vertex.
     * @return true if vertex contains.
     */
    boolean containsVertex(Vertex vertex);

    /**
     * Check if edge between two vertices contains.
     * @param source - source vertex.
     * @param destination - destination vertex.
     * @return true if edge between two vertices contains.
     */
    boolean containsEdge(Vertex source, Vertex destination);
}
