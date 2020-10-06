/*
@author: Chloe Gan
 */

package edu.up.facemaker;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // hair choices
    String[] hairStyles = {"Short", "Long", "Bald"};

    private Spinner hairSpin; // spinner object for hair choice

    Face face;
    Controls controls;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // this needs to be set first before any surface view
        face = new Face(this); // now we can call this
        controls = new Controls(face, this); // now we can call this

        // spinner options
        hairSpin = findViewById(R.id.hairChoiceSpinner); // gets our spinner ID
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>( // creates new ArrayAdapter
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.hairStyles); // populates our spinner with our hair choices
        hairSpin.setAdapter(hairAdapter); // sets our spinner we selected with our hair choices

    }
}