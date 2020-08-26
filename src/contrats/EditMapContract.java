package contrats;

import java.util.ArrayList;

import implems.Cell;
import implems.Pair;
import services.EditMapService;
import services.MapService;

public class EditMapContract extends EditMapDecorator {

	public EditMapContract(MapService ms, EditMapService ems) {
		super(ms, ems);
	}
	
	
	
	public boolean isReachable(int x1, int y1, int x2, int y2) throws PreConditionException{
		
		// \pre getCellNature(x1, y1) != WLL and getCellNature(x2, y2) != WLL
		if(! ( (getCellNature(x1, y1) != Cell.WLL) && (getCellNature(x2, y2) != Cell.WLL) ) ){
			throw new PreConditionException("Erreur pré-condition de isReachable !\n");
		}
		
		return super.isReachable(x1, y1, x2, y2);
	}
	
	public void checkInvariant() throws InvariantException, PreConditionException {
		/* \inv isReachable(x1, y1, x2, y2) == (\exists P \in [Pair<Integer,Integer>], P[0] == <x1, y1> and P[P.length - 1] = <x2, y2>)
		 * and \forall i:int \with i \in [1;P.length - 1], (P[i-1] = <u, v> and P[i] = <s, t>) => ((u-s)**2 + (v-t)**2) = 1
		 * and \forall i:int \with i \in [1;P.length - 2], P[i-1] = <u, v> => getCellNature(u, v) != WLL  
		 */
		
		//Comment reussir a initialiser x1, y1, x2, et y2 ?
		
		/*int x1, y1, x2, y2;
		if(! (isReachable(x1, y1, x2, y2) == (pairs.get(0).getLeft() == x1 && pairs.get(0).getRight() == y1) && (pairs.get(pairs.size()).getLeft() == x2 && pairs.get(pairs.size()).getRight() == y2)) ) {
			throw new InvariantException("Erreur invariant de minimisation du isReachable !\n");
		}*/
		
		ArrayList<Pair<Integer, Integer>> pairs = new ArrayList<Pair<Integer, Integer>>();
		for(int i = 1; i<(pairs.size()); i++){
			int u = pairs.get(i-1).getLeft();
			int v = pairs.get(i-1).getRight();
			int s = pairs.get(i).getLeft();
			int t = pairs.get(i).getRight();
			if( !( ( ((u-s) * (u-s)) + ((v-t) * (v-t)) ) == 1)){
				throw new InvariantException("Erreur invariant de minimisation du isReachable !\n");
			}
		}
			
		for(int i = 1; i<(pairs.size() - 1); i++){
			int u = pairs.get(i-1).getLeft();
			int v = pairs.get(i-1).getRight();
			if(! (getCellNature(u, v) != Cell.WLL)){
				throw new InvariantException("Erreur invariant de minimisation du isReachable !\n");
			}
		}
		
		
		/* \inv isReady() == (\exists xi:int, yi:int, xo:int, yo:int \with getCellNature(xi, yi) == IN and getCellNature(xo, yo) == OUT
		 * and isReachable(xi, yi, xo, yo)
		 * and \forall x:int, y:int \with x != xi or y != yi => getCellNature(x, y) != IN
		 * and \forall x:int, y:int \with x != xo or y != yo => getCellNature(x, y) != OUT)
		 * and (\forall x:int, y:int \with x, y \in getCellNature(x, y) \in {DNO, DNC} =>
		 * 		getCellNature(x+1, y) == getCellNature(x-1, y) == EMP)
		 * and (getCellNature(x, y-1) == getCellNature(x, y+1) == WLL))
		 * and (\forall x:int, y:int \with x, y \in getCellNature(x, y) \in {DWO, DWC} =>
		 * 		getCellNature(x+1, y) == getCellNature(x-1, y) == WLL)
		 * and (getCellNature(x, y-1) == getCellNature(x, y+1) == EMP))
		 * and \exists xt:int, yt:int \with ((xt != xi or yt != yi) and (xt != xo or yt != yo)) 
		 *      => ( (getCellNature(xt, yt) == CHESTC or getCellNature(xt, yt) == CHESTO) and isReachable(xi, yi, xt, yt) )
		 * and \exists xk:int, yk:int \with ((xk != xi or yk != yi) and (xk != xo or yk != yo)) => (getCellNature(xk, yk) == KEY and isReachable(xi, yi, xk, yk))
		 */
		
		

		
		if(! true){
			throw new InvariantException("Erreur invariant de minimisation du isReady !\n");
		}
	}
	
	public void setNature(int x, int y, Cell cell) throws PreConditionException, PostConditionException{
		
		// \pre 0 <= x < getWidth() and 0 <= y < getHeight()
		if(! ( ((0<=x) && (x < getWidth())) && ((0<=y) && (y<getHeight())) ) ){
			throw new PreConditionException("Erreur pré-condition de setNature !\n");
		}
		
		//Invariants
		try {
			checkInvariant();
		} catch (InvariantException e) {
			e.printStackTrace();
		}
		
		//Captures
		Cell[][] allCells_pre = new Cell[getWidth()][getHeight()];
		
		for(int u = 0; u < getWidth(); u++){
			for(int v = 0; v < getHeight(); v++){
				if(u != x && v != y){
					allCells_pre[u][v] = getCellNature(u, v); 
				}
			}
		}
		
		
		//Traitement
		super.setNature(x, y, cell);
		
		
		//Invariants
		try {
			checkInvariant();
		} catch (InvariantException e) {
			e.printStackTrace();
		}
		
		// \post getCellNature(x, y) == cell 
		if(getCellNature(x, y) != cell){
			throw new PostConditionException("Erreur post-condition getCellNature == cell de setNature !\n");
		}
		
		/* \post (\forall u:int, v:int \with u != x or v != y) 
		 * => getCellNature(u, v) == getCellNature(u,v)@pre
		 */
		for(int u = 0; u < getWidth(); u++){
			for(int v = 0; v < getHeight(); v++){
				if(u != x && v != y){
					if( ! (allCells_pre[u][v] == getCellNature(u, v) ) )throw new PostConditionException("Erreur post-condition getCellNature_pre(u, v) == getCellNature(u, v) de setNature !\n");
				}
			}
		}
	}
	
}
