package cucumber.StepDefenition;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.*;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainMenu {


    private SelenideElement amount = $(byXpath("//div[@id=\"header-container\"]//span[@class=\"amount\"]"));
    private SelenideElement text = $(byXpath("//div[@id = \"header-container\"]//span[@class = \"text\"]"));
    private SelenideElement myBalance = $(byXpath("//div[@id=\"header-container\"]//small[@class=\"my-assets\"]"));

    @Когда("Пользователь нажимает кнопку {string}")
    public void pressOverviewButton(String string) {
        $(byText(string)).click();
    }

    @И("Пользователь видит надпись {string}")
    public void checkIfSignIsPresent(String string) {
        text.shouldHave(text(string));
    }

    @Тогда("Пользователь видит сумму в формате 1 234 567.89 Р")
    public void checkAmountFormat() {
        Pattern pat = Pattern.compile("[1-9]\\s[0-9]{3}\\s[0-9]{3}\\.[0-9]{2}\\s₽");
        Matcher mat = pat.matcher(amount.getText());
        Assert.assertTrue(mat.matches());
    }

    @Ктомуже("Пользователь наводит курсором на сумму")
    public void hoverOverAmount() {
        amount.hover();
    }

    @Ктомуже("Пользователь видит надпись Моих средств и сумму в формате 1 234 567.89 Р")
    public void checkMyBalanceFormat() {
        String s = myBalance.getText();
        Pattern pat = Pattern.compile("Моих\\sсредств\\s[1-9]\\s[0-9]{3}\\s[0-9]{3}\\.[0-9]{2}\\s₽");
        Matcher mat = pat.matcher(s);
        Assert.assertTrue(mat.matches());
    }




}
