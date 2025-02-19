import { registerPlugin } from '@capacitor/core';

import type { Q2iScannerPlugin } from './definitions';

const ScannerPlugin = registerPlugin<Q2iScannerPlugin>('Q2iScannerPlugin', {
  web: () => import('./web').then((m) => new m.ScannerPluginWeb()),
});

export * from './definitions';
export { ScannerPlugin };
