package com.prequal.tiresias;

import com.prequal.tiresias.integration.CardChannel;
import com.prequal.tiresias.integration.CardException;
import com.prequal.tiresias.integration.CommandAPDU;
import com.prequal.tiresias.integration.ResponseAPDU;

public abstract class PersonSvcImpl implements PersonSvc {
    protected static byte[] b;
    private static byte[] c;
    public static int d;
    private static final String[] e;

    public static DPIVersion as(final CardChannel cardChannel) throws ReadException {
        final CommandAPDU commandAPDU = new CommandAPDU(PersonSvcImpl.c);
        DPIVersion b;
        try {
            if (isValid(cardChannel.transmit(commandAPDU))) {
                b = DPIVersion.v2;
            } else {
                b = DPIVersion.v1;
            }
        } catch (CardException ex) {
            throw new ReadException(ex);
        }
        return b;
    }

    protected static boolean isValid(final ResponseAPDU responseAPDU) {
        return a(responseAPDU.getBytes());
    }

    public static boolean a(final byte[] array) {
        return array[array.length - 2] == -112 && array[array.length - 1] == 0;
    }

    public static PersonSvc a(final DPIVersion b) {
        final int d = PersonSvcImpl.d;
//        Label_0052:
//        {
//            switch (o.readData[DPIVersion.ordinal()]) {
//                case 1: {
//                    final PersonSvc PersonSvc = new PersonSvcImpl2();
//                    if (d != 0) {
//                        break Label_0052;
//                    }
//                    return PersonSvc;
//                }
//                case 2: {
//                    final PersonSvc PersonSvc = new n();
//                    if (d != 0) {
//                        break;
//                    }
//                    return PersonSvc;
//                }
//            }
//        }
        return new PersonSvcImpl2();
    }

    protected byte[] a(final CardChannel cardChannel, final byte b, final byte b2, final byte b3) throws ReadException {
        final CommandAPDU commandAPDU = new CommandAPDU(new byte[]{0, -80, b, b2, b3});
        byte[] array;
        try {
            final ResponseAPDU transmit = cardChannel.transmit(commandAPDU);
            if (!isValid(transmit)) {
                throw new ReadException(PersonSvcImpl.e[0]);
            }
            final byte[] bytes = transmit.getBytes();
            array = new byte[bytes.length - 2];
            System.arraycopy(bytes, 0, array, 0, bytes.length - 2);
        } catch (CardException ex2) {
            throw new ReadException(ex2);
        }
        return array;
    }

    protected byte[] a(final CardChannel cardChannel, final byte b, final byte b2, final int n) throws ReadException {
        int d = PersonSvcImpl.d;
        final byte[] array = {0, -80, (byte) (b | 0xFFFFFF80), b2, 0, 0, 0};
        final byte[] a = u.a(n);
        array[4] = a[1];
        array[5] = a[2];
        array[6] = a[3];
        final CommandAPDU commandAPDU = new CommandAPDU(array);
        byte[] array2;
        try {
            final ResponseAPDU transmit = cardChannel.transmit(commandAPDU);
            if (!isValid(transmit)) {
                throw new ReadException(PersonSvcImpl.e[1]);
            }
            final byte[] bytes = transmit.getBytes();
            array2 = new byte[bytes.length - 2];
            System.arraycopy(bytes, 0, array2, 0, bytes.length - 2);
        } catch (CardException ex2) {
            throw new ReadException(ex2);
        }
        byte[] array3;
        array3 = array2;
        if (ReadException.b != 0) {
            PersonSvcImpl.d = ++d;
        }
        String newString = new String(array3);
        System.out.println("NUEVO STRING: " + newString);
        return array3;
    }

    static {
        final String[] e2 = new String[2];
        int n2;
        int n = n2 = 0;
        String s = "zFjyX\u001fYyxN^Z|y\nZX8uERUvrE\u0011";
        int n3 = -1;
        String intern = null;
        Label_0022:
        while (true) {
            final char[] charArray = s.toCharArray();
            final int i = charArray.length;
            for (int n4 = 0; i > n4; ++n4) {
                final int n5 = n4;
                final char c2 = charArray[n5];
                char c3 = '\0';
                switch (n4 % 5) {
                    case 0: {
                        c3 = '?';
                        break;
                    }
                    case 1: {
                        c3 = '4';
                        break;
                    }
                    case 2: {
                        c3 = '\u0018';
                        break;
                    }
                    case 3: {
                        c3 = '\u0016';
                        break;
                    }
                    default: {
                        c3 = '*';
                        break;
                    }
                }
                charArray[n5] = (char) (c2 ^ c3);
            }
            intern = new String(charArray).intern();
            switch (n3) {
                default: {
                    e2[n2] = intern;
                    n = (n2 = 1);
                    s = "zFjyX\u001fYyxN^Z|y\nZX8uERUvrE\u0011";
                    n3 = 0;
                    continue;
                }
                case 0: {
                    break Label_0022;
                }
            }
        }
        e2[n] = intern;
        e = e2;
        String s2 = "\u000f\u0004Y\"\u001a\u000b\u0004[&\u001d~\u0004(&\u001a\u000f\u0004*\"\u001d\u000e\u0004('";
        int n6 = -1;
        String intern2 = null;
        Label_0295:
        while (true) {
            final char[] charArray2 = s2.toCharArray();
            final int j = charArray2.length;
            for (int n7 = 0; j > n7; ++n7) {
                final int n8 = n7;
                final char c4 = charArray2[n8];
                char c5 = '\0';
                switch (n7 % 5) {
                    case 0: {
                        c5 = '?';
                        break;
                    }
                    case 1: {
                        c5 = '4';
                        break;
                    }
                    case 2: {
                        c5 = '\u0018';
                        break;
                    }
                    case 3: {
                        c5 = '\u0016';
                        break;
                    }
                    default: {
                        c5 = '*';
                        break;
                    }
                }
                charArray2[n8] = (char) (c4 ^ c5);
            }
            intern2 = new String(charArray2).intern();
            switch (n6) {
                default: {
                    b = x.a(intern2);
                    s2 = "\u000f\u0004Y\"\u001a\u000b\u0004[&i~\u0004(&\u001a\u000f\u0004( \u0019\n\u0004,T\u001e\f\u0001+$n\f\u0005+#";
                    n6 = 0;
                    continue;
                }
                case 0: {
                    break Label_0295;
                }
            }
        }
        c = x.a(intern2);
    }
}
