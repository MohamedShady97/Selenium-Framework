package com.qacart.todo.api;

import com.qacart.todo.config.EndPoint;
import com.qacart.todo.objects.User;
import com.qacart.todo.utils.UserUtils;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class RegisterApi {

    private String accessToken;
    private String userId;
    private String firstName;
    private List<Cookie> cookies;

    public void register(){

        User user = new  UserUtils().generateRandomUser();

       // User user =new User("mo7mdshady31223@gmail.com","S@s01014295925","Mohamed","Shady");

        Response response=
                given()
                        .baseUri("https://qacart-todo.herokuapp.com")
                        .header("Content-Type","application/json")
                        .body(user)
                        .when()
                        .post(EndPoint.API_REGISTER_END_POINT)
                        .then()
                        .log().all().extract().response();

        if (response.statusCode() != 201)
            throw new RuntimeException("Something went wrong");

        cookies=response.detailedCookies().asList();
        accessToken= response.path("access_token");
        userId= response.path("userID");
        firstName=response.path("firstName");

    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Cookie> getCookies() {
        return cookies;
    }

    public void setCookies(List<Cookie> cookies) {

        this.cookies = cookies;
    }


}
