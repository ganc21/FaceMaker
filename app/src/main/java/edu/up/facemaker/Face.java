/*
@author: Chloe Gan
 */

package edu.up.facemaker;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.graphics.Color;
import android.graphics.Paint;
import java.util.Random;

public class Face extends SurfaceView {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle; // identifies which hair style the face has

    Paint skinPaint = new Paint(); // creates new paint object for skin
    Paint eyePaint = new Paint();   // creates new paint object for eye
    Paint hairPaint = new Paint(); // creates new paint object for hair


    float screenHeight = getResources().getDisplayMetrics().heightPixels; // height of screen
    float screenWidth = getResources().getDisplayMetrics().widthPixels; // width of screen

    /**
     * Constructor. When Face object is created, new values assigned to global variables
     */
    public Face(Context context) {
        super(context);
        setWillNotDraw(false); // essential to onDraw, otherwise it won't be called
        randomize();

        //setup palette
        skinPaint.setColor(skinColor);
        eyePaint.setColor(eyeColor);
        hairPaint.setColor(hairColor);
    }

    /**
     * assigns a random number, between 0-255, to each global variable
     */
    public void randomize() {
        Random rand = new Random();
        int upperBound = 255; // 0-255 of the color scale
        skinColor = rand.nextInt(upperBound);
        eyeColor = rand.nextInt(upperBound);
        hairColor = rand.nextInt(upperBound);
        hairStyle = rand.nextInt(upperBound);
    }

    /**
     * Gathers the RGB values from the slider bar, sets them to the local variables inside
     * method, concatinates them into a Hexadecimal string, turns that string into an int that we
     * return.
     * External Citation:
     *       Date:   6 October 2020
     *       Problem:    I don't know how to change hex into an int
     *
     *       Resource:
     *       https://stackoverflow.com/questions/12005424/java-converting-int-to-hex-and-back-again
     *       Solution: I used the example code from this post.
     * @return
     */
    public void setSkinColor(int red, int green, int blue) {
        long alpha = 255; // transparency

        // concatenate the longs above to a hex String
        String hexSkin = Long.toHexString(alpha) + Long.toHexString(red) + Long.toHexString(green)
                + Long.toHexString(blue);

        // parses a hexadecimal number into a long
        int skinVal = (int) Long.parseLong(hexSkin, 16); // type cast long to int
        this.skinColor = skinVal;
    }

    /**
     * Similar to setSkinColor(), but for eyes this time
     */
    public void setEyeColor(int red, int green, int blue) {
        long alpha = 255; // transparency

        // concatenate the longs above to a hex String
        String hexEye = Long.toHexString(alpha) + Long.toHexString(red) + Long.toHexString(green)
                + Long.toHexString(blue);

        // parses a hexadecimal number into a long
        int eyeVal = (int) Long.parseLong(hexEye, 16); // type cast long to int
        this.eyeColor = eyeVal;
    }

    /**
     * Similar to setSkinColor(), but for hair this time
     */
    public void setHairColor(int red, int green, int blue) {
        long alpha = 255; // transparency

        // concatenate the longs above to a hex String
        String hexHair = Long.toHexString(alpha) + Long.toHexString(red) + Long.toHexString(green)
                + Long.toHexString(blue);

        // parses a hexadecimal number into a long
        int hairVal = (int) Long.parseLong(hexHair, 16); // type cast long to int
        this.hairColor = hairVal;
    }

    public void onDraw(Canvas canvas) {

    }

    /**
     * Draws the bases of a face: outline, nose, mouth, ears
     * @param canvas
     * @param x
     * @param y
     */
    public void drawBaseFace(Canvas canvas, float x, float y) {

    }

    /**
     * Draws our eyes on the face with the eye color given by the user
     * @param x
     * @param y
     */
    public void drawEyes(Canvas canvas, float x, float y) {

    }

    /**
     * Draws our hair on the face with the given hair color and hair style
     * @param canvas
     * @param x
     * @param y
     */
    public void drawHair(Canvas canvas, float x, float y) {


    }


}
