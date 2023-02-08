package entity;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	KeyHandler keyH;
	
	public final int screenX;
	public final int screenY;

	public Player(GamePanel gp, KeyHandler keyH) {
		super(gp);
		this.keyH = keyH;
		
		screenX = (gp.screenWidth / 2) - (gp.tileSize / 2);
		screenY = (gp.screenHight / 2) - (gp.tileSize / 2);
		
		solidArea = new Rectangle();
		solidArea.x = 8;
		solidArea.y = 16;
		solidAreaDefaultX = solidArea.x;
		solidAreaDefaultY = solidArea.y;
		solidArea.width = 32;
		solidArea.height = 32;
		
		setDefaultValues();
		getPlayerImage();
	}
	
	public void setDefaultValues() {
		//Players default position
		worldX = gp.tileSize * 23;
		worldY = gp.tileSize * 21;
		speed = 4;
		direction = "down";
	}
	
	public void getPlayerImage() {
		up1 = setup("/player/boy_up_1");
		up2 = setup("/player/boy_up_2");
		down1 = setup("/player/boy_down_1");
		down2 = setup("/player/boy_down_2");
		left1 = setup("/player/boy_left_1");
		left2 = setup("/player/boy_left_2");
		right1 = setup("/player/boy_right_1");
		right2 = setup("/player/boy_right_2");
	}

	public void update() {
		if(keyH.downPressed || keyH.leftPressed || keyH.rightPressed || keyH.upPressed) {
			if(keyH.upPressed) direction = "up";
			if(keyH.downPressed) direction = "down";
			if(keyH.leftPressed) direction = "left";
			if(keyH.rightPressed) direction = "right";
			spriteCounter++;

			//Check Tile Collision
			collisionOn = false;
			gp.cChecker.checkTile(this);

			//Check Object Collision
			int objIndex = gp.cChecker.checkObject(this, true);
			pickUpObject(objIndex);

			if(!collisionOn) {
				switch (direction) {
					case "up" -> worldY -= speed;
					case "down" -> worldY += speed;
					case "left" -> worldX -= speed;
					case "right" -> worldX += speed;
				}
			}

			if(spriteCounter > 10) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}else if(spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}

	public void pickUpObject(int index) {
		if(index != 999) {

		}
	}

	public void draw(Graphics2D g2) {
		BufferedImage image = null;

		switch (direction) {
			case "up" -> {
				if (spriteNum == 1) image = up1;
				if (spriteNum == 2) image = up2;
			}
			case "down" -> {
				if (spriteNum == 1) image = down1;
				if (spriteNum == 2) image = down2;
			}
			case "left" -> {
				if (spriteNum == 1) image = left1;
				if (spriteNum == 2) image = left2;
			}
			case "right" -> {
				if (spriteNum == 1) image = right1;
				if (spriteNum == 2) image = right2;
			}
		}

		g2.drawImage(image, screenX, screenY, null);
	}
}
