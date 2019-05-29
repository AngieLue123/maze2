import java.awt.Graphics;

import javax.swing.JPanel;

public class MazePanel extends JPanel{
	private Maze maze;
	private int currentRow = 0;
	private int currentCol = 0;
	
	//insert change row and column (up and down and left and right buttons clickd)
	public MazePanel() {
		maze = new Maze(this);
		//MazeListener l = new MazeListener(this);
		this.repaint();
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);  
		maze.draw(g); //need a draw method in maze class
	}
	
	public void restart() {
		maze = new Maze(this);
		this.repaint();
	}
	
	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void goUp() {
		currentRow --;
	}

	public int getCurrentCol() {
		return currentCol;
	}

	public void goLeft() {
		currentCol --;
	}
	
	public void goRight() {
		currentCol++;
	}
	public void goDown() {
		currentRow++;
	}
}
