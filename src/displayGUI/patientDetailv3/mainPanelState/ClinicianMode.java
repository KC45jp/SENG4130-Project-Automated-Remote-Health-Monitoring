package displayGUI.patientDetailv3.mainPanelState;



import displayGUI.patientDetailv3.MainPanelController;
import displayGUI.patientDetailv3.mainDetailPanelComponent.patientDetailComponent.PatientInfoPanel;
import displayGUI.patientDetailv3.sideBarPanelComponent.ClinicianSideBar;

import patientRecord.PatientDataChangeEvent;
import patientRecord.PatientDataChangeListener;
import patientRecord.PatientDataManager;
import userData.patientData.PatientData;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**Singleton class State for Clinician
 */
public class ClinicianMode implements  IMainPanelState, PatientDataChangeListener {

    private static MainPanelController mainPanelController;

    private static ClinicianMode clinicianMode;

    private static PatientData patientData = null;



    private ClinicianMode(MainPanelController mainPanelController){
        ClinicianMode.mainPanelController = mainPanelController;
        //addListener
        mainPanelController.getPatientDataManager().addPatientDataChangeListener(ClinicianMode.getInstance());

    }

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

    public static ClinicianMode getInstance(){
        if(mainPanelController == null){
            throw new RuntimeException("main Panel Controller is null");
        }

        return clinicianMode;
    }

    @Override
    public void handleState() {

    }

    @Override
    public void setUI() {

        //Set Side Bar
        setSideBar();
        setDetailPanel();


    }

    @Override
    public void setNextState() {
        //Actually doing nothing.
        mainPanelController.setNextPanelState(mainPanelController.getLoginState());
    }

    private void performSearchAction(){



    }


    private void setSideBar(){
        ClinicianSideBar clinicianSideBar = mainPanelController.getDefalutSideBarComponent();
        mainPanelController.setSideBar(clinicianSideBar);
        String searchWord = clinicianSideBar.getPatientSearchTextField().getText();

        clinicianSideBar.getActionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(clinicianSideBar.getPatientIdRadioButton().isSelected()){
                    //mainPanelController.getPatientDetailPanel().setSearchindexLabel("ID", getSerchText(clinicianSideBar));
                    JOptionPane.showMessageDialog(mainPanelController.getPatientDetailPanel(), "Does Not Support in this version. This test list all users.");
                    clinicianSideBar.setListModel(mainPanelController.getUserList().getPatientDataArrayList());

                } else if (clinicianSideBar.getPatientNameRadioButton().isSelected()) {
                    //mainPanelController.getPatientDetailPanel().setSearchindexLabel("Name", getSerchText(clinicianSideBar));
                    JOptionPane.showMessageDialog(mainPanelController.getPatientDetailPanel(), "Does Not Support in this version. Test function available via ID search.");
                }
                else {
                    throw new RuntimeException("Unsupported Radio Button");
                }
                mainPanelController.getPatientDetailPanel().refreshPanel();
            }
        });



       //Get Selected Patient
        clinicianSideBar.getDataJList().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() ==2){
                    int index = clinicianSideBar.getDataJList().locationToIndex(e.getPoint());
                    PatientData selectedPatient = clinicianSideBar.getDataJList().getModel().getElementAt(index);
                    patientData = selectedPatient;
                    setPatientGeneralInfo();
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
    /**
     *
     */
    private void setPatientGeneralInfo(){

        mainPanelController.getPatientDetailPanel().setNewPatient(patientData);
    }

    private void setPatientLogData(){

    }









    @Override
    public void patientDataChanged(PatientDataChangeEvent event) {
        if(patientData != null){
            if(patientData.getUserId().equals(event.getUserId())){


            }

        }

    }
}
