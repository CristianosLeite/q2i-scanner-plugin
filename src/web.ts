import { WebPlugin } from '@capacitor/core';

import type { Q2iScannerPlugin } from './definitions';

export class ScannerPluginWeb extends WebPlugin implements Q2iScannerPlugin {
  async scanBarcode(): Promise<{ value: string }> {
    const dummyBarcode = '1234567890';
    console.log('Simulated barcode scan:', dummyBarcode);
    return { value: dummyBarcode };
  }
}
