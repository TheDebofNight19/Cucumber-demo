package cucumber.StepDefenition;


import com.codeborne.selenide.Selenide;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class BackgroundSteps {

    /**
     * метод, котрый закрывает всплывающие окна
     */
    public static void closePopUp(){
        if($(byXpath("//body[@class='react-page body_controller_index']")).isDisplayed()){
            $(byXpath("//span[text()='Понятно, спасибо']")).click();
            Selenide.switchTo().parentFrame();
        }
    }
}
