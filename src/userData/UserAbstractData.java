package userData;

/**Template of User data. save generic informagtion such as userId, name, passowords, etc...
 */
public abstract class UserAbstractData {


    protected String userId;
    protected String password;
    protected String givenName;
    protected String familyName;
    protected String phoneNumber;
    protected String email;
    protected String address;




    public UserAbstractData(String userId, String givenName, String familyName, String password, String phoneNumber, String email, String address){
        this.userId = userId;
        this.givenName = givenName;
        this.familyName = familyName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    public String getUserId() {
        return userId;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return userId + " " + givenName;
    }

    public String getFullname(){
        return givenName + " " + familyName;
    }
}
