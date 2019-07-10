import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DummyPlant here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DummyPlant extends Actor
{
    /**
     * Act - do whatever the DummyPlant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public DummyPlant(String kleur)
    {
        setImage("Plants/"+kleur+"Plant.png");
    }
}
