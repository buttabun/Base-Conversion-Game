package controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import model.StandardQuiz;

public class FinishedScreenController{
	
	@FXML
	private Label finalScore;
	
	public void getStandardQuizResults( StandardQuiz quiz ){
		String finalMessage = "";
		finalMessage += "Your Score: " + quiz.getScore() + "\n\n";
		finalMessage += "You got " + ( int )( quiz.getScore() / quiz.getQNum() ) + "/" + quiz.getQNum() + " questions correct.";
		finalScore.setText( finalMessage );
	}
	
	public void tryAgainButtonPressed( ActionEvent event ) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation( getClass().getResource( "/application/QuizScreenViewer.fxml") );
		Parent root = loader.load();
		Scene scene = new Scene( root );
		Main.getStage().setScene( scene );
		QuizScreenController controller = loader.getController();
		if( Main.getStage().getTitle().equals( "Normal Quiz Mode" ) ){
			controller.initializeQuizData( 1, 10, 1 );
			Main.getStage().setScene( scene );
		}
		if( Main.getStage().getTitle().equals( "Infinite Quiz Mode" ) ){
			controller.initializeQuizData( 0, -1, 1 );
			Main.getStage().setScene( scene );
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