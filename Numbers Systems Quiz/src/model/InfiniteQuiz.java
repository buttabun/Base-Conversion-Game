package model;

/**
 * Infinite Quiz is an endless quiz mode that goes until the user decides to stop.
 * 
 * It's questions will be generated one at a time as the user progresses through them.
 * The score is an arbitrary integer based on question difficulty and has no limit.
 * 
 * @author Jonathan
 *
 */
public class InfiniteQuiz extends Quiz{
	
	int difficulty;
	
	public InfiniteQuiz(int qDifficulty) {
		difficulty = qDifficulty;
		
		score = 0;
		
		int qMax = getQMax(difficulty);	
	}
	
	/**
	 * Generates a new question for an infinite quiz.
	 * 
	 * @return q	returns the new Question
	 */
	public Question nextQuestion() {
		qBase = getRandomBase();
		
		//TODO: create new questions with custom base and max
		Question q = new Question(qBase, qMax, getQPoints());
		
		return q;
	}
	
	/**
	 * Returns the points a question is worth.
	 * For infinite quizzes this is done by multiplying the difficulty by 5.
	 * 
	 * @return questionPoints	The point value of an infinite quiz question
	 */
	public double getQPoints() {
		return difficulty * 5;
	}
}
