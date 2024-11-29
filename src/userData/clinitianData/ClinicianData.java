package userData.clinitianData;

import userData.UserAbstractData;
import userData.patientData.PatientData;

import java.util.ArrayList;

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

    public boolean patientDataExist(String patientId){

        return true;
    }


    public ArrayList<String> getPatientDataArrayList() {
        return patientDataArrayList;
    }
}
