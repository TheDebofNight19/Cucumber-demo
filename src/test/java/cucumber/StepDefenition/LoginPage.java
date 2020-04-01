package cucumber.StepDefenition;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.ru.Допустим;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    private SelenideElement loginField = $(byName("username"));
    private SelenideElement passwordField = $(byName("password"));
    private SelenideElement enterButton = $(byId("login-button"));



    @Допустим("Пользователь вводит логин {string} и пароль {string}")
    public void inputUserLoginAndUserPassword(String string1, String string2) {
        loginField.clear();
        loginField.setValue(string1);
        passwordField.clear();
        passwordField.setValue(string2);
        enterButton.click();
    }

}
