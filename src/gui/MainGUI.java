package gui;

import memory.GameLogic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MainGUI {

    protected JFrame mainFrame;
    protected JButton[] buttons;
    protected JPanel mainPanel;
    protected int gridsize;
    protected GameLogic gameLogic;

    protected int timerDelay;
    protected int first;
    protected int async1;
    protected int async2;
    protected Icon[] icons;

    public MainGUI(int gridsize, GameLogic gameLogic, int timerDelay) {
        this.gridsize = gridsize;
        this.gameLogic = gameLogic;
        this.first = -1;
        this.icons = new Icon[(gridsize * gridsize) / 2];
        this.timerDelay = timerDelay;

        readInIcons();

        mainFrame = new JFrame();
        mainFrame.setSize(1000, 1000);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainPanel = new JPanel();
        mainFrame.setContentPane(mainPanel);
        mainPanel.setBounds(1000, 1000, 900, 900);
        mainPanel.setLayout(new GridLayout(gridsize, gridsize));
        mainPanel.setBackground(Color.green);


        mainFrame.setVisible(true);

        buttons = new JButton[gridsize * gridsize];
        ButtonListener buttonListener = new ButtonListener();

        for (int i = 0; i < gridsize; i++) {
            for (int k = 0; k < gridsize; k++) {
                buttons[gridsize * i + k] = new JButton(String.valueOf(gridsize * i + k));
                buttons[gridsize * i + k].addActionListener(buttonListener);
                mainPanel.add(buttons[gridsize * i + k]);
            }
        }
        mainPanel.revalidate();
    }

    public void showIcons(int index1, int index2) {
        buttons[index1].setIcon(icons[gameLogic.getCardValue(index1)]);
        buttons[index2].setIcon(icons[gameLogic.getCardValue(index2)]);
        mainPanel.revalidate();
    }

    public void hideIcons(int index1, int index2) {
        buttons[index1].setIcon(null);
        buttons[index2].setIcon(null);

    }

    public void readInIcons() {
        for (int i = 0; i < (gridsize * gridsize) / 2; i++) {
            File file = new File("C:\\Users\\ludwi\\IdeaProjects\\Memory\\src\\pictures\\icon" + (i + 1) + ".jpg");
            if (file.exists()) {
                icons[i] = new ImageIcon(file.getAbsolutePath());
            }
        }
    }

    public void delay(int s) {
        long currentTime = System.currentTimeMillis();
        long endTime = currentTime + s * 1000;
        while (currentTime < endTime) {
            currentTime = System.currentTimeMillis();
        }
        ;
    }


    class ButtonListener implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent e) {

            for (int i = 0; i < gridsize * gridsize; i++) {
                if (buttons[i].equals(e.getSource())) {
                    System.out.println("JButton " + i + " wurde geklickt.");
                    if (first == -1) {
                        first = i;
                        async1 =first;
                    } else if (first != i) {
                        async2 =i;
                        showIcons(first,i);

                        if (gameLogic.move(first, i)) {
                            System.out.println("True");
                            buttons[first].setEnabled(false);
                            buttons[i].setEnabled(false);
                        } else {
                            System.out.println("False");
                            Timer timer = new Timer(timerDelay, new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    hideIcons(async1,async2);
                                }
                            });
                            timer.setRepeats(false);
                            timer.start();
                        }
                        first = -1;
                    }

                }
            }
            if (gameLogic.checkForWin()) System.out.println("win!!!!!!!!!!!!!!");


        }
    }

}