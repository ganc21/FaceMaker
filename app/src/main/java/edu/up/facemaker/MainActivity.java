/*
@author: Chloe Gan
 */

package edu.up.facemaker;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // hair choices
    private String[] hairStyles = {"One Bun", "Two Buns", "Bald"};


    private Face face;
    private Controls controls;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main); //this needs to be set first before any surface view

        //face = new Face(this, null); // reference to Face object

        face = findViewById(R.id.my_view);
        controls = new Controls(face, this); // reference to Controls,


        // spinner object and populate the spinner
        Spinner hairSpin = findViewById(R.id.hairChoiceSpinner); // gets our spinner ID
        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>( // creates new ArrayAdapter
                this,
                android.R.layout.simple_spinner_dropdown_item,
                this.hairStyles); // populates our spinner with our hair choices
        hairSpin.setAdapter(hairAdapter); // sets our spinner we selected with our hair choices

        hairSpin.setOnItemSelectedListener(controls);



        //seekbar objects and calls to the Control class
        SeekBar seekBarRed = findViewById(R.id.redSeekBar);
        SeekBar seekBarGreen = findViewById(R.id.greenSeekBar);
        SeekBar seekBarBlue = findViewById(R.id.blueSeekBar);
        seekBarRed.setOnSeekBarChangeListener(controls);
        seekBarGreen.setOnSeekBarChangeListener(controls);
        seekBarBlue.setOnSeekBarChangeListener(controls);

        //button
        Button button = findViewById(R.id.randomButton);
        button.setOnClickListener(controls);

        //radio button
        RadioButton skinRadioB = findViewById(R.id.skinRadio);
        RadioButton eyesRadioB = findViewById(R.id.eyesRadio);
        RadioButton hairRadioB = findViewById(R.id.hairRadio);
        skinRadioB.setOnClickListener(controls);
        eyesRadioB.setOnClickListener(controls);
        hairRadioB.setOnClickListener(controls);


    }
}