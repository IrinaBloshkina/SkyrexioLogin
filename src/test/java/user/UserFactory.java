package user;
import utils.PropertyReader;

public class UserFactory {
    public static User withRegularUserPermission() {
        return new User(PropertyReader.getProperty("skyrexio.user"),
                PropertyReader.getProperty("skyrexio.password"));
    }
}
