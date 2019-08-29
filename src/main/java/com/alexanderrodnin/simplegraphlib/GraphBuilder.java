package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.finder.FirstFoundPathFindStrategy;
import com.alexanderrodnin.simplegraphlib.finder.PathFindStrategy;
import com.alexanderrodnin.simplegraphlib.model.Edge;
import com.alexanderrodnin.simplegraphlib.model.DefaultGraphModel;
import com.alexanderrodnin.simplegraphlib.model.GraphModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Graph builder
 * @param <Vertex> - vertex.
 */
public class GraphBuilder<Vertex> {

    private enum GraphType {
        DIRECTED,
        UNDIRECTED,
    }

    private GraphType graphType;
    private PathFindStrategy<Vertex> pathFindStrategy;
    private List<Vertex> vertices = new ArrayList<>();
    private List<Edge<Vertex>> edges = new ArrayList<>();
    private GraphModel<Vertex> graphModel;

    private GraphBuilder(GraphType graphType) {
        this.graphType = graphType;
    }

    /**
     * Create directed graph.
     * @param <Vertex> - vertex.
     * @return #GraphBuilder .
     */
    public static <Vertex> GraphBuilder<Vertex> directed() {
        return new GraphBuilder<>(GraphType.DIRECTED);
    }

    /**
     * Create undirected graph.
     * @param <Vertex> - vertex.
     * @return #GraphBuilder .
     */
    public static <Vertex> GraphBuilder<Vertex> undirected() {
        return new GraphBuilder<>(GraphType.UNDIRECTED);
    }

    /**
     * Set custom path find strategy.
     * @param pathFindStrategy - custom path find strategy.
     * @return #GraphBuilder .
     */
    public GraphBuilder<Vertex> setCustomPathFindStrategy(PathFindStrategy<Vertex> pathFindStrategy) {
        this.pathFindStrategy = pathFindStrategy;
        return this;
    }

    /**
     * Set custom model.
     * @param graphModel - custom graph model.
     * @return #GraphBuilder .
     */
    public GraphBuilder<Vertex> setCustomGraphModel(GraphModel<Vertex> graphModel) {
        this.graphModel = graphModel;
        return this;
    }

    /**
     * Add vertex.
     * @param vertex - vertex.
     * @return #GraphBuilder .
     */
    public GraphBuilder<Vertex> addVertex(Vertex vertex) {
        vertices.add(vertex);
        return this;
    }

    /**
     * Add edge
     * @param source - destination vertex.
     * @param destination - destination vertex.
     * @return #GraphBuilder .
     */
    public GraphBuilder<Vertex> addEdge(Vertex source, Vertex destination) {
        return addEdge(new Edge<>(source, destination));
    }

    /**
     * Add edge
     * @param edge - #Edge that should be added.
     * @return #GraphBuilder .
     */
    public GraphBuilder<Vertex> addEdge(Edge<Vertex> edge) {
        edges.add(edge);
        return this;
    }

    /**
     * Build graph
     * @return instance of #Graph .
     */
    public Graph<Vertex> build() {
        Graph<Vertex> graph = graph();

        vertices.forEach(graph::addVertex);
        edges.forEach(graph::addEdge);

        return graph;
    }

    private Graph<Vertex> graph() {
        Graph<Vertex> graph = null;

        switch(graphType) {
            case DIRECTED: {
                graph = new DirectedGraph<>(graphModel(), pathFindStrategy());
                break;
            }
            case UNDIRECTED: {
                graph = new UndirectedGraph<>(graphModel(), pathFindStrategy());
                break;
            }
        }

        return graph;
    }

    private PathFindStrategy<Vertex> pathFindStrategy() {
        return pathFindStrategy != null ? pathFindStrategy : new FirstFoundPathFindStrategy<>();
    }

    private GraphModel<Vertex> graphModel() {
        return graphModel != null ? graphModel: new DefaultGraphModel<>();
    }

}
