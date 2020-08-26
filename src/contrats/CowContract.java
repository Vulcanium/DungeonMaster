package contrats;

import implems.Dir;
import services.CowService;
import services.EntityService;
import services.EnvironmentService;
import services.MobService;

public class CowContract extends CowDecorator{

	public CowContract(MobService ms, EntityService es, CowService cs) {
		super(ms, es, cs);		
	}
	
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp) throws PreConditionException{
		
		// \pre 4 >= hp >= 3
		if( !(4>= hp && hp >= 3)) {
			throw new PreConditionException("Erreur pre-condition init cow !\n");
		}		
		
		//Traitement
		super.init(env, x, y, dir, hp);
	}
	
	public void step() throws PostConditionException{
		
		//Captures
		int col_atpre = getCol();
		int row_atpre = getRow();		
		
		//Traitement
		super.step();
		
		// \post getCol()@pre - 1 <= getCol() <= getCol()@pre + 1
		if(! (col_atpre-1 <= getCol() && getCol() <= col_atpre+1) ) {
			throw new PostConditionException("Erreur post-condition 1 step cow !\n");
		}
		
		// \post getRow()@pre - 1 <= getRow() <= getRow()@pre + 1
		if(! (row_atpre-1 <= getRow() && getRow() <= row_atpre+1) ) {
			throw new PostConditionException("Erreur post-condition 2 step cow !\n");
		}
		
	}

}
