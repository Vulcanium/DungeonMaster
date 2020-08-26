package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contrats.EngineContract;
import contrats.EnvironmentContract;
import contrats.InvariantException;
import contrats.MonsterContract;
import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Dir;
import implems.EngineImpl;
import implems.EntityImpl;
import implems.EnvironmentImpl;
import implems.MapImpl;
import implems.MobImpl;
import implems.MonsterImpl;
import services.EngineService;
import services.EnvironmentService;
import services.MonsterService;

public class EngineTest {
	
	private EngineService engine;
	private EnvironmentService env;
	private MonsterService monster;
	
	public EngineTest() {
		engine = null;
		env = null;
		monster = null;
	}
	
	@Before
	public void beforeTests() {
		engine = new EngineContract(new EngineImpl());
		env = new EnvironmentContract(new MapImpl(), new EnvironmentImpl());
		monster = new MonsterContract(new MobImpl(), new EntityImpl(), new MonsterImpl());
	}
	
	
	/* Couverture des preconditions et des transitions : */
	
	//Cas de test : Engine::testGetEntity!
	@Test
	public void testGetEntityPositif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		int hp = 100;
		int dmg = 2;
		try {
			env.init(w, h);
			monster.init(env, x, y, Dir.N, hp, dmg);
			engine.init(env);
			engine.addEntity(monster);
		
		//Operations
			int i = 0;
			engine.getEntity(i);
		
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
		
	}
	
	@Test
	public void testGetEntityNegatif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		int hp = 20;
		int dmg = 2;
		try {
			env.init(w, h);
			monster.init(env, x, y, Dir.N, hp, dmg);
			engine.init(env);
			engine.addEntity(monster);
		
		//Operations
			int i = -1;
			engine.getEntity(i);
		
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testGetEntityNegatif2() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		int hp = 20;
		int dmg = 2;
		try {
			env.init(w, h);
			monster.init(env, x, y, Dir.N, hp, dmg);
			engine.init(env);
			engine.addEntity(monster);
		
		//Operations
			int i = 1;
			engine.getEntity(i);
		
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testGetEntityNegatif3() { //Pas d'ajout d'entite
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		int hp = 20;
		int dmg = 2;
		try {
			env.init(w, h);
			monster.init(env, x, y, Dir.N, hp, dmg);
			engine.init(env);
		
		//Operations
			int i = 0;
			engine.getEntity(i);
		
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	
	//Cas de test : Engine::testRemoveEntity!
		@Test
		public void testRemoveEntityPositif1() {
			
			//Conditions initiales
			int w = 2;
			int h = 2;
			int x = 1;
			int y = 1;
			int hp = 20;
			int dmg = 2;
			try {
				env.init(w, h);
				monster.init(env, x, y, Dir.N, hp, dmg);
				engine.init(env);
				engine.addEntity(monster);
			
			//Operations
				int i = 0;
				engine.removeEntity(i);
			
			//Oracle
				((EngineContract) engine).checkInvariant();
			} catch (PreConditionException | PostConditionException | InvariantException e) {
				fail("pos");
			}
			
		}
		
		@Test
		public void testRemoveEntityNegatif1() {
			
			//Conditions initiales
			int w = 2;
			int h = 2;
			int x = 1;
			int y = 1;
			int hp = 20;
			int dmg = 2;
			try {
				env.init(w, h);
				monster.init(env, x, y, Dir.N, hp, dmg);
				engine.init(env);
				engine.addEntity(monster);
			
			//Operations
				int i = -1;
				engine.removeEntity(i);
			
			//Oracle
				((EngineContract) engine).checkInvariant();
				fail("neg");
			} catch (PreConditionException | PostConditionException | InvariantException e) {
			}
			
		}
		
		@Test
		public void testRemoveEntityNegatif2() {
			
			//Conditions initiales
			int w = 2;
			int h = 2;
			int x = 1;
			int y = 1;
			int hp = 20;
			int dmg = 2;
			try {
				env.init(w, h);
				monster.init(env, x, y, Dir.N, hp, dmg);
				engine.init(env);
				engine.addEntity(monster);
			
			//Operations
				int i = 1;
				engine.removeEntity(i);
			
			//Oracle
				((EngineContract) engine).checkInvariant();
				fail("neg");
			} catch (PreConditionException | PostConditionException | InvariantException e) {
			}
			
		}
		
		@Test
		public void testRemoveEntityNegatif3() { //Pas d'ajout d'entite
			
			//Conditions initiales
			int w = 2;
			int h = 2;
			int x = 1;
			int y = 1;
			int hp = 20;
			int dmg = 2;
			try {
				env.init(w, h);
				monster.init(env, x, y, Dir.N, hp, dmg);
				engine.init(env);
			
			//Operations
				int i = 0;
				engine.removeEntity(i);
			
			//Oracle
				((EngineContract) engine).checkInvariant();
				fail("neg");
			} catch (PreConditionException | PostConditionException | InvariantException e) {
			}
			
		}
		
		

		//Cas de test : Engine::testStep!
		@Test
		public void testStepPositif1() {
			
			//Conditions initiales
			int w = 2;
			int h = 2;
			int x = 1;
			int y = 1;
			int hp = 20;
			int dmg = 2;
			try {
				env.init(w, h);
				monster.init(env, x, y, Dir.N, hp, dmg);
				engine.init(env);
				engine.addEntity(monster);
			
			//Operations
				engine.step();
			
			//Oracle
				((EngineContract) engine).checkInvariant();
			} catch (PreConditionException | PostConditionException | InvariantException e) {
				fail("pos");
			}
			
		}
		
		@Test
		public void testStepNegatif1() {
			
			//Conditions initiales
			int w = 2;
			int h = 2;
			int x = 1;
			int y = 1;
			int hp = 0; //L'entite est morte
			int dmg = 2;
			try {
				env.init(w, h);
				monster.init(env, x, y, Dir.N, hp, dmg);
				engine.init(env);
				engine.addEntity(monster);
			
			//Operations
				engine.step();
			
			//Oracle
				((EngineContract) engine).checkInvariant();
				fail("neg");
			} catch (PreConditionException | PostConditionException | InvariantException e) {
			}
			
		}
		
		@Test
		public void testStepNegatif2() {
			
			//Conditions initiales
			int w = 2;
			int h = 2;
			int x = 1;
			int y = 1;
			int hp = -1; //L'entite est morte
			int dmg = 2;
			try {
				env.init(w, h);
				monster.init(env, x, y, Dir.N, hp, dmg);
				engine.init(env);
				engine.addEntity(monster);
			
			//Operations
				engine.step();
			
			//Oracle
				((EngineContract) engine).checkInvariant();
				fail("neg");
			} catch (PreConditionException | PostConditionException | InvariantException e) {
			}
			
		}
	
	
	
		
		
	@After
	public void afterTests() {
		monster = null;
		env = null;
		engine = null;
	}

}
