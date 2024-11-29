package patientRecord.dbHandler;

import java.util.HashMap;
import java.util.Map;

public interface IDBHandler {
    void saveData(Map<String, HashMap<String, Object>> dataMap);
    Map<String, HashMap<String, Object>> loadData();
}
