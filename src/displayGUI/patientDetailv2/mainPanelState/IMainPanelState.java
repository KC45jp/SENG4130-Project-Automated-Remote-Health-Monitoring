package displayGUI.patientDetailv2.mainPanelState;

import userData.userDefaultData;

public interface IMainPanelState {

    default void excute(){
        handleState();
        setUI();
        setNextState();
    }

    public userDefaultData getUserDefaultData();
    public void handleState();
    public void setUI();

    public void setNextState();

}
