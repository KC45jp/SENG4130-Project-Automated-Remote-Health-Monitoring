package displayGUI;

import javax.swing.*;

public abstract class AbstractDisplay extends JFrame {

    protected final int Main_FRAME_WIDTH = 900;
    protected final int Main_FRAME_HEIGHT = 600;


    public AbstractDisplay(String labelTitile){
        super(labelTitile);
        setTitle("Registration Form");


        setBounds(30,100, Main_FRAME_WIDTH, Main_FRAME_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);



        addComponents();
        setActionListener();

        //var c = getContentPane();
        //c.setLayout(null);

        setVisible(true);
    }

    protected abstract void addComponents();

    protected abstract void setActionListener();

    protected int getCenterAlignmentValue(int mainFrameSize,int componentSize){
        return ((mainFrameSize - componentSize)/2);
    }




}
