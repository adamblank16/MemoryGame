package MemoryGame.view;
import java.util.*;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;

public class CardFace 
{
	public ArrayList <ImageIcon> pic = new ArrayList<ImageIcon> ();
	public Icon frontCard;
    public ArrayList HalloweenCards()
    {
		try{
			URL resource = this.getClass().getClassLoader().getResource("witch.jpg");
			Image witch = ImageIO.read(resource);
			witch = witch.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(witch));
			//pic.add(new ImageIcon(witch));
			
			resource = this.getClass().getClassLoader().getResource("pumpking.jpg");
			Image pumpkin = ImageIO.read(resource);
			pumpkin = pumpkin.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(pumpkin));
			//pic.add(new ImageIcon(pumpkin));
			
			resource = this.getClass().getClassLoader().getResource("blackCat.jpg");
			Image blackCat = ImageIO.read(resource);
			blackCat = blackCat.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(blackCat));
			//pic.add(new ImageIcon(blackCat));
			
			resource = this.getClass().getClassLoader().getResource("candy.jpg");
			Image candy = ImageIO.read(resource);
			candy = candy.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(candy));
			//pic.add(new ImageIcon(candy));
			
			resource = this.getClass().getClassLoader().getResource("bats.jpg");
			Image bats = ImageIO.read(resource);
			bats = bats.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(bats));
			//pic.add(new ImageIcon(bats));
			
			resource = this.getClass().getClassLoader().getResource("scarecrow.jpg");
			Image scarecrow = ImageIO.read(resource);
			scarecrow = scarecrow.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(scarecrow));
			//pic.add(new ImageIcon(scarecrow));
			
			resource = this.getClass().getClassLoader().getResource("halloweenFrontCard.jpg");
			Image start = ImageIO.read(resource);
			start = start.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.frontCard = new ImageIcon(start);
		}
		catch (Exception e){}
		return this.pic;

    }
    
    public ArrayList ThanksgivingCards()
    {
        try{
			
			URL resource = this.getClass().getClassLoader().getResource("dinner.jpg");
			Image image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("gourd.jpg");
			Image image1 = ImageIO.read(resource);
			image1 = image1.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image1));
			
			resource = this.getClass().getClassLoader().getResource("mashedPotatoes.jpg");
			Image image2 = ImageIO.read(resource);
			image2 = image2.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image2));
			
			resource = this.getClass().getClassLoader().getResource("nativeAmerican.jpg");
			Image image3 = ImageIO.read(resource);
			image3 = image3.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image3));
			
			resource = this.getClass().getClassLoader().getResource("pillgramBoy.jpg");
			Image image4 = ImageIO.read(resource);
			image4 = image4.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image4));
			
			resource = this.getClass().getClassLoader().getResource("pillgramGirl.jpg");
			Image image5 = ImageIO.read(resource);
			image5 = image5.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image5));
			
			resource = this.getClass().getClassLoader().getResource("pumpkinPie.jpg");
			Image image6 = ImageIO.read(resource);
			image6 = image6.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image6));
			
			resource = this.getClass().getClassLoader().getResource("turkey.jpg");
			Image image7 = ImageIO.read(resource);
			image7 = image7.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image7));
			
			resource = this.getClass().getClassLoader().getResource("thanksgivingFrontCard.jpg");
			Image start = ImageIO.read(resource);
			start = start.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.frontCard = new ImageIcon(start);
			
		}
		catch(Exception e){}
		return this.pic;
    }    

    public ArrayList ChristmasCards()
    {
        try{
			
			URL resource = this.getClass().getClassLoader().getResource("christmasTree.jpg");
			Image image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("candyCane.jpg");
			image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("coal.jpg");
			image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("elf.jpg");
			image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("grinch.jpg");
			image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("mistleToe.jpg");
			image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("present.jpg");
			image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("santa.jpg");
			image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("snowman.jpg");
			image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("stocking.jpg");
			image = ImageIO.read(resource);
			image = image.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.pic.add(new ImageIcon(image));
			
			resource = this.getClass().getClassLoader().getResource("christmasCardFront.jpg");
			Image start = ImageIO.read(resource);
			start = start.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			this.frontCard = new ImageIcon(start);
			
		}
		catch(Exception e){}
		return this.pic;
    }


}
