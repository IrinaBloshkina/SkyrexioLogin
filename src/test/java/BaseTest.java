import com.codeborne.selenide.Configuration;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import utils.PropertyReader;
import utils.TestListener;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.WebDriverRunner.clearBrowserCache;

@Listeners({AllureTestNg.class, TestListener.class})
    @Epic("Модуль логина Skyrexio")
    @Feature("Авторизация")

public class BaseTest {
    @BeforeMethod
    @Step("Выполняем предварительную подготовку к загрузке")
    @Parameters({"browser"})
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout =10000;
        Configuration.headless = false;
        Configuration.baseUrl = PropertyReader.getProperty("skyrexio.url");
    }

    @Step("Закрытие браузера")
    @AfterMethod
    public void close() {
       closeWebDriver();
        clearBrowserCache();
    }
}
