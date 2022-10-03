// @flow
import type { TurboModule } from 'react-native/Libraries/TurboModule/RCTExport';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
    +checkNotifications: () => Promise<Object>,
    +openSettings: () => Promise<boolean>,
    +checkPermission: (permission: string) => Promise<string>,
    +shouldShowRequestPermissionRationale: (permission: string) => Promise<boolean>,
    +requestPermission: (permission: string) => Promise<string>,
    +checkMultiplePermissions: (permissions: Array<string>) => Promise<Object>,
    +requestMultiplePermissions: (permissions: Array<string>) => Promise<Object>,
}

export default (TurboModuleRegistry.get<Spec>(
'RNPermissions'
): ?Spec);