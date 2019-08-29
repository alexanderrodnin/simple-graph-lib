package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.finder.PathFindStrategy;
import com.alexanderrodnin.simplegraphlib.model.Edge;
import com.alexanderrodnin.simplegraphlib.model.GraphModel;

/**
 * Undirect graph implementation
 * @param <Vertex> - vertex
 */
public class UndirectedGraph<Vertex> extends AbstractBaseGraph<Vertex> {

    public UndirectedGraph() {
        super();
    }

    public UndirectedGraph(GraphModel<Vertex> model, PathFindStrategy<Vertex> pathFindStrategy) {
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
        if (!edge.getSource().equals(edge.getDestination())) {
            checkContainsEdge(edge.getDestination(), edge.getSource());
        }

        model.addEdge(edge.getSource(), edge.getDestination());
        model.addEdge(edge.getDestination(), edge.getSource());

    }
}