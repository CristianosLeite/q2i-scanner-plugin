package com.conecsa.scanner.plugin;

import android.util.Log;

public class ScannerPlugin {

    public String echo(String value) {
        Log.i("Echo", value);
        return value;
    }
}
