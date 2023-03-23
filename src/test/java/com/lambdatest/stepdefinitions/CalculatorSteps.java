package com.lambdatest.stepdefinitions;

import java.net.URL;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CalculatorSteps {
    private WindowsDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
       capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
    }

    @Given("I have opened Windows Calculator app")
    public void openCalculator() {
        driver.findElementByName("Standard Calculator").click();
    }

    @When("I enter {string} and {string} and {string} and {string}")
    public void performOperation(String num1, String operator, String num2, String equals) {
        driver.findElementByName(num1).click();
        driver.findElementByName(operator).click();
        driver.findElementByName(num2).click();
        driver.findElementByName(equals).click();
    }

    @Then("the result should be {string} on the calculator screen")
    public void verifyResult(String expected) {
        String actual = driver.findElementByName("CalculatorResults").getText().replace("Display is ", "");
        assert(actual.equals(expected));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
