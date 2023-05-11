import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Maze extends Application {
	
	private Label player1; 
	private Label player2; 
	
	private Button p1up;
	private Button p2up;
	private Button p1right;
	private Button p2right;
	private Button p1down;
	private Button p2down;
	private Button p1left;
	private Button p2left;
	
	private Button p1CollectPart;
	private Button p1CollectTools;
	private Button p1BuildMachine;
	
	private Button p2CollectPart;
	private Button p2CollectTools;
	private Button p2BuildMachine;
	
	private TextField p1HelpMessage;
	private TextField p2HelpMessage;
	
	private Button p1ReqHelp;
	private Button p2ReqHelp;
	
	private Button reset;
	
	
	@Override
	public void start(Stage stage) {
		
		/**
		 * will be the main grid that will contain 
		 * the GUI for player1 and player 2
		 */
		
		Scene scene = null;         
	    GridPane grid = null;   
	      
	    grid = new GridPane();  
	    scene = new Scene(grid);
			
		player1 = new Label("Player 1");
		player2 = new Label("Player 2");
		
		p1up = new Button("Up");
		p2up = new Button("Up");
		
		p1right = new Button("Right");
		p2right = new Button("Right");
		
		p1down = new Button("Down");
		p2down = new Button("Down");
		
		p1left = new Button("Left");
		p2left = new Button("Left");
		
		p1CollectPart = new Button("Collect Part");
		p2CollectPart = new Button("Collect Part");
		
		p1CollectTools = new Button("Collect Tools");
		p2CollectTools = new Button("Collect Tools");
		
		p1BuildMachine = new Button("Build Machine");
		p2BuildMachine = new Button("Build Machine");
		
		p1HelpMessage = new TextField();
		p1HelpMessage.setEditable(false);
		GridPane.setColumnSpan(p1HelpMessage, 3);
	
		p2HelpMessage = new TextField();
		p2HelpMessage.setEditable(false);
		GridPane.setColumnSpan(p2HelpMessage, 3);
		
		
		p1ReqHelp = new Button("Help!");
		p2ReqHelp = new Button("Help!");
		
		reset = new Button("Reset");
		
		grid.add(player1, 1, 0); grid.add(p1up, 1, 1); grid.add(p1right, 2, 2); grid.add(p1down, 1, 3); grid.add(p1left, 0, 2);
		grid.add(p1CollectPart, 0, 4); grid.add(p1CollectTools, 1, 4); grid.add(p1BuildMachine, 2, 4); grid.add(p1HelpMessage, 0, 5);
		grid.add(p1ReqHelp, 1, 6);
	
		grid.add(player2, 5, 0); grid.add(p2up, 5, 1); grid.add(p2right, 6, 2); grid.add(p2down, 5, 3); grid.add(p2left, 4, 2);
		grid.add(p2CollectPart, 4, 4); grid.add(p2CollectTools, 5, 4); grid.add(p2BuildMachine, 6, 4); grid.add(p2HelpMessage, 4, 5);
		grid.add(p2ReqHelp, 5, 6);
		
		grid.add(reset, 3, 7);
		
		
		
		stage.setScene(scene);    // Set window's scene  
	    stage.setTitle("Maze Game"); // Set window's title
	    stage.show();             // Display window
	}
	
	public static void main(String [] args) throws Exception {
	    Game game = new Game();
	    game.InitGame();
		launch(args); // Launch application
	}

	
}