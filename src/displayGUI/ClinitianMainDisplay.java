package displayGUI;

import javax.swing.*;
import java.awt.*;

public class ClinitianMainDisplay extends AbstractDisplay{

    final int Main_FRAME_WIDTH = 900;
    final int Main_FRAME_HEIGHT = 600;

    public ClinitianMainDisplay(){
        super("Welcome");




    }

    @Override
    protected void addComponents() {

    }

    @Override
    protected void setActionListener() {

    }

    protected JScrollPane setPatientTableScrollPane(JTable patientTable){
        final int VERTICAL_SIZE = 200;
        final int HORIZONTAL_SIZE = 400;
        JScrollPane patientListScrollPane = new JScrollPane(patientTable);
        patientListScrollPane.setPreferredSize(new Dimension(HORIZONTAL_SIZE, VERTICAL_SIZE));



        return patientListScrollPane;
    }

    protected JTable setPatientTable() {
        JTable patientTable = new JTable(8,20);


        return patientTable;
    }


}
