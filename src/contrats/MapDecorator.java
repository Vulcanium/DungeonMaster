package contrats;

import implems.Cell;
import services.MapService;
import services.PlayerService;

public abstract class MapDecorator implements MapService {
	private MapService ms;
	
	protected MapDecorator(MapService ms) {
		this.ms = ms;
	}
	
	public int getHeight() {
		return ms.getHeight();
	}
	
	public int getWidth() {
		return ms.getWidth();
	}
	
	public PlayerService getPlayer() {
		return ms.getPlayer();
	}
	
	public Cell getCellNature(int x, int y) throws PreConditionException{
		return ms.getCellNature(x, y);
	}
	
	public void init(int w, int h) throws PreConditionException, PostConditionException{
		ms.init(w, h);
	}
	
	public void openDoor(int x, int y) throws PreConditionException, PostConditionException{
		ms.openDoor(x, y);
	}
	
	public void closeDoor(int x, int y) throws PreConditionException, PostConditionException{
		ms.closeDoor(x, y);
	}
	
	public void openChest(int x, int y) throws PreConditionException, PostConditionException{
		ms.openChest(x, y);
	}
	
	public void closeChest(int x, int y) throws PreConditionException, PostConditionException{
		ms.closeChest(x, y);
	}
}
