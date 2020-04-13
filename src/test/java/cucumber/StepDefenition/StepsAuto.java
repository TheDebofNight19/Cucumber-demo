package cucumber.StepDefenition;

import DataStorage.DataStorage;
import Pages.autoRu.AutoRuPage;
import Pages.autoRu.ManufacturerPage;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Допустим;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;


public class StepsAuto {


    DataStorage dataStorage = new DataStorage();
    ManufacturerPage manufacturerPage = new ManufacturerPage();

    private static final Logger LOG = LoggerFactory.getLogger(StepsAuto.class);

    /**
     * Этот шаг можно прописать как "предысторию" в bspb.feature, но тогда падет тест - не отвечает
     * веб-драйвер браузера
     */

    @Допустим("Пользователь заходит на сайт auto.ru")
    @Step
    public void openAutoRuUrl(){
        Selenide.open("https://auto.ru/");
    }

    @Допустим("Проверяем, что название страницы содержит текст {string}")
    @Step
    public void getPageTitle(String title) {
        BackgroundSteps.closePopUp();
        Assert.assertTrue(Selenide.title().contains(title));
    }


    @Допустим("^Сохраняем количество объявлений по (.+)$")
    @Step
    public void getCarManufacturer(String manufacturer) {
        BackgroundSteps.closePopUp();
        dataStorage.setManufacturerQuantity($(byText(manufacturer)).find(By.xpath("./following::div")).text());
        LOG.info(manufacturer + " : " + dataStorage.getManufacturerQuantity());

    }


    @Допустим("^Пользователь переходит на страницу производителя (.+)$")
    @Step
    public void switchToManufacturerPage(String manufacturer) {
        BackgroundSteps.closePopUp();
        $(byText(manufacturer)).click();
    }


    @Допустим("^Осуществлен переход на страницу (.+)$")
    @Step
    public void checkIfUSerIsOnManufacturerPage(String manufacturer) {
        BackgroundSteps.closePopUp();
        Assert.assertTrue(Selenide.title().contains(manufacturer));
        LOG.info(Selenide.title());
    }

    @Допустим("Отображается кнопка с текстом, " +
            "содержащим количество объявлений по производителю автомобилей")
    @Step
    public void findButtonWithQuantity() {

        /**
         * в данном шаге содерожится достаточно искуственная проверка, так как количество объявлений на
         * кнопке отображатеся динамически и может измениться в момент перехода с одной страницы на другую
         * некорректный кейс :)
         */
        BackgroundSteps.closePopUp();
        LOG.info(dataStorage.getManufacturerQuantity());
        String s = AutoRuPage.getButtonText();
        dataStorage.setManufacturerQuantityRefreshed(DataStorage.getQuantity(s));
        LOG.info(dataStorage.getManufacturerQuantityRefreshed());
        Assert.assertTrue(manufacturerPage.compareNumbers(
                dataStorage.getManufacturerQuantity(),
                dataStorage.getManufacturerQuantityRefreshed()
        ));
    }


    @Допустим("^Пользователь сохраняет количество объявлений (.+)$")
    @Step
    public void saveSeriesQuantity (String series) {
        BackgroundSteps.closePopUp();
        dataStorage.setSeriesQuantity($(byText(series))
                .find(By.xpath("./following::div"))
                .text());
        LOG.info(series + " : " + dataStorage.getSeriesQuantity());
    }


    @Допустим("Значение сохранено")
    @Step
    public void outputSavedSeriesQuantity() {
        BackgroundSteps.closePopUp();
        LOG.info(dataStorage.getSeriesQuantity());
    }

    @Допустим("^Пользователь переходит на страницу объявлений по (.+)$")
    @Step
    public void goToOffersBySeriesPage(String offersPage) {
        BackgroundSteps.closePopUp();
        LOG.info($(byText(offersPage)).text());
        $(byText(offersPage)).hover().click();
    }

    @Допустим("^Проверяем, что мы на странице (.+)$")
    @Step
    public void assertUserIsOnOffersBySeriesPage(String offersBySeries){
        BackgroundSteps.closePopUp();
        Assert.assertTrue($(byXpath("//div[@class='ListingHead__title']"))
                .text().contains(offersBySeries));
    }


    @Допустим("Отображается кнопка с количеством объявлений")
    @Step
    public void checkIfButtonWithOffersIsAvailable() {
        BackgroundSteps.closePopUp();
        Assert.assertTrue($(byXpath("//span[@class='ButtonWithLoader__content']")).isDisplayed());

        String s = AutoRuPage.getButtonText();
        dataStorage.setSeriesQuantity(DataStorage.getQuantity(s));
        LOG.info(dataStorage.getSeriesQuantity());
    }


}
