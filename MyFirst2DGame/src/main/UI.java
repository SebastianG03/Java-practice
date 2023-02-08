package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

import javax.print.DocFlavor;

public class UI {
	GamePanel gp;
	Graphics2D g2;
	Font arial_30, arial_80B;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	
	double playTime;
	DecimalFormat dFormat = new DecimalFormat("#0.00");
	
	public UI(GamePanel gp) {
		this.gp = gp;
		arial_30 = new Font("Arial", Font.PLAIN, 30);
		arial_80B = new Font("Arial", Font.BOLD, 80);
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {

		this.g2 = g2;
		g2.setFont(arial_30);
		g2.setColor(Color.WHITE);

		if (gp.gameState == gp.playState) {
//			@TODO
		} else {
			drawPauseScreen();
		}
	}

	public void drawPauseScreen() {

		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
		String text = "PAUSED";
		int x = getPauseTextPosition(text);
		int y = gp.screenHight / 2;

		g2.drawString(text, x, y);

	}

	public int getPauseTextPosition(String text) {
		return (gp.screenWidth - (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth()) / 2;
	}
}
