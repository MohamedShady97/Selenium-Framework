package com.qacart.todo.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class DriverFactory {

    private WebDriver driver;

    public WebDriver initializeDriver(){

        String browser = System.getProperty("browser","CHROME");

        switch (browser) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "SAFARI":
                driver = new SafariDriver();
                break;
            default:
               throw  new RuntimeException("The browser is not supported");

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return  driver;

    }
}
/*

Here's an explanation of each part:
The DriverFactory class is declared as public, which means it can be accessed from other classes.
private WebDriver driver; declares a private instance variable called driver of type WebDriver.
public WebDriver initializeDriver() is a public method that initializes and configures the WebDriver instance.
        WebDriverManager.chromedriver().setup(); uses the WebDriverManager library to set up the ChromeDriver binary. It ensures that the required ChromeDriver executable is downloaded and set up for use.
        driver = new ChromeDriver(); creates a new instance of the ChromeDriver class and assigns it to the driver variable.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); sets the implicit wait time to 20 seconds. This means that if an element is not immediately found in the DOM, the driver will wait for up to 20 seconds before throwing a NoSuchElementException.
        driver.manage().window().maximize(); maximizes the browser window to its full size.
        return driver; returns the initialized WebDriver instance.
The purpose of this DriverFactory class is to provide a centralized location for initializing and configuring the WebDriver instance. By calling the initializeDriver() method, you get a fully configured WebDriver instance that you can use for automation tasks.*/
