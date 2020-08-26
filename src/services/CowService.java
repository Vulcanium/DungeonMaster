package services;

import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Dir;

public interface CowService extends EntityService { //includes
	
	/*Observators*/
	
	//H�rit�s de EntityService
	
	/*Invariants*/
	
	//H�rit�s de EntityService
	
	/*Constructors*/
	
	// \pre 4 >= hp >= 3
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp) throws PreConditionException;

	/*Operators*/
	
	@Override
	public void step() throws PostConditionException;
	// \post getCol()@pre - 1 <= getCol() <= getCol()@pre + 1
	// \post getRow()@pre - 1 <= getRow() <= getRow()@pre + 1
}
