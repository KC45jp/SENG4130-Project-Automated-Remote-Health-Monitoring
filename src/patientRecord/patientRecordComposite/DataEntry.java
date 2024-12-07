package patientRecord.patientRecordComposite;

/**Holld each data of record which is the leaf of the node.
 */
public class DataEntry extends Entry {


    private String value;

    public DataEntry(String name, String value) {
        super.name = name;
        this.value = value;
    }

    @Override
    public String getContent(String s) {
        //regurd less of the input return value.
        return value;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }
}
