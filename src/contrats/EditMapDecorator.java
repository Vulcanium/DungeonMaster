package contrats;

import implems.Cell;
import services.EditMapService;
import services.MapService;

public abstract class EditMapDecorator extends MapDecorator implements EditMapService {
	
	private EditMapService ems;
	
	protected EditMapDecorator(MapService ms, EditMapService ems) {
		super(ms);
		this.ems = ems;
	}

	@Override
	public boolean isReachable(int x1, int y1, int x2, int y2) throws PreConditionException {
		return ems.isReachable(x1, y1, x2, y2);
	}

	@Override
	public boolean isReady() {
		return ems.isReady();
	}

	@Override
	public void setNature(int x, int y, Cell cell) throws PreConditionException, PostConditionException{
		ems.setNature(x, y, cell);
	}

}
