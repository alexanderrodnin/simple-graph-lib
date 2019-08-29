package com.alexanderrodnin.simplegraphlib.model;

import java.util.Set;

public interface GraphModel<Vertex> {
    void addVertex(Vertex vertex);

    void addEdge(Vertex source, Vertex destination);

    Set<Vertex> getAllVertices();

    Set<Edge> getAllEdges();

    Set<Vertex> getEdgedVertices(Vertex vertex);

    boolean containsVertex(Vertex vertex);

    boolean containsEdge(Vertex source, Vertex destination);
}
