package toolbox;

import contrats.PostConditionException;
import contrats.PreConditionException;
import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.RendererV2Map1;
import main.RendererV2Map2;

public class GameMenu extends Parent{
	
	RendererV2Map1 renderer1;
	RendererV2Map2 renderer2;	
	
	public GameMenu(Stage s, Group root, MediaPlayer mp) throws PreConditionException, PostConditionException {
		
		renderer1 = new RendererV2Map1();
		renderer2 = new RendererV2Map2();		
		
		VBox menu0 = new VBox(10);
		VBox menu1 = new VBox(10);
		VBox menu2 = new VBox(10);
		
		menu0.setTranslateX(100);
		menu0.setTranslateY(200);
		
		menu1.setTranslateX(100);
		menu1.setTranslateY(200);
		
		menu2.setTranslateX(100);
		menu2.setTranslateY(200);
		
		final int offset = 400;
		
		menu1.setTranslateX(offset);
		menu2.setTranslateX(offset);		
		
		
		MenuButton btnStart = new MenuButton("NEW GAME");
		btnStart.setOnMouseClicked(event -> {
			
			getChildren().add(menu1);
			
			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
			tt.setToX(menu0.getTranslateX() - offset);
			
			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
			tt1.setToX(menu0.getTranslateX());
			
			tt.play();
			tt1.play();
			
			tt.setOnFinished(event2 -> {
				getChildren().remove(menu0);
			});
			
			
		});
		
		MenuButton btnOptions = new MenuButton("OPTIONS");
		btnOptions.setOnMouseClicked(event -> {
			getChildren().add(menu2);
			
			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
			tt.setToX(menu0.getTranslateX() - offset);
			
			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu2);
			tt1.setToX(menu0.getTranslateX());
			
			tt.play();
			tt1.play();
			
			tt.setOnFinished(event2 -> {
				getChildren().remove(menu0);
			});
		});
		
		MenuButton btnExit = new MenuButton("EXIT");
		btnExit.setOnMouseClicked(event -> {
			System.exit(0);
		});
		
		
		MenuButton btnBack1 = new MenuButton("BACK");
		btnBack1.setOnMouseClicked(event -> {
			getChildren().add(menu0);
			
			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
			tt.setToX(menu1.getTranslateX() + offset);
			
			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
			tt1.setToX(menu1.getTranslateX());
			
			tt.play();
			tt1.play();
			
			tt.setOnFinished(event2 -> {
				getChildren().remove(menu1);
			});
		});
		
		MenuButton btnBack2 = new MenuButton("BACK");
		btnBack2.setOnMouseClicked(event -> {
			getChildren().add(menu0);
			
			TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu2);
			tt.setToX(menu2.getTranslateX() + offset);
			
			TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
			tt1.setToX(menu2.getTranslateX());
			
			tt.play();
			tt1.play();
			
			tt.setOnFinished(event2 -> {
				getChildren().remove(menu2);
			});
		});
		
		MenuButton btnMap1 = new MenuButton("LOAD MAP1 (EASY)");
		
		btnMap1.setOnMouseClicked(event -> {
			renderer1.loadViewEntrancePlayer(s, mp);
		});
		
		MenuButton btnMap2 = new MenuButton("LOAD MAP2 (MEDIUM)");
		
		btnMap2.setOnMouseClicked(event -> {
			renderer2.loadViewEntrancePlayer(s, mp);
		});

		MenuButton btnMap3 = new MenuButton("LOAD MAP3 (UNAVAILABLE)");
		
		
		
		//MenuButton btnSound = new MenuButton("SOUND");
		//MenuButton btnVideo = new MenuButton("VIDEO");
		
		menu0.getChildren().addAll(btnStart, btnOptions, btnExit);
		menu1.getChildren().addAll(btnMap1, btnMap2, btnMap3, btnBack1);
		menu2.getChildren().addAll(btnBack2); //, btnSound, btnVideo);
		
		Rectangle bg = new Rectangle(800, 600);
		bg.setFill(Color.GREY);
		bg.setOpacity(0.4);
		
		getChildren().addAll(bg, menu0);
	}
	
	
	
	
}
