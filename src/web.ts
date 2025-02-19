import { WebPlugin } from '@capacitor/core';

import type { Q2iScannerPlugin } from './definitions';

export class ScannerPluginWeb extends WebPlugin implements Q2iScannerPlugin {
  async scanBarcode(): Promise<{ value: string }> {
    return Promise.resolve({ value: 'web' });
  }
}
