package main;

import contrats.EngineContract;
import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Cell;
import implems.Dir;
import implems.MonsterImpl;
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


public class RendererV2Map2 extends RendererV2{
	
	int nbIte = 0;
	//int nbIteMax = 100;
	
	private MonsterImpl gozilla = new MonsterImpl();
	
	public RendererV2Map2() throws PreConditionException, PostConditionException {	
		
		super();
		spriteL = 70;			
		
		env.init(10, 10, eng);	
		player.init(env, 0, 9, Dir.S);
		gozilla.init(env, 5, 5, Dir.S, 100, 10);
		
		
		//on n ajoute pas le player dans engine car ce n est pas l engine qui controle le joueur (i e ce nest pas l engine qui va appeler le step du joueur mais les commandes de controle)
		eng.addEntity(gozilla);
		
		EngineContract ec = new EngineContract(eng);
		ec.init(env);
		
		
		env.getMap()[0][0] = Cell.SWORD; 
		env.getMap()[1][0] = Cell.WLL;
		env.getMap()[2][0] = Cell.EMP;
		env.getMap()[3][0] = Cell.EMP;
		env.getMap()[4][0] = Cell.EMP;
		env.getMap()[5][0] = Cell.EMP;
		env.getMap()[6][0] = Cell.EMP;
		env.getMap()[7][0] = Cell.EMP;
		env.getMap()[8][0] = Cell.WLL;
		env.getMap()[9][0] = Cell.OUT;
		
		env.getMap()[0][1] = Cell.EMP;
		env.getMap()[1][1] = Cell.WLL;
		env.getMap()[2][1] = Cell.EMP;
		env.getMap()[3][1] = Cell.EMP;
		env.getMap()[4][1] = Cell.EMP;
		env.getMap()[5][1] = Cell.EMP;
		env.getMap()[6][1] = Cell.EMP;
		env.getMap()[7][1] = Cell.EMP;
		env.getMap()[8][1] = Cell.WLL;
		env.getMap()[9][1] = Cell.EMP;
		
		env.getMap()[0][2] = Cell.EMP;
		env.getMap()[1][2] = Cell.WLL;
		env.getMap()[2][2] = Cell.EMP;
		env.getMap()[3][2] = Cell.EMP;
		env.getMap()[4][2] = Cell.EMP;
		env.getMap()[5][2] = Cell.EMP;
		env.getMap()[6][2] = Cell.EMP;
		env.getMap()[7][2] = Cell.EMP;
		env.getMap()[8][2] = Cell.WLL;
		env.getMap()[9][2] = Cell.EMP;
		
		env.getMap()[0][3] = Cell.EMP;
		env.getMap()[1][3] = Cell.WLL;
		env.getMap()[2][3] = Cell.EMP;
		env.getMap()[3][3] = Cell.EMP;
		env.getMap()[4][3] = Cell.EMP;
		env.getMap()[5][3] = Cell.EMP;
		env.getMap()[6][3] = Cell.EMP;
		env.getMap()[7][3] = Cell.EMP;
		env.getMap()[8][3] = Cell.WLL;
		env.getMap()[9][3] = Cell.EMP;
		
		env.getMap()[0][4] = Cell.EMP;
		env.getMap()[1][4] = Cell.WLL;
		env.getMap()[2][4] = Cell.EMP;
		env.getMap()[3][4] = Cell.EMP;
		env.getMap()[4][4] = Cell.EMP;
		env.getMap()[5][4] = Cell.EMP;
		env.getMap()[6][4] = Cell.EMP;
		env.getMap()[7][4] = Cell.EMP;
		env.getMap()[8][4] = Cell.WLL;
		env.getMap()[9][4] = Cell.EMP;
		
		env.getMap()[0][5] = Cell.EMP;
		env.getMap()[1][5] = Cell.EMP;
		env.getMap()[2][5] = Cell.EMP;
		env.getMap()[3][5] = Cell.EMP;
		env.getMap()[4][5] = Cell.EMP;
		env.getMap()[5][5] = Cell.EMP; //gozilla
		env.getMap()[6][5] = Cell.EMP;
		env.getMap()[7][5] = Cell.EMP; 
		env.getMap()[8][5] = Cell.EMP;
		env.getMap()[9][5] = Cell.EMP;
		
		env.getMap()[0][6] = Cell.DWC;
		env.getMap()[1][6] = Cell.WLL;
		env.getMap()[2][6] = Cell.EMP;
		env.getMap()[3][6] = Cell.EMP;
		env.getMap()[4][6] = Cell.EMP;
		env.getMap()[5][6] = Cell.EMP;
		env.getMap()[6][6] = Cell.EMP;
		env.getMap()[7][6] = Cell.EMP;
		env.getMap()[8][6] = Cell.WLL;
		env.getMap()[9][6] = Cell.EMP;
	
		env.getMap()[0][7] = Cell.EMP;
		env.getMap()[1][7] = Cell.WLL;
		env.getMap()[2][7] = Cell.EMP;
		env.getMap()[3][7] = Cell.EMP;
		env.getMap()[4][7] = Cell.EMP;
		env.getMap()[5][7] = Cell.EMP;
		env.getMap()[6][7] = Cell.EMP;
		env.getMap()[7][7] = Cell.EMP;
		env.getMap()[8][7] = Cell.WLL;
		env.getMap()[9][7] = Cell.EMP;
	
		env.getMap()[0][8] = Cell.EMP;
		env.getMap()[1][8] = Cell.WLL;
		env.getMap()[2][8] = Cell.EMP;
		env.getMap()[3][8] = Cell.EMP;
		env.getMap()[4][8] = Cell.EMP;
		env.getMap()[5][8] = Cell.EMP;
		env.getMap()[6][8] = Cell.EMP;
		env.getMap()[7][8] = Cell.EMP;
		env.getMap()[8][8] = Cell.WLL;
		env.getMap()[9][8] = Cell.EMP;
		
		env.getMap()[0][9] = Cell.IN;
		env.getMap()[1][9] = Cell.WLL;
		env.getMap()[2][9] = Cell.KEY; //clé
		env.getMap()[3][9] = Cell.EMP;
		env.getMap()[4][9] = Cell.EMP;
		env.getMap()[5][9] = Cell.EMP;
		env.getMap()[6][9] = Cell.EMP;
		env.getMap()[7][9] = Cell.EMP;
		env.getMap()[8][9] = Cell.WLL;
		env.getMap()[9][9] = Cell.CHESTC;	//chest

	}
	
	
	public void doNothing() {
		
		int i = 0;
		while(i < 100)i++;
	}
	
	public void clear() {
		
		for(int i = 0 ; i < env.getWidth() ; i++)
			for(int j = 0 ; j < env.getHeight() ; j++)
				env.getMap()[i][j] = Cell.EMP;
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
			} catch (PreConditionException e1) {				
				e1.printStackTrace();
			}
//			while(nbIte < nbIteMax) {
//				
//				try {					
//					eng.step(this, stage, player, mp);
//					//doNothing();
//					
//				} catch (PreConditionException | PostConditionException e) {						
//					e.printStackTrace();
//				}				
//			}
			System.out.println("END");
			

		});
		
		qSwitch.setOnMouseClicked(event -> {
			System.exit(0);
		});
		
		root2.getChildren().add(ToolBoxV2.createVolumeControls(mp, 50, DungeonMaster.getHaut()-180));
		root2.getChildren().addAll(backGround, porteG, porteD, eSwitch, rSwitch, qSwitch);
		stage.setScene(scene2);
		stage.centerOnScreen();
	}

	@Override
	public void updateViewPlayerDungeon(Stage stage, PlayerImpl player, MediaPlayer mp) throws PreConditionException {
		
		int x = player.getCol();
		int y = player.getRow();
		
		int gozX = gozilla.getCol();
		int gozY = gozilla.getRow();
		
		double pointInitX = 20;
		double pointInitY = 20;
		
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
							
							//faire switch weapon
							
							switch(player.getFace()) {
							
								case N:
									ImageView imv1 = new ImageView(inPN);																
									imv1.setLayoutX(pointInitX+spriteL*i);
									imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv1.setFitHeight(spriteL);
									imv1.setFitWidth(spriteL);
									root.getChildren().add(imv1);
									
									break;
								case E:
									ImageView imv2 = new ImageView(inPE);																
									imv2.setLayoutX(pointInitX+spriteL*i);
									imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv2.setFitHeight(spriteL);
									imv2.setFitWidth(spriteL);
									root.getChildren().add(imv2);
								
									break;
								case S:
									ImageView imv3 = new ImageView(inPS);																
									imv3.setLayoutX(pointInitX+spriteL*i);
									imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv3.setFitHeight(spriteL);
									imv3.setFitWidth(spriteL);
									root.getChildren().add(imv3);
									
									break;
								case W:
									ImageView imv4 = new ImageView(inPW);																
									imv4.setLayoutX(pointInitX+spriteL*i);
									imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv4.setFitHeight(spriteL);
									imv4.setFitWidth(spriteL);
									root.getChildren().add(imv4);
									
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
								
									break;
									
								case E:
									
									ImageView imv2 = new ImageView(outPE);																
									imv2.setLayoutX(pointInitX+spriteL*i);
									imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv2.setFitHeight(spriteL);
									imv2.setFitWidth(spriteL);
									root.getChildren().add(imv2);
							
									break;
									
								case S:
									
									ImageView imv3 = new ImageView(outPS);																
									imv3.setLayoutX(pointInitX+spriteL*i);
									imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv3.setFitHeight(spriteL);
									imv3.setFitWidth(spriteL);
									root.getChildren().add(imv3);
									if(env.getMap()[9][9] == Cell.CHESTO)
										System.out.println("GG, you won !");
									
									break;
									
								case W:
									
									ImageView imv4 = new ImageView(outPW);																
									imv4.setLayoutX(pointInitX+spriteL*i);
									imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
									imv4.setFitHeight(spriteL);
									imv4.setFitWidth(spriteL);
									root.getChildren().add(imv4);
								
									break;
							}												
							
							break;
							
						case EMP:
							
							switch(player.getWeapon()) {
							
								case EMPTY:
									
									switch(player.getFace()) {
									
										case N:
											
											ImageView imv1 = new ImageView(floorPN);																
											imv1.setLayoutX(pointInitX+spriteL*i);
											imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
											imv1.setFitHeight(spriteL);
											imv1.setFitWidth(spriteL);
											root.getChildren().add(imv1);
										
											break;
											
										case E:
											
											ImageView imv2 = new ImageView(floorPE);																
											imv2.setLayoutX(pointInitX+spriteL*i);
											imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
											imv2.setFitHeight(spriteL);
											imv2.setFitWidth(spriteL);
											root.getChildren().add(imv2);
										
											break;
											
										case S:
											
											ImageView imv3 = new ImageView(floorPS);																
											imv3.setLayoutX(pointInitX+spriteL*i);
											imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
											imv3.setFitHeight(spriteL);
											imv3.setFitWidth(spriteL);
											root.getChildren().add(imv3);
											
											break;
											
										case W:
											
											ImageView imv4 = new ImageView(floorPW);																
											imv4.setLayoutX(pointInitX+spriteL*i);
											imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
											imv4.setFitHeight(spriteL);
											imv4.setFitWidth(spriteL);
											root.getChildren().add(imv4);
											
											break;
									}
									
									break;
									
								case SWORD:
									
									switch(player.getFace()) {
									
										case N:
											
											ImageView imv1 = new ImageView(floorPNsword);																
											imv1.setLayoutX(pointInitX+spriteL*i);
											imv1.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
											imv1.setFitHeight(spriteL);
											imv1.setFitWidth(spriteL);
											root.getChildren().add(imv1);
										
											break;
											
										case E:
											
											ImageView imv2 = new ImageView(floorPEsword);																
											imv2.setLayoutX(pointInitX+spriteL*i);
											imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
											imv2.setFitHeight(spriteL);
											imv2.setFitWidth(spriteL);
											root.getChildren().add(imv2);
										
											break;
											
										case S:
											
											ImageView imv3 = new ImageView(floorPSsword);																
											imv3.setLayoutX(pointInitX+spriteL*i);
											imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
											imv3.setFitHeight(spriteL);
											imv3.setFitWidth(spriteL);
											root.getChildren().add(imv3);
											
											break;
											
										case W:
											
											ImageView imv4 = new ImageView(floorPWsword);																
											imv4.setLayoutX(pointInitX+spriteL*i);
											imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
											imv4.setFitHeight(spriteL);
											imv4.setFitWidth(spriteL);
											root.getChildren().add(imv4);
											
											break;
									}
									
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
								
								break;
							case E:
								ImageView imv2 = new ImageView(dwoPE);																
								imv2.setLayoutX(pointInitX+spriteL*i);
								imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
								imv2.setFitHeight(spriteL);
								imv2.setFitWidth(spriteL);
								root.getChildren().add(imv2);
								
								break;
							case S:
								ImageView imv3 = new ImageView(dwoPS);																
								imv3.setLayoutX(pointInitX+spriteL*i);
								imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
								imv3.setFitHeight(spriteL);
								imv3.setFitWidth(spriteL);
								root.getChildren().add(imv3);
								
								break;
							case W:
								ImageView imv4 = new ImageView(dwoPW);																
								imv4.setLayoutX(pointInitX+spriteL*i);
								imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
								imv4.setFitHeight(spriteL);
								imv4.setFitWidth(spriteL);
								root.getChildren().add(imv4);
								
								break;
						}
							
							break;						
					
					}					
				}				
				
				//on met toutes les autres cases à sombre sauf celle du joueur 
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
							
							ImageView imv17 = new ImageView(outo);
							imv17.setEffect(colorAdjust);								
							imv17.setLayoutX(pointInitX+spriteL*i);
							imv17.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv17.setFitHeight(spriteL);
							imv17.setFitWidth(spriteL);
							root.getChildren().add(imv17);
							break;
							
							
						case EMP:
							
							if(i == gozX && j == gozY) {
								
								switch(gozilla.getFace()) {
								
									case N:
										
										ImageView imv9 = new ImageView(floorMN);
										imv9.setEffect(colorAdjust);								
										imv9.setLayoutX(pointInitX+spriteL*i);
										imv9.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
										imv9.setFitHeight(spriteL);
										imv9.setFitWidth(spriteL);
										root.getChildren().add(imv9);
										break;
										
									case E:
										
										ImageView imv10 = new ImageView(floorME);
										imv10.setEffect(colorAdjust);								
										imv10.setLayoutX(pointInitX+spriteL*i);
										imv10.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
										imv10.setFitHeight(spriteL);
										imv10.setFitWidth(spriteL);
										root.getChildren().add(imv10);
										break;
										
									case S:
										
										ImageView imv11 = new ImageView(floorMS);
										imv11.setEffect(colorAdjust);								
										imv11.setLayoutX(pointInitX+spriteL*i);
										imv11.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
										imv11.setFitHeight(spriteL);
										imv11.setFitWidth(spriteL);
										root.getChildren().add(imv11);
										break;
										
									case W:
										
										ImageView imv12 = new ImageView(floorMW);
										imv12.setEffect(colorAdjust);								
										imv12.setLayoutX(pointInitX+spriteL*i);
										imv12.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
										imv12.setFitHeight(spriteL);
										imv12.setFitWidth(spriteL);
										root.getChildren().add(imv12);
										break;									
								}
								
								
							}
							
							else {
								ImageView imv3 = new ImageView(emptyFloor);
								imv3.setEffect(colorAdjust);								
								imv3.setLayoutX(pointInitX+spriteL*i);
								imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
								imv3.setFitHeight(spriteL);
								imv3.setFitWidth(spriteL);
								root.getChildren().add(imv3);
							}
							
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
							
						case SWORD:
							
							ImageView imv13 = new ImageView(sword);
							imv13.setEffect(colorAdjust);								
							imv13.setLayoutX(pointInitX+spriteL*i);
							imv13.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv13.setFitHeight(spriteL);
							imv13.setFitWidth(spriteL);
							root.getChildren().add(imv13);
							break;
							
						case CHESTC:
							
							ImageView imv14 = new ImageView(chestC);
							imv14.setEffect(colorAdjust);								
							imv14.setLayoutX(pointInitX+spriteL*i);
							imv14.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv14.setFitHeight(spriteL);
							imv14.setFitWidth(spriteL);
							root.getChildren().add(imv14);
							break;	
					
						case CHESTO:
							
							ImageView imv15 = new ImageView(chestO);
							imv15.setEffect(colorAdjust);								
							imv15.setLayoutX(pointInitX+spriteL*i);
							imv15.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv15.setFitHeight(spriteL);
							imv15.setFitWidth(spriteL);
							root.getChildren().add(imv15);
							break;	
							
						case KEY:
							
							ImageView imv16 = new ImageView(key);
							imv16.setEffect(colorAdjust);								
							imv16.setLayoutX(pointInitX+spriteL*i);
							imv16.setLayoutY(env.getHeight()*spriteL-(spriteL*j+spriteL) + pointInitY);
							imv16.setFitHeight(spriteL);
							imv16.setFitWidth(spriteL);
							root.getChildren().add(imv16);
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
																							
										break;
											
									case OUT:
										
										ImageView imv2 = new ImageView(outc);																
										imv2.setLayoutX(pointInitX+spriteL*posx);
										imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv2.setFitHeight(spriteL);
										imv2.setFitWidth(spriteL);
										root.getChildren().add(imv2);
										
										break;
											
									case OUTO:
										
										ImageView imv17 = new ImageView(outo);																
										imv17.setLayoutX(pointInitX+spriteL*posx);
										imv17.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv17.setFitHeight(spriteL);
										imv17.setFitWidth(spriteL);
										root.getChildren().add(imv17);
										
										break;
										
									case EMP:
										
										if(posx == gozX && posy == gozY) {
											
											switch(gozilla.getFace()) {
											
												case N:
													
													ImageView imv9 = new ImageView(floorMN);																				
													imv9.setLayoutX(pointInitX+spriteL*posx);
													imv9.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv9.setFitHeight(spriteL);
													imv9.setFitWidth(spriteL);
													root.getChildren().add(imv9);
													break;
													
												case E:
													
													ImageView imv10 = new ImageView(floorME);																			
													imv10.setLayoutX(pointInitX+spriteL*posx);
													imv10.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv10.setFitHeight(spriteL);
													imv10.setFitWidth(spriteL);
													root.getChildren().add(imv10);
													break;
													
												case S:
													
													ImageView imv11 = new ImageView(floorMS);																				
													imv11.setLayoutX(pointInitX+spriteL*posx);
													imv11.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv11.setFitHeight(spriteL);
													imv11.setFitWidth(spriteL);
													root.getChildren().add(imv11);
													break;
													
												case W:
													
													ImageView imv12 = new ImageView(floorMW);																			
													imv12.setLayoutX(pointInitX+spriteL*posx);
													imv12.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv12.setFitHeight(spriteL);
													imv12.setFitWidth(spriteL);
													root.getChildren().add(imv12);
													break;									
											}
										}
										else {
											ImageView imv3 = new ImageView(emptyFloor);																
											imv3.setLayoutX(pointInitX+spriteL*posx);
											imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
											imv3.setFitHeight(spriteL);
											imv3.setFitWidth(spriteL);
											root.getChildren().add(imv3);
											
										}
																		
										break;
											
									case WLL:
										
										ImageView imv4 = new ImageView(wall);																
										imv4.setLayoutX(pointInitX+spriteL*posx);
										imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
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
										imv7.setLayoutX(pointInitX+spriteL*posx);
										imv7.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv7.setFitHeight(spriteL);
										imv7.setFitWidth(spriteL);
										root.getChildren().add(imv7);
										
										break;
											
									case DWC:
										
										ImageView imv8 = new ImageView(dwc);																
										imv8.setLayoutX(pointInitX+spriteL*posx);
										imv8.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv8.setFitHeight(spriteL);
										imv8.setFitWidth(spriteL);
										root.getChildren().add(imv8);
										
										break;
									
									case SWORD:
										
										ImageView imv13 = new ImageView(sword);																	
										imv13.setLayoutX(pointInitX+spriteL*posx);
										imv13.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv13.setFitHeight(spriteL);
										imv13.setFitWidth(spriteL);
										root.getChildren().add(imv13);
										
										break;
										
									case CHESTC:
										
										ImageView imv14 = new ImageView(chestC);																		
										imv14.setLayoutX(pointInitX+spriteL*posx);
										imv14.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv14.setFitHeight(spriteL);
										imv14.setFitWidth(spriteL);
										root.getChildren().add(imv14);
										break;	
								
									case CHESTO:
										
										ImageView imv15 = new ImageView(chestO);																		
										imv15.setLayoutX(pointInitX+spriteL*posx);
										imv15.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv15.setFitHeight(spriteL);
										imv15.setFitWidth(spriteL);
										root.getChildren().add(imv15);
										break;
										
									case KEY:
	
										ImageView imv16 = new ImageView(key);																		
										imv16.setLayoutX(pointInitX+spriteL*posx);
										imv16.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv16.setFitHeight(spriteL);
										imv16.setFitWidth(spriteL);
										root.getChildren().add(imv16);
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
																							
										break;
											
									case OUT:
											
										ImageView imv2 = new ImageView(outc);																
										imv2.setLayoutX(pointInitX+spriteL*posx);
										imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv2.setFitHeight(spriteL);
										imv2.setFitWidth(spriteL);
										root.getChildren().add(imv2);
										
										break;
										
									case OUTO:
										
										ImageView imv17 = new ImageView(outo);																
										imv17.setLayoutX(pointInitX+spriteL*posx);
										imv17.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv17.setFitHeight(spriteL);
										imv17.setFitWidth(spriteL);
										root.getChildren().add(imv17);
										
										break;
											
									case EMP:
											
										if(posx == gozX && posy == gozY) {
											
											switch(gozilla.getFace()) {
											
												case N:
													
													ImageView imv9 = new ImageView(floorMN);																				
													imv9.setLayoutX(pointInitX+spriteL*posx);
													imv9.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv9.setFitHeight(spriteL);
													imv9.setFitWidth(spriteL);
													root.getChildren().add(imv9);
													break;
													
												case E:
													
													ImageView imv10 = new ImageView(floorME);																			
													imv10.setLayoutX(pointInitX+spriteL*posx);
													imv10.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv10.setFitHeight(spriteL);
													imv10.setFitWidth(spriteL);
													root.getChildren().add(imv10);
													break;
													
												case S:													
													
													ImageView imv11 = new ImageView(floorMS);																				
													imv11.setLayoutX(pointInitX+spriteL*posx);
													imv11.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv11.setFitHeight(spriteL);
													imv11.setFitWidth(spriteL);
													root.getChildren().add(imv11);
													break;
													
												case W:
													
													ImageView imv12 = new ImageView(floorMW);																			
													imv12.setLayoutX(pointInitX+spriteL*posx);
													imv12.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv12.setFitHeight(spriteL);
													imv12.setFitWidth(spriteL);
													root.getChildren().add(imv12);
													break;									
											}
										}
										else {
											ImageView imv3 = new ImageView(emptyFloor);																
											imv3.setLayoutX(pointInitX+spriteL*posx);
											imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
											imv3.setFitHeight(spriteL);
											imv3.setFitWidth(spriteL);
											root.getChildren().add(imv3);
											
										}
																	
										break;
											
									case WLL:
											
										ImageView imv4 = new ImageView(wall);																
										imv4.setLayoutX(pointInitX+spriteL*posx);
										imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
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
										imv7.setLayoutX(pointInitX+spriteL*posx);
										imv7.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv7.setFitHeight(spriteL);
										imv7.setFitWidth(spriteL);
										root.getChildren().add(imv7);
										
										break;
											
									case DWC:
										
										ImageView imv8 = new ImageView(dwc);																
										imv8.setLayoutX(pointInitX+spriteL*posx);
										imv8.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv8.setFitHeight(spriteL);
										imv8.setFitWidth(spriteL);
										root.getChildren().add(imv8);
										
										break;
										
										
									case SWORD:
										
										ImageView imv13 = new ImageView(sword);																	
										imv13.setLayoutX(pointInitX+spriteL*posx);
										imv13.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv13.setFitHeight(spriteL);
										imv13.setFitWidth(spriteL);
										root.getChildren().add(imv13);
										
										break;
										
									case CHESTC:
										
										ImageView imv14 = new ImageView(chestC);																		
										imv14.setLayoutX(pointInitX+spriteL*posx);
										imv14.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv14.setFitHeight(spriteL);
										imv14.setFitWidth(spriteL);
										root.getChildren().add(imv14);
										break;	
								
									case CHESTO:
										
										ImageView imv15 = new ImageView(chestO);																		
										imv15.setLayoutX(pointInitX+spriteL*posx);
										imv15.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv15.setFitHeight(spriteL);
										imv15.setFitWidth(spriteL);
										root.getChildren().add(imv15);
										break;
										
									case KEY:
										
										ImageView imv16 = new ImageView(key);																		
										imv16.setLayoutX(pointInitX+spriteL*posx);
										imv16.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv16.setFitHeight(spriteL);
										imv16.setFitWidth(spriteL);
										root.getChildren().add(imv16);
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
																							
										break;
											
									case OUT:
										
										ImageView imv2 = new ImageView(outc);																
										imv2.setLayoutX(pointInitX+spriteL*posx);
										imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv2.setFitHeight(spriteL);
										imv2.setFitWidth(spriteL);
										root.getChildren().add(imv2);
										
										break;
									
									case OUTO:
										
										ImageView imv17 = new ImageView(outo);																
										imv17.setLayoutX(pointInitX+spriteL*posx);
										imv17.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv17.setFitHeight(spriteL);
										imv17.setFitWidth(spriteL);
										root.getChildren().add(imv17);
										
										break;
										
									case EMP:
										
										if(posx == gozX && posy == gozY) {
											
											switch(gozilla.getFace()) {
											
												case N:
													
													ImageView imv9 = new ImageView(floorMN);																				
													imv9.setLayoutX(pointInitX+spriteL*posx);
													imv9.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv9.setFitHeight(spriteL);
													imv9.setFitWidth(spriteL);
													root.getChildren().add(imv9);
													break;
													
												case E:
													
													ImageView imv10 = new ImageView(floorME);																			
													imv10.setLayoutX(pointInitX+spriteL*posx);
													imv10.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv10.setFitHeight(spriteL);
													imv10.setFitWidth(spriteL);
													root.getChildren().add(imv10);
													break;
													
												case S:
													
													ImageView imv11 = new ImageView(floorMS);																				
													imv11.setLayoutX(pointInitX+spriteL*posx);
													imv11.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv11.setFitHeight(spriteL);
													imv11.setFitWidth(spriteL);
													root.getChildren().add(imv11);
													break;
													
												case W:
													
													ImageView imv12 = new ImageView(floorMW);																			
													imv12.setLayoutX(pointInitX+spriteL*posx);
													imv12.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv12.setFitHeight(spriteL);
													imv12.setFitWidth(spriteL);
													root.getChildren().add(imv12);
													break;									
											}
										}
										else {
											ImageView imv3 = new ImageView(emptyFloor);																
											imv3.setLayoutX(pointInitX+spriteL*posx);
											imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
											imv3.setFitHeight(spriteL);
											imv3.setFitWidth(spriteL);
											root.getChildren().add(imv3);
											
										}
																
										break;
											
									case WLL:
										
										ImageView imv4 = new ImageView(wall);																
										imv4.setLayoutX(pointInitX+spriteL*posx);
										imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
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
										imv7.setLayoutX(pointInitX+spriteL*posx);
										imv7.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv7.setFitHeight(spriteL);
										imv7.setFitWidth(spriteL);
										root.getChildren().add(imv7);
										
										break;
											
									case DWC:
										
										ImageView imv8 = new ImageView(dwc);																
										imv8.setLayoutX(pointInitX+spriteL*posx);
										imv8.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv8.setFitHeight(spriteL);
										imv8.setFitWidth(spriteL);
										root.getChildren().add(imv8);
										
										break;
									
									case SWORD:
										
										ImageView imv13 = new ImageView(sword);																	
										imv13.setLayoutX(pointInitX+spriteL*posx);
										imv13.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv13.setFitHeight(spriteL);
										imv13.setFitWidth(spriteL);
										root.getChildren().add(imv13);
										
										break;
										
									case CHESTC:
										
										ImageView imv14 = new ImageView(chestC);																		
										imv14.setLayoutX(pointInitX+spriteL*posx);
										imv14.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv14.setFitHeight(spriteL);
										imv14.setFitWidth(spriteL);
										root.getChildren().add(imv14);
										break;	
								
									case CHESTO:
										
										ImageView imv15 = new ImageView(chestO);																		
										imv15.setLayoutX(pointInitX+spriteL*posx);
										imv15.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv15.setFitHeight(spriteL);
										imv15.setFitWidth(spriteL);
										root.getChildren().add(imv15);
										break;
										
									case KEY:
										
										ImageView imv16 = new ImageView(key);																		
										imv16.setLayoutX(pointInitX+spriteL*posx);
										imv16.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv16.setFitHeight(spriteL);
										imv16.setFitWidth(spriteL);
										root.getChildren().add(imv16);
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
																							
										break;
											
									case OUT:
											
										ImageView imv2 = new ImageView(outc);																
										imv2.setLayoutX(pointInitX+spriteL*posx);
										imv2.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv2.setFitHeight(spriteL);
										imv2.setFitWidth(spriteL);
										root.getChildren().add(imv2);
										
										break;
										
									case OUTO:
										
										ImageView imv17 = new ImageView(outo);																
										imv17.setLayoutX(pointInitX+spriteL*posx);
										imv17.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv17.setFitHeight(spriteL);
										imv17.setFitWidth(spriteL);
										root.getChildren().add(imv17);
										
										break;	
											
									case EMP:
											
										if(posx == gozX && posy == gozY) {
											
											switch(gozilla.getFace()) {
											
												case N:
													
													ImageView imv9 = new ImageView(floorMN);																				
													imv9.setLayoutX(pointInitX+spriteL*posx);
													imv9.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv9.setFitHeight(spriteL);
													imv9.setFitWidth(spriteL);
													root.getChildren().add(imv9);
													break;
													
												case E:
													
													ImageView imv10 = new ImageView(floorME);																			
													imv10.setLayoutX(pointInitX+spriteL*posx);
													imv10.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv10.setFitHeight(spriteL);
													imv10.setFitWidth(spriteL);
													root.getChildren().add(imv10);
													break;
													
												case S:
													
													ImageView imv11 = new ImageView(floorMS);																				
													imv11.setLayoutX(pointInitX+spriteL*posx);
													imv11.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv11.setFitHeight(spriteL);
													imv11.setFitWidth(spriteL);
													root.getChildren().add(imv11);
													break;
													
												case W:
													
													ImageView imv12 = new ImageView(floorMW);																			
													imv12.setLayoutX(pointInitX+spriteL*posx);
													imv12.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
													imv12.setFitHeight(spriteL);
													imv12.setFitWidth(spriteL);
													root.getChildren().add(imv12);
													break;									
											}
										}
										else {
											ImageView imv3 = new ImageView(emptyFloor);																
											imv3.setLayoutX(pointInitX+spriteL*posx);
											imv3.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
											imv3.setFitHeight(spriteL);
											imv3.setFitWidth(spriteL);
											root.getChildren().add(imv3);
											
										}
																	
										break;
											
									case WLL:
											
										ImageView imv4 = new ImageView(wall);																
										imv4.setLayoutX(pointInitX+spriteL*posx);
										imv4.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
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
										imv7.setLayoutX(pointInitX+spriteL*posx);
										imv7.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv7.setFitHeight(spriteL);
										imv7.setFitWidth(spriteL);
										root.getChildren().add(imv7);
										
										break;
											
									case DWC:
										
										ImageView imv8 = new ImageView(dwc);																
										imv8.setLayoutX(pointInitX+spriteL*posx);
										imv8.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv8.setFitHeight(spriteL);
										imv8.setFitWidth(spriteL);
										root.getChildren().add(imv8);
										
										break;
									
									case SWORD:
										
										ImageView imv13 = new ImageView(sword);																	
										imv13.setLayoutX(pointInitX+spriteL*posx);
										imv13.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv13.setFitHeight(spriteL);
										imv13.setFitWidth(spriteL);
										root.getChildren().add(imv13);
										
										break;
										
									case CHESTC:
										
										ImageView imv14 = new ImageView(chestC);																		
										imv14.setLayoutX(pointInitX+spriteL*posx);
										imv14.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv14.setFitHeight(spriteL);
										imv14.setFitWidth(spriteL);
										root.getChildren().add(imv14);
										break;	
								
									case CHESTO:
										
										ImageView imv15 = new ImageView(chestO);																		
										imv15.setLayoutX(pointInitX+spriteL*posx);
										imv15.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv15.setFitHeight(spriteL);
										imv15.setFitWidth(spriteL);
										root.getChildren().add(imv15);
										break;
										
									case KEY:
										
										ImageView imv16 = new ImageView(key);																		
										imv16.setLayoutX(pointInitX+spriteL*posx);
										imv16.setLayoutY(env.getHeight()*spriteL-(spriteL*posy+spriteL) + pointInitY);
										imv16.setFitHeight(spriteL);
										imv16.setFitWidth(spriteL);
										root.getChildren().add(imv16);
										break;
								}
							}
						}							
					}
				}
				
				
				break;
		
		
		}
		
		nbIte++;
		//System.out.println(nbIte);
//		try {
//			Thread.sleep(100);
//		} catch (InterruptedException e) {			
//			e.printStackTrace();
//		}
		
		root.getChildren().add(canvas);
		
		stage.setScene(scene);
		
		
	}
	
	
}
	



	
	
	


