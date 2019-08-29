package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.finder.FirstFoundPathFindStrategy;
import com.alexanderrodnin.simplegraphlib.finder.PathFindStrategy;
import com.alexanderrodnin.simplegraphlib.exceptions.EdgeAlreadyExistException;
import com.alexanderrodnin.simplegraphlib.exceptions.GraphHasNotContainVertex;
import com.alexanderrodnin.simplegraphlib.exceptions.VertexAlreadyExistException;
import com.alexanderrodnin.simplegraphlib.model.DefaultGraphModel;
import com.alexanderrodnin.simplegraphlib.model.Edge;
import com.alexanderrodnin.simplegraphlib.model.GraphModel;

import java.util.*;

public abstract class AbstractBaseGraph<Vertex> implements Graph<Vertex>  {

    protected final GraphModel<Vertex> model;

    private final PathFindStrategy<Vertex> pathFindStrategy;

    public AbstractBaseGraph() {
        this(new DefaultGraphModel<>(), new FirstFoundPathFindStrategy<>());
    }

    public AbstractBaseGraph(GraphModel<Vertex> model, PathFindStrategy<Vertex> pathFindStrategy) {
        this.model = model;
        this.pathFindStrategy = pathFindStrategy;
    }

    @Override
    public void addVertex(Vertex vertex) {
        if (model.containsVertex(vertex)) {
            throw new VertexAlreadyExistException(vertex);
        }

        model.addVertex(vertex);
    }

    @Override
    public List<Vertex> getPath(Vertex source, Vertex destination) {
        return pathFindStrategy.findPath(model, source, destination);
    }

    @Override
    public String toString() {
        return "Vertices: " + model.getAllVertices() + ", Edges: " + model.getAllEdges();
    }

    protected void checkContainsVertex(Vertex vertex) {
        if(!model.containsVertex(vertex)) {
            throw new GraphHasNotContainVertex(vertex);
        }
    }

    protected void checkContainsEdge(Vertex source, Vertex destination) {
        if(model.containsEdge(source, destination)) {
            throw new EdgeAlreadyExistException(new Edge<>(source, destination));
        }
    }

}
