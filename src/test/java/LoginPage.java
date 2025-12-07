import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import user.User;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    private static final SelenideElement emailInput =  $x("//input[@placeholder='Email']");
    private static final SelenideElement passwordInput = $x("//input[@type='password']");
    private static final SelenideElement loginBtn = $x( "//button[@type='submit']");
    private static final SelenideElement statistic = $x("//*[text()='Статистика']  ");

    @Step("Загружаем страницу")
    public static void open() {
        Selenide.open("/login");
    }

    @Step("Логинимся под кредами: логин = {user.email}, пароль = *******, кликаем 'Login', проверяем видимость иконки ЛК")
    public static void login (User user) {
        emailInput.setValue(user.getEmail()).pressEnter();
        passwordInput.setValue(user.getPassword());
        loginBtn.click();
        statistic.should(Condition.visible);
            }
}
