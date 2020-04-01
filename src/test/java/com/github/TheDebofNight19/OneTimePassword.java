package com.github.TheDebofNight19;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class OneTimePassword {

    private final String OTP = "0000";
    private final String URL = "https://idemo.bspb.ru/auth/otp?authOptionId=SMS%3A10005";

    private SelenideElement oneTimePasswordField = $(By.id("otp-code"));
    private SelenideElement enterButton = $(By.id("login-otp-button"));

    public void assertOneTimePasswordPageUrl(){
        String currentUrl = com.codeborne.selenide.WebDriverRunner.url();
        Assert.assertEquals(currentUrl, URL);
    }


    public void insertOneTimePassword(){
        oneTimePasswordField.clear();
        oneTimePasswordField.setValue(OTP);
        enterButton.click();
    }

}
