package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TodoPage extends BasePage {



    public TodoPage(WebDriver driver) {
        super(driver);
    }

    private By welcomeMassege = By.cssSelector("[data-testid=\"welcome\"]");

    private WebElement getWelcomeElement() {
        return driver.findElement(welcomeMassege);
    }
    @Step
    public boolean isWelcomeDisplayed() {
        return getWelcomeElement().isDisplayed();
    }

    private By addButton = By.cssSelector("[data-testid=\"add\"]");

    private WebElement getAddElement() {
        return driver.findElement(addButton);
    }
    @Step
    public NewtodoPage clickAdd() {
        getAddElement().click();
        return new NewtodoPage(driver);
    }

    private By todotext = By.cssSelector("[data-testid=\"todo-text\"]");

    private WebElement getTodoElement() {
        return driver.findElement(todotext);
    }
    @Step
    public String getTodoText(){
        return getTodoElement().getText();
    }

    private By deleteButton = By.cssSelector("[data-testid=\"delete\"]");
    private WebElement getDeleteElement(){
        return driver.findElement(deleteButton);

    }
    @Step
    public void clickDelete(){
        getDeleteElement().click();
    }
    @Step
    public TodoPage load(){
        // here we created endPoint to make url not hard coded
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.TODO_END_POINT);
        return this;
    }



}