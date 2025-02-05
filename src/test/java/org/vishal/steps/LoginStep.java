package org.vishal.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.vishal.pages.LoginPage;
import org.vishal.selenium.Driver;

public class LoginStep {

    private Driver driver;

    @Autowired
    public LoginStep(Driver driver){
        this.driver = driver;
    }

    @Autowired
    private LoginPage loginPage;


    @Given("the user is on the login page")
    public void navigateUserToLoginPage(){
        String url = driver.getDriver().getCurrentUrl();
        assertEquals(url, "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("the users logins with {string} userName and {string} password")
    public void loginUser(String userName, String password){
        loginPage.login(userName, password);
    }

    @Then("the user must be logged in")
    public void isUserLoggedIn(){
        loginPage.isUserLoggedIn();
    }

    @Then("a toast message must be shown for invalid credentials")
    public void isUserBlocked(){
        loginPage.isUserBlocked();
    }

}
