package patientRecord;

import java.util.HashMap;
import java.util.Map;

public class DBTestGetter implements PatientDataChangeListener {
    private final PatientDataManager dataManager;

    public DBTestGetter(PatientDataManager dataManager) {
        this.dataManager = dataManager;
        this.dataManager.addPatientDataChangeListener(this);
    }

    @Override
    public void patientDataChanged(PatientDataChangeEvent event) {
        System.out.println("Patient data changed for userId: " + event.getUserId());
        for (Map.Entry<String, HashMap<String, Object>> entry : dataManager.getDataMap().entrySet()) {
            System.out.println("UserId: " + entry.getKey() + ", Data: " + entry.getValue());
        }
    }
}
