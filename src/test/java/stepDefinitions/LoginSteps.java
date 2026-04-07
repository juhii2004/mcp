package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverFactory;
import utils.ExcelReader;

import java.util.List;

import static hooks.Hooks.test;

public class LoginSteps {

    WebDriver driver;

    // 🔹 Open Browser
    @Given("user opens the browser")
    public void openBrowser() {
        driver = DriverFactory.getDriver();
    }

    // 🔹 Navigate to URL
    @When("user navigates to {string}")
    public void navigateTo(String url) {
        driver.get(url);
        test.info("Navigated to: " + url);
    }

    // 🔹 Validate Title
    @Then("page title should contain {string}")
    public void validateTitle(String expected) {

        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expected)) {
            test.pass("Title matched: " + actualTitle);
        } else {
            test.fail("Title mismatch. Actual: " + actualTitle);
        }
    }

    // 🔥 EXCEL TEST (8 PASS + 2 FAIL)
    @Given("user runs tests from excel file")
    public void runExcelTests() {

        driver = DriverFactory.getDriver(); // 🔥 IMPORTANT FIX

        String path = "src/test/resources/testdata/testdata.xlsx";

        List<String[]> data = ExcelReader.getData(path, "Sheet1");

        int pass = 0;
        int fail = 0;

        System.out.println("Excel test started");

        for (String[] row : data) {

            if (row.length < 2) continue; // safety check

            String url = row[0];
            String expectedTitle = row[1];

            driver.get(url);

            String actualTitle = driver.getTitle();

            test.info("Opening URL: " + url);

            if (actualTitle.contains(expectedTitle)) {
                test.pass("PASS: " + url);
                pass++;
            } else {
                test.fail("FAIL: " + url + " | Actual: " + actualTitle);
                fail++;
            }
        }

        test.info("Total Passed: " + pass);
        test.info("Total Failed: " + fail);

        System.out.println("Total Passed: " + pass);
        System.out.println("Total Failed: " + fail);
    }
}