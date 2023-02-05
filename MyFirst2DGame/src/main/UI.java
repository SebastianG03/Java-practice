package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

import object.OBJ_Key;

public class UI {
	GamePanel gp;
	Font arial_30, arial_80B;
	BufferedImage keyImage;
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
		OBJ_Key key = new OBJ_Key(gp);
		keyImage = key.image;
	}
	
	public void showMessage(String text) {
		message = text;
		messageOn = true;
	}
	
	public void draw(Graphics2D g2) {
		
		if(gameFinished) {
			g2.setFont(arial_30);
			g2.setColor(Color.WHITE);
			
			String text;
			int textLength;
			
			int x, y;
			
			text = "You found the treasure!";
			textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth / 2 - textLength / 2;  
			y = gp.screenHight / 2 + (gp.tileSize * 2);
			g2.drawString(text, x, y);
			
			text = "Your time is: " + dFormat.format(playTime) + "!";
			textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth / 2 - textLength / 2;  
			y = gp.screenHight / 2 + (gp.tileSize / 2);
			g2.drawString(text, x, y);
			
			g2.setFont(arial_80B);
			g2.setColor(Color.YELLOW);
			
			text = "Congratulations!";
			textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
			x = gp.screenWidth / 2 - textLength / 2;  
			y = gp.screenHight / 2 - (gp.tileSize * 2);
			g2.drawString(text, x, y);
			
			gp.gameThread = null;
		}else {
			g2.setFont(arial_30);
			g2.setColor(Color.WHITE);
			g2.drawImage(keyImage, gp.tileSize / 2, gp.tileSize / 2, gp.tileSize, gp.tileSize, null);
			g2.drawString("x " + gp.player.hasKey, 74, 60);
			
			//Time
			playTime += (double) 1 / 60;
			g2.drawString("Time: " + dFormat.format(playTime), gp.tileSize * 11, 60);
			
			//Message
			if(messageOn) {
				g2.setFont(g2.getFont().deriveFont(18F));
				g2.drawString(message, 600, 60);
				
				messageCounter++;
			}
			
			if(messageCounter > 120) {
				messageCounter = 0;
				messageOn = false;
			}
		}
	}
}
