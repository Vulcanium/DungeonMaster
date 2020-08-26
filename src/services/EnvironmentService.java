package services;

import contrats.PreConditionException;
import implems.EngineImpl;
import implems.Option;

public interface EnvironmentService extends MapService { //includes
	
	/*Observators*/
	
	public Option<MobService> getCellContent(int x, int y); //pas sur si renvoie String ou Option<MobService>
	public boolean getCellContentBool(int x, int i); //version booléenne
	
	/*Invariants*/
	//hérités de MapService
	
	/*Constructors*/
	//hérités de MapService
	
	/*Operators*/
	
	// \pre getCellContent(x, y) == No
	public void closeDoor(int x, int y) throws PreConditionException;

	

	
}
