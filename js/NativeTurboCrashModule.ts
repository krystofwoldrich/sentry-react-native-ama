import type {TurboModule} from 'react-native/Libraries/TurboModule/RCTExport';
import {TurboModuleRegistry} from 'react-native';

export interface Spec extends TurboModule {
  getDataCrash(): string;
}

export default TurboModuleRegistry.get<Spec>('TurboCrashModule') as Spec | null;
