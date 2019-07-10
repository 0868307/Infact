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
public class Plant extends Actor {
    public Plant(int x, int y, String kleur) {
        setX(x);
        setY(y);
        setKleur(kleur);
        image = Main.main.getToolkit().createImage("./Images/Plants/"+kleur+"Plant.png");
                //new File("./Images/Plants/"+kleur+"Plant.png"));
        setImage(image);

    }

}
