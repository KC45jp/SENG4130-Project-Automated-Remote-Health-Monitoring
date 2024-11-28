package displayGUI.patientDetailv3.mainPanelState;

public interface IMainPanelState {

    default void excute(){
        handleState();
        setUI();
        setNextState();
    }

    public void handleState();
    public void setUI();

    public void setNextState();
}
