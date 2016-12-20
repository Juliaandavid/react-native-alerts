
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Promise;

import android.text.InputType;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.Map;

public class RNAlertsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public AlertDialog dialog;

  public RNAlertsModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNAlerts";
  }

  @Override
  public Map<String, Object> getConstants() {
    final Map<String, Object> constants = new HashMap<>();

    constants.put("INPUT_TEXT", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
    constants.put("INPUT_EMAIL", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
    constants.put("INPUT_PASSWORD", InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
    constants.put("INPUT_NUMBER", InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL);
    constants.put("INPUT_PHONE", InputType.TYPE_CLASS_PHONE);

    return constants;
  }

  @ReactMethod
  public void alert(String message, @Nullable Callback successCallback) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getReactApplicationContext());
    builder.setMessage(message);
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            successCallback.invoke();
        }
    });
    dialog = builder.create();
    dialog.show();
  }

  /*@ReactMethod
  public void alert(String title, String message, final Promise promise) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getReactApplicationContext());
    builder.setTitle(title);
    builder.setMessage(message);
    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            promise.resolve(null);
        }
    });
    dialog = builder.create();
    dialog.show();
  }

  @ReactMethod
  public void alert(String title, String message, String button, final Promise promise) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getReactApplicationContext());
    builder.setTitle(title);
    builder.setMessage(message);
    builder.setPositiveButton(button, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            promise.resolve(null);
        }
    });
    dialog = builder.create();
    dialog.show();
  }*/

}