import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.HashMap;
import java.io.*;
import java.util.Arrays;
import java.util.List;
/**
 * Write a description of class Level1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{

    /**
     * Constructor for objects of class Level1.
     * 
     */
    public static final int pixelsize = 35;
    public static final int worldTimer = 15; 
    private HashMap<String, Actor> map = new HashMap<String, Actor>();
    private String[][] level;
    private int currentlv = 1;
    /*private String[][] level = {{o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,w ,w ,w ,w ,w ,w ,w ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,w ,o ,o ,o ,o ,o ,w ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,w ,o ,gr,o ,o ,o ,w ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,w ,o ,o ,o ,o ,o ,w ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,w ,o ,o ,o ,ge,o ,w ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,w ,o ,o ,o ,o ,o ,w ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,w ,w ,w ,w ,w ,w ,w ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  },
                                     {o  ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o ,o  }};
   */ 
    public static final int[] scherm = {700,700};  
    public Level()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(scherm[0], scherm[1], 1); 
        setPaintOrder(DummyPlant.class,Robot.class,Eindpunt.class,Glow.class,Trail.class);
        setLevel(currentlv);
    }
    public void maakLevel()
    {
        for(int n =0; n<level.length;n++)
        {
            for(int i =0; i<level[n].length;i++)
            {
                if(level[i][n].contains("w"))
                {
                    addObject(new Muur(),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("grr"))
                {
                    addObject(new Robot("Gray"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("rer"))
                {
                    addObject(new Robot("Red"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("lbr"))
                {
                    addObject(new Robot("Lightblue"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("gre"))
                {
                    addObject(new Eindpunt("Gray"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("ree"))
                {
                    addObject(new Eindpunt("Red"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("lbe"))
                {
                    addObject(new Eindpunt("Lightblue"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("rep"))
                {
                    addObject(new Plant("Red"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("lbp"))
                {
                    addObject(new Plant("Lightblue"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("reg"))
                {
                    addObject(new Glow("Red"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("lbg"))
                {
                    addObject(new Glow("Lightblue"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("ret"))
                {
                    addObject(new Trail("Red"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
                else if(level[i][n].contains("lbt"))
                {
                    addObject(new Trail("Lightblue"),n*pixelsize+pixelsize/2,i*pixelsize+pixelsize/2);
                }
            }
        }
        
        //addObject(new Grid(),scherm[0]/2,scherm[1]/2);
        
    }
    private void addController()
    {
        addObject(new Controller(),0,0);
    }
    public void setLevel(int lv)
    {
        
        currentlv = lv;
        
        List objects = getObjects(null);
        removeObjects(objects);
        ParseText(lv);
        
        maakLevel();
        addController();
        
    }
    public int getLevel()
    {
        return currentlv;
    }
    private void ParseText(int lv)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("Levels/Level"+lv+".txt"));
            String regel = null;
            String[][] tempregel = new String[20][20];
            for(int i=0;i<20; i++)
            {
                    regel = br.readLine();
                    tempregel[i] = regel.split(",");
                
            }
            level = tempregel;
            for(int i=0;i<level.length;i++)
                System.out.println(Arrays.toString(level[i]));
        }catch(Exception e)
        {
            List objects = getObjects(null);
            removeObjects(objects);
            addObject(new Gameover(),scherm[0]/2,scherm[1]/2);
            level = null;
        }
    }
}
