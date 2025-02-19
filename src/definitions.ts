export interface ScannerPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
