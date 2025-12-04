import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import user.User;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private SelenideElement emailInput =  $x("//input[@placeholder='Email']");
    private SelenideElement passwordInput = $x("//input[@type='password']");
    private SelenideElement loginBtn = $x( "//button[@type='submit']");
    private SelenideElement viewBox = $("svg[aria-haspopup='menu']");

    @Step("Загружаем страницу")
    public void openPage() {
        open("/login");
    }

    @Step("Логинимся под кредами: логин = {user.email}, пароль = *******, кликаем 'Login', проверяем видимость иконки ЛК")
    public void login(User user) {
        emailInput.setValue(user.getEmail()).pressEnter();
        passwordInput.setValue(user.getPassword());
        loginBtn.click();
        viewBox.should(Condition.visible);
    }
}
