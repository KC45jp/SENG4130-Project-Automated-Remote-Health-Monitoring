package patientRecord;

import java.util.EventListener;

// イベントリスナーインターフェース
public interface PatientDataChangeListener extends EventListener {
    void patientDataChanged(PatientDataChangeEvent event);
}
