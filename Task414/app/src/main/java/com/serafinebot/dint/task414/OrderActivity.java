package com.serafinebot.dint.task414;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
    private static final String TAG = "OrderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
    }

    public void displayToast(String msg) {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.sameday:
                if (checked)
                    displayToast(getString(R.string.chosen) + getString(R.string.same_day));
                break;
            case R.id.nextday:
                if (checked)
                    displayToast(getString(R.string.chosen) + getString(R.string.next_day));
                break;
            case R.id.pickup:
                if (checked) displayToast(getString(R.string.chosen) + getString(R.string.pick_up));
                break;
            default:
                Log.w(TAG, "onRadioButtonClicked: unknown radio button pressed.");
                break;
        }
    }
}