package displayGUI.patientDetailv2.mainPanelState;

import displayGUI.patientDetailv2.MainPanel;
import displayGUI.patientDetailv2.detailPanel.DetailPanel;
import displayGUI.patientDetailv2.sidebarPanel.ClinicianSidePanel;
import displayGUI.patientDetailv2.sidebarPanel.SidePanel;
import userData.userDefaultData;

public class ClinicianState implements IMainPanelState{


    MainPanel mainPanel;

    SidePanel sidePanel = new ClinicianSidePanel();
    DetailPanel detailPanel = new DetailPanel();

    public ClinicianState(MainPanel mainPanel){
        this.mainPanel = mainPanel;
    }


    @Override
    public userDefaultData getUserDefaultData() {
        return null;
    }

    @Override
    public void handleState() {

    }

    @Override
    public void setUI() {
        mainPanel.setDefaultComponents(sidePanel, detailPanel);

    }

    @Override
    public void setNextState() {

    }
}
