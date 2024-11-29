package patientRecord.patientRecordComposite.recordContent.bloodPressure;


import patientRecord.patientRecordComposite.Entry;

import java.time.LocalDateTime;

public class BloodPressureRecord extends Entry {

    private double systolic;
    private double diastolic;
    private LocalDateTime recordTime;


    public BloodPressureRecord(String id, double systolic, double diastolic) {
        name = id;
        this.systolic = systolic;
        this.diastolic = diastolic;
        recordTime = LocalDateTime.now();

    }



    @Override
    public String getContent(String query) {

        if(query.equals("systolic")){
            return Double.toString(systolic);
        } else if (query.equals("diastolic")) {
            return Double.toString(diastolic);
        } else if (query.equals("dateTime")) {
            return recordTime.toString();

        } else {
            throw new RuntimeException("Query is wrong.");
        }
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public String toString() {
        return (name + " " + recordTime) ;
    }
}
