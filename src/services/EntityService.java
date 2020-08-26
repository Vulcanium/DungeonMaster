package services;

import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Dir;

public interface EntityService extends MobService { //includes
	
	/*Observators*/
	
	public int getHp();
	
	/* Invariants */
	
	//H�rit�s de MobService
	
	/* Constructors */
	
	// \pre hp > 0
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp) throws PreConditionException, PostConditionException;
	// \post getHp() == hp
	
	/* Operators */
	
	public void step() throws PostConditionException, PreConditionException;
}
