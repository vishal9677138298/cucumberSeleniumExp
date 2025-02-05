package org.vishal.pages;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.vishal.selenium.Driver;
import org.vishal.selenium.ExplicitWaitHelper;
import java.util.List;

@Component
@Lazy
@ScenarioScope
public class LoginPage extends Page {

    @FindBy(xpath = "//input[@name='username']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//*[text()='Invalid credentials']")
    private WebElement invalidCredsToast;

    @FindBy(xpath = "//ul[@class='oxd-main-menu']//li")
    private List<WebElement> dashboardMenus;

    @Autowired
    public LoginPage(Driver driver) {
        super(driver);
    }

    public void login(String userName, String password){
        ExplicitWaitHelper exp = new ExplicitWaitHelper(driver, 10);
        exp.waitTillPageIsLoaded();
        exp.waitTillVisibility(userNameField, passwordField, loginButton);
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void isUserLoggedIn(){
        ExplicitWaitHelper exp = new ExplicitWaitHelper(driver, 10);
        exp.waitTillVisibility(dashboardHeader);
    }

    public void isUserBlocked(){
        ExplicitWaitHelper exp = new ExplicitWaitHelper(driver, 10);
        exp.waitTillVisibility(invalidCredsToast);
    }

    public void areAllMenuItemsPresent(List<String> menuItems){
        ExplicitWaitHelper exp = new ExplicitWaitHelper(driver, 5);
        exp.waitTillVisibility(dashboardMenus);
        dashboardMenus.stream().map(Object::toString).forEach(System.out::println);
    }
}
