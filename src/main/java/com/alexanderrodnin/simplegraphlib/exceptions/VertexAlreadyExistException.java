package com.alexanderrodnin.simplegraphlib.exceptions;

public class VertexAlreadyExistException extends RuntimeException {

    public VertexAlreadyExistException(Object vertex) {
        super("Vertex: " + vertex.toString() + "already exist.");
    }
}