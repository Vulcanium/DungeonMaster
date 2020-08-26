package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import services.CowService;
import services.EnvironmentService;
import contrats.CowContract;
import contrats.EnvironmentContract;
import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.CowImpl;
import implems.Dir;
import implems.EntityImpl;
import implems.EnvironmentImpl;
import implems.MapImpl;
import implems.MobImpl;


public class CowTest {
	
	private CowService cow;
	private EnvironmentService env;
	
	public CowTest() {
		cow = null;
		env = null;
	}
	
	
	@Before
	public void beforeTests() {
		cow = new CowContract(new MobImpl(), new EntityImpl(), new CowImpl());
		env = new EnvironmentContract(new MapImpl(), new EnvironmentImpl());
	}
	
	
	
	/* Couverture des preconditions et des transitions : */
	
	//Cas de test : Cow::testInit!
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
			int hp = 3;
			cow.init(env, x, y, Dir.N, hp);
				
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
	}
	
	@Test
	public void testInitPositif2() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		try {
			env.init(w, h);
				
		//Operations
			int x = 1;
			int y = 1;
			int hp = 4;
			cow.init(env, x, y, Dir.N, hp);
				
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
			int hp = 2;
			cow.init(env, x, y, Dir.N, hp);
				
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
			int hp = 5;
			cow.init(env, x, y, Dir.N, hp);
				
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
	}
	
	
	
	//Cas de test : Cow::testStep!
	@Test
	public void testStepPositif1() {
		
		//Conditions initiales
		int w = 20;
		int h = 20;
		int x = 10;
		int y = 10;
		try {
			env.init(w, h);
			cow.init(env, x, y, Dir.N);
		
		//Operations
			cow.step();
		
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
	}
	
	@Test
	public void testStepNegatif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = -1;
		int y = -1;
		try {
			env.init(w, h);
			cow.init(env, x, y, Dir.N);
		
		//Operations
			cow.step();
		
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
	}
	
	@Test
	public void testStepNegatif2() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 3;
		int y = 3;
		try {
			env.init(w, h);
			cow.init(env, x, y, Dir.N);
		
		//Operations
			cow.step();
		
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
	}
	
	
	
	
	
	@After
	public void afterTests() {
		env = null;
		cow = null;
	}

}
