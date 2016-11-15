package com.prequal.tiresias;

import com.prequal.tiresias.integration.CardChannel;
import com.prequal.tiresias.integration.CardException;
import com.prequal.tiresias.integration.CommandAPDU;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class PersonSvcImpl3 extends PersonSvcImpl implements PersonSvc {
    private static byte[] f;
    private static byte[] g;
    private static byte[] h;
    private static final String[] i;

    @Override
    public ExtendedPerson readData(final CardChannel cardChannel) throws ReadException {
        final ExtendedPerson r = new ExtendedPerson();
//        final QuadByteArray a = this.getQuadByteArray(cardChannel, r);
//        r.D(this.b(cardChannel, a));
        this.b(cardChannel, r);
        return r;
    }

    private String b(final CardChannel cardChannel, final QuadByteArray y) throws ReadException {
        final int d = PersonSvcImpl.d;
        final byte[] a = CryptUtil.a(cardChannel, y, PersonSvcImpl3.i[1]);
        try {
            if (!PersonSvcImpl.a(a)) {
                throw new ReadException(PersonSvcImpl3.i[0]);
            }
        } catch (ReadException e) {
            throw e;
        }
        if (a == null) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        int i = 5;
        while (i < a.length - 2) {
            final StringBuilder append = sb.append((char) (a[i] & 0xFF));
            if (d != 0) {
                return append.toString();
            }
            ++i;
            if (d == 0) {
                continue;
            }
            break;
        }
        final StringBuilder append = sb;
        return append.toString();
    }

    protected long al(final byte[] array) {
        if (array == null) {
            final long long1 = -1L;
            if (PersonSvcImpl.d == 0) {
                return long1;
            }
        }
        return Long.parseLong(x.f(Arrays.copyOf(array, 7)));
    }

    private void a(final ExtendedPerson r, final byte[] array) {
        if (r == null || array == null) {
            return;
        }
        int n = 0;
        final String c;
        final String s = c = x.c(array);
        final int n2 = n;
        n += 30;
        r.F(c.substring(n2, n).trim());
        final String s2 = s;
        final int n3 = n;
        n += 13;
        r.d(s2.substring(n3, n).trim());
        final String s3 = s;
        final int n4 = n;
        n += 25;
        r.q(s3.substring(n4, n).trim());
        final String s4 = s;
        final int n5 = n;
        n += 25;
        r.r(s4.substring(n5, n).trim());
        final String s5 = s;
        final int n6 = n;
        n += 50;
        r.E(s5.substring(n6, n).trim());
        final String s6 = s;
        final int n7 = n;
        n += 25;
        r.a(s6.substring(n7, n).trim());
        final String s7 = s;
        final int n8 = n;
        n += 25;
        r.b(s7.substring(n8, n).trim());
        final String s8 = s;
        final int n9 = n;
        n += 25;
        r.c(s8.substring(n9, n).trim());
        final String s9 = s;
        final int n10 = n;
        n += 9;
        r.i(s9.substring(n10, n).trim());
        final String s10 = s;
        final int n11 = n;
        n += 30;
        r.l(s10.substring(n11, n).trim());
        final String s11 = s;
        final int n12 = n;
        n += 30;
        r.n(s11.substring(n12, n).trim());
        final String s12 = s;
        final int n13 = n;
        n += 3;
        r.o(s12.substring(n13, n).trim());
        final String s13 = s;
        final int n14 = n;
        n += 10;
        r.m(s13.substring(n14, n).trim());
        final String s14 = s;
        final int n15 = n;
        n += 10;
        r.f(s14.substring(n15, n).trim());
        final String s15 = s;
        final int n16 = n;
        n += 10;
        r.g(s15.substring(n16, n).trim());
        final String s16 = s;
        final int n17 = n;
        n += 3;
        r.p(s16.substring(n17, n).trim());
        final String s17 = s;
        final int n18 = n;
        n += 30;
        r.k(s17.substring(n18, n).trim());
        final String s18 = s;
        final int n19 = n;
        n += 48;
        r.G(s18.substring(n19, n).trim());
        final String s19 = s;
        final int n20 = n;
        n += 15;
        r.e(s19.substring(n20, n).trim());
        final String s20 = s;
        final int n21 = n;
        n += 30;
        r.v(s20.substring(n21, n).trim());
        final String s21 = s;
        final int n22 = n;
        n += 30;
        r.w(s21.substring(n22, n).trim());
        final String s22 = s;
        final int n23 = n;
        n += 10;
        r.j(s22.substring(n23, n).trim());
        final String s23 = s;
        final int n24 = n;
        n += 10;
        r.h(s23.substring(n24, n).trim());
        final String s24 = s;
        final int n25 = n;
        n += 10;
        r.s(s24.substring(n25, n).trim());
        final String s25 = s;
        final int n26 = n;
        n += 20;
        r.H(s25.substring(n26, n).trim());
        final String s26 = s;
        final int n27 = n;
        n += 20;
        r.I(s26.substring(n27, n).trim());
    }

    private void b(final ExtendedPerson r, final byte[] array) {
        if (r == null || array == null) {
            return;
        }
        int n = 0;
        final String c;
        final String s = c = x.c(array);
        final int n2 = n;
        n += 15;
        r.z(c.substring(n2, n).trim());
        final String s2 = s;
        final int n3 = n;
        n += 30;
        r.x(s2.substring(n3, n).trim());
        final String s3 = s;
        final int n4 = n;
        n += 30;
        r.y(s3.substring(n4, n).trim());
        r.u(s.substring(n, ++n).trim());
        r.t(s.substring(n, ++n).trim());
        r.J(s.substring(n, ++n).trim());
        r.A(s.substring(n, ++n).trim());
        final String s4 = s;
        final int n5 = n;
        n += 150;
        r.B(s4.substring(n5, n).trim());
        final String s5 = s;
        final int n6 = n;
        n += 10;
        r.K(s5.substring(n6, n).trim());
        final String s6 = s;
        final int n7 = n;
        n += 15;
        r.L(s6.substring(n7, n).trim());
        final String s7 = s;
        final int n8 = n;
        n += 15;
        r.M(s7.substring(n8, n).trim());
        final String s8 = s;
        final int n9 = n;
        n += 13;
        r.N(s8.substring(n9, n).trim());
        final String s9 = s;
        final int n10 = n;
        n += 4000;
        r.O(s9.substring(n10, n).trim());
        final String s10 = s;
        final int n11 = n;
        n += 20;
        r.P(s10.substring(n11, n).trim());
        final String s11 = s;
        final int n12 = n;
        n += 20;
        r.Q(s11.substring(n12, n).trim());
        final String s12 = s;
        final int n13 = n;
        n += 50;
        r.R(s12.substring(n13, n).trim());
        final String s13 = s;
        final int n14 = n;
        n += 50;
        r.S(s13.substring(n14, n).trim());
    }

    public void a(final byte[] array, final byte[] array2, final ExtendedPerson r) {
        this.a(r, array);
        this.b(r, array2);
    }

    private QuadByteArray getQuadByteArray(final CardChannel cardChannel, final ExtendedPerson r) throws ReadException {
        this.b(cardChannel, r);
        final QuadByteArray a = CryptUtil.digestByte(r.d().substring(0, 9), x.c(r.m()), x.a(x.a(r.g(), r.f())));
        try {
            final byte[] bytes = cardChannel.transmit(new CommandAPDU(PersonSvcImpl3.b)).getBytes();
            if (!PersonSvcImpl.a(bytes)) {
                throw new ReadException(PersonSvcImpl3.i[12]);
            }
            final byte[] bytes2 = cardChannel.transmit(new CommandAPDU(PersonSvcImpl3.g)).getBytes();
            if (!PersonSvcImpl.a(bytes2)) {
                throw new ReadException(PersonSvcImpl3.i[11]);
            }
            final byte[] copyOfRange = Arrays.copyOfRange(bytes2, 0, bytes2.length - 2);
            final byte[] a2 = CryptUtil.a(copyOfRange, a);
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(PersonSvcImpl3.h);
            byteArrayOutputStream.write(a2);
            byteArrayOutputStream.write(0);
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            final byte[] bytes3 = cardChannel.transmit(new CommandAPDU(byteArray)).getBytes();
            if (!PersonSvcImpl.a(bytes3)) {
                throw new ReadException(PersonSvcImpl3.i[10]);
            }
            return CryptUtil.a(copyOfRange, Arrays.copyOfRange(bytes3, 0, bytes3.length - 2), a);
        } catch (CardException ex4) {
            throw new ReadException(ex4);
        } catch (IOException ex5) {
            throw new ReadException(ex5);
        }
    }

    private void b(final CardChannel cardChannel, final ExtendedPerson r) throws ReadException {
        try {
            final byte[] bytes = cardChannel.transmit(new CommandAPDU(PersonSvcImpl3.f)).getBytes();
            if (!PersonSvcImpl.a(bytes)) {
                throw new ReadException(PersonSvcImpl3.i[2]);
            }
            this.a(this.a(cardChannel, (byte) 1, (byte) 0, 553), this.a(cardChannel, (byte) 2, (byte) 0, 4422), r);
        } catch (CardException ex2) {
            throw new ReadException(ex2);
        }
    }

    static {
        final String[] j = new String[13];
        int n13;
        int n12;
        int n11;
        int n10;
        int n9;
        int n8;
        int n7;
        int n6;
        int n5;
        int n4;
        int n3;
        int n2;
        int n = n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 0)))))))))));
        String s = "\u001a\u001f?--\u007f\u0000,,;>\u0003)-\u007f:\u0001m!02\f#&0\u007f\t(b\u001e\u000f)\u0018l";
        int n14 = -1;
        String intern = null;
        Label_0135:
        while (true) {
            final char[] charArray = s.toCharArray();
            final int k = charArray.length;
            for (int n15 = 0; k > n15; ++n15) {
                final int n16 = n15;
                final char c = charArray[n16];
                char c2 = '\0';
                switch (n15 % 5) {
                    case 0: {
                        c2 = '_';
                        break;
                    }
                    case 1: {
                        c2 = 'm';
                        break;
                    }
                    case 2: {
                        c2 = 'M';
                        break;
                    }
                    case 3: {
                        c2 = 'B';
                        break;
                    }
                    default: {
                        c2 = '_';
                        break;
                    }
                }
                charArray[n16] = (char) (c ^ c2);
            }
            intern = new String(charArray).intern();
            switch (n14) {
                default: {
                    j[n2] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 1))))))))))));
                    s = "o]\u000frgn]}w\u001b";
                    n14 = 0;
                    continue;
                }
                case 0: {
                    j[n] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 2))))))))))));
                    s = "\u001a\u001f?--\u007f\u0000,,;>\u0003)-\u007f:\u0001m!02\f#&0\u007f.\u0000\u0006\u0000\u001e=\t\u0017q";
                    n14 = 1;
                    continue;
                }
                case 1: {
                    j[n3] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 3))))))))))));
                    s = "z]\u007f\u001a";
                    n14 = 2;
                    continue;
                }
                case 2: {
                    j[n4] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 4))))))))))));
                    s = "z]y\u001a";
                    n14 = 3;
                    continue;
                }
                case 3: {
                    j[n5] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 5))))))))))));
                    s = "o]\u000frgm]}";
                    n14 = 4;
                    continue;
                }
                case 4: {
                    j[n6] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 6))))))))))));
                    s = "o]|roo";
                    n14 = 5;
                    continue;
                }
                case 5: {
                    j[n7] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 7))))))))))));
                    s = "o]\u000fr";
                    n14 = 6;
                    continue;
                }
                case 6: {
                    j[n8] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 8))))))))))));
                    s = "\u001a\u001f?--\u007f\u001f(#;6\u0003*b/7\u00029-e\u007f";
                    n14 = 7;
                    continue;
                }
                case 7: {
                    j[n9] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 9))))))))))));
                    s = "\u001a\u001f?--\u007f\u0000,,;>\u0003)-\u007f:\u0001m!02\f#&0\u007f\t(b\u001e\u000f)\u0018l";
                    n14 = 8;
                    continue;
                }
                case 8: {
                    j[n10] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 10))))))))))));
                    s = "\u001a\u001f?--\u007f\u0000,,;>\u0003)-\u007f:\u0001m!02\f#&0\u007f.\u0000\u0006\u0000\u00128\u0019\u0017\u001e\u00132\f\u0017\u000b\u0017(\u0003\u0016\u0016\u001c,\u0019\u0007q";
                    n14 = 9;
                    continue;
                }
                case 9: {
                    j[n11] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 11))))))))))));
                    s = "\u001a\u001f?--\u007f\u0000,,;>\u0003)-\u007f:\u0001m!02\f#&0\u007f.\u0000\u0006\u0000\u0018(\u0019\u001d\u001c\u0017,\u0001\u000e\u001a\u0011*\bl";
                    n14 = 10;
                    continue;
                }
                case 10: {
                    j[n12] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 12))))))))))));
                    s = "\u001a\u001f?--\u007f\u0000,,;>\u0003)-\u007f:\u0001m!02\f#&0\u007f.\u0000\u0006\u0000\f(\u0001\u0007\u001c\u000b2\u0001\u0006\fq";
                    n14 = 11;
                    continue;
                }
                case 11: {
                    break Label_0135;
                }
            }
        }
        j[n13] = intern;
        i = j;
        String s2 = "o]\fvok]\u000er\u001c\u001e]}roo]}tlj]y\u0000klX~p\u001bl\\~w";
        int n17 = -1;
        String intern2 = null;
        Label_0467:
        while (true) {
            final char[] charArray2 = s2.toCharArray();
            final int l = charArray2.length;
            for (int n18 = 0; l > n18; ++n18) {
                final int n19 = n18;
                final char c3 = charArray2[n19];
                char c4 = '\0';
                switch (n18 % 5) {
                    case 0: {
                        c4 = '_';
                        break;
                    }
                    case 1: {
                        c4 = 'm';
                        break;
                    }
                    case 2: {
                        c4 = 'M';
                        break;
                    }
                    case 3: {
                        c4 = 'B';
                        break;
                    }
                    default: {
                        c4 = '_';
                        break;
                    }
                }
                charArray2[n19] = (char) (c3 ^ c4);
            }
            intern2 = new String(charArray2).intern();
            switch (n17) {
                default: {
                    f = x.a(intern2);
                    s2 = "o]uvoo]}rg";
                    n17 = 0;
                    continue;
                }
                case 0: {
                    g = x.a(intern2);
                    s2 = "o]upoo]}pg";
                    n17 = 1;
                    continue;
                }
                case 1: {
                    break Label_0467;
                }
            }
        }
        h = x.a(intern2);
    }
}
