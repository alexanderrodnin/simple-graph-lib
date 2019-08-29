package com.alexanderrodnin.simplegraphlib.finder;

import com.alexanderrodnin.simplegraphlib.model.GraphModel;

import java.util.List;

/**
 * PathFindStrategy represents the strategy of path finding algorithm between two vertices.
 * @param <Vertex>
 */
@FunctionalInterface
public interface PathFindStrategy<Vertex> {

    /**
     * Find path.
     * @param graphModel - #GraphModel .
     * @param source - source vertex.
     * @param destination - destination vertex.
     * @return path between two vertices
     */
    List<Vertex> findPath(GraphModel<Vertex> graphModel, Vertex source, Vertex destination);

}
