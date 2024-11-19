package displayGUI.patientDetailv2;

import displayGUI.patientDetailv2.detailPanel.DetailPanel;
import displayGUI.patientDetailv2.mainPanelState.IMainPanelState;
import displayGUI.patientDetailv2.mainPanelState.LogInState;
import displayGUI.patientDetailv2.sidebarPanel.SidePanel;

import javax.swing.*;

public class MainPanel extends JPanel {

    public final int Main_WIDTH;
    public final int Main_HEIGHT;

    DetailPanel detailPanel;
    SidePanel sidePanel;



    IMainPanelState currentMainPanelState;
    private static IMainPanelState LOGIN_STATE;

    public MainPanel(int width, int height){
        setSize(width, height);
        setLayout(null);
        Main_WIDTH = width;
        Main_HEIGHT = height;


        //State initilization
        LOGIN_STATE = new LogInState(this);
        currentMainPanelState = LOGIN_STATE;

        //refreshPanel();

        setVisible(true);
    }

    public void startUI(){
        currentMainPanelState.excute();
    }

    public void addDefaultComponents(){
        detailPanel = new DetailPanel();
        sidePanel = new SidePanel();
    }

    public void setListeners(){

    }

    public int getCenterAlignmentValue(int mainFrameSize,int componentSize){
        return ((mainFrameSize - componentSize)/2);
    }


    public static IMainPanelState getLoginState() {
        return LOGIN_STATE;
    }

    public void refreshPanel(){
        invalidate();
        validate();
        repaint();
    }


}
