package displayGUI.patientDetailv3.mainPanelState;


/// Use Singleton class for State - less use of resources + better accesss time..




/**State Pattern Interface for controller.
 */
public interface IMainPanelState {

    /**Excute thist State.
     */
    default void excute(){
        handleState();
        setUI();
        setNextState();
    }

    public void handleState();
    public void setUI();

    public void setNextState();
}
