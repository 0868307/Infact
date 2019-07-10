/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infact.Objecten;

import java.awt.Image;

/**
 *
 * @author Wouter
 */
public abstract class Actor {

    protected int x, y;
    protected String kleur = "";
    protected Image image;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public void setKleur(String kleur) {
        this.kleur = kleur;
    }

    public String getKleur() {
        return this.kleur;
    }
    public void setImage(Image image)
    {
        this.image = image;
    }
    public Image getImage()
    {
        return image;
    }
}
