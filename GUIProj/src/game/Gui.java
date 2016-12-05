
package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Gui {
    JPanel buttons, panels, fileManage;
    JFrame frame;
    JLabel Question,Correct;
    Button create, load;
    Button[] Answers;
    int index,numCor,numAnswer;
    boolean Fin;

    Gui(){
        GridLayout manage = new GridLayout(1,4);
        index = 0;
        Fin = false;
        numCor = 0;

        panels = new JPanel(new GridLayout(2,2));
        fileManage = new JPanel(new GridLayout(1,2));
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
                }
        });
        Answers[1] = new Button("Answer 2");
        Answers[1].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                        index = 1;
                        Fin = true;
                }
        });
        Answers[2] = new Button("Answer 3");
        Answers[2].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                        index = 2;
                        Fin = true;
                }
        });
        Answers[3] = new Button("Answer 4");
        Answers[3].addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e){
                        index = 3;
                        Fin = true;
                }
        });

        create = new Button("Create a question");
        create.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		index = -2;
        		Fin = true;
        	}
        });
        
        load = new Button("Load a trivia set");
        load.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		index = -3;
        		Fin = true;
        	}
        });

        buttons.add(Answers[0]);
        buttons.add(Answers[1]);
        buttons.add(Answers[2]);
        buttons.add(Answers[3]);
        fileManage.add(create);
        fileManage.add(load);

        panels.add(buttons);
        panels.add(fileManage);
        frame.add(Correct,BorderLayout.PAGE_END);
        frame.add(panels,BorderLayout.CENTER);
        frame.add(Question,BorderLayout.PAGE_START);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void setTrivia(String Quest, String[] Ans){
        Question.setText(Quest);
        for(int i=0;i<4;i++){
                Answers[i].setLabel(Ans[i]);
        }
        index = -1;
        Fin = false;
        numAnswer = 0;
    }

    public int done(){
        if(frame == null){
                return -2;
        }
        else{
                return index;
        }
    }

    public boolean check(){
        return Fin;
    }

    
    public String inQuestion(){
    	String question = JOptionPane.showInputDialog("Enter the question");
    	return question;
    }
    
    public String inAnswerWrong(){
    	String answer = JOptionPane.showInputDialog("Enter 1 wrong answer");
    	numAnswer++;
    	if(numAnswer == 3){
    		index = -1;
    		Fin = false;
    	}
    	return answer;
    }
    
    public String inAnswerRight(){
    	String answer = JOptionPane.showInputDialog("Enter the right answer");
    	return answer;
    }
    public void hide(){
    	frame.setVisible(false);
    }
    public void right(){
        numCor++;
        Correct.setText("Amount Correct: "+numCor);
    }
    public void finish(){
    	JOptionPane.showMessageDialog(frame, "Game over...You have "+numCor+" correct");
    	System.exit(0);
    }
    public String load(){
    	String load = JOptionPane.showInputDialog("Load which trivia file?");
    	return load;
    }
    public String getName(){
    	String name = JOptionPane.showInputDialog("Edit which trivia file?");
    	return name;
    }
}