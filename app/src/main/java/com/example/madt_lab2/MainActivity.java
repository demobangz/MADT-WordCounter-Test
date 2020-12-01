package com.example.madt_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Resources resources;
    private Spinner spinnerFunction;
    private EditText theInput;
    private TextView theOutput;
    private Button buttonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get Text Input By ID

        theInput = (EditText) findViewById(R.id.theInput);
        theInput.setHint(R.string.theInput_hint);

        // Spinner Function

        spinnerFunction = (Spinner) findViewById(R.id.spinnerFunction);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.method_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFunction.setAdapter(adapter);

        // Gets Output by Id

        theOutput = (TextView) findViewById(R.id.theOutput);

        // The Button Function

        buttonCount = (Button) findViewById(R.id.buttonCount);
        buttonCount.setText(R.string.buttonCount_value);

        resources = getResources();
    }

    public void onButtonCountClick(View view) {

        if(theInput.getText().toString().isEmpty()) {
            theOutput.setText("");
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, resources.getStringArray(R.array.errors)[0], Toast.LENGTH_SHORT);
            toast.show();

        }
        else {
            String spinnerValue = spinnerFunction.getSelectedItem().toString();
            String output;

            switch (spinnerValue) {
                case "Words":
                    output = StringResource.numWords(
                            theInput.getText().toString()) + " " + resources.getStringArray(R.array.method_options)[0];
                    break;
                case "Characters":
                    output = StringResource.numChars(
                            theInput.getText().toString()) + " " + resources.getStringArray(R.array.method_options)[1];
                    break;
                default:
                    throw new IllegalStateException(resources.getStringArray(R.array.errors)[1] + spinnerValue);
            }


            theOutput.setText(output);
        }

    }

}