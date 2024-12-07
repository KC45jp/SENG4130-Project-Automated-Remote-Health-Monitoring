package patientRecord;

import java.util.EventListener;

public interface IPatientDataChangeListener extends EventListener {
    public void patientDataChanged(PatientDataChangeEvent event);
}
