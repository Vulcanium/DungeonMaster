package contrats;

import implems.Cell;
import implems.Dir;
import implems.Option;
import services.EntityService;
import services.EnvironmentService;
import services.MobService;
import services.MonsterService;
import services.PlayerService;

public abstract class MonsterDecorator extends EntityDecorator implements MonsterService {
	
	MonsterService monstServ;

	protected MonsterDecorator(MobService ms, EntityService es, MonsterService monstServ) {
		super(ms, es);
		this.monstServ = monstServ;
	}

	@Override
	public int getDegats() {
		return monstServ.getDegats();
	}

	@Override
	public PlayerService getCible() {
		return monstServ.getCible();
	}

	@Override
	public Option<MobService> getContent(int x, int y) throws PreConditionException {
		return monstServ.getContent(x, y);
	}

	@Override
	public Cell getNature(int x, int y) throws PreConditionException {
		return monstServ.getNature(x, y);
	}

	@Override
	public boolean getViewable(int x, int y) throws PreConditionException {
		return monstServ.getViewable(x, y);
	}

	@Override
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp, int degats)
			throws PreConditionException, PostConditionException {
		monstServ.init(env, x, y, dir, hp, degats);
	}

	@Override
	public void attack() throws PreConditionException, PostConditionException {
		monstServ.attack();
	}
	
	@Override
	public void step() throws PostConditionException, PreConditionException {
		monstServ.step();
	}

}
