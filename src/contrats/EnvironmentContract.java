package contrats;

import implems.EngineImpl;
import implems.Option;
import services.EnvironmentService;
import services.MapService;
import services.MobService;

public class EnvironmentContract extends EnvironmentDecorator {

	public EnvironmentContract(MapService ms, EnvironmentService es) {
		super(ms, es);
	}
	
	public Option<MobService> getCellContent(int x, int y) {
		
		//Traitement
		return super.getCellContent(x, y);
	}
	
	
	public boolean getCellContentBool(int x, int y) {
		
		//Traitement
		return super.getCellContentBool(x, y);
	}
	
	public void closeDoor(int x, int y) throws PreConditionException{
		
		
		// \pre getCellContent(x, y) == No
		if(! (getCellContent(x, y).isMob().equals("No")) ){
			throw new PreConditionException("Erreur pré-condition closeDoor de EnvironmentContract !\n");
		}
		
		//Traitement
		super.closeDoor(x, y);
	}

	

	

}
