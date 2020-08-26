package contrats;

import implems.Dir;
import services.CowService;
import services.EntityService;
import services.EnvironmentService;
import services.MobService;

public abstract class CowDecorator extends EntityDecorator implements CowService {
	
	CowService cs;

	protected CowDecorator(MobService ms, EntityService es, CowService cs) {
		super(ms, es);
		this.cs = cs;
	}
	
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp) throws PreConditionException{
		cs.init(env, x, y, dir, hp);
	}
	
	public void step() throws PostConditionException{
		cs.step();
	}

}
