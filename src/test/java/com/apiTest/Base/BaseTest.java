package com.apiTest.Base;


import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
      //  RestAssured.port = 443;
    }
}