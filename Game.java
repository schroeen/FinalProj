import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;



public class Game implements ActionListener {
  JLabel welcome;
  JTextField name;
  JLabel question;
  JButton selectOne;
  JButton selectTwo;
  JButton selectThree;
  JButton selectFour;
  JLabel yesNo;
  JLabel score;
  JButton nextQuestion;
  String insert;

  
  
  //Creating Question List ArrayList
  ArrayList<Question> questionList = new ArrayList<Question>();

  //Setting Variables to Defaults or Zero
  String questionText = "";
  String answerOneText = "";
  String answerTwoText = "";
  String answerThreeText = "";
  String answerFourText = "";
  int correct = 0;
  int points = 0;
  int finalPoints = 0;
  int incorrect = 0;

  Game() {
  
    JFrame frame = new JFrame("Group 9's Game");
    frame.setLayout(new FlowLayout());
    frame.setSize(300, 180);
    JLabel welcome = new JLabel("Welcome to the game!");
    

    //FileReader
    try {
      FileReader myFile;
      myFile = new FileReader("trivia.txt");
      BufferedReader reader = new BufferedReader(myFile);

      while(reader.ready()) {
        questionText = reader.readLine();
        answerOneText = reader.readLine();
        answerTwoText = reader.readLine();
        answerThreeText = reader.readLine();
        answerFourText = reader.readLine();
        correct = Integer.parseInt(reader.readLine());
        points = Integer.parseInt(reader.readLine());

        //Creating Question Object
        Question theQuestion = new Question(questionText, answerOneText, answerTwoText, answerThreeText, answerFourText, correct, points);
        //Adding Question Objects to ArrayList
        questionList.add(theQuestion);
      }
      reader.close();
    }
    //Catch Block - Reader
    catch (IOException exception) {
      System.out.println("An error occurred: " + exception);
    }
     
    //Populating Labels and Buttons with ArrayList Data
    question = new JLabel(questionList.get(0).getQuestionText());
    selectOne = new JButton(questionList.get(0).getAnswerOneText());
    //selectOne = new JButton("");
    selectTwo = new JButton(questionList.get(0).getAnswerTwoText());
    //selectTwo = new JButton("");
    selectThree = new JButton(questionList.get(0).getAnswerThreeText());
    //selectThree = new JButton("");
    selectFour = new JButton(questionList.get(0).getAnswerFourText());
    //selectFour = new JButton("");
    selectOne.addActionListener(this);
    selectTwo.addActionListener(this);
    selectThree.addActionListener(this);
    selectFour.addActionListener(this);


    score = new JLabel("");
    yesNo = new JLabel("");
    nextQuestion = new JButton("Next Question");
    nextQuestion.setForeground(Color.BLUE);

    nextQuestion.addActionListener(this);

    //Adding objects to frame and making the GUI visible
    frame.add(welcome);
    frame.add(question);
    frame.add(selectOne);
    frame.add(selectTwo);
    frame.add(selectThree);
    frame.add(selectFour);
    frame.add(score);
    
    frame.add(yesNo);
    frame.add(nextQuestion);
    frame.setVisible(true);

  }

  // Making GUI functional
  public void actionPerformed(ActionEvent ae) {
    if(question.getText().equals(questionList.get(0).getQuestionText())){
      if(ae.getActionCommand().equals(questionList.get(0).getAnswerTwoText())){
        points = incorrect+(questionList.get(0).getPoints());
        yesNo.setText("");
        score.setText("Correct! Your score is: "+points);
        selectTwo.setEnabled(false);
        
      }
      else if(ae.getActionCommand().equals("Next Question")){
        score.setText("");
        question.setText(questionList.get(1).getQuestionText());
        selectOne.setText(questionList.get(1).getAnswerOneText());
        selectTwo.setText(questionList.get(1).getAnswerTwoText());
        selectThree.setText(questionList.get(1).getAnswerThreeText());
        selectFour.setText(questionList.get(1).getAnswerFourText());
        selectTwo.setEnabled(true);
        
      }
      else {
        yesNo.setText("Wrong Answer! -2 Points");
        score.setText("");
        incorrect = -2;
        
      }
    }
    else if(question.getText().equals(questionList.get(1).getQuestionText())){
      if(ae.getActionCommand().equals(questionList.get(1).getAnswerOneText())){
        yesNo.setText("");
        selectOne.setEnabled(false);
        points = points+(questionList.get(1).getPoints());
        score.setText("Correct! Your score is: "+points);
      }
      else if(ae.getActionCommand().equals("Next Question")){
        score.setText("");
        question.setText(questionList.get(2).getQuestionText());
        selectOne.setText(questionList.get(2).getAnswerOneText());
        selectTwo.setText(questionList.get(2).getAnswerTwoText());
        selectThree.setText(questionList.get(2).getAnswerThreeText());
        selectFour.setText(questionList.get(2).getAnswerFourText());
        selectOne.setEnabled(true);
      }
      else {
        yesNo.setText("Wrong Answer! -2 Points");
        score.setText("");
        points = points-2;
      }
    }
    else if(question.getText().equals(questionList.get(2).getQuestionText())){
      if(ae.getActionCommand().equals(questionList.get(2).getAnswerOneText())){
        yesNo.setText("");
        points = points+(questionList.get(2).getPoints());
        //points = points+points;
        score.setText("Correct! Your score is: "+points);
        selectOne.setEnabled(false);
      }
      else if(ae.getActionCommand().equals("Next Question")){
        score.setText("");
        question.setText(questionList.get(3).getQuestionText());
        selectOne.setText(questionList.get(3).getAnswerOneText());
        selectTwo.setText(questionList.get(3).getAnswerTwoText());
        selectThree.setText(questionList.get(3).getAnswerThreeText());
        selectFour.setText(questionList.get(3).getAnswerFourText());
        selectOne.setEnabled(true);
      }
      else {
        yesNo.setText("Wrong Answer! -2 Points");
        score.setText("");
        points = points-2;
      }
    }
    else if(question.getText().equals(questionList.get(3).getQuestionText())){
      if(ae.getActionCommand().equals(questionList.get(3).getAnswerThreeText())){
        yesNo.setText("");
        points = points+(questionList.get(3).getPoints());
        score.setText("Correct! Your score is: "+points);
        selectThree.setEnabled(false);
      }
      else if(ae.getActionCommand().equals("Next Question")){
        score.setText("");
        question.setText(questionList.get(4).getQuestionText());
        selectOne.setText(questionList.get(4).getAnswerOneText());
        selectTwo.setText(questionList.get(4).getAnswerTwoText());
        selectThree.setText(questionList.get(4).getAnswerThreeText());
        selectFour.setText(questionList.get(4).getAnswerFourText());
        selectThree.setEnabled(true);
      }
      else {
        yesNo.setText("Wrong Answer! -2 Points");
        score.setText("");
        points = points-2;
      }
    }
    else if(question.getText().equals(questionList.get(4).getQuestionText())){
      if(ae.getActionCommand().equals(questionList.get(4).getAnswerFourText())){
        yesNo.setText("");
        points = points+(questionList.get(4).getPoints());
        finalPoints = points;
        score.setText("Correct! Your score is: "+points);
        selectFour.setEnabled(false);
      
        try {
          FileWriter toWriteFile;
          toWriteFile = new FileWriter("scores.txt");
          BufferedWriter output = new BufferedWriter(toWriteFile);

          output.write(Integer.toString(finalPoints));

          output.close();
        }
    
        catch (IOException exception) {
          System.out.println("An error occurred: " + exception);
        }
      }
      
      else if(ae.getActionCommand().equals("Next Question")){
        score.setText("Your Final Score is: " +points);
        score.setForeground(Color.GREEN);
        yesNo.setText("Thanks for playing! The game is over");
      }
      else {
        yesNo.setText("Wrong Answer! -2 Points");
        score.setText("");
        points = points-2;
      } 
    }
  }
}
