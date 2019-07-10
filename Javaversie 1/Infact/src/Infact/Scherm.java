package Infact;

import Infact.Objecten.*;
import java.awt.Graphics;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public final class Scherm {

    private int x, y;
    private String[][] level;
    public static List<Actor> objects = new ArrayList<>();
    public static List<Actor> sorted = new ArrayList<>();
    private int currentlv = 1;

    public Scherm() {
        setLevel(currentlv);
    }
    public void drawObjects(Class object, Graphics g)
    {
        sorted.clear();
        for(int i=0;i<Scherm.objects.size();i++)
        {
            if(Scherm.objects.get(i).getClass() == object)
            {
                sorted.add(Scherm.objects.get(i));
            }
        }
        for(int i=0;i<sorted.size();i++)
        {
            g.drawImage(sorted.get(i).getImage(),sorted.get(i).getX()*Main.pixelSize,sorted.get(i).getY()*Main.pixelSize,null);
        }
    }
    public void render(Graphics g) {
        drawObjects(Trail.class, g);
        drawObjects(Glow.class, g);
        drawObjects(Muur.class, g);
        drawObjects(Eindpunt.class, g);
        drawObjects(Plant.class, g);
        drawObjects(Robot.class, g);
        
    }

    public void maakLevel() {
        for (y = 0; y < level.length; y++) {
            for (x = 0; x < level[y].length; x++) {
                if (level[y][x].contains("w")) {
                    objects.add(new Muur(x, y));
                } else if (level[y][x].contains("grr")) {
                    objects.add(new Robot(x, y, "Gray"));
                } else if (level[y][x].contains("rer")) {
                    objects.add(new Robot(x, y, "Red"));
                } else if (level[y][x].contains("lbr")) {
                    objects.add(new Robot(x, y, "Lightblue"));
                } else if (level[y][x].contains("gre")) {
                    objects.add(new Eindpunt(x, y, "Gray"));
                } else if (level[y][x].contains("ree")) {
                    objects.add(new Eindpunt(x, y, "Red"));
                } else if (level[y][x].contains("lbe")) {
                    objects.add(new Eindpunt(x, y, "Lightblue"));
                } else if (level[y][x].contains("rep")) {
                    objects.add(new Plant(x, y, "Red"));
                } else if (level[y][x].contains("lbp")) {
                    objects.add(new Plant(x, y, "Lightblue"));
                } else if (level[y][x].contains("reg")) {
                    objects.add(new Glow(x, y, "Red"));
                } else if (level[y][x].contains("lbg")) {
                    objects.add(new Glow(x, y, "Lightblue"));
                } else if (level[y][x].contains("ret")) {
                    objects.add(new Trail(x, y, "Red"));
                } else if (level[y][x].contains("lbt")) {
                    objects.add(new Trail(x, y, "Lightblue"));
                }
            }
        }
    }

    public void setLevel(int lv) {
        objects =  new ArrayList<>();
        currentlv = lv;
        Controller.gehaald = false;
        parseText(currentlv);
    }

    public int getLevel() {
        return currentlv;
    }
    public void resetLevel()
    {
        objects =  new ArrayList<>();
        parseText(currentlv);
    }

    private void parseText(int lv) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Levels/Level" + lv + ".txt"));
            String regel;
            String[][] tempregel = new String[20][20];
            for (int i = 0; i < 20; i++) {
                regel = br.readLine();
                tempregel[i] = regel.split(",");
            }
            level = tempregel;
        } catch (IOException e) {
        }
        maakLevel();
    }
}