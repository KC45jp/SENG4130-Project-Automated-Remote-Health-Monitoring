package displayGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class LogInDisplay extends AbstractDisplay {



    JTextField textFieldUsername;
    JPasswordField passwordField;
    //JButton buttonLogin;


    public LogInDisplay(int width, int height){
        super("Login", width, height);

    }

    @Override
    protected void addComponents(){
        var c = getContentPane();
        c.add(setLabelLogin());
        c.add(setLabelUsername());
        c.add(setPasswordBox());
        c.add(setLoginButton());
    }

    @Override
    protected void setActionListener() {

        textFieldUsername.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    performLoginAction();
                }
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    performLoginAction();
                }
            }
        });
    }


    private JLabel setLabelLogin(){
        JLabel labelLogin = new JLabel("Log In");
        labelLogin.setFont(new Font("Arial", Font.BOLD, 25));
        labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
        labelLogin.setSize(100,25);
        labelLogin.setLocation(400,100);
        return labelLogin;
    }

    private Box setLabelUsername(){

        final int VERTICAL_SIZE = 20;
        final int HORIZONTAL_SIZE = 300;
        Box userNameBox = new Box(BoxLayout.X_AXIS);
        userNameBox.setLocation(getCenterAlignmentValue(Main_FRAME_WIDTH, HORIZONTAL_SIZE),150);
        userNameBox.setSize(HORIZONTAL_SIZE,VERTICAL_SIZE);

        JLabel labelUsername = new JLabel("User Name ");
        labelUsername.setFont(new Font("Arial", Font.BOLD, VERTICAL_SIZE));
        labelUsername.setHorizontalAlignment(SwingConstants.LEFT);
        labelUsername.setSize(100,VERTICAL_SIZE);
        userNameBox.add(labelUsername);

        textFieldUsername = new JTextField("user id");
        textFieldUsername.setSize(100, VERTICAL_SIZE);
        textFieldUsername.setLocation(200 , 0);
        userNameBox.add(textFieldUsername);

        return userNameBox;
    }

    private Box setPasswordBox(){
        final int VERTICAL_SIZE = 20;
        final int HORIZONTAL_SIZE = 300;
        Box passwordBox = new Box(BoxLayout.X_AXIS);
        passwordBox.setLocation(getCenterAlignmentValue(Main_FRAME_WIDTH, HORIZONTAL_SIZE), 200);
        passwordBox.setSize(HORIZONTAL_SIZE, VERTICAL_SIZE);

        JLabel labelPassword = new JLabel("Password ");
        labelPassword.setFont(new Font("Arial", Font.BOLD, VERTICAL_SIZE));
        labelPassword.setHorizontalAlignment(SwingConstants.LEFT);
        labelPassword.setSize(100,VERTICAL_SIZE);
        passwordBox.add(labelPassword);

        passwordField = new JPasswordField();
        passwordField.setSize(100, VERTICAL_SIZE);
        passwordBox.add(passwordField);
        return passwordBox;
    }


    private JButton setLoginButton(){

        final int VERTICAL_SIZE = 20;
        final int HORIZONTAL_SIZE = 100;
        JButton buttonLogin = new JButton("Login");


        buttonLogin.setLocation(500, 250);
        buttonLogin.setSize(HORIZONTAL_SIZE, VERTICAL_SIZE);
        //buttonLogin.setVisible(true);


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

        if(true){
            JOptionPane.showMessageDialog(this,"Your user name/Password match");
        }
        else{
            JOptionPane.showMessageDialog(this,"Your user name/Password does not match");
        }

    }

}
