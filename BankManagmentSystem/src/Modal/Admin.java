package Modal;

public class Admin extends Login {

    private String userType;

    public Admin() {
    }

    public Admin(String userName, String password, String firstName, String lastName) {
        super(userName, password, firstName, lastName);
        this.userType = "ADMIN";
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    
}
