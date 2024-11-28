package userData;

import java.util.HashMap;
import java.util.Objects;

public abstract class userDefaultData {

    String userId;
    String password;
    String userType;

    public userDefaultData(String userId, String password, String userType){
        this.userId = userId;
        this.password = password;
        this.userType = userType;
    }

    public abstract HashMap<String, Object> getUserContent();
}
