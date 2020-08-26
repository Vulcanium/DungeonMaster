package contrats;

import java.util.Random;

import implems.Cell;
import implems.Dir;
import implems.Option;
import services.EntityService;
import services.EnvironmentService;
import services.MobService;
import services.MonsterService;
import services.PlayerService;

public class MonsterContract extends MonsterDecorator {

	public MonsterContract(MobService ms, EntityService es, MonsterService monstServ) {
		super(ms, es, monstServ);
	}

	public void checkInvariant() throws InvariantException, PreConditionException{
		
		// \inv (getFace() == N) => (getContent(u, v) == getEnv().getCellContent(getCol()+u, getRow()+v))
		Random r = new Random();
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
	
	
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp, int degats) throws PreConditionException, PostConditionException{
		
		// \pre degats > 0
		if(degats <= 0) {
			throw new PreConditionException("Erreur pre-condition init monster !\n");
		}
		
		//Traitement
		super.init(env, x, y, dir, hp, degats);
		
		// \post getDegats() == degats
		if(getDegats() != degats) {
			throw new PostConditionException("Erreur post-condition init monster !\n");
		}
		
	}
	
	
	public void attack() throws PreConditionException, PostConditionException{
		
		/* \pre (getCible() != null) && ( (getCol() == getCible().getCol()-1 && getRow() == getCible().getRow()) 
		 * || (getCol() == getCible().getCol()+1 && getRow() == getCible().getRow())
		 * || (getCol() == getCible().getCol() && getRow() == getCible().getRow()-1)
		 * || (getCol() == getCible().getCol() && getRow() == getCible().getRow()+1) )
		 */
		if( !( (getCible()!= null) && ( (getCol() == getCible().getCol()-1 && getRow() == getCible().getRow()) 
										|| (getCol() == getCible().getCol()+1 && getRow() == getCible().getRow()) 
										|| (getCol() == getCible().getCol() && getRow() == getCible().getRow()-1) 
										|| (getCol() == getCible().getCol() && getRow() == getCible().getRow()+1) ) ) ) {
			
			throw new PreConditionException("Erreur pre-condition attack monster !\n");
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
		
		// \post getCible().getHp() == getCible().getHp()@pre - getDegats()
		if(getCible().getHp() != getHp_atpre - getDegats()) {
			throw new PostConditionException("Erreur post-condition attack monster !\n");
		}
		
	}
	
	
	@Override
	public void step() throws PostConditionException, PreConditionException{
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
		
		//Captures
		Option<MobService> content_atpre_row_neg = getContent(getRow()-1, getCol());
		Option<MobService> content_atpre_row_pos1 = getContent(getRow()+1, getCol());
		Option<MobService> content_atpre_row_pos2 = getContent(getRow()+2, getCol());
		Option<MobService> content_atpre_row_pos3 = getContent(getRow()+3, getCol());
		Option<MobService> content_atpre_row_neg_col_neg = getContent(getRow()-1, getCol()-1);
		Option<MobService> content_atpre_row_neg_col_pos = getContent(getRow()-1, getCol()+1);
		Option<MobService> content_atpre_col_pos = getContent(getRow(), getCol()+1);
		Option<MobService> content_atpre_col_neg = getContent(getRow(), getCol()-1);
		Option<MobService> content_atpre_row_pos1_col_pos = getContent(getRow()+1, getCol()+1);
		Option<MobService> content_atpre_row_pos2_col_pos = getContent(getRow()+2, getCol()+1);
		Option<MobService> content_atpre_row_pos3_col_pos = getContent(getRow()+3, getCol()+1);
		Option<MobService> content_atpre_row_pos1_col_neg = getContent(getRow()+1, getCol()-1);
		Option<MobService> content_atpre_row_pos2_col_neg = getContent(getRow()+2, getCol()-1);
		Option<MobService> content_atpre_row_pos3_col_neg = getContent(getRow()+3, getCol()-1);
		
		int col_atpre = getCol();
		int row_atpre = getRow();
		
		//Traitement
		super.step();
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
		
		// \post (getContent(getRow()-1, getCol())@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()-1, getCol())) && getFace() == S )
		if( !( content_atpre_row_neg.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()-1, getCol())) && getFace() == Dir.S ) ) ) {
			throw new PostConditionException("Erreur post-condition 1 step monster !\n");
		}
		
		// \post (getContent(getRow()+1, getCol())@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+1, getCol())) && getFace() == N )
		if( !( content_atpre_row_pos1.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()+1, getCol())) && getFace() == Dir.N ) ) ) {
			throw new PostConditionException("Erreur post-condition 2 step monster !\n");
		}
		
		// \post (getContent(getRow()+2, getCol())@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+2, getCol())) && (getFace() == N) && (getRow() == getRow()@pre+1) )
		if( !( content_atpre_row_pos2.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()+2, getCol())) && (getFace() == Dir.N) && (getRow() == row_atpre+1) ) ) ) {
			throw new PostConditionException("Erreur post-condition 3 step monster !\n");
		}
		
		// \post (getContent(getRow()+3, getCol())@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+3, getCol())) && (getFace() == N) && (getRow() == getRow()@pre+1) )
		if( !( content_atpre_row_pos3.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()+3, getCol())) && (getFace() == Dir.N) && (getRow() == row_atpre+1) ) ) ) {
			throw new PostConditionException("Erreur post-condition 4 step monster !\n");
		}
		
		// \post (getContent(getRow()-1, getCol()-1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()-1, getCol()-1)) && ((getFace() == S && getCol() == getCol()@pre-1) || (getFace() == W && getRow() == getRow()@pre-1)) )
		if( !( content_atpre_row_neg_col_neg.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()-1, getCol()-1)) && ((getFace() == Dir.S && getCol() == col_atpre-1) || (getFace() == Dir.W && getRow() == row_atpre-1)) ) ) ) {
			throw new PostConditionException("Erreur post-condition 5 step monster !\n");
		}
		
		// \post (getContent(getRow()-1, getCol()+1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()-1, getCol()+1)) && ((getFace() == S && getCol() == getCol()@pre+1) || (getFace() == E && getRow() == getRow()@pre-1)) )
		if( !( content_atpre_row_neg_col_pos.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()-1, getCol()+1)) && ((getFace() == Dir.S && getCol() == col_atpre+1) || (getFace() == Dir.E && getRow() == row_atpre-1)) ) ) ) {
			throw new PostConditionException("Erreur post-condition 6 step monster !\n");
		}
		
		// \post (getContent(getRow(), getCol()+1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow(), getCol()+1)) && getFace() == E )
		if( !( content_atpre_col_pos.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow(), getCol()+1)) && getFace() == Dir.E ) ) ) {
			throw new PostConditionException("Erreur post-condition 7 step monster !\n");
		}
		
		// \post (getContent(getRow(), getCol()-1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow(), getCol()-1)) && getFace() == W )
		if( !( content_atpre_col_neg.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow(), getCol()-1)) && getFace() == Dir.W ) ) ) {
			throw new PostConditionException("Erreur post-condition 8 step monster !\n");
		}
		
		// \post (getContent(getRow()+1, getCol()+1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+1, getCol()+1)) && ((getFace() == N && getCol() == getCol()@pre+1) || (getFace() == E && getRow() == getRow()@pre+1)) )
		if( !( content_atpre_row_pos1_col_pos.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()+1, getCol()+1)) && ((getFace() == Dir.N && getCol() == col_atpre+1) || (getFace() == Dir.E && getRow() == row_atpre+1)) ) ) ) {
			throw new PostConditionException("Erreur post-condition 9 step monster !\n");
		}
		
		// \post (getContent(getRow()+2, getCol()+1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+2, getCol()+1)) && ((getFace() == N && getCol() == getCol()@pre+1) || (getFace() == E && getRow() == getRow()@pre+1)) )
		if( !( content_atpre_row_pos2_col_pos.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()+2, getCol()+1)) && ((getFace() == Dir.N && getCol() == col_atpre+1) || (getFace() == Dir.E && getRow() == row_atpre+1)) ) ) ) {
			throw new PostConditionException("Erreur post-condition 10 step monster !\n");
		}
		
		// \post (getContent(getRow()+3, getCol()+1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+3, getCol()+1)) && ((getFace() == N && getCol() == getCol()@pre+1) || (getFace() == E && getRow() == getRow()@pre+1)) )
		if( !( content_atpre_row_pos3_col_pos.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()+3, getCol()+1)) && ((getFace() == Dir.N && getCol() == col_atpre+1) || (getFace() == Dir.E && getRow() == row_atpre+1)) ) ) ) {
			throw new PostConditionException("Erreur post-condition 11 step monster !\n");
		}
		
		// \post (getContent(getRow()+1, getCol()-1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+1, getCol()-1)) && ((getFace() == N && getCol() == getCol()@pre-1) || (getFace() == W && getRow() == getRow()@pre+1)) )
		if( !( content_atpre_row_pos1_col_neg.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()+1, getCol()-1)) && ((getFace() == Dir.N && getCol() == col_atpre-1) || (getFace() == Dir.W && getRow() == row_atpre+1)) ) ) ) {
			throw new PostConditionException("Erreur post-condition 12 step monster !\n");
		}
		
		// \post (getContent(getRow()+2, getCol()-1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+2, getCol()-1)) && ((getFace() == N && getCol() == getCol()@pre-1) || (getFace() == W && getRow() == getRow()@pre+1)) )
		if( !( content_atpre_row_pos2_col_neg.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()+2, getCol()-1)) && ((getFace() == Dir.N && getCol() == col_atpre-1) || (getFace() == Dir.W && getRow() == row_atpre+1)) ) ) ) {
			throw new PostConditionException("Erreur post-condition 13 step monster !\n");
		}
		
		// \post (getContent(getRow()+3, getCol()-1)@pre == So(PlayerService)) => ( (getCible() == getContent(getRow()+3, getCol()-1)) && ((getFace() == N && getCol() == getCol()@pre-1) || (getFace() == W && getRow() == getRow()@pre+1)) )
		if( !( content_atpre_row_pos3_col_neg.isMob().equals("So(PlayerService)") && ( (getCible() == (PlayerService)getContent(getRow()+3, getCol()-1)) && ((getFace() == Dir.N && getCol() == col_atpre-1) || (getFace() == Dir.W && getRow() == row_atpre+1)) ) ) ) {
			throw new PostConditionException("Erreur post-condition 14 step monster !\n");
		}
		
	}
	
}
