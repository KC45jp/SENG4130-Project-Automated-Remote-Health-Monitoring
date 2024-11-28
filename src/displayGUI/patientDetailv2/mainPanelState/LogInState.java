package displayGUI.patientDetailv2.mainPanelState;

import displayGUI.patientDetailv2.MainPanel;
import userData.userDefaultData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.EventListener;

public class LogInState implements IMainPanelState {

    MainPanel mainPanel;

    IMainPanelState nextState = null;

    JTextField textFieldUsername;
    JPasswordField passwordField;

    JRadioButton radioButtonClinician;
    JRadioButton radioButtonPatient;

    public LogInState(MainPanel mainPanel){
        this.mainPanel = mainPanel;
    }

    @Override
    public userDefaultData getUserDefaultData() {
        return null;
    }

    @Override
    public void handleState() {
        // No specific state handling required
    }

    @Override
    public void setUI() {
        mainPanel.setNullLayout();

        mainPanel.add(setLabelLogin());
        mainPanel.add(setLabelUsername());
        mainPanel.add(setPasswordBox());
        mainPanel.add(setLoginButton());
        setLogInSelectButton();

        mainPanel.refreshPanel();
    }

    @Override
    public void setNextState() {
        mainPanel.setNextState(nextState);
    }


    private JLabel setLabelLogin(){
        JLabel labelLogin = new JLabel("Log In");
        labelLogin.setFont(new Font("Arial", Font.BOLD, 25));
        labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
        labelLogin.setBounds(400, 100, 100, 25); // Set bounds explicitly
        return labelLogin;
    }

    private Box setLabelUsername(){
        final int VERTICAL_SIZE = 20;
        final int HORIZONTAL_SIZE = 300;

        Box userNameBox = Box.createHorizontalBox();
        userNameBox.setBounds(mainPanel.getCenterAlignmentValue(mainPanel.Main_WIDTH, HORIZONTAL_SIZE), 150, HORIZONTAL_SIZE, VERTICAL_SIZE);

        JLabel labelUsername = new JLabel("User Name ");
        labelUsername.setFont(new Font("Arial", Font.BOLD, VERTICAL_SIZE));
        labelUsername.setHorizontalAlignment(SwingConstants.LEFT);
        userNameBox.add(labelUsername);

        textFieldUsername = new JTextField(10);
        textFieldUsername.setSize(new Dimension(200, VERTICAL_SIZE));
        userNameBox.add(textFieldUsername);

        return userNameBox;
    }

    private Box setPasswordBox(){
        final int VERTICAL_SIZE = 20;
        final int HORIZONTAL_SIZE = 300;

        Box passwordBox = Box.createHorizontalBox();
        passwordBox.setBounds(mainPanel.getCenterAlignmentValue(mainPanel.Main_WIDTH, HORIZONTAL_SIZE), 200, HORIZONTAL_SIZE, VERTICAL_SIZE);

        JLabel labelPassword = new JLabel("Password ");
        labelPassword.setFont(new Font("Arial", Font.BOLD, VERTICAL_SIZE));
        labelPassword.setHorizontalAlignment(SwingConstants.LEFT);
        passwordBox.add(labelPassword);

        passwordField = new JPasswordField(10);
        passwordField.setSize(new Dimension(200, VERTICAL_SIZE));
        passwordBox.add(passwordField);

        return passwordBox;
    }


    private void setLogInSelectButton() {
        final int VERTICAL_SIZE = 20;
        final int BUTTON_WIDTH = 75;

        radioButtonClinician = new JRadioButton("Clinician");
        radioButtonPatient = new JRadioButton("Patient");

        ButtonGroup loginSelectBG = new ButtonGroup();
        loginSelectBG.add(radioButtonClinician);
        loginSelectBG.add(radioButtonPatient);

        // Set bounds for radio buttons to place them next to the login button
        radioButtonClinician.setBounds(300, 250, BUTTON_WIDTH, VERTICAL_SIZE);
        radioButtonPatient.setBounds(375, 250, BUTTON_WIDTH, VERTICAL_SIZE);

        //Set PatientMode on Defalut
        radioButtonPatient.setSelected(true);

        mainPanel.add(radioButtonClinician);
        mainPanel.add(radioButtonPatient);
    }

    public JRadioButton getSelectedLoginRadioButton(){
        if(radioButtonPatient.isSelected()){
            return radioButtonPatient;
        } else if (radioButtonClinician.isSelected()) {
            return radioButtonClinician;
        }
        else {
            throw new RuntimeException("Neither radio Button is selected");
        }
    }







    private JButton setLoginButton(){
        final int VERTICAL_SIZE = 20;
        final int HORIZONTAL_SIZE = 100;
        JButton buttonLogin = new JButton("Login");

        buttonLogin.setBounds(500, 250, HORIZONTAL_SIZE, VERTICAL_SIZE); // Set bounds explicitly

        buttonLogin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                performLoginAction();
            }
        });

        return buttonLogin;
    }



    private void performLoginAction(){
        String userName = textFieldUsername.getText();
        String password = Arrays.toString(passwordField.getPassword());







        //Check Login success or not
        if (authenticateLogin()) {
            JOptionPane.showMessageDialog(mainPanel, "Welcome");
            setNextState();
            mainPanel.repaintToNextState();


        } else {
            JOptionPane.showMessageDialog(mainPanel, "Your user name/Password does not match");
        }
    }

    private boolean authenticateLogin(){

        return true;
    }


}
