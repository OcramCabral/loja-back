package com.dbserver.lojaback;

import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;

public class ProdutoPostTest {

    @Test
    public void deveria_cadastrar_um_novo_produto() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto XX");
        request.put("nome", "Celular");
        request.put("precoUnitario", 3699);
        request.put("quantidade", 15);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void nao_deveria_cadastrar_um_novo_produto_sem_nome() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("precoUnitario", 2699);
        request.put("quantidade", 15);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    //Problema permita cadastra de produto com nome vazio
    //Ver na regra de negocio!
    public void nao_deveria_cadastrar_um_novo_produto_nome_vazio() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("nome", " ");
        request.put("precoUnitario", 2699);
        request.put("quantidade", 15);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }


    @Test
    public void nao_deveria_cadastrar_um_novo_produto_descricao_menor_cinco() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto");
        request.put("nome", "Celular");
        request.put("precoUnitario", 2699);
        request.put("quantidade", 15);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void deveria_cadastrar_um_novo_produto_descricao_igual_cinco() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto ");
        request.put("nome", "Celular");
        request.put("precoUnitario", 2699);
        request.put("quantidade", 15);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void nao_deveria_cadastrar_um_novo_produto_descricao_igual_cinquenta() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Samsung Motorola Xiaomi Apple and Samsung Motorola");
        request.put("nome", "Celular");
        request.put("precoUnitario", 2699);
        request.put("quantidade", 15);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void nao_deveria_cadastrar_um_novo_produto_descricao_maior_cinquenta() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Samsung Motorola Xiaomi Apple and Samsung Motorola ");
        request.put("nome", "Celular");
        request.put("precoUnitario", 2699);
        request.put("quantidade", 15);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void nao_deveria_cadastrar_um_novo_produto_quantidade_menor_zero() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("nome", "Celular");
        request.put("precoUnitario", 15);
        request.put("quantidade", Integer.MIN_VALUE);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void nao_deveria_cadastrar_um_novo_produto_quantidade_igual_um() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("nome", "Celular");
        request.put("precoUnitario", 15);
        request.put("quantidade", 1);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void deveria_cadastrar_um_novo_produto_quantidade_igual_maior_Integer() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("nome", "Celular");
        request.put("precoUnitario", 15);
        request.put("quantidade", Integer.MAX_VALUE);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void nao_deveria_cadastrar_um_novo_produto_quantidade_maior_que_valor_maximo_inteiro() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("nome", "Celular");
        request.put("precoUnitario", 15);
        request.put("quantidade", Long.MAX_VALUE);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void nao_deveria_cadastrar_um_novo_produto_preco_unitario_menor_zero() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("nome", "Celular");
        request.put("precoUnitario", BigDecimal.valueOf(Long.MIN_VALUE));
        request.put("quantidade", 15);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void nao_deveria_cadastrar_um_novo_produto_preco_unitario_igual_zero() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("nome", "Celular");
        request.put("precoUnitario", BigDecimal.valueOf(0));
        request.put("quantidade", 15);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void deveria_cadastrar_um_novo_produto_preco_unitario_igual_maior_Long() throws JSONException {
        JSONObject request = new JSONObject();
        request.put("descricao", "Moto X");
        request.put("nome", "Celular");
        request.put("precoUnitario", BigDecimal.valueOf(Long.MAX_VALUE));
        request.put("quantidade", 15);
        given().contentType(ContentType.JSON).body(request.toString()).post("/produto").then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
    }



}
