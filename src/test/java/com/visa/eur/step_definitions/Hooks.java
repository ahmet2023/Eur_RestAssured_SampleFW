package com.visa.eur.step_definitions;

import com.visa.eur.utilities.ConfigurationReader;
import com.visa.eur.utilities.DB_Util;
import cucumber.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class Hooks {

//    @Before("@db")
//    public void dbHook() {
//        System.out.println("creating database connection");
//        DBUtils.createConnection();
//    }
//
//    @After("@db")
//    public void afterDbHook() {
//        System.out.println("closing database connection");
//        DBUtils.destroyConnection();
    //        DB_Util.destroy();
//    }
//
//    @Before("@ui")
//    public void setUp() {
//        // we put a logic that should apply to every scenario
//        System.out.println("Setting up webdriver");
//        Driver.getDriver();
    //or
  //          System.out.println("this is coming from BEFORE");
//        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        Driver.getDriver().manage().window().maximize();
//        Driver.getDriver().get(ConfigurationReader.getProperty("library_url"));

//
//    }
//
//    @After("@ui")
//    public void tearDown(Scenario scenario) {
//        // only takes a screenshot if the scenario fails
//        if (scenario.isFailed()) {
//            // taking a screenshot
//            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.embed(screenshot, "image/png");
//        }
//        //Driver.closeDriver();
//    }
}
