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
        gw.addEnterListener((s) ->  enterAction(s) );
        
        
    }

/*
 * Called when the user hits the RETURN key or clicks the ENTER button,
 * passing in the string of characters on the current row.
 */

    public void enterAction(String s) {
        
            if(isLegalWord(s) == true){
                
                
                correction(s);
                gw.showMessage("Legal word, good job");
                if(s.equalsIgnoreCase(Word)){
                    count++;
                    gw.showMessage("Good Job, you guessed the word correctly "+count+" times"); 
                    if(gw.getCurrentRow()!= 5){
                    changeWord();
                    }
                    System.out.println(Word);
                    /*
                    gw.setSquareLetter(5,0,Word.substring(0,1).toUpperCase());
                    gw.setSquareLetter(5,1,Word.substring(1,2).toUpperCase());
                    gw.setSquareLetter(5,2,Word.substring(2,3).toUpperCase());
                    gw.setSquareLetter(5,3,Word.substring(3,4).toUpperCase());
                    gw.setSquareLetter(5,4,Word.substring(4).toUpperCase());
                    */
                }
                /*
                System.out.println("hello");
                System.out.print(gw.getCurrentRow());
                */
                if(gw.getCurrentRow() == 5 && !s.equalsIgnoreCase(Word)){
                    gw.showMessage("Better luck next time the word was: "+Word);
                }
                increaseRow();
            
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
            
        String unmatched = Word.toUpperCase();
        for(int co = 0; co < WordleGWindow.N_COLS;co++){
            char ch = gw.getSquareLetter(row,co).toUpperCase().charAt(0);
            if(Word.toUpperCase().charAt(co) == ch){
                gw.setSquareColor(row,co,WordleGWindow.CORRECT_COLOR);
                //gw.setKeyColor(unmatched.substring(co,co+1),WordleGWindow.CORRECT_COLOR);
            }else {
                int index = unmatched.toUpperCase().indexOf(ch);
                if(index == -1){
                    gw.setSquareColor(row,co,WordleGWindow.MISSING_COLOR);
                    /*
                    if(gw.getKeyColor(unmatched.substring(co,co+1)) == WordleGWindow.CORRECT_COLOR){
                        break;
                    }
                    else{
                        gw.setKeyColor(unmatched.substring(co,co+1),WordleGWindow.MISSING_COLOR);
                    }
                    */
                }
                else{
                    gw.setSquareColor(row,co,WordleGWindow.PRESENT_COLOR);
                    unmatched = unmatched.toUpperCase().replaceFirst(""+ch, "");
                    /*
                    if(gw.getKeyColor(unmatched.substring(co,co+1)) == WordleGWindow.CORRECT_COLOR){
                        break;
                    }
                    else{
                        gw.setKeyColor(unmatched.substring(co,co+1),WordleGWindow.PRESENT_COLOR);
                    }
                    */
                }
            }
            if(gw.getSquareColor(row,co)== WordleGWindow.CORRECT_COLOR){
                gw.setKeyColor(gw.getSquareLetter(row,co),WordleGWindow.CORRECT_COLOR);
            }
            else if(gw.getSquareColor(row,co)== WordleGWindow.PRESENT_COLOR){
                if(gw.getKeyColor(gw.getSquareLetter(row,co)) == WordleGWindow.CORRECT_COLOR){
                    
                }
                else{
                    gw.setKeyColor(gw.getSquareLetter(row,co), WordleGWindow.PRESENT_COLOR);
                }
            }
            else{
                if(gw.getKeyColor(gw.getSquareLetter(row,co)) == WordleGWindow.CORRECT_COLOR || gw.getKeyColor(gw.getSquareLetter(row,co)) == WordleGWindow.PRESENT_COLOR){
                    
                }
                else{
                    gw.setKeyColor(gw.getSquareLetter(row,co), WordleGWindow.MISSING_COLOR);
                }
            }

        }
        
        /*
            for(int c = 0;c < WordleGWindow.N_COLS;c++){
                if(gw.getSquareLetter(row,c).equalsIgnoreCase(Word.substring(c,c+1))){
                    gw.setSquareColor(row,c, WordleGWindow.CORRECT_COLOR);
                    gw.setKeyColor(gw.getSquareLetter(row,c).toUpperCase(),WordleGWindow.CORRECT_COLOR);
                }
                else if(Word.toUpperCase().indexOf(gw.getSquareLetter(row,c))!= -1){
                    String temp1 = Word.substring(Word.toUpperCase().indexOf(gw.getSquareLetter(row,c)));
                    String temp2 ="";
                    int i =0;
                    if(gw.getKeyColor(gw.getSquareLetter(row,c).toUpperCase()) == WordleGWindow.CORRECT_COLOR){
                        break;
                    }
                    else{
                        gw.setKeyColor(gw.getSquareLetter(row,c).toUpperCase(),WordleGWindow.MISSING_COLOR);
                    }
                    while(temp1.toUpperCase().indexOf(gw.getSquareLetter(row,c).toUpperCase())!= -1){
                        i = temp1.toUpperCase().indexOf(gw.getSquareLetter(row,c));
                        gw.setSquareColor(row,i, WordleGWindow.PRESENT_COLOR);
                        temp2 = temp1;
                        temp1 = temp2.substring(Word.toUpperCase().indexOf(gw.getSquareLetter(row,c)));
                    }
                }
                else {
                    gw.setSquareColor(row,c, WordleGWindow.MISSING_COLOR);
                    gw.setKeyColor(gw.getSquareLetter(row,c).toUpperCase(),WordleGWindow.MISSING_COLOR);
                }
            }
            */

        }
        /**\
        private void KeyColors(String s){
            for(int col =0; col< WordleGWindow.N_COLS;col++ ){
                if(gw.getSquareColor(row,col) == WordleGWindow.CORRECT_COLOR){
                    gw.setKeyColor(gw.getSquareLetter(row,col),WordleGWindow.CORRECT_COLOR);
                }
            }
            
        }
        */
    static private void changeWord(){
        Word = random[(int)(Math.random()*WordleDictionary.FIVE_LETTER_WORDS.length+1)];

    }
    static private void increaseRow(){
        if(row != 5 ){   
            row++;
            gw.setCurrentRow(row);
        }
    }
     static String [] random = WordleDictionary.FIVE_LETTER_WORDS;
     static String Word= random[(int)(Math.random()*WordleDictionary.FIVE_LETTER_WORDS.length+1)]; 
     static int row =0;
     static int count=0;

/* Startup code */

    public static void main(String[] args) {
        new Wordle().run();
        System.out.println(Word);
        /*
        gw.setSquareLetter(5,0,Word.substring(0,1).toUpperCase());
        gw.setSquareLetter(5,1,Word.substring(1,2).toUpperCase());
        gw.setSquareLetter(5,2,Word.substring(2,3).toUpperCase());
        gw.setSquareLetter(5,3,Word.substring(3,4).toUpperCase());
        gw.setSquareLetter(5,4,Word.substring(4).toUpperCase());
        */
        

    }

/* Private instance variables */

    private static WordleGWindow gw;

}
