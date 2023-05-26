package model;

public class Question {
	private Integer qVal; //Question Value. Base 10 value of question
	private int qBase; //Question Base. The number base of the question.
	private String qAnswer; //The string form of the correct answer	
	
	private double points; //Point value of question for scoring
	
	
	/**
	 * Constructor
	 * 
	 * @param qB. Temp Question Base. Fills the qBase value.
	 * @param qMax. Question Max. Sets the upper limit for the question value.
	 * @param qPoints.	Point value of Question
	 */
	public Question(int qB,int qMax, double qPoints) {	
		//Assign the number base of the question
		qBase = qB;
		
		//Assign a random integer value to the question value (no more than the max value entered)
		qVal = (int)(Math.random() * qMax) + 1;	
		
		//Assign answer value to qAnswer
		qAnswer = getAnswer(10);
		
		//Assign point vlaue
		points = qPoints;
	}
	
	/**
	 * Returns a string with the question value in the proper base.
	 * This is done in a string because bases higher than 10 cannot be done in bases higher than 10.
	 * 
	 * @return A string form of the question value.
	 */
	public String getQuestion() {	
		//Uses Interger.toString to convert the question value (base 10) into the value of any number base (in the form of a string).
		return Integer.toString(qVal, qBase);
	}
	
	/**
	 * Returns a string with the answer value in the proper base.
	 * 
	 * @param aBase. Answer Base - The number base of the answer.
	 * @return A string form of the answer value
	 */
	public String getAnswer(int aBase) {
		return Integer.toString(qVal, aBase);
	}

	/**
	 * Checks the answer of the user to see if it matches the correct answer.
	 * @param userAnswer
	 * @return boolean.	True if answer is correct. False otherwise.
	 */
	public Boolean checkAnswer(String userAnswer) {
		if(qAnswer.equalsIgnoreCase(userAnswer))
		{
			return true;
		}
		
		return false;
	}

	/**
	 * Returns the number of points the question is worth
	 * 
	 * @return points	Point value of the question
	 */
	public double getPoints()  {
		return points;
	}

	/**
	 * Sets the point value for the quiz
	 */
	public void setPoints(int points) {
		this.points = points;
	}
	
	public String toString(){
		String questionString = "";
		switch( qBase ){
		case 16:
			questionString = "Convert hexadecimal " + getQuestion() + " to base 10:";
			break;
		case 8:
			questionString = "Convert octal " + getQuestion() + " to base 10:";
			break;
		case 2:
			questionString = "Convert binary " + getQuestion() + " to base 10:";
			break;
		}
		return questionString;
	}
}