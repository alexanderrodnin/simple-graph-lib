package com.alexanderrodnin.simplegraphlib.model;

import java.util.Objects;

/**
 * Data class.
 * Represents connection between two vertices.
 * @param <Vertex> User defined type of vertex.
 */
public class Edge<Vertex> {

    /**
     * @return source vertex
     */
    private final Vertex source;
    /**
     * @return destination vertex
     */
    private final Vertex destination;

    /**
     * Create a new Edge.
     * @param source - source vertex
     * @param destination - destination vertex
     */
    public Edge(Vertex source, Vertex destination) {
        this.source = source;
        this.destination = destination;
    }

    /**
     * @see #source
     */
    public Vertex getSource() {
        return source;
    }

    /**
     * @see #destination
     */
    public Vertex getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "source=" + source +
                ", destination=" + destination +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Edge)) return false;
        Edge<?> edge = (Edge<?>) o;
        return Objects.equals(source, edge.source) &&
                Objects.equals(destination, edge.destination);
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination);
    }

}
