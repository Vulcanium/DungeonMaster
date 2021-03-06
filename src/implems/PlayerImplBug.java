package implems;

import contrats.PostConditionException;
import contrats.PreConditionException;
import services.EntityService;
import services.MobService;
import services.PlayerService;

public class PlayerImplBug extends PlayerImpl implements PlayerService{
	
	private Option<Command> cmd;
	private EntityService target;
	private Weapons weapon;
	private int targetHp;
	private boolean treasure;
	private boolean key;
	
	public PlayerImplBug() {
		
		cmd = new Option<Command>(null);//mettre par defaut null?
		weapon = Weapons.EMPTY;
	}

	@Override
	public Option<Command> getLastCom() {
		
		return cmd;
	}
	
	@Override
	public Weapons getWeapon() {
		
		return weapon;
	}

	@Override
	public EntityService getCible() {
		
		return target;
	}
	
	public void setCom(Option<Command> cmd) {this.cmd = cmd;}

	@Override
	public Option<MobService> getContent(int x, int y) {
		
		//à vérif
		Option<MobService> mob = new Option<MobService>(x, y);
		mob.chercheMob(x, y);
		return mob;
		
	}

	@Override
	public Cell getNature(int x, int y) throws PreConditionException {
		
		return getEnv().getCellNature(getCol()+x, getRow()+y); //à méditer 
	}

	@Override
	public boolean getViewable(int x, int y) throws PreConditionException {
		
		if(getFace() == Dir.N) {//pour l affichage des sprites					
				
			if( x == -1 && y == 2 && (getNature(-1, 1) == Cell.WLL || getNature(-1, 1) == Cell.DWC || getNature(-1, 1) == Cell.DNC) )
				return false;
				
			else {
					
				if( x == 0 && y == 2 && (getNature(0, 1) == Cell.WLL || getNature(0, 1) == Cell.DWC || getNature(0, 1) == Cell.DNC) )
					return false;
					
				else {
						
					if( x == 1 && y == 2 && (getNature(1, 1) == Cell.WLL || getNature(1, 1) == Cell.DWC || getNature(1, 1) == Cell.DNC) )
						return false;
					
					else {
							
						if( x == -1 && y == 3 && (getNature(-1, 2) == Cell.WLL || getNature(-1, 2) == Cell.DWC || getNature(-1, 2) == Cell.DNC || getNature(-1, 1) == Cell.WLL || getNature(-1, 1) == Cell.DWC || getNature(-1, 1) == Cell.DNC) )
							return false;
							
						else {
								
							if( x == 0 && y == 3 && (getNature(0, 2) == Cell.WLL || getNature(0, 2) == Cell.DWC || getNature(0, 2) == Cell.DNC || getNature(0, 1) == Cell.WLL || getNature(0, 1) == Cell.DWC || getNature(0, 1) == Cell.DNC ) )
								return false;
								
							else {
									
								if( x == 1 && y == 3 && (getNature(1, 2) == Cell.WLL || getNature(1, 2) == Cell.DWC || getNature(1, 2) == Cell.DNC || getNature(1, 1) == Cell.WLL || getNature(1, 1) == Cell.DWC || getNature(1, 1) == Cell.DNC ) )
									return false;
								else
									return true;
							}
						}
					}
				}
			}
		}
		
		else {
		
			if(getFace() == Dir.S) {
				
				if( x == -1 && y == -2 && (getNature(-1, -1) == Cell.WLL || getNature(-1, -1) == Cell.DWC || getNature(-1, -1) == Cell.DNC) )
					return false;
				
				else {
					
					if( x == 0 && y == -2 && (getNature(0, -1) == Cell.WLL || getNature(0, -1) == Cell.DWC || getNature(0, -1) == Cell.DNC) )
						return false;
					
					else {
						
						if( x == 1 && y == -2 && (getNature(1, -1) == Cell.WLL || getNature(1, -1) == Cell.DWC || getNature(1, -1) == Cell.DNC) )
							return false;
						
						else {
							
							if( x == -1 && y == -3 && (getNature(-1, -2) == Cell.WLL || getNature(-1, -2) == Cell.DWC || getNature(-1, -2) == Cell.DNC || getNature(-1, -1) == Cell.WLL || getNature(-1, -1) == Cell.DWC || getNature(-1, -1) == Cell.DNC) )
								return false;
							
							else {
								
								if( x == 0 && y == -3 && (getNature(0, -2) == Cell.WLL || getNature(0, -2) == Cell.DWC || getNature(0, -2) == Cell.DNC || getNature(0, -1) == Cell.WLL || getNature(0, -1) == Cell.DWC || getNature(0, -1) == Cell.DNC ) )
									return false;
								
								else {
									
									if( x == 1 && y == -3 && (getNature(1, -2) == Cell.WLL || getNature(1, -2) == Cell.DWC || getNature(1, -2) == Cell.DNC || getNature(1, -1) == Cell.WLL || getNature(1, -1) == Cell.DWC || getNature(1, -1) == Cell.DNC ) )
										return false;
									else
										return true;
								}
							}
						}
					}
				}
			}
			
			else {
				
				if(getFace() == Dir.E) {
					
					if( x == 2 && y == 1 && (getNature(1, 1) == Cell.WLL || getNature(1, 1) == Cell.DWC || getNature(1, 1) == Cell.DNC) )
						return false;
					
					else {
						
						if( x == 2 && y == 0 && (getNature(1, 0) == Cell.WLL || getNature(1, 0) == Cell.DWC || getNature(1, 0) == Cell.DNC) )
							return false;
						
						else {
							
							if( x == 2 && y == -1 && (getNature(1, -1) == Cell.WLL || getNature(1, -1) == Cell.DWC || getNature(1, -1) == Cell.DNC) )
								return false;
							
							else {
								
								if( x == 3 && y == 1 && (getNature(2, 1) == Cell.WLL || getNature(2, 1) == Cell.DWC || getNature(2, 1) == Cell.DNC || getNature(1, 1) == Cell.WLL || getNature(1, 1) == Cell.DWC || getNature(1, 1) == Cell.DNC) )
									return false;
								
								else {
									
									if( x == 3 && y == 0 && (getNature(2, 0) == Cell.WLL || getNature(2, 0) == Cell.DWC || getNature(2, 0) == Cell.DNC || getNature(1, 0) == Cell.WLL || getNature(1, 0) == Cell.DWC || getNature(1, 0) == Cell.DNC ) )
										return false;
									
									else {
										
										if( x == 3 && y == -1 && (getNature(2, -1) == Cell.WLL || getNature(2, -1) == Cell.DWC || getNature(2, -1) == Cell.DNC || getNature(1, -1) == Cell.WLL || getNature(1, -1) == Cell.DWC || getNature(1, -1) == Cell.DNC ) )
											return false;
										else
											return true;
									}
								}
							}
						}
					}
				}
				
				else { //Dir.W
				
					if( x == -2 && y == 1 && (getNature(-1, 1) == Cell.WLL || getNature(-1, 1) == Cell.DWC || getNature(-1, 1) == Cell.DNC) )
						return false;
					
					else {
						
						if( x == -2 && y == 0 && (getNature(-1, 0) == Cell.WLL || getNature(-1, 0) == Cell.DWC || getNature(-1, 0) == Cell.DNC) )
							return false;
						
						else {
							
							if( x == -2 && y == -1 && (getNature(-1, -1) == Cell.WLL || getNature(-1, -1) == Cell.DWC || getNature(-1, -1) == Cell.DNC) )
								return false;
							
							else {
								
								if( x == -3 && y == 1 && (getNature(-2, 1) == Cell.WLL || getNature(-2, 1) == Cell.DWC || getNature(-2, 1) == Cell.DNC || getNature(-1, 1) == Cell.WLL || getNature(-1, 1) == Cell.DWC || getNature(-1, 1) == Cell.DNC) )
									return false;
								
								else {
									
									if( x == -3 && y == 0 && (getNature(-2, 0) == Cell.WLL || getNature(-2, 0) == Cell.DWC || getNature(-2, 0) == Cell.DNC || getNature(-1, 0) == Cell.WLL || getNature(-1, 0) == Cell.DWC || getNature(-1, 0) == Cell.DNC ) )
										return false;
									
									else {
										
										if( x == -3 && y == -1 && (getNature(-2, -1) == Cell.WLL || getNature(-2, -1) == Cell.DWC || getNature(-2, -1) == Cell.DNC || getNature(-1, -1) == Cell.WLL || getNature(-1, -1) == Cell.DWC || getNature(-1, -1) == Cell.DNC ) )
											return false;
										else
											return true;
									}
								}
							}
						}
					}
				}
			}
		}
	}
		
	
	
	@Override
	public void step() {
		
		try {
			
//			Option<MobService> content_row_neg = getContent(getRow()-1, getCol());
//			Option<MobService> content_row_pos = getContent(getRow()+1, getCol());
//			Option<MobService> content_col_neg = getContent(getRow(), getCol()-1);
//			Option<MobService> content_col_pos = getContent(getRow(), getCol()+1);
		
			switch(cmd.getElem()) {
		
				case FF:
					super.backward();
					break;
					
				case BB:
					super.forward();
					break;
					
				case LL:
					super.strafeR();
					break;
					
				case RR:
					super.strafeL();
					break;
					
				case TL:
					super.turnR();
					break;
					
				case TR:
					super.turnL();
					break;
					
//				case ATK:
//					
//					if(content_row_neg.isMob().equals("So(EntityService)")) {
//						
//						target = (EntityService)content_row_neg;
//						attack();
//					}
//					
//					if(content_row_pos.isMob().equals("So(EntityService)")) {
//						
//						target = (EntityService)content_row_pos;
//						attack();
//					}
//					
//					if(content_col_pos.isMob().equals("So(EntityService)")) {
//						
//						target = (EntityService)content_col_pos;
//						attack();
//					}
//					
//					if(content_col_neg.isMob().equals("So(EntityService)")) {
//						
//						target = (EntityService)content_col_neg;
//						attack();
//					}
//					
//					break;
					
				default:
					break;
			}
			
			if(getNature(getRow(), getCol()) == Cell.CHESTO) {
				treasure = true;
			}
			
			if(getNature(getRow(), getCol()) == Cell.KEY) {
				key = true;
			}
		
		} catch (PreConditionException e) {
			e.printStackTrace();
		}
	}
	
	public void takeWeaponOrKey() throws PreConditionException {
		
		EnvironmentImpl env = (EnvironmentImpl) getEnv();
		
		switch(getFace()) {
		
			case N:
				
				if(getEnv().getCellNature(getCol(), getRow() + 1) == Cell.SWORD && weapon != Weapons.SWORD) {
					weapon = Weapons.WOODEN_STICK;
					env.getMap()[getCol()][getRow() + 1] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol(), getRow() + 1) == Cell.AXE && weapon != Weapons.AXE) {
					weapon = Weapons.DAGGER;
					env.getMap()[getCol()][getRow() + 1] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol(), getRow() + 1) == Cell.DAGGER && weapon != Weapons.DAGGER) {
					weapon = Weapons.AXE;
					env.getMap()[getCol()][getRow() + 1] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol(), getRow() + 1) == Cell.WOODEN_STICK && weapon != Weapons.WOODEN_STICK) {
					weapon = Weapons.SWORD;
					env.getMap()[getCol()][getRow() + 1] = Cell.EMP;
				}
				
				else {
					System.out.println("No sword at proximity or already have one");
				}
				
				break;
				
			case E:
				
				if(getEnv().getCellNature(getCol() + 1, getRow()) == Cell.SWORD && weapon != Weapons.SWORD) {
					weapon = Weapons.WOODEN_STICK;
					env.getMap()[getCol() + 1][getRow()] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol() + 1, getRow()) == Cell.AXE && weapon != Weapons.AXE) {
					weapon = Weapons.DAGGER;
					env.getMap()[getCol() + 1][getRow()] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol() + 1, getRow()) == Cell.DAGGER && weapon != Weapons.DAGGER) {
					weapon = Weapons.AXE;
					env.getMap()[getCol() + 1][getRow()] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol() + 1, getRow()) == Cell.WOODEN_STICK && weapon != Weapons.WOODEN_STICK) {
					weapon = Weapons.SWORD;
					env.getMap()[getCol() + 1][getRow()] = Cell.EMP;
				}
				
				else {
					System.out.println("No sword at proximity or already have one");
				}
				
				break;
				
			case S:
				
				if(getEnv().getCellNature(getCol(), getRow() - 1) == Cell.SWORD && weapon != Weapons.SWORD) {
					weapon = Weapons.WOODEN_STICK;
					env.getMap()[getCol()][getRow() - 1] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol(), getRow() - 1) == Cell.AXE && weapon != Weapons.AXE) {
					weapon = Weapons.DAGGER;
					env.getMap()[getCol()][getRow() - 1] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol(), getRow() - 1) == Cell.DAGGER && weapon != Weapons.DAGGER) {
					weapon = Weapons.AXE;
					env.getMap()[getCol()][getRow() - 1] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol(), getRow() - 1) == Cell.WOODEN_STICK && weapon != Weapons.WOODEN_STICK) {
					weapon = Weapons.SWORD;
					env.getMap()[getCol()][getRow() - 1] = Cell.EMP;
				}
				
				else {
					System.out.println("No sword at proximity or already have one");
				}
				
				break;
				
			case W:
				
				if(getEnv().getCellNature(getCol() - 1, getRow()) == Cell.SWORD && weapon != Weapons.SWORD) {
					weapon = Weapons.WOODEN_STICK;
					env.getMap()[getCol() - 1][getRow()] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol() - 1, getRow()) == Cell.AXE && weapon != Weapons.AXE) {
					weapon = Weapons.DAGGER;
					env.getMap()[getCol() - 1][getRow()] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol() - 1, getRow()) == Cell.DAGGER && weapon != Weapons.DAGGER) {
					weapon = Weapons.AXE;
					env.getMap()[getCol() - 1][getRow()] = Cell.EMP;
				}
				
				else if(getEnv().getCellNature(getCol() - 1, getRow()) == Cell.WOODEN_STICK && weapon != Weapons.WOODEN_STICK) {
					weapon = Weapons.SWORD;
					env.getMap()[getCol() - 1][getRow()] = Cell.EMP;
				}
				
				else {
					System.out.println("No sword at proximity or already have one");
				}
				
				break;
		}
	}
	
	public void dropWeapon() throws PreConditionException {
		
		EnvironmentImpl env = (EnvironmentImpl) getEnv();
		
		switch(getFace()) {
		
			case N:
				
				if(getEnv().getCellNature(getCol(), getRow() + 1) == Cell.EMP && weapon == Weapons.SWORD) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol()][getRow() + 1] = Cell.AXE;
					
				} 
				
				else if(getEnv().getCellNature(getCol(), getRow() + 1) == Cell.EMP && weapon == Weapons.AXE) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol()][getRow() + 1] = Cell.WOODEN_STICK;
				} 
				
				else if(getEnv().getCellNature(getCol(), getRow() + 1) == Cell.EMP && weapon == Weapons.DAGGER) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol()][getRow() + 1] = Cell.SWORD;
				}
				
				else if(getEnv().getCellNature(getCol(), getRow() + 1) == Cell.EMP && weapon == Weapons.WOODEN_STICK) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol()][getRow() + 1] = Cell.DAGGER;
				}
				
				else {
					System.out.println("Can't drop here or no weapon to drop");
				}
				
				break;
				
			case E:
				
				if(getEnv().getCellNature(getCol() + 1, getRow()) == Cell.EMP && weapon == Weapons.SWORD) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol() + 1][getRow()] = Cell.AXE;
				}
				
				else if(getEnv().getCellNature(getCol() + 1, getRow()) == Cell.EMP && weapon == Weapons.AXE) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol() + 1][getRow()] = Cell.WOODEN_STICK;
				}
				
				else if(getEnv().getCellNature(getCol() + 1, getRow()) == Cell.EMP && weapon == Weapons.DAGGER) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol() + 1][getRow()] = Cell.SWORD;
				}
				
				else if(getEnv().getCellNature(getCol() + 1, getRow()) == Cell.EMP && weapon == Weapons.WOODEN_STICK) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol() + 1][getRow()] = Cell.DAGGER;
				}
				
				else {
					System.out.println("Can't drop here or no weapon to drop");
				}
				
				break;
				
			case S:
				
				if(getEnv().getCellNature(getCol(), getRow() - 1) == Cell.EMP && weapon == Weapons.SWORD) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol()][getRow() - 1] = Cell.AXE;
				}
				
				else if(getEnv().getCellNature(getCol(), getRow() - 1) == Cell.EMP && weapon == Weapons.AXE) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol()][getRow() - 1] = Cell.WOODEN_STICK;
				}
				
				else if(getEnv().getCellNature(getCol(), getRow() - 1) == Cell.EMP && weapon == Weapons.DAGGER) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol()][getRow() - 1] = Cell.SWORD;
				}
				
				else if(getEnv().getCellNature(getCol(), getRow() - 1) == Cell.EMP && weapon == Weapons.WOODEN_STICK) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol()][getRow() - 1] = Cell.DAGGER;
				}
				
				else {
					System.out.println("Can't drop here or no weapon to drop");
				}
				
				break;
				
			case W:
				
				if(getEnv().getCellNature(getCol() - 1, getRow()) == Cell.EMP && weapon == Weapons.SWORD) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol() - 1][getRow()] = Cell.AXE;
				}
				
				else if(getEnv().getCellNature(getCol() - 1, getRow()) == Cell.EMP && weapon == Weapons.AXE) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol() - 1][getRow()] = Cell.WOODEN_STICK;
				}
				
				else if(getEnv().getCellNature(getCol() - 1, getRow()) == Cell.EMP && weapon == Weapons.DAGGER) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol() - 1][getRow()] = Cell.SWORD;
				}
				
				else if(getEnv().getCellNature(getCol() - 1, getRow()) == Cell.EMP && weapon == Weapons.WOODEN_STICK) {
					weapon = Weapons.EMPTY;
					env.getMap()[getCol() - 1][getRow()] = Cell.DAGGER;
				}
				
				else {
					System.out.println("Can't drop here or no weapon to drop");
				}
				
				break;
		}
	}
	
	@Override
	public void attack() throws PreConditionException, PostConditionException {
		
		targetHp = target.getHp();
		
		switch(weapon) {
			
			case EMPTY :
				targetHp = targetHp - 10;
				break;
				
			case AXE:
				targetHp = targetHp - 1;
				break;
				
			case DAGGER:
				targetHp = targetHp - 2;
				break;
				
			case SWORD:
				targetHp = targetHp - 1;
				break;
				
			case WOODEN_STICK:
				targetHp = targetHp - 10;
				break;
				
			default:
				break;
			
		}
	}
	
	@Override
	public boolean haveKey(){
		return key;
	}

	@Override
	public boolean haveTreasure(){
		return treasure;
	}
	
	@Override
	public boolean haveKeyAndTreasure() {
		return (key && treasure);
	}
}
