/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infact;

import Infact.Objecten.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wouter
 */
public class Controller {
    private final int TIMER = 5;
    public static int selected = 0;
    private int lastselected = 1;
    private Eindpunt currEind, tempEind;
    private Robot currRobot, tempRobot;
    private int counter =0;
    private boolean run;
    private int wincounter;
    public static boolean gehaald;

    public void tick() {
        
        if (run) {
            List<Actor> robots = new ArrayList<Actor>();
            List<Actor> eindpunten = new ArrayList<Actor>();
            robots = getObjects(Robot.class);
            eindpunten = getObjects(Eindpunt.class);

            if (robots.size() > 0 && eindpunten.size() > 0) {
                for (int i = 0; i < eindpunten.size(); i++) {
                    tempEind = (Eindpunt) eindpunten.get(i);
                    tempEind.tick();
                    if (tempEind.getFilled()) {
                        wincounter++;
                    }
                }
                for (int i = 0; i < robots.size(); i++) {
                    tempRobot = (Robot) robots.get(i);
                    tempRobot.tick();
                    if (tempRobot.getOnBase()) {
                        wincounter++;
                    }
                }
            }

            currRobot = (Robot) robots.get(selected);
            currRobot.checkTrail();
            if (lastselected != selected) {
                currRobot.setSelected(true);
                }
            for(int i=0;i<robots.size();i++)
            {
               if(robots.get(i) != currRobot && ((Robot)robots.get(i)).getSelected())
               {
                    ((Robot) robots.get(i)).setSelected(false);
               }
            }
            lastselected = selected;
            if(!currRobot.getMoving())
            {
                if (Main.keys[KeyEvent.VK_A] || Main.keys[KeyEvent.VK_LEFT]) {
                //if(getCollisionAt(-1, 0, currRobot).size() <= 0)
                    if (canMove(-1, 0, currRobot)) {
                        currRobot.lastMovex = -1;
                        currRobot.lastMovey = 0;
                        currRobot.setX(currRobot.getX() - 1);
                    }
                } else if (Main.keys[KeyEvent.VK_D] || Main.keys[KeyEvent.VK_RIGHT]) {
                    if (canMove(1, 0, currRobot)) {
                        currRobot.lastMovex = 1;
                        currRobot.lastMovey = 0;
                        currRobot.setX(currRobot.getX() + 1);
                    }
                } else if (Main.keys[KeyEvent.VK_W] || Main.keys[KeyEvent.VK_UP]) {
                    if (canMove(0, -1, currRobot)) {
                        currRobot.lastMovex = 0;
                        currRobot.lastMovey = -1;
                        currRobot.setY(currRobot.getY() - 1);
                    }
                } else if (Main.keys[KeyEvent.VK_S] || Main.keys[KeyEvent.VK_DOWN]) {
                    if (canMove(0, 1, currRobot)) {
                        currRobot.lastMovex = 0;
                        currRobot.lastMovey = 1;
                        currRobot.setY(currRobot.getY() + 1);
                    }
                } else if (Main.keys[KeyEvent.VK_SPACE]) {
                    selected = (selected + 1) % robots.size();
                }
            }
            if (Main.keys[KeyEvent.VK_R]) {
                Main.scherm.resetLevel();
            }

            if (wincounter >= (eindpunten.size() + robots.size()) && !gehaald) {
                gehaald = true;
                try {
                    Main.scherm.setLevel(Main.scherm.getLevel() + 1);
                    selected = 0;
                    lastselected = 1;
                } catch (Exception e) {

                }

            }
            wincounter = 0;
            run = false;
        }
        if(counter == TIMER)
        {
            counter = 0;
            run = true;
        }
        counter++;
        
    }

    public static List getObjects(Class object) {
        List<Actor> sorted = new ArrayList<Actor>();
        if (object != null) {
            sorted.clear();
            for (int i = 0; i < Scherm.objects.size(); i++) {
                if (Scherm.objects.get(i).getClass() == object) {
                    sorted.add(Scherm.objects.get(i));
                }
            }
            return sorted;
        }
        return Scherm.objects;
    }

    public static List getCollisionAt(int dx, int dy, Actor actor) {
        List<Actor> objects = Scherm.objects;
        List<Actor> collision = new ArrayList<Actor>();
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) != actor) {
                if (objects.get(i).getX() == (actor.getX() + dx) && objects.get(i).getY() == (actor.getY() + dy)) {
                    collision.add(objects.get(i));
                }
            }
        }
        return collision;
    }

    public static Actor getCollisionOfType(int dx, int dy, Class cl, Actor actor) {
        List<Actor> objects = Scherm.objects;
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i) != actor) {
                if (objects.get(i).getX() == (actor.getX() + dx) && objects.get(i).getY() == (actor.getY() + dy)) {
                    if (objects.get(i).getClass() == cl) {
                        return objects.get(i);
                    }
                }
            }
        }
        return null;
    }

    public static boolean canMove(int dx, int dy, Robot robot) {
        List<Actor> objects = getCollisionAt(dx, dy, robot);
        
        if(objects.size() >0)
        {
            for (int i = 0; i < objects.size(); i++) {
                Class object = objects.get(i).getClass();
                if (object == Muur.class || object == Plant.class || object == Robot.class) {
                    return false;
                }
            }
        }
        return true;
    }
}
