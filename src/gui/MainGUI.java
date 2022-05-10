package gui;

import memory.GameLogic;

import javax.swing.*;
import java.awt.*;

public class MainGUI {

    protected JFrame mainFrame;
    protected JButton[] buttons;
    protected JPanel mainPanel;
    protected int gridsize;
    protected GameLogic gameLogic;
    protected int first;

    public MainGUI(int gridsize, GameLogic gameLogic){
        this.gridsize = gridsize;
        this.gameLogic = gameLogic;
        this.first = -1;


        mainFrame = new JFrame();
        mainFrame.setSize(1000,1000);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainFrame.setContentPane(mainPanel);
        mainPanel.setBounds(1000,1000,900,900);
        mainPanel.setLayout(new GridLayout(gridsize,gridsize));
        mainPanel.setBackground(Color.green);


        mainFrame.setVisible(true);

        buttons = new JButton[gridsize*gridsize];
        ButtonListener buttonListener = new ButtonListener();

        for (int i=0;i<gridsize;i++){
            for (int k=0;k<gridsize;k++){
                buttons[gridsize*i+k] = new JButton(String.valueOf(gridsize*i+k));
                buttons[gridsize*i+k].addActionListener(buttonListener);
                mainPanel.add(buttons[gridsize*i+k]);
            }
        }
        mainPanel.revalidate();
    }

    class ButtonListener implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {

            for (int i=0; i<gridsize*gridsize; i++) {
                if(buttons[i].equals(e.getSource())){
                    System.out.println("JButton " + i + " wurde geklickt.");
                    if (first==-1){
                        first = i;
                    } else if (first!=i) {
                        if(gameLogic.move(first,i)){
                            System.out.println("True");
                        } else {
                            System.out.println("False");
                        }
                        first = -1;
                    }

                }
            }
            if(gameLogic.checkForWin()) System.out.println("win!!!!!!!!!!!!!!");



        }
    }

}
