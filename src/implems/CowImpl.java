package implems;

import java.util.Random;

import contrats.PreConditionException;
import services.CowService;

public class CowImpl extends EntityImpl implements CowService{
	
	@Override
	public void step() {
		
		Random r = new Random();
		int action = r.nextInt(6);
		
		try {
			switch(action) {
			
				case 0:
					super.forward();
					break;
				case 1:
					super.backward();
					break;
				case 2:
					super.turnL();
					break;
				case 3:
					super.turnR();
					break;
				case 4:
					super.strafeL();
					break;
				case 5:
					super.strafeR();
					break;
			}
		}catch(PreConditionException pe) {
			pe.printStackTrace();
		}
	}

}
