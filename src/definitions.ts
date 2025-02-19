export interface Q2iScannerPlugin {
  scanBarcode(): Promise<{ value: string }>;
}
