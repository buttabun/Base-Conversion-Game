package model;

import java.util.ArrayList;

/**
 * Standard Quiz is a classic style quiz.
 * 
 * It has a set number of questions generated at the time of 
 * and a score in the form of a percentage of 100
 * 
 * @author Jonathan
 *
 */

public class StandardQuiz extends Quiz {
	
	private int qNum; //Number of questions in this quiz
	private int difficulty;
	
	private ArrayList<Question> quizQuestions;	//Array of questions in the quiz
	
	/**
	 * @param qN	Number of questions
	 * @param difficulty	Difficulty value of quiz
	 */
	public StandardQuiz(int qN, int newDifficulty) {
		
		qNum = qN;
		difficulty = newDifficulty;
		//Set score to zero
		score = 0;
		
		//Initialize quiz max with getQMax
		int qMax = getQMax(difficulty);
		
		//Initialize quizQuestion array
		quizQuestions = new ArrayList<Question>();
		
		//Assign qNum with the value at qNum. (Why? Becasue qNum is global and qN is local.)
		qNum = qN;

		//Fill quiz question array
		for(int i = 0; i < qNum; i++) {
			qBase = getRandomBase();
			
			//TODO: create new questions with custom base and max
			quizQuestions.add(new Question(qBase, qMax, getQPoints()));
		}
	}
	
	public void setDifficulty( int newDifficulty ){
		difficulty = newDifficulty;
	}
	
	public void setQNum( int newQNum ){
		qNum = newQNum;
	}
	
	public int getDifficulty(){
		return difficulty;
	}
	
	public int getQNum(){
		return qNum;
	}
	
	/**
	 * Question points for a standard quiz are determined by dividing 100 by the number of questions 
	 * @return qPoints.	The value of a question scored in points.
	 */
	public double getQPoints() {
		return (double) (100 / qNum);
	}
	
	public ArrayList<Question> getQuizQuestions(){
		return quizQuestions;
	}
}
