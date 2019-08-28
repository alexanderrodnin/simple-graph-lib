package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.model.Edge;

import java.util.List;

public interface Graph<Vertex> {

    void addVertex(Vertex vertex);

    void addEdge(Edge<Vertex> edge);

    List<Vertex> getPath(Vertex source, Vertex destination);

}
