import displayGUI.patientDetailv3.MainFrame;
import displayGUI.patientDetailv3.MainPanel;
import displayGUI.patientDetailv3.MainPanelController;
import displayGUI.patientDetailv3.mainDetailPanelComponent.LogInDetailPanel;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        //new LogInDisplay(900,600);

        MainPanel mainPanel = new MainPanel(900, 600);
        MainPanelController controller = new MainPanelController(mainPanel);

        new MainFrame("Main", mainPanel);

        //testFrame();


    }

    private static void testFrame(){
        JFrame testFrame = new JFrame("test");
        testFrame.setLayout(new BorderLayout());
        testFrame.setSize(900,600);
        testFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel panel = new LogInDetailPanel();
        testFrame.add(panel, BorderLayout.NORTH);

        testFrame.setVisible(true);
    }
}