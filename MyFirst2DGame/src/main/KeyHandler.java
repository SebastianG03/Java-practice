package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	GamePanel gp;
	public boolean upPressed, leftPressed, rightPressed, downPressed, checkDrawTime = false;
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}

	public void keyTyped(KeyEvent e) {
		
	}

	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		//PLAVER MOVEMENT
		if(code == KeyEvent.VK_W) upPressed = true;
		if(code == KeyEvent.VK_S) downPressed = true;
		if(code == KeyEvent.VK_A) leftPressed = true;
		if(code == KeyEvent.VK_D) rightPressed = true;
		if(code == KeyEvent.VK_Q) System.exit(0);
		//GAME STATE
		if(code == KeyEvent.VK_ESCAPE)
			gp.gameState = (gp.gameState == gp.playState)? gp.pauseState : gp.playState;
		
		//Debug
		checkDrawTime = (code == KeyEvent.VK_T && (!checkDrawTime));
	}

	public void keyReleased(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) upPressed = false;
		if(code == KeyEvent.VK_S) downPressed = false;
		if(code == KeyEvent.VK_A) leftPressed = false;
		if(code == KeyEvent.VK_D) rightPressed = false;
	}

}
