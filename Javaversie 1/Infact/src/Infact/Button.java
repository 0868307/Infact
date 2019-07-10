/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infact;

import java.awt.Image;

/**
 *
 * @author Wouter
 */
public class Button {
    private final int x,y,width,height;
    private final String text;
    private final Image image;
    public Button(int x,int y,int width,int height,String text)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        image = Main.main.getToolkit().createImage("./Images/EndPoints/RedEndPoint.png");
//image = Main.main.getToolkit().createImage("./Images/Buttons/"+text+"Button.png");
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    public String getText()
    {
        return text;
    }
    public Image getImage()
    {
        return image;
    }
    
    
    
}
