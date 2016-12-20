package co.darto.alerts;

//
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;
//

public class MainActivity extends AppCompatActivity {

    private static final int INPUT_TEXT = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_FLAG_CAP_SENTENCES;
    private static final int INPUT_EMAIL = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS;
    private static final int INPUT_PASSWORD = InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD;
    private static final int INPUT_NUMBER = InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED | InputType.TYPE_NUMBER_FLAG_DECIMAL;
    private static final int INPUT_PHONE = InputType.TYPE_CLASS_PHONE;

    private Context reactContext = this;

    public AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Map<String, Integer> constants = new HashMap<>();
    }

    public void alert (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(reactContext);
        //builder.setTitle("Esto es un título");
        builder.setMessage("Esto es un mensaje de prueba");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        dialog = builder.create();
        dialog.show();
    }

    public void confirm (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(reactContext);
        builder.setTitle("Esto es un título");
        builder.setMessage("Esto es un mensaje de prueba");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked Cancel button
            }
        });
        dialog = builder.create();
        dialog.show();
    }

    public void prompt (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(reactContext);
        builder.setTitle("Esto es un título");
        builder.setMessage("Esto es un mensaje de prueba");
        EditText input = new EditText(reactContext);
        input.setInputType(INPUT_TEXT);
        input.setHint("Placeholder");
        builder.setView(input);
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked Cancel button
            }
        });
        dialog = builder.create();
        dialog.show();
    }

    public void form (View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(reactContext);
        builder.setTitle("Esto es un título");
        builder.setMessage("Esto es un mensaje de prueba");

        LinearLayout layout = new LinearLayout(reactContext);
        layout.setOrientation(LinearLayout.VERTICAL);
        EditText input1 = new EditText(reactContext);
        EditText input2 = new EditText(reactContext);
        input1.setInputType(INPUT_EMAIL);
        input2.setInputType(INPUT_PASSWORD);
        input1.setHint("Email");
        input2.setHint("Contraseña");
        layout.addView(input1);
        layout.addView(input2);
        builder.setView(layout);

        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked OK button
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked Cancel button
            }
        });
        dialog = builder.create();
        dialog.show();
    }

}
