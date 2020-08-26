package contrats;

import implems.EngineImpl;
import implems.Option;
import services.EnvironmentService;
import services.MapService;
import services.MobService;

public abstract class EnvironmentDecorator extends MapDecorator implements EnvironmentService{
	
	private EnvironmentService es;
	
	protected EnvironmentDecorator(MapService ms, EnvironmentService es) {
		super(ms);
		this.es = es;
	}
	
	public Option<MobService> getCellContent(int x, int y){
		return es.getCellContent(x, y);
	}
	
	public boolean getCellContentBool(int x, int y){
		return es.getCellContentBool(x, y);
	}
	
	public void closeDoor(int x, int y) throws PreConditionException{
		es.closeDoor(x, y);
	}

}
