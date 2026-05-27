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
            correction(s);
            gw.showMessage("Legal word, good job");
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
    private void correction(String w){
        if(isLegalWord(w) == true){
            int row= 0;
            for(int c = 0;c < 6;c++){
                if(gw.getSquareLetter(0,c).equals(Word.substring(0,1))){
                    gw.setSquareColor(0,0, WordleGWindow.CORRECT_COLOR);
                }
                else if(Word.indexOf(gw.getSquareLetter(0,c))!= -1){
                    gw.setSquareColor(0,0, WordleGWindow.PRESENT_COLOR);
                }
                else {
                    gw.setSquareColor(0,0, WordleGWindow.MISSING_COLOR);
                }

                if(gw.getSquareLetter(0,c).equals(Word.substring(1,2))){
                    gw.setSquareColor(0,1, WordleGWindow.CORRECT_COLOR);
                }
                else if(Word.indexOf(gw.getSquareLetter(0,c))!= -1){
                    gw.setSquareColor(0,1, WordleGWindow.PRESENT_COLOR);
                }
                else {
                    gw.setSquareColor(0,1, WordleGWindow.MISSING_COLOR);
                }

                if(gw.getSquareLetter(0,c).equals(Word.substring(2,3))){
                    gw.setSquareColor(0,2, WordleGWindow.CORRECT_COLOR);
                }
                else if(Word.indexOf(gw.getSquareLetter(0,c))!= -1){
                    gw.setSquareColor(0,2, WordleGWindow.PRESENT_COLOR);
                }
                else {
                    gw.setSquareColor(0,2, WordleGWindow.MISSING_COLOR);
                }

                if(gw.getSquareLetter(0,c).equals(Word.substring(3,4))){
                    gw.setSquareColor(0,3, WordleGWindow.CORRECT_COLOR);
                }
                else if(Word.indexOf(gw.getSquareLetter(0,c))!= -1){
                    gw.setSquareColor(0,3, WordleGWindow.PRESENT_COLOR);
                }
                else {
                    gw.setSquareColor(0,3, WordleGWindow.MISSING_COLOR);
                }

                if(gw.getSquareLetter(0,c).equals(Word.substring(4))){
                    gw.setSquareColor(0,4, WordleGWindow.CORRECT_COLOR);
                }
                else if(Word.indexOf(gw.getSquareLetter(0,c))!= -1){
                    gw.setSquareColor(0,4, WordleGWindow.PRESENT_COLOR);
                }
                else {
                    gw.setSquareColor(0,4, WordleGWindow.MISSING_COLOR);
                }
            }
            

        }
    }
    static private void changeWord(){
        Word = random[(int)(Math.random()*WordleDictionary.FIVE_LETTER_WORDS.length+1)];

    }
     static String [] random = WordleDictionary.FIVE_LETTER_WORDS;
     static String Word= random[(int)(Math.random()*WordleDictionary.FIVE_LETTER_WORDS.length+1)]; 

/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();

    }

/* Private instance variables */

    private static WordleGWindow gw;

}
