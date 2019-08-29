package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.finder.PathFindStrategy;
import com.alexanderrodnin.simplegraphlib.model.Edge;
import com.alexanderrodnin.simplegraphlib.model.GraphModel;

/**
 * Direct graph implementation
 * @param <Vertex> - vertex
 */
public class DirectedGraph<Vertex> extends AbstractBaseGraph<Vertex> {

    public DirectedGraph() {
        super();
    }

    public DirectedGraph(GraphModel<Vertex> model, PathFindStrategy<Vertex> pathFindStrategy) {
        super(model, pathFindStrategy);
    }

    /**
     * @see Graph#addEdge(Edge)
     */
    @Override
    public void addEdge(Edge<Vertex> edge) {
        checkContainsVertex(edge.getSource());
        checkContainsVertex(edge.getDestination());
        checkContainsEdge(edge.getSource(), edge.getDestination());

        model.addEdge(edge.getSource(), edge.getDestination());
    }
}