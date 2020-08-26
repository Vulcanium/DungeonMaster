package implems;

import java.util.ArrayList;

import contrats.PostConditionException;
import contrats.PreConditionException;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import main.RendererV2Map2;
import services.EngineService;
import services.EntityService;
import services.EnvironmentService;

public class EngineImpl implements EngineService{
	
	private EnvironmentService envi;
	private ArrayList<EntityService> entities;

	@Override
	public EnvironmentService getEnvi() {
		
		return envi;
	}

	@Override
	public ArrayList<EntityService> getEntities() {
		
		return entities;
	}

	@Override
	public EntityService getEntity(int index) {
		
		return entities.get(index);
	}

	@Override
	public void init(EnvironmentService env) {
		
		envi = env;
		entities = new ArrayList<EntityService>();
	}

	@Override
	public void removeEntity(int index) {
		
		entities.remove(index);
	}

	@Override
	public void addEntity(EntityService e) {
		
		entities.add(e);
	}

	@Override
	public void step() {
		
	}
	
	public void step(RendererV2Map2 renderer, Stage stage, PlayerImpl player, MediaPlayer mp) throws PostConditionException, PreConditionException {
		
		//boolean b = true;
		
		for(EntityService entity : entities) { 
			if(entity.getHp() <= 0) 
				removeEntity(entities.indexOf(entity));			
			else 
				entity.step();
			
		}	
		renderer.updateViewPlayerDungeon(stage, player,  mp);
				//b = false;
		
		
		/*if(b) {
			for(EntityService entity : entities)
				entity.step();
		}*/
		
	}

}
