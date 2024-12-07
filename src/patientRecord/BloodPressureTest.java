package patientRecord;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class BloodPressureTest {
    private PatientDataManager patientDataManager;
    private ScheduledExecutorService scheduler;
    private boolean isRunning = false;
    private Random random = new Random();
    private int recordCounter = 1;

    public BloodPressureTest(PatientDataManager patientDataManager) {
        this.patientDataManager = patientDataManager;
    }

    public void start() {
        if (isRunning) {
            stop();
        }
        isRunning = true;
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            if (!isRunning) return;

            String userId1 = "p001";
            String userId2 = "p002";
            String recordId1 = String.format("%03d", recordCounter++);
            String recordId2 = String.format("%03d", recordCounter++);

            int systolic1 = 100 + random.nextInt(50);
            int diastolic1 = 60 + random.nextInt(40);

            int systolic2 = 100 + random.nextInt(50);
            int diastolic2 = 60 + random.nextInt(40);

            patientDataManager.addBloodPressureRecord(userId1, recordId1, systolic1, diastolic1);
            patientDataManager.addBloodPressureRecord(userId2, recordId2, systolic2, diastolic2);

            System.out.println("Added records for " + userId1 + " and " + userId2);
        }, 0, 1, TimeUnit.SECONDS);
    }

    public void stop() {
        if (!isRunning) return;

        isRunning = false;
        if (scheduler != null) {
            scheduler.shutdown();
        }
    }
}
