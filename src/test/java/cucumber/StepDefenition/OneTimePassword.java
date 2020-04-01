package cucumber.StepDefenition;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Допустим;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class OneTimePassword {

    private final String OTP_PAGE_URL = "https://idemo.bspb.ru/auth/otp?authOptionId=SMS%3A10005";

    private SelenideElement oneTimePasswordField = $(By.id("otp-code"));
    private SelenideElement enterButton = $(By.id("login-otp-button"));

    @Допустим("Пользователь попадает на страницу ввода одноразового пароля")
    public void assertUserIsOnOneTimePasswordPage() {

        String currentUrl = com.codeborne.selenide.WebDriverRunner.url();
        Assert.assertEquals(currentUrl, OTP_PAGE_URL);
    }

    @Допустим("Пользователь вводит одноразовый пароль {string}")
    public void inputOneTimePassword(String string) {

        oneTimePasswordField.clear();
        oneTimePasswordField.setValue(string);
        enterButton.click();
    }

}
