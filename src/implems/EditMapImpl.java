package implems;

import java.util.ArrayList;

import contrats.PostConditionException;
import contrats.PreConditionException;
import services.EditMapService;

public class EditMapImpl extends MapImpl implements EditMapService {

	//private Cell[][] mapedit;
	
	private int coordXCellIn;
	private int coordYCellIn;
	private int coordXCellOut;
	private int coordYCellOut;
	private int coordXCellTreasure;
	private int coordYCellTreasure;
	private int coordXCellKey;
	private int coordYCellKey;
	
	public void init(int w, int h) {
		super.init(w, h);
		//super.map = mapedit;
	}
	
	@Override
	public boolean isReachable(int x1, int y1, int x2, int y2) throws PreConditionException { //Pas sûr
		
		ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer, Integer>>();
		
		if(x1 == x2 && y1 == y2) {
			return true;
		}
		
		pairs.add(new Pair(x1, y1));
		
		for(int i = 0; i<getHeight(); i++) {
			for(int j = 0; j<getWidth(); j++) {
				
				Cell cellOuest = getCellNature(i-1, j);
				Cell cellEst = getCellNature(i+1, j);
				Cell cellSud = getCellNature(i, j-1);
				Cell cellNord = getCellNature(i, j+1);
				
				if(cellOuest != Cell.WLL) {
					pairs.add(new Pair(i-1, j));
					if(pairs.get(i+1).getLeft() == x2 && pairs.get(i+1).getRight() == y2) return true;
					continue;
				}
				if(cellEst != Cell.WLL) {
					pairs.add(new Pair(i+1, j));
					if(pairs.get(i+1).getLeft() == x2 && pairs.get(i+1).getRight() == y2) return true;
					continue;
				}
				if(cellSud != Cell.WLL) {
					pairs.add(new Pair(i, j-1));
					if(pairs.get(i+1).getLeft() == x2 && pairs.get(i+1).getRight() == y2) return true;
					continue;
				}
				if(cellNord != Cell.WLL) {
					pairs.add(new Pair(i, j+1));
					if(pairs.get(i+1).getLeft() == x2 && pairs.get(i+1).getRight() == y2) return true;
					continue;
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean isReady() {
		
		boolean verif = false;
		Cell cellIn = null;
		Cell cellOut = null;
		Cell cellTreasure = null;
		Cell cellKey = null;
		
		for(int i = 0; i<getHeight(); i++) {
			for(int j = 0; j<getWidth(); j++) {
				
				Cell currentcell = getCellNature(i, j);
				Cell cellOuest = getCellNature(i-1, j);
				Cell cellEst = getCellNature(i+1, j);
				Cell cellSud = getCellNature(i, j-1);
				Cell cellNord = getCellNature(i, j+1);
				
				if(currentcell == Cell.DNO || currentcell == Cell.DNC) {
					if(cellOuest == Cell.EMP && cellEst == Cell.EMP && cellNord == Cell.WLL && cellSud == Cell.WLL) {
						verif = true;
					} else {
						return false;
					}
				}
				else if (currentcell == Cell.DWO || currentcell == Cell.DWC) {
					if(cellOuest == Cell.WLL && cellEst == Cell.WLL && cellNord == Cell.EMP && cellSud == Cell.EMP) {
						verif = true;
					} else {
						return false;
					}
				}
				else if (currentcell == Cell.IN) {
					if(cellIn == null) {
						cellIn = currentcell;
						coordXCellIn = i;
						coordYCellIn = j;
						verif = true;
					}
					else {
						return false;
					}
				}
				else if (currentcell == Cell.OUT) {
					if(cellOut == null) {
						cellOut = currentcell;
						coordXCellOut = i;
						coordYCellOut = j;
						verif = true;
					}
					else {
						return false;
					}
				}
				else if (currentcell == Cell.CHESTC || currentcell == Cell.CHESTO) {
					if(cellTreasure == null) {
						cellTreasure = currentcell;
						coordXCellTreasure = i;
						coordYCellTreasure = j;
						verif = true;
					}
					else {
						return false;
					}
				}
				else if (currentcell == Cell.KEY) {
					if(cellKey == null) {
						cellKey = currentcell;
						coordXCellKey = i;
						coordYCellKey = j;
						verif = true;
					}
					else {
						return false;
					}
				}
				
			}
		}
		
		if(cellIn != null && cellOut != null && cellTreasure != null && cellKey != null) {
			try {
				
				if( (isReachable(coordXCellIn, coordYCellIn, coordXCellOut, coordYCellOut)) 
						&& (isReachable(coordXCellIn, coordYCellIn, coordXCellTreasure, coordYCellTreasure))
						&& (isReachable(coordXCellIn, coordYCellIn, coordXCellKey, coordYCellKey)) ) {
					verif = true;
				} else {
					return false;
				}
						
			} catch (PreConditionException e) {
				e.printStackTrace();
			}
			
		} else {
			return false;
		}
		
		return verif;
	}

	@Override
	public void setNature(int x, int y, Cell cell) throws PreConditionException, PostConditionException {
		
		super.map[x][y] = cell;
		
	}

}
