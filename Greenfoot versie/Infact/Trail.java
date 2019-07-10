import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Write a description of class Trail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Trail extends Objecten implements Cloneable
{
    /**
     * Act - do whatever the Trail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String kleur;
    public Trail(String kleur)
    {
       this.kleur = kleur;
       setImage("Trails/"+kleur+"Trail.png");
    }
    public String getKleur()
    {
        return kleur;
    }
}
