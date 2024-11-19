package patientRecord;

import patientRecord.dbHandler.BloodPressureRecord;
import patientRecord.dbHandler.IDBHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class PatientDataManager {
    private final Map<String, HashMap<String, Object>> dataMap = new ConcurrentHashMap<>();
    private final List<PatientDataChangeListener> listeners = new ArrayList<>();
    private final IDBHandler dbHandler;
    private int recordCounter = 0;

    public PatientDataManager(IDBHandler dbHandler) {
        this.dbHandler = dbHandler;
        loadData();
    }

    private void loadData() {
        Map<String, HashMap<String, Object>> initialData = dbHandler.loadData();
        for (Map.Entry<String, HashMap<String, Object>> entry : initialData.entrySet()) {
            dataMap.put(entry.getKey(), entry.getValue());
            // 最大のレコード番号を探す
            for (String key : entry.getValue().keySet()) {
                if (key.startsWith("Record")) {
                    int recordNumber = Integer.parseInt(key.substring(6));
                    if (recordNumber >= recordCounter) {
                        recordCounter = recordNumber + 1;
                    }
                }
            }
        }
    }

    // イベントリスナーを追加する
    public void addPatientDataChangeListener(PatientDataChangeListener listener) {
        listeners.add(listener);
    }

    // イベントリスナーを削除する
    public void removePatientDataChangeListener(PatientDataChangeListener listener) {
        listeners.remove(listener);
    }

    // データを追加または更新する
    public void putData(String userId, HashMap<String, Object> data) {
        dataMap.put(userId, data);
        dbHandler.saveData(dataMap);
        triggerDataChangeEvent(userId);
    }

    // データを削除する
    public void removeData(String userId) {
        dataMap.remove(userId);
        dbHandler.saveData(dataMap);
        triggerDataChangeEvent(userId);
    }

    // データを取得する
    public HashMap<String, Object> getData(String userId) {
        return dataMap.get(userId);
    }

    public Map<String, HashMap<String, Object>> getDataMap() {
        return dataMap;
    }

    // 血圧記録を追加する
    public void addBloodPressureRecord(String userId, BloodPressureRecord record) {
        HashMap<String, Object> userData = dataMap.getOrDefault(userId, new HashMap<>());
        userData.put("Record" + recordCounter++, record);
        putData(userId, userData);
    }

    // データが変更されたときにイベントをトリガーする
    private void triggerDataChangeEvent(String userId) {
        PatientDataChangeEvent event = new PatientDataChangeEvent(this, userId);
        for (PatientDataChangeListener listener : listeners) {
            listener.patientDataChanged(event);
        }
    }
}
