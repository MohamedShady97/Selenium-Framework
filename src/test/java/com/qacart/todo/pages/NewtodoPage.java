package com.qacart.todo.pages;

import com.qacart.todo.base.BasePage;
import com.qacart.todo.config.EndPoint;
import com.qacart.todo.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewtodoPage extends BasePage {

    public NewtodoPage(WebDriver driver){
        super(driver);
    }

    private By newtodoInput= By.cssSelector("[data-testid=\"new-todo\"]");

    private WebElement getNewTodoElement(){
        return driver.findElement(newtodoInput);
    }

    private By createtodoButton= By.cssSelector("[data-testid=\"submit-newTask\"]");

    private WebElement getSubmitElement(){
        return driver.findElement(createtodoButton);
    }
    @Step
    public NewtodoPage addNewTodo(String newtodo){
        getNewTodoElement().sendKeys(newtodo);
        return this;
    }
    @Step
    public TodoPage submitNewTodo(){
        getSubmitElement().click();
        return new TodoPage(driver);
    }
    @Step
    public NewtodoPage load(){
        driver.get(ConfigUtils.getInstance().getBaseUrl()+ EndPoint.NEW_TODO_END_POINT);
        return this;
    }
}
