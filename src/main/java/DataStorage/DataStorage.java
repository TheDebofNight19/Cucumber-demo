package DataStorage;

import com.codeborne.selenide.Selenide;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class DataStorage {

    private String manufacturerQuantity;
    private String manufacturerQuantityRefreshed;
    private String seriesQuantity;
    private String manufacturer;

    /**
     * Метод, который парсит текст с кнопки "Показать <n> предложений" и "достает"
     * оттуда число
     */
    public static String getQuantity(String string){
        String offers = null;
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(string);
        while (m.find()) {
            offers = m.group();
        }
        return offers;
    }


    public String getManufacturerQuantityRefreshed() {
        return manufacturerQuantityRefreshed;
    }

    public void setManufacturerQuantityRefreshed(String manufacturerQuantityRefreshed) {
        this.manufacturerQuantityRefreshed = manufacturerQuantityRefreshed;
    }


    public String getSeriesQuantity() {
        return seriesQuantity;
    }

    public void setSeriesQuantity(String seriesQuantity) {
        this.seriesQuantity = seriesQuantity;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturerQuantity() {
        return manufacturerQuantity;
    }

    public void setManufacturerQuantity(String manufacturerQuantity) {
        this.manufacturerQuantity = manufacturerQuantity;
    }
}
