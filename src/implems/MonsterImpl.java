package implems;

import java.util.Random;

import contrats.PostConditionException;
import contrats.PreConditionException;
import services.EnvironmentService;
import services.MobService;
import services.MonsterService;
import services.PlayerService;

public class MonsterImpl extends EntityImpl implements MonsterService {

	private int dmg;
	private PlayerService target;
	private int targetHp;
	
	public MonsterImpl() { target = null; }
	
	@Override
	public int getDegats() {
		
		return dmg;
	}

	@Override
	public PlayerService getCible() {
		
		return target;
	}

	@Override
	public Option<MobService> getContent(int x, int y) throws PreConditionException {
		
		Option<MobService> mob = new Option<MobService>(x, y);
		mob.chercheMob(x, y);
		return mob;
	}

	@Override
	public Cell getNature(int x, int y) throws PreConditionException {
		
		return getEnv().getCellNature(x, y);
	}

	@Override
	public boolean getViewable(int x, int y) throws PreConditionException {

		if(x < 1 || x > 3 || y < -1 || y > 1) {
			return false;
		}
		
		else {
			
			for(int i = getRow() ; i < getRow() + x ; i++) {
				for(int j = getCol() ; j < getCol() + y ; j++) {
					if( (getFace() == Dir.W || getFace() == Dir.E) 
							&& (getNature(i,j) == Cell.WLL || getNature(i,j) == Cell.DNC) )
						return false;
					if( (getFace() == Dir.N || getFace() == Dir.S) 
							&& (getNature(i,j) == Cell.WLL || getNature(i,j) == Cell.DWC) )
						return false;
				}
			}
		}
		
		return true;
	}

	@Override
	public void init(EnvironmentService env, int x, int y, Dir dir, int hp, int degats)
			throws PreConditionException, PostConditionException {
		
		super.init(env, x, y, dir, hp);
		dmg = degats;
	}
	

	@Override
	public void attack() throws PreConditionException, PostConditionException {
		
		targetHp = target.getHp();
		targetHp = targetHp - dmg;
	}
	
//	@Override
//	public void step() {
//		
//		Random r = new Random();
//		int action = r.nextInt(6);
//		
//		try {
//			
//			switch(getFace()) {			
//			
//				case N:					
//					
//					//attention, getCol retourne x, soit la coordonnée en abscisse, et getCol la coordonnée en ordonnée
//					Option<MobService> ncontent_col_neg_row_neg = getContent(getCol()-1, getRow()-1);
//					Option<MobService> ncontent_col_neg = getContent(getCol()-1, getRow());
//					Option<MobService> ncontent_col_neg_row_pos1 = getContent(getCol()-1, getRow()+1);
//					Option<MobService> ncontent_col_neg_row_pos2 = getContent(getCol()-1, getRow()+2);
//					Option<MobService> ncontent_col_neg_row_pos3 = getContent(getCol()-1, getRow()+3);
//					
//					Option<MobService> ncontent_row_neg = getContent(getCol(), getRow()-1);
//					Option<MobService> ncontent_row_pos1 = getContent(getCol(), getRow()+1);
//					Option<MobService> ncontent_row_pos2 = getContent(getCol(), getRow()+2);
//					Option<MobService> ncontent_row_pos3 = getContent(getCol(), getRow()+3);
//					
//					Option<MobService> ncontent_col_pos_row_neg = getContent(getCol()+1, getRow()-1);
//					Option<MobService> ncontent_col_pos = getContent(getCol()+1, getRow());					
//					Option<MobService> ncontent_col_pos_row_pos1 = getContent(getCol()+1, getRow()+1);
//					Option<MobService> ncontent_col_pos_row_pos2 = getContent(getCol()+1, getRow()+2);
//					Option<MobService> ncontent_col_pos_row_pos3 = getContent(getCol()+1, getRow()+3);
//					
//					
//					if(ncontent_row_neg.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)ncontent_row_neg;
//						turnL();
//						turnL();
//						
//						attack();
//					}	
//					
//					else if(ncontent_row_pos1.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)ncontent_row_pos1;
//						attack();
//						
//					}
//					
//					else if(ncontent_row_pos2.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)ncontent_row_pos2;
//						forward();
//					}
//					
//					else if(ncontent_row_pos3.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)ncontent_row_pos3;
//						forward();
//						
//					}
//					
//					else if(ncontent_col_pos.isMob().equals("So(PlayerService)")) {						
//						
//						target = (PlayerService)ncontent_col_pos;
//						turnR();
//						attack();
//					}
//					
//					else if(ncontent_col_neg.isMob().equals("So(PlayerService)")) {						
//					
//						target = (PlayerService)ncontent_col_neg;
//						turnL();
//						attack();
//					}
//					
//					else {
//						
//						switch(action) {
//						
//							case 0:
//								super.forward();
//								break;
//							case 1:
//								super.backward();
//								break;
//							case 2:
//								super.turnL();
//								break;
//							case 3:
//								super.turnR();
//								break;
//							case 4:
//								super.strafeL();
//								break;
//							case 5:
//								super.strafeR();
//								break;
//						}
//					
//					}
//					
//					
//					/*else if(ncontent_col_neg_row_neg.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)ncontent_col_neg_row_neg;
//						
//						if( (getNature(getCol()-1, getRow()) == Cell.EMP) || (getNature(getCol()-1, getRow()) == Cell.DNO) || (getNature(getCol()-1, getRow()) == Cell.DWO) ) {
//							
//							turnL();
//							turnL();
//							strafeR();
//						}
//						
//						else if( (getNature(getCol(), getRow()-1) == Cell.EMP) || (getNature(getCol(), getRow()-1) == Cell.DNO) || (getNature(getCol(), getRow()-1) == Cell.DWO) ) {
//						
//							turnL();
//							strafeL();
//						}
//					}
//					
//					else if(ncontent_col_pos_row_neg.isMob().equals("So(PlayerService)")) {
//						target = (PlayerService)ncontent_col_pos_row_neg;
//						
//						if( (getNature(getCol()+1, getRow()) == Cell.EMP) || (getNature(getCol()+1, getRow()) == Cell.DNO) || (getNature(getCol()+1, getRow()) == Cell.DWO) ) {
//							
//							turnL();
//							turnL();
//							strafeL();						
//						}						
//					
//					
//						else if( (getNature(getCol(), getRow()-1) == Cell.EMP) || (getNature(getCol(), getRow()-1) == Cell.DNO) || (getNature(getCol(), getRow()-1) == Cell.DWO) ) {
//							
//							turnR();
//							strafeR();
//						}
//						
//					}*/					
//					
//					/*else if(ncontent_col_pos_row_pos1.isMob().equals("So(PlayerService)")) {
//						target = (PlayerService)ncontent_col_pos_row_pos1;
//						
//						if( (getNature(getCol()+1, getRow()) == Cell.EMP) || (getNature(getCol()+1, getRow()) == Cell.DNO) || (getNature(getCol()+1, getRow()) == Cell.DWO) ) {
//							
//							strafeR();						
//						}
//						
//						else if( (getNature(getCol(), getRow()+1) == Cell.EMP) || (getNature(getCol(), getRow()+1) == Cell.DNO) || (getNature(getCol(), getRow()+1) == Cell.DWO) ) {
//							
//							turnR();
//							strafeL();
//						}					
//					}
//					
//					else if(ncontent_col_pos_row_pos2.isMob().equals("So(PlayerService)")) {
//						target = (PlayerService)ncontent_col_pos_row_pos2;
//						
//						if( (getNature(getCol()+1, getRow()) == Cell.EMP) || (getNature(getCol()+1, getRow()) == Cell.DNO) || (getNature(getCol()+1, getRow()) == Cell.DWO) ) {							
//							
//							strafeR();
//							
//						}
//						
//						else if( (getNature(getCol(), getRow()+1) == Cell.EMP) || (getNature(getCol(), getRow()+1) == Cell.DNO) || (getNature(getCol(), getRow()+1) == Cell.DWO) ) {
//							
//							turnR();
//							strafeL();
//						}
//					}
//					
//					else if(ncontent_col_pos_row_pos3.isMob().equals("So(PlayerService)")) {						
//					
//						target = (PlayerService)ncontent_col_pos_row_pos3;
//						strafeR();
//						
//						if( (getNature(getCol()+1, getRow()) == Cell.EMP) || (getNature(getCol()+1, getRow()) == Cell.DNO) || (getNature(getCol()+1, getRow()) == Cell.DWO) ) {
//							strafeR();
//						}
//						
//						else if( (getNature(getCol(), getRow()+1) == Cell.EMP) || (getNature(getCol(), getRow()+1) == Cell.DNO) || (getNature(getCol(), getRow()+1) == Cell.DWO) ) {
//							
//							turnR();
//							strafeL();
//						}
//					}
//					
//					else if(ncontent_col_neg_row_pos1.isMob().equals("So(PlayerService)")) {
//						target = (PlayerService)ncontent_col_neg_row_pos1;
//						
//						if( (getNature(getCol()-1, getRow()) == Cell.EMP) || (getNature(getCol()-1, getRow()) == Cell.DNO) || (getNature(getCol()-1, getRow()) == Cell.DWO) ) {							
//						
//							strafeL();
//						}
//						else if( (getNature(getCol(), getRow()+1) == Cell.EMP) || (getNature(getCol(), getRow()+1) == Cell.DNO) || (getNature(getCol(), getRow()+1) == Cell.DWO) ) {
//							
//							turnL();
//							strafeR();
//						}
//						
//					}
//					
//					else if(ncontent_col_neg_row_pos2.isMob().equals("So(PlayerService)")) {
//						target = (PlayerService)ncontent_col_neg_row_pos2;
//						
//						if( (getNature(getCol()-1, getRow()) == Cell.EMP) || (getNature(getCol()-1, getRow()) == Cell.DNO) || (getNature(getCol()-1, getRow()) == Cell.DWO) ) {
//							
//							strafeL();
//						}
//						
//						else if( (getNature(getCol(), getRow()+1) == Cell.EMP) || (getNature(getCol(), getRow()+1) == Cell.DNO) || (getNature(getCol(), getRow()+1) == Cell.DWO) ) {
//							
//							turnL();
//							strafeR();
//						}
//					}
//					
//					else if(ncontent_col_neg_row_pos3.isMob().equals("So(PlayerService)")) {
//						target = (PlayerService)ncontent_col_neg_row_pos3;
//						
//						if( (getNature(getCol()-1, getRow()) == Cell.EMP) || (getNature(getCol()-1, getRow()) == Cell.DNO) || (getNature(getCol()-1, getRow()) == Cell.DWO) ) {
//							strafeL();
//						}
//						
//						else if( (getNature(getCol(), getRow()+1) == Cell.EMP) || (getNature(getCol(), getRow()+1) == Cell.DNO) || (getNature(getCol(), getRow()+1) == Cell.DWO) ) {
//							turnL();
//							strafeL();
//						}
//						
//					}*/								
//						
//					break;
//					
//				case E:
//					
//					Option<MobService> econtent_col_neg_row_pos = getContent(getCol()-1, getRow()+1);
//					Option<MobService> econtent_row_pos = getContent(getCol(), getRow()+1);
//					Option<MobService> econtent_col_pos1_row_pos = getContent(getCol()+1, getRow()+1);
//					Option<MobService> econtent_col_pos2_row_pos = getContent(getCol()+2, getRow()+1);
//					Option<MobService> econtent_col_pos3_row_pos = getContent(getCol()+3, getRow()+1);
//					
//					Option<MobService> econtent_col_neg = getContent(getCol()-1, getRow());					
//					Option<MobService> econtent_col_pos1 = getContent(getCol()+1, getRow());
//					Option<MobService> econtent_col_pos2 = getContent(getCol()+2, getRow());
//					Option<MobService> econtent_col_pos3 = getContent(getCol()+3, getRow());
//					
//					Option<MobService> econtent_col_neg_row_neg = getContent(getCol()-1, getRow()-1);
//					Option<MobService> econtent_row_neg = getContent(getCol(), getRow()-1);
//					Option<MobService> econtent_col_pos1_row_neg = getContent(getCol()+1, getRow()-1);
//					Option<MobService> econtent_col_pos2_row_neg = getContent(getCol()+2, getRow()-1);
//					Option<MobService> econtent_col_pos3_row_neg = getContent(getCol()+3, getRow()-1);
//					
//					if(econtent_row_pos.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)econtent_row_pos;
//						turnL();					
//						
//						attack();
//					}	
//					
//					else if(econtent_col_neg.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)econtent_col_neg;
//						turnL();
//						turnL();
//						
//						attack();
//						
//					}
//					
//					else if(econtent_col_pos1.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)econtent_col_pos1;
//						attack();
//					}
//					
//					else if(econtent_col_pos2.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)econtent_col_pos2;
//						forward();
//						
//					}
//					
//					else if(econtent_col_pos3.isMob().equals("So(PlayerService)")) {						
//						
//						target = (PlayerService)econtent_col_pos3;
//						
//						forward();
//					}
//					
//					else if(econtent_row_neg.isMob().equals("So(PlayerService)")) {						
//					
//						target = (PlayerService)econtent_row_neg;
//						turnR();
//						attack();
//					}
//					
//					else {
//						
//						switch(action) {
//						
//							case 0:
//								super.forward();
//								break;
//							case 1:
//								super.backward();
//								break;
//							case 2:
//								super.turnL();
//								break;
//							case 3:
//								super.turnR();
//								break;
//							case 4:
//								super.strafeL();
//								break;
//							case 5:
//								super.strafeR();
//								break;
//						}
//					}
//					
//				
//					break;
//					
//				case S:
//					
//					Option<MobService> scontent_col_neg_row_pos = getContent(getCol()-1, getRow()+1);
//					Option<MobService> scontent_col_neg = getContent(getCol()-1, getRow());
//					Option<MobService> scontent_col_neg_row_neg1 = getContent(getCol()-1, getRow()-1);
//					Option<MobService> scontent_col_neg_row_neg2 = getContent(getCol()-1, getRow()-2);
//					Option<MobService> scontent_col_neg_row_neg3 = getContent(getCol()-1, getRow()-3);
//					
//					Option<MobService> scontent_row_pos = getContent(getCol(), getRow()+1);					
//					Option<MobService> scontent_row_neg1 = getContent(getCol(), getRow()-1);
//					Option<MobService> scontent_row_neg2 = getContent(getCol(), getRow()-2);
//					Option<MobService> scontent_row_neg3 = getContent(getCol(), getRow()-3);
//					
//					Option<MobService> scontent_col_pos_row_pos = getContent(getCol()+1, getRow()+1);
//					Option<MobService> scontent_col_pos = getContent(getCol()+1, getRow());
//					Option<MobService> scontent_col_pos_row_neg1 = getContent(getCol()+1, getRow()-1);
//					Option<MobService> scontent_col_pos_row_neg2 = getContent(getCol()+1, getRow()-2);
//					Option<MobService> scontent_col_pos_row_neg3 = getContent(getCol()+1, getRow()-3);
//					
//					if(scontent_col_neg.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)scontent_col_neg;
//						turnR();					
//						
//						attack();
//					}	
//					
//					else if(scontent_row_pos.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)scontent_row_pos;
//						turnR();
//						turnR();
//						
//						attack();
//						
//					}
//					
//					else if(scontent_row_neg1.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)scontent_row_neg1;
//						attack();
//					}
//					
//					else if(scontent_row_neg2.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)scontent_row_neg2;
//						forward();
//						
//					}
//					
//					else if(scontent_row_neg3.isMob().equals("So(PlayerService)")) {						
//						
//						target = (PlayerService)scontent_row_neg3;
//						
//						forward();
//					}
//					
//					else if(scontent_col_pos.isMob().equals("So(PlayerService)")) {						
//					
//						target = (PlayerService)scontent_col_pos;
//						turnL();
//						attack();
//					}
//					
//					else {
//						
//						switch(action) {
//						
//							case 0:
//								super.forward();
//								break;
//							case 1:
//								super.backward();
//								break;
//							case 2:
//								super.turnL();
//								break;
//							case 3:
//								super.turnR();
//								break;
//							case 4:
//								super.strafeL();
//								break;
//							case 5:
//								super.strafeR();
//								break;
//						}
//				
//					}
//					
//					
//					break;
//					
//				case W:
//					
//					Option<MobService> wcontent_col_neg3_row_pos = getContent(getCol()-3, getRow()+1);
//					Option<MobService> wcontent_col_neg2_row_pos = getContent(getCol()-2, getRow()+1);
//					Option<MobService> wcontent_col_neg1_row_pos = getContent(getCol()-1, getRow()+1);
//					Option<MobService> wcontent_row_pos = getContent(getCol(), getRow()+1);
//					Option<MobService> wcontent_col_pos_row_pos = getContent(getCol()+1, getRow()+1);
//					
//					Option<MobService> wcontent_col_neg3 = getContent(getCol()-3, getRow());
//					Option<MobService> wcontent_col_neg2 = getContent(getCol()-2, getRow());
//					Option<MobService> wcontent_col_neg1 = getContent(getCol()-1, getRow());					
//					Option<MobService> wcontent_col_pos = getContent(getCol()+1, getRow());
//					
//					Option<MobService> wcontent_col_neg3_row_neg = getContent(getCol()-3, getRow()-1);
//					Option<MobService> wcontent_col_neg2_row_neg = getContent(getCol()-2, getRow()-1);
//					Option<MobService> wcontent_col_neg1_row_neg = getContent(getCol()-1, getRow()-1);
//					Option<MobService> wcontent_row_neg = getContent(getCol(), getRow()-1);
//					Option<MobService> wcontent_col_pos_row_neg = getContent(getCol()+1, getRow()-1);
//					
//					if(wcontent_row_pos.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)wcontent_row_pos;
//						turnR();					
//						
//						attack();
//					}	
//					
//					else if(wcontent_col_neg3.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)wcontent_col_neg3;
//						forward();
//						
//					}
//					
//					else if(wcontent_col_neg2.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)wcontent_col_neg2;
//						forward();
//					}
//					
//					else if(wcontent_col_neg1.isMob().equals("So(PlayerService)")) {
//						
//						target = (PlayerService)wcontent_col_neg1;
//						attack();
//						
//					}
//					
//					else if(wcontent_col_pos.isMob().equals("So(PlayerService)")) {						
//						
//						target = (PlayerService)wcontent_col_pos;
//						
//						attack();
//					}
//					
//					else if(wcontent_row_neg.isMob().equals("So(PlayerService)")) {						
//					
//						target = (PlayerService)wcontent_row_neg;
//						turnL();
//						attack();
//					}
//
//					else {
//						
//						switch(action) {
//							
//							case 0:
//								super.forward();
//								break;
//							case 1:
//								super.backward();
//								break;
//							case 2:
//								super.turnL();
//								break;
//							case 3:
//								super.turnR();
//								break;
//							case 4:
//								super.strafeL();
//								break;
//							case 5:
//								super.strafeR();
//								break;
//						}
//					}
//					
//					
//					break;
//					
//			
//			}
//			
//		} catch (PreConditionException | PostConditionException e) {
//			e.printStackTrace();
//		}			
//	}
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
