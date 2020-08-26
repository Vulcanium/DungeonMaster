package implems;

import services.MapService;
import services.PlayerService;

public class MapImpl implements MapService{
	
	private int height, width;
	protected Cell[][] map;
	private PlayerService player;

	@Override
	public int getHeight() {
		
		return height;
	}

	@Override
	public int getWidth() {
		
		return width;
	}

	@Override
	public PlayerService getPlayer() {
		
		return player;
	}
	
	@Override
	public Cell getCellNature(int x, int y) {
		
		return map[x][y];
	}
	
	public Cell[][] getMap(){ //Pour recuperer la grille dans EditMapImpl
		return map;
	}

	@Override
	public void init(int w, int h) {
		
		width = w;
		height = h;
		map = new Cell[w][h];		
	
	}	
		
		

	@Override
	public void openDoor(int x, int y) {
		
		if(getCellNature(x, y) == Cell.DWC)map[x][y] = Cell.DWO;
		if(getCellNature(x, y) == Cell.DNC)map[x][y] = Cell.DNO;
		if(getCellNature(x, y) == Cell.OUT)map[x][y] = Cell.OUTO;
		
		
	}

	@Override
	public void closeDoor(int x, int y) {
		
		if(getCellNature(x, y) == Cell.DWO)map[x][y] = Cell.DWC;
		if(getCellNature(x, y) == Cell.DNO)map[x][y] = Cell.DNC;
		if(getCellNature(x, y) == Cell.OUTO)map[x][y] = Cell.OUT;
	}
	
	@Override
	public void openChest(int x, int y) {
		
		if(getCellNature(x, y) == Cell.CHESTC)map[x][y] = Cell.CHESTO;
		
	}

	@Override
	public void closeChest(int x, int y) {
		
		if(getCellNature(x, y) == Cell.CHESTO)map[x][y] = Cell.CHESTC;
		
	}

}
