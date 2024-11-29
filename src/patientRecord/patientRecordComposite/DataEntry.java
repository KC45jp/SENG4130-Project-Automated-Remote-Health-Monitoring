package patientRecord.patientRecordComposite;

public class DataEntry extends Entry {


    private String value;

    public DataEntry(String name, String value) {
        super.name = name;
        this.value = value;
    }

    @Override
    public String getContent(String s) {
        return value;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
