package cucumber.StepDefenition;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class OneTimePassword {

    private final String OTP_PAGE_URL = "https://idemo.bspb.ru/auth/otp?authOptionId=SMS%3A10005";

    private SelenideElement oneTimePasswordField = $(By.id("otp-code"));
    private SelenideElement enterButton = $(By.id("login-otp-button"));

    @Когда("Пользователь вводит одноразовый пароль {string}")
    public void inputOneTimePassword(String string) {

        oneTimePasswordField.clear();
        oneTimePasswordField.setValue(string);
        enterButton.click();
    }

    @Тогда("Пользователь попадает в личный кабинет")
    public void assertUSerIsInPersonalCabinet() {

        $(byXpath("//title[contains(text(), \"Интернет банк\")]")).isDisplayed();

    }

}
