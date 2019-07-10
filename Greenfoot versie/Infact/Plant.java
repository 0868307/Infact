import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Graphics;
import java.awt.Image;
/**
 * Write a description of class Plant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plant extends Objecten implements Cloneable
{
    /**
     * Act - do whatever the Plant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String kleur;
    int px = Level.pixelsize;
    boolean init = true;
    GreenfootImage image;
    public Plant(String kleur)
    {
        image = new GreenfootImage(px,px);
        this.kleur = kleur;
        setImage(image);
        //setImage("Plants/"+kleur+"Plant.png");
    }
    public void act() 
    {
        if(init)
        {
            getWorld().addObject(new DummyPlant(kleur),getX(),getY()-px/2);
            addGlow();
            init = false;
        }
    }    
    public String getKleur()
    {
        return kleur;
    }
    private void addGlow()
    {
        Level lv =(Level)getWorld();
        lv.addObject(new Glow(kleur),getX(),getY());
    }
    
}
