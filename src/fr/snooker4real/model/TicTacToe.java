package fr.snooker4real.model;

import javax.swing.*;
import java.awt.*;

public class TicTacToe extends JFrame {
    private JPanel panel;
    private BouttonXo[][] boutton = new BouttonXo[3][3];

    public TicTacToe(){
        //création de la fenêtre
        panel = new JPanel(new GridLayout(3,3));
        //Titre
        this.setTitle("Jeu de morpion");
        //Taille de la fenêtre
        this.setSize(450,450);
        this.setResizable(false);

        //création de la grille
        for(int x=0;x<3;x++){
            for(int j=0;j<3;j++)
            panel.add(boutton[x][j] = new BouttonXo(x,j));
        }

        //paramètres graphiques
        panel.setBackground(Color.PINK);
        this.add(panel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }



}
