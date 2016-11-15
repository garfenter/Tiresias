package com.prequal.tiresias.integration;

public class CommandAPDU {
    private byte[] data;

    public CommandAPDU(byte[] data) {
        this.data = data;
    }

    public byte[] getData() {
        return this.data;
    }
}
