package edu.up.facemaker;

import android.content.Context;
import android.os.Build;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class Controls implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
        RadioGroup.OnCheckedChangeListener, Spinner.OnItemSelectedListener {


    private MainActivity context;   // reference to the MainActivty that holds all the views
    private Face face = null; // reference to the Face object

    private RadioButton checkedRadioButton; // the radio button that is checked
    private int red; // red color int
    private int green; // green color int
    private int blue; // blue color int

    /**
     * Constructor of a
     *
     * @param face
     */
    public Controls(Face face, MainActivity context) {
        this.face = face;
        this.context = context;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override // for the Buttons
    public void onClick(View view) {
        face.randomize();
        face.invalidate();

    }

    @Override // for seekbar
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // figure out which radio button is currently selected
        if (seekBar == context.findViewById(R.id.redSeekBar)) {
            this.red = progress;
        } else if (seekBar == context.findViewById(R.id.greenSeekBar)) {
            this.green = progress;
        } else if (seekBar == context.findViewById(R.id.blueSeekBar)) {
            this.blue = progress;
        }

        // looks at the radio button to see which is selected
        //context.findViewById(R.id.skinRadio
        if (checkedRadioButton == context.findViewById(R.id.skinRadio)) {
            face.setSkinColor(red, green, blue);
        } else if (checkedRadioButton == context.findViewById(R.id.hairRadio)){
            face.setHairColor(this.red, this.green, this.blue);
        } else if (checkedRadioButton == context.findViewById(R.id.eyesRadio)) {
            face.setEyeColor(this.red, this.green, this.blue);
        }

        face.invalidate();
    }

    @Override // Part of SeekBar interface. Don't care for this
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // Part of SeekBar interface. Don't care for this
    public void onStopTrackingTouch(SeekBar seekBar) {
    }


    /**
      External Citation:
      Date:   6 October 2020
      Problem:    I don't know how to implement the listener for Radio Buttons

      Resource:
      https://stackoverflow.com/questions/6780981/android-radiogroup-
      how-to-configure-the-event-listener
      Solution: I used the example code from this post.
     * @param radioGroup
     * @param i - the RadioButton selected
     */
    @Override // for the Radio Buttons
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        // get's radio button that is checked
        this.checkedRadioButton = (RadioButton) radioGroup.findViewById(i);
        face.invalidate();
    }

    @Override // for the Spinner
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        face.setHairStyle(i);
        face.invalidate();
    }
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        adapterView.setSelection(face.getHairStyle()); // start hairstyle with starting option

    }
}
