package contrats;

import java.util.Random;

import implems.Cell;
import implems.Command;
import implems.Dir;
import implems.Option;
import implems.Weapons;
import services.EntityService;
import services.MobService;
import services.PlayerService;

public class PlayerContract extends PlayerDecorator {

	public PlayerContract(MobService ms, EntityService es, PlayerService ps) {
		super(ms, es, ps);		
	}
	
	public void checkInvariant() throws InvariantException, PreConditionException{ 
		
		// \inv (getFace() == N) => (getContent(u, v) == getEnv().getCellContent(getCol()+u, getRow()+v))
		Random r = new Random(); //pas sûr
		int u = r.nextInt(2) - 1, v = r.nextInt(2) - 1;
		
		if(getFace() == Dir.N && (getContent(u, v) != getEnv().getCellContent(getCol() + u, getRow() + v) ) ){
			throw new InvariantException("Erreur invariant 1 !\\n");
		}
		
		// \inv (getFace() == N) => (getNature(u, v) == getEnv().getCellNature(getCol()+u, getRow()+v))
		if(getFace() == Dir.N && (getNature(u, v) != getEnv().getCellNature(getCol() + u, getRow() + v) ) ){
			throw new InvariantException("Erreur invariant 2 !\\n");
		}
		
		// \inv (getFace() == S) => (getContent(u, v) == getEnv().getCellContent(getCol()-u, getRow()-v))
		if(getFace() == Dir.S && (getContent(u, v) != getEnv().getCellContent(getCol() - u, getRow() - v) ) ){
			throw new InvariantException("Erreur invariant 3 !\\n");
		}		
		
		// \inv (getFace() == S) => (getNature(u, v) == getEnv().getCellNature(getCol()-u, getRow()-v))
		if(getFace() == Dir.S && (getNature(u, v) != getEnv().getCellNature(getCol() - u, getRow() - v) ) ){
			throw new InvariantException("Erreur invariant 4 !\\n");
		}
		
		// \inv (getFace() == E) => (getContent(u, v) == getEnv().getCellContent(getCol()+v, getRow()-u))
		if(getFace() == Dir.E && (getContent(u, v) != getEnv().getCellContent(getCol() + u, getRow() - v) ) ){
			throw new InvariantException("Erreur invariant 5 !\\n");
		}
		
		// \inv (getFace() == N) => (getNature(u, v) == getEnv().getCellNature(getCol()+v, getRow()-u))
		if(getFace() == Dir.N && (getNature(u, v) != getEnv().getCellNature(getCol() + u, getRow() - v) ) ){
			throw new InvariantException("Erreur invariant 6 !\\n");
		}
		
		// \inv (getFace() == W) => (getContent(u, v) == getEnv().getCellContent(getCol()-v, getRow()+u))
		if(getFace() == Dir.W && (getContent(u, v) != getEnv().getCellContent(getCol() - u, getRow() + v) ) ){
			throw new InvariantException("Erreur invariant 7 !\\n");
		}
		
		// \inv (getFace() == W) => (getNature(u, v) == getEnv().getCellNature(getCol()-v, getRow()+u))
		if(getFace() == Dir.W && (getNature(u, v) != getEnv().getCellNature(getCol() - u, getRow() + v) ) ){
			throw new InvariantException("Erreur invariant 8 !\\n");
		}
		
		// \inv \forall u:int, v:int \with u, v \in [-1, 1], \not getViewable(u, v)
		boolean b = true;
		for(int i = -1 ; i < 1 ; i++)
			for(int j = -1 ; j < 1 ; j++)
				if(getViewable(i, j))
					b = false;
		if(!b){
			throw new InvariantException("Erreur invariant 9 !\\n");
		}
		// \inv getViewable(-1, 2) == getNature(-1, 1) \not \in {WLL, DWC, DNC}
		Cell tmp = getNature(-1,  1);
		if( ( (getViewable(-1, 2) != (tmp == Cell.WLL || tmp == Cell.DWC || tmp == Cell.DNC) ) ) ){
			throw new InvariantException("Erreur invariant 10 !\\n");
		}
		
		// \inv getViewable(0, 2) == getNature(0, 1) \not \in {WLL, DWC, DNC}
		Cell tmp2 = getNature(0,  1);
		if( ( (getViewable(0, 2) != (tmp2 == Cell.WLL || tmp2 == Cell.DWC || tmp2 == Cell.DNC) ) ) ){
			throw new InvariantException("Erreur invariant 11 !\\n");
		}
		
		// \inv getViewable(1, 2) == getNature(1, 1) \not \in {WLL, DWC, DNC}
		Cell tmp3 = getNature(1,  1);
		if( ( (getViewable(1, 2) != (tmp3 == Cell.WLL || tmp3 == Cell.DWC || tmp3 == Cell.DNC) ) ) ){
			throw new InvariantException("Erreur invariant 12 !\\n");
		}
		
		// \inv getViewable(-1, 3) == getNature(-1, 2) \not \in {WLL, DWC, DNC} and getViewable(-1, 2)
		Cell tmp4 = getNature(-1,  2);
		if(! ( (getViewable(-1, 3) == (tmp4 == Cell.WLL || tmp4 == Cell.DWC || tmp4 == Cell.DNC) ) && getViewable(-1, 2) ) )  {
			throw new InvariantException("Erreur invariant 13 !\\n");
		}
		
		// \inv getViewable(0, 3) == getNature(0, 2) \not \in {WLL, DWC, DNC} and getViewable(0, 2)
		Cell tmp5 = getNature(0,  2);
		if(! ( (getViewable(0, 3) == (tmp5 == Cell.WLL || tmp5 == Cell.DWC || tmp5 == Cell.DNC ) ) && getViewable(0, 2) ) ){
			throw new InvariantException("Erreur invariant 14 !\\n");
		}
		
		// \inv getViewable(1, 3) == getNature(1, 2) \not \in {WLL, DWC, DNC} and getViewable(1, 2)
		Cell tmp6 = getNature(1,  2);
		if(! ( (getViewable(1, 3) == (tmp6 == Cell.WLL || tmp6 == Cell.DWC || tmp6 == Cell.DNC ) ) && getViewable(1, 2) ) ){
			throw new InvariantException("Erreur invariant 15 !\\n");
		}
		
		// \inv haveKeyAndTreasure() == haveTreasure() and haveKey()
		if( !( haveKeyAndTreasure() == (haveTreasure() && haveKey()) ) ) {
			throw new InvariantException("Erreur invariant 16 !\\n");
		}
		
	}
	
	public Option<Command> getLastCom(){
		
		//Traitement
		return super.getLastCom();		
	}
	
	public Option<MobService> getContent(int x, int y) throws PreConditionException{
		
		// \pre x \in {-1, 0, 1} and y \in {-1, +3}}
		if(! ( (x == -1 || x == 0 || x == 1 ) && (y == -1 || y == 0 || y == 1 || y == 2 || y == 3) ) ){
			throw new PreConditionException("Erreur pre-condition getContent !\n");
		}
	
		//Traitement
		return super.getContent(x, y);
	}

	public Cell getNature(int x, int y) throws PreConditionException{
		
		// \pre x \in {-1, 0, 1} and y \in {-1, +3}}
		if(! ( (x == -1 || x == 0 || x == 1 ) && (y == -1 || y == 0 || y == 1 || y == 2 || y == 3) ) ){
			throw new PreConditionException("Erreur pre-condition getContent !\n");
		}
		
		//Traitement
		return super.getNature(x, y);			
	}

	public boolean getViewable(int x, int y) throws PreConditionException{
		
		// \pre x \in {-1, 0, 1} and y \in {-1, +3}}
		if(! ( (x == -1 || x == 0 || x == 1 ) && (y == -1 || y == 0 || y == 1 || y == 2 || y == 3) ) ){
			throw new PreConditionException("Erreur pre-condition getContent !\n");
		}
		
		//Traitement
		return super.getViewable(x, y);		
	}
	
	public void step() throws PostConditionException, PreConditionException{		
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
		
		//captures
		Option<Command> command_atpre = getLastCom();
		int row_atpre = getRow();
		int col_atpre = getCol();
		Dir dir_atpre = getFace();
		Option<Command> cmdFF = new Option<>(Command.FF);
		Option<Command> cmdBB = new Option<>(Command.BB);
		Option<Command> cmdLL = new Option<>(Command.LL);
		Option<Command> cmdRR = new Option<>(Command.RR);
		Option<Command> cmdTL = new Option<>(Command.TL);
		Option<Command> cmdTR = new Option<>(Command.TR);
		Option<Command> cmdATK = new Option<>(Command.ATK);
				
		//Traitement
		super.step();
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
		
		// \post (getLastCom()@pre == FF) => (step() == forward())    voir si equals
		if( command_atpre == cmdFF && ( (getRow() != row_atpre+1 && dir_atpre == Dir.N) || (getCol() != col_atpre+1 && dir_atpre == Dir.E)
									|| (getRow() != row_atpre-1 && dir_atpre == Dir.S) || (getCol() != col_atpre-1 && dir_atpre == Dir.W) ) ){
			throw new PostConditionException("Erreur post-condition 1 de step !\n");
		}
				
		// \post (getLastCom()@pre == BB) => (step() == backward())
		if( command_atpre == cmdBB && ( (getRow() != row_atpre+1 && dir_atpre == Dir.S) || (getCol() != col_atpre+1 && dir_atpre == Dir.W)
				|| (getRow() != row_atpre-1 && dir_atpre == Dir.N) || (getCol() != col_atpre-1 && dir_atpre == Dir.E) ) ){
					throw new PostConditionException("Erreur post-condition 2 de step !\n");
		}
				
		// \post (getLastCom()@pre == LL) => (step() == strafeL())
		if( command_atpre == cmdLL && ( (getCol() != col_atpre+1 && dir_atpre == Dir.S) || (getRow() != row_atpre-1 && dir_atpre == Dir.W)
				|| (getCol() != col_atpre-1 && dir_atpre == Dir.N) || (getRow() != row_atpre+1 && dir_atpre == Dir.E) ) ){
			throw new PostConditionException("Erreur post-condition 3 de step !\n");
		}
				
		// \post (getLastCom()@pre == RR) => (step() == strafeR())
		if( command_atpre == cmdRR && ( (getCol() != col_atpre-1 && dir_atpre == Dir.S) || (getRow() != row_atpre+1 && dir_atpre == Dir.W)
				|| (getCol() != col_atpre+1 && dir_atpre == Dir.N) || (getRow() != row_atpre-1 && dir_atpre == Dir.E) ) ){
			throw new PostConditionException("Erreur post-condition 4 de step !\n");
		}
				
		// \post (getLastCom()@pre == TL) => (step() == turnL()) //on aurait pu factoriser 
		if( command_atpre == cmdTL && ( ( (getCol() != col_atpre || getRow() != row_atpre || getFace() != Dir.E) && dir_atpre == Dir.S) 
				|| ( (getCol() != col_atpre || getRow() != row_atpre || getFace() != Dir.S) && dir_atpre == Dir.W)
				|| ( (getCol() != col_atpre || getRow() != row_atpre || getFace() != Dir.W) && dir_atpre == Dir.N) 
				|| ( (getCol() != col_atpre || getRow() != row_atpre || getFace() != Dir.N) && dir_atpre == Dir.E) ) ){
			throw new PostConditionException("Erreur post-condition 5 de step !\n");
		}
				
		// \post (getLastCom()@pre == TR) => (step() == turnR())
		if( command_atpre == cmdTR && ( ( (getCol() != col_atpre || getRow() != row_atpre || getFace() != Dir.W) && dir_atpre == Dir.S) 
				|| ( (getCol() != col_atpre || getRow() != row_atpre || getFace() != Dir.N) && dir_atpre == Dir.W)
				|| ( (getCol() != col_atpre || getRow() != row_atpre || getFace() != Dir.E) && dir_atpre == Dir.N) 
				|| ( (getCol() != col_atpre || getRow() != row_atpre || getFace() != Dir.S) && dir_atpre == Dir.E) ) ){
			throw new PostConditionException("Erreur post-condition 6 de step !\n");
		}
				
		// \post (getLastCom()@pre == ATK) => (getCol() == getCol@pre && getRow() == getRow@pre && getFace() == getFace()@pre && attack())
		if( !( (command_atpre == cmdATK) && (getCol() == col_atpre && getRow() == row_atpre && getFace() == dir_atpre) ) ) {
			throw new PostConditionException("Erreur post-condition 7 de step !\n");
		}
			
		// \post (getNature(getRow(), getCol()) \in {CHESTO}) => haveTreasure()
		if( !( (getNature(getRow(), getCol()) == Cell.CHESTO) && haveTreasure() ) ) {
			throw new PostConditionException("Erreur post-condition 8 de step !\n");
		}
				
		// \post (getNature(getRow(), getCol()) \in {KEY}) => haveKey()
		if( !( (getNature(getRow(), getCol()) == Cell.KEY) && haveKey() ) ) {
			throw new PostConditionException("Erreur post-condition 9 de step !\n");
		}
		
	}

	public void attack() throws PreConditionException, PostConditionException{
	
		/* \pre (getCible() != null) && ( (getCol() == getCible().getCol()-1 && getRow() == getCible().getRow() && getFace() == W) 
		 * || (getCol() == getCible().getCol()+1 && getRow() == getCible().getRow() && getFace() == E)
		 * || (getCol() == getCible().getCol() && getRow() == getCible().getRow()-1 && getFace() == S)
		 * || (getCol() == getCible().getCol() && getRow() == getCible().getRow()+1 && getFace() == N) )
		 */
		if( !( (getCible()!= null) && ( (getCol() == getCible().getCol()-1 && getRow() == getCible().getRow() && getFace() == Dir.W) 
				|| (getCol() == getCible().getCol()+1 && getRow() == getCible().getRow() && getFace() == Dir.E) 
				|| (getCol() == getCible().getCol() && getRow() == getCible().getRow()-1 && getFace() == Dir.S) 
				|| (getCol() == getCible().getCol() && getRow() == getCible().getRow()+1 && getFace() == Dir.N) ) ) ) {
			
			throw new PreConditionException("Erreur pre-condition attack player !\n");
		}
			
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException e) {			
			e.printStackTrace();
		}
			
		//Captures
		int getHp_atpre = getCible().getHp(); 
		
		//Traitement
		super.attack();
			
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException e) {			
			e.printStackTrace();
		}
			
		/* \post ((getWeapon() == EMPTY) => (getCible().getHp() == getCible().getHp()@pre - 1))
		 * || ((getWeapon() == DAGGER) => (getCible().getHp() == getCible().getHp()@pre - 5))
		 * || ((getWeapon() == SWORD) => (getCible().getHp() == getCible().getHp()@pre - 10))
		 * || ((getWeapon() == AXE) => (getCible().getHp() == getCible().getHp()@pre - 10))
		 * || ((getWeapon() == WOODEN_STICK) => (getCible().getHp() == getCible().getHp()@pre - 2))
		 */
		if( !( ((getWeapon() == Weapons.EMPTY) && (getCible().getHp() == getHp_atpre - 1))
				|| ((getWeapon() == Weapons.DAGGER) && (getCible().getHp() == getHp_atpre - 5))
				|| ((getWeapon() == Weapons.SWORD) && (getCible().getHp() == getHp_atpre - 10)) 
				|| ((getWeapon() == Weapons.AXE) && (getCible().getHp() == getHp_atpre - 10))
				|| ((getWeapon() == Weapons.WOODEN_STICK) && (getCible().getHp() == getHp_atpre - 2)) ) ) {
			
			throw new PostConditionException("Erreur post-condition attack player !\n");
		}
		
	}
	
	@Override
	public void takeWeaponOrKey() throws PreConditionException, PostConditionException {
		
		/* \pre ( (getFace() == N => (getNature(getCol(), getRow() + 1) == SWORD && getWeapon() != SWORD) || (getNature(getCol(), getRow() + 1) == AXE && getWeapon() != AXE) || (getNature(getCol(), getRow() + 1) == DAGGER && getWeapon() != DAGGER) || (getNature(getCol(), getRow() + 1) == WOODEN_STICK && getWeapon() != WOODEN_STICK))
		 *	   	|| (getFace() == E => (getNature(getCol() + 1, getRow()) == SWORD && getWeapon() != SWORD) || (getNature(getCol() + 1, getRow()) == AXE && getWeapon() != AXE) || (getNature(getCol() + 1, getRow()) == DAGGER && getWeapon() != DAGGER) || (getNature(getCol() + 1, getRow()) == WOODEN_STICK && getWeapon() != WOODEN_STICK))
		 *		|| (getFace() == S => (getNature(getCol(), getRow() - 1) == SWORD && getWeapon() != SWORD) || (getNature(getCol(), getRow() - 1) == AXE && getWeapon() != AXE) || (getNature(getCol(), getRow() - 1) == DAGGER && getWeapon() != DAGGER) || (getNature(getCol(), getRow() - 1) == WOODEN_STICK && getWeapon() != WOODEN_STICK))
		 *		|| (getFace() == W => (getNature(getCol() - 1, getRow()) == SWORD && getWeapon() != SWORD) || (getNature(getCol() - 1, getRow()) == AXE && getWeapon() != AXE) || (getNature(getCol() - 1, getRow()) == DAGGER && getWeapon() != DAGGER) || (getNature(getCol() - 1, getRow()) == WOODEN_STICK && getWeapon() != WOODEN_STICK)) )
		 */
		if( !( ( (getFace() == Dir.N && ((getNature(getCol(), getRow() + 1) == Cell.SWORD && getWeapon() != Weapons.SWORD) || (getNature(getCol(), getRow() + 1) == Cell.AXE && getWeapon() != Weapons.AXE) || (getNature(getCol(), getRow() + 1) == Cell.DAGGER && getWeapon() != Weapons.DAGGER) || (getNature(getCol(), getRow() + 1) == Cell.WOODEN_STICK && getWeapon() != Weapons.WOODEN_STICK)))
				|| (getFace() == Dir.E && ((getNature(getCol() + 1, getRow()) == Cell.SWORD && getWeapon() != Weapons.SWORD) || (getNature(getCol() + 1, getRow()) == Cell.AXE && getWeapon() != Weapons.AXE) || (getNature(getCol() + 1, getRow()) == Cell.DAGGER && getWeapon() != Weapons.DAGGER) || (getNature(getCol() + 1, getRow()) == Cell.WOODEN_STICK && getWeapon() != Weapons.WOODEN_STICK)))
				|| (getFace() == Dir.S && ((getNature(getCol(), getRow() - 1) == Cell.SWORD && getWeapon() != Weapons.SWORD) || (getNature(getCol(), getRow() - 1) == Cell.AXE && getWeapon() != Weapons.AXE) || (getNature(getCol(), getRow() - 1) == Cell.DAGGER && getWeapon() != Weapons.DAGGER) || (getNature(getCol(), getRow() - 1) == Cell.WOODEN_STICK && getWeapon() != Weapons.WOODEN_STICK)))
				|| (getFace() == Dir.W && ((getNature(getCol() - 1, getRow()) == Cell.SWORD && getWeapon() != Weapons.SWORD) || (getNature(getCol() - 1, getRow()) == Cell.AXE && getWeapon() != Weapons.AXE) || (getNature(getCol() - 1, getRow()) == Cell.DAGGER && getWeapon() != Weapons.DAGGER) || (getNature(getCol() - 1, getRow()) == Cell.WOODEN_STICK && getWeapon() != Weapons.WOODEN_STICK))) )
		) ) {
			throw new PreConditionException("Erreur pre-condition takeWeapon !\n");
		}
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException e) {			
			e.printStackTrace();
		}
		
		
		//Captures
		Cell nature_north_atpre = getNature(getCol(), getRow()+1);
		Cell nature_east_atpre = getNature(getCol()+1, getRow());
		Cell nature_south_atpre = getNature(getCol(), getRow()-1);
		Cell nature_west_atpre = getNature(getCol()-1, getRow());
		
		//Traitement
		super.takeWeaponOrKey();
		
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException e) {			
			e.printStackTrace();
		}
		
		
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
		if( !( ( (getFace() == Dir.N && nature_north_atpre == Cell.SWORD) && (getNature(getCol(), getRow() + 1) == Cell.EMP && getWeapon() == Weapons.SWORD)
				 || (getFace() == Dir.N && nature_north_atpre == Cell.DAGGER) && (getNature(getCol(), getRow() + 1) == Cell.EMP && getWeapon() == Weapons.DAGGER)
				 || (getFace() == Dir.N && nature_north_atpre == Cell.AXE) && (getNature(getCol(), getRow() + 1) == Cell.EMP && getWeapon() == Weapons.AXE)
				 || (getFace() == Dir.N && nature_north_atpre == Cell.WOODEN_STICK) && (getNature(getCol(), getRow() + 1) == Cell.EMP && getWeapon() == Weapons.WOODEN_STICK)
				     
				 || (getFace() == Dir.E && nature_east_atpre == Cell.SWORD) && (getNature(getCol() + 1, getRow()) == Cell.EMP && getWeapon() == Weapons.SWORD)
				 || (getFace() == Dir.E && nature_east_atpre == Cell.DAGGER) && (getNature(getCol() + 1, getRow()) == Cell.EMP && getWeapon() == Weapons.DAGGER)
				 || (getFace() == Dir.E && nature_east_atpre == Cell.AXE) && (getNature(getCol() + 1, getRow()) == Cell.EMP && getWeapon() == Weapons.AXE)
				 || (getFace() == Dir.E && nature_east_atpre == Cell.WOODEN_STICK) && (getNature(getCol() + 1, getRow()) == Cell.EMP && getWeapon() == Weapons.WOODEN_STICK)
				 
				 || (getFace() == Dir.S && nature_south_atpre == Cell.SWORD) && (getNature(getCol(), getRow() - 1) == Cell.EMP && getWeapon() == Weapons.SWORD)
				 || (getFace() == Dir.S && nature_south_atpre == Cell.DAGGER) && (getNature(getCol(), getRow() - 1) == Cell.EMP && getWeapon() == Weapons.DAGGER)
				 || (getFace() == Dir.S && nature_south_atpre == Cell.AXE) && (getNature(getCol(), getRow() - 1) == Cell.EMP && getWeapon() == Weapons.AXE)
				 || (getFace() == Dir.S && nature_south_atpre == Cell.WOODEN_STICK) && (getNature(getCol(), getRow() - 1) == Cell.EMP && getWeapon() == Weapons.WOODEN_STICK)
				 
				 || (getFace() == Dir.W && nature_west_atpre == Cell.SWORD) && (getNature(getCol() - 1, getRow()) == Cell.EMP && getWeapon() == Weapons.SWORD)
				 || (getFace() == Dir.W && nature_west_atpre == Cell.DAGGER) && (getNature(getCol() - 1, getRow()) == Cell.EMP && getWeapon() == Weapons.DAGGER)
				 || (getFace() == Dir.W && nature_west_atpre == Cell.AXE) && (getNature(getCol() - 1, getRow()) == Cell.EMP && getWeapon() == Weapons.AXE)
				 || (getFace() == Dir.W && nature_west_atpre == Cell.WOODEN_STICK) && (getNature(getCol() - 1, getRow()) == Cell.EMP && getWeapon() == Weapons.WOODEN_STICK) ) 
		) ) {
			throw new PostConditionException("Erreur post-condition takeWeapon !\n");
		}
		
	}
	

	@Override
	public void dropWeapon() throws PreConditionException, PostConditionException {
		
		/* \pre (getWeapon() != EMPTY) && ( (getFace() == N => getNature(getCol(), getRow() + 1) == EMP)
		 *									|| (getFace() == E => getNature(getCol() + 1, getRow()) == EMP)
		 *									|| (getFace() == S => getNature(getCol(), getRow() - 1) == EMP)
		 *									|| (getFace() == W => getNature(getCol() - 1, getRow()) == EMP) )
		 */
		if( !( (getWeapon() != Weapons.EMPTY) && ( (getFace() == Dir.N && getNature(getCol(), getRow() + 1) == Cell.EMP)
												|| (getFace() == Dir.E && getNature(getCol() + 1, getRow()) == Cell.EMP)
												|| (getFace() == Dir.S && getNature(getCol(), getRow() - 1) == Cell.EMP)
												|| (getFace() == Dir.W && getNature(getCol() - 1, getRow()) == Cell.EMP) ) 
		 ) ) {
			throw new PreConditionException("Erreur pre-condition dropWeapon !\n");
		}
		
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException e) {			
			e.printStackTrace();
		}
		
		
		//Capture
		Weapons weapon_atpre = getWeapon();
		
		//Traitement
		super.dropWeapon();
		
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException e) {			
			e.printStackTrace();
		}
		
		
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
		if( !( (getWeapon() == Weapons.EMPTY) && ( (getFace() == Dir.N && weapon_atpre == Weapons.SWORD) && (getNature(getCol(), getRow() + 1) == Cell.SWORD) 
												|| (getFace() == Dir.N && weapon_atpre == Weapons.AXE) && (getNature(getCol(), getRow() + 1) == Cell.AXE) 
												|| (getFace() == Dir.N && weapon_atpre == Weapons.DAGGER) && (getNature(getCol(), getRow() + 1) == Cell.DAGGER) 
												|| (getFace() == Dir.N && weapon_atpre == Weapons.WOODEN_STICK) && (getNature(getCol(), getRow() + 1) == Cell.WOODEN_STICK) 
												
												|| (getFace() == Dir.E && weapon_atpre == Weapons.SWORD) && (getNature(getCol() + 1, getRow()) == Cell.SWORD) 
												|| (getFace() == Dir.E && weapon_atpre == Weapons.AXE) && (getNature(getCol() + 1, getRow()) == Cell.AXE) 
												|| (getFace() == Dir.E && weapon_atpre == Weapons.DAGGER) && (getNature(getCol() + 1, getRow()) == Cell.DAGGER) 
												|| (getFace() == Dir.E && weapon_atpre == Weapons.WOODEN_STICK) && (getNature(getCol() + 1, getRow()) == Cell.WOODEN_STICK)
												
												|| (getFace() == Dir.S && weapon_atpre == Weapons.SWORD) && (getNature(getCol(), getRow() - 1) == Cell.SWORD) 
												|| (getFace() == Dir.S && weapon_atpre == Weapons.AXE) && (getNature(getCol(), getRow() - 1) == Cell.AXE) 
												|| (getFace() == Dir.S && weapon_atpre == Weapons.DAGGER) && (getNature(getCol(), getRow() - 1) == Cell.DAGGER) 
												|| (getFace() == Dir.S && weapon_atpre == Weapons.WOODEN_STICK) && (getNature(getCol(), getRow() - 1) == Cell.WOODEN_STICK)
												
												|| (getFace() == Dir.W && weapon_atpre == Weapons.SWORD) && (getNature(getCol() - 1, getRow()) == Cell.SWORD) 
												|| (getFace() == Dir.W && weapon_atpre == Weapons.AXE) && (getNature(getCol() - 1, getRow()) == Cell.AXE) 
												|| (getFace() == Dir.W && weapon_atpre == Weapons.DAGGER) && (getNature(getCol() - 1, getRow()) == Cell.DAGGER) 
												|| (getFace() == Dir.W && weapon_atpre == Weapons.WOODEN_STICK) && (getNature(getCol() - 1, getRow()) == Cell.WOODEN_STICK) )
				
		) ) {
			throw new PostConditionException("Erreur post-condition dropWeapon !\n");
		}
		
	}

}
