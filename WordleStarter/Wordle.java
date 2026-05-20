/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * BE SURE TO UPDATE THIS COMMENT WHEN YOU COMPLETE THE CODE.
 */

import edu.willamette.cs1.wordle.WordleDictionary;
import edu.willamette.cs1.wordle.WordleGWindow;

public class Wordle {

    public void run() {
        gw = new WordleGWindow();
        gw.addEnterListener((s) -> enterAction(s));
    }

/*
 * Called when the user hits the RETURN key or clicks the ENTER button,
 * passing in the string of characters on the current row.
 */

    public void enterAction(String s) {
        gw.showMessage("You have to implement this method.");
        
        
    }

/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
       gw.setSquareLetter(0,0,"z");
       gw.setSquareLetter(0,1,"a");
       gw.setSquareLetter(0,2,"i");
       gw.setSquareLetter(0,3,"d");
       gw.setSquareLetter(0,4,"s");
    }

/* Private instance variables */

    private static WordleGWindow gw;

}
