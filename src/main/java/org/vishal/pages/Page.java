package org.vishal.pages;

import org.openqa.selenium.support.PageFactory;
import org.vishal.selenium.Driver;

public class Page {
    protected Driver driver;

    public Page(Driver driver){
        this.driver = driver;
        PageFactory.initElements(driver.getDriver(), this);
    }
}
