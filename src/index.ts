import { registerPlugin } from '@capacitor/core';

import type { ScannerPluginPlugin } from './definitions';

const ScannerPlugin = registerPlugin<ScannerPluginPlugin>('ScannerPlugin', {
  web: () => import('./web').then((m) => new m.ScannerPluginWeb()),
});

export * from './definitions';
export { ScannerPlugin };
