import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Objecten implements Cloneable
{
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int px = Level.pixelsize;
    int x,y;
    int score = 0;
    private boolean onBase = false;
    boolean isDeleted = false;
    String kleur;
    int lastMovex,lastMovey;
    public Robot(String kleur)
    {
        this.kleur = kleur;
        paintImage();
    } 
    public void act()
    {
        Eindpunt eind = (Eindpunt)getOneObjectAtOffset(0,0,Eindpunt.class);
        Glow glow = (Glow)getOneObjectAtOffset(0,0,Glow.class);
        if (!isDeleted)
        {
            if(glow != null)
            {
                System.out.println(kleur);
                kleur = glow.getKleur();
                paintImage();
            }
            
            if(eind !=null)
            {
                if(eind.getKleur() == kleur)
                    setOnBase(true);
            }
            else
            {
                setOnBase(false);
            }
        }
        
    }
    public void Move(int dx,int dy)
    {   
        x = getX()/px;
        y = getY()/px;
        lastMovex = dx;
        lastMovey = dy;
        
        x += dx;
        y += dy;
        Muur coll = (Muur)getOneObjectAtOffset(x*px+px/2-getX(),y*px+px/2-getY(),Muur.class);
        Plant plant = (Plant)getOneObjectAtOffset(x*px+px/2-getX(),y*px+px/2-getY(),Plant.class);
        Robot robot = (Robot)getOneObjectAtOffset(x*px+px/2-getX(),y*px+px/2-getY(),Robot.class);
        if(coll == null && plant == null && robot == null)
        {  
            if(kleur != "Gray")
                getWorld().addObject(new Trail(kleur),getX(),getY());
            setLocation(x*px+px/2,y*px+px/2);
        }
    }
    public void checkTrail()
    {
        Trail trail = (Trail)getOneObjectAtOffset(0,0,Trail.class);
        if(trail != null)
        {
            if(trail.getKleur().equals("Red") && !getKleur().equals("Red"))
            {
                getWorld().removeObject(this);
                Controller.selected =0;
                isDeleted = true;
            }
            if(trail.getKleur().equals("Lightblue") && !getKleur().equals("Lightblue"))
            {
                
                Muur coll = (Muur)getOneObjectAtOffset(lastMovex*px+px/2,lastMovey*px+px/2,Muur.class);
                Plant plant = (Plant)getOneObjectAtOffset(lastMovex*px+px/2,lastMovey*px+px/2,Plant.class);
                Robot robot = (Robot)getOneObjectAtOffset(lastMovex*px+px/2,lastMovey*px+px/2,Robot.class);
                if(coll == null && plant == null && robot ==  null)
                {
                    x += lastMovex;
                    y += lastMovey;
                    setLocation(x*px+px/2,y*px+px/2);
                }
            }
        }
    }
    public String getKleur()
    {
        return kleur;
    }
    public void setOnBase(boolean x)
    {
        onBase = x;
    }
    public boolean getOnBase()
    {
        return onBase;
    }
    private void paintImage()
    {
        getImage().clear();
        setImage("Robots/"+kleur+"Robot.png");
    }
    
}
