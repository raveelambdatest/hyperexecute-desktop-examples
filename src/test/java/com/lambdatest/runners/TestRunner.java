package com.lambdatest.runners;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import java.awt.*;
import java.io.*;

@CucumberOptions(
        features = {"src/test/java/com/lambdatest/features"},
        glue = {"com.lambdatest.stepdefinitions"},
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class TestRunner extends AbstractTestNGCucumberTests {

    private String cmd = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";


    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeClass
    public void beforeClass() {
        try {
            Runtime.getRuntime().exec(cmd);
        }
        catch (Exception err) {
            err.printStackTrace();
        }
    }

    @AfterClass
    public void afterClass() {
    }


}

