package com.prequal.tiresias;

public enum DPIVersion {
    v1(2009),
    v2(2014);

    private int a;
    private static final String[] c;

    private DPIVersion(final int a) {
        this.a = a;
    }

    public int getYear() {
        return this.a;
    }

    static {
        final String[] c2 = new String[2];
        int n2;
        int n = n2 = 0;
        String s = "?\u001d";
        int n3 = -1;
        String intern = null;
        Label_0022:
        while (true) {
            final char[] charArray = s.toCharArray();
            final int i = charArray.length;
            for (int n4 = 0; i > n4; ++n4) {
                final int n5 = n4;
                final char c3 = charArray[n5];
                char c4 = '\0';
                switch (n4 % 5) {
                    case 0: {
                        c4 = 'I';
                        break;
                    }
                    case 1: {
                        c4 = '/';
                        break;
                    }
                    case 2: {
                        c4 = '4';
                        break;
                    }
                    case 3: {
                        c4 = 'g';
                        break;
                    }
                    default: {
                        c4 = '\u001c';
                        break;
                    }
                }
                charArray[n5] = (char)(c3 ^ c4);
            }
            intern = new String(charArray).intern();
            switch (n3) {
                default: {
                    c2[n2] = intern;
                    n = (n2 = 1);
                    s = "?\u001e";
                    n3 = 0;
                    continue;
                }
                case 0: {
                    break Label_0022;
                }
            }
        }
        c2[n] = intern;
        c = c2;
    }
}
