/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
    private final String FILE_PREFIX = "./src/";
    /**Array of questions to be asked*/
    private ArrayList<Question> questions;
    /**Remembers current question index for use with getNextQuestion()*/
    private int currentIndex;
    
    /**
     * Creates a new TriviaGame, defaulting to the file ./default.txt
     */
    public TriviaGame(){
        currentIndex = 0;
        questions = new ArrayList<Question>();
        Scanner sc = new Scanner("");
        try {
            sc = new Scanner(new FileReader(FILE_PREFIX+"default.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File |"+"default.txt"+"| not found in |"+FILE_PREFIX+"|");
            System.exit(1);
        }
        sc.useDelimiter("@");
        while(sc.hasNext()){
            Scanner questionParser = new Scanner(sc.next());
            questionParser.useDelimiter(" #");
            try{
                String q = questionParser.next();
                String c = questionParser.next();
                String a1 = questionParser.next();
                String a2 = questionParser.next();
                String a3 = questionParser.next();
                questions.add(new Question(q,c,a1,a2,a3));
            }
            catch(NoSuchElementException e){
                System.out.println("Not enough arguments in file or incorrect format\n"+
                        "Correct format is: @[question] #[correct answer]"+
                        " #[incorrect answer 1] #[incorrect answer 2] #[incorrect answer 3]");
                System.exit(1);
            }
        }
    }
    
    /**
     * Creates a new TriviaGame based on file given
     * @param file file to read from
     */
    public TriviaGame(String file){
        currentIndex = 0;
        questions = new ArrayList<Question>();
        Scanner sc = new Scanner("");
        try {
            sc = new Scanner(new FileReader(FILE_PREFIX+file));
        } catch (FileNotFoundException ex) {
            System.out.println("File |"+file+"| not found in |"+FILE_PREFIX+"|");
            System.exit(1);
        }
        sc.useDelimiter("@");
        while(sc.hasNext()){
            Scanner questionParser = new Scanner(sc.next());
            questionParser.useDelimiter(" #");
            try{
                String q = questionParser.next();
                String c = questionParser.next();
                String a1 = questionParser.next();
                String a2 = questionParser.next();
                String a3 = questionParser.next();
                questions.add(new Question(q,c,a1,a2,a3));
            }
            catch(NoSuchElementException e){
                System.out.println("Not enough arguments in file or incorrect format\n"+
                        "Correct format is: @[question] #[correct answer]"+
                        " #[incorrect answer 1] #[incorrect answer 2] #[incorrect answer 3]");
                System.exit(1);
            }
        }
    }
    
    /**
     * @return true if there is another question to get
     */
    public boolean hasNextQuestion(){
        return currentIndex != questions.size();
    }
    
    /**
     * @return next Question in questions
     */
    public Question getNextQuestion(){
        currentIndex++;
        return questions.get(currentIndex-1);
    }
    
    /**
     * Returns true if answer is correct, otherwise returns false
     * @param q Question to check answer of
     * @param ind index of answer to check
     * @return true if correct, false otherwise
     */
    public boolean checkAnswer(Question q, int ind){
        if(q.checkAnswer(ind)){
            return true;
        }
        return false;
    }
    
    /**
     * For testing purposes only -- Runs game in command line.
     * @param args Unused
     */
    public static void main(String[] args){
        Gui gu = new Gui();
        TriviaGame tg = new TriviaGame();
        while(tg.hasNextQuestion()){
            Question q = tg.getNextQuestion();
            gu.setTrivia(q.getBody(), q.getPossibleAnswers());
        }
    }
}