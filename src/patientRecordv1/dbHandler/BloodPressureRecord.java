package patientRecord.dbHandler;
import java.time.LocalDateTime;

public class BloodPressureRecord extends genericRecord{
    private LocalDateTime recordTime;
    private int systolic;
    private int diastolic;

    public BloodPressureRecord(int id, LocalDateTime recordTime, int systolic, int diastolic) {
        super(id);
        this.recordTime = recordTime;
        this.systolic = systolic;
        this.diastolic = diastolic;
    }

    public LocalDateTime getRecordTime() {
        return recordTime;
    }

    public int getSystolic() {
        return systolic;
    }

    public int getDiastolic() {
        return diastolic;
    }

    @Override
    public String toString() {
        return "BloodPressureRecord{" +
                "recordId="+ getRecordId()+
                ", recordTime=" + recordTime +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                '}';
    }
}
