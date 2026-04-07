package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    WebElement username;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "login")
    WebElement loginBtn;

    public void login(String user, String pass) {
        username.clear();
        password.clear();
        username.sendKeys(user);
        password.sendKeys(pass);
        loginBtn.click();
    }
}