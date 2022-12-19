package com.visa.eur.tests;

import com.visa.eur.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;

public class ZipCodesAPITest {
    
    /**    TEST CASE
     * 
     Given accept type is json
     and country path param value is "us"
     and postal code path param value is 78729
     When I send get request to http://api.zippopotam.us/{country}/{postal-code}
     Then status code is 200
     Then "post code" is "78729"
     And  "country" is "United States"
     And "place name" is "Austin"
     And  "state" is "Texas"
     */

    @BeforeAll
    public static void setUp() {
        System.out.println("Setting up base Url ... ");
        baseURI = ConfigurationReader.getProperty("zipcode.api.url");
    }

    @DisplayName("GET us/zipCode - jsonPath")
    @Test
    public void zipCodeJsonPathTest() {
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("country","us")
                .and().pathParam("postal-code", "78729")
                .when().get("/{country}/{postal-code}");
        response.prettyPrint();

        assertEquals(200, response.statusCode());

        //assign response json payload/body to Jsonpath
        JsonPath jsonPath = response.jsonPath();
        verifyZipCode(jsonPath, "78729");
        //navigate the json and print/assert country value
        System.out.println("country name = " + jsonPath.getString("country"));
        assertEquals("United States" , jsonPath.getString("country"));

        //navigate the json and print/assert post code value
        System.out.println("post code = " + jsonPath.getString("'post code'"));
        String zipCode = jsonPath.getString("'post code'");
        assertEquals("78729", zipCode);

        //verify place name
        System.out.println("place name = " + jsonPath.getString("places[0].'place name'"));
        assertEquals("Austin" , jsonPath.getString("places[0].'place name'"));

        //verify state is "Texas"
        String state = jsonPath.getString("places[0].state");
        System.out.println("state = " + state);
        assertEquals("Texas", state);
    }

    public void verifyZipCode(JsonPath jsonPath, String expZipCode) {
        assertEquals(expZipCode, jsonPath.getString("'post code'"));
    }

}
