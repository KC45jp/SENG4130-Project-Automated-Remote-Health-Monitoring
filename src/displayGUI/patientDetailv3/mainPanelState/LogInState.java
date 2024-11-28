package displayGUI.patientDetailv3.mainPanelState;

import displayGUI.patientDetailv3.MainPanelController;
import displayGUI.patientDetailv3.mainDetailPanelComponent.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class LogInState implements IMainPanelState{

    private static MainPanelController mainPanelController;
    private static LogInState logInState;

    LogInDetailPanel logInDetailPanel;

    private LogInState(MainPanelController mainPanelController){
        LogInState.mainPanelController = mainPanelController;
    }

    public static LogInState initializeInstance(MainPanelController mainPanelController){

        if(mainPanelController == null){
            throw new RuntimeException("Error, mainPanelController is null");
        }

        if(logInState == null){
            logInState = new LogInState(mainPanelController);
        } else if (LogInState.mainPanelController != mainPanelController) {
            throw new RuntimeException("Trying to set different main panel controller");
        }

        return LogInState.logInState;
    }

    public static LogInState getInstance(){

        if(logInState == null){
            throw new RuntimeException("This instance is not initialized");
        }

        return LogInState.logInState;
    }




    @Override
    public void handleState() {
        logInDetailPanel = mainPanelController.getLogInDetailPanel();
        setButtonActionListener();

    }

    @Override
    public void setUI() {
        mainPanelController.setSideBar(null);
        mainPanelController.setDetailPanel(mainPanelController.getLogInDetailPanel());


    }

    @Override
    public void setNextState() {

        //Return to this.
        mainPanelController.setNextPanelState(this);
    }





    private void setButtonActionListener(){


        logInDetailPanel.getButtonLogin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                if(logInDetailPanel.getRadioButtonClinician().isSelected()){
                    performClinicianLoginAction();


                } else if (logInDetailPanel.getRadioButtonPatient().isSelected()) {
                    //performLoginAction();
                    JOptionPane.showMessageDialog(logInDetailPanel, "Does Not Support in this version");
                }
                else{
                    throw new RuntimeException("No search mode selected. Select what to search");
                }


            }
        });
    }


    private void performClinicianLoginAction(){
        String userName = logInDetailPanel.getTextFieldUsername().getText();
        String password = Arrays.toString(logInDetailPanel.getPasswordField().getPassword());


        //Check Login success or not
        if (authenticateLogin()) {
            JOptionPane.showMessageDialog(logInDetailPanel, "Welcome");
            mainPanelController.setNextPanelState(mainPanelController.getClinician_STATE());
            mainPanelController.repaintToNextState();




        } else {
            JOptionPane.showMessageDialog(logInDetailPanel, "Your user name/Password does not match");
        }

        //Null the password
        logInDetailPanel.getPasswordField().setText("");
    }

    private boolean authenticateLogin(){

        return true;
    }
}
