import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Maze {
	private static Cell[][] grid = new Cell[15][15];
	private static ArrayList<Cell> visited = new ArrayList<Cell>();
	private static int isubtract = 1;
	private MazePanel gamePanel;

	public Maze(MazePanel panel) { // secondary step could be an easy and hard version of th game with differnt dimnsions
		gamePanel = panel;
		for(int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j] = new Cell(i, j, Color.WHITE);
			}
		}
		grid[0][0].changeColor(Color.MAGENTA);
		grid[14][14].changeColor(Color.GREEN);
		visited.add(grid[0][0]);
		generateMaze(grid, 0, 0, false);
		
	}
	public static void generateMaze(Cell[][] grid, int row, int col, boolean isTraversing) {
		if(visited.get(visited.size()-1) != grid[row][col] && ((isTraversing == true && atEnd(grid, row, col) == false) || isTraversing == false))
			visited.add(grid[row][col]);// also only add it when you are traversing backwards and theres an open neighbor. UPDATE - just added this
		if(atEnd(grid, row, col)) {
			if(complete(grid)) {
				return;
			} else { 
				isubtract++;
				traverseBack(grid, visited.get(visited.size()-isubtract).getRow(), visited.get(visited.size()-isubtract).getCol()); 
			}
		} else {
			isubtract= 1;
		}

		try {
			int rand = (int)(Math.random()*4);
			switch(rand) {
			case 0://upper cell
				if(visited.indexOf(grid[row-1][col])==-1) { //if its not visited
					grid[row][col].changeTop(false);
					grid[row-1][col].changeBottom(false);
					generateMaze(grid, row-1, col, false);

				} else {
					generateMaze(grid,row,col, false);

				}
				break;
			case 1://right cell
				if(visited.indexOf(grid[row][col+1])==-1) {
					grid[row][col].changeRight(false);
					grid[row][col+1].changeLeft(false);
					generateMaze(grid, row, col+1, false);
				} else {
					generateMaze(grid,row,col, false);

				}
				break;
			case 2://bottom cell
				if(visited.indexOf(grid[row+1][col])==-1) {
					grid[row][col].changeBottom(false);
					grid[row+1][col].changeTop(false);
					generateMaze(grid, row+1, col, false);
				} else {
					generateMaze(grid,row,col, false);

				}
				break;
			default: //left cell
				if(visited.indexOf(grid[row][col-1])==-1) {
					grid[row][col].changeLeft(false);
					grid[row][col-1].changeRight(false);
					generateMaze(grid, row, col-1, false);
				} else {
					generateMaze(grid,row,col, false);

				}
				break;
			}

		} catch (IndexOutOfBoundsException e) {
			generateMaze(grid, row, col, false);
		}

		return;

	}

	public static boolean atEnd(Cell[][] grid, int row, int col) {

		if((row-1 == -1 || visited.indexOf(grid[row - 1][col]) != -1) && 
				(col+1 == grid[0].length || visited.indexOf(grid[row][col+1])!=-1) &&
				(row+1== grid.length || visited.indexOf(grid[row+1][col])!=-1) &&
				(col-1==-1 || visited.indexOf(grid[row][col-1])!=-1)) {
			return true;
		}
		return false;
	}

	public static void traverseBack(Cell[][] grid, int row, int col) {
		generateMaze(grid, row, col, true);
	}

	public static boolean complete(Cell[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j<grid[0].length; j++) {
				if (visited.indexOf(grid[i][j]) == -1)
					return false;
			}
		}
		return true;
	}
	
	void draw(Graphics g) {		
		g.setColor(Color.BLACK);
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				grid[i][j].draw(g);
			}
		}
		
	}
	public static Cell[][] getGrid() {
		return grid;
	}
	
	
}
