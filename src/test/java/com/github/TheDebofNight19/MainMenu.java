package com.github.TheDebofNight19;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainMenu {

    private static final String TEXT_ONE = "Финансовая свобода";


    private SelenideElement overview = $(By.xpath("//a[@id=\"bank-overview\"]"));
    private SelenideElement amount = $(By.xpath("//div[@id=\"header-container\"]//span[@class=\"amount\"]"));
    private SelenideElement text = $(By.xpath("//div[@id = \"header-container\"]//span[@class = \"text\"]"));
    private SelenideElement myBalance = $(By.xpath("//div[@id=\"header-container\"]//small[@class=\"my-assets\"]"));

    public void interactWithMainMenu(){
        overview.click();
    }

    public void compareText() {
       text.shouldHave(text(TEXT_ONE));
        Pattern pat = Pattern.compile("[1-9]\\s[0-9]{3}\\s[0-9]{3}\\.[0-9]{2}\\s₽");
        Matcher mat = pat.matcher(amount.getText());
        Assert.assertTrue(mat.matches());
    }

    public void checkMyBalanceElement(){
        amount.contextClick();
        String s = myBalance.getText();
        Pattern pat = Pattern.compile("Моих\\sсредств\\s[1-9]\\s[0-9]{3}\\s[0-9]{3}\\.[0-9]{2}\\s₽");
        Matcher mat = pat.matcher(s);
        Assert.assertTrue(mat.matches());

    }




}
