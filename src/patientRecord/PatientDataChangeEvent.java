package patientRecord;

import java.util.EventObject;

public class PatientDataChangeEvent extends EventObject {
    private final String userId;

    public PatientDataChangeEvent(Object source, String userId) {
        super(source);
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }
}
