import javax.swing.*;
import java.io.IOException;

public class Memory {

    public static void main(String[]args) throws IOException {
        MemoryGUI memoryGUI = new MemoryGUI();
        JFrame frame = new JFrame();
        frame.setContentPane(memoryGUI.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        memoryGUI.add(new JButton("a"));


    }


}
