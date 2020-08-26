package toolbox;

import java.io.File;

import contrats.PreConditionException;
import implems.Cell;
import implems.EnvironmentImpl;
import implems.PlayerImpl;
import javafx.animation.TranslateTransition;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import main.RendererV2;

public class ToolBox {
	
	 	public static Image loadImage(String path) {
	    	
	    	return new Image(new File(path).toURI().toString());
	    }
	    
	    public static ImageView loadImageView(String path) {
	    	
	    	ImageView imv = new ImageView(new File(path).toURI().toString());
	    	imv.setFitHeight(600);
	    	imv.setFitWidth(600);
	    	return imv;
	    }
	    
	    public static ImageView loadImageView2(String path) {
	    	
	    	return new ImageView(new File(path).toURI().toString());
	    	
	    }
	    
	    public static ImageView loadImageView3(String path, double posx, double posy) {
	    	
	    	ImageView imv = loadImageView2(path);
	    	imv.setLayoutX(posx);
	    	imv.setLayoutY(posy);	    	
	    	return imv;
	    }
	    
	    public static ImageView loadImageViewMap(String path, int x, int y, int size, int nb) {
	    	
	    	ImageView imv = new ImageView(new File(path).toURI().toString());
	    	imv.setFitHeight(size*nb);
	    	imv.setFitWidth(size*nb);
	    	imv.setLayoutX(y*size*nb);
	    	imv.setLayoutY(x*size*nb);
	    	return imv;
	    }
	    
	    public static Region createToggleButton(String title, double x, double y) {
	    	
	    	ToggleButton tb = new ToggleButton(title);    	
	    	tb.setLayoutX(x);
	    	tb.setLayoutY(y);
	    	return tb;
	    }
	    
	    public static Region createToggleButtonImage(String txt, String path, double x, double y) {
	    	
	    	ImageView imv = loadImageView2(path);
	    	ToggleButton tb = new ToggleButton(txt, imv);
	    	tb.setLayoutX(x);
	    	tb.setLayoutY(y);
	    	tb.setPadding(new Insets(imv.getFitHeight()));
	    	return tb;
	    }
	    
	    public static Region createVolumeControls(MediaPlayer player, int posx, int posy) {
	    	
	    	final Slider volumeSlider = new Slider(0, 1, 0);
	    	volumeSlider.setOrientation(Orientation.VERTICAL);
	    	volumeSlider.setLayoutX(posx);
	    	volumeSlider.setLayoutY(posy);
	    	
	    	player.volumeProperty().bindBidirectional(volumeSlider.valueProperty());
	    	
	    	return volumeSlider;
	    }
	    
	    public static Rectangle createZoneRect(int posx, int posy) {
	    	
	    	Rectangle zone = new Rectangle();
	    	zone.setX(posx);
	    	zone.setY(posy);
	    	
	    	return zone;
	    }
	    
	    
	    public static Rectangle createZoneRect2(double l, double h, int posx, int posy) {
	    	
	    	Rectangle zone = createZoneRect(posx, posy);	    
	    	zone.setWidth(l);
	    	zone.setHeight(h);
	    	
	    	return zone;
	    }
	    
	    public static void adjustPos(Group root, Region zone, double posx, double posy) {
	    	
	    	zone.setLayoutX(posx);
	    	zone.setLayoutY(posy);
	    	
	        root.getChildren().add(zone);
	    }	    
	  
	   
	    public static void addControlPanel(Stage stage, Group root, int posx, int posy, PlayerImpl player, RendererV2 envL) {	    
	    	
	    	ImageView imv1 = ToolBox.loadImageView2("graphics&sounds/controls/turnL.gif");
	        ToggleButton turnL = (ToggleButton) ToolBox.createToggleButtonImage("", "graphics&sounds/controls/turnL.gif", posx, posy);
	        double wTL = imv1.getImage().getWidth(); 
	        //System.out.println(wTL);
	        double hTL = imv1.getImage().getHeight();
	         
	        ImageView imv2 = ToolBox.loadImageView2("graphics&sounds/controls/forward.gif");
	        ToggleButton forward = (ToggleButton) ToolBox.createToggleButtonImage("", "graphics&sounds/controls/forward.gif", posx+wTL, posy);
	        double wF = imv2.getImage().getWidth();
	        
	        ToggleButton strafeR = (ToggleButton) ToolBox.createToggleButtonImage("", "graphics&sounds/controls/strafeR.gif", posx+wTL+wF, posy+hTL);
	        ToggleButton strafeL = (ToggleButton) ToolBox.createToggleButtonImage("", "graphics&sounds/controls/strafeL.gif", posx, posy+hTL);        
	        ToggleButton backward = (ToggleButton) ToolBox.createToggleButtonImage("", "graphics&sounds/controls/backward.gif", posx+wTL, posy+hTL);        
	        ToggleButton turnR = (ToggleButton) ToolBox.createToggleButtonImage("", "graphics&sounds/controls/turnR.gif", posx+wTL+wF, posy);
	        
	        
	        strafeL.setOnAction(event -> {
	        	System.out.println("Going To The Left !");
	        	try {
					player.strafeL();
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        	try {
					envL.updateViewPlayerDungeon(stage, player, null);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        });
	        
	        backward.setOnAction(event -> {
	        	System.out.println("Going Backward !");
	        	try {
					player.backward();
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        	try {
					envL.updateViewPlayerDungeon(stage, player, null);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        });
	        
	        strafeR.setOnAction(event -> {
	        	System.out.println("Going To The Right !");
	        	try {
					player.strafeR();
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        	try {
					envL.updateViewPlayerDungeon(stage, player, null);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        });
	        
	        turnL.setOnAction(event -> {
	        	System.out.println("Turning To The Left !");
	        	player.turnL();
	        	try {
					envL.updateViewPlayerDungeon(stage, player, null);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        });
	        
	        forward.setOnAction(event -> {
	        	System.out.println("Going Forward !");
	        	try {
					player.forward();
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        	try {
					envL.updateViewPlayerDungeon(stage, player, null);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        	
	        });
	        
	        turnR.setOnAction(event -> {
	        	System.out.println("Turning To The Right !");
	        	player.turnR();
	        	try {
					envL.updateViewPlayerDungeon(stage, player, null);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        });
	        
	        root.getChildren().addAll(strafeL, backward, strafeR, turnL, forward, turnR);
	     
	    }
	  
	    
	    
	

}
