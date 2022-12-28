package com.visa.eur.tests;


import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;


/**  TEST CASE
 *
 * When User sends GET Request to
 * https://reqres.in/api/users
 *
 * Then Response status code should be 200
 * And Response body should contain "George"
 * And Header Content type should be json
 */


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@Tag("reqAPI")
public class ReqResAPITest {

    String url = "https://reqres.in/api/users";
    //String url = ConfigurationReader.getProperty("reqres.api");

    @DisplayName("GET all users")
    @Order(2)
    @Test
    public void usersGetTest() {
        //When User sends GET Request
        Response response = when().get(url);
        //Response response = RestAssured.get(url); both same. first one more readable

        //Then Response status code should be 200
        System.out.println("status code = " + response.statusCode());
        assertEquals(200, response.statusCode());

        //BDD syntax
        response.then().statusCode(200);
        response.then().assertThat().statusCode(200);

        //And Response body should contain "George"
        System.out.println("Response json body = " + response.asString());
        assertTrue(response.asString().contains("George"));

        //And Header Content type should be application/json
        System.out.println("Content type header value = " + response.contentType());
        assertTrue(response.contentType().contains("application/json"));
    }

//    When User Sends get request to API Endpoint:
//            "https://reqres.in/api/users/5"
//    Then Response status code should be 200
//    And Response body should contain user info "Charles"

    @DisplayName("GET single user")
    @Order(1)
    @Test
    public void getSingleUserApiTest() {
        Response response = when().get(url + "/5");

        System.out.println("status code = " + response.statusCode());
        assertEquals(200 , response.statusCode());

        //And Response body should contain user info "Charles"
        response.prettyPrint();
        assertTrue(response.asString().contains("Charles"));
    }


//    When Send get request to API Endpoint:
//            "https://reqres.in/api/users/50"
//    Then Response status code should be 404
//    And Response body should contain "{}"

    @DisplayName("GET request to non existing user")
    @Order(3)
    @Test
    public void getSingleUserNegativeApiTest() {
        Response response = when().get(url + "/50");

        System.out.println("Status code = " + response.statusCode());
        assertEquals(404, response.statusCode());

        System.out.println("Json body = " + response.asString());
        assertEquals("{}" , response.asString());

    }

}
