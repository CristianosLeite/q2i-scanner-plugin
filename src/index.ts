import { registerPlugin } from '@capacitor/core';

import type { Q2iScannerPlugin } from './definitions';

const ScannerPlugin = registerPlugin<Q2iScannerPlugin>('ScannerPlugin', {
  web: () => import('./web').then((m) => new m.ScannerPluginWeb()),
});

export * from './definitions';
export { ScannerPlugin };
