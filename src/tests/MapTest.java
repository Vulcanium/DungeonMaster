package tests;

import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import contrats.EditMapContract;
import contrats.MapContract;
import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Cell;
import implems.EditMapImpl;
import implems.MapImpl;
import services.EditMapService;
import services.MapService;

public class MapTest {

	private MapService map;
	private EditMapService editMap;
	
	public MapTest() {
		map = null;
		editMap = null;
	}
	
	@Before
	public void beforeTests() {
		map = new MapContract(new MapImpl());
		editMap = new EditMapContract(map, new EditMapImpl());
	}
	
	
	
	/* Couverture des preconditions et des transitions : */
	
	//Cas de test : Map::testInit!
	@Test
	public void testInitPositif1(){
		
		//Conditions initiales
			//Vide, car init
		
		//Operations
		int w = 2;
		int h = 2;
		try {
			map.init(w, h);
			
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
		
	}
	
	@Test
	public void testInitNegatif1(){
		
		//Conditions initiales
			//Vide, car init
		
		//Operations
		int w = -2;
		int h = 2;
		try {
			map.init(w, h);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testInitNegatif2(){
		
		//Conditions initiales
			//Vide, car init
		
		//Operations
		int w = 2;
		int h = -2;
		try {
			map.init(w, h);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testInitNegatif3(){
		
		//Conditions initiales
			//Vide, car init
		
		//Operations
		int w = -2;
		int h = -2;
		try {
			map.init(w, h);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	
	//Cas de test : Map::testGetCellNature!
	@Test
	public void testGetCellNaturePositif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		try {
			map.init(w, h);
			
		//Operations
			int x = 1;
			int y = 1;
			map.getCellNature(x, y);
			
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
		
	}
	
	@Test
	public void testGetCellNatureNegatif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		try {
			map.init(w, h);
			
		//Operations
			int x = -1;
			int y = -1;
			map.getCellNature(x, y);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testGetCellNatureNegatif2() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		try {
			map.init(w, h);
			
		//Operations
			int x = 3;
			int y = 5;
			map.getCellNature(x, y);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testGetCellNatureNegatif3() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		try {
			map.init(w, h);
			
		//Operations
			int x = 2;
			int y = 2;
			map.getCellNature(x, y);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	
	//Cas de test : Map::testOpenDoor!
	@Test
	public void testOpenDoorPositif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			map.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DWC);
			
		//Operations
			map.openDoor(x, y);
			
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
		
	}
	
	@Test
	public void testOpenDoorPositif2() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			map.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DNC);
			
		//Operations
			map.openDoor(x, y);
			
		//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
		
	}
	
	@Test
	public void testOpenDoorNegatif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			map.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DWO);
			
		//Operations
			map.openDoor(x, y);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testOpenDoorNegatif2() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			map.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DNO);
			
		//Operations
			map.openDoor(x, y);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	
	//Cas de test : Map::testCloseDoor!
	@Test
	public void testCloseDoorPositif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			map.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DNO);
					
			//Operations
			map.closeDoor(x, y);
					
			//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
				
	}
	
	@Test
	public void testCloseDoorPositif2() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			map.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DWO);
					
			//Operations
			map.closeDoor(x, y);
					
			//Oracle
		} catch (PreConditionException | PostConditionException e) {
			fail("pos");
		}
				
	}
		
	@Test
	public void testCloseDoorNegatif1() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			map.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DNC);
			
		//Operations
			map.closeDoor(x, y);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	
	@Test
	public void testCloseDoorNegatif2() {
		
		//Conditions initiales
		int w = 2;
		int h = 2;
		int x = 1;
		int y = 1;
		try {
			map.init(w, h);
			editMap.init(w, h);
			editMap.setNature(x, y, Cell.DWC);
			
		//Operations
			map.closeDoor(x, y);
			
		//Oracle
			fail("neg");
		} catch (PreConditionException | PostConditionException e) {
		}
		
	}
	


	
	@After
	public void afterTests() {
		editMap = null;
		map = null;
	}
	
}
