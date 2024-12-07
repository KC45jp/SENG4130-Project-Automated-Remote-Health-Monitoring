package userData.clinitianData;

import userData.UserAbstractData;
import userData.patientData.PatientData;

import java.util.ArrayList;

/**ClinicianData class is the data for clinitian which saves patient they are watching
 * Not used in this prototype as of December 2024
 */
public class ClinicianData extends UserAbstractData {

    ArrayList<String> patientDataArrayList;

    public ClinicianData(String userId, String givenName, String familyName, String password, String phoneNumber, String email, String address) {
        super(userId, givenName, familyName, password, phoneNumber, email, address);
        patientDataArrayList = new ArrayList<>();
    }


    public boolean addPatient(String patientId){

        if(!patientDataExist(patientId)){
            System.err.println("Patient Not Exist");
            return false;
        }

        for(String s : patientDataArrayList){
            if(s.equals(patientId)){
                System.err.println("Patient Already Implemented");
                return false;
            }
        }

        patientDataArrayList.add(patientId);
        return true;
    }

    /**return
     * @param patientId
     * @return
     */
    public boolean patientDataExist(String patientId){

        //Check arraylist of patient id and return true if it exist.
        return true;
    }


    /**get all patient id they are watching
     * @return arralist of patient id
     */
    public ArrayList<String> getPatientDataArrayList() {
        return patientDataArrayList;
    }
}
