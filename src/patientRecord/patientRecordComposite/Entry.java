package patientRecord.patientRecordComposite;

/**Composite Pattern
 * Entry of Composite pattern the basic structure of the component of composite pattern.
 */
public abstract class Entry {

    protected String name;

    public String getName(){
        return name;
    }

    /**For future we should be able to get data from here.
     * @param query
     * @return
     */
    public abstract String getContent(String query);

    public abstract boolean isLeaf();

}
