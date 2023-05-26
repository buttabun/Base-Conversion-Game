package controller;

import java.io.IOException;
import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StartMenuController {
	public void goButtonPressed( ActionEvent event ) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation( getClass().getResource( "/application/SelectionScreenView.fxml") );
		Parent root = loader.load();
		Scene scene = new Scene( root );
		Main.getStage().setTitle( "Quiz Selection Screen" );
		Main.getStage().setScene( scene );
	}
	
	public void exitButtonPressed( ActionEvent event ) throws IOException{
		Main.getStage().close();
	}
}