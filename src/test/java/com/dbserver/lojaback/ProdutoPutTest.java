package com.dbserver.lojaback;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;

public class ProdutoPutTest extends BaseTest{

    @Test
    public void deveria_atualizar_informacoes() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("id", 1);
        request.put("nome", "Celular");
        request.put("precoUnitario", 2024);
        request.put("quantidade", 10);

        given().contentType(ContentType.JSON).body(request.toString()).when().log().all().put("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void nao_deveria_atualizar_informacoes_produto_nao_existe() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("id", Long.MAX_VALUE);
        request.put("nome", "Celular");
        request.put("precoUnitario", 2024);
        request.put("quantidade", 10);
        given().contentType(ContentType.JSON).body(request.toString()).when().log().all().put("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
    }

}
