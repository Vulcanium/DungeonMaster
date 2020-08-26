package services;

import java.util.ArrayList;

import contrats.PostConditionException;
import contrats.PreConditionException;

public interface EngineService {
	
	/* Observators */
	
	public EnvironmentService getEnvi();
	public ArrayList<EntityService> getEntities();
	
	// \pre 0 <= index < getEntities().size()
	public EntityService getEntity(int index) throws PreConditionException;
	
	/* Invariants */
	
	// \inv \forall i:int \with i \in [0; (getEntities().size())-1], getEntity(i).getEnv() == getEnvi()
	
	/* \inv 
	 * (\forall i:int \with i \in [0; (getEntities().size())-1], getEntity(i).getCol() == x
	 * and getEntity(i).getRow() == y)
	 * => getEnvi().getCellContent(x, y) == getEntity(i)
	 */
	
	
	/* Constructors */
	
	public void init(EnvironmentService env);
	
	/* Operators */
	
	// \pre 0 <= index < getEntities().size()
	public void removeEntity(int index) throws PreConditionException, PostConditionException;
	// \post getEntities().size() == getEntities()@pre.size() - 1
	// \post \forall k:int \with k \in [0, i-1], getEntity(k) == getEntity(k)@pre
	// \post \forall k:int \with k \in [i, (getEntities()@pre.size())-2], getEntity(k) == getEntity(k+1)@pre
	// \post \forall k:int \with k \in [0, getEntities().size()-1], getEntity(k).getHp() > 0
	
	public void addEntity(EntityService e) throws PostConditionException, PreConditionException;
	// \post getEntities().size() == getEntities()@pre.size() + 1
	// \post \forall k:int \with k \in [0, (getEntities()@pre.size())-1], getEntity(k) == getEntity(k)@pre
	// \post getEntity(e), getEntities()@pre.size() == e
	
	// \pre \forall i:int \with i \in [0; (getEntities().size())-1], getEntity(i).getHp()>0
	public void step() throws PreConditionException, PostConditionException;

}
