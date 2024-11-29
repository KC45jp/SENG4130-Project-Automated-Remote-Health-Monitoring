package patientRecord.dbHandler;

public class genericRecord {

    private int recordId;

    genericRecord(int recordId){
        this.recordId = recordId;
    }

    public int getRecordId() {
        return recordId;
    }
}
