/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Infact;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Wouter
 */
public class Hud {
    List<Button> button = new ArrayList<Button>();
    public Hud()
    {
        makeButtons();
    }
    
    public void render(Graphics g)
    {
        drawButtons(g);
        drawInfo(g);
    }
    public void drawButtons(Graphics g)
    {
        g.drawImage(button.get(0).getImage(), button.get(0).getX(), button.get(0).getY(), button.get(0).getWidth(), button.get(0).getHeight(), null);
    }
    public void drawInfo(Graphics g)
    {
        
    }
    public void makeButtons()
    {
        button.add(new Button(50,(int)Main.size.getHeight()-100,200,50,"reset"));
    }
    public List getButtons()
    {
        return button;
    }
}
