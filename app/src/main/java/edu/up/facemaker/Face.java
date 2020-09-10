/*
@author: Chloe Gan
 */

package edu.up.facemaker;
import java.util.Random;

public class Face {
    private int skinColor;
    private int eyeColor;
    private int hairColor;
    private int hairStyle; // identifies which eye style the face has

    public Face() {
        randomize();
    }

    public void randomize() {
        Random rand = new Random();
        int upperBound = 255; // 0-255 of the color scale

        skinColor = rand.nextInt(upperBound);
        eyeColor = rand.nextInt(upperBound);
        hairColor = rand.nextInt(upperBound);
        hairStyle = rand.nextInt(upperBound);
    }
}
