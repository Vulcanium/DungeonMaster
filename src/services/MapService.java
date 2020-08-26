package services;

import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Cell;

public interface MapService {
	
	/*Observators*/
	
	public int getHeight(); // \const
	public int getWidth();  // \const
	public PlayerService getPlayer();
	
	// \pre 0 <= x < getWidth() and 0 <= y < getHeight()
	public Cell getCellNature(int x, int y) throws PreConditionException;
	
	/*Invariants*/
	// T
	
	/*Constructors*/
	
	// \pre 0 < w and 0 < h
	public void init(int w, int h) throws PreConditionException, PostConditionException;
	// \post getHeight() == h	
	// \post getWidth() == w
	
	/*Operators*/
	
	// \pre (getCellNature(x, y) \in {DNC, DWC}) or (getCellNature(x, y) \in {OUT} and getPlayer().haveKeyAndTreasure())
	public void openDoor(int x, int y) throws PreConditionException, PostConditionException;
	// \post (getCellNature(x, y)@pre == DWC) => (getCellNature(x, y) == DWO)
	// \post (getCellNature(x, y)@pre == DNC) => (getCellNature(x, y) == DNO)
	// \post (getCellNature(x, y)@pre == OUT) => (getCellNature(x, y) == OUTO)
	/* \post (\forall u:int \with u \in [0; getWidth()-1]
	 *		 \forall v:int \with \in [0; getHeight()-1]
	 *		 \with (u != x or v != y) )
	 *		 => getCellNature(u, v) == getCellNature(u, v)@pre
	 */
	//Pour la completude de la spécification, on précise que la case que l'on ouvre, ne modifie pas l'état des autres cases.
	
	// \post getHeight() == getHeight()@pre and getWidth() == getWidth()@pre
	//Pour la completude de la spécification, on précise que la case que l'on ouvre, ne modifie pas la taille de la map.
	
	
	// \pre getCellNature(x, y) \in {DNO, DWO}
	public void closeDoor(int x, int y) throws PreConditionException, PostConditionException;
	// \post (getCellNature(x, y)@pre == DWO) => (getCellNature(x, y) == DWC)
	// \post (getCellNature(x, y)@pre == DNO) => (getCellNature(x, y) == DNC)
	/* \post (\forall u:int \with u \in [0; getWidth()-1]
	 *		 \forall v:int \with \in [0; getHeight()-1]
	 *		 \with (u != x or v != y) )
	 *		 => getCellNature(u, v) == getCellNature(u, v)@pre
	 */
	//Pour la completude de la spécification, on précise que la case que l'on ferme, ne modifie pas l'état des autres cases.
	
	// \post getHeight() == getHeight()@pre and getWidth() == getWidth()@pre
	//Pour la completude de la spécification, on précise que la case que l'on ferme, ne modifie pas la taille de la map.
	

	// \pre getCellNature(x, y) \in {CHESTC}
	public void openChest(int x, int y) throws PreConditionException, PostConditionException;
	// \post (getCellNature(x, y)@pre == CHESTC) => (getCellNature(x, y) == CHESTO)
	/* \post (\forall u:int \with u \in [0; getWidth()-1]
	 *		 \forall v:int \with \in [0; getHeight()-1]
	 *		 \with (u != x or v != y) )
	 *		 => getCellNature(u, v) == getCellNature(u, v)@pre
	 */
	//Pour la completude de la spécification, on précise que la case que l'on ouvre, ne modifie pas l'état des autres cases.
		
	// \post getHeight() == getHeight()@pre and getWidth() == getWidth()@pre
	//Pour la completude de la spécification, on précise que la case que l'on ouvre, ne modifie pas la taille de la map.
	
	
	// \pre getCellNature(x, y) \in {CHESTO}
	public void closeChest(int x, int y) throws PreConditionException, PostConditionException;
	// \post (getCellNature(x, y)@pre == CHESTO) => (getCellNature(x, y) == CHESTC)
	/* \post (\forall u:int \with u \in [0; getWidth()-1]
	 *		 \forall v:int \with \in [0; getHeight()-1]
	 *		 \with (u != x or v != y) )
	 *		 => getCellNature(u, v) == getCellNature(u, v)@pre
	 */
	//Pour la completude de la spécification, on précise que la case que l'on ferme, ne modifie pas l'état des autres cases.
	
	// \post getHeight() == getHeight()@pre and getWidth() == getWidth()@pre
	//Pour la completude de la spécification, on précise que la case que l'on ferme, ne modifie pas la taille de la map.
	
}
