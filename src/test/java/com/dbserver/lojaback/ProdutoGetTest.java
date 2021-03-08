package com.dbserver.lojaback;

import com.dbserver.lojaback.models.Produto;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ProdutoGetTest extends BaseTest {

    @Test
    public void deve_listar_produtos(){

        Response resp = given().
                when().log().all().
                get("/produtos").
                then().log().all().
                assertThat().
                statusCode(HttpStatus.SC_OK).extract().response();

        List<Produto> listaProdutos = resp.jsonPath().getList("",Produto.class);

        Assert.assertEquals(listaProdutos.size(), 2);
        Assert.assertEquals(listaProdutos.get(0).getId(), Long.valueOf(1));
    }

    @Test
    public void deveria_pesquisar_produto_id_valido(){
        given().when().get("/produto/{id}", 1).then().log().all().assertThat().statusCode(HttpStatus.SC_OK).extract().response();

    }

    @Test
    public void deveria_pesquisar_produto_id_invalido(){
        Response resp = given().when().get("/produto/{id}", Long.MAX_VALUE).then().log().all().assertThat().statusCode(HttpStatus.SC_NOT_FOUND).extract().response();
        Assert.assertEquals(resp.getBody().asString(), "O produto informado não foi encontrado.");
    }





}

