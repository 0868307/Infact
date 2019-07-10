/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Infact;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Wouter
 */
public class Main extends Applet implements Runnable,KeyListener,MouseListener {

    public static final long serialVersionUID = 1L;

    public static boolean isRunning = false;

    public static final int pixelSize = 35;
    public static final Dimension size = new Dimension(700, 700);
    public static final Dimension screenSize = new Dimension((int) size.getWidth() / pixelSize, (int) size.getHeight() / pixelSize);
    public static Scherm scherm;
    public static Hud hud;
    public static Main main;
    public static Controller controller;
    public static Image schermImage;

    public Main() {
        setPreferredSize(size);
    }
    public JFrame getFrame()
    {
        return (JFrame)SwingUtilities.getRoot(this);
    }
    public static void main(String[] args) {
        main = new Main();
        JFrame frame = new JFrame();
        frame.add(main);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Infact");
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        main.init();
        main.start();
    }

    @Override
    public void init() {
        schermImage = createVolatileImage((int) size.getWidth(), (int) size.getHeight());
        scherm = new Scherm();
        hud = new Hud();
        controller = new Controller();
        addKeyListener(this);
        addMouseListener(this);
    }

    @Override
    public void run() {
        while (isRunning) {
            tick();
            render();
            try {
                Thread.sleep(5);
            } catch (Exception e) {
            }
        }
    }
    public void tick() {
        controller.tick();
    }

    @Override
    public void start() {
        isRunning = true;

        new Thread(this).start();
    }

    @Override
    public void stop() {
        isRunning = false;
    }

    public void render() {
        /*Graphics g = schermImage.getGraphics();
        g.dispose();
        g = getGraphics();
        scherm.render(g);
        g.dispose();
        g.drawImage(schermImage, 0, 0, null);
        */
        Graphics g = schermImage.getGraphics();
        g.clearRect(0, 0, (int)size.getWidth(), (int)size.getHeight());
        scherm.render(g);
        hud.render(g);
        g.dispose();
        g = getGraphics();
        g.drawImage(schermImage,0,0,(int)size.getWidth(),(int)size.getHeight(),null);
        g.dispose();
    }

   public static boolean[] keys = new boolean[1000000];
    @Override
    public void keyPressed(KeyEvent e)
    {
        int key = e.getKeyCode();
        keys[key]= true;
    }
    @Override
    public void keyReleased(KeyEvent e)
    {
        int key = e.getKeyCode();
        keys[key]= false;
    }
    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            System.out.println("clicked");
            int buttonx = ((Button)hud.getButtons().get(0)).getX();
            int buttony = ((Button)hud.getButtons().get(0)).getY();
            int buttonwidth = ((Button)hud.getButtons().get(0)).getWidth();
            int buttonheight = ((Button)hud.getButtons().get(0)).getHeight();
            if(e.getX() >= buttonx && e.getX() <= (buttonx+buttonwidth) && e.getY() >= buttony && e.getY() <= (buttony+buttonheight) )
            {
                scherm.resetLevel();
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
