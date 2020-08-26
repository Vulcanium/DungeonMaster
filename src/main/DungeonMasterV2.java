package main;

import java.io.File;

import contrats.PostConditionException;
import contrats.PreConditionException;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import toolbox.ToolBox;
import toolbox.GameMenu;

public class DungeonMasterV2 extends Application{
	
	private static int longu = 1300;
	private static int haut = 900;
	private static final int STEP = 100000;
	
	private GameMenu gameMenu;

    public static void main(String[] args) {
       launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws PreConditionException, PostConditionException {
    	
       loadFirstStage(primaryStage);
       
    }
    
    public static int getLongu() {return longu;}
    public static int getHaut() {return haut;}
    
    public void loadFirstStage(Stage primaryStage) throws PreConditionException, PostConditionException {
    	
   	 primaryStage.setTitle("DungeonMaster");
        
        Group root = new Group();
        Scene scene = new Scene(root, 600, 550, null);
        
        Media music = new Media( new File("graphics&sounds/Avenged Sevenfold - The Stage.mp3").toURI().toString());
        MediaPlayer player = new MediaPlayer(music);
        
        gameMenu = new GameMenu(primaryStage, root, player);
        
        root.getChildren().add(ToolBox.loadImageView("pics/title.gif")); 
        root.getChildren().add(gameMenu);
        
        primaryStage.getIcons().add(ToolBox.loadImage("pics/title.gif"));
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.show();
  	
   }
    
    
    
    
    
    
    

}
