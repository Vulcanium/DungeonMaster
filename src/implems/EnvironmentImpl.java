package implems;

import services.EntityService;
import services.EnvironmentService;
import services.MobService;

public class EnvironmentImpl extends MapImpl implements EnvironmentService{
	
	EngineImpl eng;
	
	public void init(int w, int h, EngineImpl eng) {
		super.init(w, h);
		this.eng = eng;
	}

	@Override
	public Option<MobService> getCellContent(int x, int y) {
		
//		Option<MobService> m = new Option<MobService>(x, y, eng);// à refaire, voir s'il faut une liste de mob
//		m.chercheMob(x, y);
//		return m;
		if( x >= 0 && x < getWidth() && y >= 0 && y < getHeight() && eng.getEntities() != null) {
			
			for(EntityService ent : eng.getEntities()) {
				if(ent.getCol() == x && ent.getRow() == y) {
					return new Option(ent, eng);
				}
			}
			
		}
			
		
		return new Option(null);
	}
	
	// y'a-t-il déjà une entité sur la case
	public boolean getCellContentBool(int x, int y) {		
		
		for(EntityService ent : eng.getEntities()) {			
			if(x == ent.getCol() && y == ent.getRow())
				return true;
				
		}
		return false;
	}

	
	public Option<MobService> getCellConten2(int x, int y) {
		Option<MobService> m = new Option<MobService>(x, y);// à refaire, voir s'il faut une liste de mob
		m.chercheMob(x, y);
		return m;
	}

}
