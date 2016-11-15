package com.prequal.tiresias;

/* renamed from: com.prequal.tiresias.v */
public class v {
    public static int a(final String s) {
        final int d = x.d;
        final int[] array = {7, 3, 1};
        int n = 0;
        int i = 0;
        while (i < s.length()) {
            final char char1 = s.charAt(i);
            final int n2;
            final char c = (char) (n2 = char1);
            final int n4;
            final int n3 = n4 = 48;
            if (d != 0) {
                return n2 % n4;
            }
            char c2 = '\0';
            Label_0095:
            {
                if (c >= n3 && char1 <= '9') {
                    c2 = (char) (char1 - '0');
                    if (d == 0) {
                        break Label_0095;
                    }
                }
                if (char1 >= 'A' && char1 <= 'Z') {
                    c2 = (char) (char1 - '7');
                    if (d == 0) {
                        break Label_0095;
                    }
                }
                c2 = '\0';
            }
            n += c2 * array[i % 3];
            ++i;
            if (d != 0) {
                break;
            }
        }
        int n2 = n;
        int n4 = 10;
        return n2 % n4;
    }
}
