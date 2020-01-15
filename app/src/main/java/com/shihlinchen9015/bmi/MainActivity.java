package com.shihlinchen9015.bmi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edWeight;
    private EditText edHeight;
    private Button help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        edWeight = findViewById(R.id.ed_weight);
        edHeight = findViewById(R.id.ed_height);
        help = findViewById(R.id.help);
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.help)
                        .setMessage(R.string.bmi_info)
                        .setPositiveButton(R.string.ok, null)
                        .show();
            }
        });
    }

    public void bmi(View view) {
        String w = edWeight.getText().toString();
        String h = edHeight.getText().toString();
        float weight = Float.parseFloat(w);
        float height = Float.parseFloat(h);
        float bmi = weight / (height * height);

        Log.d("MainActivity", "BMI:" + bmi);
        Toast.makeText(this, getString(R.string.your_bmi) + bmi, Toast.LENGTH_LONG).show();

        new AlertDialog.Builder(this)
                .setTitle("BMI")
                .setMessage(getString(R.string.your_bmi) + bmi)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edWeight.setText("");
                        edHeight.setText("");
                    }
                })
                .show();
    }
}
