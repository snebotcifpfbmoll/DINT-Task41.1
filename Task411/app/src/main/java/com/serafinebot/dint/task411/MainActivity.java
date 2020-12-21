package com.serafinebot.dint.task411;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText editText = null;
    private Button showButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editText = findViewById(R.id.editText);
        this.showButton = findViewById(R.id.showButton);
    }

    public void didPressShowButton(View view) {
        if (view.equals(this.showButton))
            Toast.makeText(this, this.editText.getText(), Toast.LENGTH_LONG).show();
    }
}