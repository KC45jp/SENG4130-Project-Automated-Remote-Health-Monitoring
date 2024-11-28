package displayGUI.patientDetailv2.sidebarPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClinicianSidePanel extends SidePanel {

    private JRadioButton patientIDRadioButton;
    private JRadioButton patientNameRadioButton;
    private JTextField searchField;
    private JButton searchButton;
    private JList<String> patientList;

    public ClinicianSidePanel() {
        super();
    }

    @Override
    protected void addComponents() {
        // Create and add radio buttons
        patientIDRadioButton = new JRadioButton("Patient ID");
        patientNameRadioButton = new JRadioButton("Patient Name");
        ButtonGroup group = new ButtonGroup();
        group.add(patientIDRadioButton);
        group.add(patientNameRadioButton);

        // Add radio buttons to the panel
        add(patientIDRadioButton);
        add(patientNameRadioButton);

        // Create and add search field
        searchField = new JTextField();
        add(searchField);

        // Create and add search button
        searchButton = new JButton("Search");
        add(searchButton);

        // Create and add patient list component
        patientList = new JList<>();
        add(new JScrollPane(patientList));
    }

    // Method to update the patient list
    public void updatePatientList(List<String> patients) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String patient : patients) {
            listModel.addElement(patient);
        }
        patientList.setModel(listModel);
    }
}
