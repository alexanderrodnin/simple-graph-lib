package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.finder.PathFindStrategy;
import com.alexanderrodnin.simplegraphlib.model.Edge;
import com.alexanderrodnin.simplegraphlib.model.GraphModel;

public class DirectedGraph<Vertex> extends AbstractBaseGraph<Vertex> {

    public DirectedGraph() {
        super();
    }

    public DirectedGraph(GraphModel<Vertex> model, PathFindStrategy<Vertex> pathFindStrategy) {
        super(model, pathFindStrategy);
    }

    @Override
    public void addEdge(Edge<Vertex> edge) {
        checkContainsVertex(edge.getSource());
        checkContainsVertex(edge.getDestination());
        checkContainsEdge(edge.getSource(), edge.getDestination());

        model.addEdge(edge.getSource(), edge.getDestination());
    }
}