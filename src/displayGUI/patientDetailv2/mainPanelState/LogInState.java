package displayGUI.patientDetailv2.mainPanelState;

import displayGUI.patientDetailv2.MainPanel;
import userData.userDefaultData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class LogInState implements IMainPanelState {

    MainPanel mainPanel;

    JTextField textFieldUsername;
    JPasswordField passwordField;

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
        mainPanel.removeAll();

        mainPanel.add(setLabelLogin());
        mainPanel.add(setLabelUsername());
        mainPanel.add(setPasswordBox());
        mainPanel.add(setLoginButton());

        mainPanel.refreshPanel();
    }

    @Override
    public void nextState() {
        // No next state handling required
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

        if (true) {
            JOptionPane.showMessageDialog(mainPanel, "Your user name/Password match");
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Your user name/Password does not match");
        }
    }
}
