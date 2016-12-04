/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package game;

import java.util.Random;

/**
 * I pledge my honor that I have abided by the Stevens Honor System
 * -- Matthew Doto
 *
 * @author mdoto
 * @version 1.0.0
 * @since Dec 4, 2016
 */
public class Question {
    /**This is the question body*/
    private String question;
    /**This is an array storing the answers, in random positions*/
    private String[] answers;
    /**Stores the location of the correct answer in answers*/
    private int corAnsPos;
    
    /**
     * Creates a test question. Not for use in regular play.
     */
    public Question(){
        this.question = "Test Question";
        this.answers = new String[]{"N/A","N/A","N/A","N/A"};
        corAnsPos = 0;
    }
    
    /**
     * Creates a new question using the parameters given.
     * @param question the question to be asked
     * @param corAns the correct answer to the question
     * @param incAns1 an incorrect answer
     * @param incAns2 an incorrect answer
     * @param incAns3 an incorrect answer
     */
    public Question(String question, String corAns, String incAns1,
            String incAns2, String incAns3){
        this.question = question;
        this.answers = new String[]{corAns, incAns1, incAns2, incAns3};
        shuffleArray(this.answers);
        int i = 0;
        for(String s:this.answers){
            if(s.equals(corAns)){
                corAnsPos = i;
                break;
            }
            i++;
        }
    }
    
    /**
     * Checks if the answer is correct
     * @param ans answer to check
     * @return true if the answer is correct.
     */
    public boolean checkAnswer(int ans){
        return(ans==corAnsPos);
    }
    
    /**
     * @return the body text of the question
     */
    public String getBody(){
        return question;
    }
    
    /**
     * @return the array of possible answers
     */
    public String[] getPossibleAnswers(){
        return answers;
    }
    
    /**
     * Implementing Fisher–Yates shuffle
     */
    static void shuffleArray(String[] ar)
    {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            String a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}