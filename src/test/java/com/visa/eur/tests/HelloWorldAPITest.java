package com.visa.eur.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("hello")
public class HelloWorldAPITest {

    /**

     - When user sends GET Request to :
     https://sandbox.api.service.nhs.uk/hello-world/hello/world

     - Then status code should be 200
     - And "Hello World!" message should be in the response

     */

    @DisplayName("Test1 Hello World API Test")

    @Test  //junit-jupiter.api

    public void HelloWorldTest() {

        String url = "https://sandbox.api.service.nhs.uk/hello-world/hello/world";

        //Short SOLUTION
        RestAssured.when().get(url).
                then().
                assertThat().statusCode(200).
                contentType(ContentType.JSON).
                body("message", is("Hello World!"));

        //ANOTHER SOLUTION

        //1- Send GET Request to Hello World API
        //RestAssured Library
        Response response = RestAssured.when().get(url);
        //Response -> interface

        //System.out.println(response); not printable.

        response.prettyPrint(); //to print the results out

        //2-Then response status code is 200
        //Assertion
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.contentType() = " + response.contentType());

        //junit -> assertEquals(expectedValue, actualValue)
        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertEquals("application/json; charset=UTF-8", response.contentType());

        //3-And response body contains "Hello World!"
        //response body validation
        //There are couples methods to do that. For now, We can use the String structure.
        // first convert it to String . response.asString();

        System.out.println("response.asString() = " + response.asString());

        Assertions.assertTrue(response.asString().contains("Hello World!"));

    }

}
