package ZoomCar.Models;

public class User extends BaseClass{
    private final String name, password;
    private final Location basedInCity;
    public User(String name, String password, Location loc){
        this.basedInCity = loc;
        this.name = name;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
