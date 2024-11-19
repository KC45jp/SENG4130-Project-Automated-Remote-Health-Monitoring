package displayGUI;

import javax.swing.*;

public abstract class AbstractDisplay extends JFrame {

    protected final int Main_FRAME_WIDTH;
    protected final int Main_FRAME_HEIGHT;


    public AbstractDisplay(String labelTitile, int width, int height){
        super(labelTitile);
        setTitle("Registration Form");

        Main_FRAME_WIDTH = width;
        Main_FRAME_HEIGHT = height;


        setBounds(30,100, Main_FRAME_WIDTH, Main_FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        var c = getContentPane();
        c.setLayout(null);

        addComponents();
        setActionListener();

        setVisible(true);

    }

    protected abstract void addComponents();

    protected abstract void setActionListener();

    protected int getCenterAlignmentValue(int mainFrameSize,int componentSize){
        return ((mainFrameSize - componentSize)/2);
    }




}
