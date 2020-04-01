package cucumber.StepDefenition;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Допустим;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBSPB {

    private WebDriver webDriver;
    private final static String URL = "https://idemo.bspb.ru";


    @BeforeSuite
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }


    @Допустим("Пользователь заходит на сайт bspb.ru")
    public void goToTargetPage() {

        Selenide.open(URL);
    }
    @AfterSuite
    public void closeDriver(){
        webDriver.quit();
    }
}
