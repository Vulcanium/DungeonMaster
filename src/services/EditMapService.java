package services;

import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Cell;

public interface EditMapService extends MapService { //refines
	
	/*Observators*/
	
	// \pre getCellNature(x1, y1) != WLL and getCellNature(x2, y2) != WLL
	public boolean isReachable(int x1, int y1, int x2, int y2) throws PreConditionException;
	
	public boolean isReady();
	
	/*Invariants*/
	
	//il existe un chemin entre les 2 cases de coordonnées (x1, y1) et (x2, y2)
	/* \inv isReachable(x1, y1, x2, y2) == (\exists P \in [Pair<Integer,Integer>], P[0] == <x1, y1> and P[P.length - 1] = <x2, y2>)
	 * and \forall i:int \with i \in [1;P.length - 1], (P[i-1] = <u, v> and P[i] == <s, t>) => ((u-s)**2 + (v-t)**2) == 1
	 * and \forall i:int \with i \in [1;P.length - 2], P[i-1] = <u, v> => getCellNature(u, v) != WLL  
	 */
	
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
	
	/*Constructors*/
	//vide
	
	/*Operators*/
	
	// \pre 0 <= x < getWidth() and 0 <= y < getHeight()
	public void setNature(int x, int y, Cell cell) throws PreConditionException, PostConditionException;
	// \post getCellNature(x, y) == cell 
	
	/* \post (\forall u:int, v:int \with u != x or v != y) 
	 * => getCellNature(u, v) == getCellNature(u,v)@pre
	 */

}
