package com.serafinebot.dint.task412;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText editText = null;
    private Spinner spinner = null;
    private Button showButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText = findViewById(R.id.editText);
        this.spinner = findViewById(R.id.spinner);
        this.showButton = findViewById(R.id.showButton);

        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this, R.array.phone_numbers, android.R.layout.simple_spinner_item);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.spinner.setAdapter(spinnerAdapter);
    }

    public void didPressShowButton(@NonNull View view) {
        if (view.equals(this.showButton)) {
            Toast.makeText(this, String.format("Phone number: %s - %s", this.editText.getText(), spinner.getSelectedItem()), Toast.LENGTH_LONG).show();
        }
    }
}
