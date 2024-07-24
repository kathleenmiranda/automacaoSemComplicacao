package PlataformaFilmes;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import maps.LoginMap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.LineSeparatorDetector;
import utils.RestUltils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlataformarFilmesTest {

    static String token;

    @BeforeAll
    public static void validarLoginMap(){
        RestUltils.setBaseURI("http://localhost:8080/");

        LoginMap.initLogin();

        Response response = RestUltils.post(LoginMap.getLogin(), ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
       LoginMap.token = response.jsonPath().get("token");
    }

    @Test
    public void validarLogin(){
        LoginMap.initLogin();
        Response response = RestUltils.post(LoginMap.getLogin(), ContentType.JSON, "auth");

        assertEquals(200, response.statusCode());
        token = response.jsonPath().get("token");
    }

    @Test
    public void validarLoginInvalido(){

        Response response = RestUltils.post(LoginMap.getLogin(), ContentType.JSON, "auth");
        assertEquals(400, response.statusCode());
    }

    @Test
    public void validarConsultaCategorias(){
        Map<String,String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " +token);

        Response response = RestUltils.getSemLog(headers, "categorias");

        assertEquals(200, response.statusCode());

        assertEquals("Terror", response.jsonPath().get("tipo[2]"));
        List<String> listTipo = response.jsonPath().getList("tipo");
        assertTrue(listTipo.contains("Terror"));
    }

    public static Stream<Arguments> loginSenhaUsuarios(){
        return Stream.of(
                Arguments.of("aluno@email.com", "123456"),
                Arguments.of("emailInvalido@teste.com", "1234567")
        );
    }






}
