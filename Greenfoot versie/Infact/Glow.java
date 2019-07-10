import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GLow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Glow extends Objecten implements Cloneable
{
    /**
     * Act - do whatever the GLow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    String kleur;
    public Glow(String kleur)
    {
        this.kleur = kleur;
        setImage("Glows/"+kleur+"Glow.png");
    }   
    public String getKleur()
    {
        return kleur;
    }
    
}
