package displayGUI.patientDetailv2;

import displayGUI.AbstractDisplay;
import displayGUI.patientDetailv2.mainPanelState.IMainPanelState;
import displayGUI.patientDetailv2.mainPanelState.LogInState;

import javax.swing.*;

public class MainDisplay extends AbstractDisplay {

    MainPanel mainPanel;


    public MainDisplay(String labelTitile) {
        super(labelTitile);
    }




    @Override
    protected void addComponents() {
        var c = getContentPane();
        c.add(setMainPanel());

        //test();




    }

    @Override
    protected void setActionListener() {

    }

    public JPanel setMainPanel() {
        mainPanel = new MainPanel(Main_FRAME_WIDTH, Main_FRAME_HEIGHT);
        mainPanel.setLocation(0,0);
        mainPanel.startUI();
        return mainPanel;
    }

    private void resetPanel(){
        invalidate();
        validate();
        repaint();
    }

    private void test(){
        JLabel label = new JLabel("test");
        add(label);
    }

}
