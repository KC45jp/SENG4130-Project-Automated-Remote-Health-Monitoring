package displayGUI.patientDetailv3;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    MainPanel mainPanel;

    protected final int Main_FRAME_WIDTH = 900;
    protected final int Main_FRAME_HEIGHT = 600;



    public MainFrame(String labelTitile, MainPanel mainPanel) {
        super(labelTitile);
        setBounds(30,100, Main_FRAME_WIDTH, Main_FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(600,600));
        //setResizable(false);
        this.mainPanel = mainPanel;

        addComponents();
        setVisible(true);
    }





    protected void addComponents() {
        var c = getContentPane();
        c.add(setMainPanel());
    }

    public JPanel setMainPanel() {
        mainPanel.setLocation(0,0);
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
