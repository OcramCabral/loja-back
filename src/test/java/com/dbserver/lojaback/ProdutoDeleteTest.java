package com.dbserver.lojaback;

import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ProdutoDeleteTest {

    @Test
    public void deveria_excluir_produto_existente(){
        given().when().delete("/produto/{id}", 21).then().log().all().assertThat().statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void nao_deveria_excluir_produto_nao_existente(){
        given().when().delete("/produto/{id}", 21).then().log().all().assertThat().statusCode(HttpStatus.SC_NOT_FOUND);
    }



}
