package userData.patientData;

import userData.UserAbstractData;

import java.util.HashMap;

/**Patient Data class extended from UserAbstructed Data
 */
public class PatientData extends UserAbstractData {

    //Directly implemented Blood pressure threshold information - for future this should be implemented by userdata
    HashMap<String, String> bpThreshold;

    /// Main Clinitian -0 likely to be a doctor.
    String mainClinicianId;

    public PatientData(String userId, String givenName, String familyName, String password, String phoneNumber, String email, String address) {
        super(userId, givenName, familyName, password, phoneNumber, email, address);
        this.mainClinicianId = mainClinicianId;
        bpThreshold = new HashMap<>();
    }


    /// The method implemented here should be implemented in  decorator or something for future

    /**Set Bloodpressure threshold
     * @param systolicH
     * @param systolicL
     * @param diastolicH
     * @param diastolicL
     */
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
