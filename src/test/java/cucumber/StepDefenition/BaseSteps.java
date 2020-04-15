package cucumber.StepDefenition;

import Pages.sberbank.BasePage;
import Pages.sberbank.DepositControl;
import Pages.sberbank.DepositsPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.Before;
import io.cucumber.java.ru.Допустим;
import io.cucumber.java.ru.Если;
import io.cucumber.java.ru.Ктомуже;
import io.cucumber.java.ru.То;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;


public class BaseSteps {

    BasePage basePage = new BasePage();
    DepositsPage depositsPage = new DepositsPage();
    DepositControl depositControl = new DepositControl();



    private static final Logger LOG = LoggerFactory.getLogger(BaseSteps.class);



    @Допустим("Пользователь переходит по ссылке {string}")
    @Step
    public void openPage(String string) {
        Selenide.open(string);
    }


    @Если("Пользователь попадает на страницу sberbank.ru")
    @Step
    public void assertUserIsOnTargetPage() {
        Assert.assertTrue(basePage.getBasePageLogo().isDisplayed());
    }


    @То("Отображается название страницы {string}")
    @Step
    public void assertCorrectTitle(String string) {
        Assert.assertEquals(string, Selenide.title());
    }


    @Допустим("Пользователь переходит через верхнее меню во \"Вклады\"")
    @Step
    public void hoverOverDepositOption() {
        basePage.getDepositTab().hover();
        basePage.getDepositTabSubLink().click();
    }


    @Если("Осущестляется переход")
    @Step
    public void getDepositPage() {
        depositsPage.getDepositPageText().isDisplayed();
    }


    @То("Название страницы {string}")
    @Step
    public void assertUserIsOnDepositPage(String string) {
        Assert.assertEquals(string, Selenide.title());
    }


    @Допустим("Пользователь находится на странице {string}")
    @Step
    public void checkIfUserIsOnDepositPage(String string) {
        Assert.assertEquals(string, Selenide.title());
    }


    @Если("Пользователь перешел на вкладку {string}")
    @Step
    public void getChooseDepositTab(String string) {
        depositsPage.getChooseDeposit().click();

    }

    @То("Отображаются 4 чек-бокса и установлен чек-бокс «Онлайн»")
    @Step
    public void assertCheckboxesAreAvailable(List<String> dataTable) {

        depositsPage.scanCheckboxes(dataTable);
    }


    @Ктомуже("Отображается 3 вклада")
    @Step
    public void assertDepositOptionsAreAvailable(List<String> dataTable) {
        for (String text : dataTable) {
            Assert.assertTrue($(byText(text)).isDisplayed());
        }
    }


    @Допустим("Пользователь выбирает чек-боксы")
    @Step
    public void markDepositTypeCheckBoxes(List<String> dataTable) {
        for (String text : dataTable) {
            $(byText(text)).click();
        }

    }


    @Если("Исчезли вклады")
    @Step
    public void checkIfDepositTypesAreNotAvailable(List<String> dataTable) {

        for (String text : dataTable) {
            $(byText(text)).shouldNotBe(Condition.visible);
            LOG.info("Элемент " + text + " не найден");
        }
    }

    @То("Остался только {string}")
    @Step
    public void checkWhichOptionIsAvailable(String string) {
        $(byText(string))
                .shouldBe(Condition.visible);
        LOG.info("Остался только " + string);
    }


    @Допустим("Пользователь нажимет на кнопку {string} вклада «Управляй»")
    @Step
    public void userPressesControlButton(String string) {
        depositsPage.getDepositElement()
                .find(byText(string))
                .click();
    }


    @Если("В новом окне открывается окно с названием {string}")
    @Step
    public void checkIfUSerIsOnControlPage(String string) {
        Selenide.switchTo().window("«Сбербанк» - Вклад Управляй");
        Assert.assertEquals(string, Selenide.title());
        LOG.info("Осуществлен переход на страницу Вклада \"Вклад «Управляй»\"");
    }


    @То("На странице отображается надпись «Вклад Управляй»")
    @Step
    public void checkIfUserIsOnCorrectPage(){
       depositControl.assertPage();
    }
}
