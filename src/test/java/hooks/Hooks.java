package hooks;

import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.DriverFactory;
import utils.ExtentManager;
import com.aventstack.extentreports.*;

public class Hooks {

    public static ExtentReports extent = ExtentManager.getInstance();
    public static ExtentTest test;

    @Before
    public void setup(Scenario scenario) {
        test = extent.createTest(scenario.getName());
        DriverFactory.initDriver();
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
        extent.flush();
    }
}