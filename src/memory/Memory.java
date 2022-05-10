package memory;

import gui.MainGUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Memory {

    protected int gridsize;
    protected double timeLimit;

    public Memory(){
        readProperties();

        GameLogic gameLogic = new GameLogic(gridsize);
        gameLogic.init();

        MainGUI mainGUI = new MainGUI(gridsize,gameLogic);
    }

    public void init(){

    }

    public static void main(String[]args) throws IOException {

        Memory memory = new Memory();
    }

    public void readProperties(){
        try (InputStream input = new FileInputStream("C:\\Users\\ludwi\\IdeaProjects\\Memory\\src\\config.prop")) {
            Properties prop = new Properties();
            prop.load(input);

            timeLimit = Double.parseDouble(prop.getProperty("TIME_LIMIT"));
            gridsize = Integer.parseInt(prop.getProperty("GRIDSIZE"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }


}
