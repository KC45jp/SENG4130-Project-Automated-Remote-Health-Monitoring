package displayGUI.patientDetailv3;



import displayGUI.patientDetailv3.mainDetailPanelComponent.LogInDetailPanel;
import displayGUI.patientDetailv3.mainDetailPanelComponent.patientDetailComponent.PatientDetailPanel;
import displayGUI.patientDetailv3.mainPanelState.ClinicianMode;
import displayGUI.patientDetailv3.mainPanelState.IMainPanelState;
import displayGUI.patientDetailv3.mainPanelState.LogInState;
import displayGUI.patientDetailv3.sideBarPanelComponent.ClinicianSideBar;
import patientRecord.PatientDataManager;

import userData.UserList;

import javax.swing.*;


/////////////////////////
/*
This is Main Controller of main Panel
This class will have Several States.

To make this class not too huge with unnecessary methods, please implement concrete method to Listeners in each state.

 */
/////////////////////////

/**Main Panel Controller is controller of MVC model of this project and change its behavior by State Pattern.
 */
public class MainPanelController {

    //Main Panel
    private MainPanel mainPanel;


    //Mod Panel

    ////Side Panel
    private ClinicianSideBar defalutClinicianSideBar;



    //Mod Panel
    private PatientDetailPanel patientDetailPanel;
    private LogInDetailPanel logInDetailPanel;

    public IMainPanelState currentPanelState;
    public IMainPanelState nextPanelState;

    public static IMainPanelState Clinician_STATE;
    public static IMainPanelState LOGIN_STATE;


    /// Business Logics
    /// FOllowing are business logics

    //User List both patient and clinicians
    private UserList userList;



    //Business logic of this project which controls Data
    private PatientDataManager patientDataManager = new PatientDataManager();






    public  MainPanelController(MainPanel mainPanel, UserList userList){
        this.mainPanel = mainPanel;

        this.userList = userList;


        //SideBar
        ////SideDefaultBar
        this.defalutClinicianSideBar = new ClinicianSideBar();
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
    public ClinicianSideBar getDefalutSideBarComponent(){
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




    //other getters
    public PatientDataManager getPatientDataManager() {
        return patientDataManager;
    }

    public UserList getUserList() {
        return userList;
    }
}
