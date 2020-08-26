package implems;

import java.util.ArrayList;

import services.EntityService;
import services.MobService;

public class Option<T> { //à vérif
	
	private int x, y;
	private T elem;
	private ArrayList<MobService> mobs;
	private String containsMob;
	private EngineImpl engine;
	
	public Option(T elem, ArrayList<MobService> mobs){
		this.elem = elem;
		this.mobs = mobs;
	}

	
	public Option(T elem, EngineImpl eng) {
		this.elem = elem;
		engine = eng;
	}
	
	public Option(T elem) {
		this.elem = elem;		
	}
	
	public Option(int x, int y, EngineImpl eng) {this.x = x; this.y = y; engine = eng;}
	
	public Option(int x, int y) {this.x = x; this.y = y;}
	
	public T getElem(){return elem;}
	
	public void chercheMob(int x, int y){ 
		
//		if(elem instanceof MobService && ((MobService) elem).getCol() == this.x && ((MobService) elem).getRow() == this.y) {
//			
//			for(MobService mob:mobs){
//				if(this.x == x && this.y == y) 
//					containsMob = "So("+mob.toString()+")";							
//			}				
//		}
		
		if(engine.getEntities().size() > 0) {
			for(EntityService ent : engine.getEntities()) {
				if(ent.getCol() == x && ent.getRow() == y) {
					containsMob = "So("+ent.getClass()+")";
					break;
				}
				else {
					containsMob = "No";	
				}
			}
		}
		else {
			containsMob = "No";	
		}		
			
	}
	
	public String isMob() {return containsMob;}
	
	public boolean ismob() {
		
		return containsMob != "No";
	}
}
