package displayGUI.patientDetailv3.mainDetailPanelComponent.patientDetailComponent;

import patientRecord.PatientDataChangeEvent;
import patientRecord.PatientDataChangeListener;
import userData.patientData.PatientData;

import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class PatientInfoPanel extends JPanel {

    public PatientData patientData;

    private GridBagLayout gridBagLayout;
    private GridBagConstraints gbc;

    private Font defaultFont;

    public PatientInfoPanel(PatientData patientData) {
        this.patientData = patientData;

        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(600, 600));
        gridBagLayout = new GridBagLayout();

        defaultFont = new Font("Arial", Font.PLAIN, 25);
        setComponent();
    }

    private void setGridBagConstrains() {
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(10, 10, 10, 10);
    }

    private GridBagConstraints getSetGridBagConstrains(int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;

        return gbc;
    }

    private GridBagConstraints getSetGridBagConstrains(int x, int y, int width, int height) {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = x;
        gbc.gridy = y;

        gbc.gridwidth = width;
        gbc.gridheight = height;

        return gbc;
    }

    private void setComponent() {
        setGridBagConstrains();
        add(setLabelPatientNameLabel(), getSetGridBagConstrains(0, 0));
        add(setLabelPatientName(patientData), getSetGridBagConstrains(1, 0));

        add(setLabelAddressLabel(), getSetGridBagConstrains(0, 1));
        add(setLabelAddress(patientData), getSetGridBagConstrains(1, 1));

        add(setLabelEmailLabel(), getSetGridBagConstrains(0, 2));
        add(setLabelEmail(patientData), getSetGridBagConstrains(1, 2));
    }

    private JLabel setLabelPatientNameLabel() {
        JLabel labelPatientNameLabel = new JLabel("UserName");
        labelPatientNameLabel.setFont(defaultFont);
        return labelPatientNameLabel;
    }

    private JLabel setLabelPatientName(PatientData pd) {
        JLabel patientNameLabel = new JLabel(pd.getFullname());
        patientNameLabel.setFont(defaultFont);
        return patientNameLabel;
    }

    private JLabel setLabelAddressLabel() {
        JLabel labelAddressLabel = new JLabel("Address");
        labelAddressLabel.setFont(defaultFont);
        return labelAddressLabel;
    }

    private JLabel setLabelAddress(PatientData pd) {
        JLabel addressLabel = new JLabel(pd.getAddress());
        addressLabel.setFont(defaultFont);
        return addressLabel;
    }

    private JLabel setLabelEmailLabel() {
        JLabel labelEmailLabel = new JLabel("Email");
        labelEmailLabel.setFont(defaultFont);
        return labelEmailLabel;
    }

    private JLabel setLabelEmail(PatientData pd) {
        JLabel emailLabel = new JLabel(pd.getEmail());
        emailLabel.setFont(defaultFont);
        return emailLabel;
    }
}
