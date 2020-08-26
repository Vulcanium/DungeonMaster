package contrats;

import implems.Dir;
import services.EnvironmentService;
import services.MobService;

public abstract class MobDecorator implements MobService {

	MobService ms;
	
	protected MobDecorator(MobService ms) {
		this.ms = ms;
	}
	
	@Override
	public EnvironmentService getEnv() {
		return ms.getEnv();
	}

	@Override
	public int getCol() {
		return ms.getCol();
	}

	@Override
	public int getRow() {
		return ms.getRow();
	}

	@Override
	public Dir getFace() {
		return ms.getFace();
	}

	@Override
	public void init(EnvironmentService env, int x, int y, Dir dir)
			throws PreConditionException, PostConditionException {
		ms.init(env, x, y, dir);
	}

	@Override
	public void forward() throws PostConditionException, PreConditionException {
		ms.forward();
	}

	@Override
	public void backward() throws PostConditionException, PreConditionException {
		ms.backward();
	}

	@Override
	public void turnL() throws PostConditionException, PreConditionException {
		ms.turnL();
	}

	@Override
	public void turnR() throws PostConditionException, PreConditionException {
		ms.turnR();
	}

	@Override
	public void strafeL() throws PostConditionException, PreConditionException {
		ms.strafeL();
	}

	@Override
	public void strafeR() throws PostConditionException, PreConditionException {
		ms.strafeR();
	}

}
