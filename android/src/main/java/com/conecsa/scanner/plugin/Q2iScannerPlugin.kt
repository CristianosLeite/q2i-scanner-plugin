package com.conecsa.scanner.plugin

import android.content.Intent
import androidx.activity.result.ActivityResult
import com.getcapacitor.JSObject
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.ActivityCallback
import com.getcapacitor.annotation.CapacitorPlugin
import com.journeyapps.barcodescanner.CaptureActivity

@CapacitorPlugin(name = "Q2iScannerPlugin")
class CapacitorBarcodeScannerPlugin : Plugin() {

  @PluginMethod
  fun scanBarcode(call: PluginCall) {
    val intent = Intent(activity, CaptureActivity::class.java)
    startActivityForResult(call, intent, "handleScanResult")
  }

  @ActivityCallback
  fun handleScanResult(call: PluginCall, result: ActivityResult) {
    if (result.resultCode == android.app.Activity.RESULT_OK) {
      val data = result.data?.getStringExtra("SCAN_RESULT") ?: ""
      val ret = JSObject()
      ret.put("value", data)
      call.resolve(ret)
    } else {
      call.reject("Scan canceled")
    }
  }
}
