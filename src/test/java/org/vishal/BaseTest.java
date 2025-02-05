package org.vishal;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.vishal.selenium.Driver;

public class BaseTest {

    @Autowired
    protected Driver driver;

    @Before
    public void initiateDriver(){
        driver.createNewSession();
        driver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @After
    public void tearDown(){
        driver.endBrowserSession();
    }
}
