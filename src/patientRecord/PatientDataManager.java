package patientRecord;

import patientRecord.patientRecordComposite.Entry;
import patientRecord.patientRecordComposite.PatientEntry;
import patientRecord.patientRecordComposite.PatientListEntry;
import patientRecord.patientRecordComposite.RecordEntry;
import patientRecord.patientRecordComposite.recordContent.bloodPressure.BloodPressureRecord;
import patientRecord.patientRecordComposite.recordContent.bloodPressure.BloodPressureRecordList;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PatientDataManager {

    private PatientListEntry patientListEntry;
    private final List<IPatientDataChangeListener> listeners = new ArrayList<>();

    public PatientDataManager() {

        patientListEntry = new PatientListEntry();
        TEST();




    }

    public void addPatientDataChangeListener(IPatientDataChangeListener listener) {
        listeners.add(listener);
    }


    public void addBloodPressureRecord(String userId, String recordId, int systolic, int diastolic) {

        PatientEntry patientEntry;
        BloodPressureRecordList bprl;

        if(patientListEntry.getContent(userId).equals(userId)){
            patientEntry = (PatientEntry) patientListEntry.getRecordContent(userId);
        }
        else {
            return;
        }

        BloodPressureRecord bpr = new BloodPressureRecord(recordId, systolic, diastolic);

        int i = 1;


        for(Entry e: patientEntry.getRecord()){
            if(e instanceof BloodPressureRecordList){
                bprl = (BloodPressureRecordList) e;
                bprl.add(bpr);
                break;
            } else if (patientEntry.getRecord().size() == i) {
                bprl = new BloodPressureRecordList();
                patientEntry.add(bprl);
                bprl.add(bpr);
            }
            i++;
        }

        if(patientEntry.getRecord().isEmpty()){
            bprl = new BloodPressureRecordList();
            bprl.add(bpr);
            patientEntry.add(bprl);
        }


        triggerDataChangeEvent(userId);
    }

  private void triggerDataChangeEvent(String userId) {
        PatientDataChangeEvent event = new PatientDataChangeEvent(this, userId);
        for (IPatientDataChangeListener listener : listeners) {
            listener.patientDataChanged(event);
        }

  }

    public PatientListEntry getPatientListEntry() {
        return patientListEntry;
    }


    private void TEST(){
        PatientEntry p1 = new PatientEntry("p001");
        PatientEntry p2 = new PatientEntry("p002");


        patientListEntry.add(p1);
        patientListEntry.add(p2);


        addBloodPressureRecord("p001", "test001", 120, 90);

    }
}
