package displayGUI.patientDetailv3;


import displayGUI.patientDetailv3.sideBarPanelComponent.clinicianSideBar;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    public final int Main_WIDTH;
    public final int Main_HEIGHT;

    public JPanel sideBarPanel;
    public JPanel mainDetailPanel;

    public static clinicianSideBar clinicianSideBar;

    public MainPanel(int width, int height){
        setSize(width, height);
        setLayout(new BorderLayout());
        Main_WIDTH = width;
        Main_HEIGHT = height;
        addComponents();
        setVisible(true);
    }

    private void addComponents(){
//        sideBarPanel = new JPanel();
//        add(sideBarPanel, BorderLayout.WEST);
//        mainDetailPanel = new JPanel();
//        add(mainDetailPanel, BorderLayout.CENTER);

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

    public void refreshPanel(){
        invalidate();
        validate();
        repaint();
    }
}
