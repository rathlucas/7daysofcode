package dev.lucin.sevendaysofcode.exceptions;

public class MovieIntegrationException extends RuntimeException {

    private int statusCode;

    public MovieIntegrationException(String message, int statusCode) {
        super(message);
        this.statusCode = statusCode;
    }
}
