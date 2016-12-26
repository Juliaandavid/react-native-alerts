
package com.reactlibrary;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.Callback;

import android.support.annotation.Nullable;
import android.util.Log;
import android.graphics.Color;
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
  public void alert(ReadableMap options, final Callback callback) {
    builder = new AlertDialog.Builder(getCurrentActivity());
    if(options.hasKey("title"))
      builder.setTitle(options.getString("title"));
    if(options.hasKey("message"))
      builder.setMessage(options.getString("message"));
    
    String buttonName = (options.hasKey("button")) ? options.getString("button") : "OK";
    builder.setPositiveButton(buttonName, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            callback.invoke();
        }
    });
    AlertDialog ad = builder.create();
    ad.show();
  }

  @ReactMethod
  public void confirm(ReadableMap options, final Callback callback) {
    builder = new AlertDialog.Builder(getCurrentActivity());
    if(options.hasKey("title"))
      builder.setTitle(options.getString("title"));
    if(options.hasKey("message"))
      builder.setMessage(options.getString("message"));
    
    String buttonAccept = (options.hasKey("accept")) ? options.getString("accept") : "Accept";
    builder.setPositiveButton(buttonAccept, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            callback.invoke(true);
        }
    });
    String buttonCancel = (options.hasKey("cancel")) ? options.getString("cancel") : "Cancel";
    builder.setNegativeButton(buttonCancel, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            callback.invoke(false);
        }
    });
    AlertDialog ad = builder.create();
    ad.show();
  }

  @ReactMethod
  public void prompt(ReadableMap options, final Callback callback) {
    builder = new AlertDialog.Builder(getCurrentActivity());

    if(options.hasKey("title"))
      builder.setTitle(options.getString("title"));
    if(options.hasKey("message"))
      builder.setMessage(options.getString("message"));

    final EditText input = new EditText(this.reactContext);
    input.setTextColor(Color.BLACK);
    input.setHintTextColor(Color.LTGRAY);
    input.setInputType( (options.hasKey("inputtype")) ? options.getInt("inputtype") : InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
    if(options.hasKey("placeholder"))
      input.setHint(options.getString("placeholder"));
    builder.setView(input);

    String buttonAccept = (options.hasKey("accept")) ? options.getString("accept") : "Accept";
    builder.setPositiveButton(buttonAccept, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            if(input.getText().toString().matches(""))
              callback.invoke();
            else
              callback.invoke("_"+input.getText().toString());
        }
    });
    String buttonCancel = (options.hasKey("cancel")) ? options.getString("cancel") : "Cancel";
    builder.setNegativeButton(buttonCancel, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            callback.invoke();
        }
    });
    AlertDialog ad = builder.create();
    ad.show();
  }

  @ReactMethod
  public void login(ReadableMap options, final Callback successCB, final Callback failureCB ) {

  }

}