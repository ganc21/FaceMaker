/*
@author: Chloe Gan
 */

package edu.up.facemaker;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.RequiresApi;

import java.util.Random;

public class Face extends SurfaceView {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle; // identifies which hair style the face has

    private Paint skinPaint = new Paint(); // creates new paint object for skin
    private Paint eyePaint = new Paint();   // creates new paint object for eye
    private Paint hairPaint = new Paint(); // creates new paint object for hair
    private Paint whitePaint = new Paint();
    private Paint redPaint = new Paint();
    private Paint blackPaint = new Paint();

    /**
     External Citation:
     Date:   6 October 2020
     Problem:    How do I make all the shapes relative to the screen size?

     Resource:
     https://developer.android.com/reference/android/util/DisplayMetrics
     Solution: Followed documentation
     */
    float screenHeight = getResources().getDisplayMetrics().heightPixels; // height of screen
    float screenWidth = getResources().getDisplayMetrics().widthPixels; // width of screen
    float cx = screenWidth/2f; // half width
    float cy = screenHeight/3f; // 3rd height

    /**
     * Constructor. When Face object is created, new values assigned to global variables
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false); // essential to onDraw, otherwise it won't be called
        randomize();

        //setup palette
        skinPaint.setColor(skinColor);
        skinPaint.setStyle(Paint.Style.FILL);
        eyePaint.setColor(eyeColor);
        hairPaint.setColor(hairColor);

        whitePaint.setColor(Color.WHITE);
        redPaint.setColor(Color.RED);
        blackPaint.setColor(Color.BLACK);

    }

    /**
     * assigns a random number, between 0-255, to each global variable
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void randomize() {
        Random rand = new Random();
        int upperBound = 256; // 0-255 of the color scale, 256 exclusive
        skinColor = rand.nextInt(upperBound);
        eyeColor = rand.nextInt(upperBound);
        hairColor = rand.nextInt(upperBound);
        hairStyle = rand.nextInt(4-1) + 1;
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
    public void setSkinColor(long red, long green, long blue) {
        long alpha = 255; // transparency

        // concatenate the longs above to a hex String
        String hexSkin = Long.toHexString(alpha) + Long.toHexString(red) + Long.toHexString(green)
                + Long.toHexString(blue);

        // parses a hexadecimal number into a long
        int skinVal = (int) Long.parseLong(hexSkin, 16); // type cast long to int
        this.skinColor = skinVal;
    }

    public int getSkinColor() {
        return skinColor;
    } // getter for skinColor

    /**
     * Similar to setSkinColor(), but for eyes this time
     */
    public void setEyeColor(long red, long green, long blue) {
        long alpha = 255; // transparency

        // concatenate the longs above to a hex String
        String hexEye = Long.toHexString(alpha) + Long.toHexString(red) + Long.toHexString(green)
                + Long.toHexString(blue);

        // parses a hexadecimal number into a long
        int eyeVal = (int) Long.parseLong(hexEye, 16); // type cast long to int
        this.eyeColor = eyeVal;
    }
    public int getEyeColor() {
        return eyeColor;
    }

    /**
     * Similar to setSkinColor(), but for hair this time
     */
    public void setHairColor(long red, long green, long blue) {
        long alpha = 255; // transparency

        // concatenate the longs above to a hex String
        String hexHair = Long.toHexString(alpha) + Long.toHexString(red) + Long.toHexString(green)
                + Long.toHexString(blue);

        // parses a hexadecimal number into a long
        int hairVal = (int) Long.parseLong(hexHair, 16); // type cast long to int
        this.hairColor = hairVal;
    }
    public int getHairColor() {
        return hairColor;
    }

    // set the hair style
    public void setHairStyle(int i) {
        this.hairStyle = i;

    }
    // get the hair style
    public int getHairStyle() {return hairStyle; }


    /**
     * Draws the bases of a face: outline, nose, mouth, ears
     * @param canvas
     * @param x // screen width, screenWidth
     * @param y // screen, screenHeight
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void drawBaseFace(Canvas canvas, float x, float y) {
        float radius = x/4; // circle radius
        skinPaint.setColor(getSkinColor());
        skinPaint.setStyle(Paint.Style.FILL);

        whitePaint.setStyle(Paint.Style.STROKE);
        whitePaint.setStrokeWidth(5f);

        // outline of the face
        skinPaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx, cy, radius, skinPaint);

        // mouth
        redPaint.setStyle(Paint.Style.FILL);
        RectF ourOval = new RectF(cx-(cx/3), y/2-200, cx+200, y/2-150);
        canvas.drawOval(ourOval, redPaint);

        // nose
        canvas.drawCircle(cx,cy, radius/10, whitePaint);
        canvas.drawCircle(cx,cy, radius/10-1, skinPaint);

        // eye whites
        whitePaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx-(cx/4),y/3.5f,radius/5, whitePaint); // left eye
        canvas.drawCircle(cx+(cx/4), y/3.5f, radius/5, whitePaint); // right eye

    }

    /**
     * Draws our eyes on the face with the eye color given by the user
     * @param x screenWidth
     * @param y screenHeight
     */
    public void drawEyes(Canvas canvas, float x, float y) {
        float radius = x/4; // circle radius
        eyePaint.setColor(getEyeColor());
        eyePaint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(cx-(cx/4),y/3.5f,radius/7f, eyePaint); // left iris
        canvas.drawCircle(cx+(cx/4), y/3.5f, radius/5f, eyePaint); // right iris
    }

    /**
     * Draws our hair on the face with the given hair color and hair style
     * @param canvas
     * @param x
     * @param y
     */
    public void drawHair(Canvas canvas, float x, float y) {
        hairPaint.setColor(getHairColor());
        float radius = x/4; // circle radius
        redPaint.setStyle(Paint.Style.FILL);
        if (getHairStyle() == 1) {
            canvas.drawCircle(cx, radius+10, radius/4, redPaint);//top bun
        } else if (getHairStyle() == 2) {
            // left bun
            canvas.drawCircle(cx-(cx/4),radius+cx/6, radius/4, hairPaint );
            //right bun
            canvas.drawCircle(cx+(cx/4),radius+cx/6, radius/4, hairPaint );
        } else if (getHairStyle() == 3) {

        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawHair(canvas, screenWidth, screenHeight);
        drawBaseFace(canvas, screenWidth, screenHeight); // basics of a face and outline
        drawEyes(canvas, screenWidth, screenHeight); // eye iris
    }


}
