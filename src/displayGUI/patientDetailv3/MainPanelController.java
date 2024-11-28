package displayGUI.patientDetailv3;



import displayGUI.patientDetailv3.mainDetailPanelComponent.LogInDetailPanel;
import displayGUI.patientDetailv3.mainDetailPanelComponent.PatientDetailPanel;
import displayGUI.patientDetailv3.mainPanelState.ClinicianMode;
import displayGUI.patientDetailv3.mainPanelState.IMainPanelState;
import displayGUI.patientDetailv3.mainPanelState.LogInState;
import displayGUI.patientDetailv3.sideBarPanelComponent.clinicianSideBar;

import javax.swing.*;


/////////////////////////
/*
This is Main Controller of main Panel
This class will have Several States.

To make this class not too huge with unnecessary methods, please implement concrete method to Listeners in each state.



 */
/////////////////////////


public class MainPanelController {

    //Main Panel
    private MainPanel mainPanel;


    //Mod Panel

    ////Side Panel
    private clinicianSideBar defalutClinicianSideBar;



    //Mod Panel
    private PatientDetailPanel patientDetailPanel;
    private LogInDetailPanel logInDetailPanel;

    public IMainPanelState currentPanelState;
    public IMainPanelState nextPanelState;

    public static IMainPanelState Clinician_STATE;
    public static IMainPanelState LOGIN_STATE;







    public  MainPanelController(MainPanel mainPanel){
        this.mainPanel = mainPanel;

        //SideBar
        ////SideDefaultBar
        this.defalutClinicianSideBar = new clinicianSideBar();
        //DetailPanel
        ////MainDetailPanel
        this.patientDetailPanel = new PatientDetailPanel();
        ////LoginPanel
        this.logInDetailPanel = new LogInDetailPanel();



        //ini State
        Clinician_STATE = ClinicianMode.initializeInstance(this);
        LOGIN_STATE = LogInState.initializeInstance(this);


        //ini State
        //currentPanelState = Clinician_STATE;
        currentPanelState = LOGIN_STATE;
        currentPanelState.excute();

        mainPanel.refreshPanel();
    }



    //Side Bar Components

    public void setSideBar(JPanel sideBar){
        mainPanel.setSideBarPanel(sideBar);
    }



    //Default SideBar
    public clinicianSideBar getDefalutSideBarComponent(){
        return defalutClinicianSideBar;
    }



    //MainDetailPanel
    public void setDetailPanel(JPanel detailPanel){
        mainPanel.setMainDetailPanel(detailPanel);
    }

    ////Patient Detail Panel
    public PatientDetailPanel getPatientDetailPanel() {
        return patientDetailPanel;
    }


    ////LogIn Panel
    public LogInDetailPanel getLogInDetailPanel() {
        return logInDetailPanel;
    }



    //State

    public IMainPanelState getClinician_STATE(){
        return Clinician_STATE;
    }

    public IMainPanelState getLoginState() {
        return LOGIN_STATE;
    }

    public void setNextPanelState(IMainPanelState nextPanelState){
        this.nextPanelState = nextPanelState;
    }

    public void repaintToNextState(){
        currentPanelState = nextPanelState;
        currentPanelState.excute();
    }




}
