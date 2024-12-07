package displayGUI.patientDetailv3;


import displayGUI.patientDetailv3.sideBarPanelComponent.ClinicianSideBar;

import javax.swing.*;
import java.awt.*;

/**View of the MVC model.
 * Have two component, sidebar and detail panel. Controller select what to do.
 */
public class MainPanel extends JPanel {

    public final int Main_WIDTH;
    public final int Main_HEIGHT;

    public JPanel sideBarPanel;
    public JPanel mainDetailPanel;

    //public static ClinicianSideBar clinicianSideBar;

    public MainPanel(int width, int height){
        setSize(width, height);
        setLayout(new BorderLayout());
        Main_WIDTH = width;
        Main_HEIGHT = height;
        addComponents();
        setVisible(true);
    }

    private void addComponents(){

    }


    public void setSideBarPanel(JPanel panel){
        if(sideBarPanel != null){
            remove(sideBarPanel);
        }


        if(panel != null){
            sideBarPanel = panel;
            add(sideBarPanel, BorderLayout.WEST);
        }

        refreshPanel();
    }

    public void setMainDetailPanel(JPanel panel){

        if(mainDetailPanel != null){
            remove(mainDetailPanel);
        }

        if(panel != null){
            mainDetailPanel = panel;
            add(mainDetailPanel, BorderLayout.CENTER);
        }

        refreshPanel();
    }

    /**To refresh panel when it is updated.
     */
    public void refreshPanel(){
        invalidate();
        validate();
        repaint();
    }
}
