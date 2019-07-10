import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.awt.Color;
/**
 * Write a description of class Controller here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Controller extends Actor implements Cloneable
{
    /**
     * Act - do whatever the Controller wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static List robots;
    public static int selected = 0;
    
    private List eindpunten;
    int px = Level.pixelsize;
    Robot currRobot;
    Eindpunt currEind;
    int timer = 0;
    GreenfootImage image;
    private int wincounter = 0;
    boolean gehaald = false;
    public void Controller()
    {
        image = new GreenfootImage(px,px);
        setImage(image);
    }
    public void act() 
    {
        robots = getWorld().getObjects(Robot.class);
        eindpunten = getWorld().getObjects(Eindpunt.class);
        if(robots.size() >0 && eindpunten.size() >0)
        {
            for(int i=0;i<eindpunten.size();i++)
            {
                currEind = (Eindpunt)eindpunten.get(i);
                if(currEind.getFilled())
                    wincounter++;
            }
            for(int i=0;i<robots.size();i++)
            {
                currRobot =(Robot)robots.get(i);
                if(currRobot.getOnBase())
                    wincounter++;
            }
            currRobot = (Robot)robots.get(selected);
            currRobot.getImage().setColor(Color.WHITE);
            currRobot.getImage().fillRect(currRobot.getImage().getWidth()/2,currRobot.getImage().getHeight()/2,5,5);
            if(Greenfoot.isKeyDown("escape"))
            {
                if(timer <= 0)
                {
                    Level lv = (Level)(getWorld());
                    lv.setLevel(lv.getLevel());
                }
            }
            if(Greenfoot.isKeyDown("space"))
            {
                if(timer <= 0)
                {
                    addSelected();
                    timer = Level.worldTimer;
                }
            }
            if(Greenfoot.isKeyDown("up"))
            {
                if(timer <= 0)
                {
                    currRobot.Move(0,-1);
                    timer = Level.worldTimer;
                }
            }
            else if(Greenfoot.isKeyDown("down"))
            {
                if(timer <= 0)
                {
                    currRobot.Move(0,1);
                    timer = Level.worldTimer;
                }
            }
            else if(Greenfoot.isKeyDown("left"))
            {
                if(timer <= 0)
                {
                    currRobot.Move(-1,0);
                    timer = Level.worldTimer;
                }
            }
            else if(Greenfoot.isKeyDown("right"))
            {
                if(timer <= 0)
                {
                    currRobot.Move(1,0);
                    timer = Level.worldTimer;
                }
            }
            if(timer <= 0)
            {
                currRobot.checkTrail();
            }
            timer--;
            if(wincounter >= (eindpunten.size()+robots.size()) && !gehaald)
            {
                gehaald = true;
                Level lv = (Level)(getWorld());
                try
                {
                   lv.setLevel(lv.getLevel()+1);
                }catch(Exception e)
                {
                    
                }
                    
               
            }
            wincounter = 0;
        }
    }    
    public void addSelected()
    {
        selected = (selected+1)%robots.size();
    }
    
    
}
