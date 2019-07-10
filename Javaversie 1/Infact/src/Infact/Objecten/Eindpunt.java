/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infact.Objecten;

import Infact.Controller;
import Infact.Main;

/**
 *
 * @author Wouter
 */
public class Eindpunt extends Actor {
    private boolean filled;
    public Eindpunt(int x,int y,String kleur)
    {
        setX(x);
        setY(y);
        setKleur(kleur);
        image = Main.main.getToolkit().createImage("./Images/EndPoints/"+kleur+"EndPoint.png");
        setImage(image);
    }
    public void tick()
    {
        Robot robot = (Robot)Controller.getCollisionOfType(0,0,Robot.class,this);
        if(robot!=null)
        {   
            if(robot.getKleur() == kleur)
                setFilled(true);
        }
        else 
        {
            setFilled(false);
        }
    }
    public void setFilled(boolean x)
    {
        filled = x;
    }
    public boolean getFilled()
    {
        return filled;
    }
    
    
}
