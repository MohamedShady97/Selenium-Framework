package com.qacart.todo.base;

import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.CookiesUtils;
import io.qameta.allure.Allure;
import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BaseTest {

    public WebDriver driver;

    @BeforeMethod

    public void setDriver(){
        driver= new DriverFactory().initializeDriver();
    }

    @AfterMethod

    public void teardown(ITestResult result){

        String testCaseName = result.getMethod().getMethodName();
        File destFile = new File("screenshots"+ File.separator+ testCaseName + ".png");
        takeScreenShot(destFile);

        driver.quit();
    }

    public void takeScreenShot(File destFile){
        //Convert webdriver object to Takescreenshots (Casting process)
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        // Capture screenShot as a file
        File srcFile= takesScreenshot.getScreenshotAs(OutputType.FILE);
        // move the file to the destination lacation
        try {
            FileHandler.copy(srcFile,destFile);
            // creates an InputStream from the destFile to attach it to the Allure report
            InputStream is = new FileInputStream(destFile);
            Allure.addAttachment("screenshots",is);
        } catch (IOException e) {
            throw new RuntimeException("file not found");
        }
    }

    public void injectCookiesToBrowser(List<io.restassured.http.Cookie> restAssuredCookies){

       List<Cookie> seleniumCookies = CookiesUtils.convertRestAssuredClookiesToSeleniumCookies(restAssuredCookies);
        for (Cookie seleniumCookie :seleniumCookies) {
            driver.manage().addCookie(seleniumCookie);
        }
        }



    }

/*Using a base test class is a common practice in software testing, especially when working with test automation frameworks. The base test class serves as a foundation or a parent class for other test classes and provides shared functionality, setup, and teardown methods that can be inherited by the child test classes. Here are a few reasons why using a base test class can be beneficial:
Code Reusability: By placing common test setup and teardown logic in a base test class, you can avoid duplicating code across multiple test classes. This promotes code reusability and reduces maintenance efforts. For example, if all your test classes require a certain configuration or initialization steps, you can centralize those steps in the base test class.
Consistent Test Environment: The base test class allows you to define and enforce a consistent test environment. You can set up preconditions, such as database connections, API clients, or browser configurations, in the base class, ensuring that all test classes start with the same initial state. This helps in creating reliable and reproducible tests.
Shared Test Methods: The base test class can contain common utility methods or helper functions that are relevant to multiple test cases. These shared methods can be inherited and used by the child test classes, reducing code duplication and promoting maintainability.
Framework Hooks: Test automation frameworks often provide hooks or callback methods that are executed at specific points during the test execution lifecycle, such as before each test case or after all test cases. The base test class can define and implement these hooks, allowing you to perform actions like logging, reporting, or cleanup consistently across all tests.
Test Configuration: If your tests require configuration parameters or settings, the base test class can handle loading and providing those configurations to the child test classes. This ensures that all tests have access to the necessary configurations without duplicating the code to load them.
Using a base test class helps in structuring and organizing your tests, improving code maintainability, and promoting consistency across your test suite. It provides a foundation for common functionality and reduces the burden of repetitive code in individual test classes.*/






