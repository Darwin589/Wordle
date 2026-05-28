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
            for(int c = 0;c < 6;c++){
                if(gw.getSquareLetter(row,c).equalsIgnoreCase(Word.substring(c,c+1))){
                    gw.setSquareColor(row,c, WordleGWindow.CORRECT_COLOR);
                }
                else if(Word.toUpperCase().indexOf(gw.getSquareLetter(row,c))!= -1){
                    gw.setSquareColor(row,c, WordleGWindow.PRESENT_COLOR);
                }
                else {
                    gw.setSquareColor(row,c, WordleGWindow.MISSING_COLOR);
                }
            }
            

        }
    }
    static private void changeWord(){
        Word = random[(int)(Math.random()*WordleDictionary.FIVE_LETTER_WORDS.length+1)];

    }
    static private void increaseRow(){
        if(row!= 5 ){   
            row++;
        }
    }
     static String [] random = WordleDictionary.FIVE_LETTER_WORDS;
     static String Word= random[(int)(Math.random()*WordleDictionary.FIVE_LETTER_WORDS.length+1)]; 
     static int row =0;

/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
        /*
        gw.setSquareLetter(0,0,Word.substring(0,1));
        gw.setSquareLetter(0,1,Word.substring(1,2));
        gw.setSquareLetter(0,2,Word.substring(2,3));
        gw.setSquareLetter(0,3,Word.substring(3,4));
        gw.setSquareLetter(0,4,Word.substring(4));
        */

    }

/* Private instance variables */

    private static WordleGWindow gw;

}
