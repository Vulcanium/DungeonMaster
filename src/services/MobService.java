package services;

import contrats.PostConditionException;
import contrats.PreConditionException;
import implems.Dir;

public interface MobService {
	
	/*Observators*/
	
	public EnvironmentService getEnv();
	public int getCol();
	public int getRow();
	public Dir getFace();
	
	/*Invariants*/
	
	// \inv 0 <= getCol() < getEnv().getWidth() 
	// \inv 0 <= getRow() < getEnv().getHeight()
	// \inv getEnv().getCellNature(getCol(), getRow()) \not \in {WLL, DNC, DWC}
	
	/*Constructors*/
	
	// \pre 0 <= x < getEnv().getWidth() and 0 <= y < getEnv().getHeight()
	public void init(EnvironmentService env, int x, int y, Dir dir) throws PreConditionException, PostConditionException;
	// \post getCol() == x
	// \post getRow() == y
	// \post getFace() == dir
	// \post getEnv() == env
	
	/*Operators*/
	
	public void forward() throws PostConditionException, PreConditionException; 
	/* \post
	 * getFace()@pre == N => getEnv().getCellNature(getCol(), getRow()+1) \in {EMP, DWO}
	 * and getRow()+1 < getEnv().getHeight()
	 * and (getEnv().getCellContent(getCol(), getRow()+1) == No) => (getRow() == getRow()@pre + 1)
	 * and getCol() == getCol()@pre
 	 */
	/* \post
	 * getFace()@pre == N => getEnv().getCellNature(getCol(), getRow()+1) \not \in {EMP, DWO}
	 * or getRow()+1 >= getEnv().getHeight() 
	 * or (getEnv().getCellContent(getCol(), getRow()+1) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == E => getEnv().getCellNature(getCol()+1, getRow()) \in {EMP, DNO}
	 * and getCol()+1 < getEnv().getWidth() 
	 * and (getEnv().getCellContent(getCol()+1, getRow()) == No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre + 1
	 */
	/* \post
	 * getFace()@pre == E => getEnv().getCellNature(getCol()+1, getRow()) \not \in {EMP, DWO}
	 * or getCol()+1 >= getEnv().getWidth() 
	 * or (getEnv().getCellContent(getCol()+1, getRow()) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == S => getEnv().getCellNature(getCol(), getRow()-1) \in {EMP, DWO}
	 * and getRow()-1 >= 0 
	 * and (getEnv().getCellContent(getCol(), getRow()-1) == No) => (getRow() == getRow()@pre - 1)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == S => getEnv().getCellNature(getCol(), getRow()-1) \not \in {EMP, DWO}
	 * or getRow()-1 < 0 
	 * or (getEnv().getCellContent(getCol(), getRow()-1) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == W => getEnv().getCellNature(getCol()-1, getRow()) \in {EMP, DNO}
	 * and getCol()-1 >= 0 
	 * and (getEnv().getCellContent(getCol()-1, getRow()) == No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre - 1
	 */
	/* \post
	 * getFace()@pre == W => getEnv().getCellNature(getCol()-1, getRow()) \not \in {EMP, DNO}
	 * or getCol()-1 < 0 
	 * or (getEnv().getCellContent(getCol()-1, getRow()) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	
	public void turnL() throws PostConditionException, PreConditionException;
	// \post (getFace()@pre == N) => (getFace() == W)
	// \post (getFace()@pre == W) => (getFace() == S)
	// \post (getFace()@pre == S) => (getFace() == E)
	// \post (getFace()@pre == E) => (getFace() == N)
	// \post getCol() == getCol()@pre and getRow() == getRow()@pre
	
	//Pour la completude de la spec, nous pr�cisons que les lignes et les colonnes sont inchang�es au cours d'un quart de tour gauche
	
	public void turnR() throws PostConditionException, PreConditionException;
	// \post (getFace()@pre == N) => (getFace() == E)
	// \post (getFace()@pre == W) => (getFace() == N)
	// \post (getFace()@pre == S) => (getFace() == W)
	// \post (getFace()@pre == E) => (getFace() == S)
	// \post getCol() == getCol()@pre and getRow() == getRow()@pre
	
	//Pour la completude de la spec, nous pr�cisons que les lignes et les colonnes sont inchang�es au cours d'un quart de tour droit
	
	
	public void strafeL() throws PostConditionException, PreConditionException;
	/* \post
	 * getFace()@pre == N => getEnv().getCellNature(getCol()-1, getRow()) \in {EMP, DWO}
	 * and getCol()-1 >= 0
	 * and (getEnv().getCellContent(getCol()-1, getRow()) == No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre - 1
 	 */
	/* \post
	 * getFace()@pre == N => getEnv().getCellNature(getCol()-1, getRow()) \not \in {EMP, DWO}
	 * or getCol()-1 < 0
	 * or (getEnv().getCellContent(getCol()-1, getRow()) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == E => getEnv().getCellNature(getCol(), getRow()+1) \in {EMP, DNO}
	 * and getRow()+1 < getEnv().getHeight() 
	 * and (getEnv().getCellContent(getCol(), getRow()+1) == No) => (getRow() == getRow()@pre + 1)
	 * and getCol() == getCol()@pre 
	 */
	/* \post
	 * getFace()@pre == E => getEnv().getCellNature(getCol(), getRow()+1) \not \in {EMP, DWO}
	 * or getRow()+1 >= getEnv().getHeight() 
	 * or (getEnv().getCellContent(getCol(), getRow()+1) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == S => getEnv().getCellNature(getCol()+1, getRow()) \in {EMP, DWO}
	 * and getCol+1 < getEnv().getWidth()
	 * and (getEnv().getCellContent(getCol()+1, getRow()) == No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre + 1
	 */
	/* \post
	 * getFace()@pre == S => getEnv().getCellNature(getCol()+1, getRow()) \not \in {EMP, DWO}
	 * or getCol+1 >= getEnv().getWidth()
	 * or (getEnv().getCellContent(getCol()+1, getRow()) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == W => getEnv().getCellNature(getCol(), getRow()-1) \in {EMP, DNO}
	 * and getRow()-1 >= 0 
	 * and (getEnv().getCellContent(getCol(), getRow()-1) == No) => (getRow() == getRow()@pre - 1)
	 * and getCol() == getCol()@pre 
	 */
	/* \post
	 * getFace()@pre == W => getEnv().getCellNature(getCol(), getRow()-1) \not \in {EMP, DNO}
	 * or getRow()-1 < 0 
	 * or (getEnv().getCellContent(getCol(), getRow()-1) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	
	public void strafeR() throws PostConditionException, PreConditionException;
	/* \post
	 * getFace()@pre == N => getEnv().getCellNature(getCol()+1, getRow()) \in {EMP, DWO}
	 * and getCol()+1 < getEnv().getWidth()
	 * and (getEnv().getCellContent(getCol()+1, getRow()) == No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre + 1
 	 */
	/* \post
	 * getFace()@pre == N => getEnv().getCellNature(getCol()+1, getRow()) \not \in {EMP, DWO}
	 * or getCol()+1 >= getEnv().getWidth()
	 * or (getEnv().getCellContent(getCol()+1, getRow()) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == E => getEnv().getCellNature(getCol(), getRow()-1) \in {EMP, DNO}
	 * and getRow()-1 >= 0 
	 * and (getEnv().getCellContent(getCol(), getRow()-1) == No) => (getRow() == getRow()@pre - 1)
	 * and getCol() == getCol()@pre 
	 */
	/* \post
	 * getFace()@pre == E => getEnv().getCellNature(getCol(), getRow()-1) \not \in {EMP, DWO}
	 * or getRow()-1 < 0
	 * or (getEnv().getCellContent(getCol(), getRow()-1) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == S => getEnv().getCellNature(getCol()-1, getRow()) \in {EMP, DWO}
	 * and getCol-1 >= 0
	 * and (getEnv().getCellContent(getCol()-1, getRow()) == No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre - 1
	 */
	/* \post
	 * getFace()@pre == S => getEnv().getCellNature(getCol()-1, getRow()) \not \in {EMP, DWO}
	 * or getCol-1 < 0
	 * or (getEnv().getCellContent(getCol()-1, getRow()) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == W => getEnv().getCellNature(getCol(), getRow()+1) \in {EMP, DNO}
	 * and getRow()+1 < getEnv().getHeight()
	 * and (getEnv().getCellContent(getCol(), getRow()+1) == No) => (getRow() == getRow()@pre + 1)
	 * and getCol() == getCol()@pre 
	 */
	/* \post
	 * getFace()@pre == W => getEnv().getCellNature(getCol(), getRow()+1) \not \in {EMP, DNO}
	 * or getRow()+1 >= getEnv().getHeight()
	 * or (getEnv().getCellContent(getCol(), getRow()+1) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	
	public void backward() throws PostConditionException, PreConditionException;
	/* \post
	 * getFace()@pre == N => getEnv().getCellNature(getCol(), getRow()-1) \in {EMP, DWO}
	 * and getRow()-1 >= 0
	 * and (getEnv().getCellContent(getCol(), getRow()-1) == No) => (getRow() == getRow()@pre - 1)
	 * and getCol() == getCol()@pre
 	 */
	/* \post
	 * getFace()@pre == N => getEnv().getCellNature(getCol(), getRow()-1) \not \in {EMP, DWO}
	 * or getRow()-1 < 0
	 * or (getEnv().getCellContent(getCol(), getRow()-1) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == E => getEnv().getCellNature(getCol()-1, getRow()) \in {EMP, DNO}
	 * and getCol()-1 >= 0 
	 * and (getEnv().getCellContent(getCol()-1, getRow()) == No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre - 1
	 */
	/* \post
	 * getFace()@pre == E => getEnv().getCellNature(getCol()-1, getRow()) \not \in {EMP, DWO}
	 * or getCol()-1 < 0
	 * or (getEnv().getCellContent(getCol()-1, getRow()) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == S => getEnv().getCellNature(getCol(), getRow()+1) \in {EMP, DWO}
	 * and getRow()+1 < getEnv().getHeight()
	 * and (getEnv().getCellContent(getCol(), getRow()+1) == No) => (getRow() == getRow()@pre + 1)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == S => getEnv().getCellNature(getCol(), getRow()+1) \not \in {EMP, DWO}
	 * or getRow()+1 >= getEnv().getHeight()
	 * or (getEnv().getCellContent(getCol(), getRow()+1) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */
	/* \post
	 * getFace()@pre == W => getEnv().getCellNature(getCol()+1, getRow()) \in {EMP, DNO}
	 * and getCol()+1 < getEnv().getWidth() 
	 * and (getEnv().getCellContent(getCol()+1, getRow()) == No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre + 1
	 */
	/* \post
	 * getFace()@pre == W => getEnv().getCellNature(getCol()+1, getRow()) \not \in {EMP, DNO}
	 * or getCol()+1 >= getEnv().getWidth() 
	 * or (getEnv().getCellContent(getCol()+1, getRow()) != No) => (getRow() == getRow()@pre)
	 * and getCol() == getCol()@pre
	 */

}
