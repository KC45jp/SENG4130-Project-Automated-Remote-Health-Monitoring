package displayGUI.patientDetailv2.sidebarPanel;

import javax.swing.*;
import java.awt.*;

/*
Side Panel

Patient Mode
-Display Main Doctor

Clinician Mode
-Search Box
 */

public abstract class SidePanel extends JPanel {

    public SidePanel(){
        setLayout(new GridLayout(5,1,10,10));
        setPreferredSize(new Dimension(200,600));
        addComponents();
    }

    protected abstract void addComponents();
}
