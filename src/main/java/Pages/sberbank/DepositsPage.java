package Pages.sberbank;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DepositsPage extends BasePage {

    private SelenideElement depositPageText = $(byXpath("//h2[@class = 't-h2' and text()='Вклады']"));
    private SelenideElement chooseDeposit = $(byXpath("//a[text()='Подобрать вклад']"));
    private SelenideElement iFrame = $(byXpath("//iframe[@sandbox]"));
    private SelenideElement label = $(byXpath("//div[@id='depositSelection']//label"));
    private SelenideElement checkBox = $(byXpath("//div[@id='depositSelection']//input[@type='checkbox']"));
    private SelenideElement depositElement = $(byXpath("//div[@id='depositSelection']"));
    private SelenideElement depositType = $(byXpath("//h3[@class='offered-products__header']"));

    private static final Logger LOG = LoggerFactory.getLogger(DepositsPage.class);

    public void scanCheckboxes(List<String> dataTable) {

        Selenide.switchTo().frame(iFrame);
        for (String text : dataTable) {
            Assert.assertTrue($(byText(text)).isDisplayed());
            LOG.info("Отображается чекбокс " + text);
            if (text == "Онлайн") {
                Assert.assertTrue(depositElement
                        .find(byText(text))
                        .find(byXpath("//div[@id='depositSelection']//input[@type='checkbox']"))
                        .shouldHave(Condition.attribute("aria-checked", "true"))
                        .isDisplayed());
            }
        }
    }

    public SelenideElement getDepositElement() {
        return depositElement;
    }

    public SelenideElement getDepositType() {
        return depositType;
    }


    public SelenideElement getLabel() {
        return label;
    }

    public SelenideElement getCheckBox() {
        return checkBox;
    }

    public SelenideElement getiFrame() {
        return iFrame;
    }

    public SelenideElement getDepositPageText() {
        return depositPageText;
    }

    public SelenideElement getChooseDeposit() {
        return chooseDeposit;
    }


}
