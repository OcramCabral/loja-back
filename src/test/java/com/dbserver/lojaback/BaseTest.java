package com.dbserver.lojaback;


import io.restassured.RestAssured;
import org.testng.ITestListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

public class BaseTest{

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "http://localhost:8080/";
        RestAssured.basePath = "";
    }
}
