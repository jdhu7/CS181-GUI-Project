/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * I pledge my honor that I have abided by the Stevens Honor System
 * -- Matthew Doto
 *
 * @author mdoto
 * @version 1.0.0
 * @since Dec 4, 2016
 */
public class TriviaGame {
    /**Origin folder in which to look for question files*/
    private final String FILE_PREFIX = "./";
    /**Array of questions to be asked*/
    private Question[] questions;
    /**Remembers current question index for use with getNextQuestion()*/
    private int currentIndex;
    
    /**
     * Creates a new TriviaGame, defaulting to the file ./default.txt
     */
    public TriviaGame(){
        
    }
    
    /**
     * Creates a new TriviaGame based on file given
     * @param file file to read from
     */
    public TriviaGame(String file){
        currentIndex = 0;
        Scanner sc;
        try {
            sc = new Scanner(new FileReader(FILE_PREFIX+file));
        } catch (FileNotFoundException ex) {
            System.out.println("File |"+file+"| not found in |"+FILE_PREFIX+"|");
            System.exit(1);
        }
        
    }
    
    /**
     * For testing purposes only -- Runs game in command line.
     * @param args Unused
     */
    public static void main(String[] args){
        Question q = new Question("What is food?","food","bricks","AC","cement");
    }
}