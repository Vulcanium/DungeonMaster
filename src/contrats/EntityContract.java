package contrats;

import implems.Dir;
import services.EntityService;
import services.EnvironmentService;
import services.MobService;

public class EntityContract extends EntityDecorator{

	public EntityContract(MobService ms, EntityService es) {
		super(ms, es);		
	}
	
	public int getHp() {
		
		//Traitement
		return super.getHp();
	}
	
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp) throws PreConditionException, PostConditionException{
		
		// \pre hp > 0
		if(! (hp > 0)) {
			throw new PreConditionException("Erreur pre-condition init entity !\n");
		}
		
		//Traitement
		super.init(env, x, y, dir, hp);
		
		// \post getHp() == hp
		if(! (getHp() == hp) ) {
			throw new PostConditionException("Erreur post-condition init entity!\n");
		}
		
	}
	
	public void step() throws PostConditionException, PreConditionException {
		
		//Traitement
		super.step();
	}

}
