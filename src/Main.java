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

        //Set Main Panel (View)
        MainPanel mainPanel = new MainPanel(900, 600);

        //Set Controller
        MainPanelController controller = new MainPanelController(mainPanel, testUserData());

        //Generate Main frame
        new MainFrame("Main", mainPanel);
    }

    /**This method makes test user data (Patient data) which make it much better. This works as business logic
     * @return Patient Data
     */
    private static UserList testUserData(){
        ArrayList<ClinicianData> cd = new ArrayList<>();
        cd.add(new ClinicianData("c001", "John", "Due", "000", "001", "i9@hh.cm","rms"));


        PatientData pd = new PatientData("p001", "Doc1","DocF", "000", "005", "dmdm@dm.dm", "Kamloops");
        pd.setBloodPressureThreshold(130, 90, 90, 60);

        PatientData pd2 = new PatientData("p002", "Doc2","DomDom", "000", "005", "dmdm@dm.dm", "Kamloops");
        pd2.setBloodPressureThreshold(130, 90, 90, 60);
        pd2.setBloodPressureThreshold(130, 90, 90, 60);


        ArrayList<PatientData> patientDataArrayList = new ArrayList<>();
        patientDataArrayList.add(pd);
        patientDataArrayList.add(pd2);

        UserList UL = new UserList(cd,patientDataArrayList);

        return UL;
    }
}