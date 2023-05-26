package model;

/**
 * The parent class for all quiz objects. 
 * Holds basic info relevant to all quizzes regardless of type.
 */
public abstract class Quiz {
	double score; //Quiz score
	int qMax; //Maximum value for quiz questions
	int qBase; //Number base of questions
	
	abstract double getQPoints();
	
	/**
	 * Returns the quiz score
	 * @return score. Quiz score.
	 */
	public double getScore() {
		return score;
	}
	
	/**
	 * Triggered by a question being answered correctly.
	 * Adds the point value question to the quiz score.
	 * 
	 *  @param q	Question
	 */
	public void addScore(Question q) {
		score += q.getPoints();
	}
	
	/**
	 * Determines the Question maximum value.
	 * It will be a base 2 integer determined by the difficulty value selected by the user.
	 * 
	 * While the difficulty value could be anything, it is intended to be a number from 1 to 10.
	 * This gives us a question range of 16 to 2048. Feel free to mess with that range if it ends up feeling restrictive.
	 * 
	 * Formula: questionMax = 8 * (2 ^ difficulty)
	 *  
	 *  @param difficulty	Question difficulty
	 *  @return	qMax	Maximum value a question can have
	 *  
	 */
	public int getQMax(int difficulty) {
		return (int) (8 * Math.pow(2, difficulty));
	}
	
	/**
	 * Gets a random number base from an hand approved list
	 * I originally wanted to have a larger list of number bases but it's probably better to have a 
	 * smaller list of number bases that actually matter. (Seriously who cares about base 6?)
	 * 
	 * @return randomBase	Returns a random base value form an approved list
	 */
	public int getRandomBase() {
		
		//Random switch case value
		int randSCase; 
		
		//Assigns a random value from 1 to 3 to this random case
		//TODO: Check my work here. Idk if I generated the random values in the right range. Double check it's generating values from 1 to 3
		randSCase = (int)(Math.random() * 3) + 1;
		
		//Return a number base based on the random switch case value.
		//Feel free to add new cases if I forgot something. 
		//	Just be sure to adjust the random case generator too if you end up doing that. 
		switch(randSCase)
		{
			case 1:
				return 2;
			case 2: 
				return 8;
			case 3:
				return 16;
			default:
				return 10;
		}
	}
}

