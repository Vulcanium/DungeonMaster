package contrats;

import implems.Cell;
import implems.Command;
import implems.Option;
import implems.Weapons;
import services.EntityService;
import services.MobService;
import services.PlayerService;

public abstract class PlayerDecorator extends EntityDecorator implements PlayerService {

	PlayerService ps;
	
	protected PlayerDecorator(MobService ms, EntityService es, PlayerService ps) {
		super(ms, es);
		this.ps = ps;
	}

	@Override
	public Option<Command> getLastCom() {
		return ps.getLastCom();
	}
	
	@Override
	public Weapons getWeapon() {
		return ps.getWeapon();
	}
	
	@Override
	public EntityService getCible() {
		return ps.getCible();
	}
	
	@Override
	public boolean haveKeyAndTreasure() {
		return ps.haveKeyAndTreasure();
	}
	
	@Override
	public boolean haveKey() {
		return ps.haveKey();
	}
	
	@Override
	public boolean haveTreasure() {
		return ps.haveTreasure();
	}

	@Override
	public Option<MobService> getContent(int x, int y) throws PreConditionException {
		return ps.getContent(x, y);
	}

	@Override
	public Cell getNature(int x, int y) throws PreConditionException {
		return ps.getNature(x, y);
	}

	@Override
	public boolean getViewable(int x, int y) throws PreConditionException {
		return ps.getViewable(x, y);
	}
	
	@Override
	public void step() throws PostConditionException, PreConditionException{
		ps.step();
	}
	
	@Override
	public void attack() throws PreConditionException, PostConditionException{
		ps.attack();
	}
	
	@Override
	public void takeWeaponOrKey() throws PreConditionException, PostConditionException {
		ps.takeWeaponOrKey();
	}

	@Override
	public void dropWeapon() throws PreConditionException, PostConditionException {
		ps.dropWeapon();
	}

}
