package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contrats.EditMapContract;
import contrats.InvariantException;
import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Cell;
import implems.EditMapImpl;
import implems.MapImpl;
import services.EditMapService;

public class EditMapTest {
	
	private EditMapService editMap;
	
	public EditMapTest() {
		editMap = null;
	}
	
	@Before
	public void beforeTests() {
		editMap = new EditMapContract(new MapImpl(), new EditMapImpl());
	}
	
	
	/* Couverture des preconditions et des transitions : */
	
	//Cas de test : EditMap::testIsReachable!
	@Test
	public void testIsReachablePositif1() {
		
		//Conditions initiales
		int w = 10;
		int h = 10;
		int x1 = 2;
		int x2 = 3;
		int y1 = 2;
		int y2 = 3;
		try {
			editMap.init(w, h);
			editMap.setNature(x1, y1, Cell.EMP);
			editMap.setNature(x2, y2, Cell.EMP);
			
		//Operations
			editMap.isReachable(x1, y1, x2, y2);
			
		//Oracle
			((EditMapContract) editMap).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
		
	}
	
	@Test
	public void testIsReachableNegatif1() {
		
		//Conditions initiales
		int w = 10;
		int h = 10;
		int x1 = 2;
		int x2 = 3;
		int y1 = 2;
		int y2 = 3;
		try {
			editMap.init(w, h);
			editMap.setNature(x1, y1, Cell.WLL);
			editMap.setNature(x2, y2, Cell.WLL);
			
		//Operations
			editMap.isReachable(x1, y1, x2, y2);
			
		//Oracle
			((EditMapContract) editMap).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
		
	}
	
	
	//Cas de test : EditMap::testSetNature!
	@Test
	public void testSetNaturePositif1() {
		
		//Conditions initiales
		int h = 2;
		int w = 2;
		try {
			editMap.init(w, h);
			
		//Operations
			int x = 1;
			int y = 1;
			editMap.setNature(x, y, Cell.EMP);
			
		//Oracle
			((EditMapContract) editMap).checkInvariant();
		} catch (PreConditionException | PostConditionException | InvariantException e) {
			fail("pos");
		}
	}
	
	@Test
	public void testSetNatureNegatif1() {
		
		//Conditions initiales
		int h = 2;
		int w = 2;
		try {
			editMap.init(w, h);
			
		//Operations
			int x = -1;
			int y = -1;
			editMap.setNature(x, y, Cell.EMP);
			
		//Oracle
			((EditMapContract) editMap).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
	
	@Test
	public void testSetNatureNegatif2() {
		
		//Conditions initiales
		int h = 2;
		int w = 2;
		try {
			editMap.init(w, h);
			
		//Operations
			int x = 5;
			int y = 5;
			editMap.setNature(x, y, Cell.EMP);
			
		//Oracle
			((EditMapContract) editMap).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
	
	@Test
	public void testSetNatureNegatif3() {
		
		//Conditions initiales
		int h = 2;
		int w = 2;
		try {
			editMap.init(w, h);
			
		//Operations
			int x = 2;
			int y = 2;
			editMap.setNature(x, y, Cell.EMP);
			
		//Oracle
			((EditMapContract) editMap).checkInvariant();
			fail("neg");
		} catch (PreConditionException | PostConditionException | InvariantException e) {
		}
	}
	
	
	
	@After
	public void afterTests() {
		editMap = null;
	}

}
