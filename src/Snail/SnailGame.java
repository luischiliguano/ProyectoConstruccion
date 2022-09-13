package Snail;

import Conection.PlayerConection;
import Conection.ScoreConection;
import Persistence.Player;
import Input.Keyboard;
import Persistence.Score;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class SnailGame extends JFrame implements Runnable {

    private boolean state = false;
    private Thread thread;
    private Keyboard keyboard;
    private GameLevel level;
    private int score;
    private int contDie;
    private Player player;
    private Score scoreB;
    private StartMenu startMenu;
    private boolean mode;
    private int numPlayer = 1;
    PlayerConection playerCon = new PlayerConection();
    ScoreConection scoreCon = new ScoreConection();

    public SnailGame() {
        setSize(1200, 800);
        this.setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        this.setTitle("Snail");

        this.setVisible(state);

        if (numPlayer == 1) {
            this.mode = true;
        }

        /* if (numPlayer == 2) {
            this.mode = false;
        }*/
    }

    @Override
    public void run() {

        this.keyboard = new Keyboard();

        level = new GameLevel(this, mode);

        level.scene.addKeyListener(keyboard);
        state = true;
        this.add(level.getScene());
        this.setSize(1200, 700);
        this.setVisible(state);
        this.setLocation(100, 25);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (state) {

            refresh();
            state = level.checkInteractions();
            score = level.checkRecollection(score);
            contDie = level.checkDie(contDie);
            if (mode == false) {
                if (contDie == 2) {
                    state = false;
                }
            }

            if (mode == true) {
                if (contDie == 1) {
                    state = false;
                }
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(SnailGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            endGame(this.state);

        }
        stop();
    }

    public void refresh() {
        this.level.getScene().update();
        keyboard.update();
        this.repaint();

    }

    public void endGame(boolean state) {
        if (state == false) {
            startMenu = new StartMenu();
            //int punctuation = (int) ((tf - t0) / 1000);
            asignarScore();
            //player.updateScore(score);
            this.setVisible(false);
            //startMenu.setVisible(true);
            //boolean isFound= false;
            // Save the new Score for the User Login

            startMenu.setVisible(true);
            

        }
    }

    public void start() {

        thread = new Thread(this);
        thread.start();
        state = true;

    }

    private void stop() {
        try {
            thread.join();
            state = false;
        } catch (InterruptedException e) {
            /* Prints the error */
            e.printStackTrace();
        }
    }

    public void showWindow() {
        startMenu = new StartMenu();
        startMenu.setVisible(true);

    }

    private String setDateNow() {
        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
        return format.format(today);
    }

    private void asignarScore(){
        JOptionPane.showMessageDialog(null, "Your score is " + score, "GAME OVER", 1);
        int num = playerCon.ObtenerIDDeNick(playerCon.ObtenerNickDeCurrentActive(1));
        scoreB = new Score(score, num, setDateNow(), "SNAIL GAME");
        try {
            scoreCon.Insertar(scoreB);
        } catch (SQLException ex) {
            Logger.getLogger(SnailGame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   

}
