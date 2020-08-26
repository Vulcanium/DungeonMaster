package services;

import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Cell;
import implems.Command;
import implems.Option;
import implems.Weapons;

public interface PlayerService extends EntityService { //includes
	
	/* Observators */
	
	public Option<Command> getLastCom();
	public Weapons getWeapon();
	public EntityService getCible();
	public boolean haveKey();
	public boolean haveTreasure();
	public boolean haveKeyAndTreasure();
	
	// \pre x \in {-1, 0, 1} and y \in {-1, +3}}
	public Option<MobService> getContent(int x, int y) throws PreConditionException; //pas sur si renvoie String ou Option<MobService>
	
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
	// \inv haveKeyAndTreasure() == haveTreasure() and haveKey()
	
	/* Constructors */
	
	//H�rit�s de EntityService
	
	/* Operators */
	
	@Override
	public void step() throws PostConditionException, PreConditionException;
	// \post (getLastCom()@pre == FF) => (step() == forward())
	// \post (getLastCom()@pre == BB) => (step() == backward())
	// \post (getLastCom()@pre == LL) => (step() == strafeL())
	// \post (getLastCom()@pre == RR) => (step() == strafeR())
	// \post (getLastCom()@pre == TL) => (step() == turnL())
	// \post (getLastCom()@pre == TR) => (step() == turnR())
	// \post (getLastCom()@pre == ATK) => (getCol() == getCol@pre && getRow() == getRow@pre && getFace() == getFace()@pre && attack())
	// \post (getNature(getRow(), getCol()) \in {CHESTO}) => haveTreasure()
	// \post (getNature(getRow(), getCol()) \in {KEY}) => haveKey()
	
	
	/* \pre (getCible() != null) && ( (getCol() == getCible().getCol()-1 && getRow() == getCible().getRow() && getFace() == W) 
	 * || (getCol() == getCible().getCol()+1 && getRow() == getCible().getRow() && getFace() == E)
	 * || (getCol() == getCible().getCol() && getRow() == getCible().getRow()-1 && getFace() == S)
	 * || (getCol() == getCible().getCol() && getRow() == getCible().getRow()+1 && getFace() == N) )
	 */
	public void attack() throws PreConditionException, PostConditionException;
	/* \post ((getWeapon() == EMPTY) => (getCible().getHp() == getCible().getHp()@pre - 1))
	 * || ((getWeapon() == DAGGER) => (getCible().getHp() == getCible().getHp()@pre - 5))
	 * || ((getWeapon() == SWORD) => (getCible().getHp() == getCible().getHp()@pre - 10))
	 * || ((getWeapon() == AXE) => (getCible().getHp() == getCible().getHp()@pre - 10))
	 * || ((getWeapon() == WOODEN_STICK) => (getCible().getHp() == getCible().getHp()@pre - 2))
	 */
	
	
	/* \pre ( (getFace() == N => (getNature(getCol(), getRow() + 1) == SWORD && getWeapon() != SWORD) || (getNature(getCol(), getRow() + 1) == AXE && getWeapon() != AXE) || (getNature(getCol(), getRow() + 1) == DAGGER && getWeapon() != DAGGER) || (getNature(getCol(), getRow() + 1) == WOODEN_STICK && getWeapon() != WOODEN_STICK))
	 *	   	|| (getFace() == E => (getNature(getCol() + 1, getRow()) == SWORD && getWeapon() != SWORD) || (getNature(getCol() + 1, getRow()) == AXE && getWeapon() != AXE) || (getNature(getCol() + 1, getRow()) == DAGGER && getWeapon() != DAGGER) || (getNature(getCol() + 1, getRow()) == WOODEN_STICK && getWeapon() != WOODEN_STICK))
	 *		|| (getFace() == S => (getNature(getCol(), getRow() - 1) == SWORD && getWeapon() != SWORD) || (getNature(getCol(), getRow() - 1) == AXE && getWeapon() != AXE) || (getNature(getCol(), getRow() - 1) == DAGGER && getWeapon() != DAGGER) || (getNature(getCol(), getRow() - 1) == WOODEN_STICK && getWeapon() != WOODEN_STICK))
	 *		|| (getFace() == W => (getNature(getCol() - 1, getRow()) == SWORD && getWeapon() != SWORD) || (getNature(getCol() - 1, getRow()) == AXE && getWeapon() != AXE) || (getNature(getCol() - 1, getRow()) == DAGGER && getWeapon() != DAGGER) || (getNature(getCol() - 1, getRow()) == WOODEN_STICK && getWeapon() != WOODEN_STICK)) )
	 */
	public void takeWeaponOrKey() throws PreConditionException, PostConditionException;
	/* \post ( (getFace() == N && getNature(getCol(), getRow() + 1)@pre == SWORD) => (getNature(getCol(), getRow() + 1) == EMP && getWeapon() == SWORD)
	 * 		|| (getFace() == N && getNature(getCol(), getRow() + 1)@pre == DAGGER) => (getNature(getCol(), getRow() + 1) == EMP && getWeapon() == DAGGER)
	 *      || (getFace() == N && getNature(getCol(), getRow() + 1)@pre == AXE) => (getNature(getCol(), getRow() + 1) == EMP && getWeapon() == AXE)
	 *      || (getFace() == N && getNature(getCol(), getRow() + 1)@pre == WOODEN_STICK) => (getNature(getCol(), getRow() + 1) == EMP && getWeapon() == WOODEN_STICK)
	 *      
	 *		|| (getFace() == E && getNature(getCol() + 1, getRow())@pre == SWORD) => (getNature(getCol() + 1, getRow()) == EMP && getWeapon() == SWORD)
	 *		|| (getFace() == E && getNature(getCol() + 1, getRow())@pre == DAGGER) => (getNature(getCol() + 1, getRow()) == EMP && getWeapon() == DAGGER)
	 *		|| (getFace() == E && getNature(getCol() + 1, getRow())@pre == AXE) => (getNature(getCol() + 1, getRow()) == EMP && getWeapon() == AXE)
	 *		|| (getFace() == E && getNature(getCol() + 1, getRow())@pre == WOODEN_STICK) => (getNature(getCol() + 1, getRow()) == EMP && getWeapon() == WOODEN_STICK)
	 *
	 *		|| (getFace() == S && getNature(getCol(), getRow() - 1)@pre == SWORD) => (getNature(getCol(), getRow() - 1) == EMP && getWeapon() == SWORD)
	 *		|| (getFace() == S && getNature(getCol(), getRow() - 1)@pre == DAGGER) => (getNature(getCol(), getRow() - 1) == EMP && getWeapon() == DAGGER)
	 *		|| (getFace() == S && getNature(getCol(), getRow() - 1)@pre == AXE) => (getNature(getCol(), getRow() - 1) == EMP && getWeapon() == AXE)
	 *		|| (getFace() == S && getNature(getCol(), getRow() - 1)@pre == WOODEN_STICK) => (getNature(getCol(), getRow() - 1) == EMP && getWeapon() == WOODEN_STICK)
	 *
	 *		|| (getFace() == W && getNature(getCol() - 1, getRow())@pre == SWORD) => (getNature(getCol() - 1, getRow()) == EMP && getWeapon() == SWORD)
	 *		|| (getFace() == W && getNature(getCol() - 1, getRow())@pre == DAGGER) => (getNature(getCol() - 1, getRow()) == EMP && getWeapon() == DAGGER)
	 *		|| (getFace() == W && getNature(getCol() - 1, getRow())@pre == AXE) => (getNature(getCol() - 1, getRow()) == EMP && getWeapon() == AXE)
	 *		|| (getFace() == W && getNature(getCol() - 1, getRow())@pre == WOODEN_STICK) => (getNature(getCol() - 1, getRow()) == EMP && getWeapon() == WOODEN_STICK) )
	 */
	
	
	/* \pre (getWeapon() != EMPTY) && ( (getFace() == N => getNature(getCol(), getRow() + 1) == EMP)
	 *									|| (getFace() == E => getNature(getCol() + 1, getRow()) == EMP)
	 *									|| (getFace() == S => getNature(getCol(), getRow() - 1) == EMP)
	 *									|| (getFace() == W => getNature(getCol() - 1, getRow()) == EMP) )
	 */
	public void dropWeapon() throws PreConditionException, PostConditionException;
	/* \post (getWeapon() == EMPTY) && ( (getFace() == N && getWeapon()@pre == SWORD) => (getNature(getCol(), getRow() + 1) == SWORD) 
	 * 									|| (getFace() == N && getWeapon()@pre == AXE) => (getNature(getCol(), getRow() + 1) == AXE) 
	 * 									|| (getFace() == N && getWeapon()@pre == DAGGER) => (getNature(getCol(), getRow() + 1) == DAGGER) 
	 * 									|| (getFace() == N && getWeapon()@pre == WOODEN_STICK) => (getNature(getCol(), getRow() + 1) == WOODEN_STICK)
	 * 
	 *									|| (getFace() == E && getWeapon()@pre == SWORD) => (getNature(getCol() + 1, getRow()) == SWORD) 
	 *									|| (getFace() == E && getWeapon()@pre == AXE) => (getNature(getCol() + 1, getRow()) == AXE)
	 *									|| (getFace() == E && getWeapon()@pre == DAGGER) => (getNature(getCol() + 1, getRow()) == DAGGER) 
	 *									|| (getFace() == E && getWeapon()@pre == WOODEN_STICK) => (getNature(getCol() + 1, getRow()) == WOODEN_STICK)
	 *
	 *									|| (getFace() == S && getWeapon()@pre == SWORD) => (getNature(getCol(), getRow() - 1) == SWORD) 
	 *									|| (getFace() == S && getWeapon()@pre == AXE) => (getNature(getCol(), getRow() - 1) == AXE) 
	 *									|| (getFace() == S && getWeapon()@pre == DAGGER) => (getNature(getCol(), getRow() - 1) == DAGGER) 
	 *									|| (getFace() == S && getWeapon()@pre == WOODEN_STICK) => (getNature(getCol(), getRow() - 1) == WOODEN_STICK)
	 *
	 *									|| (getFace() == W && getWeapon()@pre == SWORD) => (getNature(getCol() - 1, getRow()) == SWORD) 
	 *									|| (getFace() == W && getWeapon()@pre == AXE) => (getNature(getCol() - 1, getRow()) == AXE) 
	 *									|| (getFace() == W && getWeapon()@pre == DAGGER) => (getNature(getCol() - 1, getRow()) == DAGGER) 
	 *									|| (getFace() == W && getWeapon()@pre == WOODEN_STICK) => (getNature(getCol() - 1, getRow()) == WOODEN_STICK) )
	 */
}