package contrats;

import java.util.ArrayList;
import java.util.Random;

import implems.Cell;
import services.EngineService;
import services.EntityService;
import services.EnvironmentService;

public class EngineContract extends EngineDecorator{

	public EngineContract(EngineService es) {
		super(es);		
	}
	
	public EnvironmentService getEnvi() {return super.getEnvi();}
	public ArrayList<EntityService> getEntities(){return super.getEntities();}
	
	
	public EntityService getEntity(int index) throws PreConditionException{
		// \pre 0 <= index < getEntities().size()
		if(! (0<=index && index < getEntities().size())) {
			throw new PreConditionException("Erreur précondition getEntity Engine!\\n");
		}
		
		//Traitement
		return super.getEntity(index);
		
	}
	
	public void checkInvariant() throws InvariantException, PreConditionException{
		
		// \inv \forall i:int \with i \in [0; (getEntities().size())-1], getEntity(i).getEnv() == getEnvi()
		for(int i = 0 ; i < getEntities().size() ; i++) {
			if(! (getEntity(i).getEnv() == getEnvi())) {
				throw new InvariantException("Erreur invariant 1 Engine!\\n");
			}
		}		
		
		/* \inv 
		 * (\forall i:int \with i \in [0; (getEntities().size())-1], getEntity(i).getCol() == x
		 * and getEntity(i).getRow() == y)
		 * => getEnvi().getCellContent(x, y) == getEntity(i)
		 */
		Random r = new Random();
		int x = r.nextInt(getEnvi().getHeight());
		int y = r.nextInt(getEnvi().getWidth());
		for(int i = 0 ; i < getEntities().size() ; i++) {
			if(! ( ( getEntity(i).getCol() == x && getEntity(i).getRow() == y ) && getEnvi().getCellContent(x, y) == getEntity(i) )) {
				throw new InvariantException("Erreur invariant 2 Engine!\\n");
			}
		}		
	}
	
	
	public void init(EnvironmentService env) {
		
		//Traitement
		super.init(env);
	}
	
	
	public void removeEntity(int index) throws PreConditionException, PostConditionException{
		
		// \pre 0 <= index < getEntities().size()
		if(! (0 <= index && index < getEntities().size())) {
			throw new PreConditionException("Erreur pre-condition removeEntity Engine !\n");
		}
		
		//invariants
		try {
			checkInvariant();
		} catch (InvariantException e) {
			e.printStackTrace();
		}
		
		//captures
		int size_atpre = getEntities().size();
		ArrayList<EntityService> entities_atpre = getEntities();
		
		//Traitement
		super.removeEntity(index);
		
		//invariants
		try {
			checkInvariant();
		} catch (InvariantException e) {
			e.printStackTrace();
		}
		
		// \post getEntities().size() == getEntities()@pre.size() - 1
		if(! (getEntities().size() == size_atpre - 1)) {
			throw new PostConditionException("Erreur post-condition 1 removeEntity Engine !\n");
		}
		
		// \post \forall k:int \with k \in [0, i-1], getEntity(k) == getEntity(k)@pre
		for(int k = 0 ; k < index ; k++) {
			if(! (getEntity(k) == entities_atpre.get(k))) {
				throw new PostConditionException("Erreur post-condition 2 removeEntity Engine !\n");
			}
		}
		
		// \post \forall k:int \with k \in [i, (getEntities()@pre.size())-2], getEntity(k) == getEntity(k+1)@pre
		for(int k = index ; k < size_atpre-1 ; k++) {
			if(! (getEntity(k) == entities_atpre.get(k+1))) {
				throw new PostConditionException("Erreur post-condition 3 removeEntity Engine !\n");
			}
		}
		
		// \post \forall k:int \with k \in [0, getEntities().size()-1], getEntity(k).getHp() > 0
		for(int k = 0 ; k < getEntities().size() ; k++) {
			if(! (getEntity(k).getHp() > 0)) {
				throw new PostConditionException("Erreur post-condition 4 removeEntity Engine !\n");
			}
		}
	}
	
	
	public void addEntity(EntityService e) throws PostConditionException, PreConditionException{
		
		//invariants
		try {
			checkInvariant();
		} catch (InvariantException ie) {
			ie.printStackTrace();
		}
				
		//captures
		int size_atpre = getEntities().size();
		ArrayList<EntityService> entities_atpre = getEntities();
				
		//Traitement
		super.addEntity(e);
		
		// \post getEntities().size() == getEntities()@pre.size() + 1
		if(! (getEntities().size() == size_atpre + 1)) {
			throw new PostConditionException("Erreur post-condition 1 addEntity Engine !\n");
		}
		
		// \post \forall k:int \with k \in [0, (getEntities()@pre.size())-1], getEntity(k) == getEntity(k)@pre
		for(int k = 0 ; k < size_atpre ; k++) {
			if(! (getEntity(k) == entities_atpre.get(k))) {
				throw new PostConditionException("Erreur post-condition 2 addEntity Engine !\n");
			}
		}
		
		// \post getEntity(getEntities()@pre.size()) == e
		if(! (getEntity(size_atpre) == e)) {
			throw new PostConditionException("Erreur post-condition 3 addEntity Engine !\n");
		}
		
	}
	
	
	public void step() throws PreConditionException, PostConditionException{
		
		// \pre \forall i:int \with i \in [0; (getEntities().size())-1], getEntity(i).getHp()>0
		for(int i = 0 ; i < getEntities().size() ; i++) {
			if(! (getEntity(i).getHp() > 0)) {
				throw new PreConditionException("Erreur pre-condition step Engine !\n");
			}
		}
		
		//invariants
		try {
			checkInvariant();
		} catch (InvariantException ie) {
			ie.printStackTrace();
		}
		
		//Traitement
		super.step();
		
		//invariants
		try {
			checkInvariant();
		} catch (InvariantException ie) {
			ie.printStackTrace();
		}				
	}

}
