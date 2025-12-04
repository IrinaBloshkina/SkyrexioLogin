import io.qameta.allure.*;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginTest extends BaseTest {

    @Epic("Модуль логина Skyrexio")
    @Feature("Авторизация")
    @Story("Валидная авторизация")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Irina Bloshkina @kakoy to vnutrenniy chat ")
    @TmsLink("SkyrexioLogin/tree/Branch-1")
    @Test
    public void openProject() {
        open("login");
        LoginPage loginPage = new LoginPage();
        loginPage.openPage();
        User user = UserFactory.withRegularUserPermission();
        loginPage.login(user);
        $("svg[aria-haspopup='menu']").shouldBe(visible);
    }
}
