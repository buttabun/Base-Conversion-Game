package application;
	
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


/** Main is the class that contains the main screen of the program.
 *  It will initialize the login screen.
 *  
 *
 */
public class Main extends Application {
	private static Stage currentStage;
	
	public static Stage getStage(){
		return currentStage;
	}
	
	/** This overrides the start method to show the login screen.
	 * 
	 */
	@Override
	public void start( Stage primaryStage ) throws IOException {
		currentStage = primaryStage;
		Parent root = FXMLLoader.load( getClass().getResource( "StartMenuView.fxml" ) );
		Scene scene = new Scene( root );
		primaryStage.setTitle( "Main Menu" );
		primaryStage.setScene( scene );
		primaryStage.show();
	}
	
	public static void main( String[] args ) {
		launch( args );
	}
}
