package com.github.TheDebofNight19;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    private final static String URL = "https://idemo.bspb.ru";
    private final static String LOGIN = "demo";
    private final static String PASSWORD = "demo";

    private SelenideElement loginField = $(By.name("username"));
    private SelenideElement passwordField = $(By.name("password"));
    private SelenideElement enterButton = $(By.id("login-button"));


    public void login(){

        Selenide.open(URL);
        loginField.clear();
        passwordField.clear();
        loginField.setValue(LOGIN);
        passwordField.setValue(PASSWORD);
        enterButton.click();
    }

}
