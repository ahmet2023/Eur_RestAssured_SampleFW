package com.visa.eur.tests;


import com.visa.eur.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TypeICodeTest {

    /**
     * Send request to url: https://jsonplaceholder.typicode.com/users
     * satus 200
     * Content-Type "application/json"
     *
     */

    @BeforeAll
    public static void setUp() {
        System.out.println("Setting up base Url ... ");
        baseURI = ConfigurationReader.getProperty("typeicode.url");
    }

    @DisplayName("All Users")
    @Test
    public void getAllUsers() {

        given().accept(ContentType.JSON)
                .when().get("users").prettyPeek()
                .then()
                .and().statusCode(200)
                .and().contentType(ContentType.JSON);


    }


    /*
      {
    "id": 1,
    "name": "Leanne Graham",
    "username": "Bret",
    "email": "Sincere@april.biz",
    "address": {
      "street": "Kulas Light",
      "suite": "Apt. 556",
      "city": "Gwenborough",
      "zipcode": "92998-3874",
      "geo": {
        "lat": "-37.3159",
        "lng": "81.1496"
      }
    },
    "phone": "1-770-736-8031 x56442",
    "website": "hildegard.org",
    "company": {
      "name": "Romaguera-Crona",
      "catchPhrase": "Multi-layered client-server neural-net",
      "bs": "harness real-time e-markets"
    }
  }
     */

    @DisplayName("Single User => /users/1")
    @Test
    public void getsingleUser() {

        given().accept(ContentType.JSON)
                .and().pathParam("id", 1)
                .when().get("users/{id}").prettyPeek()
                .then()
                .and().statusCode(200)
                .and().contentType(ContentType.JSON)
                .assertThat()
                .body(
                        "id", is(1),
                        "name", equalTo("Leanne Graham"),
                        "address.city", is("Gwenborough"),
                        "address.geo.lng", equalTo("81.1496")
                        );

    }
}
