package com.visa.eur.tests;

import com.visa.eur.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SampleVisaCardValidationTest {

    @BeforeAll
    public static void setUp() {
        baseURI = ConfigurationReader.getProperty("card.base.url");
    }

    /**
     * QUERY PARAMS:
     * type: visa
     * country: US
     *
     */

    /*
    Sample Response Body:
    {
    "pan": {
            "PrimaryAccountNumber": "1234123412341234";
            "CardHolderName": "Test Test",
            "AddressStreet": "123 Ben St",
            "AddressStreet2": "",
            "AddressStreet3": "",
            "City": "Austin",
            "State": "TX",
            "AddressPostalCode": "12345",
            "Country":"US",
            "Locale": "en",
            "Cvv2Value": "123",
            "ExpirationDate": "01/01",
            "isVIPReject": "N",
            "AddressVerified": "VERIFIED",
            "VTS_Enabled": "N",
            "Type": "VISA",
            "OFAC_Status": "",
            "DataRowID": "123456",
            "BIN": "123456",
            "Category": "Credit"
           {
    }

     */


    //Way-1 GET Request
    @DisplayName("Visa Card Test1")
    @Test
    public void getVisaCardTest1() {

        Response response = given().accept(ContentType.JSON)
                .and().queryParam("type", "visa")
                .and().queryParam("country", "US")
                .when().get("getCard");

        // response.prettyPrint();
    }


    //Way-2
    // GET Request
    //Validation: Status Code and Content Type
    @DisplayName("Visa Card Test2")
    @Test
    public void getVisaCardTest2() {

        given().accept(ContentType.JSON)
                .and().queryParam("type", "visa")
                .and().queryParam("country", "US")
                .when().get("getCard")
                .then()
                .assertThat().statusCode(200)
                .and().contentType(ContentType.JSON);
    }



        //Way-3
            //GET Request
            //Validation: Status Code and Content Type
            //Response Body Validation

    @DisplayName("Visa Card Test3")
    @Test
    public void getVisaCardTest3() {
        given().accept(ContentType.JSON)
                .and().queryParam("type", "visa")
                .and().queryParam("country", "US")
                .when().get("getCard")
                .then()
                .assertThat()
                .and().statusCode(200)
                .and().contentType(ContentType.JSON)
                .and().body(
                        "pan.CardHolderName", is("Test Test"),
                        "pan.Type", equalTo("VISA"), //or "pan.Type", is("VISA")
                        "pan.AddressPostalCode", is("12345")
                        );

    }

}
