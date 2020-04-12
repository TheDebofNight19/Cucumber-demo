package Pages.sberbank;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DepositControl extends BasePage {


    private SelenideElement mainFrame = $(byXpath("//div[@class='kit-col_xs_12 kit-col_md_0 kit-col_lg_6 " +
            "kit-col_xs-bottom_20 kit-col_lg-bottom_10 kit-col_xs-top_20 kit-col_lg-top_40']"));

    public void assertPage(){
        Assert.assertTrue($(mainFrame). find(byXpath("h2[text()='Вклад Управляй']"))
                .shouldBe(Condition.visible)
                .isDisplayed());
    }

    public SelenideElement getMainFrame() {
        return mainFrame;
    }

}

