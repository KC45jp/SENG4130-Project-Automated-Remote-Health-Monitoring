package displayGUI.patientDetailv3.mainDetailPanelComponent.patientDetailComponent.logPanel;

import javax.swing.*;
import java.util.ArrayList;

public abstract class AbstractPatientLogPanel extends JPanel {

    /**
     * Check the all the log
     */
    ArrayList arrayList;


    JList jList;

    public AbstractPatientLogPanel(ArrayList arrayList){
        this.arrayList = arrayList;
    }

    public abstract void setJList();





}



