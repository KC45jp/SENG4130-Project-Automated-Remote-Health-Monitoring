package patientRecord.patientRecordComposite;

import java.util.ArrayList;
import java.util.List;

public class PatientListEntry extends Entry{

    protected List<Entry> record;


    public PatientListEntry() {
        super.name = "PatientList";
        record = new ArrayList<>();
    }

    @Override
    public String getContent(String query) {
        for(Entry e: record){
            if(e.getName().equals(query)){
                return query;
            }
        }
        return null;
    }


    @Override
    public boolean isLeaf() {
        return false;
    }

    public Entry add(Entry entry){
        record.add(entry);
        if(getContent(entry.getName()) == null){
            System.err.println("item id already exist");
        }
        return this;
    }

    public List<Entry> getRecord() {
        return record;
    }

    public Entry getRecordContent(String query) {
        for(Entry e: record){
            if(e.getName().equals(query)){
                return e;
            }
        }
        return null;
    }
}
