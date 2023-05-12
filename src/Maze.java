import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Maze extends Application {
	
	private Game game1;
	private Game game2;
	
	private Label player1Label; 
	private Label player2Label; 
	
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
	
	private TextField p1TextField;
	private TextField p2TextField;
	
	private Button p1ReqHelp;
	private Button p2ReqHelp;
	
	private Button reset;
	
	
	@Override
	public void start(Stage stage) {
		
		game1 = new Game(1);
	    game2 = new Game(2);
		/**
		 * will be the main grid that will contain 
		 * the GUI for player1 and player 2
		 */
		
		Scene scene = null;         
	    GridPane grid = null;   
	      
	    grid = new GridPane();  
	    scene = new Scene(grid);
			
		player1Label = new Label("Player 1");
		player2Label = new Label("Player 2");
		
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
		
		p1TextField = new TextField();
		p1TextField.setEditable(false);
		GridPane.setColumnSpan(p1TextField, 3);
	
		p2TextField = new TextField();
		p2TextField.setEditable(false);
		GridPane.setColumnSpan(p2TextField, 3);
		
		
		p1ReqHelp = new Button("Help!");
		p2ReqHelp = new Button("Help!");
		
		reset = new Button("Reset");
		
		grid.add(player1Label, 1, 0); grid.add(p1up, 1, 1); grid.add(p1right, 2, 2); grid.add(p1down, 1, 3); grid.add(p1left, 0, 2);
		grid.add(p1CollectPart, 0, 4); grid.add(p1CollectTools, 1, 4); grid.add(p1BuildMachine, 2, 4); grid.add(p1TextField, 0, 5);
		grid.add(p1ReqHelp, 1, 6);
	
		grid.add(player2Label, 5, 0); grid.add(p2up, 5, 1); grid.add(p2right, 6, 2); grid.add(p2down, 5, 3); grid.add(p2left, 4, 2);
		grid.add(p2CollectPart, 4, 4); grid.add(p2CollectTools, 5, 4); grid.add(p2BuildMachine, 6, 4); grid.add(p2TextField, 4, 5);
		grid.add(p2ReqHelp, 5, 6);
		
		grid.add(reset, 3, 7);
		
		
		
		
		/**
		 * Reset Button event Handler
		 */
		reset.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				
			try {
				game1.reset();
				game2.reset();
				p1TextField.setText("Game has been reset.");
				p2TextField.setText("Game has been reset.");
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error in Maze>reset");
			}
			
			}
		});
		
		/**
		 * Help Button event Handler
		 */
		p1ReqHelp.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		      String str = game1.getCurrentPlayer().getCurrentRoom().helpMessage();
		      p1TextField.setText(str);
		      
		    }
		});
		p2ReqHelp.setOnAction(new EventHandler<ActionEvent>() {
		    @Override
		    public void handle(ActionEvent event) {
		      String str = game2.getCurrentPlayer().getCurrentRoom().helpMessage(); 
		      p2TextField.setText(str);
		      
		    }
		});
		
		/*
		 * UP button handlers
		 */
		p1up.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p1TextField.setText(game1.getCurrentPlayer().move(Direction.up));
			}
		});
		
		p2up.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p2TextField.setText(game2.getCurrentPlayer().move(Direction.up));
			}
		});
		
		/*
		 * RIGHT button handlers
		 */
		p1right.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p1TextField.setText(game1.getCurrentPlayer().move(Direction.right));
			}
		});
		
		p2right.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p2TextField.setText(game2.getCurrentPlayer().move(Direction.right));
			}
		});
		
		/*
		 * Down Button Handlers 
		 */
		p1down.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p1TextField.setText(game1.getCurrentPlayer().move(Direction.down));
			}
		});
		p2down.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p2TextField.setText(game2.getCurrentPlayer().move(Direction.down));
			}
		});
		
		/*
		 * Left button Handlers
		 */
		p1left.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p1TextField.setText(game1.getCurrentPlayer().move(Direction.left));
			}
		});
		p2left.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p2TextField.setText(game2.getCurrentPlayer().move(Direction.left));
			}
		});
		
		/*
		 * Handlers for collect tools/machine part/build machine
		 */
		
		p1CollectPart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				
				p1TextField.setText(game1.getCurrentPlayer().collectPart());
			}
		});
		p2CollectPart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p2TextField.setText(game2.getCurrentPlayer().collectPart());
			}
		});
		
		p1CollectTools.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p1TextField.setText(game1.getCurrentPlayer().collectTools());
			}
		});
		p2CollectTools.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p2TextField.setText(game2.getCurrentPlayer().collectTools());
			}
		});
		
		
		p1BuildMachine.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p1TextField.setText(game1.getCurrentPlayer().build());
			}
		});
		p2BuildMachine.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				p2TextField.setText(game2.getCurrentPlayer().build());
			}
		});
		
		
		stage.setScene(scene);    // Set window's scene  
	    stage.setTitle("Maze Game"); // Set window's title
	    stage.show();             // Display window
	}
	
	public static void main(String [] args) throws Exception {
		launch(args); // Launch application
	}

	
}