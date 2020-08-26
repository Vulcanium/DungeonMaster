package contrats;

import implems.Dir;
import services.EntityService;
import services.EnvironmentService;
import services.MobService;

public abstract class EntityDecorator extends MobDecorator implements EntityService {

	EntityService es;
	
	protected EntityDecorator(MobService ms, EntityService es) {
		super(ms);
		this.es = es;
	}

	@Override
	public int getHp() {
		return es.getHp();
	}

	@Override
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp)
			throws PreConditionException, PostConditionException {
		es.init(env, x, y, dir, hp);
	}

	@Override
	public void step() throws PostConditionException, PreConditionException {
		es.step();
	}

}
