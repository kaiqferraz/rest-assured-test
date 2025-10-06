package org.example;

import io.restassured.response.Response;
import org.example.model.UsuarioModel;
import org.junit.jupiter.api.*;
import java.util.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class Usuarios extends BaseTest {

        private static String usuarioId;

        @Test
        @Order(1)
        @DisplayName("Deve cadastrar um novo usuário com sucesso")
        public void deveCadastrarUsuarioComSucesso() {
                UsuarioModel usuario = new UsuarioModel(
                                "QA Teste",
                                "qa." + System.currentTimeMillis() + "@teste.com",
                                "123456",
                                "true");

                Response response = given()
                                .contentType("application/json")
                                .body(usuario)
                                .when()
                                .post("/usuarios");

                response.then()
                                .statusCode(201)
                                .body("message", equalTo("Cadastro realizado com sucesso"))
                                .log().all();

                usuarioId = response.jsonPath().getString("_id"); // <-- importante
        }

        @Test
        @Order(2)
        @DisplayName("Deve buscar o usuário pelo ID")
        public void deveBuscarUsuarioPorID() {
                given()
                                .when()
                                .get("/usuarios/" + usuarioId)
                                .then()
                                .statusCode(200)
                                .body("_id", equalTo(usuarioId));
        }

        @Test
        @Order(3)
        @DisplayName("Deve listar todos os usuários cadastrados")
        public void deveListarUsuarios() {
                Response response = given()
                                .when()
                                .get("/usuarios");

                response.then()
                                .statusCode(200)
                                .body("usuarios", notNullValue())
                                .log().ifValidationFails();

                System.out.println("Lista de usuários:");
                response.getBody().prettyPrint();
        }

        @Test
        @Order(4)
        @DisplayName("Deve editar o usuário com sucesso")
        public void deveEditarUsuario() {
                Map<String, Object> user = new HashMap<>();
                user.put("nome", "QA Teste Editado");
                user.put("email", "qa.editado" + System.currentTimeMillis() + "@teste.com");
                user.put("password", "654321");
                user.put("administrador", "true");

                given()
                                .body(user)
                                .when()
                                .put("/usuarios/" + usuarioId)
                                .then()
                                .statusCode(200)
                                .body("message", equalTo("Registro alterado com sucesso"));
        }

        @Test
        @Order(5)
        @DisplayName("Deve excluir o usuário com sucesso")
        public void deveExcluirUsuario() {
                given()
                                .when()
                                .delete("/usuarios/" + usuarioId)
                                .then()
                                .statusCode(200)
                                .body("message", equalTo("Registro excluído com sucesso"));
        }
}
