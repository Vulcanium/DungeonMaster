package toolbox;

import javafx.geometry.Pos;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class MenuButton2 extends StackPane{
	private Text text;
	
	public MenuButton2(String name) {
		text = new Text(name);
		text.setFont(text.getFont().font(20));
		text.setFill(Color.BLACK);
		
		Rectangle bg = new Rectangle(250, 30);
		bg.setOpacity(0.6);
		bg.setFill(Color.WHITE);
		bg.setEffect(new GaussianBlur(3.5));
		
		setAlignment(Pos.CENTER_LEFT);	    		
		getChildren().addAll(bg, text);
		
		setOnMouseEntered(event -> {
			bg.setTranslateX(10);
			text.setTranslateX(10);
			bg.setFill(Color.DARKGRAY);
			text.setFill(Color.BLACK);
		});
		
		setOnMouseExited(event -> {
			bg.setTranslateX(0);
			text.setTranslateX(0);
			bg.setFill(Color.WHITE);
			text.setFill(Color.BLACK);
		});	    		
		
		DropShadow drop = new DropShadow(50, Color.WHITE);
		drop.setInput(new Glow());
		
		setOnMousePressed(event -> setEffect(drop));
		setOnMouseReleased(event -> setEffect(null));

	}
}