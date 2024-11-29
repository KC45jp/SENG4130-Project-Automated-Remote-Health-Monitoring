package displayGUI.patientDetailv3.mainDetailPanelComponent.patientDetailComponent;

import displayGUI.patientDetailv3.mainDetailPanelComponent.patientDetailComponent.infoPanel.PatientInfoPanel;


import patientRecord.patientRecordComposite.Entry;
import patientRecord.patientRecordComposite.recordContent.bloodPressure.BloodPressureRecord;
import patientRecord.patientRecordComposite.recordContent.bloodPressure.BloodPressureRecordList;
import userData.patientData.PatientData;

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;

public class PatientDetailPanel extends JPanel {

    private PatientData pd;
    private JPanel generalInformation;
    private GridBagConstraints gbc;

    private JList jlist;


    public PatientDetailPanel() {
        // パネルの初期設定
        setPreferredSize(new Dimension(700, 600));
        setLayout(new GridBagLayout());
        setDefaultComponent();
    }

    // 新しい患者データを設定
    public void setNewPatient(PatientData pd) {
        setGridBagConstrains(); // GridBagConstraintsの初期化
        this.pd = pd;
        setGeneralInformation(pd);
        refreshPanel(); // パネルを更新
    }

    // パネルのデフォルトコンポーネントを設定
    public void setDefaultComponent() {
        removeAll(); // すべてのコンポーネントを削除
    }

    // GridBagConstraintsの設定
    private void setGridBagConstrains() {
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.insets = new Insets(10, 10, 10, 10);
    }

    // GridBagConstraintsを設定して取得
    private GridBagConstraints getSetGridBagConstrains(int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        return gbc;
    }

    // GridBagConstraintsを設定して取得（幅と高さ指定）
    private GridBagConstraints getSetGridBagConstrains(int x, int y, int width, int height) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.insets = new Insets(10, 10, 10, 10);
        //gbc.fill = GridBagConstraints.BOTH;
        return gbc;
    }

    // 患者の基本情報パネルを設定
    public void setGeneralInformation(PatientData pd) {
        if(generalInformation != null){
            remove(generalInformation);
        }

        generalInformation = null;
        generalInformation = new PatientInfoPanel(pd);
        add(generalInformation, getSetGridBagConstrains(0, 0, 1, 1));
    }

    // 患者ログパネルを設定
    public void setPatientLogPanel(BloodPressureRecordList bloodPressureRecordList) {


        //If parameter is empty
        if(bloodPressureRecordList == null){
            if(jlist != null){
                jlist.removeAll();
                remove(jlist);
            }
            refreshPanel();
            return;
        }


        //Parameter is not empty
        DefaultListModel<BloodPressureRecord> listModel = new DefaultListModel<>();
        for(Entry bloodPressureRecord: bloodPressureRecordList.getRecord()){
            if(bloodPressureRecord.isLeaf() & bloodPressureRecord instanceof BloodPressureRecord){
                listModel.addElement((BloodPressureRecord) bloodPressureRecord);

            }
            else {
                throw new RuntimeException("Error class does not match");
            }
        }

        if(jlist != null){
            remove(jlist);
        }
        jlist = null;
        jlist = new JList<>(listModel);

        add(jlist, getSetGridBagConstrains(0, 1, 1, 1));
        refreshPanel();
    }


    public void setPatientLogPanel(boolean isWarning, BloodPressureRecordList bloodPressureRecordList) {


        //If parameter is empty
        if(bloodPressureRecordList == null){
            if(jlist != null){
                jlist.removeAll();
                remove(jlist);
            }
            refreshPanel();
            return;
        }


        //Parameter is not empty
        DefaultListModel<BloodPressureRecord> listModel = new DefaultListModel<>();
        for(Entry bloodPressureRecord: bloodPressureRecordList.getRecord()){
            if(bloodPressureRecord.isLeaf() & bloodPressureRecord instanceof BloodPressureRecord){
                listModel.addElement((BloodPressureRecord) bloodPressureRecord);

            }
            else {
                throw new RuntimeException("Error class does not match");
            }
        }

        if(jlist != null){
            remove(jlist);
        }
        jlist = null;
        jlist = new JList<>(listModel);

        add(jlist, getSetGridBagConstrains(0, 1, 1, 1));
        refreshPanel();
    }

    public JList getJlist() {
        return jlist;
    }

    private void testFunction(){



    }






    // パネルを更新
    public void refreshPanel() {
        invalidate(); // パネルを無効化
        validate(); // パネルを有効化
        repaint(); // パネルを再描画
    }
}
