package com.github.TheDebofNight19;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestBSPB {

    private WebDriver webDriver;



    @BeforeTest
    public void initDriver() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }


    @Test
    public void testLogin(){

        LoginPage loginPage = new LoginPage();
        OneTimePassword oneTimePassword = new OneTimePassword();
        MainMenu mainMenu = new MainMenu();
        loginPage.login();
        oneTimePassword.assertOneTimePasswordPageUrl();
        oneTimePassword.insertOneTimePassword();
        mainMenu.interactWithMainMenu();
        mainMenu.compareText();
        mainMenu.checkMyBalanceElement();
    }

    @AfterClass
    public void closeDriver(){
        webDriver.quit();
    }
}
