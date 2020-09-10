/*
@author: Chloe Gan
 */

package edu.up.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String [] hairStyles = {"Short", "Bald", "Long"}; // hair choices
    private Spinner hairSpin; // spinner object for hair choice

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hairSpin = findViewById(R.id.hairChoiceSpinner);
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.hairStyles);
        hairSpin.setAdapter(hairAdapter);

    }
}