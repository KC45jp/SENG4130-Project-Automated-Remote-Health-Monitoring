import displayGUI.patientDetailv3.MainFrame;
import displayGUI.patientDetailv3.MainPanel;
import displayGUI.patientDetailv3.MainPanelController;
import displayGUI.patientDetailv3.mainDetailPanelComponent.LogInDetailPanel;
import userData.UserList;
import userData.clinitianData.ClinicianData;
import userData.patientData.PatientData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        //new LogInDisplay(900,600);

        MainPanel mainPanel = new MainPanel(900, 600);
        MainPanelController controller = new MainPanelController(mainPanel, testUserData());

        new MainFrame("Main", mainPanel);

        //testFrame();


    }

    private static UserList testUserData(){
        ArrayList<ClinicianData> cd = new ArrayList<>();
        cd.add(new ClinicianData("c001", "John", "Due", "000", "001", "i9@hh.cm","rms"));

        ArrayList<PatientData> pd = new ArrayList<>();
        pd.add(new PatientData("p001", "Doc1","DocF", "000", "005", "dmdm@dm.dm", "Kamloops"));
        pd.add(new PatientData("p002", "Doc2","DomDom", "000", "005", "dmdm@dm.dm", "Kamloops"));


        UserList UL = new UserList(cd,pd);



        return UL;
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