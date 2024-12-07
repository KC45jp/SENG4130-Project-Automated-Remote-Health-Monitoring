package displayGUI.patientDetailv2;

import displayGUI.patientDetailv2.detailPanel.DetailPanel;
import displayGUI.patientDetailv2.mainPanelState.ClinicianState;
import displayGUI.patientDetailv2.mainPanelState.IMainPanelState;
import displayGUI.patientDetailv2.mainPanelState.LogInState;
import displayGUI.patientDetailv2.sidebarPanel.SidePanel;
import userData.userDefaultData;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public final int Main_WIDTH;
    public final int Main_HEIGHT;

    DetailPanel detailPanel;
    SidePanel sidePanel;

    protected userDefaultData userType;

    IMainPanelState currentMainPanelState;
    IMainPanelState nextState;

    private static IMainPanelState LOGIN_STATE;
    private static IMainPanelState CLINICIAN_STATE;

    public MainPanel(int width, int height){
        setSize(width, height);
        setLayout(null);
        Main_WIDTH = width;
        Main_HEIGHT = height;


        //State initilization
        LOGIN_STATE = new LogInState(this);
        CLINICIAN_STATE = new ClinicianState(this);
        currentMainPanelState = LOGIN_STATE;

        //refreshPanel();

        setVisible(true);
    }


    public void startUI(){
        currentMainPanelState.excute();
    }

    //If Panel does not use sidepanel + default then use this
    public void setNullLayout(){
        removeAll();
        setLayout(null);
    }

    public void setDefaultComponents(SidePanel sidePanel, DetailPanel detailPanel){
        removeAll();
        setLayout(new BorderLayout());
        this.detailPanel = detailPanel;
        this.sidePanel = sidePanel;
        add(sidePanel, BorderLayout.WEST);
        add(detailPanel, BorderLayout.CENTER);
        refreshPanel();
    }

    public void setListeners(){

    }

    public int getCenterAlignmentValue(int mainFrameSize,int componentSize){
        return ((mainFrameSize - componentSize)/2);
    }


    public static IMainPanelState getLoginState() {
        return LOGIN_STATE;
    }

    public static IMainPanelState getClinicianState(){
        return CLINICIAN_STATE;
    }

    public void setNextState(IMainPanelState nextState) {
        this.nextState = nextState;
    }

    public void repaintToNextState(){
        currentMainPanelState = nextState;
    }

    public void refreshPanel(){
        invalidate();
        validate();
        repaint();
    }

    public void setUserType(userDefaultData userType) {
        this.userType = userType;
    }

    public userDefaultData getUserType() {
        return userType;
    }
}
