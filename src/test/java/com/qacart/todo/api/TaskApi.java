package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.Task;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TaskApi {



    public void addTask(String token){
        Task task = new Task(false,"Learn Selenium");
        Response response =
        given().baseUri("https://qacart-todo.herokuapp.com")
                .header("Content-Type","application/json")
                .auth().oauth2(token)
                .body(task)
        .when()
                .post(EndPoint.API_TASK_ENDPIONT)
        .then()
                .log().all().extract().response();

        if (response.statusCode()!= 201)
            throw new RuntimeException("Something is wrong");

    }

}
