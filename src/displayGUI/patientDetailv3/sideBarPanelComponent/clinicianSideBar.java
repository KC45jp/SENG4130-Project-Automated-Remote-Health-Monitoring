package displayGUI.patientDetailv3.sideBarPanelComponent;

import javax.swing.*;
import java.awt.*;

public class clinicianSideBar extends JPanel {


    private JRadioButton patientIdRadioButton;
    private JRadioButton patientNameRadioButton;
    private JTextField patientSearchTextField;
    private JButton actionButton;

    private ButtonGroup patientSearchModeSelectBG;

    public clinicianSideBar(){
        setLayout(new GridLayout(10,1,10,10));
        setPreferredSize(new Dimension(200,200));
        addComponents();
    }

    private void addComponents(){
        addSearchBoxLabel();
        addSearchBox();
        addActionButton();
    }

    private void addSearchBoxLabel(){
        JLabel label = new JLabel("Enter Patient Name or ID");
        add(label);
    }


    private void addSearchBox(){
        patientSearchTextField = new JTextField();
        patientSearchTextField.setSize(150,10);
        add(patientSearchTextField);


        Box radioButtonBox = new Box(BoxLayout.X_AXIS);
        patientIdRadioButton = new JRadioButton("ID");
        patientNameRadioButton = new JRadioButton("Name");

        patientSearchModeSelectBG = new ButtonGroup();
        patientSearchModeSelectBG.add(patientIdRadioButton);
        patientSearchModeSelectBG.add(patientNameRadioButton);

        patientNameRadioButton.setSelected(true);

        radioButtonBox.add(patientIdRadioButton);
        radioButtonBox.add(patientNameRadioButton);
        add(radioButtonBox);
    }

    private void addActionButton(){
        actionButton = new JButton("Execute");
        actionButton.setSize(100,25);
        add(actionButton);
    }


    public JRadioButton getPatientNameRadioButton() {
        return patientNameRadioButton;
    }

    public JRadioButton getPatientIdRadioButton() {
        return patientIdRadioButton;
    }

    public JTextField getPatientSearchTextField() {
        return patientSearchTextField;
    }

    public JButton getActionButton() {
        return actionButton;
    }
}
