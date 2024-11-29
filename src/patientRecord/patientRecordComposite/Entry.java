package patientRecord.patientRecordComposite;

public abstract class Entry {

    protected String name;

    public String getName(){
        return name;
    }
    public abstract String getContent(String query);

    public abstract boolean isLeaf();

}
