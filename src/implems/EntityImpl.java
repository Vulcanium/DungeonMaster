package implems;

import contrats.PreConditionException;
import services.EntityService;
import services.EnvironmentService;

public class EntityImpl extends MobImpl implements EntityService{

	private int hp;
	
	@Override
	public int getHp() {
		
		return hp;
	}

	@Override
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp){
		
		super.init(env, x, y, dir);
		this.hp = hp;		
	}

	@Override
	public void step() throws PreConditionException {} //sera redéfinie par les sous entités
	
}
