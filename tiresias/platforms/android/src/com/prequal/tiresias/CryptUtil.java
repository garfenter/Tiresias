package com.prequal.tiresias;

import com.prequal.tiresias.integration.CardChannel;
import com.prequal.tiresias.integration.CardException;
import com.prequal.tiresias.integration.CommandAPDU;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CryptUtil {

    private static final byte[] a;
    private static final String[] b;

    public static QuadByteArray digestByte(final String s, final String s2, final String s3) throws ReadException {
        final byte[] bytes = (s + v.a(s) + s2 + v.a(s2) + s3 + v.a(s3)).getBytes();
        byte[] digest;
        try {
            digest = MessageDigest.getInstance(CryptUtil.b[10]).digest(bytes);
        } catch (NoSuchAlgorithmException ex) {
            throw new ReadException(ex);
        }
        return a(digest);
    }

    public static QuadByteArray a(final byte[] array) throws ReadException {
        final byte[] array2 = new byte[16];
        final byte[] array3 = new byte[16];
        final byte[] array4 = new byte[20];
        try {
            if (array.length < 16) {
                throw new ReadException(CryptUtil.b[2]);
            }
            System.arraycopy(array, 0, array4, 0, 16);
            final MessageDigest instance = MessageDigest.getInstance(CryptUtil.b[3]);
            array4[19] = 1;
            System.arraycopy(instance.digest(array4), 0, array2, 0, 16);
            array4[19] = 2;
            System.arraycopy(instance.digest(array4), 0, array3, 0, 16);
            return new QuadByteArray(array, array2, array3);
        } catch (NoSuchAlgorithmException ex2) {
            throw new ReadException(ex2);
        }
    }

    public static byte[] b(final byte[] array) throws IOException {
        final int d = x.d;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byteArrayOutputStream.write(array, 0, array.length);
        byteArrayOutputStream.write(-128);
        int n = array.length + 1;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        while (n++ % 8 != 0) {
            byteArrayOutputStream2 = byteArrayOutputStream;
            if (d != 0) {
                return byteArrayOutputStream2.toByteArray();
            }
            byteArrayOutputStream2.write(0);
            if (d == 0) {
                continue;
            }
            break;
        }
        final ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream;
        return byteArrayOutputStream2.toByteArray();
    }

    public static byte[] a(final byte[] array, final byte[] array2) throws ReadException {
        final int d = x.d;
        final byte[] array3 = new byte[8];
        System.arraycopy(array2, 0, array3, 0, 8);
        final byte[] array4 = new byte[8];
        System.arraycopy(array2, 8, array4, 0, 8);
        final IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[8]);
        final SecretKeySpec secretKeySpec = new SecretKeySpec(array3, CryptUtil.b[15]);
        final SecretKeySpec secretKeySpec2 = new SecretKeySpec(array4, CryptUtil.b[14]);
        try {
            final Cipher instance = Cipher.getInstance(CryptUtil.b[12]);
            instance.init(1, secretKeySpec, ivParameterSpec);
            final Cipher instance2 = Cipher.getInstance(CryptUtil.b[13]);
            instance2.init(2, secretKeySpec2, ivParameterSpec);
            final byte[] b = b(array);
            final byte[] copyOfRange = Arrays.copyOfRange(b, 0, 8);
            byte[] array5 = instance.doFinal(copyOfRange);
            final int n = b.length >> 3;
            int i = 1;
            Label_0246_Outer:
            while (i < n) {
                if (d == 0) {
                    int j = 0;
                    Label_0246:
                    while (true) {
                        while (j < 8) {
                            try {
                                copyOfRange[j] = (byte) (array5[j] ^ b[j + i * 8]);
                                ++j;
                                if (d != 0) {
                                    break Label_0246;
                                }
                                if (d == 0) {
                                    continue Label_0246_Outer;
                                }
                            } catch (Exception ex) {
                                throw ex;
                            }
                            int b2 = ReadException.b;
                            ReadException.b = ++b2;
                            break;
//                            if (d != 0) {
//                                break Label_0246_Outer;
//                            }
//                            continue Label_0246_Outer;
                        }
                        array5 = instance.doFinal(copyOfRange, 0, 8);
                        return array5;
                    }
                }
                return array5;
            }
            array5 = instance.doFinal(instance2.doFinal(array5, 0, 8), 0, 8);
            return array5;
        } catch (Exception ex2) {
            throw new ReadException(CryptUtil.b[11], ex2);
        }
    }

    private static byte[] b(final byte[] array, final byte[] array2) throws ReadException {
        byte[] array3 = null;
        Label_0039:
        {
            if (array.length == 16) {
                array3 = new byte[24];
                System.arraycopy(array, 0, array3, 0, 16);
                System.arraycopy(array, 0, array3, 16, 8);
                if (x.d == 0) {
                    break Label_0039;
                }
            }
            array3 = array;
        }
        final IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[8]);
        final SecretKeySpec secretKeySpec = new SecretKeySpec(array3, CryptUtil.b[8]);
        try {
            final Cipher instance = Cipher.getInstance(CryptUtil.b[7]);
            instance.init(1, secretKeySpec, ivParameterSpec);
            return instance.doFinal(array2);
        } catch (Exception ex) {
            throw new ReadException(ex);
        }
    }

    private static byte[] c(final byte[] array, final byte[] array2) throws ReadException {
        byte[] array3 = null;
        Label_0039:
        {
            if (array.length == 16) {
                array3 = new byte[24];
                System.arraycopy(array, 0, array3, 0, 16);
                System.arraycopy(array, 0, array3, 16, 8);
                if (x.d == 0) {
                    break Label_0039;
                }
            }
            array3 = array;
        }
        final IvParameterSpec ivParameterSpec = new IvParameterSpec(new byte[8]);
        final SecretKeySpec secretKeySpec = new SecretKeySpec(array3, CryptUtil.b[1]);
        try {
            final Cipher instance = Cipher.getInstance(CryptUtil.b[0]);
            instance.init(2, secretKeySpec, ivParameterSpec);
            return instance.doFinal(array2);
        } catch (Exception ex) {
            throw new ReadException(ex);
        }
    }

    public static byte[] a(final byte[] array, final QuadByteArray y) throws ReadException {
        final byte[] array2 = CryptUtil.a.clone();
        System.arraycopy(array, 0, array2, 8, 8);
        try {
            final byte[] b = b(y.a(), array2);
            final byte[] a = a(b, y.b());
            final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write(b);
            byteArrayOutputStream.write(a);
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception ex) {
            throw new ReadException(CryptUtil.b[9], ex);
        }
    }

    public static QuadByteArray a(final byte[] array, final byte[] array2, final QuadByteArray y) throws ReadException {
        int d = x.d;
        final byte[] array3 = CryptUtil.a.clone();
        System.arraycopy(array, 0, array3, 8, 8);
        final byte[] copyOfRange = Arrays.copyOfRange(array2, 0, 32);
        final byte[] a = a(copyOfRange, y.b());
        try {
            if (!u.a(a, 0, array2, 32, 8)) {
                throw new ReadException(CryptUtil.b[4]);
            }
        } catch (ReadException e) {
            throw e;
        }
        final byte[] c = c(y.a(), copyOfRange);
        try {
            if (!u.a(array3, 0, c, 8, 8)) {
                throw new ReadException(CryptUtil.b[6]);
            }
        } catch (ReadException e2) {
            throw e2;
        }
        try {
            if (!u.a(array3, 8, c, 0, 8)) {
                throw new ReadException(CryptUtil.b[5]);
            }
        } catch (ReadException e3) {
            throw e3;
        }
        final byte[] array4 = new byte[8];
        System.arraycopy(array, 4, array4, 0, 4);
        System.arraycopy(array3, 4, array4, 4, 4);
        final QuadByteArray a2 = a(u.b(c, 16, array3, 16, 16));
        QuadByteArray y2;
        a2.a(array4);
        y2 = a2;
        if (ReadException.b != 0) {
            x.d = ++d;
        }
        return y2;
    }

    private static void c(final byte[] array) {
        final int d = x.d;
        int i = 7;
        while (i >= 0) {
            final int n = i;
            ++array[n];
            if (array[i] != 0 && d == 0) {
                break;
            }
            --i;
            if (d != 0) {
                break;
            }
        }
    }

    protected static byte[] a(final QuadByteArray y, final String s) throws ReadException {
        final String s2 = "";
        String s3 = CryptUtil.b[21];
        Label_0125:
        {
            Label_0088:
            {
                if (s.length() <= 10) {
                    break Label_0088;
                }
                if (!s.substring(8, 10).equals(CryptUtil.b[26])) {
                    break Label_0125;
                }
                s3 = s3 + CryptUtil.b[25] + s.substring(10, 14);
                if (x.d == 0) {
                    break Label_0125;
                }
            }
            s3 = s3 + CryptUtil.b[23] + s.substring(8, 10);
        }
        c(y.c());
        final String b = x.b(a(x.a(x.b(y.c()) + CryptUtil.b[18] + s.substring(2, 8) + CryptUtil.b[17] + s2 + s3), y.b()));
        StringBuilder append;
        append = new StringBuilder().append(CryptUtil.b[22]).append(s.substring(2, 8));
        if (s3.charAt(3) == '1') {
            final String s4 = CryptUtil.b[24];
            return x.a(append.append(s4).append(s3).append(CryptUtil.b[16]).append(b).append(CryptUtil.b[19]).toString());
        }
        final String s4 = CryptUtil.b[20];
        return x.a(append.append(s4).append(s3).append(CryptUtil.b[16]).append(b).append(CryptUtil.b[19]).toString());
    }

    protected static byte[] a(final QuadByteArray y, final byte[] array) throws ReadException {
        final int d = x.d;
        byte[] array2 = null;
        int n = 0;
        if (array[n] == -121) {
            int n2 = 0;
            int n3 = 0;
            Label_0124:
            {
                Label_0121:
                {
                    if ((array[n + 1] & 0xFF) > 128) {
                        n3 = (array[n + 1] & 0xFF) - 129 + 1;
                        int i = n + 2;
                        while (i < n + n3 + 2) {
                            n2 = n2 * 256 + (array[i] & 0xFF);
                            ++i;
                            if (d != 0) {
                                break Label_0124;
                            }
                            if (d == 0) {
                                continue;
                            }
                            break;
                        }
                        if (d == 0) {
                            break Label_0121;
                        }
                    }
                    n2 = (array[n + 1] & 0xFF);
                }
                --n2;
            }
            final byte[] array3 = new byte[n2];
            System.arraycopy(array, n + 3 + n3, array3, 0, n2);
            n += n2 + 3 + n3;
            final byte[] c = c(y.a(), array3);
            int n4 = c.length - 1;
            while (c[n4] != -128) {
                --n4;
                if (d != 0) {
                    break;
                }
            }
            array2 = new byte[n4 + 2];
            System.arraycopy(c, 0, array2, 0, n4);
        }
        Label_0244:
        {
            Label_0228:
            {
                if (array[n] != -103) {
                    break Label_0244;
                }
                if (array2 != null) {
                    break Label_0228;
                }
                array2 = new byte[2];
            }
            System.arraycopy(array, n + 2, array2, array2.length - 2, 2);
            n += 4;
            if (array[n] != -114) {
                return null;
            }

        }
        c(y.c());
        return array2;
    }

    public static byte[] a(final CardChannel cardChannel, final QuadByteArray y, final String s) throws ReadException {
        byte[] a;
        try {
            a = a(y, cardChannel.transmit(new CommandAPDU(a(y, s))).getBytes());
        } catch (CardException ex) {
            throw new ReadException(ex);
        }
        return a;
    }

    static {
        final String[] b2 = new String[27];
        int n27;
        int n26;
        int n25;
        int n24;
        int n23;
        int n22;
        int n21;
        int n20;
        int n19;
        int n18;
        int n17;
        int n16;
        int n15;
        int n14;
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
        int n = n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 0)))))))))))))))))))))))));
        String s = "o;iztNQy]S\u00040UOqO\u001aSqw";
        int n28 = -1;
        String intern = null;
        Label_0296:
        while (true) {
            final char[] charArray = s.toCharArray();
            final int i = charArray.length;
            for (int n29 = 0; i > n29; ++n29) {
                final int n30 = n29;
                final char c = charArray[n30];
                char c2 = '\0';
                switch (n29 % 5) {
                    case 0: {
                        c2 = '+';
                        break;
                    }
                    case 1: {
                        c2 = '~';
                        break;
                    }
                    case 2: {
                        c2 = ':';
                        break;
                    }
                    case 3: {
                        c2 = '\u001f';
                        break;
                    }
                    default: {
                        c2 = '\u0010';
                        break;
                    }
                }
                charArray[n30] = (char) (c ^ c2);
            }
            intern = new String(charArray).intern();
            switch (n28) {
                default: {
                    b2[n2] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 1))))))))))))))))))))))))));
                    s = "o;iztN";
                    n28 = 0;
                    continue;
                }
                case 0: {
                    b2[n] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 2))))))))))))))))))))))))));
                    s = "b\u0010L~|B\u001a\u001aluN\u001a\u001asuE\u0019Nw>";
                    n28 = 1;
                    continue;
                }
                case 1: {
                    b2[n3] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 3))))))))))))))))))))))))));
                    s = "x6{2!";
                    n28 = 2;
                    continue;
                }
                case 2: {
                    b2[n4] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 4))))))))))))))))))))))))));
                    s = "y\u001bIo\u007fE\r_?fN\fSyyH\u001fNv\u007fE^_mbD\f\u0014";
                    n28 = 3;
                    continue;
                }
                case 3: {
                    b2[n5] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 5))))))))))))))))))))))))));
                    s = "c\u0017I?sC\u001fVsuE\u0019_?fN\fSyyH\u001fNv\u007fE^_mbD\f\u0014";
                    n28 = 4;
                    continue;
                }
                case 4: {
                    b2[n6] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 6))))))))))))))))))))))))));
                    s = "f\u0007\u001a|xJ\u0012Vz~L\u001b\u001aiuY\u0017\\vsJ\nSp~\u000b\u001bHm\u007fYP";
                    n28 = 5;
                    continue;
                }
                case 5: {
                    b2[n7] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 7))))))))))))))))))))))))));
                    s = "o;iztNQy]S\u00040UOqO\u001aSqw";
                    n28 = 6;
                    continue;
                }
                case 6: {
                    b2[n8] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 8))))))))))))))))))))))))));
                    s = "o;iztN";
                    n28 = 7;
                    continue;
                }
                case 7: {
                    b2[n9] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 9))))))))))))))))))))))))));
                    s = "n\fHpb\u000b\u0011T?`Y\u001bJ~bN3OkeJ\u0012{jdCP";
                    n28 = 8;
                    continue;
                }
                case 8: {
                    b2[n10] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 10))))))))))))))))))))))))));
                    s = "x6{2!";
                    n28 = 9;
                    continue;
                }
                case 9: {
                    b2[n11] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 11))))))))))))))))))))))))));
                    s = "n\fHpb\u000b\u0011T?uE\u001dHf`_^w~s\u000b6[lx\u0005";
                    n28 = 10;
                    continue;
                }
                case 10: {
                    b2[n12] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 12))))))))))))))))))))))))));
                    s = "o;i0Si=\u0015Q\u007f{\u001f^{yE\u0019";
                    n28 = 11;
                    continue;
                }
                case 11: {
                    b2[n13] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 13))))))))))))))))))))))))));
                    s = "o;i0Si=\u0015Q\u007f{\u001f^{yE\u0019";
                    n28 = 12;
                    continue;
                }
                case 12: {
                    b2[n14] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 14))))))))))))))))))))))))));
                    s = "o;i";
                    n28 = 13;
                    continue;
                }
                case 13: {
                    b2[n15] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 15))))))))))))))))))))))))));
                    s = "o;i";
                    n28 = 14;
                    continue;
                }
                case 14: {
                    b2[n16] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 16))))))))))))))))))))))))));
                    s = "\u0013;\n'";
                    n28 = 15;
                    continue;
                }
                case 15: {
                    b2[n17] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 17))))))))))))))))))))))))));
                    s = "\u0013N\n/ \u001bN\n";
                    n28 = 16;
                    continue;
                }
                case 16: {
                    b2[n18] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 18))))))))))))))))))))))))));
                    s = "\u001b=";
                    n28 = 17;
                    continue;
                }
                case 17: {
                    b2[n19] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 19))))))))))))))))))))))))));
                    s = "\u001bN";
                    n28 = 18;
                    continue;
                }
                case 18: {
                    b2[n20] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 20))))))))))))))))))))))))));
                    s = "\u001b;";
                    n28 = 19;
                    continue;
                }
                case 19: {
                    b2[n21] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 21))))))))))))))))))))))))));
                    s = "\u0012I";
                    n28 = 20;
                    continue;
                }
                case 20: {
                    b2[n22] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 22))))))))))))))))))))))))));
                    s = "\u001b=";
                    n28 = 21;
                    continue;
                }
                case 21: {
                    b2[n23] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 23))))))))))))))))))))))))));
                    s = "\u001bO";
                    n28 = 22;
                    continue;
                }
                case 22: {
                    b2[n24] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 24))))))))))))))))))))))))));
                    s = "\u001b:";
                    n28 = 23;
                    continue;
                }
                case 23: {
                    b2[n25] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 25))))))))))))))))))))))))));
                    s = "\u001bL";
                    n28 = 24;
                    continue;
                }
                case 24: {
                    b2[n26] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = 26))))))))))))))))))))))))));
                    s = "\u001bN";
                    n28 = 25;
                    continue;
                }
                case 25: {
                    break Label_0296;
                }
            }
        }
        b2[n27] = intern;
        b = b2;
        final char[] charArray2 = "\u001bN\n. \u0019N\t/$\u001bK\n) \u001cN\n/ \u001bN\n/ \u001bN\n/ \u001bN\u000b/!\u001aO\b.#\u001aJ\u000b*!\u001dO\r.(\u001aG\u000b^!iOy.T\u001a;\u000bY".toCharArray();
        final int j = charArray2.length;
        for (int n31 = 0; j > n31; ++n31) {
            final int n32 = n31;
            final char c3 = charArray2[n32];
            char c4 = '\0';
            switch (n31 % 5) {
                case 0: {
                    c4 = '+';
                    break;
                }
                case 1: {
                    c4 = '~';
                    break;
                }
                case 2: {
                    c4 = ':';
                    break;
                }
                case 3: {
                    c4 = '\u001f';
                    break;
                }
                default: {
                    c4 = '\u0010';
                    break;
                }
            }
            charArray2[n32] = (char) (c3 ^ c4);
        }
        a = x.a(new String(charArray2).intern());
    }

}
