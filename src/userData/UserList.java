package userData;

import userData.clinitianData.ClinicianData;
import userData.patientData.PatientData;

import java.util.ArrayList;

/**User List class has array list of users both clinician and patient.
 */
public class UserList {

    private ArrayList<ClinicianData> clinicianDataArrayList;
    private ArrayList<PatientData> patientDataArrayList;

    public UserList(ArrayList<ClinicianData> clinicianDataArrayList, ArrayList<PatientData> patientDataArrayList){
        this.clinicianDataArrayList = clinicianDataArrayList;
        this.patientDataArrayList = patientDataArrayList;
    }


    public ArrayList<ClinicianData> getClinicianDataArrayList() {
        return clinicianDataArrayList;
    }

    public ArrayList<PatientData> getPatientDataArrayList() {
        return patientDataArrayList;
    }


}
