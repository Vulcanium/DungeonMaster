package contrats;

import java.util.ArrayList;

import services.EngineService;
import services.EntityService;
import services.EnvironmentService;

public abstract class EngineDecorator implements EngineService {
	
	private EngineService es;
	
	protected EngineDecorator(EngineService es) {
		this.es = es;
	}

	@Override
	public EnvironmentService getEnvi() {
		return es.getEnvi();
	}

	@Override
	public ArrayList<EntityService> getEntities() {
		return es.getEntities();
	}

	@Override
	public EntityService getEntity(int index) throws PreConditionException {
		return es.getEntity(index);
	}

	@Override
	public void init(EnvironmentService env) {
		es.init(env);
	}

	@Override
	public void removeEntity(int index) throws PreConditionException, PostConditionException {
		es.removeEntity(index);
	}

	@Override
	public void addEntity(EntityService e) throws PostConditionException, PreConditionException {
		es.addEntity(e);
	}

	@Override
	public void step() throws PreConditionException, PostConditionException {
		es.step();
	}

}
