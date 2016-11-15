package com.prequal.tiresias;

import org.apache.cordova.BuildConfig;

public class StringUtil {
    public static String toByteString(byte[] array) {
        String result = BuildConfig.FLAVOR;
        for (byte b : array) {
            result = result + b + " ";
        }
        return result;
    }
}
