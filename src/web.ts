import { WebPlugin } from '@capacitor/core';

import type { ScannerPluginPlugin } from './definitions';

export class ScannerPluginWeb extends WebPlugin implements ScannerPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
