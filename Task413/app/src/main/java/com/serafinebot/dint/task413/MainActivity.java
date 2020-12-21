package com.serafinebot.dint.task413;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements PickerFragmentDelegate, DatePickerDialog.OnDateSetListener {
    private static final String TAG = "MainActivity";
    private Button alertButton = null;
    private Button dateButton = null;
    private Button timeButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.alertButton = findViewById(R.id.alertButton);
        this.dateButton = findViewById(R.id.dateButton);
        this.timeButton = findViewById(R.id.timeButton);
    }

    public void didPressAlertButton(@NonNull View view) {
        if (view.equals(this.alertButton)) {
            new AlertDialog.Builder(this)
                    .setTitle("Alert")
                    .setMessage("This is a test alert")
                    .setPositiveButton("OK", (dialog, which) -> {
                        dialog.cancel();
                    })
                    .create()
                    .show();
            Log.d(TAG, "didPressAlertButton: ");
        }
    }

    public void didPressDateButton(@NonNull View view) {
        if (view.equals(this.dateButton)) {
            final Calendar calendar = Calendar.getInstance();
            final int day = calendar.get(Calendar.DAY_OF_MONTH);
            final int month = calendar.get(Calendar.MONTH);
            final int year = calendar.get(Calendar.YEAR);
            DatePickerDialog datePicker = new DatePickerDialog(this, DatePickerDialog.THEME_DEVICE_DEFAULT_DARK, this, year, month, day);
            datePicker.show();
        }
    }

    public void didPressTimeButton(@NonNull View view) {
        if (view.equals(this.timeButton)) {
            TimePickerFragment timePickerFragment = new TimePickerFragment();
            timePickerFragment.delegate = this;
            timePickerFragment.show(getSupportFragmentManager(), "time_picker_fragment");
        }
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void didSelect(int hour, int minute) {
        Toast.makeText(this, String.format("%d:%d", hour, minute), Toast.LENGTH_LONG).show();
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Toast.makeText(this, String.format("%d/%d/%d", dayOfMonth, month + 1, year), Toast.LENGTH_LONG).show();
    }
}