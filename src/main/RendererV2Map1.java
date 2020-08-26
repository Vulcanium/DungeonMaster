package main;

import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Cell;
import implems.Dir;
import implems.PlayerImpl;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import toolbox.MenuButton2;
import toolbox.ToolBoxV2;


public class RendererV2Map1 extends RendererV2{
	
	public RendererV2Map1() throws PreConditionException, PostConditionException {
		
		super();	
		
		env.init(5, 5);	
		player.init(env, 0, 4, Dir.S);
		
		/*emap.init(env.getWidth(), env.getHeight());
		
		emap.setNature(0, 0, Cell.EMP);
		emap.setNature(1, 0, Cell.EMP);
		emap.setNature(2, 0, Cell.EMP);
		emap.setNature(3, 0, Cell.WLL);
		emap.setNature(4, 0, Cell.OUT);
		
		emap.setNature(0, 1, Cell.EMP);
		emap.setNature(1, 1, Cell.WLL);
		emap.setNature(2, 1, Cell.EMP);
		emap.setNature(3, 1, Cell.WLL);
		emap.setNature(4, 1, Cell.EMP);
		
		emap.setNature(0, 2, Cell.EMP);
		emap.setNature(1, 2, Cell.WLL);
		emap.setNature(2, 2, Cell.DWC);
		emap.setNature(3, 2, Cell.WLL);
		emap.setNature(4, 2, Cell.EMP);

		emap.setNature(0, 3, Cell.EMP);
		emap.setNature(1, 3, Cell.WLL);
		emap.setNature(2, 3, Cell.EMP);
		emap.setNature(3, 3, Cell.WLL);
		emap.setNature(4, 3, Cell.EMP);
		
		emap.setNature(0, 4, Cell.IN);
		emap.setNature(1, 4, Cell.WLL);
		emap.setNature(2, 4, Cell.EMP);
		emap.setNature(3, 4, Cell.EMP);
		emap.setNature(4, 4, Cell.EMP);*/
		
		env.getMap()[0][0] = Cell.EMP;
		env.getMap()[1][0] = Cell.EMP;
		env.getMap()[2][0] = Cell.EMP;
		env.getMap()[3][0] = Cell.WLL;
		env.getMap()[4][0] = Cell.OUTO;
		
		env.getMap()[0][1] = Cell.EMP;
		env.getMap()[1][1] = Cell.WLL;
		env.getMap()[2][1] = Cell.EMP;
		env.getMap()[3][1] = Cell.WLL;
		env.getMap()[4][1] = Cell.EMP;
		
		env.getMap()[0][2] = Cell.EMP;
		env.getMap()[1][2] = Cell.WLL;
		env.getMap()[2][2] = Cell.DWC;
		env.getMap()[3][2] = Cell.WLL;
		env.getMap()[4][2] = Cell.EMP;
		
		env.getMap()[0][3] = Cell.EMP;
		env.getMap()[1][3] = Cell.WLL;
		env.getMap()[2][3] = Cell.EMP;
		env.getMap()[3][3] = Cell.WLL;
		env.getMap()[4][3] = Cell.EMP;
		
		env.getMap()[0][4] = Cell.IN;
		env.getMap()[1][4] = Cell.WLL;
		env.getMap()[2][4] = Cell.EMP;
		env.getMap()[3][4] = Cell.EMP;
		env.getMap()[4][4] = Cell.EMP;
	}	
	
	@Override
	public void loadViewEntrancePlayer(Stage stage, MediaPlayer mp) {		
				
		Group root2 = new Group();
		Scene scene2 = new Scene(root2, DungeonMaster.getLongu(), DungeonMaster.getHaut(), Color.BLACK);
		
		ImageView imvG = ToolBoxV2.loadImageView2("graphics&sounds/graphics_hd/Entrance/leftEntranceDoor.png");
		backGround = ToolBoxV2.loadImageView3("graphics&sounds/graphics_hd/Entrance/backGroundEntrance.png", pointInitX, pointInitY);
		porteG = ToolBoxV2.loadImageView3("graphics&sounds/graphics_hd/Entrance/leftEntranceDoor.png", pointInitX, pointInitY+60);
		porteD = ToolBoxV2.loadImageView3("graphics&sounds/graphics_hd/Entrance/rightEntranceDoor.png", pointInitX+imvG.getImage().getWidth(), pointInitY+60);
		
		ToggleButton eSwitch= (ToggleButton) ToolBoxV2.createToggleButtonImage("", "graphics&sounds/graphics_hd/Entrance/enterSwitch.png", pointInitX+488, pointInitY+93);
		ToggleButton rSwitch= (ToggleButton) ToolBoxV2.createToggleButtonImage("", "graphics&sounds/graphics_hd/Entrance/resumeSwitch.png", pointInitX+488, pointInitY+158);
		ToggleButton qSwitch= (ToggleButton) ToolBoxV2.createToggleButtonImage("", "graphics&sounds/graphics_hd/Entrance/quitSwitch.png", pointInitX+488, pointInitY+219);
		
		MenuButton2 musicButton = new MenuButton2("MUSIC ON/OFF");
	    MenuButton2 backToMenu = new MenuButton2("BACK TO MENU");
	    
	    musicButton.setOnMouseClicked(event2 -> {
        	
        	mp.play();
        	//faire en sorte qu'on puisse mettre en pause quand on reclique, on y arrive avec un toggleButton grace à isSelected, trouver un moyen pour MenuButton2
        	
        });
        
        backToMenu.setOnMouseClicked(event2 -> {
        	mp.pause();
        	try {
				main.loadFirstStage(stage);
			} catch (PreConditionException | PostConditionException e) {				
				e.printStackTrace();
			}
        });
        
        ToolBoxV2.adjustPos(root2, musicButton, 100, DungeonMaster.getHaut()-50);        
        ToolBoxV2.adjustPos(root2, backToMenu, 120+250, DungeonMaster.getHaut()-50);
		
		eSwitch.setOnMouseClicked(event -> {
			
			
			backGround = ToolBoxV2.loadImageView3("graphics&sounds/graphics_hd/Entrance/backGroundEntrance.png", pointInitX, pointInitY);
			
			
			Group root3 = new Group();
			
			ToolBoxV2.addControlPanel(stage, root3, DungeonMaster.getLongu()-360, DungeonMaster.getHaut()-200, player, this, mp, eng);			
		    
			ToolBoxV2.adjustPos(root3, musicButton, 100, DungeonMaster.getHaut()-50);        
	        ToolBoxV2.adjustPos(root3, backToMenu, 120+250, DungeonMaster.getHaut()-50);
		    
			
	        root3.getChildren().add(ToolBoxV2.createVolumeControls(mp, 50, DungeonMaster.getHaut()-180));
			root3.getChildren().add(backGround);	
			

			try {
				updateViewPlayerDungeon(stage, player, mp);
			} catch (PreConditionException e) {				
				e.printStackTrace();
			}
			
			

		});
		
		qSwitch.setOnMouseClicked(event -> {
			System.exit(0);
		});
		
		root2.getChildren().add(ToolBoxV2.createVolumeControls(mp, 50, DungeonMaster.getHaut()-180));
		root2.getChildren().addAll(backGround, porteG, porteD, eSwitch, rSwitch, qSwitch);
		stage.setScene(scene2);
		stage.centerOnScreen();
	}
	
	public void waitt(long time) {
		
		long firstTime = System.currentTimeMillis();
		
		while(System.currentTimeMillis() - firstTime < time) {
			//System.out.println(System.currentTimeMillis());
		}
	}
	
	
	//méthode pple de màj de l'ihm
	@Override
	public void updateViewPlayerDungeon(Stage stage, PlayerImpl player, MediaPlayer mp) throws PreConditionException {			
		
		int x = player.getCol();
		int y = player.getRow();
		
		Group root = new Group();
		
		Scene scene = new Scene(root, DungeonMaster.getLongu(), DungeonMaster.getHaut(), Color.BLACK);
		
		ToolBoxV2.addControlPanel(stage, root, DungeonMaster.getLongu()-360, DungeonMaster.getHaut()-200, player, this, mp, eng);
		
		MenuButton2 musicButton = new MenuButton2("MUSIC ON/OFF");
		MenuButton2 backToMenu = new MenuButton2("BACK TO MENU");

		musicButton.setOnMouseClicked(event2 -> {
        	
        	mp.play();
        	//faire en sorte qu'on puisse mettre en pause quand on reclique, on y arrive avec un toggleButton grace à isSelected, trouver un moyen pour MenuButton2
        	
        });
		backToMenu.setOnMouseClicked(event2 -> {
        	//mp.pause();
        	try {
				main.loadFirstStage(stage);
			} catch (PreConditionException | PostConditionException e) {				
				e.printStackTrace();
			}
        });
		
		
		ToolBoxV2.adjustPos(root, musicButton, 100, DungeonMaster.getHaut()-50); 
		ToolBoxV2.adjustPos(root, backToMenu, 120+250, DungeonMaster.getHaut()-50);	
		
		root.getChildren().add(ToolBoxV2.createVolumeControls(mp, 50, DungeonMaster.getHaut()-180));
		
		Color targetColor = Color.GRAY;
        ColorAdjust colorAdjust = new ColorAdjust();	        
        colorAdjust.setBrightness(targetColor.getBrightness()-1.35);
		
		for(int i = 0 ; i < env.getWidth() ; i++) {
			for(int j = 0 ; j < env.getHeight() ; j++) {
				
				//pour afficher la case où se situe le joueur
				if(i == x && y == j) {
					
					switch(env.getCellNature(i, j)) {
					
						case IN:	    						
							
							switch(player.getFace()) {
							
								case N:
									ImageView imv1 = new ImageView(inPN);																
									imv1.setLayoutX(pointInitX+spriteL*i);
									imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv1.setFitHeight(spriteL);
									imv1.setFitWidth(spriteL);
									root.getChildren().add(imv1);
									//gc.drawImage(inPN, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
								case E:
									ImageView imv2 = new ImageView(inPE);																
									imv2.setLayoutX(pointInitX+spriteL*i);
									imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv2.setFitHeight(spriteL);
									imv2.setFitWidth(spriteL);
									root.getChildren().add(imv2);
									//c.drawImage(inPE, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
								case S:
									ImageView imv3 = new ImageView(inPS);																
									imv3.setLayoutX(pointInitX+spriteL*i);
									imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv3.setFitHeight(spriteL);
									imv3.setFitWidth(spriteL);
									root.getChildren().add(imv3);
									//gc.drawImage(inPS, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
								case W:
									ImageView imv4 = new ImageView(inPW);																
									imv4.setLayoutX(pointInitX+spriteL*i);
									imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv4.setFitHeight(spriteL);
									imv4.setFitWidth(spriteL);
									root.getChildren().add(imv4);
									//gc.drawImage(inPW, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
							}
							
							break;
							
						case OUTO:			
							
							switch(player.getFace()) {
							
								case N:
									
									ImageView imv1 = new ImageView(outPN);																
									imv1.setLayoutX(pointInitX+spriteL*i);
									imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv1.setFitHeight(spriteL);
									imv1.setFitWidth(spriteL);
									root.getChildren().add(imv1);
									//gc.drawImage(outPN, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
									
								case E:
									
									ImageView imv2 = new ImageView(outPE);																
									imv2.setLayoutX(pointInitX+spriteL*i);
									imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv2.setFitHeight(spriteL);
									imv2.setFitWidth(spriteL);
									root.getChildren().add(imv2);
									//gc.drawImage(outPE, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
									
								case S:
									
									ImageView imv3 = new ImageView(outPS);																
									imv3.setLayoutX(pointInitX+spriteL*i);
									imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv3.setFitHeight(spriteL);
									imv3.setFitWidth(spriteL);
									root.getChildren().add(imv3);
									//gc.drawImage(outPS, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
									
								case W:
									
									ImageView imv4 = new ImageView(outPW);																
									imv4.setLayoutX(pointInitX+spriteL*i);
									imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv4.setFitHeight(spriteL);
									imv4.setFitWidth(spriteL);
									root.getChildren().add(imv4);
									//gc.drawImage(outPW, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
							}
							
							System.out.println("Congratulations, you won !");
							
							break;
							
						case EMP:
							
							switch(player.getFace()) {
							
								case N:
									
									ImageView imv1 = new ImageView(floorPN);																
									imv1.setLayoutX(pointInitX+spriteL*i);
									imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv1.setFitHeight(spriteL);
									imv1.setFitWidth(spriteL);
									root.getChildren().add(imv1);
									//gc.drawImage(floorPN, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
									
								case E:
									
									ImageView imv2 = new ImageView(floorPE);																
									imv2.setLayoutX(pointInitX+spriteL*i);
									imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv2.setFitHeight(spriteL);
									imv2.setFitWidth(spriteL);
									root.getChildren().add(imv2);
									//gc.drawImage(floorPE, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
									
								case S:
									
									ImageView imv3 = new ImageView(floorPS);																
									imv3.setLayoutX(pointInitX+spriteL*i);
									imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv3.setFitHeight(spriteL);
									imv3.setFitWidth(spriteL);
									root.getChildren().add(imv3);
									//gc.drawImage(floorPS, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
									
								case W:
									
									ImageView imv4 = new ImageView(floorPW);																
									imv4.setLayoutX(pointInitX+spriteL*i);
									imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv4.setFitHeight(spriteL);
									imv4.setFitWidth(spriteL);
									root.getChildren().add(imv4);
									//gc.drawImage(floorPW, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
									break;
							}
							
							break;
						
						case DNO:
							
							switch(player.getFace()) {
							
								case N:
									
									//todo
									break;
									
								case E:
									
									//todo
									break;
									
								case S:
									
									//todo
									break;
									
								case W:
									
									//todo
									break;
							}
							
							break;
						
						case DWO:
							
							switch(player.getFace()) {
							
							case N:
								ImageView imv1 = new ImageView(dwoPN);																
								imv1.setLayoutX(pointInitX+spriteL*i);
								imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
								imv1.setFitHeight(spriteL);
								imv1.setFitWidth(spriteL);
								root.getChildren().add(imv1);
								//gc.drawImage(inPN, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
								break;
							case E:
								ImageView imv2 = new ImageView(dwoPE);																
								imv2.setLayoutX(pointInitX+spriteL*i);
								imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
								imv2.setFitHeight(spriteL);
								imv2.setFitWidth(spriteL);
								root.getChildren().add(imv2);
								//c.drawImage(inPE, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
								break;
							case S:
								ImageView imv3 = new ImageView(dwoPS);																
								imv3.setLayoutX(pointInitX+spriteL*i);
								imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
								imv3.setFitHeight(spriteL);
								imv3.setFitWidth(spriteL);
								root.getChildren().add(imv3);
								//gc.drawImage(inPS, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
								break;
							case W:
								ImageView imv4 = new ImageView(dwoPW);																
								imv4.setLayoutX(pointInitX+spriteL*i);
								imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
								imv4.setFitHeight(spriteL);
								imv4.setFitWidth(spriteL);
								root.getChildren().add(imv4);
								//gc.drawImage(inPW, pointInitX+spriteL*i, env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY, spriteL, spriteL);
								break;
						}
							
							break;						
					
					}					
				}
				
				//on met toutes les autres cases sauf celle du joueur à sombre
				//puis on mettra à jour les cases visibles après
				
				else {
					
					switch(env.getCellNature(i, j)) {
					
						case IN:
							
							ImageView imv1 = new ImageView(in);
							imv1.setEffect(colorAdjust);								
							imv1.setLayoutX(pointInitX+spriteL*i);
							imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv1.setFitHeight(spriteL);
							imv1.setFitWidth(spriteL);
							root.getChildren().add(imv1);
							break;
							
						case OUT:
							
							ImageView imv2 = new ImageView(outc);
							imv2.setEffect(colorAdjust);								
							imv2.setLayoutX(pointInitX+spriteL*i);
							imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv2.setFitHeight(spriteL);
							imv2.setFitWidth(spriteL);
							root.getChildren().add(imv2);
							break;
							
						case OUTO:
							
							ImageView imv9 = new ImageView(outo);
							imv9.setEffect(colorAdjust);								
							imv9.setLayoutX(pointInitX+spriteL*i);
							imv9.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv9.setFitHeight(spriteL);
							imv9.setFitWidth(spriteL);
							root.getChildren().add(imv9);
							break;	
							
						case EMP:
							
							ImageView imv3 = new ImageView(emptyFloor);
							imv3.setEffect(colorAdjust);								
							imv3.setLayoutX(pointInitX+spriteL*i);
							imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv3.setFitHeight(spriteL);
							imv3.setFitWidth(spriteL);
							root.getChildren().add(imv3);
							break;
							
						case WLL:
							
							ImageView imv4 = new ImageView(wall);
							imv4.setEffect(colorAdjust);								
							imv4.setLayoutX(pointInitX+spriteL*i);
							imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv4.setFitHeight(spriteL);
							imv4.setFitWidth(spriteL);
							root.getChildren().add(imv4);
							break;
							
						case DNO:
							
							//todo
							break;
							
						case DNC:
							
							//todo
							break;
							
						case DWO:
							
							ImageView imv7 = new ImageView(dwo);
							imv7.setEffect(colorAdjust);								
							imv7.setLayoutX(pointInitX+spriteL*i);
							imv7.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv7.setFitHeight(spriteL);
							imv7.setFitWidth(spriteL);
							root.getChildren().add(imv7);
							break;
							
						case DWC:
							
							ImageView imv8 = new ImageView(dwc);
							imv8.setEffect(colorAdjust);								
							imv8.setLayoutX(pointInitX+spriteL*i);
							imv8.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv8.setFitHeight(spriteL);
							imv8.setFitWidth(spriteL);
							root.getChildren().add(imv8);
							break;
					
					}
				}
			}
		}
		
		//pour les cases visibles dans le champ de vision du joueur
		switch(player.getFace()) {			
		
			case N:				
				
				for(int i = -1 ; i < 2 ; i++) {					
					
					for(int j = -1 ; j < 4 ; j++) {
						
						if(x == x + i && y == y + j) continue;
						
						double posx = i+x;
						double posy = j+y;
						
						if(i+x >= 0 && i+x < env.getWidth() && j+y >= 0 && j+y < env.getWidth()) {							
							
							//on change la luminosité pour les cases que le joueur voit
							if(player.getViewable(i, j)) {												
															
								switch(player.getNature(i, j)) {
								
									case IN:	    						
										
										ImageView imv1 = new ImageView(in);																
										imv1.setLayoutX(pointInitX+spriteL*posx);
										imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv1.setFitHeight(spriteL);
										imv1.setFitWidth(spriteL);
										root.getChildren().add(imv1);
										//gc.drawImage(in, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);														
										break;
											
									case OUT:
										
										ImageView imv2 = new ImageView(outc);																
										imv2.setLayoutX(pointInitX+spriteL*posx);
										imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv2.setFitHeight(spriteL);
										imv2.setFitWidth(spriteL);
										root.getChildren().add(imv2);
										//gc.drawImage(out, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
										
									case OUTO:
										
										ImageView imv9 = new ImageView(outo);																
										imv9.setLayoutX(pointInitX+spriteL*posx);
										imv9.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv9.setFitHeight(spriteL);
										imv9.setFitWidth(spriteL);
										root.getChildren().add(imv9);
										//gc.drawImage(out, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
											
									case EMP:
										
										ImageView imv3 = new ImageView(emptyFloor);																
										imv3.setLayoutX(pointInitX+spriteL*posx);
										imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv3.setFitHeight(spriteL);
										imv3.setFitWidth(spriteL);
										root.getChildren().add(imv3);
										//gc.drawImage(emptyFloor, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);								
										break;
											
									case WLL:
										
										ImageView imv4 = new ImageView(wall);																
										imv4.setLayoutX(pointInitX+spriteL*posx);
										imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv4.setFitHeight(spriteL);
										imv4.setFitWidth(spriteL);
										root.getChildren().add(imv4);
										//gc.drawImage(wall, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);								
										break;
											
									case DNO:
											
										//todo
										break;
											
									case DNC:
											
										//todo
										break;
											
									case DWO:
										
										ImageView imv7 = new ImageView(dwo);																
										imv7.setLayoutX(pointInitX+spriteL*posx);
										imv7.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv7.setFitHeight(spriteL);
										imv7.setFitWidth(spriteL);
										root.getChildren().add(imv7);
										//gc.drawImage(dwo, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
											
									case DWC:
										
										ImageView imv8 = new ImageView(dwc);																
										imv8.setLayoutX(pointInitX+spriteL*posx);
										imv8.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv8.setFitHeight(spriteL);
										imv8.setFitWidth(spriteL);
										root.getChildren().add(imv8);
										//gc.drawImage(dwc, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
									
									
								}
							}
						}							
					}
				}
						
				break;
				
			case E:
				

				for(int i = -1 ; i < 4 ; i++) {					
					
					for(int j = -1 ; j < 2 ; j++) {
						
						if(x == x + i && y == y + j) continue;
						
						double posx = i+x;
						double posy = j+y;
						
						if(i+x >= 0 && i+x < env.getWidth() && j+y >= 0 && j+y < env.getWidth()) {						
							
							if(player.getViewable(i, j)) {							
								
								switch(player.getNature(i, j)) {
								
									case IN:	    						
										
										ImageView imv1 = new ImageView(in);																
										imv1.setLayoutX(pointInitX+spriteL*posx);
										imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv1.setFitHeight(spriteL);
										imv1.setFitWidth(spriteL);
										root.getChildren().add(imv1);
										//gc.drawImage(in, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);														
										break;
											
									case OUT:
											
										ImageView imv2 = new ImageView(outc);																
										imv2.setLayoutX(pointInitX+spriteL*posx);
										imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv2.setFitHeight(spriteL);
										imv2.setFitWidth(spriteL);
										root.getChildren().add(imv2);
										//gc.drawImage(out, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
										
									case OUTO:
										
										ImageView imv9 = new ImageView(outo);																
										imv9.setLayoutX(pointInitX+spriteL*posx);
										imv9.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv9.setFitHeight(spriteL);
										imv9.setFitWidth(spriteL);
										root.getChildren().add(imv9);
										//gc.drawImage(out, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
											
									case EMP:
											
										ImageView imv3 = new ImageView(emptyFloor);																
										imv3.setLayoutX(pointInitX+spriteL*posx);
										imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv3.setFitHeight(spriteL);
										imv3.setFitWidth(spriteL);
										root.getChildren().add(imv3);
										//gc.drawImage(emptyFloor, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);								
										break;
											
									case WLL:
											
										ImageView imv4 = new ImageView(wall);																
										imv4.setLayoutX(pointInitX+spriteL*posx);
										imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv4.setFitHeight(spriteL);
										imv4.setFitWidth(spriteL);
										root.getChildren().add(imv4);
										//gc.drawImage(wall, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);								
										break;
											
									case DNO:
											
										//todo
										break;
											
									case DNC:
											
										//todo
										break;
											
									case DWO:
										
										ImageView imv7 = new ImageView(dwo);																
										imv7.setLayoutX(pointInitX+spriteL*posx);
										imv7.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv7.setFitHeight(spriteL);
										imv7.setFitWidth(spriteL);
										root.getChildren().add(imv7);
										//gc.drawImage(dwo, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
											
									case DWC:
										
										ImageView imv8 = new ImageView(dwc);																
										imv8.setLayoutX(pointInitX+spriteL*posx);
										imv8.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv8.setFitHeight(spriteL);
										imv8.setFitWidth(spriteL);
										root.getChildren().add(imv8);
										//gc.drawImage(dwc, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
									
									
								}
							}
						}							
					}
				}
				
				
				break;
				
			case S:
				

				for(int i = -1 ; i < 2 ; i++) {					
					
					for(int j = -3 ; j < 2 ; j++) {
						
						if(x == x + i && y == y + j) continue;
						
						double posx = i+x;
						double posy = j+y;
						
						if(i+x >= 0 && i+x < env.getWidth() && j+y >= 0 && j+y < env.getWidth()) {							
							
							//on change la luminosité pour les cases que le joueur voit
							if(player.getViewable(i, j)) {												
															
								switch(player.getNature(i, j)) {
								
									case IN:	    						
										
										ImageView imv1 = new ImageView(in);																
										imv1.setLayoutX(pointInitX+spriteL*posx);
										imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv1.setFitHeight(spriteL);
										imv1.setFitWidth(spriteL);
										root.getChildren().add(imv1);
										//gc.drawImage(in, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);														
										break;
											
									case OUT:
										
										ImageView imv2 = new ImageView(outc);																
										imv2.setLayoutX(pointInitX+spriteL*posx);
										imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv2.setFitHeight(spriteL);
										imv2.setFitWidth(spriteL);
										root.getChildren().add(imv2);
										//gc.drawImage(out, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
										
									case OUTO:
										
										ImageView imv9 = new ImageView(outo);																
										imv9.setLayoutX(pointInitX+spriteL*posx);
										imv9.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv9.setFitHeight(spriteL);
										imv9.setFitWidth(spriteL);
										root.getChildren().add(imv9);
										//gc.drawImage(out, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
											
									case EMP:
										
										ImageView imv3 = new ImageView(emptyFloor);																
										imv3.setLayoutX(pointInitX+spriteL*posx);
										imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv3.setFitHeight(spriteL);
										imv3.setFitWidth(spriteL);
										root.getChildren().add(imv3);
										//gc.drawImage(emptyFloor, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);								
										break;
											
									case WLL:
										
										ImageView imv4 = new ImageView(wall);																
										imv4.setLayoutX(pointInitX+spriteL*posx);
										imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv4.setFitHeight(spriteL);
										imv4.setFitWidth(spriteL);
										root.getChildren().add(imv4);
										//gc.drawImage(wall, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);								
										break;
											
									case DNO:
											
										//todo
										break;
											
									case DNC:
											
										//todo
										break;
											
									case DWO:
										
										ImageView imv7 = new ImageView(dwo);																
										imv7.setLayoutX(pointInitX+spriteL*posx);
										imv7.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv7.setFitHeight(spriteL);
										imv7.setFitWidth(spriteL);
										root.getChildren().add(imv7);
										//gc.drawImage(dwo, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
											
									case DWC:
										
										ImageView imv8 = new ImageView(dwc);																
										imv8.setLayoutX(pointInitX+spriteL*posx);
										imv8.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv8.setFitHeight(spriteL);
										imv8.setFitWidth(spriteL);
										root.getChildren().add(imv8);
										//gc.drawImage(dwc, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
									
									
								}
							}
						}							
					}
				}
						
				break;
				
			case W:
				

				for(int i = -3 ; i < 2 ; i++) {					
					
					for(int j = -1 ; j < 2 ; j++) {
						
						if(x == x + i && y == y + j) continue;
						
						double posx = i+x;
						double posy = j+y;
						
						if(i+x >= 0 && i+x < env.getWidth() && j+y >= 0 && j+y < env.getWidth()) {													
							
							if(player.getViewable(i, j)) {														
								
								switch(player.getNature(i, j)) {
								
									case IN:	    						
										
										ImageView imv1 = new ImageView(in);																
										imv1.setLayoutX(pointInitX+spriteL*posx);
										imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv1.setFitHeight(spriteL);
										imv1.setFitWidth(spriteL);
										root.getChildren().add(imv1);
										//gc.drawImage(in, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);														
										break;
											
									case OUT:
											
										ImageView imv2 = new ImageView(outc);																
										imv2.setLayoutX(pointInitX+spriteL*posx);
										imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv2.setFitHeight(spriteL);
										imv2.setFitWidth(spriteL);
										root.getChildren().add(imv2);
										//gc.drawImage(out, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
										
									case OUTO:
										
										ImageView imv9 = new ImageView(outo);																
										imv9.setLayoutX(pointInitX+spriteL*posx);
										imv9.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv9.setFitHeight(spriteL);
										imv9.setFitWidth(spriteL);
										root.getChildren().add(imv9);
										//gc.drawImage(out, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
										
									case EMP:
											
										ImageView imv3 = new ImageView(emptyFloor);																
										imv3.setLayoutX(pointInitX+spriteL*posx);
										imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv3.setFitHeight(spriteL);
										imv3.setFitWidth(spriteL);
										root.getChildren().add(imv3);
										//gc.drawImage(emptyFloor, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);								
										break;
											
									case WLL:
											
										ImageView imv4 = new ImageView(wall);																
										imv4.setLayoutX(pointInitX+spriteL*posx);
										imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv4.setFitHeight(spriteL);
										imv4.setFitWidth(spriteL);
										root.getChildren().add(imv4);
										//gc.drawImage(wall, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);								
										break;
											
									case DNO:
											
										//todo
										break;
											
									case DNC:
											
										//todo
										break;
											
									case DWO:
										
										ImageView imv7 = new ImageView(dwo);																
										imv7.setLayoutX(pointInitX+spriteL*posx);
										imv7.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv7.setFitHeight(spriteL);
										imv7.setFitWidth(spriteL);
										root.getChildren().add(imv7);
										//gc.drawImage(dwo, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
											
									case DWC:
										
										ImageView imv8 = new ImageView(dwc);																
										imv8.setLayoutX(pointInitX+spriteL*posx);
										imv8.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv8.setFitHeight(spriteL);
										imv8.setFitWidth(spriteL);
										root.getChildren().add(imv8);
										//gc.drawImage(dwc, pointInitX+spriteL*posx, env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY, spriteL, spriteL);
										break;
									
									
								}
							}
						}							
					}
				}
				
				
				break;
		
		
		}
				
		
		root.getChildren().add(canvas);
		
		stage.setScene(scene);
		
	}
}
	



	
	
	


