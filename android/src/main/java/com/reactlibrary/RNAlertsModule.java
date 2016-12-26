
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Callback;

import android.support.annotation.Nullable;
import android.util.Log;
import android.text.InputType;
import android.support.v7.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.LinearLayout;
import java.util.HashMap;
import java.util.Map;

public class RNAlertsModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;
  private final String TAG = "RNAlerts";

  public AlertDialog.Builder builder;

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
  public void alert(ReadableMap options, final Callback cb) {
    builder = new AlertDialog.Builder(getCurrentActivity());
    if(options.hasKey("title"))
      builder.setTitle(options.getString("title"));
    if(options.hasKey("message"))
      builder.setMessage(options.getString("message"));
    
    String buttonName = (options.hasKey("button")) ? options.getString("button") : "OK";
    builder.setPositiveButton(buttonName, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            cb.invoke();
        }
    });
    AlertDialog ad = builder.create();
    ad.show();
  }

  @ReactMethod
  public void confirm(ReadableMap options, final Callback successCB, final Callback failureCB ) {
    builder = new AlertDialog.Builder(getCurrentActivity());
    if(options.hasKey("title"))
      builder.setTitle(options.getString("title"));
    if(options.hasKey("message"))
      builder.setMessage(options.getString("message"));
    
    String buttonAccept = (options.hasKey("buttonAccept")) ? options.getString("buttonAccept") : "Accept";
    builder.setPositiveButton(buttonAccept, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            successCB.invoke();
        }
    });
    String buttonCancel = (options.hasKey("buttonCancel")) ? options.getString("buttonCancel") : "Cancel";
    builder.setNegativeButton(buttonCancel, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            failureCB.invoke();
        }
    });
    AlertDialog ad = builder.create();
    ad.show();
  }

}