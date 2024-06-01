package com.qacart.todo.testcases;

import com.qacart.todo.api.RegisterApi;
import com.qacart.todo.api.TaskApi;
import com.qacart.todo.base.BaseTest;
import com.qacart.todo.factory.DriverFactory;
import com.qacart.todo.pages.LoginPage;
import com.qacart.todo.pages.NewtodoPage;
import com.qacart.todo.pages.TodoPage;
import com.qacart.todo.utils.ConfigUtils;
import com.qacart.todo.utils.CookiesUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
@Feature("Todo Feature")
public class TodoTest extends BaseTest {

    @Story("add Todo")
    @Test(description = "Test the functionality to add Todo")

    public void shouldBeAbleToAddNewToDo(){

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        NewtodoPage newtodoPage = new NewtodoPage(driver);
        newtodoPage.load();
        injectCookiesToBrowser(registerApi.getCookies());

        String actualResult=newtodoPage.load()
                            .addNewTodo("Learn Selenium")
                            .submitNewTodo()
                            .getTodoText();
        Assert.assertEquals(actualResult,"Learn Selenium");
/*

        LoginPage loginPage= new LoginPage(driver);
        String actualResult=loginPage.load()
                .loginWithCredintials(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getpassword())
                .clickAdd()
                .addNewTodo("Learn Selenium")
                .submitNewTodo().getTodoText();
*/


    }

    @Story("Delete Todo")
    @Test(description = "Test the functionality to delete Todo")
    public void shouldBeAbleToDeleteToDo(){

        RegisterApi registerApi = new RegisterApi();
        registerApi.register();

        TaskApi taskApi = new TaskApi();
        taskApi.addTask(registerApi.getAccessToken());

        TodoPage todoPage = new TodoPage(driver);
        todoPage.load();

        injectCookiesToBrowser(registerApi.getCookies());

        todoPage.load().clickDelete();
        Assert.assertTrue(true,"No Available Todos");


        /*

        LoginPage loginPage= new LoginPage(driver);
        loginPage.load()
                .loginWithCredintials(ConfigUtils.getInstance().getEmail(), ConfigUtils.getInstance().getpassword())
                .clickAdd()
                .addNewTodo("Learn Selenium")
                .submitNewTodo()
                .clickDelete();

        Assert.assertTrue(true,"No Available Todos");
*/

    }
}
