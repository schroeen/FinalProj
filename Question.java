class Question {
  String questionText;
  String answerOneText;
  String answerTwoText;
  String answerThreeText;
  String answerFourText;
  int correct;
  int points;

  //Constructor
  Question (String aQuestionText, String aAnswerOneText, String aAnswerTwoText, String aAnswerThreeText, String aAnswerFourText, int aCorrect, int aPoints) {
    questionText = aQuestionText;
    answerOneText = aAnswerOneText;
    answerTwoText = aAnswerTwoText;
    answerThreeText = aAnswerThreeText;
    answerFourText = aAnswerFourText;
    correct = aCorrect;
    points = aPoints;
  }

  //Accessor Methods
  String getQuestionText(){
    return questionText;
  }

  String getAnswerOneText(){
    return answerOneText;
  }

  String getAnswerTwoText(){
    return answerTwoText;
  }

  String getAnswerThreeText(){
    return answerThreeText;
  }

  String getAnswerFourText(){
    return answerFourText;
  }

  int getCorrect(){
    return correct;
  }

  int getPoints(){
    return points;
  }

}