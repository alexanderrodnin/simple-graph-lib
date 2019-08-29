package com.alexanderrodnin.simplegraphlib.exceptions;

/**
 * Exception.
 * Throws if graph already contains the vertex.
 */
public class VertexAlreadyExistException extends RuntimeException {

    public VertexAlreadyExistException(Object vertex) {
        super("Vertex: " + vertex.toString() + "already exist.");
    }
}