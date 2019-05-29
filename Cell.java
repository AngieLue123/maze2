import java.awt.Color;
import java.awt.Graphics;

public class Cell {
	private boolean top=true; 
	private boolean left=true;
	private boolean bottom = true;
	private boolean right = true;
	private int x;
	private int y;
	private int row;
	private int col;
	private int dimension = 15	;
	private Color c;
	
	public Cell(int row, int col, Color c) {
		this.row = row;
		this.col = col;
		this.c = c;
		x = (int)((600/dimension) * col);
		y = (int)((600/dimension) * row);
	}
	
	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}


	public boolean isTop() {
		return top;
	}

	public void setTop(boolean top) {
		this.top = top;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isBottom() {
		return bottom;
	}

	public void setBottom(boolean bottom) {
		this.bottom = bottom;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void changeTop(boolean b) {
		top = b;
	}
	public void changeBottom(boolean b) {
		bottom = b;
	}
	public void changeRight(boolean b) {
		right = b;
	}
	public void changeLeft(boolean b) {
		left = b;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void changeColor(Color color) {
		c = color;
	}
	
	
	void draw(Graphics g) {
		g.setColor(Color.BLACK);

		if(left) {
			g.drawLine(x, y, x, y + (int)(600/dimension));
		}
		if(top) {
			g.drawLine(x, y, x+ (int)(600/dimension), y);
		}
		if(right) {
			g.drawLine(x+ (int)(600/dimension), y, x+ (int)(600/dimension), y + (int)(600/dimension));
		}
		if(bottom) {
			g.drawLine(x, y + (int)(600/dimension), x+ (int)(600/dimension), y + (int)(600/dimension));
		}
		g.setColor(c);
		g.fillRect(x+2, y+2, (int)(600/dimension)-2, (int)(600/dimension)-2);
	}
}
