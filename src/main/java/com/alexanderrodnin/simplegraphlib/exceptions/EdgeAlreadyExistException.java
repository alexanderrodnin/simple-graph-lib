package com.alexanderrodnin.simplegraphlib.exceptions;

public class EdgeAlreadyExistException extends RuntimeException {

    public EdgeAlreadyExistException(Object edge) {
        super("Edge: " + edge.toString() + " already exist.");
    }
}
