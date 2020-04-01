package cucumber.StepDefenition;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Допустим;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class BSPBloginTest {

    private final static String URL = "https://idemo.bspb.ru";
    private final String OTP_PAGE_URL = "https://idemo.bspb.ru/auth/otp?authOptionId=SMS%3A10005";

    @Допустим("Пользователь заходит на сайт bspb.ru")
    public void goToTargetPage() {

        Selenide.open(URL);
    }

    @Допустим("Пользователь вводит логин {string} и пароль {string}")
    public void inputUserLoginAndUserPassword(String string1, String string2) {
        $(byName("username")).clear();
        $(byName("username")).setValue(string1);
        $(byName("password")).clear();
        $(byName("password")).setValue(string2);
        $(byId("login-button")).click();
    }

    @Допустим("Пользователь попадает на страницу ввода одноразового пароля")
    public void assertUserIsOnOneTimePasswordPage() {

        String currentUrl = com.codeborne.selenide.WebDriverRunner.url();
        Assert.assertEquals(currentUrl, OTP_PAGE_URL);
    }

    @Допустим("Пользователь вводит одноразовый пароль {string}")
    public void inputOneTimePassword(String string) {

        $(byId("otp-code")).clear();
        $(byId("otp-code")).setValue(string);
        $(byId("login-otp-button")).click();
    }

    @Допустим("Пользователь попадает в личный кабинет")
    public void assertUSerIsInPersonalCabinet() {

        $(byXpath("//title[contains(text(), \"Интернет банк\")]")).isDisplayed();

    }

    @Допустим("Пользователь нажимает кнопку {string}")
    public void pressOverviewButton(String string) {
        $(byText(string)).click();
    }

    @Допустим("Пользователь видит надпись {string}")
    public void checkIfSignIsPresent(String string) {
        $(byXpath("//div[@id = \"header-container\"]//span[@class = \"text\"]")).shouldHave(text(string));
    }

    @Допустим("Пользователь видит сумму в формате 1 234 567.89 Р")
    public void checkAmountFormat() {
        Pattern pat = Pattern.compile("[1-9]\\s[0-9]{3}\\s[0-9]{3}\\.[0-9]{2}\\s₽");
        Matcher mat = pat.matcher($(byXpath("//div[@id=\"header-container\"]//span[@class=\"amount\"]")).getText());
        Assert.assertTrue(mat.matches());
    }

    @Допустим("Пользователь наводит курсором на сумму")
    public void hoverOverAmount() {
        $(byXpath("//div[@id=\"header-container\"]//span[@class=\"amount\"]")).hover();
    }

    @Допустим("Пользователь видит надпись Моих средств и сумму в формате 1 234 567.89 Р")
    public void checkMyBalanceFormat() {
        String s = $(byXpath("//div[@id=\"header-container\"]//small[@class=\"my-assets\"]")).getText();
        Pattern pat = Pattern.compile("Моих\\sсредств\\s[1-9]\\s[0-9]{3}\\s[0-9]{3}\\.[0-9]{2}\\s₽");
        Matcher mat = pat.matcher(s);
        Assert.assertTrue(mat.matches());
    }


}
