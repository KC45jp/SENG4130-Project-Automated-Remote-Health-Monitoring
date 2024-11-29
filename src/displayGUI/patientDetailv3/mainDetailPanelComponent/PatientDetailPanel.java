package displayGUI.patientDetailv3.mainDetailPanelComponent;

import displayGUI.patientDetailv3.mainDetailPanelComponent.patientDetailComponent.PatientInfoPanel;
import userData.patientData.PatientData;

import javax.swing.*;
import java.awt.*;

public class PatientDetailPanel extends JPanel {

    private PatientData pd;
    private JPanel generalInformation;
    private JPanel patientLogPanel;
    private GridBagConstraints gbc;

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
        add(generalInformation, getSetGridBagConstrains(0, 0, 2, 1));
    }

    // 患者ログパネルを設定
    public void setPatientLogPanel(String patientId) {

        //remove panel
        if(patientLogPanel != null){
            remove(patientLogPanel);
        }
        patientLogPanel = null;



        add(patientLogPanel, getSetGridBagConstrains(0, 1, 2, 1));
    }

    // パネルを更新
    public void refreshPanel() {
        invalidate(); // パネルを無効化
        validate(); // パネルを有効化
        repaint(); // パネルを再描画
    }
}
