package displayGUI.patientDetailv3.mainPanelState;



import displayGUI.patientDetailv3.MainPanelController;
import displayGUI.patientDetailv3.sideBarPanelComponent.ClinicianSideBar;

import patientRecord.IPatientDataChangeListener;
import patientRecord.PatientDataChangeEvent;
import patientRecord.patientRecordComposite.Entry;
import patientRecord.patientRecordComposite.PatientEntry;
import patientRecord.patientRecordComposite.PatientListEntry;
import patientRecord.patientRecordComposite.recordContent.bloodPressure.BloodPressureRecord;
import patientRecord.patientRecordComposite.recordContent.bloodPressure.BloodPressureRecordList;
import userData.patientData.PatientData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.function.DoublePredicate;

/**Singleton class State for Clinician.
 */
public class ClinicianMode implements  IMainPanelState, IPatientDataChangeListener {

    private static MainPanelController mainPanelController;

    private static ClinicianMode clinicianMode;

    private static PatientData patientData = null;


    /**Private constructor for singleton pattern
     * @param mainPanelController
     */
    private ClinicianMode(MainPanelController mainPanelController){
        ClinicianMode.mainPanelController = mainPanelController;
        //addListener
        mainPanelController.getPatientDataManager().addPatientDataChangeListener(this);

        //bloodPressurePanel = new BloodPressurePanel();

    }

    /**Create instance and return it.
     * @param mainPanelController
     * @return
     */
    public static ClinicianMode initializeInstance(MainPanelController mainPanelController){
        if(mainPanelController == null){
            throw new RuntimeException("main Panel Controller is null");
        }

        if(clinicianMode == null ){
            clinicianMode = new ClinicianMode(mainPanelController);
        } else if (ClinicianMode.mainPanelController != mainPanelController) {
            throw new RuntimeException("There should not be a multiple main panel controller");
        }
        return clinicianMode;
    }

    /** get this instance without making instance - less time to go through
     * @return
     */
    public static ClinicianMode getInstance(){
        if(mainPanelController == null){
            throw new RuntimeException("main Panel Controller is null");
        }
        return clinicianMode;
    }

    @Override
    public void handleState() {
        TESTER();

    }

    @Override
    public void setUI() {

        //Set Side Bar
        setSideBar();
        setDetailPanel();
        setPatientLogData();


    }

    @Override
    public void setNextState() {
        //Actually doing nothing for next uodate, it should go back to login state
        mainPanelController.setNextPanelState(mainPanelController.getLoginState());
    }

    /**Perform search acgtion at sidebar.
     */
    private void performSearchAction(String searchMode, String searchWord){

        /*
        search user by search mode and word and update sidebar
         */

    }


    private void setSideBar(){
        ClinicianSideBar clinicianSideBar = mainPanelController.getDefalutSideBarComponent();
        mainPanelController.setSideBar(clinicianSideBar);
        String searchWord = clinicianSideBar.getPatientSearchTextField().getText();

        clinicianSideBar.getActionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //Below is temporary if statement to do test mode function
                if(clinicianSideBar.getPatientIdRadioButton().isSelected()){
                    //mainPanelController.getPatientDetailPanel().setSearchindexLabel("ID", getSerchText(clinicianSideBar));
                    JOptionPane.showMessageDialog(mainPanelController.getPatientDetailPanel(), "Does Not Support in this version. This test list all users.");
                    //Update Sidebar
                    clinicianSideBar.setListModel(mainPanelController.getUserList().getPatientDataArrayList());

                } else if (clinicianSideBar.getPatientNameRadioButton().isSelected()) {

                    //NO function for now - just show it is not supported

                    //mainPanelController.getPatientDetailPanel().setSearchindexLabel("Name", getSerchText(clinicianSideBar));
                    JOptionPane.showMessageDialog(mainPanelController.getPatientDetailPanel(), "Does Not Support in this version. Test function available via ID search.");
                }
                else {
                    //neither radio button is selected is out of consideration - there should be a bug
                    throw new RuntimeException("Unsupported Radio Button");
                }
                //refresh panel
                mainPanelController.getPatientDetailPanel().refreshPanel();
            }
        });


       //Get Selected Patient by double click
        clinicianSideBar.getDataJList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() ==2){
                    int index = clinicianSideBar.getDataJList().locationToIndex(e.getPoint());
                    PatientData selectedPatient = clinicianSideBar.getDataJList().getModel().getElementAt(index);
                    patientData = selectedPatient;
                    setPatientGeneralInfo();
                    setPatientLogData();

                }
            }
        });


    }

    ///Patient Search Function
    /// NO IMPLEMENTATION in prototype
//    private String getSerchText(ClinicianSideBar clinicianSideBar){
//        return clinicianSideBar.getPatientSearchTextField().getText();
//    }
//
//    private void searchById(ClinicianSideBar clinicianSideBar, String searchWord){
//
//    }


    private void setDetailPanel(){
        JPanel detailPanelComponent = mainPanelController.getPatientDetailPanel();

        mainPanelController.setDetailPanel(detailPanelComponent);
    }

    //PatientData

    ///Patient Data
    ///
    /** this will set patient general data such as name, adress, etc
     */
    private void setPatientGeneralInfo(){
        mainPanelController.getPatientDetailPanel().setNewPatient(patientData);
    }

    /**This will set patient log
     */
    private void setPatientLogData(){

        //Get patient history data
        PatientListEntry patientListEntry = mainPanelController.getPatientDataManager().getPatientListEntry();

        PatientEntry patientEntry;

        //If there are not patient data then do nothing
        if(patientData == null){
            return;
        }


        //get patient record
        //SHould fo it in business logic
        if(patientListEntry.getContent(patientData.getUserId()).equals(patientData.getUserId())){
            patientEntry = (PatientEntry) patientListEntry.getRecordContent(patientData.getUserId());
        }
        else {
            throw  new RuntimeException("Error");
            //return;
        }



        //Should do it in business logic
        if(patientEntry.getRecord().isEmpty()){
            mainPanelController.getPatientDetailPanel().setPatientLogPanel(null);
        }

        //get each record in blood pressure
        //should be done by business logic but I did not have time for it
        for(Entry e: patientEntry.getRecord()){
            if( e instanceof BloodPressureRecordList){

                //update pane
                mainPanelController.getPatientDetailPanel().setPatientLogPanel((BloodPressureRecordList) e);




                //Show pop up
                List<Entry> bloodPressureRecordArrayList = ((BloodPressureRecordList) e).getRecord();


                BloodPressureRecord newData = (BloodPressureRecord) bloodPressureRecordArrayList.getLast();


                //if the patient added data is more than the threshold, display pop up as alert.
                if(checkThreshold(patientData, newData)){
                    JOptionPane.showMessageDialog(mainPanelController.getPatientDetailPanel(), newData);
                }

                break;
            }
        }
    }

    /** Check threshold and the value
     * @param pd
     * @param bloodPressureRecord
     * @return
     */
    private boolean checkThreshold(PatientData pd, BloodPressureRecord bloodPressureRecord){

        if(pd.getBloodPressureThreshold().isEmpty()){
            return true;
        }

        double sH = Double.parseDouble((String) pd.getBloodPressureThreshold().get("bpSystolicH")) ;
        double sL = Double.parseDouble((String) pd.getBloodPressureThreshold().get("bpSystolicL"));
        double dL = Double.parseDouble((String) pd.getBloodPressureThreshold().get("bpDiastolicL"));
        double dH = Double.parseDouble((String) pd.getBloodPressureThreshold().get("bpDiastolicH"));
        double currentS = Double.parseDouble(bloodPressureRecord.getContent("systolic"));
        double currentd = Double.parseDouble(bloodPressureRecord.getContent("diastolic"));



        if((sH < currentS) |(sL > currentS) | dH < currentd | dL > currentd){
            return false;
        }

        return true;
    }










    //Event Lisner when it is updated
    @Override
    public void patientDataChanged(PatientDataChangeEvent event) {
        if(patientData != null){
            if(patientData.getUserId().equals(event.getUserId())){
                setPatientLogData();
            }

        }

    }


    ///TEST method to add data three clicks and can enter user data

    public void TESTER(){

        mainPanelController.getPatientDetailPanel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == 3){
                    addBloodPressureRecordFromInput();
                }

            }
        });


    }
    public void addBloodPressureRecordFromInput() {
        JTextField userIdField = new JTextField(5);
        JTextField recordIdField = new JTextField(5);
        JTextField systolicField = new JTextField(5);
        JTextField diastolicField = new JTextField(5);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        panel.add(new JLabel("User ID:"));
        panel.add(userIdField);
        panel.add(new JLabel("Record ID:"));
        panel.add(recordIdField);
        panel.add(new JLabel("Systolic Pressure:"));
        panel.add(systolicField);
        panel.add(new JLabel("Diastolic Pressure:"));
        panel.add(diastolicField);

        int result = JOptionPane.showConfirmDialog(null, panel,
                "Enter Blood Pressure Record", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            try {
                String userId = userIdField.getText();
                String recordId = recordIdField.getText();
                int systolic = Integer.parseInt(systolicField.getText());
                int diastolic = Integer.parseInt(diastolicField.getText());

                mainPanelController.getPatientDataManager().addBloodPressureRecord(userId, recordId, systolic, diastolic);
                JOptionPane.showMessageDialog(null, "Blood pressure record added successfully for user " + userId);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter valid numbers for blood pressure values.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }





}
