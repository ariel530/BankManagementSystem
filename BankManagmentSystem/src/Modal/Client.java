package Modal;

public class Client extends Login {

    private String userType;

    public Client(String userName, String password, String firstName, String lastName) {
        super(userName, password, firstName, lastName);
        this.userType = "CLIENT";
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Client() {
    }
    

}
