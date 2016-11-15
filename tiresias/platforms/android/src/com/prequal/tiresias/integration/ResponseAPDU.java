package com.prequal.tiresias.integration;

public class ResponseAPDU {
    byte[] result;

    public ResponseAPDU(byte[] result) {
        this.result = result;
    }

    public byte[] getBytes() {
        return this.result;
    }
}
