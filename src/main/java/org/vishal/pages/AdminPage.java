package org.vishal.pages;

import io.cucumber.spring.ScenarioScope;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.vishal.selenium.Driver;
import org.vishal.selenium.ExplicitWaitHelper;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Lazy
@ScenarioScope
public class AdminPage extends Page {

    @FindBy(xpath = "//span[text()='Admin']")
    private WebElement adminMenu;

    @FindBy(xpath = "//*[contains(text(), 'User Role')]//following::div[1]//*[contains(text(), 'Select')]")
    private WebElement selectUserRoleDropdown;

    @FindBy(xpath = "//button[text()=' Search ']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@role='table']//*[@class='oxd-table-body']//*[@role='row']//*[@role='cell'][3]")
    private List<WebElement> userRoles;

    private ExplicitWaitHelper expWait;

    private String userRoleDropdownOption = "//*[@role='option']//span[text()='%s']";


    @Autowired
    public AdminPage(Driver driver) {
        super(driver);
        this.expWait = new ExplicitWaitHelper(driver, 5);
    }

    public void navigateTo(){
        expWait.waitTillVisibility(adminMenu);
        adminMenu.click();
    }

    public void filterUserBasedOnRole(String role){
        expWait.waitTillVisibility(selectUserRoleDropdown, searchButton);
        selectUserRoleDropdown.click();
        By locator = By.xpath(String.format(userRoleDropdownOption, role));
        expWait.waitTillVisibility(locator);
        driver.getDriver().findElement(locator).click();
        searchButton.click();
    }

    public List<String> getFilteredUserRoles(){
        expWait.waitTillVisibility(userRoles);
        return userRoles.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
