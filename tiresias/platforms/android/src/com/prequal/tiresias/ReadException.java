package com.prequal.tiresias;

public class ReadException extends Exception {
    public static int b;

    public ReadException(Exception ex) {
        super(ex);
    }

    public ReadException(String message) {
        super(message);
    }

    public ReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
