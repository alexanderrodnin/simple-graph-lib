package com.alexanderrodnin.simplegraphlib.exceptions;

public class GraphHasNotContainVertex extends RuntimeException {

    public GraphHasNotContainVertex(Object vertex) {
        super("Graph has not contain vertex:" + vertex.toString() + ".");
    }
}
