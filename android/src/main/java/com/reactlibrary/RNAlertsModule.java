
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
              callback.invoke(null);
            else
              callback.invoke(input.getText().toString());
        }
    });
    String buttonCancel = (options.hasKey("cancel")) ? options.getString("cancel") : "Cancel";
    builder.setNegativeButton(buttonCancel, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            callback.invoke(null);
        }
    });
    AlertDialog ad = builder.create();
    ad.show();
  }

  @ReactMethod
  public void login(ReadableMap options, final Callback callback) {
		builder = new AlertDialog.Builder(getCurrentActivity());

    if(options.hasKey("title"))
      builder.setTitle(options.getString("title"));
    if(options.hasKey("message"))
      builder.setMessage(options.getString("message"));

		LinearLayout layout = new LinearLayout(this.reactContext);
		layout.setOrientation(LinearLayout.VERTICAL);
		final EditText input1 = new EditText(this.reactContext);
		final EditText input2 = new EditText(this.reactContext);
		
		input1.setTextColor(Color.BLACK);
    input1.setHintTextColor(Color.LTGRAY);
		input2.setTextColor(Color.BLACK);
    input2.setHintTextColor(Color.LTGRAY);

		input1.setInputType( (options.hasKey("userInputType")) ? options.getInt("userInputType") : InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES);
		input2.setInputType( (options.hasKey("passwordInputType")) ? options.getInt("passwordInputType") : InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

		if(options.hasKey("userPlaceholder"))
      input1.setHint(options.getString("userPlaceholder"));
		if(options.hasKey("passwordPlaceholder"))
      input2.setHint(options.getString("passwordPlaceholder"));

		layout.addView(input1);
		layout.addView(input2);
		builder.setView(layout);

		String buttonAccept = (options.hasKey("accept")) ? options.getString("accept") : "Accept";
    builder.setPositiveButton(buttonAccept, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
						String user = (input1.getText().toString().matches("")) ? null : input1.getText().toString();
						String password = (input2.getText().toString().matches("")) ? null : input2.getText().toString();
						callback.invoke(user, password);
        }
    });
    String buttonCancel = (options.hasKey("cancel")) ? options.getString("cancel") : "Cancel";
    builder.setNegativeButton(buttonCancel, new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int id) {
            callback.invoke(null, null);
        }
    });
    AlertDialog ad = builder.create();
    ad.show();
  }

}