/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infact.Objecten;

import Infact.Main;

/**
 *
 * @author Wouter
 */
public class Muur extends Actor {
    public Muur(int x, int y) {
        setX(x);
        setY(y);
        image = Main.main.getToolkit().createImage("./Images/SingleBlocks/Wall.png");
        setImage(image);
    }
}
