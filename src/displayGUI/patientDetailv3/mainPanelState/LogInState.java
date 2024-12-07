package displayGUI.patientDetailv3.mainPanelState;

import displayGUI.patientDetailv3.MainPanelController;
import displayGUI.patientDetailv3.mainDetailPanelComponent.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

/**Login state is initial state to let user to login.
 * Minimal function available and has no business logic because there are no function to login. for now, you can log in directly.
 */
public class LogInState implements IMainPanelState{

    private static MainPanelController mainPanelController;
    private static LogInState logInState;

    LogInDetailPanel logInDetailPanel;

    /**private costractor for singleton pattern.
     * @param mainPanelController
     */
    private LogInState(MainPanelController mainPanelController){
        LogInState.mainPanelController = mainPanelController;
    }

    /**create and return this instance.
     * @param mainPanelController
     * @return
     */
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

    /**Separate method to get this instance.
     *
     * @return this inistance
     */
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


    /**Set Action Listener
     */
    private void setButtonActionListener(){


        //Login button function
        logInDetailPanel.getButtonLogin().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);
                if(logInDetailPanel.getRadioButtonClinician().isSelected()){
                    //Perform Login for clinician
                    performClinicianLoginAction();
                    JOptionPane.showMessageDialog(logInDetailPanel, "Does Not Support in this version but display all patient");
                } else if (logInDetailPanel.getRadioButtonPatient().isSelected()) {
                    //Perform Login for patient - not supported by this prototype
                    //performLoginAction();
                    JOptionPane.showMessageDialog(logInDetailPanel, "Does Not Support in this version");
                }
                else{
                    //Neither clinician and patient selected -> throw error for debug
                    throw new RuntimeException("No search mode selected. Select what to search");
                }
            }
        });
    }


    /** Perform login for clinician
     *
     */
    private void performClinicianLoginAction(){

        /*
        Precondition:
            user enters Clinician id + password

        Perform;
            authenticate user

        Post condition:
            if OK -> Change to next state wih clinician mode
            if NOT -> show pop up -> stay condition
         */





        /// Get data from view.
        //String userName = logInDetailPanel.getTextFieldUsername().getText();
        //String password = Arrays.toString(logInDetailPanel.getPasswordField().getPassword());


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

    /** Check if user entereed id and pass was matched or not. may change parameter for future.
     * @return false if userid and password match
     */
    private boolean authenticateLogin(){

        //Perform login Action

        return true;
    }
}
