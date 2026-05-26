/*
 * File: Wordle.java
 * -----------------
 * This module is the starter file for the Wordle assignment.
 * BE SURE TO UPDATE THIS COMMENT WHEN YOU COMPLETE THE CODE.
 */

import edu.willamette.cs1.wordle.WordleDictionary;
import edu.willamette.cs1.wordle.WordleGWindow;
import java.util.*;

public class Wordle {

    public void run() {
        gw = new WordleGWindow();
        gw.addEnterListener((s) ->  enterAction(s));
    }

/*
 * Called when the user hits the RETURN key or clicks the ENTER button,
 * passing in the string of characters on the current row.
 */

    public void enterAction(String s) {
        if(isLegalWord(s) == true){
            gw.showMessage("Legal word good job");
        }
        else{
            gw.showMessage("try again, not a legal word");
        }
        }
    private boolean isLegalWord(String word){
        String [] dictionary = WordleDictionary.FIVE_LETTER_WORDS;
        word = word.toLowerCase();
        int lh =0;
        int rb = dictionary.length-1;
        while(lh <= rb){
            int mid = (lh +rb)/2;
            int cmp = word.compareTo(dictionary[mid]);
            if(cmp == 0){
                return true;
                }        
            else if(cmp <0){
                rb = mid-1;
            }
            else {
                lh =mid+1;
                }
    }
        return false;
    }

    

/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
       gw.setSquareLetter(0,0,"Z");
       gw.setSquareLetter(0,1,"A");
       gw.setSquareLetter(0,2,"I");
       gw.setSquareLetter(0,3,"D");
       gw.setSquareLetter(0,4,"S");
    }

/* Private instance variables */

    private static WordleGWindow gw;

}
