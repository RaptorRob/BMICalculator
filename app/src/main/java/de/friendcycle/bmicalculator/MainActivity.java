package de.friendcycle.bmicalculator;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView resultTextValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set screen to only be portrait
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // reference View objects
        final EditText massInputText = findViewById(R.id.editTextMass);
        final EditText heightInputText = findViewById(R.id.editTextHeight);
        resultTextValue = findViewById(R.id.textResultValue);
        final DecimalFormat df = new DecimalFormat("##.00");
        final Button buttonCalculateBMI = findViewById(R.id.button);


        buttonCalculateBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double mass = Double.parseDouble(massInputText.getText().toString());
                double height = Double.parseDouble(heightInputText.getText().toString());
                double bmi = getBodyMassIndex(mass, height);
                //resultTextValue.setTextColor(getResources().getColor(R.color.colorTextPrimary));
                resultTextValue.setText(df.format(bmi).toString());
            }
        });
    }

    /**
     * Calculates the body mass index.
     * @param mass in kg (kilograms)
     * @param height in m (meters)
     * @return the value for body mass index after calculating it with the input of body mass divided
     * by the square potency of body height
     */
    public double getBodyMassIndex(double mass, double height){
        return mass / Math.pow(2,height);
    }
}
