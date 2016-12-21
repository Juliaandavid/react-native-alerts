
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Callback;

import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.ReadableType;

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
  public void testParameters(ReadableMap readableMap, final Callback cb) {
    if (readableMap == null) {
      cb.invoke("null");
    }

    ReadableMapKeySetIterator iterator = readableMap.keySetIterator();

    WritableMap bundle = new WritableNativeMap();

    while (iterator.hasNextKey()) {
      String key = iterator.nextKey();
      ReadableType readableType = readableMap.getType(key);
      switch (readableType) {
        case Null:
          bundle.putString(key, null);
          break;
        case Boolean:
          bundle.putBoolean(key, readableMap.getBoolean(key));
          break;
        case Number:
          // Can be int or double.
          bundle.putDouble(key, readableMap.getDouble(key));
          break;
        case String:
          bundle.putString(key, readableMap.getString(key));
          break;
        default:
          throw new IllegalArgumentException("Could not convert object with key: " + key + ".");
      }
    }

    cb.invoke(bundle);
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

}