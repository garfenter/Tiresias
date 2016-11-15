package com.prequal.tiresias.reader;

public class FtBlueReadException extends Exception {
    public FtBlueReadException(String msg) {
        super(msg);
    }

    public FtBlueReadException(Throwable throwable) {
        super(throwable);
    }

    public FtBlueReadException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }
}
