package cucumber.StepDefenition;

import DataStorage.DataStorage;
import Pages.autoRu.AutoRuPage;
import Pages.autoRu.ManufacturerPage;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Допустим;
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
     * Этот шаг можно прописать как "предысторию" в 1.feature, но тогда падет тест - не отвечает
     * веб-драйвер браузера
     */

    @Допустим("Пользователь заходит на сайт auto.ru")
    public void openAutoRuUrl(){
        Selenide.open("https://auto.ru/");
    }

    @Допустим("Проверяем, что название страницы содержит текст {string}")
    public void getPageTitle(String title) {
        DataStorage.closePopUp();
        Assert.assertTrue(Selenide.title().contains(title));
    }


    @Допустим("^Сохраняем количество объявлений по (.+)$")
    public void getCarManufacturer(String manufacturer) {
        DataStorage.closePopUp();
        dataStorage.setManufacturerQuantity($(byText(manufacturer)).find(By.xpath("./following::div")).text());
        LOG.info(manufacturer + " : " + dataStorage.getManufacturerQuantity());

    }


    @Допустим("^Пользователь переходит на страницу производителя (.+)$")
    public void switchToManufacturerPage(String manufacturer) {
        DataStorage.closePopUp();
        $(byText(manufacturer)).click();
    }


    @Допустим("^Осуществлен переход на страницу (.+)$")
    public void checkIfUSerIsOnManufacturerPage(String manufacturer) {
        DataStorage.closePopUp();
        Assert.assertTrue(Selenide.title().contains(manufacturer));
        LOG.info(Selenide.title());
    }

    @Допустим("Отображается кнопка с текстом, содержащим количество объявлений по производителю автомобилей")
    public void findButtonWithQuantity() {

        /**
         * в данном шаге содерожится достаточно искуственная проверка, так как количество объявлений на
         * кнопке отображатеся динамически и может измениться в момент перехода с одной страницы на другую
         * некорректный кейс :)
         */
        DataStorage.closePopUp();
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
    public void saveSeriesQuantity (String series) {
        DataStorage.closePopUp();
        dataStorage.setSeriesQuantity($(byText(series))
                .find(By.xpath("./following::div"))
                .text());
        LOG.info(series + " : " + dataStorage.getSeriesQuantity());
    }


    @Допустим("Значение сохранено")
    public void outputSavedSeriesQuantity() {
        DataStorage.closePopUp();
        LOG.info(dataStorage.getSeriesQuantity());
    }

    @Допустим("^Пользователь переходит на страницу объявлений по (.+)$")
    public void goToOffersBySeriesPage(String offersPage) {
        DataStorage.closePopUp();
        LOG.info($(byText(offersPage)).text());
        $(byText(offersPage)).hover().click();
    }

    @Допустим("^Проверяем, что мы на странице (.+)$")
    public void assertUserIsOnOffersBySeriesPage(String offersBySeries){
        DataStorage.closePopUp();
        Assert.assertTrue($(byXpath("//div[@class='ListingHead__title']"))
                .text().contains(offersBySeries));
    }


    @Допустим("Отображается кнопка с количеством объявлений")
    public void checkIfButtonWithOffersIsAvailable() {
        DataStorage.closePopUp();
        Assert.assertTrue($(byXpath("//span[@class='ButtonWithLoader__content']")).isDisplayed());

        String s = AutoRuPage.getButtonText();
        dataStorage.setSeriesQuantity(DataStorage.getQuantity(s));
        LOG.info(dataStorage.getSeriesQuantity());
    }


}
