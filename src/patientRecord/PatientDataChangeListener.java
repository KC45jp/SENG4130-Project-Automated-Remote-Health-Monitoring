package patientRecord;

import java.util.EventListener;

// イベントリスナーインターフェース
interface PatientDataChangeListener extends EventListener {
    void patientDataChanged(PatientDataChangeEvent event);
}
