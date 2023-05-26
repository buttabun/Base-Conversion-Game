package controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Quiz;
import model.StandardQuiz;
import model.InfiniteQuiz;
import model.Question;

public class QuizScreenController{
	private StandardQuiz currentStandardQuiz;
	private int currentQuestion = 0;
	private int currentQuizType;
	
	@FXML
	private Label quizQuestionDisplay;
	@FXML
	private TextField answerField;
	
	public int getQuizType(){
		return currentQuizType;
	}
	
	public void initializeQuizData( int quizType, int qNum, int difficulty ) throws IOException{
		switch( quizType ){
		case 1: //Normal Quiz
			currentQuizType = 1;
			currentStandardQuiz = new StandardQuiz( qNum, difficulty );
			quizQuestionDisplay.setText( currentStandardQuiz.getQuizQuestions().get( 0 ).toString() );
			break;
		case 0: //TODO: Infinite Quiz
			break;
		}
	}
	
	public void updateQuizData( Quiz quiz, int quizType ) throws IOException{
		quiz = currentStandardQuiz;
		switch( quizType ){
		case 1: //Normal Quiz
			quizQuestionDisplay.setText( currentStandardQuiz.getQuizQuestions().get( currentQuestion ).toString() );
			break;
		case 0: //TODO: Infinite Quiz
			break;
		}
	}
	
	public void submitButtonPressed( ActionEvent event ) throws IOException{
		String answer = answerField.getText();
		int quizType = currentQuizType;
		switch( quizType ){
		case 1: //Normal Quiz
			if( currentStandardQuiz.getQuizQuestions().get( currentQuestion ).checkAnswer( answer ) == true ){
				answerField.setText( "" );
				currentStandardQuiz.addScore( currentStandardQuiz.getQuizQuestions().get( currentQuestion ) );
			}
			else{
				answerField.setText( "" );
			}
			currentQuestion++;
			//while there are still questions left on the quiz, keep showing more questions
			if( currentQuestion < currentStandardQuiz.getQNum() ){
				updateQuizData( currentStandardQuiz, quizType );
			}
			else{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( getClass().getResource( "/application/FinishedScreenView.fxml") );
				Parent root = loader.load();
				Scene scene = new Scene( root );
				Main.getStage().setScene( scene );
				FinishedScreenController controller = loader.getController();
				controller.getStandardQuizResults( currentStandardQuiz );
			}
			break;
		case 0: //TODO: Infinite Quiz
			break;
		}
	}
	
	public void skipButtonPressed( ActionEvent event ) throws IOException{
		int quizType = currentQuizType;
		switch( quizType ){
		case 1: //Normal Quiz
			answerField.setText( "" );
			currentQuestion++;
			//while there are still questions left on the quiz, keep showing more questions
			if( currentQuestion < currentStandardQuiz.getQNum() ){
				updateQuizData( currentStandardQuiz, quizType );
			}
			else{
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation( getClass().getResource( "/application/FinishedScreenView.fxml") );
				Parent root = loader.load();
				Scene scene = new Scene( root );
				Main.getStage().setScene( scene );
				FinishedScreenController controller = loader.getController();
				controller.getStandardQuizResults( currentStandardQuiz );
			}
			break;
		case 0: //TODO:Infinite Quiz
			break;
		}
	}
	
	public void quitButtonPressed( ActionEvent event ) throws IOException{
		int quizType = currentQuizType;
		switch( quizType ){
		case 1: //Normal Quiz
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation( getClass().getResource( "/application/FinishedScreenView.fxml") );
			Parent root = loader.load();
			Scene scene = new Scene( root );
			Main.getStage().setScene( scene );
			FinishedScreenController controller = loader.getController();
			controller.getStandardQuizResults( currentStandardQuiz );
		}
	}
	
	public void exitButtonPressed( ActionEvent event ) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation( getClass().getResource( "/application/SelectionScreenView.fxml") );
		Parent root = loader.load();
		Scene scene = new Scene( root );
		Main.getStage().setTitle( "Quiz Selection Screen" );
		Main.getStage().setScene( scene );
	}
	
}