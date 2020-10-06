package edu.up.facemaker;

import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class Controls implements View.OnClickListener, SeekBar.OnSeekBarChangeListener,
        RadioGroup.OnCheckedChangeListener, Spinner.OnItemSelectedListener {

    private Face face = null; // reference to the Face object

    /**
     * Constructor of a
     *
     * @param face
     */
    public Controls(Face face) {
        this.face = face;
    }

    @Override // for the Buttons
    public void onClick(View view) {
        face.randomize();
        face.invalidate();

    }

    @Override // for the seekbar
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


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
        // get's radio button
        RadioButton checkedRadioButton = (RadioButton) radioGroup.findViewById(i);

    }

    @Override // for the Spinner
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
