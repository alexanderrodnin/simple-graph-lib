package com.alexanderrodnin.simplegraphlib.exceptions;

/**
 * Exception.
 * Throws if graph already contains the edge.
 */
public class EdgeAlreadyExistException extends RuntimeException {

    public EdgeAlreadyExistException(Object edge) {
        super("Edge: " + edge.toString() + " already exist.");
    }
}
