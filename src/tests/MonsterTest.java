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
import implems.Dir;
import implems.EntityImpl;
import implems.EnvironmentImpl;
import implems.MapImpl;
import implems.MobImpl;
import implems.MonsterImpl;
import implems.Option;
import implems.PlayerImpl;
import services.EnvironmentService;
import services.MonsterService;
import services.PlayerService;

public class MonsterTest {
	
	private PlayerService player;
	private EnvironmentService env;
	private MonsterService monster;
	
	public MonsterTest() {
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
	
	//Cas de test : Monster::testGetContent!
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
			monster.init(env, x, y, Dir.N, hp);
		
		//Operations
			monster.getContent(x, y);
			
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
			monster.init(env, x, y, Dir.N, hp);
		
		//Operations
			int xv = 10;
			int yv = 10;		
			monster.getContent(xv, yv);
			
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
			monster.init(env, x, y, Dir.N, hp);
		
		//Operations
			int xv = 0;
			int yv = 0;		
			monster.getContent(xv, yv);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
	}
	
	
	//Cas de test : Monster::testGetNature!
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
				monster.init(env, x, y, Dir.N, hp);
			
			//Operations
				monster.getNature(x, y);
				
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
				monster.init(env, x, y, Dir.N, hp);
			
			//Operations
				int xv = 10;
				int yv = 10;		
				monster.getNature(xv, yv);
				
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
				monster.init(env, x, y, Dir.N, hp);
			
			//Operations
				int xv = 0;
				int yv = 0;		
				monster.getNature(xv, yv);
				
			//Oracle
				fail("neg");
			} catch (PreConditionException | PostConditionException e) {
			}
		}
		
		
		//Cas de test : Monster::testGetViewable!
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
				monster.init(env, x, y, Dir.N, hp);
			
			//Operations
				monster.getViewable(x, y);
				
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
				monster.init(env, x, y, Dir.N, hp);
			
			//Operations
				int xv = 10;
				int yv = 10;		
				monster.getViewable(xv, yv);
				
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
				monster.init(env, x, y, Dir.N, hp);
			
			//Operations
				int xv = 0;
				int yv = 0;		
				monster.getViewable(xv, yv);
				
			//Oracle
				fail("neg");
			} catch (PreConditionException | PostConditionException e) {
			}
		}
		
		
	//Cas de test : Monster::testInit!
	@Test
	public void testInitPositif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		try {
			env.init(w, h);
			
		//Operations
			int x = 1;
			int y = 1;
			int hp = 20;
			int dmg = 2;
			monster.init(env, x, y, Dir.N, hp, dmg);
			
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
		
	}
	
	@Test
	public void testInitNegatif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		try {
			env.init(w, h);
			
		//Operations
			int x = 1;
			int y = 1;
			int hp = 20;
			int dmg = 0;
			monster.init(env, x, y, Dir.N, hp, dmg);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testInitNegatif2() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		try {
			env.init(w, h);
			
		//Operations
			int x = 1;
			int y = 1;
			int hp = 20;
			int dmg = -20;
			monster.init(env, x, y, Dir.N, hp, dmg);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	
	//Cas de test : Monster::testAttack!
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
				new Option<PlayerService>(player);
				monster.step();
			
			//Operations		
				monster.attack();
				
			//Oracle
				((MonsterContract) monster).checkInvariant();
			} catch (PreConditionException | PostConditionException | InvariantException e) {
				fail("pos");
			}
		}
		
		@Test
		public void testAttackNegatif1() { //Aucun joueur
			
			//Conditions initiales
			int w = 10;
			int h = 10;
			int xj = 5;
			int yj = 5;
			int hp = 100;
			try {
				env.init(w, h);
				monster.init(env, xj, yj, Dir.N, hp);
			
			//Operations		
				monster.attack();
				
			//Oracle
				((MonsterContract) monster).checkInvariant();
				fail("neg");
			} catch (PreConditionException | PostConditionException | InvariantException e) {
			}
		}
		
		
		//Cas de test : Monster::testStep!
				@Test
				public void testStepPositif1() {
					
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
						new Option<PlayerService>(player);
					
					//Operations		
						monster.step();
						
					//Oracle
						((MonsterContract) monster).checkInvariant();
					} catch (PreConditionException | PostConditionException | InvariantException e) {
						fail("pos");
					}
				}
				
				@Test
				public void testStepNegatif1() { //Aucun joueur
					
					//Conditions initiales
					int w = 10;
					int h = 10;
					int xj = 5;
					int yj = 5;
					int hp = 100;
					try {
						env.init(w, h);
						monster.init(env, xj, yj, Dir.N, hp);
					
					//Operations		
						monster.step();
						
					//Oracle
						((MonsterContract) monster).checkInvariant();
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
