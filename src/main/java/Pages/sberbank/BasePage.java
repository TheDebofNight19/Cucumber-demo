package Pages.sberbank;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    private SelenideElement basePageLogo = $(byXpath("//img[@class = 'header__logo-image']"));
    private SelenideElement depositTab = $(byXpath("//button/span[contains(text(), 'Вклады')]"));
    private SelenideElement depositTabSubLink =
            $(byXpath("//a[@class='lg-menu__sub-link' and text()=\"Вклады\"]"));


    public SelenideElement getBasePageLogo() {
        return basePageLogo;
    }

    public SelenideElement getDepositTab() {
        return depositTab;
    }

    public SelenideElement getDepositTabSubLink() {
        return depositTabSubLink;
    }


}
