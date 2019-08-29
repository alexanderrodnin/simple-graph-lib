package com.alexanderrodnin.simplegraphlib.finder;

import com.alexanderrodnin.simplegraphlib.model.GraphModel;

import java.util.List;

/**
 * PathFindStrategy represents the strategy of path finding algorithm between two Vertices.
 * @param <Vertex>
 */
@FunctionalInterface
public interface PathFindStrategy<Vertex> {

    List<Vertex> findPath(GraphModel<Vertex> graphModel, Vertex source, Vertex destination);

}
