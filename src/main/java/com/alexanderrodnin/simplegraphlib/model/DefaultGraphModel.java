package com.alexanderrodnin.simplegraphlib.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DefaultGraphModel<Vertex> implements GraphModel<Vertex> {

    private final Map<Vertex, Set<Vertex>> graph = new HashMap<>();

    @Override
    public void addVertex(Vertex vertex) {
        graph.put(vertex, new HashSet<>());
    }

    @Override
    public void addEdge(Vertex source, Vertex destination) {
        graph.get(source).add(destination);

    }

    @Override
    public Set<Vertex> getAllVertexes() {
        return graph.keySet();
    }

    @Override
    public Set<Edge> getAllEdges() {
        return graph.keySet().stream()
                .flatMap(
                        source -> graph.get(source).stream()
                                .map(destination -> new Edge<>(source, destination)))
                .collect(Collectors.toCollection(HashSet::new));
    }

    @Override
    public Set<Vertex> getEdgedVertexes(Vertex vertex) {
        return graph.get(vertex);
    }

    @Override
    public boolean containsVertex(Vertex vertex) {
        return graph.containsKey(vertex);
    }

    @Override
    public boolean containsEdge(Vertex source, Vertex destination) {
        return graph.containsKey(source) && graph.get(source).contains(destination);
    }
}
