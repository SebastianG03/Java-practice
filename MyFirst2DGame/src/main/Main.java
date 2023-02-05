package main;

import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Adventure Tales");
		
		GamePanel gamePanel = new GamePanel();
		window.add(gamePanel);
		window.pack();
		
		window.setLocation(250, 70);
		window.setVisible(true);
		
		gamePanel.setupGame();
		gamePanel.startGameThread();
	}
}
