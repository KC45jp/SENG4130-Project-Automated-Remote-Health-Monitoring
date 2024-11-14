package displayGUI;

import javax.swing.*;

public abstract class AbstractDisplay extends JFrame {


    public AbstractDisplay(String labelTitile){
        super(labelTitile);
        setTitle("Registration Form");
        setBounds(30, 100, 900, 600);
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
