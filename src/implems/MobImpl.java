package implems;

import contrats.PreConditionException;
import services.EnvironmentService;
import services.MobService;

public class MobImpl implements MobService{

	private EnvironmentService env;
	private int x, y;
	private Dir dir;
	
	@Override
	public EnvironmentService getEnv() {
		
		return env;
	}

	@Override
	public int getCol() {
		
		return x;
	}

	@Override
	public int getRow() {
		
		return y;
	}

	@Override
	public Dir getFace() {
		
		return dir;
	}

	@Override
	public void init(EnvironmentService env, int x, int y, Dir dir) {
		
		this.env = env;
		this.x = x;
		this.y = y;
		this.dir = dir;
	}

	@Override
	public void forward() throws PreConditionException { 
		
		
		
		switch(dir) {
		
			case N:			
				
				
				
				if(y+1 < env.getHeight()) {
					Cell cforward1 = env.getCellNature(x, y+1);
					//Option<MobService> f = env.getCellContent(x, y+1);
					if(cforward1 != Cell.WLL && cforward1 != Cell.OUT && cforward1 != Cell.DNC && cforward1 != Cell.DWC && cforward1 != Cell.SWORD  && cforward1 != Cell.CHESTC  && cforward1 != Cell.CHESTO && cforward1 != Cell.KEY ) {// && !env.getCellContentBool(getCol(), getRow()+1)) {
						y++;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
					
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case E:
				
				
				
				if(x+1 < env.getWidth()) {
					Cell cforward2 = env.getCellNature(x+1, y);
					if(cforward2 != Cell.WLL && cforward2 != Cell.OUT  && cforward2 != Cell.DNC && cforward2 != Cell.DWC && cforward2 != Cell.SWORD  && cforward2 != Cell.CHESTC  && cforward2 != Cell.CHESTO && cforward2 != Cell.KEY ) {  // && !env.getCellContentBool(getCol()+1, getRow())) {
						x++;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
					
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case S:
				
				
				
				if(y-1 >= 0) {
					Cell cforward3 = env.getCellNature(x, y-1);
					if(cforward3 != Cell.WLL && cforward3 != Cell.OUT  && cforward3 != Cell.DNC && cforward3 != Cell.DWC && cforward3 != Cell.SWORD  && cforward3 != Cell.CHESTC  && cforward3 != Cell.CHESTO && cforward3 != Cell.KEY ) {  // && !env.getCellContentBool(getCol(), getRow()-1))
						y--;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}					
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case W:
				
			
				
				if(x-1 >= 0) {
					Cell cforward4 = env.getCellNature(x-1, y);
					if(cforward4 != Cell.WLL && cforward4 != Cell.OUT  && cforward4 != Cell.DNC && cforward4 != Cell.DWC && cforward4 != Cell.SWORD  && cforward4 != Cell.CHESTC  && cforward4 != Cell.CHESTO && cforward4 != Cell.KEY ) {// && !env.getCellContentBool(getCol()-1, getRow()))
						x--;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
				else {
					//System.out.println("There is void !");
				}
				break;
		}
	}

	@Override
	public void turnL() {
		
		switch(dir) {
		
			case N:
				dir = Dir.W;
				break;
			case E:
				dir = Dir.N;
				break;
			case S:
				dir = Dir.E;
				break;
			case W:
				dir = Dir.S;
				break;
		}
	}

	@Override
	public void turnR() {
		
		switch(dir) {
			
			case N:
				dir = Dir.E;
				break;
			case E:
				dir = Dir.S;
				break;
			case S:
				dir = Dir.W;
				break;
			case W:
				dir = Dir.N;
				break;
		}
	}

	@Override
	public void strafeL() throws PreConditionException {
		
	
		switch(dir) {
		
			case N:
				
			
				
				if(x-1 >= 0) {
					Cell cforward1 = env.getCellNature(x-1, y);
					if(cforward1 != Cell.WLL && cforward1 != Cell.OUT  && cforward1 != Cell.DNC && cforward1 != Cell.DWC  && cforward1 != Cell.SWORD  && cforward1 != Cell.CHESTC  && cforward1 != Cell.CHESTO && cforward1 != Cell.KEY ) {//  && !env.getCellContentBool(getCol()-1, getRow()))
						x--;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case E:
				
				
				
				if(y+1 < env.getHeight()) {
					Cell cforward2 = env.getCellNature(x, y+1);
					if(cforward2 != Cell.WLL && cforward2 != Cell.OUT  && cforward2 != Cell.DNC && cforward2 != Cell.DWC && cforward2 != Cell.SWORD  && cforward2 != Cell.CHESTC  && cforward2 != Cell.CHESTO && cforward2 != Cell.KEY ) {//  && !env.getCellContentBool(getCol(), getRow()+1)) {
						y++;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
					
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case S:
				
				
				
				if(x+1 < env.getWidth()) {
					Cell cforward3 = env.getCellNature(x+1, y);
					if(cforward3 != Cell.WLL && cforward3 != Cell.OUT  && cforward3 != Cell.DNC && cforward3 != Cell.DWC && cforward3 != Cell.SWORD  && cforward3 != Cell.CHESTC  && cforward3 != Cell.CHESTO && cforward3 != Cell.KEY ) {// && !env.getCellContentBool(getCol()+1, getRow())) {
						x++;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
					
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case W:
			
				if(y-1 >= 0) {
					Cell cforward4 = env.getCellNature(x, y-1);
					if(cforward4 != Cell.WLL && cforward4 != Cell.OUT  && cforward4 != Cell.DNC && cforward4 != Cell.DWC && cforward4 != Cell.SWORD  && cforward4 != Cell.CHESTC  && cforward4 != Cell.CHESTO && cforward4 != Cell.KEY ) {//  && !env.getCellContentBool(getCol(), getRow()-1))
						y--;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}					
				else {
					//System.out.println("There is void !");
				}
				break;
				
		}
	}

	@Override
	public void strafeR() throws PreConditionException{
		
	
		
		switch(dir) {
		
			case N:
				
				
				
				if(x+1 < env.getWidth()) {
					Cell cforward1 = env.getCellNature(x+1, y);
					if(cforward1 != Cell.WLL && cforward1 != Cell.OUT  && cforward1 != Cell.DNC && cforward1 != Cell.DWC && cforward1 != Cell.SWORD  && cforward1 != Cell.CHESTC  && cforward1 != Cell.CHESTO && cforward1 != Cell.KEY ) {//  && !env.getCellContentBool(getCol()+1, getRow())) {
						x++;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
					
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case E:
				
					
				
				if(y-1 >= 0) {
					Cell cforward2 = env.getCellNature(x, y-1);
					if(cforward2 != Cell.WLL && cforward2 != Cell.OUT  && cforward2 != Cell.DNC && cforward2 != Cell.DWC && cforward2 != Cell.SWORD  && cforward2 != Cell.CHESTC  && cforward2 != Cell.CHESTO && cforward2 != Cell.KEY ) {//  && !env.getCellContentBool(getCol(), getRow()-1))
						y--;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}					
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case S:
				
				
				
				if(x-1 >= 0) {
					Cell cforward3 = env.getCellNature(x-1, y);
					if(cforward3 != Cell.WLL && cforward3 != Cell.OUT  && cforward3 != Cell.DNC && cforward3 != Cell.DWC && cforward3 != Cell.SWORD  && cforward3 != Cell.CHESTC  && cforward3 != Cell.CHESTO && cforward3 != Cell.KEY ) {// && !env.getCellContentBool(getCol()-1, getRow()))
						x--;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case W:
				
				
				
				if(y+1 < env.getHeight()) {
					Cell cforward4 = env.getCellNature(x, y+1);
					if(cforward4 != Cell.WLL && cforward4 != Cell.OUT  && cforward4 != Cell.DNC && cforward4 != Cell.DWC && cforward4 != Cell.SWORD  && cforward4 != Cell.CHESTC  && cforward4 != Cell.CHESTO && cforward4 != Cell.KEY ) {// && !env.getCellContentBool(getCol(), getRow()+1)) {
						y++;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
					
				else {
					//System.out.println("There is void !");
				}
				break;
		}
	}

	@Override
	public void backward() throws PreConditionException {
		
	
		
		switch(dir) {
			
			case N:
				
				
				
				if(y-1 >= 0) {
					Cell cforward1 = env.getCellNature(x, y-1);
					if(cforward1 != Cell.WLL && cforward1 != Cell.OUT  && cforward1 != Cell.DNC && cforward1 != Cell.DWC && cforward1 != Cell.SWORD  && cforward1 != Cell.CHESTC  && cforward1 != Cell.CHESTO && cforward1 != Cell.KEY ) {// && !env.getCellContentBool(getCol(), getRow()-1))
						y--;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}					
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case E:
				
			
				if(x-1 >= 0) {
					Cell cforward2 = env.getCellNature(x-1, y);
					if(cforward2 != Cell.WLL && cforward2 != Cell.OUT  && cforward2 != Cell.DNC && cforward2 != Cell.DWC && cforward2 != Cell.SWORD  && cforward2 != Cell.CHESTC  && cforward2 != Cell.CHESTO && cforward2 != Cell.KEY  ) {// && !env.getCellContentBool(getCol()-1, getRow()))
						x--;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case S:
				
			
				
				if(y+1 < env.getHeight()) {
					Cell cforward3 = env.getCellNature(x, y+1);
					if(cforward3 != Cell.WLL && cforward3 != Cell.OUT  && cforward3 != Cell.DNC && cforward3 != Cell.DWC && cforward3 != Cell.SWORD  && cforward3 != Cell.CHESTC  && cforward3 != Cell.CHESTO && cforward3 != Cell.KEY ) {// && !env.getCellContentBool(getCol(), getRow()+1)) {
						y++;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
					
				else {
					//System.out.println("There is void !");
				}
				break;
				
			case W:
				
				
				
				if(x+1 < env.getWidth()) {
					Cell cforward4 = env.getCellNature(x+1, y);
					if(cforward4 != Cell.WLL && cforward4 != Cell.OUT  && cforward4 != Cell.DNC && cforward4 != Cell.DWC && cforward4 != Cell.SWORD  && cforward4 != Cell.CHESTC  && cforward4 != Cell.CHESTO && cforward4 != Cell.KEY ) {// && !env.getCellContentBool(getCol()+1, getRow())) {
						x++;
					}
					else {
						//System.out.println("It's a wall / door / entity");
					}
				}
					
				else {
					//System.out.println("There is void !");
				}
				break;
		}
		
	}

}
