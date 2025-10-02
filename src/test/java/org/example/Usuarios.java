package org.example;

import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Usuarios extends BaseTest {

    private static String usuarioId;

    @Test
    @Order(1)
    public void cadastrarUsuario() {
        String userJson = "{"
                + "\"nome\": \"QA Teste\","
                + "\"email\": \"kaique.teste" + System.currentTimeMillis() + "@gmail.com\","
                + "\"password\": \"123456\","
                + "\"administrador\": \"true\""
                + "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userJson)
                .when()
                .post("/usuarios");

        response.then()
                .statusCode(201)
                .body("message", equalTo("Cadastro realizado com sucesso"));

        // Capturar o ID do usuário criado
        usuarioId = response.jsonPath().getString("_id");
        System.out.println("Usuário cadastrado com ID: " + usuarioId);
    }

    @Test
    @Order(2)
    public void buscarUsuarioPorID() {
        Response response = given().when().get("/usuarios/" + usuarioId);
        response.then().statusCode(200);
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    @Order(3)
    public void listarUsuariosCadastrados() {
        Response response = given().when().get("/usuarios");
        response.then().statusCode(200);
        System.out.println(response.getBody().prettyPrint());
    }

    @Test
    @Order(4)
    public void editarUsuario() {
        String userJson = "{"
                + "\"nome\": \"QA Teste EDITADO\","
                + "\"email\": \"kaique.010255" + System.currentTimeMillis() + "@teste.com\","
                + "\"password\": \"654321\","
                + "\"administrador\": \"true\""
                + "}";

        Response response = given()
                .header("Content-Type", "application/json")
                .body(userJson)
                .when()
                .put("/usuarios/" + usuarioId);

        response.then()
                .statusCode(200)
                .body("message", equalTo("Registro alterado com sucesso"));
        System.out.println("Usuário com ID: " + usuarioId + " alterado com sucesso");
    }

    @Test
    @Order(5)
    public void excluirUsuario() {
        Response response = given().when().delete("/usuarios/" + usuarioId);
        response.then().statusCode(200);
        System.out.println(response.getBody().prettyPrint());
    }
}
