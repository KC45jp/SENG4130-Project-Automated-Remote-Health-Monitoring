package patientRecord;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Random;

public class DBTestInserter {
    private final PatientDataManager dataManager;
    private final Random random = new Random();

    public DBTestInserter(PatientDataManager dataManager) {
        this.dataManager = dataManager;
    }

    // 患者データを作成し、入力を受け取るメソッド
    public void createPatientData() {
        for (int i = 1; i <= 5; i++) {
            String userId = String.format("u%03d", i);
            HashMap<String, Object> data = new HashMap<>();

            // 血圧記録を追加
            for (int j = 0; j < 5; j++) {
                //BloodPressureRecord record = new BloodPressureRecord(LocalDateTime.now(), random.nextInt(40) + 80, random.nextInt(40) + 60);
                dataManager.addBloodPressureRecord(userId, LocalDateTime.now(), random.nextInt(40) + 80, random.nextInt(40) + 60);
            }
        }
    }
}
