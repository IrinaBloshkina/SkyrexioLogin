package user;

import org.jspecify.annotations.Nullable;
import utils.PropertyReader;

public class UserFactory {
    public static User withRegularUserPermission() {
        return new User(PropertyReader.getProperty("skyrexio.user"),
                PropertyReader.getProperty("skyrexio.password"));
    }
}
