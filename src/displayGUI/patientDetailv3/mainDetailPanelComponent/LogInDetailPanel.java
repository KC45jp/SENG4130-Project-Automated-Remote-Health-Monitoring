package displayGUI.patientDetailv3.mainDetailPanelComponent;

import javax.swing.*;
import java.awt.*;

public class LogInDetailPanel extends JPanel {

    private JTextField textFieldUsername;
    private JPasswordField passwordField;

    private JRadioButton radioButtonClinician;
    private JRadioButton radioButtonPatient;

    private JButton buttonLogin;

    private GridBagLayout gridBagLayout;
    private GridBagConstraints gbc;

    public LogInDetailPanel(){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600,600));
        gridBagLayout = new GridBagLayout();
        setComponent();

        setVisible(true);
    }

    private void setGridBagConstrains(){
         gbc = new GridBagConstraints();
        gbc.insets = new Insets(10,10,10,10);
    }

    private GridBagConstraints getSetGridBagConstrains(int x, int y){

        gbc.gridx = x;
        gbc.gridy = y;

        return gbc;
    }

    private GridBagConstraints getSetGridBagConstrains(int x, int y, int width, int height){
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = x;
        gbc.gridy = y;

        gbc.gridwidth = width;
        gbc.gridheight = height;

        return gbc;
    }


    private void setComponent(){

        setGridBagConstrains();

        add(setLabelLogin(), getSetGridBagConstrains(1, 0));
        add(setUsernameBox(), getSetGridBagConstrains(0, 1,5,1));
        add(setPasswordBox(), getSetGridBagConstrains(0, 2, 5,1));
        add(setRadioButtonClinician(), getSetGridBagConstrains(0, 3));
        add(setRadioButtonPatient(), getSetGridBagConstrains(1, 3));
        add(setLoginButton(), getSetGridBagConstrains(5,4));
        setLogInSelectButtonGroup();
    }

    private JLabel setLabelLogin(){
        JLabel labelLogin = new JLabel("Log In");
        labelLogin.setFont(new Font("Arial", Font.BOLD, 25));
        labelLogin.setHorizontalAlignment(SwingConstants.CENTER);

        return labelLogin;
    }

    private Box setUsernameBox(){
        final int VERTICAL_SIZE = 20;
        final int HORIZONTAL_SIZE = 300;

        Box userNameBox = Box.createHorizontalBox();

        JLabel labelUsername = new JLabel("User Name ");
        labelUsername.setFont(new Font("Arial", Font.PLAIN, VERTICAL_SIZE));
        labelUsername.setHorizontalAlignment(SwingConstants.LEFT);
        userNameBox.add(labelUsername);

        textFieldUsername = new JTextField(10);
        userNameBox.add(textFieldUsername);

        return userNameBox;
    }

    private Box setPasswordBox(){
        final int VERTICAL_SIZE = 20;
        final int HORIZONTAL_SIZE = 300;

        Box passwordBox = Box.createHorizontalBox();
        JLabel labelPassword = new JLabel("Password ");
        labelPassword.setFont(new Font("Arial", Font.PLAIN, VERTICAL_SIZE));
        labelPassword.setHorizontalAlignment(SwingConstants.LEFT);
        passwordBox.add(labelPassword);

        passwordField = new JPasswordField(10);
        passwordBox.add(passwordField);

        return passwordBox;
    }

    private JRadioButton setRadioButtonClinician(){
        final int VERTICAL_SIZE = 20;
        radioButtonClinician = new JRadioButton("Clinician");
        radioButtonClinician.setFont(new Font("Arial", Font.PLAIN, VERTICAL_SIZE));
        return radioButtonClinician;
    }

    private JRadioButton setRadioButtonPatient(){
        final int VERTICAL_SIZE = 20;
        radioButtonPatient = new JRadioButton("Patient");
        radioButtonPatient.setFont(new Font("Arial", Font.PLAIN, VERTICAL_SIZE));
        return radioButtonPatient;
    }




    private void setLogInSelectButtonGroup() {
        final int VERTICAL_SIZE = 20;
        final int BUTTON_WIDTH = 75;

        ButtonGroup loginSelectBG = new ButtonGroup();
        loginSelectBG.add(radioButtonClinician);
        loginSelectBG.add(radioButtonPatient);

        radioButtonPatient.setSelected(true);
    }
    private JButton setLoginButton(){
        final int VERTICAL_SIZE = 20;
        final int HORIZONTAL_SIZE = 100;
        buttonLogin = new JButton("Login");

        return buttonLogin;
    }


    //Getter SET

    public JTextField getTextFieldUsername() {
        return textFieldUsername;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public JRadioButton getRadioButtonClinician() {
        return radioButtonClinician;
    }

    public JRadioButton getRadioButtonPatient() {
        return radioButtonPatient;
    }

    public JButton getButtonLogin() {
        return buttonLogin;
    }
}
