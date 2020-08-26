package services;

import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Cell;
import implems.Dir;
import implems.Option;

public interface MonsterService extends EntityService { //includes
	
	/* Observators */
	
	public int getDegats(); // \const
	public PlayerService getCible();
	
	// \pre x \in {-1, 0, 1} and y \in {-1, +3}}
	public Option<MobService> getContent(int x, int y) throws PreConditionException;
		
	// \pre x \in {-1, 0, 1} and y \in {-1, +3}}
	public Cell getNature(int x, int y) throws PreConditionException;
	
	// \pre x \in {-1, 0, 1} and y \in {-1, +3}}
	public boolean getViewable(int x, int y) throws PreConditionException;
	
	/* Invariants */
	
	// \inv (getFace() == N) => (getContent(u, v) == getEnv().getCellContent(getCol()+u, getRow()+v))
	// \inv (getFace() == N) => (getNature(u, v) == getEnv().getCellNature(getCol()+u, getRow()+v))
	// \inv (getFace() == S) => (getContent(u, v) == getEnv().getCellContent(getCol()-u, getRow()-v))
	// \inv (getFace() == S) => (getNature(u, v) == getEnv().getCellNature(getCol()-u, getRow()-v))
	// \inv (getFace() == E) => (getContent(u, v) == getEnv().getCellContent(getCol()+v, getRow()-u))
	// \inv (getFace() == E) => (getNature(u, v) == getEnv().getCellNature(getCol()+v, getRow()-u))
	// \inv (getFace() == W) => (getContent(u, v) == getEnv().getCellContent(getCol()-v, getRow()+u))
	// \inv (getFace() == W) => (getNature(u, v) == getEnv().getCellNature(getCol()-v, getRow()+u))
	// \inv \forall u:int, v:int \with u, v \in [-1, 1], \not getViewable(u, v)
	// \inv getViewable(-1, 2) == (getNature(-1, 1) \not \in {WLL, DWC, DNC})
	// \inv getViewable(0, 2) == (getNature(0, 1) \not \in {WLL, DWC, DNC})
	// \inv getViewable(1, 2) == (getNature(1, 1) \not \in {WLL, DWC, DNC})
	// \inv getViewable(-1, 3) == (getNature(-1, 2) \not \in {WLL, DWC, DNC}) and getViewable(-1, 2)
	// \inv getViewable(0, 3) == (getNature(0, 2) \not \in {WLL, DWC, DNC}) and getViewable(0, 2)
	// \inv getViewable(1, 3) == (getNature(1, 2) \not \in {WLL, DWC, DNC}) and getViewable(1, 2)
	
	/* Constructors */
	
	// \pre degats > 0
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp, int degats) throws PreConditionException, PostConditionException;
	// \post getDegats() == degats
	
	/* Operators */
	
	/* \pre (getCible() != null) && ( (getCol() == getCible().getCol()-1 && getRow() == getCible().getRow()) 
	 * || (getCol() == getCible().getCol()+1 && getRow() == getCible().getRow())
	 * || (getCol() == getCible().getCol() && getRow() == getCible().getRow()-1)
	 * || (getCol() == getCible().getCol() && getRow() == getCible().getRow()+1) )
	 */
	public void attack() throws PreConditionException, PostConditionException;
	// \post getCible().getHp() == getCible().getHp()@pre - getDegats()
	
	@Override
	public void step() throws PostConditionException, PreConditionException;
	// \post (getContent(getRow()-1, getCol())@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()-1, getCol())) && getFace() == S )
	// \post (getContent(getRow()+1, getCol())@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+1, getCol())) && getFace() == N )
	// \post (getContent(getRow()+2, getCol())@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+2, getCol())) && (getFace() == N) && (getRow() == getRow()@pre+1) )
	// \post (getContent(getRow()+3, getCol())@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+3, getCol())) && (getFace() == N) && (getRow() == getRow()@pre+1) )
	// \post (getContent(getRow()-1, getCol()-1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()-1, getCol()-1)) && ((getFace() == S && getCol() == getCol()@pre-1) || (getFace() == W && getRow() == getRow()@pre-1)) )
	// \post (getContent(getRow()-1, getCol()+1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()-1, getCol()+1)) && ((getFace() == S && getCol() == getCol()@pre+1) || (getFace() == E && getRow() == getRow()@pre-1)) )
	// \post (getContent(getRow(), getCol()+1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow(), getCol()+1)) && getFace() == E )
	// \post (getContent(getRow(), getCol()-1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow(), getCol()-1)) && getFace() == W )
	// \post (getContent(getRow()+1, getCol()+1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+1, getCol()+1)) && ((getFace() == N && getCol() == getCol()@pre+1) || (getFace() == E && getRow() == getRow()@pre+1)) )
	// \post (getContent(getRow()+2, getCol()+1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+2, getCol()+1)) && ((getFace() == N && getCol() == getCol()@pre+1) || (getFace() == E && getRow() == getRow()@pre+1)) )
	// \post (getContent(getRow()+3, getCol()+1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+3, getCol()+1)) && ((getFace() == N && getCol() == getCol()@pre+1) || (getFace() == E && getRow() == getRow()@pre+1)) )
	// \post (getContent(getRow()+1, getCol()-1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+1, getCol()-1)) && ((getFace() == N && getCol() == getCol()@pre-1) || (getFace() == W && getRow() == getRow()@pre+1)) )
	// \post (getContent(getRow()+2, getCol()-1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+2, getCol()-1)) && ((getFace() == N && getCol() == getCol()@pre-1) || (getFace() == W && getRow() == getRow()@pre+1)) )
	// \post (getContent(getRow()+3, getCol()-1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+3, getCol()-1)) && ((getFace() == N && getCol() == getCol()@pre-1) || (getFace() == W && getRow() == getRow()@pre+1)) )
	
}
