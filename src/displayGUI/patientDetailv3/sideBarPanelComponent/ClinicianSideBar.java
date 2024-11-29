package displayGUI.patientDetailv3.sideBarPanelComponent;

import userData.patientData.PatientData;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ClinicianSideBar extends JPanel {

    private JRadioButton patientIdRadioButton;
    private JRadioButton patientNameRadioButton;
    private JTextField patientSearchTextField;
    private JButton actionButton;
    private JList<PatientData> dataJList;
    private ButtonGroup patientSearchModeSelectBG;
    private ArrayList<PatientData> patientDataArrayList;
    DefaultListModel<PatientData> listModel;

    public ClinicianSideBar() {
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(200, 200));
        //this.patientDataArrayList = patientDataArrayList;


        addComponents();
    }

    private void addComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        addSearchBoxLabel(gbc);
        addSearchBox(gbc);
        addActionButton(gbc);
        addDataJList(gbc);
    }

    private void addSearchBoxLabel(GridBagConstraints gbc) {
        JLabel label = new JLabel("Enter Patient Name or ID");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        add(label, gbc);
    }

    private void addSearchBox(GridBagConstraints gbc) {
        patientSearchTextField = new JTextField();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(patientSearchTextField, gbc);

        Box radioButtonBox = new Box(BoxLayout.X_AXIS);
        patientIdRadioButton = new JRadioButton("ID");
        patientNameRadioButton = new JRadioButton("Name");

        patientSearchModeSelectBG = new ButtonGroup();
        patientSearchModeSelectBG.add(patientIdRadioButton);
        patientSearchModeSelectBG.add(patientNameRadioButton);

        patientNameRadioButton.setSelected(true);

        radioButtonBox.add(patientIdRadioButton);
        radioButtonBox.add(patientNameRadioButton);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(radioButtonBox, gbc);
    }

    private void addActionButton(GridBagConstraints gbc) {
        actionButton = new JButton("Execute");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(actionButton, gbc);
    }

    private void addDataJList(GridBagConstraints gbc) {
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        listModel = new DefaultListModel<>();
//        for (PatientData patientData : patientDataArrayList) {
//            listModel.addElement(patientData);
//        }

        dataJList = new JList<>(listModel);

        JScrollPane scrollPane = new JScrollPane(dataJList);
        add(scrollPane, gbc);
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

    public JList<PatientData> getDataJList() {
        return dataJList;
    }

    public void setListModel(ArrayList<PatientData> patientDataArrayList){
        listModel.removeAllElements();
        for (PatientData patientData : patientDataArrayList) {
            listModel.addElement(patientData);
        }

    }
}
