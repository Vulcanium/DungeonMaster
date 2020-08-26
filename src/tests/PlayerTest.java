package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contrats.EnvironmentContract;
import contrats.InvariantException;
import contrats.MonsterContract;
import contrats.PlayerContract;
import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Command;
import implems.Dir;
import implems.EntityImpl;
import implems.EnvironmentImpl;
import implems.MapImpl;
import implems.MobImpl;
import implems.MonsterImpl;
import implems.Option;
import implems.PlayerImpl;
import services.EntityService;
import services.EnvironmentService;
import services.MonsterService;
import services.PlayerService;

public class PlayerTest {
	
	private PlayerService player;
	private EnvironmentService env;
	private MonsterService monster;
	
	
	public PlayerTest() {
		player = null;
		env = null;
		monster = null;
	}
	
	@Before
	public void beforeTests() {
		player = new PlayerContract(new MobImpl(), new EntityImpl(), new PlayerImpl());
		monster = new MonsterContract(new MobImpl(), new EntityImpl(), new MonsterImpl());
		env = new EnvironmentContract(new MapImpl(), new EnvironmentImpl());
	}
	
	
	
	/* Couverture des preconditions et des transitions : */
	
	//Cas de test : Player::testGetContent!
	@Test
	public void testGetContentPositif1() {
		
		//Conditions initiales
		int w = 10;
		int h = 10;
		int x = 5;
		int y = 5;
		int hp = 100;
		try {
			env.init(w, h);
			player.init(env, x, y, Dir.N, hp);
		
		//Operations
			player.getContent(x, y);
			
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
	}
	
	@Test
	public void testGetContentNegatif1() {
		
		//Conditions initiales
		int w = 10;
		int h = 10;
		int x = 5;
		int y = 5;
		int hp = 100;
		try {
			env.init(w, h);
			player.init(env, x, y, Dir.N, hp);
		
		//Operations
			int xv = 10;
			int yv = 10;		
			player.getContent(xv, yv);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
	}
	
	
	@Test
	public void testGetContentNegatif2() {
		
		//Conditions initiales
		int w = 10;
		int h = 10;
		int x = 5;
		int y = 5;
		int hp = 100;
		try {
			env.init(w, h);
			player.init(env, x, y, Dir.N, hp);
		
		//Operations
			int xv = 0;
			int yv = 0;		
			player.getContent(xv, yv);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
	}
	
	
	//Cas de test : Player::testGetNature!
		@Test
		public void testGetNaturePositif1() {
			
			//Conditions initiales
			int w = 10;
			int h = 10;
			int x = 5;
			int y = 5;
			int hp = 100;
			try {
				env.init(w, h);
				player.init(env, x, y, Dir.N, hp);
			
			//Operations
				player.getNature(x, y);
				
			//Oracle
			} catch (PreConditionException | PostConditionException e) {
				fail("pos");
			}
		}
		
		@Test
		public void testGetNatureNegatif1() {
			
			//Conditions initiales
			int w = 10;
			int h = 10;
			int x = 5;
			int y = 5;
			int hp = 100;
			try {
				env.init(w, h);
				player.init(env, x, y, Dir.N, hp);
			
			//Operations
				int xv = 10;
				int yv = 10;		
				player.getNature(xv, yv);
				
			//Oracle
				fail("neg");
			} catch (PreConditionException | PostConditionException e) {
			}
		}
		
		
		@Test
		public void testGetNatureNegatif2() {
			
			//Conditions initiales
			int w = 10;
			int h = 10;
			int x = 5;
			int y = 5;
			int hp = 100;
			try {
				env.init(w, h);
				player.init(env, x, y, Dir.N, hp);
			
			//Operations
				int xv = 0;
				int yv = 0;		
				player.getNature(xv, yv);
				
			//Oracle
				fail("neg");
			} catch (PreConditionException | PostConditionException e) {
			}
		}
		
		
		//Cas de test : Player::testGetViewable!
		@Test
		public void testGetViewablePositif1() {
			
			//Conditions initiales
			int w = 10;
			int h = 10;
			int x = 5;
			int y = 5;
			int hp = 100;
			try {
				env.init(w, h);
				player.init(env, x, y, Dir.N, hp);
			
			//Operations
				player.getViewable(x, y);
				
			//Oracle
			} catch (PreConditionException | PostConditionException e) {
				fail("pos");
			}
		}
		
		@Test
		public void testGetViewableNegatif1() {
			
			//Conditions initiales
			int w = 10;
			int h = 10;
			int x = 5;
			int y = 5;
			int hp = 100;
			try {
				env.init(w, h);
				player.init(env, x, y, Dir.N, hp);
			
			//Operations
				int xv = 10;
				int yv = 10;		
				player.getViewable(xv, yv);
				
			//Oracle
				fail("neg");
			} catch (PreConditionException | PostConditionException e) {
			}
		}
		
		
		@Test
		public void testGetViewableNegatif2() {
			
			//Conditions initiales
			int w = 10;
			int h = 10;
			int x = 5;
			int y = 5;
			int hp = 100;
			try {
				env.init(w, h);
				player.init(env, x, y, Dir.N, hp);
			
			//Operations
				int xv = 0;
				int yv = 0;		
				player.getViewable(xv, yv);
				
			//Oracle
				fail("neg");
			} catch (PreConditionException | PostConditionException e) {
			}
		}
	
		
	//Cas de test : Player::testStep!
	@Test
	public void testStepPositif1() {
		
		//Conditions initiales
		int w = 10;
		int h = 10;
		int x = 5;
		int y = 5;
		int hp = 100;
		try {
			env.init(w, h);
			player.init(env, x, y, Dir.N, hp);
			new Option<Command>(Command.FF);
		
		//Operations		
			player.step();
			
		//Oracle
			((PlayerContract) player).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
	}
	
	@Test
	public void testStepPositif2() {
		
		//Conditions initiales
		int w = 10;
		int h = 10;
		int xj = 5;
		int yj = 5;
		int xm = 6;
		int ym = 5;
		int hp = 100;
		int dmg = 2;
		try {
			env.init(w, h);
			player.init(env, xj, yj, Dir.N, hp);
			monster.init(env, xm, ym, Dir.S, hp, dmg);
			new Option<EntityService>(monster);
			new Option<Command>(Command.ATK);
		
		//Operations		
			player.step();
			
		//Oracle
			((PlayerContract) player).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
	}
	
	@Test
	public void testStepNegatif1() {
		
		//Conditions initiales
		int w = 10;
		int h = 10;
		int xj = 5;
		int yj = 5;
		int hp = 100;
		try {
			env.init(w, h);
			player.init(env, xj, yj, Dir.N, hp);
			new Option<Command>(Command.FF);
		
		//Operations		
			player.step();
			player.backward(); //Le joueur recule sans rien lui demander
			
		//Oracle
			((PlayerContract) player).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
	
	
	//Cas de test : Player::testAttack!
	@Test
	public void testAttackPositif1() {
		
		//Conditions initiales
		int w = 10;
		int h = 10;
		int xj = 5;
		int yj = 5;
		int xm = 6;
		int ym = 5;
		int hp = 100;
		int dmg = 2;
		try {
			env.init(w, h);
			player.init(env, xj, yj, Dir.N, hp);
			monster.init(env, xm, ym, Dir.S, hp, dmg);
			new Option<EntityService>(monster);
			new Option<Command>(Command.ATK);
			player.step();
		
		//Operations		
			player.attack();
			
		//Oracle
			((PlayerContract) player).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
	}
	
	@Test
	public void testAttackNegatif1() { //Aucun monstre
		
		//Conditions initiales
		int w = 10;
		int h = 10;
		int xj = 5;
		int yj = 5;
		int hp = 100;
		try {
			env.init(w, h);
			player.init(env, xj, yj, Dir.N, hp);
		
		//Operations		
			player.attack();
			
		//Oracle
			((PlayerContract) player).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
	
	
	
	
	
	
	
	@After
	public void afterTests() {
		env = null;
		player = null;
		monster = null;
	}

}
