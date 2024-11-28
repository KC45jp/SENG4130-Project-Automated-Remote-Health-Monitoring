package displayGUI.patientDetailv3.mainPanelState;



import displayGUI.patientDetailv3.MainPanelController;
import displayGUI.patientDetailv3.sideBarPanelComponent.clinicianSideBar;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**Singleton class State for Clinician
 */
public class ClinicianMode implements  IMainPanelState{

    private static MainPanelController mainPanelController;

    private static ClinicianMode clinicianMode;


    private ClinicianMode(MainPanelController mainPanelController){
        ClinicianMode.mainPanelController = mainPanelController;
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
        clinicianSideBar clinicianSideBar = mainPanelController.getDefalutSideBarComponent();
        mainPanelController.setSideBar(clinicianSideBar);
        String searchWord = clinicianSideBar.getPatientSearchTextField().getText();

        clinicianSideBar.getActionButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if(clinicianSideBar.getPatientIdRadioButton().isSelected()){
                    mainPanelController.getPatientDetailPanel().setSearchindexLabel("ID", getSerchText(clinicianSideBar));

                } else if (clinicianSideBar.getPatientNameRadioButton().isSelected()) {
                    mainPanelController.getPatientDetailPanel().setSearchindexLabel("Name", getSerchText(clinicianSideBar));
                }
                else {
                    throw new RuntimeException("Unsupported Radio Button");
                }
                mainPanelController.getPatientDetailPanel().refreshPanel();

            }
        });

    }

    private String getSerchText(clinicianSideBar clinicianSideBar){
        return clinicianSideBar.getPatientSearchTextField().getText();
    }


    private void searchById(clinicianSideBar clinicianSideBar, String searchWord){

    }






    private void setDetailPanel(){
        JPanel detailPanelComponent = mainPanelController.getPatientDetailPanel();
        mainPanelController.setDetailPanel(detailPanelComponent);
    }


}
