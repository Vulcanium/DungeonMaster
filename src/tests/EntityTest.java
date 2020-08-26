package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import implems.MobImpl;
import contrats.EntityContract;
import contrats.EnvironmentContract;
import contrats.PostConditionException;
import contrats.PreConditionException;
import services.EntityService;
import services.EnvironmentService;
import implems.Dir;
import implems.EntityImpl;
import implems.EnvironmentImpl;
import implems.MapImpl;

public class EntityTest {
	
	private EntityService entity;
	private EnvironmentService env;
	
	public EntityTest() {
		entity = null;
		env = null;
	}
	
	@Before
	public void beforeTests() {
		entity = new EntityContract(new MobImpl(), new EntityImpl());
		env = new EnvironmentContract(new MapImpl(), new EnvironmentImpl());
	}
	
	
	/* Couverture des preconditions et des transitions : */
	
	//Cas de test : Entity::testInit!
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
		entity.init(env, x, y, Dir.N, hp);
		
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
		int hp = 0;
		entity.init(env, x, y, Dir.N, hp);
		
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
		int hp = -20;
		entity.init(env, x, y, Dir.N, hp);
		
		//Oracle
		fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
	}
	
	
	
	@After
	public void afterTests() {
		env = null;
		entity = null;
	}

}
