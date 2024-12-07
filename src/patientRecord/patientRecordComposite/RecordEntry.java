package patientRecord.patientRecordComposite;

import java.util.ArrayList;
import java.util.List;

/**Contain List of the one tyoe of records (In this case, Bloodpressure) got by patient device. Held by patientEntry.
 */
public abstract class RecordEntry extends Entry {

    protected List<Entry> record;

    public RecordEntry(String name){
        super.name = name;
        record = new ArrayList<>();
    }

    @Override
    public String getContent(String query){
        String s;
        s = name;
        for(Entry entry: record){
            s+= " ";
            s+= entry.getName();
        }
        return s;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    public Entry add(Entry entry){
        //record.add(entry);
        record.addFirst(entry);
        return this;
    }

    public List<Entry> getRecord() {
        return record;
    }
}
