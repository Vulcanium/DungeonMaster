package contrats;

import implems.Cell;
import services.MapService;

public class MapContract extends MapDecorator {

	public MapContract(MapService ms) {
		super(ms);
	}
	
	
	public Cell getCellNature(int x, int y) throws PreConditionException{
		
		// \pre 0 <= x < getWidth() and 0 <= y < getHeight()
		if(! (((0<= x) && (x < getWidth()) && ((0<=y) && (y < getHeight())))) ){
			throw new PreConditionException("Erreur pre-condition getCellNature !\n");
		}
		//Traitement
		return super.getCellNature(x, y);
	}
	
	
	public void init(int w, int h) throws PreConditionException, PostConditionException{
		
		// \pre 0 < w and 0 < h
		if(! (0<w && 0<h) ){
			throw new PreConditionException("Erreur pre-condition init !\n");
		}
		
		//Traitement
		super.init(w, h);
		
		// \post getHeight() == h	
		if(! (getHeight() == h)){
			throw new PostConditionException("Erreur post-condition getHeight du init !\n");
		}
		
		// \post getWidth() == w
		if(! (getWidth() == w)){
			throw new PostConditionException("Erreur post-condition getWidth du init !\n");
		}
	}
	
	
	
	public void openDoor(int x, int y) throws PreConditionException, PostConditionException{
			
		// \pre getCellNature(x, y) \in {DNC, DWC} or (getCellNature(x, y) \in {OUT} and getPlayer().haveKeyAndTreasure())
		if(! ( ((getCellNature(x, y) == Cell.DNC) ||  (getCellNature(x, y) == Cell.DWC)) 
				|| (getCellNature(x, y) == Cell.OUT && getPlayer().haveKeyAndTreasure()) ) ){
			throw new PreConditionException("Erreur pre-condition openDoor !\n");
		}
		
		//Captures
		Cell cellNature_pre = getCellNature(x, y);
		
		int height_pre = getHeight();
		
		int width_pre = getWidth();

		Cell[][] allCells_pre = new Cell[getWidth()][getHeight()];
		
		for(int u = 0; u < getWidth(); u++){
			for(int v = 0; v < getHeight(); v++){
				if(u != x && v != y){
					allCells_pre[u][v] = getCellNature(u, v); 
				}
			}
		}
		
		
		//Traitement
		super.openDoor(x, y);
		
		// \post (getCellNature(x, y)@pre == DWC) => (getCellNature(x, y) == DWO)
		if( (cellNature_pre == Cell.DWC) && (!(getCellNature(x, y) == Cell.DWO)) ){ //Pas sûr, peut être qu'il faudrait faire un (not(A) ou B)
			throw new PostConditionException("Erreur post-condition getCellNature(x, y) == DWO de openDoor!\n");
		}
		
		// \post (getCellNature(x, y)@pre == DNC) => (getCellNature(x, y) == DNO)
		if( (cellNature_pre == Cell.DNC) && (!(getCellNature(x, y) == Cell.DNO)) ){ //Pas sûr, peut être qu'il faudrait faire un (not(A) ou B)
			throw new PostConditionException("Erreur post-condition getCellNature(x, y) == DNO de openDoor!\n");
		}
		
		// \post (getCellNature(x, y)@pre == OUT) => (getCellNature(x, y) == OUTO)
		if( (cellNature_pre == Cell.OUT) && (!(getCellNature(x, y) == Cell.OUTO)) ){ //Pas sûr, peut être qu'il faudrait faire un (not(A) ou B)
			throw new PostConditionException("Erreur post-condition getCellNature(x, y) == OUTO de openDoor!\n");
		}
		
		/* \post (\forall u:int \with u \in [0; getWidth()-1]
		 *		 \forall v:int \with \in [0; getHeight()-1]
		 *		 \with (u != x or v != y) )
		 *		 => getCellNature(u, v) == getCellNature(u, v)@pre
		 */
		for(int u = 0; u < getWidth(); u++){
			for(int v = 0; v < getHeight(); v++){
				if(u != x && v != y){
					if( ! (allCells_pre[u][v] == getCellNature(u, v) ) )throw new PostConditionException("Erreur post-condition getCellNature_pre(u, v) == getCellNature(u, v) de openDoor!\n");
				}
			}
		}
		
		// \post getHeight() == getHeight()@pre and getWidth() == getWidth()@pre
		if( (getHeight() != height_pre) || (getWidth() != width_pre) ){
			throw new PostConditionException("Erreur post-condition getHeight() == getHeight()_pre and getWidth() == getWidth()_pre de openDoor!\n");
		}
	}		
	
	
	
	public void closeDoor(int x, int y) throws PreConditionException, PostConditionException{
		
		// \pre getCellNature(x, y) \in {DNO, DWO}
		if(! ( (getCellNature(x, y) == Cell.DNO) ||  (getCellNature(x, y) == Cell.DWO) ) ){
			throw new PreConditionException("Erreur pre-condition closeDoor !\n");
		}
		
		//Captures
		Cell cellNature_pre = getCellNature(x, y);
		
		int height_pre = getHeight();
		
		int width_pre = getWidth();

		Cell[][] allCells_pre = new Cell[getWidth()][getHeight()];
		
		for(int u = 0; u < getWidth(); u++){
			for(int v = 0; v < getHeight(); v++){
				if(u != x && v != y){
					allCells_pre[u][v] = getCellNature(u, v); 
				}
			}
		}
		
		
		//Traitement
		super.closeDoor(x, y);
		
		// \post (getCellNature(x, y)@pre == DWO) => (getCellNature(x, y) == DWC)
		if( (cellNature_pre == Cell.DWO) && (!(getCellNature(x, y) == Cell.DWC)) ){ //Pas sûr, peut être qu'il faudrait faire un (not(A) ou B)
			throw new PostConditionException("Erreur post-condition getCellNature(x, y) == DWC de closeDoor!\n");
		}
		
		// \post (getCellNature(x, y)@pre == DNO) => (getCellNature(x, y) == DNC)
		if( (cellNature_pre == Cell.DNO) && (!(getCellNature(x, y) == Cell.DNC)) ){ //Pas sûr, peut être qu'il faudrait faire un (not(A) ou B)
			throw new PostConditionException("Erreur post-condition getCellNature(x, y) == DNC de closeDoor!\n");
		}
		
		/* \post (\forall u:int \with u \in [0; getWidth()-1]
		 *		 \forall v:int \with \in [0; getHeight()-1]
		 *		 \with (u != x or v != y) )
		 *		 => getCellNature(u, v) == getCellNature(u, v)@pre
		 */
		for(int u = 0; u < getWidth(); u++){
			for(int v = 0; v < getHeight(); v++){
				if(u != x && v != y){
					if( ! (allCells_pre[u][v] == getCellNature(u, v) ) )throw new PostConditionException("Erreur post-condition getCellNature_pre(u, v) == getCellNature(u, v) de closeDoor!\n");
				}
			}
		}
		
		// \post getHeight() == getHeight()@pre and getWidth() == getWidth()@pre
		if( (getHeight() != height_pre) || (getWidth() != width_pre) ){
			throw new PostConditionException("Erreur post-condition getHeight() == getHeight()_pre and getWidth() == getWidth()_pre de closeDoor!\n");
		}
	}
	

	@Override
	public void openChest(int x, int y) throws PreConditionException, PostConditionException{
		
		// \pre getCellNature(x, y) \in {CHESTC}
		if(getCellNature(x, y) != Cell.CHESTC) {
			throw new PreConditionException("Erreur pre-condition openChest !\n");
		}
		
		//Captures
		Cell cellNature_pre = getCellNature(x, y);
		
		int height_pre = getHeight();
		
		int width_pre = getWidth();

		Cell[][] allCells_pre = new Cell[getWidth()][getHeight()];
				
		for(int u = 0; u < getWidth(); u++){
			for(int v = 0; v < getHeight(); v++){
				if(u != x && v != y){
					allCells_pre[u][v] = getCellNature(u, v); 
				}
			}
		}
				
				
		//Traitement
		super.openChest(x, y);
		
		// \post (getCellNature(x, y)@pre == CHESTC) => (getCellNature(x, y) == CHESTO)
		if( (cellNature_pre == Cell.CHESTC) && (!(getCellNature(x, y) == Cell.CHESTO)) ){ //Pas sûr, peut être qu'il faudrait faire un (not(A) ou B)
			throw new PostConditionException("Erreur post-condition getCellNature(x, y) == CHESTO de openChest!\n");
		}
		
		/* \post (\forall u:int \with u \in [0; getWidth()-1]
		 *		 \forall v:int \with \in [0; getHeight()-1]
		 *		 \with (u != x or v != y) )
		 *		 => getCellNature(u, v) == getCellNature(u, v)@pre
		 */
		for(int u = 0; u < getWidth(); u++){
			for(int v = 0; v < getHeight(); v++){
				if(u != x && v != y){
					if( ! (allCells_pre[u][v] == getCellNature(u, v) ) )throw new PostConditionException("Erreur post-condition getCellNature_pre(u, v) == getCellNature(u, v) de openChest!\n");
				}
			}
		}
		
		// \post getHeight() == getHeight()@pre and getWidth() == getWidth()@pre
		if( (getHeight() != height_pre) || (getWidth() != width_pre) ){
			throw new PostConditionException("Erreur post-condition getHeight() == getHeight()_pre and getWidth() == getWidth()_pre de openChest!\n");
		}
		
	}


	@Override
	public void closeChest(int x, int y) throws PreConditionException, PostConditionException{
		
		// \pre getCellNature(x, y) \in {CHESTO}
		if(getCellNature(x, y) != Cell.CHESTO) {
			throw new PreConditionException("Erreur pre-condition closeChest !\n");
		}
		
		//Captures
		Cell cellNature_pre = getCellNature(x, y);
		
		int height_pre = getHeight();
		
		int width_pre = getWidth();

		Cell[][] allCells_pre = new Cell[getWidth()][getHeight()];
		
		for(int u = 0; u < getWidth(); u++){
			for(int v = 0; v < getHeight(); v++){
				if(u != x && v != y){
					allCells_pre[u][v] = getCellNature(u, v); 
				}
			}
		}
						
						
		//Traitement
		super.closeChest(x, y);
				
		// \post (getCellNature(x, y)@pre == CHESTO) => (getCellNature(x, y) == CHESTC)
		if( (cellNature_pre == Cell.CHESTO) && (!(getCellNature(x, y) == Cell.CHESTC)) ){ //Pas sûr, peut être qu'il faudrait faire un (not(A) ou B)
			throw new PostConditionException("Erreur post-condition getCellNature(x, y) == CHESTC de closeChest!\n");
		}		
				
		/* \post (\forall u:int \with u \in [0; getWidth()-1]
		 *		 \forall v:int \with \in [0; getHeight()-1]
		 *		 \with (u != x or v != y) )
		 *		 => getCellNature(u, v) == getCellNature(u, v)@pre
		 */
		for(int u = 0; u < getWidth(); u++){
			for(int v = 0; v < getHeight(); v++){
				if(u != x && v != y){
					if( ! (allCells_pre[u][v] == getCellNature(u, v) ) )throw new PostConditionException("Erreur post-condition getCellNature_pre(u, v) == getCellNature(u, v) de closeChest!\n");
				}
			}
		}
				
		// \post getHeight() == getHeight()@pre and getWidth() == getWidth()@pre
		if( (getHeight() != height_pre) || (getWidth() != width_pre) ){
			throw new PostConditionException("Erreur post-condition getHeight() == getHeight()_pre and getWidth() == getWidth()_pre de closeChest!\n");
		}
		
	}	
	
}
