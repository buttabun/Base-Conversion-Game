package controller;

import java.io.IOException;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
//import javafx.scene.control.Slider;

public class SelectionScreenController{
	@FXML
	//private Slider difficultySlider;
	
	private Label quizDescription;
	
	private int quizType = -1;
	
	public void exitButtonPressed( ActionEvent event ) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation( getClass().getResource( "/application/StartMenuView.fxml") );
		Parent root = loader.load();
		Scene scene = new Scene( root );
		Main.getStage().setTitle( "Main Menu" );
		Main.getStage().setScene( scene );
	}
	
	public void normalQuizButtonPressed( ActionEvent event ) throws IOException{
		quizType = 1;
		String descriptionText = "Test your knowledge with 10 questions.\n\nGet as many numerical conversions correct!";
		quizDescription.setText( descriptionText );
	}
	
	public void infiniteQuizButtonPressed( ActionEvent event ) throws IOException{
		quizType = 0;
		String descriptionText = "Practice numerical conversions infinitely.";
		quizDescription.setText( descriptionText );
	}
	
	public void startButtonPressed( ActionEvent event ) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation( getClass().getResource( "/application/QuizScreenViewer.fxml") );
		Parent root = loader.load();
		Scene scene = new Scene( root );
		if( quizType == 1 ){
			QuizScreenController controller = loader.getController();
			controller.initializeQuizData( quizType, 10, 1 );
			Main.getStage().setTitle( "Normal Quiz Mode" );
			Main.getStage().setScene( scene );
		}
		if( quizType == 0 ){
			Main.getStage().setTitle( "Infinite Quiz Mode" );
			Main.getStage().setScene( scene );
		}
		if( quizType == -1 ){
			String descriptionText = "Please select a quiz type before starting!";
			quizDescription.setText( descriptionText );
		}
	}
}