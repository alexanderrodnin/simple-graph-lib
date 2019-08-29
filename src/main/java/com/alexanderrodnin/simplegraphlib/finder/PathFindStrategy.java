package com.alexanderrodnin.simplegraphlib.finder;

import com.alexanderrodnin.simplegraphlib.model.GraphModel;

import java.util.List;

@FunctionalInterface
public interface PathFindStrategy<Vertex> {

    List<Vertex> findPath(GraphModel<Vertex> graphModel, Vertex source, Vertex destination);

}
