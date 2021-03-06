package fr.snooker4real.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fin extends JFrame implements ActionListener {

    //private static final long serialVersionUID = 1600441073860748610L;
    JPanel contentPane, bottomPane,p;
    JLabel imageLabel, headerLabel;
    JButton retry, exit;
    Box b,bb,bbb;

    public Fin(String texte){
        try {
            imageLabel = new JLabel();
            headerLabel = new JLabel();
            retry = new JButton("<html><font size=+2 color=#00991C>Recommencer</font></html>");
            exit = new JButton("<html><font size=+2 color=#F50300>Sortir</font></html>");
            retry.addActionListener(this);
            exit.addActionListener(this);
            b = Box.createHorizontalBox();
            bb = Box.createHorizontalBox();
            p = new JPanel();
            bottomPane = new JPanel(new GridLayout(2,1));
            bottomPane.add(retry);
            bottomPane.add(exit);
            bottomPane.add(bb);
            this.setUndecorated(true);
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.contentPane = (JPanel) getContentPane();
            this.contentPane.setLayout(new BorderLayout());
            this.setSize(500,580);
            headerLabel.setFont(new java.awt.Font("Comic sans ms", Font.BOLD,40));
            String affiche="<html><font color=#006699>"+texte+"</font></html>";
            headerLabel.setText(affiche);
            b.add(headerLabel);
            p.add(b);
            contentPane.add(p, java.awt.BorderLayout.NORTH);
            ImageIcon ii = new ImageIcon(this.getClass().getResource("victoire.gif"));
            imageLabel.setIcon(ii);
            this.contentPane.add(imageLabel, java.awt.BorderLayout.CENTER);
            this.contentPane.add(bottomPane, java.awt.BorderLayout.SOUTH);
            this.setLocationRelativeTo(null);
            this.setVisible(true);

        } catch (Exception exception){
            exception.printStackTrace();
        }
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == exit){
            System.exit(0);
        } else if(e.getSource() == retry){

            TicTacToe j=new TicTacToe();
        }
    }
}
