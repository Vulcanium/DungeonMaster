package main;

import contrats.PreConditionException;
import implems.EditMapImpl;
import implems.EngineImpl;
import implems.EnvironmentImpl;
import implems.PlayerImpl;
import implems.PlayerImplBug;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import toolbox.ToolBoxV2;

public abstract class RendererV2{
	
	protected double pointInitX;
	protected double pointInitY;
	
	protected PlayerImpl player;
	//protected PlayerImplBug player;
	protected EnvironmentImpl env; 
	protected EngineImpl eng;
	protected ImageView porteG, porteD, backGround;
	protected DungeonMaster main;
	protected EditMapImpl emap;
	
	protected Image emptyFloor, wall, in, outo, outc, dno, dnc, dwo, dwc;
	protected Image floorPN, floorPE, floorPS, floorPW; //PN = Player direction North etc.
	protected Image inPN, inPE, inPS, inPW;
	protected Image outPN, outPE, outPS, outPW; 
	protected Image dnoPN, dnoPE, dnoPS, dnoPW; 
	protected Image dwoPN, dwoPE, dwoPS, dwoPW;
	protected Image open, close, take, attack;
	
	protected Image floorMN, floorME, floorMS, floorMW;
	protected Image sword, dagger, stick;
	protected Image chestC, chestO;
	protected Image floorPEattack, floorPSattack, floorPWattack, floorPNattack;
	protected Image floorPEsword, floorPSsword, floorPWsword, floorPNsword;
	protected Image floorPEattackSword, floorPSattackSword, floorPWattackSword, floorPNattackSword;
	protected Image floorCE, floorCN, floordCS, floorCW;
	protected Image key;
	
	protected double spriteL;
	
	protected Canvas canvas;
	protected GraphicsContext gc;
	
	public RendererV2() {
		
		pointInitX = 20;
		pointInitY = 20;
		
		env = new EnvironmentImpl();		
		main = new DungeonMaster();
		player = new PlayerImpl();
		//player = new PlayerImplBug();
		eng = new EngineImpl();
		eng.init(env);
		emap = new EditMapImpl();
		
		emptyFloor = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/emptyFloor.jpg");
		wall = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/wall.jpg");
		in = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/in.jpg");
		outo = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/outo.jpg");	
		outc = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/outc.jpg");	
		dno = null;
		dnc = null;
		dwo = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/dwo.jpg");
		dwc = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/dwc.jpg");
		
		floorPN = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPN.jpg");
		floorPE = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPE.jpg");
		floorPS = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPS.jpg");
		floorPW = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPW.jpg");
		
		inPN = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/inPN.jpg");
		inPE = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/inPE.jpg");
		inPS = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/inPS.jpg");
		inPW = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/inPW.jpg");
		
		outPN = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/outPN.jpg");
		outPE = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/outPE.jpg");
		outPS = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/outPS.jpg");
		outPW = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/outPW.jpg");
		
		dnoPN = null;
		dnoPE = null;
		dnoPS = null;
		dnoPW = null;
		
		dwoPN = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/dwoPN.jpg");
		dwoPE = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/dwoPE.jpg");
		dwoPS = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/dwoPS.jpg");
		dwoPW = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/dwoPW.jpg");
		
		open = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/open.jpg");
		close = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/close.jpg");
		take = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/take.jpg");
		attack = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/attack.jpg");
		
		floorMN = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorMN.jpg");
		floorME = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorME.jpg");
		floorMS = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorMS.jpg");
		floorMW = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorMW.jpg");
		
		sword = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/sword.jpg");
		dagger = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/dagger.jpg"); 
		stick = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/stick.jpg");
		
		chestC = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/chestC.jpg"); 
		chestO = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/chestO.jpg");
		
		floorPEattack = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPEattack.jpg");
		floorPSattack = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPSattack.jpg");
		floorPWattack = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPWattack.jpg");
		floorPNattack = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPNattack.jpg");
		
		floorPEsword = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPEsword.jpg");
		floorPSsword = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPSsword.jpg");
		floorPWsword = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPWsword.jpg");
		floorPNsword = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPNsword.jpg");
		
		floorPEattackSword = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPEattackSword.jpg");
		floorPSattackSword = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPSattackSword.jpg");
		floorPWattackSword = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPWattackSword.jpg");
		floorPNattackSword = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorPNattackSword.jpg");
		
		floorCE = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorCE.jpg");
		floorCN = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorCN.jpg");
		floordCS = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floordCS.jpg");
		floorCW = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/floorCW.jpg");
		
		key = ToolBoxV2.loadImage("graphics&sounds/graphics_2d/key.jpg");
		
		spriteL = 100;
		
		canvas = new Canvas(spriteL*env.getWidth()+pointInitX, spriteL*env.getHeight()+pointInitY);
		gc = canvas.getGraphicsContext2D();

	}
	
	public EnvironmentImpl getEnv() {return env;}
	
	public abstract void loadViewEntrancePlayer(Stage stage, MediaPlayer mp);
	
	public abstract void updateViewPlayerDungeon(Stage stage, PlayerImpl player, MediaPlayer mp) throws PreConditionException;
	
	public void clear() {}
}
	



	
	
	


