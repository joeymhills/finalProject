import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Maze extends Application {
	
	
	public void start(Stage stage) {
		
		/**
		 * will be the main grid that will contain 
		 * the GUI for player1 and player 2
		 */
		GridPane mainGrid = new GridPane();
		
		Button up = new Button("up");
		
		mainGrid.add(up, 0, 1);
		
		Scene scene = new Scene(mainGrid, 300, 300);
	    stage.setTitle("Maze");
	    stage.setScene(scene);
	    stage.show();
		
		}
	   
	public static void main(String[] args) {
	  
		launch(args);
	   
	}
		
}
	
	

	