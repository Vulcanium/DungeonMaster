package contrats;

import implems.Cell;
import implems.Dir;
import implems.Option;
import services.EnvironmentService;
import services.MobService;

public class MobContract extends MobDecorator {

	public MobContract(MobService ms) {
		super(ms);		
	}
	
	public EnvironmentService getEnv() {return super.getEnv();}
	public int getCol() {return super.getCol();}
	public int getRow() {return super.getRow();}
	public Dir getFace() {return super.getFace();}
	
	public void checkInvariant() throws InvariantException, PreConditionException{
		
		// \inv 0 <= getCol() < getEnv().getWidth() 
		if(! (0 <= getCol() && getCol() < getEnv().getWidth() )){
			throw new InvariantException("Erreur invariant 1 Mob !\\n");
		}
		
		// \inv 0 <= getRow() < getEnv().getHeight()
		if(! (0 <= getRow() && getCol() < getEnv().getHeight() )){
			throw new InvariantException("Erreur invariant 2 Mob !\\n");
		}
		
		// \inv getEnv().getCellNature(getCol(), getRow()) \not \in {WLL, DNC, DWC}
		if(! ( (getEnv().getCellNature(getCol(), getRow()) != Cell.WLL) 
		    || (getEnv().getCellNature(getCol(), getRow()) != Cell.DNC)
		    || (getEnv().getCellNature(getCol(), getRow()) != Cell.DWC) ) ){
			throw new InvariantException("Erreur invariant 3 Mob !\\n");
		}
		
	}
	
	
	public void init(EnvironmentService env, int x, int y, Dir dir) throws PreConditionException, PostConditionException{
		// \pre 0 <= x < getEnv().getWidth() and 0 <= y < getEnv().getHeight()
		if(! ( (0<=x && x<getEnv().getWidth()) && (0<=y && y<getEnv().getHeight()) ) ) {
			throw new PreConditionException("Erreur pre-condition init !\n");
		}
		
		//Traitement
		super.init(env, x, y, dir);
		
		// \post getCol() == x
		if(! (getCol() == x) ) {
			throw new PostConditionException("Erreur post-condition getCol du init !\n");
		}
		
		// \post getRow() == y
		if(! (getRow() == y) ) {
			throw new PostConditionException("Erreur post-condition getRow du init !\n");
		}
		
		// \post getFace() == dir
		if(! (getFace() == dir) ) {
			throw new PostConditionException("Erreur post-condition getFace du init !\n");
		}
		
		// \post getEnv() == env
		if(! (getEnv() == env) ) {
			throw new PostConditionException("Erreur post-condition getEnv du init !\n");
		}	
	}
	
	public void forward() throws PostConditionException, PreConditionException{
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
				
		//captures
		Dir face_atpre = getFace();
		int row_atpre = getRow();
		int col_atpre = getCol();
		
		//Traitement
		super.forward();
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
		
		/* \post
		 * getFace()@pre == N => getEnv().getCellNature(getCol(), getRow()+1) \in {EMP, DWO}
		 * and getRow()+1 < getEnv().getHeight()
		 * and (getEnv().getCellContent(getCol(), getRow()+1) == No) => (getRow() == getRow()@pre + 1)
		 * and getCol() == getCol()@pre
	 	 */
		if( ! (face_atpre == Dir.N && ( ( getEnv().getCellNature(getCol(), getRow()+1) == Cell.EMP) 
									   || getEnv().getCellNature(getCol(), getRow()+1) == Cell.DWO) ) 
									   && getRow()+1 < getEnv().getHeight()
									   && getEnv().getCellContent(getCol(), getRow()+1).isMob() == "No"
									   && getRow() == row_atpre+1
									   && getCol() == col_atpre ) {
			
			throw new PostConditionException("Erreur post-condition 1 de forward !\n");
		}
		
		/* \post
		 * getFace()@pre == N => getEnv().getCellNature(getCol(), getRow()+1) \not \in {EMP, DWO}
		 * or getRow()+1 >= getEnv().getHeight() 
		 * or (getEnv().getCellContent(getCol(), getRow()+1) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.N && ( ( getEnv().getCellNature(getCol(), getRow()+1) != Cell.EMP) 
				   && getEnv().getCellNature(getCol(), getRow()+1) != Cell.DWO) ) 
				   || getRow()+1 >= getEnv().getHeight()
				   || (getEnv().getCellContent(getCol(), getRow()+1).isMob() != "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 2 de forward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == E => getEnv().getCellNature(getCol()+1, getRow()) \in {EMP, DNO}
		 * and getCol()+1 < getEnv().getWidth() 
		 * and (getEnv().getCellContent(getCol()+1, getRow()) == No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre + 1
		 */
		if( ! (face_atpre == Dir.E && ( ( getEnv().getCellNature(getCol()+1, getRow()) == Cell.EMP) 
				   || getEnv().getCellNature(getCol()+1, getRow()) == Cell.DWO) ) 
				   && getCol()+1 < getEnv().getWidth()
				   && getEnv().getCellContent(getCol()+1, getRow()).isMob() == "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre+1 ) {

				throw new PostConditionException("Erreur post-condition 3 de forward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == E => getEnv().getCellNature(getCol()+1, getRow()) \not \in {EMP, DWO}
		 * or getCol()+1 >= getEnv().getWidth() 
		 * or (getEnv().getCellContent(getCol()+1, getRow()) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.E && ( ( getEnv().getCellNature(getCol()+1, getRow()) != Cell.EMP) 
				   && getEnv().getCellNature(getCol()+1, getRow()) != Cell.DWO) ) 
				   || getCol()+1 >= getEnv().getWidth()
				   || (getEnv().getCellContent(getCol()+1, getRow()).isMob() != "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 4 de forward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == S => getEnv().getCellNature(getCol(), getRow()-1) \in {EMP, DWO}
		 * and getRow()-1 >= 0 
		 * and (getEnv().getCellContent(getCol(), getRow()-1) == No) => (getRow() == getRow()@pre - 1)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.S && ( ( getEnv().getCellNature(getCol(), getRow()-1) == Cell.EMP) 
				   || getEnv().getCellNature(getCol(), getRow()-1) == Cell.DWO) ) 
				   && getRow()-1 >= 0
				   && getEnv().getCellContent(getCol(), getRow()-1).isMob() == "No"
				   && getRow() == row_atpre-1
				   && getCol() == col_atpre ) {

				throw new PostConditionException("Erreur post-condition 5 de forward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == S => getEnv().getCellNature(getCol(), getRow()-1) \not \in {EMP, DWO}
		 * or getRow()-1 < 0 
		 * or (getEnv().getCellContent(getCol(), getRow()-1) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.S && ( ( getEnv().getCellNature(getCol(), getRow()-1) != Cell.EMP) 
				   && getEnv().getCellNature(getCol(), getRow()-1) != Cell.DWO) ) 
				   || getRow()-1 < 0
				   || (getEnv().getCellContent(getCol(), getRow()-1).isMob() != "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 6 de forward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == W => getEnv().getCellNature(getCol()-1, getRow()) \in {EMP, DNO}
		 * and getCol()-1 >= 0 
		 * and (getEnv().getCellContent(getCol()-1, getRow()) == No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre - 1
		 */
		if( ! (face_atpre == Dir.W && ( ( getEnv().getCellNature(getCol()-1, getRow()) == Cell.EMP) 
				   || getEnv().getCellNature(getCol()-1, getRow()) == Cell.DWO) ) 
				   && getCol()-1 >= 0
				   && getEnv().getCellContent(getCol()-1, getRow()).isMob() == "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre-1 ) {

				throw new PostConditionException("Erreur post-condition 7 de forward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == W => getEnv().getCellNature(getCol()-1, getRow()) \not \in {EMP, DNO}
		 * or getCol()-1 < 0 
		 * or (getEnv().getCellContent(getCol()-1, getRow()) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.W && ( ( getEnv().getCellNature(getCol()-1, getRow()) != Cell.EMP) 
				   && getEnv().getCellNature(getCol()-1, getRow()) != Cell.DWO) ) 
				   || getCol()-1 < 0
				   || (getEnv().getCellContent(getCol()-1, getRow()).isMob() != "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 8 de forward !\n");
		}		
		
	}
	

	public void turnL() throws PostConditionException, PreConditionException{
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
				
		//captures
		Dir face_atpre = getFace();
		int row_atpre = getRow();
		int col_atpre = getCol();
		
		//Traitement
		super.turnL();
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
		
		// \post (getFace()@pre == N) => (getFace() == W)
		if(! (face_atpre == Dir.N && getFace() == Dir.W)) {
			throw new PostConditionException("Erreur post-condition 1 de turnL !\n");
		}
		
		// \post (getFace()@pre == W) => (getFace() == S)
		if(! (face_atpre == Dir.W && getFace() == Dir.S)) {
			throw new PostConditionException("Erreur post-condition 2 de turnL !\n");
		}
		
		// \post (getFace()@pre == S) => (getFace() == E)
		if(! (face_atpre == Dir.S && getFace() == Dir.E)) {
			throw new PostConditionException("Erreur post-condition 3 de turnL !\n");
		}
		
		// \post (getFace()@pre == E) => (getFace() == N)
		if(! (face_atpre == Dir.E && getFace() == Dir.N)) {
			throw new PostConditionException("Erreur post-condition 4 de turnL !\n");
		}
		
		// \post getCol() == getCol()@pre and getRow() == getRow()@pre
		if(! (getCol() == col_atpre && getRow() == row_atpre)) {
			throw new PostConditionException("Erreur post-condition 5 de turnL !\n");
		}
		
	}
	
	public void turnR() throws PostConditionException, PreConditionException{
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
				
		//captures
		Dir face_atpre = getFace();
		int row_atpre = getRow();
		int col_atpre = getCol();
		
		//Traitement
		super.turnR();
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
		
		// \post (getFace()@pre == N) => (getFace() == E)
		if(! (face_atpre == Dir.N && getFace() == Dir.E)) {
			throw new PostConditionException("Erreur post-condition 1 de turnR !\n");
		}
		
		// \post (getFace()@pre == W) => (getFace() == N)
		if(! (face_atpre == Dir.W && getFace() == Dir.N)) {
			throw new PostConditionException("Erreur post-condition 2 de turnR !\n");
		}
		
		// \post (getFace()@pre == S) => (getFace() == W)
		if(! (face_atpre == Dir.S && getFace() == Dir.W)) {
			throw new PostConditionException("Erreur post-condition 3 de turnR !\n");
		}
		
		// \post (getFace()@pre == E) => (getFace() == S)
		if(! (face_atpre == Dir.E && getFace() == Dir.S)) {
			throw new PostConditionException("Erreur post-condition 4 de turnR !\n");
		}
		
		// \post getCol() == getCol()@pre and getRow() == getRow()@pre
		if(! (getCol() == col_atpre && getRow() == row_atpre)) {
			throw new PostConditionException("Erreur post-condition 5 de turnR !\n");
		}
		
	}
	
	
	public void strafeL() throws PostConditionException, PreConditionException{
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
				
		//captures
		Dir face_atpre = getFace();
		int row_atpre = getRow();
		int col_atpre = getCol();
		
		//Traitement
		super.strafeL();
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
		
		/* \post
		 * getFace()@pre == N => getEnv().getCellNature(getCol()-1, getRow()) \in {EMP, DWO}
		 * and getCol()-1 >= 0
		 * and (getEnv().getCellContent(getCol()-1, getRow()) == No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre - 1
	 	 */
		if( ! (face_atpre == Dir.N && ( ( getEnv().getCellNature(getCol()-1, getRow()) == Cell.EMP) 
									   || getEnv().getCellNature(getCol()-1, getRow()) == Cell.DWO) ) 
									   && getCol()-1 >= 0
									   && getEnv().getCellContent(getCol()-1, getRow()).isMob() == "No"
									   && getRow() == row_atpre
									   && getCol() == col_atpre-1 ) {
			
			throw new PostConditionException("Erreur post-condition 1 de strafeL !\n");
		}
		
		/* \post
		 * getFace()@pre == N => getEnv().getCellNature(getCol()-1, getRow()) \not \in {EMP, DWO}
		 * or getCol()-1 < 0
		 * or (getEnv().getCellContent(getCol()-1, getRow()) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.N && ( ( getEnv().getCellNature(getCol()-1, getRow()) != Cell.EMP) 
				   && getEnv().getCellNature(getCol()-1, getRow()) != Cell.DWO) ) 
				   || getCol()-1 < 0
				   || (getEnv().getCellContent(getCol()-1, getRow()).isMob() != "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 2 de strafeL !\n");
		}
		
		
		/* \post
		 * getFace()@pre == E => getEnv().getCellNature(getCol(), getRow()+1) \in {EMP, DNO}
		 * and getRow()+1 < getEnv().getHeight() 
		 * and (getEnv().getCellContent(getCol(), getRow()+1) == No) => (getRow() == getRow()@pre + 1)
		 * and getCol() == getCol()@pre 
		 */
		if( ! (face_atpre == Dir.E && ( ( getEnv().getCellNature(getCol(), getRow()+1) == Cell.EMP) 
				   || getEnv().getCellNature(getCol(), getRow()+1) == Cell.DWO) ) 
				   && getRow()+1 < getEnv().getHeight()
				   && getEnv().getCellContent(getCol(), getRow()+1).isMob() == "No"
				   && getRow() == row_atpre+1
				   && getCol() == col_atpre ) {

				throw new PostConditionException("Erreur post-condition 3 de strafeL !\n");
		}
		
		
		/* \post
		 * getFace()@pre == E => getEnv().getCellNature(getCol(), getRow()+1) \not \in {EMP, DWO}
		 * or getRow()+1 >= getEnv().getHeight() 
		 * or (getEnv().getCellContent(getCol(), getRow()+1) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.E && ( ( getEnv().getCellNature(getCol(), getRow()+1) != Cell.EMP) 
				   && getEnv().getCellNature(getCol(), getRow()+1) != Cell.DWO) ) 
				   || getRow()+1 >= getEnv().getHeight()
				   || (getEnv().getCellContent(getCol(), getRow()+1).isMob() != "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 4 de strafeL !\n");
		}
		
		
		/* \post
		 * getFace()@pre == S => getEnv().getCellNature(getCol()+1, getRow()) \in {EMP, DWO}
		 * and getCol+1 < getEnv().getWidth()
		 * and (getEnv().getCellContent(getCol()+1, getRow()) == No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre + 1
		 */
		if( ! (face_atpre == Dir.S && ( ( getEnv().getCellNature(getCol()+1, getRow()) == Cell.EMP) 
				   || getEnv().getCellNature(getCol()+1, getRow()) == Cell.DWO) ) 
				   && getCol()+1 < getEnv().getWidth()
				   && getEnv().getCellContent(getCol()+1, getRow()).isMob() == "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre+1 ) {

				throw new PostConditionException("Erreur post-condition 5 de strafeL !\n");
		}
		
		
		/* \post
		 * getFace()@pre == S => getEnv().getCellNature(getCol()+1, getRow()) \not \in {EMP, DWO}
		 * or getCol+1 >= getEnv().getWidth()
		 * or (getEnv().getCellContent(getCol()+1, getRow()) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.S && ( ( getEnv().getCellNature(getCol()+1, getRow()) != Cell.EMP) 
				   && getEnv().getCellNature(getCol()+1, getRow()) != Cell.DWO) ) 
				   || getCol()+1 >= getEnv().getWidth()
				   || (getEnv().getCellContent(getCol()+1, getRow()).isMob() != "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 6 de strafeL !\n");
		}
		
		
		/* \post
		 * getFace()@pre == W => getEnv().getCellNature(getCol(), getRow()-1) \in {EMP, DNO}
		 * and getRow()-1 >= 0 
		 * and (getEnv().getCellContent(getCol(), getRow()-1) == No) => (getRow() == getRow()@pre - 1)
		 * and getCol() == getCol()@pre 
		 */
		if( ! (face_atpre == Dir.W && ( ( getEnv().getCellNature(getCol(), getRow()-1) == Cell.EMP) 
				   || getEnv().getCellNature(getCol(), getRow()-1) == Cell.DWO) ) 
				   && getRow()-1 >= 0
				   && getEnv().getCellContent(getCol(), getRow()-1).isMob() == "No"
				   && getRow() == row_atpre-1
				   && getCol() == col_atpre ) {

				throw new PostConditionException("Erreur post-condition 7 de strafeL !\n");
		}
		
		
		/* \post
		 * getFace()@pre == W => getEnv().getCellNature(getCol(), getRow()-1) \not \in {EMP, DNO}
		 * or getRow()-1 < 0 
		 * or (getEnv().getCellContent(getCol(), getRow()-1) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.W && ( ( getEnv().getCellNature(getCol(), getRow()-1) != Cell.EMP) 
				   && getEnv().getCellNature(getCol(), getRow()-1) != Cell.DWO) ) 
				   || getRow()-1 < 0
				   || (getEnv().getCellContent(getCol(), getRow()-1).isMob() != "No"
				   && getRow() == row_atpre
				   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 8 de strafeL !\n");
		}		
		
	}
	
	
	public void strafeR() throws PostConditionException, PreConditionException{
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
				
		//captures
		Dir face_atpre = getFace();
		int row_atpre = getRow();
		int col_atpre = getCol();
		
		//Traitement
		super.strafeR();
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
		
		/* \post
		 * getFace()@pre == N => getEnv().getCellNature(getCol()+1, getRow()) \in {EMP, DWO}
		 * and getCol()+1 < getEnv().getWidth()
		 * and (getEnv().getCellContent(getCol()+1, getRow()) == No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre + 1
	 	 */
		if( ! (face_atpre == Dir.N && ( ( getEnv().getCellNature(getCol()+1, getRow()) == Cell.EMP) 
									   || getEnv().getCellNature(getCol()+1, getRow()) == Cell.DWO) ) 
									   && getCol()+1 < getEnv().getWidth()
									   && getEnv().getCellContent(getCol()+1, getRow()).isMob() == "No"
									   && getRow() == row_atpre
									   && getCol() == col_atpre+1 ) {
			
			throw new PostConditionException("Erreur post-condition 1 de strafeR !\n");
		}
		
		/* \post
		 * getFace()@pre == N => getEnv().getCellNature(getCol()+1, getRow()) \not \in {EMP, DWO}
		 * or getCol()+1 >= getEnv().getWidth()
		 * or (getEnv().getCellContent(getCol()+1, getRow()) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.N && ( ( getEnv().getCellNature(getCol()+1, getRow()) != Cell.EMP) 
									   && getEnv().getCellNature(getCol()+1, getRow()) != Cell.DWO) ) 
				   				   	   || getCol()+1 >= getEnv().getWidth()
				   				       || (getEnv().getCellContent(getCol()+1, getRow()).isMob() != "No"
				   				       && getRow() == row_atpre
				   				       && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 2 de strafeR !\n");
		}
		
		
		/* \post
		 * getFace()@pre == E => getEnv().getCellNature(getCol(), getRow()-1) \in {EMP, DNO}
		 * and getRow()-1 >= 0 
		 * and (getEnv().getCellContent(getCol(), getRow()-1) == No) => (getRow() == getRow()@pre - 1)
		 * and getCol() == getCol()@pre 
		 */
		if( ! (face_atpre == Dir.E && ( ( getEnv().getCellNature(getCol(), getRow()-1) == Cell.EMP) 
				   				       || getEnv().getCellNature(getCol(), getRow()-1) == Cell.DWO) ) 
				   				       && getRow()-1 >= 0
				   				       && getEnv().getCellContent(getCol(), getRow()-1).isMob() == "No"
				   				       && getRow() == row_atpre-1
				   				       && getCol() == col_atpre ) {

			throw new PostConditionException("Erreur post-condition 3 de strafeR !\n");
		}
		
		
		/* \post
		 * getFace()@pre == E => getEnv().getCellNature(getCol(), getRow()-1) \not \in {EMP, DWO}
		 * or getRow()-1 < 0
		 * or (getEnv().getCellContent(getCol(), getRow()-1) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.E && ( ( getEnv().getCellNature(getCol(), getRow()-1) != Cell.EMP) 
				   				       && getEnv().getCellNature(getCol(), getRow()-1) != Cell.DWO) ) 
				   				       || getRow()-1 < 0
				   				       || (getEnv().getCellContent(getCol(), getRow()-1).isMob() != "No"
				   				       && getRow() == row_atpre
				   				       && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 4 de strafeR !\n");
		}
		
		
		/* \post
		 * getFace()@pre == S => getEnv().getCellNature(getCol()-1, getRow()) \in {EMP, DWO}
		 * and getCol-1 >= 0
		 * and (getEnv().getCellContent(getCol()-1, getRow()) == No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre - 1
		 */
		if( ! (face_atpre == Dir.S && ( ( getEnv().getCellNature(getCol()-1, getRow()) == Cell.EMP) 
				   				       || getEnv().getCellNature(getCol()-1, getRow()) == Cell.DWO) ) 
				   				       && getCol()-1 >= 0
				   				       && getEnv().getCellContent(getCol()-1, getRow()).isMob() == "No"
				   				       && getRow() == row_atpre
				   				       && getCol() == col_atpre-1 ) {

			throw new PostConditionException("Erreur post-condition 5 de strafeR !\n");
		}
		
		
		/* \post
		 * getFace()@pre == S => getEnv().getCellNature(getCol()-1, getRow()) \not \in {EMP, DWO}
		 * or getCol-1 < 0
		 * or (getEnv().getCellContent(getCol()-1, getRow()) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.S && ( ( getEnv().getCellNature(getCol()-1, getRow()) != Cell.EMP) 
				   				       && getEnv().getCellNature(getCol()-1, getRow()) != Cell.DWO) ) 
								       || getCol()-1 < 0
								       || (getEnv().getCellContent(getCol()-1, getRow()).isMob() != "No"
								       && getRow() == row_atpre
								       && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 6 de strafeR !\n");
		}
		
		
		/* \post
		 * getFace()@pre == W => getEnv().getCellNature(getCol(), getRow()+1) \in {EMP, DNO}
		 * and getRow()+1 < getEnv().getHeight()
		 * and (getEnv().getCellContent(getCol(), getRow()+1) == No) => (getRow() == getRow()@pre + 1)
		 * and getCol() == getCol()@pre 
		 */
		if( ! (face_atpre == Dir.W && ( ( getEnv().getCellNature(getCol(), getRow()+1) == Cell.EMP) 
				   				       || getEnv().getCellNature(getCol(), getRow()+1) == Cell.DWO) ) 
								       && getRow()-1 < getEnv().getHeight()
				   				       && getEnv().getCellContent(getCol(), getRow()+1).isMob() == "No"
				   				       && getRow() == row_atpre+1
				   				       && getCol() == col_atpre ) {

			throw new PostConditionException("Erreur post-condition 7 de strafeR !\n");
		}
		
		
		/* \post
		 * getFace()@pre == W => getEnv().getCellNature(getCol(), getRow()+1) \not \in {EMP, DNO}
		 * or getRow()+1 >= getEnv().getHeight()
		 * or (getEnv().getCellContent(getCol(), getRow()+1) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.W && ( ( getEnv().getCellNature(getCol(), getRow()+1) != Cell.EMP) 
								       && getEnv().getCellNature(getCol(), getRow()+1) != Cell.DWO) ) 
								       || getRow()-1 >= getEnv().getHeight()
								       || (getEnv().getCellContent(getCol(), getRow()+1).isMob() != "No"
								       && getRow() == row_atpre
								       && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 8 de strafeR !\n");
		}		
		
	}
	
	
	public void backward() throws PostConditionException, PreConditionException{
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
				
		//captures
		Dir face_atpre = getFace();
		int row_atpre = getRow();
		int col_atpre = getCol();
		
		//Traitement
		super.backward();
		
		// \inv
		try {
			checkInvariant();
		} catch (InvariantException | PreConditionException e) {			
			e.printStackTrace();
		}
		
		/* \post
		 * getFace()@pre == N => getEnv().getCellNature(getCol(), getRow()-1) \in {EMP, DWO}
		 * and getRow()-1 >= 0
		 * and (getEnv().getCellContent(getCol(), getRow()-1) == No) => (getRow() == getRow()@pre - 1)
		 * and getCol() == getCol()@pre
	 	 */
		if( ! (face_atpre == Dir.N && ( ( getEnv().getCellNature(getCol(), getRow()-1) == Cell.EMP) 
									   || getEnv().getCellNature(getCol(), getRow()-1) == Cell.DWO) ) 
									   && getRow()-1 >= 0
									   && getEnv().getCellContent(getCol(), getRow()-1).isMob() == "No"
									   && getRow() == row_atpre-1
									   && getCol() == col_atpre ) {
			
			throw new PostConditionException("Erreur post-condition 1 de backward !\n");
		}
		
		/* \post
		 * getFace()@pre == N => getEnv().getCellNature(getCol(), getRow()-1) \not \in {EMP, DWO}
		 * or getRow()-1 < 0
		 * or (getEnv().getCellContent(getCol(), getRow()-1) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.N && ( ( getEnv().getCellNature(getCol(), getRow()-1) != Cell.EMP) 
				   					   && getEnv().getCellNature(getCol(), getRow()-1) != Cell.DWO) ) 
				   					   || getRow()-1 < 0
				   					  || (getEnv().getCellContent(getCol(), getRow()-1).isMob() != "No"
				   		  			   && getRow() == row_atpre
				   					   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 2 de backward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == E => getEnv().getCellNature(getCol()-1, getRow()) \in {EMP, DNO}
		 * and getCol()-1 >= 0 
		 * and (getEnv().getCellContent(getCol()-1, getRow()) == No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre - 1
		 */
		if( ! (face_atpre == Dir.E && ( ( getEnv().getCellNature(getCol()-1, getRow()) == Cell.EMP) 
									   || getEnv().getCellNature(getCol()-1, getRow()) == Cell.DWO) ) 
				   					   && getCol()-1 >= 0 
				   					   && getEnv().getCellContent(getCol()-1, getRow()).isMob() == "No"
				   					   && getRow() == row_atpre
				   					   && getCol() == col_atpre-1 ) {

				throw new PostConditionException("Erreur post-condition 3 de backward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == E => getEnv().getCellNature(getCol()-1, getRow()) \not \in {EMP, DWO}
		 * or getCol()-1 < 0
		 * or (getEnv().getCellContent(getCol()-1, getRow()) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.E && ( ( getEnv().getCellNature(getCol()-1, getRow()) != Cell.EMP) 
				   				       && getEnv().getCellNature(getCol()-1, getRow()) != Cell.DWO) ) 
								       || getCol()-1 < 0
								      || (getEnv().getCellContent(getCol()-1, getRow()).isMob() != "No"
								       && getRow() == row_atpre
								       && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 4 de backward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == S => getEnv().getCellNature(getCol(), getRow()+1) \in {EMP, DWO}
		 * and getRow()+1 < getEnv().getHeight()
		 * and (getEnv().getCellContent(getCol(), getRow()+1) == No) => (getRow() == getRow()@pre + 1)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.S && ( ( getEnv().getCellNature(getCol(), getRow()+1) == Cell.EMP) 
									   || getEnv().getCellNature(getCol(), getRow()+1) == Cell.DWO) ) 
									   && getRow()+1 < getEnv().getHeight()
									   && getEnv().getCellContent(getCol(), getRow()+1).isMob() == "No"
									   && getRow() == row_atpre+1
									   && getCol() == col_atpre ) {

				throw new PostConditionException("Erreur post-condition 5 de backward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == S => getEnv().getCellNature(getCol(), getRow()+1) \not \in {EMP, DWO}
		 * or getRow()+1 >= getEnv().getHeight()
		 * or (getEnv().getCellContent(getCol(), getRow()+1) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.S && ( ( getEnv().getCellNature(getCol(), getRow()+1) != Cell.EMP) 
				   					   && getEnv().getCellNature(getCol(), getRow()+1) != Cell.DWO) ) 
									   || getRow()+1 >= getEnv().getHeight()
									  || (getEnv().getCellContent(getCol(), getRow()+1).isMob() != "No"
									   && getRow() == row_atpre
									   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 6 de backward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == W => getEnv().getCellNature(getCol()+1, getRow()) \in {EMP, DNO}
		 * and getCol()+1 < getEnv().getWidth() 
		 * and (getEnv().getCellContent(getCol()+1, getRow()) == No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre + 1
		 */
		if( ! (face_atpre == Dir.W && ( ( getEnv().getCellNature(getCol()+1, getRow()) == Cell.EMP) 
				   					   || getEnv().getCellNature(getCol()+1, getRow()) == Cell.DWO) ) 
									   && getCol()+1 < getEnv().getWidth() 
									   && getEnv().getCellContent(getCol()+1, getRow()).isMob() == "No"
									   && getRow() == row_atpre
									   && getCol() == col_atpre+1 ) {

				throw new PostConditionException("Erreur post-condition 7 de backward !\n");
		}
		
		
		/* \post
		 * getFace()@pre == W => getEnv().getCellNature(getCol()+1, getRow()) \not \in {EMP, DNO}
		 * or getCol()+1 >= getEnv().getWidth() 
		 * or (getEnv().getCellContent(getCol()+1, getRow()) != No) => (getRow() == getRow()@pre)
		 * and getCol() == getCol()@pre
		 */
		if( ! (face_atpre == Dir.W && ( ( getEnv().getCellNature(getCol()+1, getRow()) != Cell.EMP) 
									   && getEnv().getCellNature(getCol()+1, getRow()) != Cell.DWO) ) 
									   || getCol()+1 >= getEnv().getWidth() 
									  || (getEnv().getCellContent(getCol()+1, getRow()).isMob() != "No"
									   && getRow() == row_atpre
									   && getCol() == col_atpre ) ) {

			throw new PostConditionException("Erreur post-condition 8 de backward !\n");
		}		
		
	}
	

}
