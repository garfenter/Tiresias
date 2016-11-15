package com.prequal.tiresias.reader;

import android.os.Handler;
import com.feitian.reader.devicecontrol.Card;
import com.feitian.readerdk.Tool.DK;
import java.io.InputStream;
import java.io.OutputStream;

public class ft_reader {
    private Card inner_card;
    private boolean isPowerOn;
    Handler mHandler;

    public ft_reader(InputStream Intmp, OutputStream Outmp) {
        this.isPowerOn = false;
        this.inner_card = new Card(Intmp, Outmp);
    }

    public boolean isPowerOn() {
        return this.isPowerOn;
    }

    public int PowerOn() throws FtBlueReadException {
        int ret = this.inner_card.PowerOn();
        if (ret != 0) {
            throw new FtBlueReadException("Power On Failed");
        }
        this.isPowerOn = true;
        return ret;
    }

    public int PowerOff() throws FtBlueReadException {
        int ret = this.inner_card.PowerOff();
        if (ret != 0) {
            throw new FtBlueReadException("Power Off Failed");
        }
        this.isPowerOn = false;
        return ret;
    }

    public int getProtocol() throws FtBlueReadException {
        if (this.isPowerOn) {
            return this.inner_card.getProtocol();
        }
        throw new FtBlueReadException("Power Off already");
    }

    public byte[] getAtr() throws FtBlueReadException {
        if (this.isPowerOn) {
            return this.inner_card.getAtr();
        }
        throw new FtBlueReadException("Power Off already");
    }

    public int getVersion(byte[] recvBuf, int[] recvBufLen) {
        return this.inner_card.getVersion(recvBuf, recvBufLen);
    }

    public String getDkVersion() {
        return this.inner_card.GetDkVersion();
    }

    public int getCardStatus() throws FtBlueReadException {
        return this.inner_card.getcardStatus();
    }

    public int getSerialNum(byte[] serial, int[] serialLen) {
        return this.inner_card.FtGetSerialNum(serial, serialLen);
    }

    public int readFlash(byte[] buf, int offset, int len) {
        return this.inner_card.FtReadFlash(buf, offset, len);
    }

    public int writeFlash(byte[] buf, int offset, int len) {
        return this.inner_card.FtWriteFlash(buf, offset, len);
    }

    public void registerCardStatusMonitoring(Handler Handler) throws FtBlueReadException {
        this.mHandler = Handler;
        if (this.inner_card.registerCardStatusMonitoring(Handler) != 0) {
            throw new FtBlueReadException("not support cardStatusMonitoring");
        }
    }

    public int transApdu(int tx_length, byte[] tx_buffer, int[] rx_length, byte[] rx_buffer) throws FtBlueReadException {
        if (this.isPowerOn) {
            int ret = this.inner_card.transApdu(tx_length, tx_buffer, rx_length, rx_buffer);
            if (ret == 0) {
                return ret;
            }
            if (ret == DK.BUFFER_NOT_ENOUGH) {
                throw new FtBlueReadException("receive buffer not enough");
            } else if (ret == 3) {
                this.mHandler.obtainMessage(DK.CARD_STATUS, 3, -1).sendToTarget();
                throw new FtBlueReadException("card is absent");
            } else {
                throw new FtBlueReadException("trans apdu error");
            }
        }
        throw new FtBlueReadException("Power Off already");
    }

    public void readerClose() {
        this.inner_card.cardClose();
    }
}
