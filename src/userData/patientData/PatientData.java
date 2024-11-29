package userData.patientData;

import userData.UserAbstractData;

import java.util.HashMap;

public class PatientData extends UserAbstractData {

    HashMap<String, String> bpThreshold;

    String mainClinicianId;

    public PatientData(String userId, String givenName, String familyName, String password, String phoneNumber, String email, String address) {
        super(userId, givenName, familyName, password, phoneNumber, email, address);
        this.mainClinicianId = mainClinicianId;
        bpThreshold = new HashMap<>();
    }


    public void setBloodPressureThreshold(double systolicH, double systolicL, double diastolicH, double diastolicL){
        bpThreshold.put("bpSystolicH", String.valueOf(systolicH));
        bpThreshold.put("bpSystolicL", String.valueOf(systolicL));
        bpThreshold.put("bpDiastolicH", String.valueOf(diastolicH));
        bpThreshold.put("bpDiastolicL", String.valueOf(diastolicL));
    }

    public HashMap getBloodPressureThreshold(){
        return bpThreshold;
    }

}
