package patientRecord.dbHandler;
import java.time.LocalDateTime;

public class BloodPressureRecord {
    private LocalDateTime recordTime;
    private int systolic;
    private int diastolic;

    public BloodPressureRecord(LocalDateTime recordTime, int systolic, int diastolic) {
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
                "recordTime=" + recordTime +
                ", systolic=" + systolic +
                ", diastolic=" + diastolic +
                '}';
    }
}
