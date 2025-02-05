package org.vishal.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.vishal.pages.AdminPage;
import org.vishal.selenium.Driver;
import static org.junit.Assert.*;
import java.util.List;
import java.util.Map;

public class AdminSteps {
    private Driver driver;

    @Autowired
    private AdminPage adminPage;

    @Autowired
    public AdminSteps(Driver driver){
        this.driver = driver;
    }
    @Given("I'm in admin module")
    public void navigateToAdminModule(){
        adminPage.navigateTo();
    }

    @When("I select a filter users based on a {string}")
    public void applyFilter(String userRole){
        adminPage.filterUserBasedOnRole(userRole);
    }

    @Then("the users should be filtered based on the selected {string}")
    public void checkFilteredUsers(String expectedUserRole){
        List<String> filteredUserRoles = adminPage.getFilteredUserRoles();
        filteredUserRoles.forEach(userRole -> {
            assertEquals(userRole.toLowerCase(), expectedUserRole.toLowerCase());
        });
    }

    @Given("the below data table")
    public void testData(DataTable table){
        List<Map<String, String>> fullTable = table.asMaps(String.class, String.class);

        fullTable.forEach(row -> {
            row.forEach((key, value) -> {
                System.out.println(" key "+key);
                System.out.println(" value "+value);
            });
        });
    }
}
