package com.conecsa.scanner.plugin

import android.app.Activity
import android.content.Intent
import androidx.activity.result.ActivityResult
import com.getcapacitor.JSObject
import com.getcapacitor.PluginCall
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.kotlin.argumentCaptor
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class Q2iScannerPluginTest {

  private val plugin = CapacitorBarcodeScannerPlugin()

  @Test
  fun resolvesWithScannedValueOnSuccess() {
    val call = mock<PluginCall>()
    val intent = Intent().putExtra("SCAN_RESULT", "0123456789")
    val result = ActivityResult(Activity.RESULT_OK, intent)

    plugin.handleScanResult(call, result)

    val captor = argumentCaptor<JSObject>()
    verify(call).resolve(captor.capture())
    assertEquals("0123456789", captor.firstValue.getString("value"))
  }

  @Test
  fun resolvesWithEmptyValueWhenExtraMissing() {
    val call = mock<PluginCall>()
    val result = ActivityResult(Activity.RESULT_OK, Intent())

    plugin.handleScanResult(call, result)

    val captor = argumentCaptor<JSObject>()
    verify(call).resolve(captor.capture())
    assertEquals("", captor.firstValue.getString("value"))
  }

  @Test
  fun rejectsWhenScanCanceled() {
    val call = mock<PluginCall>()
    val result = ActivityResult(Activity.RESULT_CANCELED, null)

    plugin.handleScanResult(call, result)

    verify(call).reject("Scan canceled")
  }
}
