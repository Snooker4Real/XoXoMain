package fr.snooker4real.model;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BouttonXo extends JButton implements ActionListener {

    //private static final long serialVersionUID = 1L;
    private static byte valeur = 0;
    private boolean touch = false;
    //booleen pour la fin de partie
    private static boolean fin = false;
    //position de la sourie une fois cliquée
    private int posX=0, posY=0;
    //A qui le tour ?
    private static byte tour=0;
    private Graphics paintContour;
    //images X et O
    ImageIcon x,o;
    private static int[][] mat = new int[3][3];

    public static byte getTour(){
        return tour;
    }

    public BouttonXo(int i, int j){
        x = new ImageIcon(this.getClass().getResource("x.png"));
        o = new ImageIcon(this.getClass().getResource("o.png"));
        posX=i;posY=j;
        this.setOpaque(false);
        this.addActionListener(this);
        this.setVisible(true);

        switch(i){
        case 0:
            switch(j){
                case 1:
                    this.setBorder(BorderFactory.createMatteBorder(
                            0,
                            2,
                            2,
                            2,
                        Color.MAGENTA));
                    break;
                default:
                    this.setBorder(BorderFactory.createMatteBorder(
                            0,
                            0,
                            0,
                            2,
                            Color.MAGENTA));
                    break;
                }
                break;
            case 2:
                switch(j){
                    case 1:
                        this.setBorder(BorderFactory.createMatteBorder(
                                2,
                                2,
                                2,
                                2,
                                Color.MAGENTA
                        ));
                        break;
                    default:
                        this.setBorder(BorderFactory.createMatteBorder(
                                2,
                                0,
                                0,
                                0,
                                Color.MAGENTA));
                        break;
                    }
                    break;
            case 1:
                switch(j){
                    case 1:
                        this.setBorder(BorderFactory.createMatteBorder(
                                2,
                                2,
                                2,
                                2,
                                Color.MAGENTA));
                        break;
                    default:
                        this.setBorder(BorderFactory.createMatteBorder(
                                2,
                                0,
                                2,
                                0,
                                Color.MAGENTA));
                        break;
                }
                break;
        }
        this.setContentAreaFilled(false);
        this.setOpaque(false);
    }

    private void jeu(int choix){
        mat[posX][posY] = choix;
    }

    private void check(){
        for(int i=0; i<3;i++){
            if(mat[i][0] ==1 && mat[i][1]==1 && mat[i][2]==1 || mat[0][i] ==1 && mat[1][i]==1 && mat[2][2]==1){
                Fin win = new Fin("O a gagné");
                fin=true;
                break;
            } else if(mat[i][0]==2 && mat[i][1]==2 && mat[i][2]==2 || mat[0][i]==2 && mat[1][i]==2 && mat[2][i]==2){
                Fin win = new Fin("X a gagné");
                fin=true;
                break;
            }
        }

        if(mat[0][0]==2 && mat[2][2]==2 && mat[1][1]==2 || mat[0][2]==2 && mat[1][1]==2 && mat[2][0]==2){
            Fin win = new Fin("X a gagné");
            fin=true;
        } else if(mat[0][0]==1 && mat[2][2]==1 && mat[1][1]==1 || mat[0][2]==1 && mat[1][1]==1 && mat[2][0]==1){
            Fin win = new Fin("O a gagné");
            fin=true;
        }
        if(tour==9 && !fin){
            Fin win = new Fin("Match null");
            fin = true;
        }
    }

    //Action sur la grille X ou O
    public void actionPerformed(ActionEvent e){
        if(!touch && !fin){
            valeur++;
            tour++;
            if(valeur==3)
                valeur=1;
            switch(valeur){
                case 1:
                    this.setIcon(x);
                    jeu(2);
                    break;
                case 2:
                    this.setIcon(o);
                    jeu(1);
                    break;
            }
            check();
        }
        touch=true;
    }
}
