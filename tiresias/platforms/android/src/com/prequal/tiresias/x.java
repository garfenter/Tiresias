package com.prequal.tiresias;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class x {
    private static String[] a;
    private static SimpleDateFormat b;
    private static SimpleDateFormat c;
    public static int d;
    private static String[] e;

    public static String a(final byte[] array) {
        final int d = x.d;
        final StringBuilder sb = new StringBuilder();
        int i = 0;
        String upperCase = null;
        while (i < array.length) {
            final String s = upperCase = Integer.toHexString(array[i] & 0xFF).toUpperCase();
            if (d != 0) {
                return upperCase;
            }
            if (upperCase.length() == 1) {
                sb.append(0);
            }
            sb.append(s).append(" ");
            ++i;
            if (d != 0) {
                break;
            }
        }
        sb.substring(0, sb.length() - 1);
        return upperCase;
    }

    public static String b(final byte[] array) {
        final int d = x.d;
        if (array == null) {
            return null;
        }
        final StringBuilder sb = new StringBuilder();
        int i = 0;
        String upperCase = null;
        while (i < array.length) {
            final String s = upperCase = Integer.toHexString(array[i] & 0xFF).toUpperCase();
            if (d != 0) {
                return upperCase;
            }
            if (upperCase.length() == 1) {
                sb.append("0");
            }
            sb.append(s);
            ++i;
            if (d != 0) {
                break;
            }
        }
        sb.toString();
        return upperCase;
    }

    public static byte[] a(final String s) {
        if (s == null) {
            return null;
        }
        final int length = s.length();
        final byte[] array = new byte[length / 2];
        for (int i = 0; i < length; i += 2) {
            array[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return array;
    }

    public static String c(final byte[] array) {
        final int d = x.d;
        final StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < array.length) {
            final StringBuilder append = sb.append((char) (array[i] & 0xFF));
            if (d != 0) {
                return append.toString();
            }
            ++i;
            if (d != 0) {
                break;
            }
        }
        final StringBuilder append = sb;
        return append.toString();
    }

    public static int d(final byte[] array) {
        return Integer.valueOf(a(array).replace(" ", ""), 16);
    }

    public static Date convertToDate(final String s) throws ReadException {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(s);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static String a(final Date date) {
        return x.c.format(date);
    }

    public static String c(final String s) throws ReadException {
        return a(convertToDate(s));
    }

    public static Date a(final String s, final String s2) throws ReadException {
        if (s == null) {
            return null;
        }
        if (s.equalsIgnoreCase(x.e[0])) {
            final Date b = convertToDate(s2);
            final Calendar instance = Calendar.getInstance();
            instance.setTime(b);
            instance.add(1, 10);
            instance.add(5, -1);
            final Date date = instance.getTime();
            if (x.d == 0) {
                return date;
            }
        }
        return convertToDate(s);
    }

    public static long d(String replace) {
        replace = replace.replace(" ", "");
        return Long.parseLong(replace, 16);
    }

    public static byte[] e(final byte[] array) {
        final int d = x.d;
        int i = array.length - 1;
        int n = 0;
        while (i >= 0) {
            final byte[] array2 = array;
            n = i;
            if (d != 0) {
                return Arrays.copyOf(array2, n);
            }
            if (array[n] != 0) {
                break;
            }
            --i;
            if (d != 0) {
                break;
            }
        }
        final byte[] array2 = array;
        return Arrays.copyOf(array2, n);
    }

    public static String a(final byte b) {
        final byte b2 = (byte) ((byte) ((byte) (b & 0xF0) >>> 4) & 0xF);
        final byte b3 = (byte) (b & 0xF);
        final StringBuilder sb = new StringBuilder();
        sb.append(b2).append(b3);
        return sb.toString();
    }

    public static String f(final byte[] array) {
        final int d = x.d;
        final StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < array.length) {
            final StringBuilder append = sb.append(a(array[i]));
            if (d != 0) {
                return append.toString().substring(0, sb.toString().length() - 1);
            }
            ++i;
            if (d != 0) {
                break;
            }
        }
        final StringBuilder append = sb;
        return append.toString().substring(0, sb.toString().length() - 1);
    }

    public static int a(final byte b, final byte b2) {
        return (b & 0xFF) << 8 | (b2 & 0xFF);
    }

    static {
        String[] a2;
        String[] array20;
        String[] array19;
        String[] array18;
        String[] array17;
        String[] array16;
        String[] array15;
        String[] array14;
        String[] array13;
        String[] array12;
        String[] array11;
        String[] array10;
        String[] array9;
        String[] e2;
        String[] array8;
        String[] array7;
        String[] array6;
        String[] array5;
        String[] array4;
        String[] array3;
        String[] array2;
        String[] array = array2 = (array3 = (array4 = (array5 = (array6 = (array7 = (array8 = (e2 = (array9 = (array10 = (array11 = (array12 = (array13 = (array14 = (array15 = (array16 = (array17 = (array18 = (array19 = (array20 = (a2 = new String[8]))))))))))))))))))));
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
        int n = n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 0))))))))))))))))));
        String s = "~\u0005:d\u000e~\u00057e\u0007";
        int n21 = -1;
        String intern = null;
        Label_0410:
        while (true) {
            final char[] charArray = s.toCharArray();
            final int i = charArray.length;
            for (int n22 = 0; i > n22; ++n22) {
                final int n23 = n22;
                final char c2 = charArray[n23];
                char c3 = '\0';
                switch (n22 % 5) {
                    case 0: {
                        c3 = '7';
                        break;
                    }
                    case 1: {
                        c3 = 'K';
                        break;
                    }
                    case 2: {
                        c3 = '~';
                        break;
                    }
                    case 3: {
                        c3 = '!';
                        break;
                    }
                    default: {
                        c3 = 'H';
                        break;
                    }
                }
                charArray[n23] = (char) (c2 ^ c3);
            }
            intern = new String(charArray).intern();
            switch (n21) {
                default: {
                    array2[n2] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 1)))))))))))))))))));
                    s = "\u0017$\u0010\u0001+_\"\u000e\u000fh";
                    n21 = 0;
                    continue;
                }
                case 0: {
                    array[n] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 2)))))))))))))))))));
                    s = "~%\b@$^/^E)C.D\u0001";
                    n21 = 1;
                    continue;
                }
                case 1: {
                    array3[n3] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 3)))))))))))))))))));
                    s = "\u0012{LE";
                    n21 = 2;
                    continue;
                }
                case 2: {
                    array4[n4] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 4)))))))))))))))))));
                    s = "\u0017$\u0010\u0001+_\"\u000e\u000fh";
                    n21 = 3;
                    continue;
                }
                case 3: {
                    array5[n5] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 5)))))))))))))))))));
                    s = "~%\b@$^/^E)C.D\u0001";
                    n21 = 4;
                    continue;
                }
                case 4: {
                    array6[n6] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 6)))))))))))))))))));
                    s = "N23l,S";
                    n21 = 5;
                    continue;
                }
                case 5: {
                    array7[n7] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 7)))))))))))))))))));
                    s = "S/Ql\u0005\u00182\u0007X1";
                    n21 = 6;
                    continue;
                }
                case 6: {
                    array8[n8] = intern;
                    e = e2;
                    array = (array2 = (array3 = (array4 = (array5 = (array6 = (array7 = (array8 = (e2 = (array9 = (array10 = (array11 = (array12 = (array13 = (array14 = (array15 = (array16 = (array17 = (array18 = (array19 = (array20 = (a2 = new String[12])))))))))))))))))))));
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 0)))))))))))))))))));
                    s = "r\u0005;";
                    n21 = 7;
                    continue;
                }
                case 7: {
                    array9[n9] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 1)))))))))))))))))));
                    s = "q\u000e<";
                    n21 = 8;
                    continue;
                }
                case 8: {
                    array10[n10] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 2)))))))))))))))))));
                    s = "z\n,";
                    n21 = 9;
                    continue;
                }
                case 9: {
                    array11[n11] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 3)))))))))))))))))));
                    s = "v\t,";
                    n21 = 10;
                    continue;
                }
                case 10: {
                    array12[n12] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 4)))))))))))))))))));
                    s = "z\n'";
                    n21 = 11;
                    continue;
                }
                case 11: {
                    array13[n13] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 5)))))))))))))))))));
                    s = "}\u001e0";
                    n21 = 12;
                    continue;
                }
                case 12: {
                    array14[n14] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 6)))))))))))))))))));
                    s = "}\u001e2";
                    n21 = 13;
                    continue;
                }
                case 13: {
                    array15[n15] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 7)))))))))))))))))));
                    s = "v\f1";
                    n21 = 14;
                    continue;
                }
                case 14: {
                    array16[n16] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 8)))))))))))))))))));
                    s = "d\u000e.";
                    n21 = 15;
                    continue;
                }
                case 15: {
                    array17[n17] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 9)))))))))))))))))));
                    s = "x\b*";
                    n21 = 16;
                    continue;
                }
                case 16: {
                    array18[n18] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 10)))))))))))))))))));
                    s = "y\u0004(";
                    n21 = 17;
                    continue;
                }
                case 17: {
                    array19[n19] = intern;
                    n = (n2 = (n3 = (n4 = (n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = (n13 = (n14 = (n15 = (n16 = (n17 = (n18 = (n19 = (n20 = 11)))))))))))))))))));
                    s = "s\u000e=";
                    n21 = 18;
                    continue;
                }
                case 18: {
                    break Label_0410;
                }
            }
        }
        array20[n20] = intern;
        a = a2;
        b = new SimpleDateFormat(x.e[7]);
        c = new SimpleDateFormat(x.e[6]);
    }
}
