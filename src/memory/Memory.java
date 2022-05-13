package memory;

import gui.MainGUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Memory {

    protected int gridsize;
    protected int timeLimit;
    protected int timerDelay;

    public Memory(){
        readProperties();

        GameLogic gameLogic = new GameLogic(gridsize);
        gameLogic.init();

        MainGUI mainGUI = new MainGUI(gridsize,gameLogic,timerDelay,timeLimit);
    }


    public static void main(String[]args) throws IOException {

        Memory memory = new Memory();
    }

    public void readProperties(){
        try (InputStream input = new FileInputStream("/home/user/Documents/Memory/src/config.prop")) {
            Properties prop = new Properties();
            prop.load(input);

            timeLimit = Integer.parseInt(prop.getProperty("TIME_LIMIT"));
            gridsize = Integer.parseInt(prop.getProperty("GRID_SIZE"));
            timerDelay = Integer.parseInt(prop.getProperty("TIMER_DELAY"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }


}
