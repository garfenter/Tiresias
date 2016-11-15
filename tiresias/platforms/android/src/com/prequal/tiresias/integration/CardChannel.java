package com.prequal.tiresias.integration;

import android.util.Log;
import com.prequal.tiresias.StringUtil;
import com.prequal.tiresias.reader.FtBlueReadException;
import com.prequal.tiresias.reader.ft_reader;

public class CardChannel {
    public ft_reader reader;

    public CardChannel(ft_reader reader) {
        this.reader = reader;
    }

    public ResponseAPDU transmit(CommandAPDU command) throws CardException {
        return transmit(command, 0x2000);
    }

    public ResponseAPDU transmit(CommandAPDU command, int resultLength) throws CardException {
        byte[] result = new byte[resultLength];
        int[] resultLengthArray = new int[]{resultLength};
        try {
            Log.i("CardChannel", "Enviando: " + StringUtil.toByteString(command.getData()));
            this.reader.transApdu(command.getData().length, command.getData(), resultLengthArray, result);
            Log.i("CardChannel", "RECIBIENDO***************************: " + StringUtil.toByteString(result));
            int position = 0;
            byte lastByte = (byte) 0;
            boolean twoZeros = false;
            int i = 0;
            while (i < result.length) {
                if (lastByte == 0 && result[i] == 0 && !twoZeros) {
                    twoZeros = true;
                    position = i;
                }
                if (result[i] != 0) {
                    twoZeros = false;
                }
                lastByte = result[i];
                i++;
            }
            byte[] realResult = new byte[position];
            for (i = 0; i < position; i++) {
                realResult[i] = result[i];
            }
            Log.i("CardChannel", "RESULTADO:***************************: " + StringUtil.toByteString(realResult));
            return new ResponseAPDU(realResult);
        } catch (FtBlueReadException e) {
            throw new CardException(e);
        }
    }
}
