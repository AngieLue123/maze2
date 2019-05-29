
import java.awt.*;

import javax.swing.*;

public class MazeMain {
	public static void main (String[] args) {
		JFrame window = new JFrame("Maze Game");
		
		
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		
		MazePanel content = new MazePanel();
		MazeListener listener = new MazeListener(content);
		
		content.addKeyListener(listener);
		container.add(content, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu mazeMenu = new JMenu("Maze");
		
		JMenuItem quit = new JMenuItem("Quit");
		JMenuItem restart = new JMenuItem("Restart");
		
		quit.addActionListener(listener);
		restart.addActionListener(listener);
		mazeMenu.add(quit);
		mazeMenu.addSeparator();
		mazeMenu.add(restart);
		
		menuBar.add(mazeMenu);
		window.setJMenuBar(menuBar);
		window.setContentPane(container);
		
		window.setSize(600, 645);
		window.setLocation(100,100);
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setResizable(false);  // User can't change the window's size.
		window.setVisible(true);
		content.requestFocusInWindow();
	}

}
