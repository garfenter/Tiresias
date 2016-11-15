package com.prequal.tiresias;

import java.util.Arrays;

public class QuadByteArray {
    private byte[] a;
    private byte[] b;
    private byte[] c;
    private byte[] d;

    public QuadByteArray(byte[] c, byte[] a, byte[] b) {
        this.c = c;
        this.a = a;
        this.b = b;
    }

    public byte[] a() {
        return this.a;
    }

    public byte[] b() {
        return this.b;
    }

    public byte[] c() {
        return this.d;
    }

    public void a(byte[] d) {
        this.d = d;
    }

    public int hashCode() {
        return ((((((Arrays.hashCode(this.a) + 77) * 11) + Arrays.hashCode(this.b)) * 11) + Arrays.hashCode(this.c)) * 11) + Arrays.hashCode(this.d);
    }

    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        QuadByteArray y = (QuadByteArray) o;
        if (Arrays.equals(this.a, y.a) && Arrays.equals(this.b, y.b) && Arrays.equals(this.c, y.c) && Arrays.equals(this.d, y.d)) {
            return true;
        }
        return false;
    }
}
