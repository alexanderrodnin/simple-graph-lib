package com.alexanderrodnin.simplegraphlib.exceptions;

/**
 * Exception.
 * Throws if graph has not contain vertex.
 */
public class GraphHasNotContainVertex extends RuntimeException {

    public GraphHasNotContainVertex(Object vertex) {
        super("Graph has not contain vertex:" + vertex.toString() + ".");
    }
}
