package com.alexanderrodnin.simplegraphlib.model;

import java.util.Set;

public interface GraphModel<Vertex> {
    void addVertex(Vertex vertex);

    void addEdge(Vertex source, Vertex destination);

    Set<Vertex> getAllVertexes();

    Set<Edge> getAllEdges();

    Set<Vertex> getEdgedVertexes(Vertex vertex);

    boolean containsVertex(Vertex vertex);

    boolean containsEdge(Vertex source, Vertex destination);
}
