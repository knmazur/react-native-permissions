package com.zoontek.rnpermissions;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.PermissionListener;

@ReactModule(name = RNPermissionsModuleImpl.MODULE_NAME)
public class RNPermissionsModule extends ReactContextBaseJavaModule implements PermissionListener  {
  private RNPermissionsModuleImpl implementation;


  public RNPermissionsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.implementation = new RNPermissionsModuleImpl(reactContext, this);
  }

  @Override
  public String getName() {
    return RNPermissionsModuleImpl.MODULE_NAME;
  }

  @ReactMethod
  public void checkNotifications(final Promise promise) {
    implementation.checkNotifications(promise);
  }

  @ReactMethod
  public void openSettings(final Promise promise) {
    implementation.openSettings(promise);
  }

  @ReactMethod
  public void checkPermission(final String permission, final Promise promise) {
    implementation.checkPermission(permission, promise);
  }

  @ReactMethod
  public void shouldShowRequestPermissionRationale(final String permission, final Promise promise) {
    implementation.shouldShowRequestPermissionRationale(permission, promise, getCurrentActivity());
  }

  @ReactMethod
  public void requestPermission(final String permission, final Promise promise) {
    implementation.requestPermission(permission, promise, getCurrentActivity());
  }

  @ReactMethod
  public void checkMultiplePermissions(final ReadableArray permissions, final Promise promise) {
    implementation.checkMultiplePermissions(permissions, promise);
  }

  @ReactMethod
  public void requestMultiplePermissions(final ReadableArray permissions, final Promise promise) {
    implementation.requestMultiplePermissions(permissions,promise,getCurrentActivity());
  }

  @Override
  public boolean onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    return implementation.onRequestPermissionsResult(requestCode, permissions, grantResults, getCurrentActivity());
  }
}
