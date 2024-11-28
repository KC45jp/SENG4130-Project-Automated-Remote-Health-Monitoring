package displayGUI.patientDetailv3.mainDetailPanelComponent;

import javax.swing.*;
import java.awt.*;

public class PatientDetailPanel extends JPanel {

    private JPanel generalInformation;
    private JPanel thresholdPanel;
    private JPanel graphPanel;
    private JPanel currentPanel;



    private JLabel searchindexLabel;
    private JLabel searchTypelabel;

    public PatientDetailPanel(){

        setPreferredSize(new Dimension(700,600));
        setLayout(new GridLayout(2,2,10,10));

        searchTypelabel = new JLabel("You searched by :");
        add(searchTypelabel);

        searchindexLabel = new JLabel();
        add(searchindexLabel);
    }

    public void setSearchindexLabel(String searchType, String searchIndex){
        searchindexLabel.setText(searchType + " for " + searchIndex);
    }


    public void refreshPanel(){
        invalidate();
        validate();
        repaint();
    }



}
