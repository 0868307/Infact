/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infact.Objecten;

import Infact.Controller;
import Infact.Main;
import Infact.Scherm;
import java.awt.Image;

/**
 *
 * @author Wouter
 */
public class Robot extends Actor {

    Image selectedImage;
    int currentImage;
    private boolean onBase;
    private boolean selected;
    public int lastMovex = 0;
    public int lastMovey = 0;
    public boolean moving;
    
    
    public Robot(int x, int y, String kleur) {
        setX(x);
        setY(y);
        setKleur(kleur);
        image = Main.main.getToolkit().createImage("./Images/Robots/"+kleur+"Robot.png");
        selectedImage = Main.main.getToolkit().createImage("./Images/Robots/"+kleur+"RobotA.png");
        setImage(image);

    }
    public void tick()
    {
        Actor eind = Controller.getCollisionOfType(0, 0,Eindpunt.class,this);
        Actor glow = Controller.getCollisionOfType(0, 0,Glow.class,this);
        if(glow != null)
        {
            if(!glow.getKleur().equals(kleur))
            {
                kleur = glow.getKleur();
                image = Main.main.getToolkit().createImage("./Images/Robots/"+kleur+"RobotA.png");
                setImage(image);
            }
        }
        
        if(eind != null)
        {
            if(eind.getKleur().equals(kleur))
                setOnBase(true);
        }
        else
        {
            setOnBase(false);
        }
        
    }
    public void checkTrail()
    {
        Trail trail = (Trail)Controller.getCollisionOfType(0,0,Trail.class,this);
        if(trail != null)
        {
            if(trail.getKleur().equals("Red") && !getKleur().equals("Red"))
            {
                Scherm.objects.remove(this);
                Controller.selected = 0;
            }
            if(trail.getKleur().equals("Lightblue") && !getKleur().equals("Lightblue"))
            {
                if(Controller.canMove(lastMovex,lastMovey,this))
                {
                    moving = true;
                    setX(getX()+lastMovex);
                    setY(getY()+lastMovey);
                }else 
                {
                    moving = false;
                }
            }
        }
        else 
        {
            moving = false;
        }
    }
    @Override
    public void setX(int x)
    {
        if(!this.getKleur().equals("Gray"))
        {
            Scherm.objects.add(new Trail(getX(),getY(),getKleur()));
        }
        this.x = x;
    }
    @Override
    public void setY(int y)
    {
        if(!this.getKleur().equals("Gray"))
        {
            Scherm.objects.add(new Trail(getX(),getY(),getKleur()));
        }
        this.y = y;
    }
    public void setSelected(boolean x)
    {
        image = Main.main.getToolkit().createImage("./Images/Robots/"+getKleur()+"Robot.png");
        selectedImage = Main.main.getToolkit().createImage("./Images/Robots/"+getKleur()+"RobotA.png");
        selected = x;
        if(x)
            setImage(selectedImage);
        else
            setImage(image);
    }
    public boolean getSelected()
    {
       return selected;
    }
    public void setOnBase(boolean x)
    {
        onBase = x;
    }
    public boolean getOnBase()
    {
        return onBase;
    }
    public boolean getMoving()
    {
        return moving;
    }
}
