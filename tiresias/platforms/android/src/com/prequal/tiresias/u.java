package com.prequal.tiresias;

/* renamed from: com.prequal.tiresias.u */
public class u {
    public static boolean a(final byte[] array, final int n, final byte[] array2, final int n2, final int n3) {
        final int d = x.d;
        int i = 0;
        while (i < n3) {
            final byte b2;
            final byte b = b2 = array[n + i];
            if (d != 0) {
                return b2 != 0;
            }
            if (b != array2[n2 + i]) {
                return false;
            }
            ++i;
            if (d != 0) {
                break;
            }
        }
        byte b2 = (byte) (true ? 1 : 0);
        return b2 != 0;
    }

    public static byte[] b(final byte[] array, final int n, final byte[] array2, final int n2, final int n3) {
        final int d = x.d;
        if (array.length - n < n3) {
            return null;
        }
        if (array2.length - n2 < n3) {
            return null;
        }
        final byte[] array3 = new byte[n3];
        int i = 0;
        byte[] array4 = null;
        while (i < n3) {
            array4 = array3;
            if (d != 0) {
                return array4;
            }
            array4[i] = (byte) (array[n + i] ^ array2[n2 + i]);
            ++i;
            if (d != 0) {
                break;
            }
        }
        return array4;
    }

    public static byte[] a(final int n) {
        return new byte[]{(byte) (n >>> 24), (byte) (n >>> 16), (byte) (n >>> 8), (byte) n};
    }
}
