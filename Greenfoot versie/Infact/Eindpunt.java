import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eindpunt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Eindpunt extends Objecten implements Cloneable
{
    /**
     * Act - do whatever the Eindpunt wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String kleur;
    private boolean filled = false;
    public Eindpunt(String kleur)
    {
        this.kleur = kleur;
        setImage("EndPoints/"+kleur+"EndPoint.png");
    }
    public void act() 
    {
        Robot robot = (Robot)getOneObjectAtOffset(0,0,Robot.class);
        if(robot!=null)
        {   
            if(robot.getKleur() == kleur)
                setFilled(true);
        }
    }    
    public String getKleur()
    {
        return kleur;
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
