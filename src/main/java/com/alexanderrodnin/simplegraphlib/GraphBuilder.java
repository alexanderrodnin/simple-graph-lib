package com.alexanderrodnin.simplegraphlib;

import com.alexanderrodnin.simplegraphlib.finder.FirstFoundPathFindStrategy;
import com.alexanderrodnin.simplegraphlib.finder.PathFindStrategy;
import com.alexanderrodnin.simplegraphlib.model.Edge;
import com.alexanderrodnin.simplegraphlib.model.DefaultGraphModel;
import com.alexanderrodnin.simplegraphlib.model.GraphModel;

import java.util.ArrayList;
import java.util.List;

public class GraphBuilder<Vertex> {

    private enum GraphType {
        DIRECTED,
        UNDIRECTED,
        CUSTOM
    }

    private GraphType graphType;
    private PathFindStrategy<Vertex> pathFindStrategy;
    private List<Vertex> vertexes = new ArrayList<>();
    private List<Edge<Vertex>> edges = new ArrayList<>();
    private Graph<Vertex> customGraph;
    private GraphModel<Vertex> graphModel;

    private GraphBuilder(GraphType graphType) {
        this.graphType = graphType;
    }

    public static <Vertex> GraphBuilder<Vertex> directed() {
        return new GraphBuilder<>(GraphType.DIRECTED);
    }

    public static <Vertex> GraphBuilder<Vertex> undirected() {
        return new GraphBuilder<>(GraphType.UNDIRECTED);
    }

    public static <Vertex> GraphBuilder<Vertex> custom(Graph<Vertex> graph) {
        GraphBuilder<Vertex> builder = new GraphBuilder<>(GraphType.CUSTOM);
        builder.customGraph = graph;

        return builder;
    }

    public GraphBuilder<Vertex> setCustomPathFindStrategy(PathFindStrategy<Vertex> pathFindStrategy) {
        this.pathFindStrategy = pathFindStrategy;
        return this;
    }

    public GraphBuilder<Vertex> setCustomGraphModel(GraphModel<Vertex> graphModel) {
        this.graphModel = graphModel;
        return this;
    }

    public GraphBuilder<Vertex> addVertex(Vertex vertex) {
        vertexes.add(vertex);
        return this;
    }

    public GraphBuilder<Vertex> addEdge(Vertex source, Vertex destination) {
        return addEdge(new Edge<>(source, destination));
    }


    public GraphBuilder<Vertex> addEdge(Edge<Vertex> edge) {
        edges.add(edge);
        return this;
    }

    public Graph<Vertex> build() {
        Graph<Vertex> graph = graph();

        vertexes.forEach(graph::addVertex);
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
            case CUSTOM:
                graph = customGraph;
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
