package org.example;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    protected static RequestSpecification requestSpec;

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://serverest.dev";

        // Cria uma especificação reutilizável com boas práticas
        requestSpec = new RequestSpecBuilder()
                .setBaseUri(RestAssured.baseURI)
                .setContentType("application/json")
                .log(LogDetail.ALL) // Loga todos os detalhes (útil para debug)
                .build();

        // Define a especificação padrão para todos os testes
        RestAssured.requestSpecification = requestSpec;
    }
}
