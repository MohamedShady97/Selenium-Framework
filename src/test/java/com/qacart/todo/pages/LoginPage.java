package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.PropertiesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Properties;


public class LoginPage extends BasePage {


    public LoginPage(WebDriver driver){
        super(driver);
       // PageFactory.initElements(driver, this);
    }

    private By emailInput= By.cssSelector("[data-testid=\"email\"]");
    private WebElement getEmailElement(){
        return driver.findElement(emailInput);
    }

    private By passwordInput= By.id("password");
    private WebElement getpasswordElement(){
        return driver.findElement(passwordInput);
    }

    private By submitButton= By.cssSelector("[data-testid=\"submit\"]");
    @Step
    private WebElement getSubmitElement(){
        return driver.findElement(submitButton);
    }
    @Step
    private void enterEmail(String email){
        getEmailElement().sendKeys(email);
    }
    @Step
    private void enterPassword(String password){
        getpasswordElement().sendKeys(password);
    }
    @Step
    private void clickSubmit(){
        getSubmitElement().click();
    }
    @Step
    public TodoPage loginWithCredintials(String email,String password){
        enterEmail(email);
        enterPassword(password);
        clickSubmit();
        return new TodoPage(driver);
    }

    @Step
    // This Annotaion is used to mark a methode as a test step
    public LoginPage load() {

        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }



     /* protected WebElement getElement(By by){
        return driver.findElement(by);
    }

    protected  void fillInput (By vv,String gg){
        getElement(vv).sendKeys(gg);
        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("fff");
    }

    By emailInput= By.cssSelector("[data-testid=\"email\"]");*/

  /*  protected WebElement getElement(By by){
         return driver.findElement(by);
     }
*/

  /*  @FindBy(css = "[data-testid=\"email\"]")
    private WebElement emailInput;


    @FindBy(css = "[data-testid=\"password\"]")
    private WebElement passwordInput;

    @FindBy(css = "[data-testid=\"submit\"]")
    private WebElement submit;
*/

}

 /* protected WebElement getElement(By by){
        return driver.findElement(by);
    }

    protected  void fillInput (By vv,String gg){
        getElement(vv).sendKeys(gg);
        driver.findElement(By.cssSelector("[data-testid=\"email\"]")).sendKeys("fff");
    }

    By emailInput= By.cssSelector("[data-testid=\"email\"]");*/