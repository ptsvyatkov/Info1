import java.security.SecureRandom;
import java.util.*;
/**
 * Maintain the environment for a 2D cellular automaton.
 * 
 * @author David J. Barnes
 * @version  2016.02.29
 */
public class Environment
{
    // Default size for the environment.
    private static final int DEFAULT_ROWS = 50;
    private static final int DEFAULT_COLS = 50;
    
    // The grid of cells.
    private Cell[][] cells;
    // Visualization of the environment.
    private final EnvironmentView view;

    /**
     * Create an environment with the default size.
     */
    public Environment()
    {
        this(DEFAULT_ROWS, DEFAULT_COLS);
    }

    /**
     * Create an environment with the given size.
     * @param numRows The number of rows.
     * @param numCols The number of cols;
     */
    public Environment(int numRows, int numCols)
    {
        setup(numRows, numCols);
        randomize();
        view = new EnvironmentView(this, numRows, numCols);
        view.showCells();
    }
    
    /**
     * Run the automaton for one step.
     */
    public void step()
    {
        int numRows = cells.length;
        int numCols = cells[0].length;
        // Build a record of the next state of each cell.
        int[][] nextStates = new int[numRows][numCols];
        // Ask each cell to determine its next state.
        for(int row = 0; row < numRows; row++) {
            int[] rowOfStates = nextStates[row];
            for(int col = 0; col < numCols; col++) {
                rowOfStates[col] = cells[row][col].getNextState();
            }
        }
        // Update the cells' states.
        for(int row = 0; row < numRows; row++) {
            int[] rowOfStates = nextStates[row];
            for(int col = 0; col < numCols; col++) {
                setCellState(row, col, rowOfStates[col]);
            }
        }
    }
    
    /**
     * Reset the state of the automaton to all DEAD.
     */
    public void reset()
    {
        int numRows = cells.length;
        int numCols = cells[0].length;
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                setCellState(row, col, Cell.DEAD);
            }
        }
    }
    
    /**
     * Creates a oscillate pattern
     */
    public void oscillator() 
    {
        int numRows = cells.length;
        int numCols = cells[0].length;
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                 setCellState(row, col, Cell.ALIVE);                
            }
        }   
        int midRows = numRows/2;
        int midCols = numCols/2;
        setCellState(midRows  ,midCols,     Cell.DEAD); 
        setCellState(midRows+1,midCols-1, Cell.DEAD);
        setCellState(midRows-1,midCols-1, Cell.DEAD);
        setCellState(midRows+1,midCols,   Cell.DEAD);
        setCellState(midRows-1,midCols+1, Cell.DEAD);
        setCellState(midRows+1,midCols+1, Cell.DEAD);
        setCellState(midRows-1,midCols+1, Cell.DEAD);       
    }
    
    /**
     * Creates an dead ship surrounded by live cells.
     */
    public void deathShip() 
    {
        int numRows = cells.length;
        int numCols = cells[0].length;
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                 setCellState(row, col, Cell.ALIVE);                
            }
        }   
        int midRows = numRows/2;
        int midCols = numCols/2;
        setCellState(midRows,midCols, Cell.DEAD);
        setCellState(midRows+2,midCols, Cell.DEAD);
        setCellState(midRows+1,midCols+1, Cell.DEAD);
        setCellState(midRows+1,midCols+2, Cell.DEAD);
        setCellState(midRows+2,midCols+1, Cell.DEAD);       
    }
    
    /**
     * Creates an ship full of live in a sea of dead cells.
     */
    public void aliveShip() 
    {
        int numRows = cells.length;
        int numCols = cells[0].length;
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                 setCellState(row, col,Cell.DEAD);                
            }
        }   
        int midRows = numRows/2;
        int midCols = numCols/2;
        setCellState(midRows,midCols,Cell.ALIVE);
        setCellState(midRows+2,midCols,Cell.ALIVE);
        setCellState(midRows+1,midCols+1,Cell.ALIVE);
        setCellState(midRows+1,midCols+2,Cell.ALIVE);
        setCellState(midRows+2,midCols+1,Cell.ALIVE);
    }
    
    /**
     * Generate a random setup.
     */
    public void randomize()
    {
        int numRows = cells.length;
        int numCols = cells[0].length;
        SecureRandom rand = new SecureRandom();
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                setCellState(row, col, rand.nextInt(Cell.NUM_STATES));
            }
        }
    }
    
    /**
     * Set the state of one cell.
     * @param row The cell's row.
     * @param col The cell's col.
     * @param state The cell's state.
     */
    public void setCellState(int row, int col, int state)
    {
        cells[row][col].setState(state);
    }
    
    /**
     * Return the grid of cells.
     * @return The grid of cells.
     */
    public Cell[][] getCells()
    {
        return cells;
    }
    
    /**
     * Setup a new environment of the given size.
     * @param numRows The number of rows.
     * @param numCols The number of cols;
     */
    private void setup(int numRows, int numCols)
    {
        cells = new Cell[numRows][numCols];
        for(int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                cells[row][col] = new Cell();
            }
        }
        setupNeighbors();
    }
    
    /**
     * Give to a cell a list of its neighbors.
     */
    private void setupNeighbors()
    {
        int numRows = cells.length;
        int numCols = cells[0].length;
        // Allow for 8 neighbors plus the cell.
        ArrayList<Cell> neighbors = new ArrayList<>(9);
        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                Cell cell = cells[row][col];
                // This process will also include the cell.
                for(int dr = -1; dr <= 1; dr++) {
                    for(int dc = -1; dc <= 1; dc++) {                        
                        int nr = (row + dr);
                        int nc = (col + dc);                       
                        if(nr>=0 && nr<numRows && nc>=0 && nc<numCols){
                          //add neigbors INSIDE the bounds
                          neighbors.add(cells[nr][nc]);
                        } else {
                          //add neighbors OUTSIDE the bounds as DEAD
                          neighbors.add(new Cell());
                        }
                    }
                }
                // The neighbours should not include the cell at
                // (row,col) so remove it.
                neighbors.remove(cell);
                cell.setNeighbors(neighbors);
                neighbors.clear();
            }
        }
    }
}
