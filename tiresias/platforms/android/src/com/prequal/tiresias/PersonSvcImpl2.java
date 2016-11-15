package com.prequal.tiresias;

import com.prequal.tiresias.integration.CardChannel;
import com.prequal.tiresias.integration.CardException;
import com.prequal.tiresias.integration.CommandAPDU;
import com.prequal.tiresias.integration.ResponseAPDU;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class PersonSvcImpl2 extends PersonSvcImpl implements PersonSvc {
    private static byte[] e = null;
    private static byte[] f = null;
    private static byte[] g = null;
    private static byte[] h = null;
    private static byte[] i = null;
    private static byte[] j = null;
    private static byte[] k = null;
    private static byte[] l = null;
    private static CommandAPDU m;
    private static CommandAPDU n;
    private static CommandAPDU o;
    private static CommandAPDU p;
    private static CommandAPDU q;
    private static CommandAPDU r;
    private static CommandAPDU s;
    private static CommandAPDU t;
    private static CommandAPDU u;
    private static String[] v;

    public ExtendedPerson b(final CardChannel cardChannel) throws ReadException {
        try {
            try {
                if (!PersonSvcImpl.isValid(cardChannel.transmit(PersonSvcImpl2.n))) {
                    throw new ReadException(PersonSvcImpl2.v[4]);
                }
            } catch (CardException ex) {
                throw ex;
            }
            try {
                if (!PersonSvcImpl.isValid(cardChannel.transmit(PersonSvcImpl2.q))) {
                //    throw new ReadException(PersonSvcImpl2.v[3]);
                }
            } catch (CardException ex2) {
                throw ex2;
            }
            try {
                if (!PersonSvcImpl.isValid(cardChannel.transmit(PersonSvcImpl2.r))) {
                //    throw new ReadException(PersonSvcImpl2.v[6]);
                }
            } catch (CardException ex3) {
                throw ex3;
            }
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(x.e(this.a(cardChannel, (byte) 0, (byte) 0, (byte) (-1))));
            final byte[] a = this.a(cardChannel, (byte) 0, (byte) (-1), (byte) (-1));
            try {
                byteArrayOutputStream.write(x.e(a));
                System.out.println("Byte 4" + PersonSvcImpl2.s);
                if (!PersonSvcImpl.isValid(cardChannel.transmit(PersonSvcImpl2.s))) {
                //    throw new ReadException(PersonSvcImpl2.v[5]);
                }
            } catch (CardException ex4) {
                throw ex4;
            }
            byteArrayOutputStream.write(x.e(this.a(cardChannel, (byte) 0, (byte) 0, (byte) (-1))));
            byteArrayOutputStream.write(x.e(this.a(cardChannel, (byte) 0, (byte) (-1), (byte) (-1))));
            return this.al(byteArrayOutputStream.toByteArray());
        } catch (CardException ex5) {
            throw new ReadException(ex5);
        } catch (IOException ex6) {
            throw new ReadException(ex6);
        }
    }

    public String c(final CardChannel cardChannel) throws ReadException {
        final int d = PersonSvcImpl.d;
        try {
            try {
                if (!PersonSvcImpl.isValid(cardChannel.transmit(PersonSvcImpl2.m))) {
                    throw new ReadException(PersonSvcImpl2.v[2]);
                }
            } catch (CardException ex) {
                throw ex;
            }
            final byte[] a = this.a(cardChannel, (byte) (-127), (byte) 0, (byte) 93);
            final StringBuilder sb = new StringBuilder();
            int i = 5;
            while (i < a.length) {

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
        } catch (CardException ex3) {
            throw new ReadException(ex3);
        }
    }

    public long d(final CardChannel cardChannel) throws ReadException {
        final int n = 4;
        try {
            try {
                if (!PersonSvcImpl.isValid(cardChannel.transmit(PersonSvcImpl2.o))) {
                    throw new ReadException(PersonSvcImpl2.v[0] + x.a(PersonSvcImpl2.f));
                }
            } catch (CardException ex) {
                throw ex;
            }
            final ResponseAPDU transmit = cardChannel.transmit(PersonSvcImpl2.t);

            if (!PersonSvcImpl.isValid(transmit)) {
                throw new ReadException(PersonSvcImpl2.v[1]);
            }
            final byte[] bytes = transmit.getBytes();
            final byte[] array = new byte[4];
            System.arraycopy(bytes, 15, array, 0, n);
            return x.d(x.a(array));
        } catch (CardException ex3) {
            throw new ReadException(ex3);
        }
    }

    public byte[] e(final CardChannel cardChannel) throws ReadException {
        final int d = PersonSvcImpl.d;
        final byte[] array = new byte[2];
        final int n = 256;
        final int n2 = 104;
        final Byte value = -126;
        final Byte value2 = 0;
        try {
            try {
                if (!PersonSvcImpl.isValid(cardChannel.transmit(PersonSvcImpl2.m))) {
                    throw new ReadException(PersonSvcImpl2.v[7]);
                }
            } catch (CardException ex) {
                throw ex;
            }
            final byte[] a = this.a(cardChannel, value, value2, (byte) 0);
            array[0] = a[2];
            array[1] = a[3];
            final int n3 = x.d(array) + 4;
            final int n4 = n3 % n;
            final byte[] array2 = new byte[n3];
            System.arraycopy(a, 0, array2, 0, n);
            final int n5 = n3 / n;
            int i = 1;
            Label_0226:
            while (true) {
                while (i < n5) {
                    final byte[] a2 = this.a(cardChannel, (byte) i, (byte) 0, (byte) 0);
                    System.arraycopy(a2, 0, array2, i * n, n);
                    ++i;
                    if (d != 0) {
                        break Label_0226;
                    }
                    if (d == 0) {
                        continue;
                    }
                    int b = ReadException.b;
                    ReadException.b = ++b;
                    final byte[] array3 = new byte[n3 - n2];
                    System.arraycopy(array2, n2, array3, 0, n3 - n2);
                    return array3;
                }
                if (n4 > 0) {
                    System.arraycopy(this.a(cardChannel, (byte) (n3 / n), (byte) 0, (byte) n4), 0, array2, n3 - n4, n4);
                }
                continue Label_0226;
            }
        } catch (CardException ex3) {
            throw new ReadException(ex3);
        }
        return null;
    }

    @Override
    public ExtendedPerson readData(final CardChannel cardChannel) throws ReadException {
        final ExtendedPerson b = this.b(cardChannel);
//        b.D(this.c(cardChannel));
//        b.a(this.e(cardChannel));
//        b.C(String.valueOf(this.d(cardChannel)));
        return b;
    }

    private ExtendedPerson al(final byte[] array) {
        int n = 0;
        final String c = x.c(array);
        final ExtendedPerson r2;
        final ExtendedPerson r = r2 = new ExtendedPerson();
        final String s = c;
        final int n2 = n;
        n += 13;
        r2.d(s.substring(n2, n).trim());
        final ExtendedPerson r3 = r;
        final String s2 = c;
        final int n3 = n;
        n += 25;
        r3.q(s2.substring(n3, n).trim());
        final ExtendedPerson r4 = r;
        final String s3 = c;
        final int n4 = n;
        n += 25;
        r4.r(s3.substring(n4, n).trim());
        final ExtendedPerson r5 = r;
        final String s4 = c;
        final int n5 = n;
        n += 25;
        r5.a(s4.substring(n5, n).trim());
        final ExtendedPerson r6 = r;
        final String s5 = c;
        final int n6 = n;
        n += 25;
        r6.b(s5.substring(n6, n).trim());
        final ExtendedPerson r7 = r;
        final String s6 = c;
        final int n7 = n;
        n += 25;
        r7.c(s6.substring(n7, n).trim());
        final ExtendedPerson r8 = r;
        final String s7 = c;
        final int n8 = n;
        n += 9;
        r8.i(s7.substring(n8, n).trim());
        final ExtendedPerson r9 = r;
        final String s8 = c;
        final int n9 = n;
        n += 30;
        r9.n(s8.substring(n9, n).trim());
        final ExtendedPerson r10 = r;
        final String s9 = c;
        final int n10 = n;
        n += 30;
        r10.l(s9.substring(n10, n).trim());
        final ExtendedPerson r11 = r;
        final String s10 = c;
        final int n11 = n;
        n += 30;
        r11.o(s10.substring(n11, n).trim());
        final ExtendedPerson r12 = r;
        final String s11 = c;
        final int n12 = n;
        n += 10;
        r12.m(s11.substring(n12, n).trim());
        final ExtendedPerson r13 = r;
        final String s12 = c;
        final int n13 = n;
        n += 10;
        r13.f(s12.substring(n13, n).trim());
        final ExtendedPerson r14 = r;
        final String s13 = c;
        final int n14 = n;
        n += 10;
        r14.g(s13.substring(n14, n).trim());
        final ExtendedPerson r15 = r;
        final String s14 = c;
        final int n15 = n;
        n += 7;
        r15.e(s14.substring(n15, n).trim());
        final ExtendedPerson r16 = r;
        final String s15 = c;
        final int n16 = n;
        n += 30;
        r16.w(s15.substring(n16, n).trim());
        final ExtendedPerson r17 = r;
        final String s16 = c;
        final int n17 = n;
        n += 30;
        r17.v(s16.substring(n17, n).trim());
        final ExtendedPerson r18 = r;
        final String s17 = c;
        final int n18 = n;
        n += 30;
        r18.p(s17.substring(n18, n).trim());
        r.u(c.substring(n, ++n).trim());
        r.t(c.substring(n, ++n).trim());
        final ExtendedPerson r19 = r;
        final String s18 = c;
        final int n19 = n;
        n += 30;
        r19.k(s18.substring(n19, n).trim());
        final ExtendedPerson r20 = r;
        final String s19 = c;
        final int n20 = n;
        n += 5;
        r20.j(s19.substring(n20, n).trim());
        final ExtendedPerson r21 = r;
        final String s20 = c;
        final int n21 = n;
        n += 5;
        r21.h(s20.substring(n21, n).trim());
        final ExtendedPerson r22 = r;
        final String s21 = c;
        final int n22 = n;
        n += 5;
        r22.s(s21.substring(n22, n).trim());
        n += 185;
        final ExtendedPerson r23 = r;
        final String s22 = c;
        final int n23 = n;
        n += 40;
        r23.B(s22.substring(n23, n));
        final ExtendedPerson r24 = r;
        final String s23 = c;
        final int n24 = n;
        n += 15;
        r24.z(s23.substring(n24, n).trim());
        final ExtendedPerson r25 = r;
        final String s24 = c;
        final int n25 = n;
        n += 30;
        r25.y(s24.substring(n25, n).trim());
        final ExtendedPerson r26 = r;
        final String s25 = c;
        final int n26 = n;
        n += 30;
//        r26.x(s25.substring(n26, n).trim());
//        r.A(c.substring(n, ++n).trim());
        return r;
    }

    static {
        final String[] v2 = new String[12];
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
        int n2 = n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 0))))))))));
        String s2 = "-\u007f\u000f\u001dnH`\u001c\u001cx\tc\u0019\u001d<\ra]\u0011s\u0005l\u0013\u0016sHL-6I7N062";
        int n14 = -1;
        String intern = null;
        Label_0130:
        while (true) {
            final char[] charArray = s2.toCharArray();
            final int length = charArray.length;
            for (int n15 = 0; length > n15; ++n15) {
                final int n16 = n15;
                final char c = charArray[n16];
                char c2 = '\0';
                switch (n15 % 5) {
                    case 0: {
                        c2 = 'h';
                        break;
                    }
                    case 1: {
                        c2 = '\r';
                        break;
                    }
                    case 2: {
                        c2 = '}';
                        break;
                    }
                    case 3: {
                        c2 = 'r';
                        break;
                    }
                    default: {
                        c2 = '\u001c';
                        break;
                    }
                }
                charArray[n16] = (char) (c ^ c2);
            }
            intern = new String(charArray).intern();
            switch (n14) {
                default: {
                    v2[n3] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 1)))))))))));
                    s2 = "-\u007f\u000f\u001dnH`\u001c\u001cx\ti\u0012Ry\u0004-\u001e\u001dq\tc\u0019\u001d<)]9'C+@9\\";
                    n14 = 0;
                    continue;
                }
                case 0: {
                    v2[n2] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 2)))))))))));
                    s2 = "-\u007f\u000f\u001dnH`\u001c\u001cx\tc\u0019\u001d<\ra]\u0011s\u0005l\u0013\u0016sHL-6I7N062";
                    n14 = 1;
                    continue;
                }
                case 1: {
                    v2[n4] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 3)))))))))));
                    s2 = "-\u007f\u000f\u001dnH`\u001c\u001cx\ti\u0012Ry\u0004-\u001e\u001dq\tc\u0019\u001d<)]9'C+@9";
                    n14 = 2;
                    continue;
                }
                case 2: {
                    v2[n5] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 4)))))))))));
                    s2 = "-\u007f\u000f\u001dnH`\u001c\u001cx\ti\u0012Ry\u0004-\u001e\u001dq\tc\u0019\u001d<)]9'C+@9";
                    n14 = 3;
                    continue;
                }
                case 3: {
                    v2[n6] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 5)))))))))));
                    s2 = "-\u007f\u000f\u001dnH`\u001c\u001cx\ti\u0012Ry\u0004-\u001e\u001dq\tc\u0019\u001d<)]9'C+@9";
                    n14 = 4;
                    continue;
                }
                case 4: {
                    v2[n7] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 6)))))))))));
                    s2 = "-\u007f\u000f\u001dnH`\u001c\u001cx\ti\u0012Ry\u0004-\u001e\u001dq\tc\u0019\u001d<)]9'C+@9";
                    n14 = 5;
                    continue;
                }
                case 5: {
                    v2[n8] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 7)))))))))));
                    s2 = "-\u007f\u000f\u001dnH`\u001c\u001cx\tc\u0019\u001d<\ra]\u0011s\u0005l\u0013\u0016sHL-6I7N06";
                    n14 = 6;
                    continue;
                }
                case 6: {
                    v2[n9] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 8)))))))))));
                    s2 = "-\u007f\u000f\u001dnH`\u001c\u001cx\tc\u0019\u001d<\ra]\u0011s\u0005l\u0013\u0016sHL-6I7N06";
                    n14 = 7;
                    continue;
                }
                case 7: {
                    v2[n10] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 9)))))))))));
                    s2 = "*l\u0019Rp\rc\u001a\u0006tHb\u001bR~\u0011y\u0018\u0001<\u001ah\t\u0007n\u0006h\u0019Ru\u0006-<\"X=-\u001e\u001dq\u0005`\u001c\u001cxF";
                    n14 = 8;
                    continue;
                }
                case 8: {
                    v2[n11] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 10)))))))))));
                    s2 = "*l\u0019Rp\rc\u001a\u0006tHb\u001bRn\r~\r\u001dr\u001bh]\u0000y\ti\u0014\u001c{Hk\u0014\u001c{\r\u007f\r\u0000u\u0006y\u000eRy\u0006\u007f\u0012\u001ey\f#";
                    n14 = 9;
                    continue;
                }
                case 9: {
                    v2[n12] = intern;
                    n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = 11)))))))))));
                    s2 = "-\u007f\u000f\u001dnH`\u001c\u001cx\ti\u0012Ry\u0004-\u001e\u001dq\tc\u0019\u001d<)]9'C+@9";
                    n14 = 10;
                    continue;
                }
                case 10: {
                    break Label_0130;
                }
            }
        }
        v2[n13] = intern;
        v = v2;
        String s3 = "X=<F,\\=>C,)=MB,X=ME+X<EA$[=EC,X=;C,X=MB,X<";
        int n17 = -1;
        String intern2 = null;
        Label_0532:
        while (true) {
            final char[] charArray2 = s3.toCharArray();
            final int length2 = charArray2.length;
            for (int n18 = 0; length2 > n18; ++n18) {
                final int n19 = n18;
                final char c3 = charArray2[n19];
                char c4 = '\0';
                switch (n18 % 5) {
                    case 0: {
                        c4 = 'h';
                        break;
                    }
                    case 1: {
                        c4 = '\r';
                        break;
                    }
                    case 2: {
                        c4 = '}';
                        break;
                    }
                    case 3: {
                        c4 = 'r';
                        break;
                    }
                    default: {
                        c4 = '\u001c';
                        break;
                    }
                }
                charArray2[n19] = (char) (c3 ^ c4);
            }
            intern2 = new String(charArray2).intern();
            switch (n17) {
                default: {
                    e = x.a(intern2);
                    s3 = "X=<F,\\=MB+)=MB,X=LG-X=MB";
                    n17 = 0;
                    continue;
                }
                case 0: {
                    f = x.a(intern2);
                    s3 = "X=<F,\\=MC,)=MB,X=ME+X<MJ,X=JC,X=;C,X=MB/X=";
                    n17 = 1;
                    continue;
                }
                case 1: {
                    g = x.a(intern2);
                    s3 = "X=<F,X=MB.Y=MC";
                    n17 = 2;
                    continue;
                }
                case 2: {
                    h = x.a(intern2);
                    s3 = "X=<F,Z=MB.X<MC";
                    n17 = 3;
                    continue;
                }
                case 3: {
                    i = x.a(intern2);
                    s3 = "X=<F,Z=MB.X<M@";
                    n17 = 4;
                    continue;
                }
                case 4: {
                    j = x.a(intern2);
                    s3 = "P=>3%.:;@X";
                    n17 = 5;
                    continue;
                }
                case 5: {
                    k = x.a(intern2);
                    s3 = "X=>0/.K;B/]NMC_Z";
                    n17 = 6;
                    continue;
                }
                case 6: {
                    break Label_0532;
                }
            }
        }
        l = x.a(intern2);
        m = new CommandAPDU(PersonSvcImpl2.b);
        n = new CommandAPDU(PersonSvcImpl2.e);
        o = new CommandAPDU(PersonSvcImpl2.f);
        p = new CommandAPDU(PersonSvcImpl2.g);
        q = new CommandAPDU(PersonSvcImpl2.h);
        r = new CommandAPDU(PersonSvcImpl2.i);
        s = new CommandAPDU(PersonSvcImpl2.j);
        t = new CommandAPDU(PersonSvcImpl2.k);
        u = new CommandAPDU(PersonSvcImpl2.l);
    }
}
