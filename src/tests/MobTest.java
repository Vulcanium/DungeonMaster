package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import services.EnvironmentService;
import services.MobService;
import contrats.EnvironmentContract;
import contrats.InvariantException;
import contrats.MobContract;
import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Dir;
import implems.EnvironmentImpl;
import implems.MapImpl;
import implems.MobImpl;

public class MobTest {
	
	private MobService mob;
	private EnvironmentService env;
	
	public MobTest() {
		mob = null;
		env = null;
	}
	
	@Before
	public void beforeTests() {
		mob = new MobContract(new MobImpl());
		env = new EnvironmentContract(new MapImpl(), new EnvironmentImpl());
	}
	
	
	/* Couverture des preconditions et des transitions : */
	
	//Cas de test : Mob::testInit!
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
		mob.init(env, x, y, Dir.N);
		
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
		int x = -1;
		int y = -1;
		mob.init(env, x, y, Dir.N);
		
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
		int x = 3;
		int y = 3;
		mob.init(env, x, y, Dir.N);
		
		//Oracle
		fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testInitNegatif3() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		try {
			env.init(w, h);
			
		//Operations
		int x = -1;
		int y = 3;
		mob.init(env, x, y, Dir.N);
		
		//Oracle
		fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	
	//Cas de test : Mob::testForward!
	@Test
	public void testForwardPositif1() {
		//Conditions initiales
		int w = 20;
		int h = 20;
		int x = 5;
		int y = 5;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
			
		//Operations
			mob.forward();
			
		//Oracle
			((MobContract) mob).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
	}
	
	@Test
	public void testForwardNegatif1() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
			
		//Operations
			mob.forward(); //x++ => x=h => InvariantException
			
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
	
	@Test
	public void testForwardNegatif2() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.E);
			
		//Operations
			mob.forward(); //y++ => y=w => InvariantException
			
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
	
	
	//Cas de test : Mob::testBackward!
	@Test
	public void testBackwardPositif1() {
		//Conditions initiales
		int w = 20;
		int h = 20;
		int x = 5;
		int y = 5;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
			
		//Operations
			mob.backward();
			
		//Oracle
			((MobContract) mob).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
	}
	
	@Test
	public void testBackwardNegatif1() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 0;
		int y = 0;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
			
		//Operations
			mob.backward(); //x-- => x=-1 => InvariantException
			
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
	
	@Test
	public void testBackwardNegatif2() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 0;
		int y = 0;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.E);
			
		//Operations
			mob.backward(); //y-- => y=-1 => InvariantException
			
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
	
	
	//Cas de test : Mob::testStrafeL!
	@Test
	public void testStrafeLPositif1() {
		//Conditions initiales
		int w = 20;
		int h = 20;
		int x = 5;
		int y = 5;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
			
		//Operations
			mob.strafeL();
			
		//Oracle
			((MobContract) mob).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
	}
		
	@Test
	public void testStrafeLNegatif1() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 0;
		int y = 0;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
			
		//Operations
			mob.strafeL(); //y-- => y=-1 => InvariantException
				
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
		
	@Test
	public void testStrafeLNegatif2() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.E);
			
		//Operations
			mob.strafeL(); //x++ => x=h => InvariantException
				
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
		
		
	//Cas de test : Mob::testStrafeR!
	@Test
	public void testStrafeRPositif1() {
		//Conditions initiales
		int w = 20;
		int h = 20;
		int x = 5;
		int y = 5;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
			
		//Operations
			mob.strafeR();
				
		//Oracle
			((MobContract) mob).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
	}
		
	@Test
	public void testStrafeRNegatif1() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
				
		//Operations
			mob.strafeR(); //y++ => y=w => InvariantException
				
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
		
	@Test
	public void testStrafeRNegatif2() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 0;
		int y = 0;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.E);
				
		//Operations
			mob.strafeR(); //x-- => x=-1 => InvariantException
				
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
		
		
	//Cas de test : Mob::testTurnL!
	@Test
	public void testTurnLPositif1() {
		//Conditions initiales
		int w = 20;
		int h = 20;
		int x = 5;
		int y = 5;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
				
		//Operations
			mob.turnL();
			
		//Oracle
			((MobContract) mob).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
	}
		
	@Test
	public void testTurnLNegatif1() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = -1;
		int y = -1;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
				
		//Operations
			mob.turnL();
			
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
		
	@Test
	public void testTurnLNegatif2() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 3;
		int y = 3;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.E);
				
		//Operations
			mob.turnL();
				
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
		
	
	//Cas de test : Mob::testTurnR!
	@Test
	public void testTurnRPositif1() {
		//Conditions initiales
		int w = 20;
		int h = 20;
		int x = 5;
		int y = 5;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
			
		//Operations
			mob.turnR();
					
		//Oracle
			((MobContract) mob).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
	}
	
	@Test
	public void testTurnRNegatif1() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = -1;
		int y = -1;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.N);
			
		//Operations
			mob.turnR();
					
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
			
	@Test
	public void testTurnRNegatif2() {
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 3;
		int y = 3;
		try {
			env.init(w, h);
			mob.init(env, x, y, Dir.E);
					
		//Operations
			mob.turnR();
					
		//Oracle
			((MobContract) mob).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
	
			
			
	
	
	@After
	public void afterTests() {
		env = null;
		mob = null;
	}

}
