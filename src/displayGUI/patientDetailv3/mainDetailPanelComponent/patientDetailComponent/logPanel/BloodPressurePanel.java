package displayGUI.patientDetailv3.mainDetailPanelComponent.patientDetailComponent.logPanel;


import patientRecord.dbHandler.BloodPressureRecord;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;

public class BloodPressurePanel extends AbstractPatientLogPanel  {

    public BloodPressurePanel(ArrayList<BloodPressureRecord> brp){
        super(brp);
    }


    @Override
    public void setJList() {

    }
}
