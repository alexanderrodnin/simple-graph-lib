package com.alexanderrodnin.simplegraphlib.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Default implementation of #GraphModel .
 * @param <Vertex> - vertex
 */
public class DefaultGraphModel<Vertex> implements GraphModel<Vertex> {

    private final Map<Vertex, Set<Vertex>> graph = new HashMap<>();

    /**
     * @see GraphModel#addVertex(Object)
     */
    @Override
    public void addVertex(Vertex vertex) {
        graph.put(vertex, new HashSet<>());
    }


    /**
     * @see GraphModel#addEdge(Object, Object)
     */
    @Override
    public void addEdge(Vertex source, Vertex destination) {
        graph.get(source).add(destination);

    }

    /**
     * @see GraphModel#getAllVertices()
     */
    @Override
    public Set<Vertex> getAllVertices() {
        return graph.keySet();
    }

    /**
     * @see GraphModel#getAllEdges()
     */
    @Override
    public Set<Edge> getAllEdges() {
        return graph.keySet().stream()
                .flatMap(
                        source -> graph.get(source).stream()
                                .map(destination -> new Edge<>(source, destination)))
                .collect(Collectors.toCollection(HashSet::new));
    }

    /**
     * @see GraphModel#getConnectedVertices(Object)
     */
    @Override
    public Set<Vertex> getConnectedVertices(Vertex vertex) {
        return graph.get(vertex);
    }

    /**
     * @see GraphModel#containsVertex(Object)
     */
    @Override
    public boolean containsVertex(Vertex vertex) {
        return graph.containsKey(vertex);
    }


    /**
     * @see GraphModel#containsEdge(Object, Object)
     */
    @Override
    public boolean containsEdge(Vertex source, Vertex destination) {
        return graph.containsKey(source) && graph.get(source).contains(destination);
    }
}
