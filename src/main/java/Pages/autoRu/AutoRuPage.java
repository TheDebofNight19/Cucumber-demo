package Pages.autoRu;


import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AutoRuPage {

//    DataStorage dataStorage = new DataStorage();
//
//    String offersNumber = "./following::div";

    public static String getButtonText(){
        String s = $(byXpath("//span[@class='ButtonWithLoader__content']"))
                .text()
                .replaceAll(" ", "");
        return s;
    }
//
//    public void findOffers(String text){
//        dataStorage.setManufacturerQuantity($(byText(text))
//                .find(byXpath(offersNumber)).text());
//    }

}
