package com.prequal.tiresias;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import com.google.gson.Gson;
import com.prequal.tiresias.integration.CardChannel;
import com.prequal.tiresias.reader.FtBlueReadException;
import com.prequal.tiresias.reader.ft_reader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class FtReaderPlugin extends CordovaPlugin {
    private static final UUID MY_UUID;

    static {
        MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        InputStream mInput = null;
        OutputStream mOutput = null;
        if (!action.equals("read")) {
            return false;
        }
        try {
            BluetoothDevice mBlueToothDevice = null;
            for (BluetoothDevice device : BluetoothAdapter.getDefaultAdapter().getBondedDevices()) {
                Log.i(FtReaderPlugin.class.getSimpleName(), "************************* " + device.getName());
                if (device.getName().startsWith("FT_")) {
                    mBlueToothDevice = device;
                    break;
                }
            }
            if(mBlueToothDevice == null){
                callbackContext.error("No se encontro lector de DPI");
                return false;
            }
            BluetoothSocket mBlueToothSocket = mBlueToothDevice.createInsecureRfcommSocketToServiceRecord(MY_UUID);
            mBlueToothSocket.connect();
            try {
                mInput = mBlueToothSocket.getInputStream();
                try {
                    mOutput = mBlueToothSocket.getOutputStream();
                    ft_reader ftReader = new ft_reader(mInput, mOutput);
                    ftReader.PowerOn();
                    CardChannel channel = new CardChannel(ftReader);
                    Object person = null;
                    try {
                        person = new PersonSvcImpl3().readData(channel);
                    } catch (Exception ex) {
                        Log.i(FtReaderPlugin.class.getSimpleName(), "ERROR:::::::::::::::::::::::: " + ex.getMessage(), ex);
                        ex.printStackTrace();
                        try {
                            person = new PersonSvcImpl2().readData(channel);
                        } catch (ReadException e) {
                            e.printStackTrace();
                            callbackContext.error("DPI no reconocido o dañado");
                            return false;
                        }
                    }
                    try {
                        ftReader.PowerOff();
                    } catch (FtBlueReadException e2) {
                        e2.printStackTrace();
                    }
                    Gson gson = new Gson();
                    if (person != null) {
                        callbackContext.success(gson.toJson(person));
                    } else {
                        callbackContext.error("No se ha podido procesar");
                        return false;
                    }
                    if (mOutput != null) {
                        try {
                            mOutput.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (mInput != null) {
                        try {
                            mInput.close();
                        } catch (Exception e4) {
                        }
                    }
                    return true;
                } catch (FtBlueReadException e5) {
                    callbackContext.error("El dispositivo esta apagado");
                    if (mOutput != null) {
                        try {
                            mOutput.close();
                        } catch (Exception e6) {
                        }
                    }
                    if (mInput == null) {
                        return false;
                    }
                    try {
                        mInput.close();
                        return false;
                    } catch (Exception e7) {
                        return false;
                    }
                } catch (Throwable th) {
                    if (mOutput != null) {
                        try {
                            mOutput.close();
                        } catch (Exception e8) {
                        }
                    }
                }
            } catch (Throwable th2) {
                if (mInput != null) {
                    try {
                        mInput.close();
                    } catch (Exception e9) {
                    }
                }
            }
        } catch (IOException e10) {
            e10.printStackTrace();
            callbackContext.error("Failed to parse parameters");
            return false;
        }
        return true;
    }

}
