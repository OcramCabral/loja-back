package com.dbserver.lojaback;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.dbserver.lojaback.models.Produto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProdutoGetTest {

    @Test
    public void deveListarProdutos(){

        Response resp = given().
                basePath(RestAssured.basePath).
                when().log().all().
                get("/produtos").
                then().log().all().
                assertThat().
                statusCode(HttpStatus.SC_OK).extract().response();

        List<Produto> listaProdutos = resp.jsonPath().getList("",Produto.class);

        Assert.assertEquals(listaProdutos.size(), 2);
    }

}

