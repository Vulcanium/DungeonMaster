package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contrats.EditMapContract;
import contrats.EnvironmentContract;
import contrats.MobContract;
import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Cell;
import implems.Dir;
import implems.EditMapImpl;
import implems.EnvironmentImpl;
import implems.MapImpl;
import implems.MobImpl;
import implems.Option;
import services.EditMapService;
import services.EnvironmentService;
import services.MobService;

public class EnvironmentTest {
	
	private EnvironmentService env;
	private EditMapService editMap;
	private MobService mob;
	
	public EnvironmentTest() {
		env = null;
		editMap = null;
		mob = null;
	}
	
	@Before
	public void beforeTests() {
		env = new EnvironmentContract(new MapImpl(), new EnvironmentImpl());
		editMap = new EditMapContract(env, new EditMapImpl());
		mob = new MobContract(new MobImpl());
	}
	
	
	/* Couverture des preconditions et des transitions : */
	
	//Cas de test : Environment::testCloseDoor!
	@Test
	public void testCloseDoorPositif1() {
		
		//Conditions initiales
		int h = 2;
		int w = 2;
		int x = 1;
		int y = 1;
		try {
			env.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DNO);
		
		//Operations
			env.closeDoor(x, y);
			
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
		
	}
	
	@Test
	public void testCloseDoorPositif2() {
		
		//Conditions initiales
		int h = 2;
		int w = 2;
		int x = 1;
		int y = 1;
		try {
			env.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DWO);
		
		//Operations
			env.closeDoor(x, y);
			
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
		
	}
	
	@Test
	public void testCloseDoorNegatif1() {
		
		//Conditions initiales
		int h = 2;
		int w = 2;
		int x = 1;
		int y = 1;
		try {
			env.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DNO);
			mob.init(env, x, y, Dir.N);
			new Option<MobService>(mob);
		
		//Operations
			env.closeDoor(x, y);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testCloseDoorNegatif2() {
		
		//Conditions initiales
		int h = 2;
		int w = 2;
		int x = 1;
		int y = 1;
		try {
			env.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DWO);
			mob.init(env, x, y, Dir.N);
			new Option<MobService>(mob);
		
		//Operations
			env.closeDoor(x, y);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	
	
	
	@After
	public void afterTests() {
		mob = null;
		editMap = null;
		env = null;
	}

}
