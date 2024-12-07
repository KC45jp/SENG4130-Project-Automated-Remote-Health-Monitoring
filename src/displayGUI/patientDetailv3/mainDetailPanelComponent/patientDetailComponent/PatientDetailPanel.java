package displayGUI.patientDetailv3.mainDetailPanelComponent.patientDetailComponent;

import displayGUI.patientDetailv3.mainDetailPanelComponent.patientDetailComponent.infoPanel.PatientInfoPanel;


import patientRecord.patientRecordComposite.Entry;
import patientRecord.patientRecordComposite.recordContent.bloodPressure.BloodPressureRecord;
import patientRecord.patientRecordComposite.recordContent.bloodPressure.BloodPressureRecordList;
import userData.patientData.PatientData;

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;

public class PatientDetailPanel extends JPanel {

    private PatientData pd;
    private JPanel generalInformation;
    private GridBagConstraints gbc;

    private JList jlist;


    public PatientDetailPanel() {
        // initialize panel
        setPreferredSize(new Dimension(700, 600));
        setLayout(new GridBagLayout());
        setDefaultComponent();
    }

    // set new patient
    public void setNewPatient(PatientData pd) {
        setGridBagConstrains(); // GridBagConstraints initilize
        this.pd = pd;
        setGeneralInformation(pd);
        refreshPanel(); // refresh panel
    }

    // get default panel component which remove everything for this one _ no sidebars
    public void setDefaultComponent() {
        removeAll();
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

    // set ridBagConstraints but you can set width and heights as well
    private GridBagConstraints getSetGridBagConstrains(int x, int y, int width, int height) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.insets = new Insets(10, 10, 10, 10);
        //gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }

    /**
     * Detail panel for general information of patient like name and address
      */
    public void setGeneralInformation(PatientData pd) {
        if(generalInformation != null){
            remove(generalInformation);
        }

        generalInformation = null;
        generalInformation = new PatientInfoPanel(pd);
        add(generalInformation, getSetGridBagConstrains(0, 0, 1, 1));
    }

    /** set patient logpanel and return it
     * @param bloodPressureRecordList
     */
    public void setPatientLogPanel(BloodPressureRecordList bloodPressureRecordList) {


        //If parameter is empty
        if(bloodPressureRecordList == null){
            if(jlist != null){
                jlist.removeAll();
                remove(jlist);
            }
            refreshPanel();
            return;
        }


        //Parameter is not empty
        DefaultListModel<BloodPressureRecord> listModel = new DefaultListModel<>();
        for(Entry bloodPressureRecord: bloodPressureRecordList.getRecord()){
            if(bloodPressureRecord.isLeaf() & bloodPressureRecord instanceof BloodPressureRecord){
                listModel.addElement((BloodPressureRecord) bloodPressureRecord);

            }
            else {
                throw new RuntimeException("Error class does not match");
            }
        }

        if(jlist != null){
            remove(jlist);
        }
        jlist = null;
        jlist = new JList<>(listModel);

        add(jlist, getSetGridBagConstrains(0, 1, 1, 1));
        refreshPanel();
    }


    //Not in use for this prototype - panel for the alert
    public void setPatientAlertPanel(boolean isWarning, BloodPressureRecordList bloodPressureRecordList) {


        //If parameter is empty
        if(bloodPressureRecordList == null){
            if(jlist != null){
                jlist.removeAll();
                remove(jlist);
            }
            refreshPanel();
            return;
        }


        //Parameter is not empty
        DefaultListModel<BloodPressureRecord> listModel = new DefaultListModel<>();
        for(Entry bloodPressureRecord: bloodPressureRecordList.getRecord()){
            if(bloodPressureRecord.isLeaf() & bloodPressureRecord instanceof BloodPressureRecord){
                listModel.addElement((BloodPressureRecord) bloodPressureRecord);

            }
            else {
                throw new RuntimeException("Error class does not match");
            }
        }

        if(jlist != null){
            remove(jlist);
        }
        jlist = null;
        jlist = new JList<>(listModel);

        add(jlist, getSetGridBagConstrains(0, 1, 1, 1));
        refreshPanel();
    }


    /**refresh panel like other refreshers
     */
    public void refreshPanel() {
        invalidate();
        validate();
        repaint();
    }
}
