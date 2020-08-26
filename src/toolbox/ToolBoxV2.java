package toolbox;

import java.io.File;

import contrats.PreConditionException;
import implems.Cell;
import implems.Command;
import implems.EngineImpl;
import implems.EnvironmentImpl;
import implems.Option;
import implems.PlayerImpl;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.Slider;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import main.DungeonMaster;
import main.RendererV2;
import main.RendererV2Map1;

public class ToolBoxV2 {
	
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
	  
	   
	    public static void addControlPanel(Stage stage, Group root, int posx, int posy, PlayerImpl player, RendererV2 renderer, MediaPlayer mp, EngineImpl engine) {	
	    	
	    	int x = player.getCol();
			int y = player.getRow();
	    	
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
	        	player.setCom(new Option<Command>(Command.LL));
	        	player.step();
	        	//engine.step();
	        	try {
	        		renderer.updateViewPlayerDungeon(stage, player, mp);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        });
	        
	        backward.setOnAction(event -> {
	        	System.out.println("Going Backward !");
	        	player.setCom(new Option<Command>(Command.BB));
	        	player.step();
	        	//engine.step();
	        	try {
	        		renderer.updateViewPlayerDungeon(stage, player, mp);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        });
	        
	        strafeR.setOnAction(event -> {
	        	System.out.println("Going To The Right !");
	        	player.setCom(new Option<Command>(Command.RR));
	        	player.step();
	        	//engine.step();
	        	try {
	        		renderer.updateViewPlayerDungeon(stage, player, mp);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        });
	        
	        turnL.setOnAction(event -> {
	        	System.out.println("Turning To The Left !");
	        	player.setCom(new Option<Command>(Command.TL));
	        	player.step();
	        	//engine.step();
	        	try {
	        		renderer.updateViewPlayerDungeon(stage, player, mp);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        });
	        
	        forward.setOnAction(event -> {
	        	System.out.println("Going Forward !");
	        	player.setCom(new Option<Command>(Command.FF));
	        	player.step();
	        	//engine.step();
	        	try {
	        		renderer.updateViewPlayerDungeon(stage, player, mp);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        	
	        });
	        
	        turnR.setOnAction(event -> {
	        	System.out.println("Turning To The Right !");
	        	player.setCom(new Option<Command>(Command.TR));
	        	player.step();
	        	//engine.step();
	        	try {
	        		renderer.updateViewPlayerDungeon(stage, player, mp);
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
	        });
	        
	        root.getChildren().addAll(strafeL, backward, strafeR, turnL, forward, turnR);
	        
	        ToggleButton openButton = (ToggleButton) ToolBoxV2.createToggleButtonImage("", "graphics&sounds/graphics_2d/open.jpg", DungeonMaster.getLongu()-360, DungeonMaster.getHaut()-250);
			
			openButton.setOnMouseClicked(event ->{
				
				EnvironmentImpl rendenv = renderer.getEnv();
				
				switch(player.getFace()) {
				
				
					case N:
						
						if(x >= 0 && y+1 >= 0 && x < rendenv.getWidth() && y+1 < rendenv.getHeight()) {
							if(rendenv.getCellNature(x, y+1) == Cell.CHESTC)
								rendenv.openChest(x, y+1);
							if(rendenv.getCellNature(x, y+1) == Cell.OUT) {
								if(player.haveKey())
									rendenv.openDoor(x, y+1);
							}
							else
								rendenv.openDoor(x, y+1);
						}
					try {
						renderer.updateViewPlayerDungeon(stage, player, mp);
					} catch (PreConditionException e) {						
						e.printStackTrace();
					}
						break;
						
					case E:
						
						if(x+1 >= 0 && y >= 0 && x+1 < rendenv.getWidth() && y < rendenv.getHeight()) {
							if(rendenv.getCellNature(x+1, y) == Cell.CHESTC)
								rendenv.openChest(x+1, y);
							else
								rendenv.openDoor(x+1, y);
						}
					try {
						renderer.updateViewPlayerDungeon(stage, player, mp);
					} catch (PreConditionException e) {						
						e.printStackTrace();
					}
						break;
					
					case S:
						
						if(x >= 0 && y-1 >= 0 && x < rendenv.getWidth() && y-1 < rendenv.getHeight()) {
							if(rendenv.getCellNature(x, y-1) == Cell.CHESTC)
								rendenv.openChest(x, y-1);
							if(rendenv.getCellNature(x, y-1) == Cell.OUT) {
								if(player.haveKey())
									rendenv.openDoor(x, y-1);
							}
							else
								rendenv.openDoor(x, y-1);
						}
					try {
						renderer.updateViewPlayerDungeon(stage, player, mp);
					} catch (PreConditionException e) {						
						e.printStackTrace();
					}
						break;
						
					case W:
						if(x-1 >= 0 && y >= 0 && x-1 < rendenv.getWidth() && y+1 < rendenv.getHeight()) {	
							if(rendenv.getCellNature(x-1, y) == Cell.CHESTC)
								rendenv.openChest(x-1, y);
							else
								rendenv.openDoor(x-1, y);
						}
					try {
						renderer.updateViewPlayerDungeon(stage, player, mp);
					} catch (PreConditionException e) {						
						e.printStackTrace();
					}
						break;					
					
				}
				
			});
			
			root.getChildren().add(openButton);
			
			ToggleButton closeButton = (ToggleButton) ToolBoxV2.createToggleButtonImage("", "graphics&sounds/graphics_2d/close.jpg", DungeonMaster.getLongu()-360+64+30, DungeonMaster.getHaut()-250);		
			
			closeButton.setOnMouseClicked(event ->{
				
				EnvironmentImpl rendenv = renderer.getEnv();
				
				switch(player.getFace()) {
				
				
					case N:
						
						if(x >= 0 && y+1 >= 0 && x < rendenv.getWidth() && y+1 < rendenv.getHeight()) {
							if(rendenv.getCellNature(x, y+1) == Cell.CHESTO)
								rendenv.closeChest(x, y+1);
							else
								rendenv.closeDoor(x, y+1);
						}
					try {
						renderer.updateViewPlayerDungeon(stage, player, mp);
					} catch (PreConditionException e) {						
						e.printStackTrace();
					}
						break;
						
					case E:
					
						if(x+1 >= 0 && y >= 0 && x+1 < rendenv.getWidth() && y < rendenv.getHeight()) {
							if(rendenv.getCellNature(x+1, y) == Cell.CHESTO)
								rendenv.closeChest(x+1, y);
							else
								rendenv.closeDoor(x+1, y);
						}
					try {
						renderer.updateViewPlayerDungeon(stage, player, mp);
					} catch (PreConditionException e) {						
						e.printStackTrace();
					}
						break;
					
					case S:
						
						if(x >= 0 && y-1 >= 0 && x < rendenv.getWidth() && y-1 < rendenv.getHeight()) {
							if(rendenv.getCellNature(x, y-1) == Cell.CHESTO)
								rendenv.closeChest(x, y-1);
							else
								rendenv.closeDoor(x, y-1);
						}
					try {
						renderer.updateViewPlayerDungeon(stage, player, mp);
					} catch (PreConditionException e) {						
						e.printStackTrace();
					}
						break;
						
					case W:
						
						if(x-1 >= 0 && y >= 0 && x-1 < rendenv.getWidth() && y < rendenv.getHeight()) {
							if(rendenv.getCellNature(x-1, y) == Cell.CHESTO)
								rendenv.closeChest(x-1, y);
							else
								rendenv.closeDoor(x-1, y);
						}
					try {
						renderer.updateViewPlayerDungeon(stage, player, mp);
					} catch (PreConditionException e) {						
						e.printStackTrace();
					}
						break;					
					
				}
				
			});
			
			root.getChildren().add(closeButton);
			
			ToggleButton takeButton = (ToggleButton) ToolBoxV2.createToggleButtonImage("", "graphics&sounds/graphics_2d/take.jpg", DungeonMaster.getLongu()-360+64*2+30*2, DungeonMaster.getHaut()-250);
			
			takeButton.setOnMouseClicked(event ->{
				
				try {
					
					player.takeWeaponOrKey();
					renderer.updateViewPlayerDungeon(stage, player, mp);
					
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
				
			});
			
			root.getChildren().add(takeButton);
			
			ToggleButton dropButton = (ToggleButton) ToolBoxV2.createToggleButtonImage("", "graphics&sounds/graphics_2d/drop.jpg", DungeonMaster.getLongu()-360+64*2+30*2, DungeonMaster.getHaut()-300);
			
			dropButton.setOnMouseClicked(event ->{
				
				try {
					
					player.dropWeapon();
					renderer.updateViewPlayerDungeon(stage, player, mp);
					
				} catch (PreConditionException e) {					
					e.printStackTrace();
				}
				
			});
			
			root.getChildren().add(dropButton);
			
			ToggleButton attackButton = (ToggleButton) ToolBoxV2.createToggleButtonImage("", "graphics&sounds/graphics_2d/attack.jpg", DungeonMaster.getLongu()-360+64*3+30*3, DungeonMaster.getHaut()-250);		
			root.getChildren().add(attackButton);
	     
	    }
	  
	    
	    
	

}
