package patientRecord.patientRecordComposite;

import java.util.ArrayList;
import java.util.List;

public class PatientEntry extends Entry{

    protected List<Entry> record;


    public PatientEntry(String name) {
        super.name = name;
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
        return this;
    }

    public List<Entry> getRecord() {
        return record;
    }
}
