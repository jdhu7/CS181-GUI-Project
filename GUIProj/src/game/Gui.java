package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui {
    JPanel buttons;
    JFrame frame;
    JLabel Question,Correct;
    Button[] Answers;
    int index,numCor;
    boolean Fin;
/**
 * constructor of the gui
 */
    Gui(){
        GridLayout manage = new GridLayout(1,4);
        index = 0;
        Fin = false;
        numCor = 0;

        buttons = new JPanel(manage);
        frame = new JFrame();
        frame.setSize(400,200);
        frame.setLayout(new BorderLayout());

        Question = new JLabel("Questlove is in the house");
        Question.setHorizontalAlignment(JLabel.CENTER);

        Correct = new JLabel("Amount Correct: "+ numCor);
        Correct.setHorizontalAlignment(JLabel.CENTER);

        Answers = new Button[4];
        Answers[0] = new Button("Answer 1");
        Answers[0].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                        index = 0;
                        Fin = true;
                        System.out.println("index is "+index);
                }
        });
        Answers[1] = new Button("Answer 2");
        Answers[1].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                        index = 1;
                        Fin = true;
                        System.out.println("index is "+index);
                }
        });
        Answers[2] = new Button("Answer 3");
        Answers[2].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                        index = 2;
                        Fin = true;
                        System.out.println("index is "+index);
                }
        });
        Answers[3] = new Button("Answer 4");
        Answers[3].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                        index = 3;
                        Fin = true;
                        System.out.println("index is "+index);
                }
        });



        buttons.add(Answers[0]);
        buttons.add(Answers[1]);
        buttons.add(Answers[2]);
        buttons.add(Answers[3]);
        frame.add(Correct,BorderLayout.PAGE_END);
        frame.add(buttons,BorderLayout.CENTER);
        frame.add(Question,BorderLayout.PAGE_START);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    /**
     * sets the labels and the buttons
     * @param Quest The question
     * @param Ans Array of answers
     */
    public void setTrivia(String Quest, String[] Ans){
        Question.setText(Quest);
        for(int i=0;i<4;i++){
                Answers[i].setLabel(Ans[i]);
        }
        index = -1;
        Fin = false;
    }
/**
 * 
 * @return check if a button has been pressed, returns the index of the button
 */
    public int done(){
        if(frame == null){
                return -2;
        }
        else{
                return index;
        }
    }
/**
 * 
 * @return  boolean if a button has been pressed
 */
    public boolean check(){
        return Fin;
    }
/**
 *  when the user has gotten a question right
 */
    public void right(){
        numCor++;
        Correct.setText("Amount Correct: "+numCor);
    }
}